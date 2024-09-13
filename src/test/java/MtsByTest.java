import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MtsByTest {
    WebDriver driver;
    LeftSideBlock leftSideBlock;
    PageConnection pageConnection;
    PageInternet pageInternet;
    PageInstalment pageInstalment;
    PageArrear pageArrear;
    PageForm pageForm;
    String sum = "499.99";
    String tel = "297777777";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        leftSideBlock = new LeftSideBlock(driver);
        pageConnection = new PageConnection(driver);
        pageInternet = new PageInternet(driver);
        pageInstalment = new PageInstalment(driver);
        pageArrear = new PageArrear(driver);
        cookiePopUp.cookieAgree(driver);
    }

    // Проверка названия блока
    @Test(priority=1, description = "Проверка названия блока")
    public void blockTitleCheck() {
        assertAll(
                () -> assertTrue(leftSideBlock.blockTitle().contains("Онлайн пополнение")),
                () -> assertTrue(leftSideBlock.blockTitle().contains("без комиссии"), "Заголовок найден: '" + leftSideBlock.blockTitle() + "'"));
    }

    // Проверка наличия логотипов платежных систем
    @Test(priority=2, description = "Проверка наличия логотипов платежных систем")
    public void logoPresenceCheck() {
        assertTrue(leftSideBlock.logosPresent(), "Лого платежных систем присутствуют.");
    }

    // Проверка работы ссылки "Подробнее о сервисе"
    @Test(priority=3, description = "Проверка работы ссылки 'Подробнее о сервисе'")
    public void detailsLinkCheck() {
        assertTrue(leftSideBlock.detailsLinkPresent(), "Ссылка 'Подробнее о сервисе' работает корректно.");
    }

    // Заполнение полей и проверка работы кнопки "Продолжить"
    @Test(priority=4, description = "Заполнение полей и проверка работы кнопки 'Продолжить'")
    public void checkSubmitButton() {
        pageConnection.enterPhone(tel);
        pageConnection.enterSum(sum);
        pageConnection.enterEmail("test@test.com");
        pageConnection.clickButton();

        // Если отображается фрейм для ввода данных карты, то кнопка работает корректно
        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))).isDisplayed(), "Кнопка 'Продолжить' функционирует корректно.");
    }

    // Проверка плейсхолдеров формы
    @Test(priority=5, description = "Проверка плейсхолдеров формы")
    public void placeholdersCheck() {
        assertAll(
                () -> assertEquals(pageConnection.getPhonePlaceholder(), "Номер телефона"),
                () -> assertEquals(pageConnection.getSumPlaceholder(), "Сумма"),
                () -> assertEquals(pageConnection.getEmailPlaceholder(), "E-mail для отправки чека"),

                () -> assertEquals(pageInternet.getPhonePlaceholder(), "Номер абонента"),
                () -> assertEquals(pageInternet.getSumPlaceholder(), "Сумма"),
                () -> assertEquals(pageInternet.getEmailPlaceholder(), "E-mail для отправки чека"),

                () -> assertEquals(pageInstalment.getNumberPlaceholder(), "Номер счета на 44"),
                () -> assertEquals(pageInstalment.getSumPlaceholder(), "Сумма"),
                () -> assertEquals(pageInstalment.getEmailPlaceholder(), "E-mail для отправки чека"),

                () -> assertEquals(pageArrear.getNumberPlaceholder(), "Номер счета на 2073"),
                () -> assertEquals(pageArrear.getSumPlaceholder(), "Сумма"),
                () -> assertEquals(pageArrear.getEmailPlaceholder(), "E-mail для отправки чека"));
    }

    // Проверка отображения формы оплаты
    @Test(priority=6, description = "Проверка отображения формы оплаты")
    public void paymentFormCheck() {
        pageForm = new PageForm(driver); //инициализируем экземпляр здесь, чтобы фрейм успел подгрузиться

        //проверка плейсхолдеров на форме
        assertAll(
                () -> assertEquals(pageForm.getCardPlaceholder(), "Номер карты"),
                () -> assertEquals(pageForm.getExpPlaceholder(), "Срок действия"),
                () -> assertEquals(pageForm.getCvcPlaceholder(), "CVC"),
                () -> assertEquals(pageForm.getHolderPlaceholder(), "Имя держателя (как на карте)"),

        //проверка суммы и номера телефона на форме
                () -> assertTrue(pageForm.getHeaderSum().contains(sum)),
                () -> assertTrue(pageForm.getButtonSum().contains(sum)),
                () -> assertTrue(pageForm.getPhone().contains(tel)),

        //проверка логотипов платежных систем на форме
                () -> assertTrue(pageForm.getLogos()));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}