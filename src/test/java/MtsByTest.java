import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class MtsByTest {
    public static WebDriver driver;
    private static int cookieCount=0;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }

    // Проверка названия блока
    @Test(priority=1, description = "Проверка названия блока")
    public void blockTitle() {
        WebElement blockTitle = driver.findElement(xpath("//*[contains(text(), 'Онлайн пополнение')]"));

        assertAll(
                () -> assertTrue(blockTitle.getText().contains("Онлайн пополнение")),
                () -> assertTrue(blockTitle.getText().contains("без комиссии"))
        );
        //Assert.assertTrue(blockTitle.getText().contains("Онлайн пополнение"));
        //Assert.assertTrue(blockTitle.getText().contains("без комиссии"));
    }

    // Проверка наличия логотипов платежных систем
    @Test(priority=2, description = "Проверка наличия логотипов платежных систем")
    public void logoPresenceCheck() {
        WebElement logos = driver.findElement(xpath("//div[@class='pay__partners']"));
        Assert.assertTrue(logos.isDisplayed(), "Логотипы платежных систем не найдены.");
    }

    // Проверка работы ссылки "Подробнее о сервисе"
    @Test(priority=3, description = "Проверка работы ссылки 'Подробнее о сервисе'")
    public void detailsLink() {
        cookiePopUp.cookieAgree(driver); //соглашаемся на куки
        WebElement moreInfoButton = driver.findElement(xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a"));
        Assert.assertTrue(moreInfoButton.getAttribute("href").contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Страница 'Подробнее о сервисе' НЕ открывается корректно.");
    }

    // Заполнение полей и проверка работы кнопки "Продолжить"
    @Test(priority=4, description = "Заполнение полей и проверка работы кнопки 'Продолжить'")
    public void checkSubmitButton() {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone")); //заполняем номер телефона
        phoneNumberField.click();
        phoneNumberField.sendKeys("297777777");

        WebElement moneyField = driver.findElement(By.id("connection-sum")); //заполняем сумму пополнеия
        moneyField.click();
        moneyField.sendKeys("499");

        WebElement emailField = driver.findElement(By.id("connection-email")); //заполняем имейл
        emailField.click();
        emailField.sendKeys("test@test.com");

        driver.findElement(xpath("//*[@id='pay-connection']/button")).click(); //нажимаем кнопку Продолжить

        // если отображается фрейм для ввода данных карты, то кнопка работает корректно
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))).isDisplayed(), "Кнопка 'Продолжить' функционирует НЕкорректно.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}