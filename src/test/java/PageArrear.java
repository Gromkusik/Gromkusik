import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageArrear {
    WebDriver driver;
    By Number = By.xpath("//*[@id='score-arrears']");
    By Sum = By.id("arrears-sum");
    By Email = By.id("arrears-email");
    By Button = By.xpath("//form[@id='pay-arrears']//button");

    //конструктор
    public PageArrear(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения плейсхолдера поля телефона
    public String getNumberPlaceholder() {
        return driver.findElement(Number).getAttribute("placeholder");
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
    public void enterPhone (String number) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(Number));
        driver.findElement(Number).click();
        driver.findElement(Number).sendKeys(number);
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