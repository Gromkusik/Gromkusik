import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageInternet {
    WebDriver driver;
    By Phone = By.xpath("//*[@id='internet-phone']");
    By Sum = By.id("internet-sum");
    By Email = By.id("internet-email");
    By Button = By.xpath("//form[@id='pay-internet']//button");

    //конструктор
    public PageInternet(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения плейсхолдера поля телефона
    public String getPhonePlaceholder() {
        return driver.findElement(Phone).getAttribute("placeholder");
    }

    //метод получения плейсхолдера поля суммы
    public String getSumPlaceholder() {
        return driver.findElement(Sum).getAttribute("placeholder");
    }

    //метод получения плейсхолдера поля имейла
    public String getEmailPlaceholder() {
        return driver.findElement(Email).getAttribute("placeholder");
    }

    //метод ввода номера телефона
    public void enterPhone (String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(Phone));
        driver.findElement(Phone).click();
        driver.findElement(Phone).sendKeys(phoneNumber);
    }

    //метод ввода суммы
    public void enterSum (String sum) {
        driver.findElement(Sum).click();
        driver.findElement(Sum).sendKeys(sum);
    }

    //метод ввода имейла
    public void enterEmail (String email) {
        driver.findElement(Email).click();
        driver.findElement(Email).sendKeys(email);
    }

    //метод нажатия кнопки 'Продолжить'
    public void clickButton() {
        driver.findElement(Button).click();
    }
}