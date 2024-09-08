import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageConnection {
    WebDriver driver;
    By phone = By.id("connection-phone");
    By sum = By.id("connection-sum");
    By email = By.id("connection-email");
    By button = By.xpath("//form[@id='pay-connection']//button");

    //конструктор
    public PageConnection(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения плейсхолдера поля телефона
    public String getPhonePlaceholder() {
        return driver.findElement(phone).getAttribute("placeholder");
    }

    //метод получения плейсхолдера поля суммы
    public String getSumPlaceholder() {
        return driver.findElement(sum).getAttribute("placeholder");
    }

    //метод получения плейсхолдера поля имейла
    public String getEmailPlaceholder() {
        return driver.findElement(email).getAttribute("placeholder");
    }

    //метод ввода номера телефона
    public void enterPhone (String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(phone));
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(phoneNumber);
    }

    //метод ввода суммы
    public void enterSum (String sum) {
        driver.findElement(this.sum).click();
        driver.findElement(this.sum).sendKeys(sum);
    }

    //метод ввода имейла
    public void enterEmail (String email) {
        driver.findElement(this.email).click();
        driver.findElement(this.email).sendKeys(email);
    }

    //метод нажатия кнопки 'Продолжить'
    public void clickButton() {
        driver.findElement(button).click();
    }
}