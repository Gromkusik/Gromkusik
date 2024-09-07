import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageForm {
    WebDriver driver;
    By card = By.xpath("//div[@class='app-input ng-tns-c46-1 with-error']");
    By exp = By.xpath("//input[@formcontrolname='expirationDate']");
    By cvc = By.xpath("//input[@formcontrolname='cvc']");
    By holder = By.xpath("//input[@formcontrolname='holder']");
    By sumHeader = By.xpath("//div[@class='pay-description__cost']");
    By sumButton = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    By phone = By.xpath("//div[@class='pay-description__text']");
    By logos = By.xpath("//div[@class='cards-brands ng-tns-c46-1']//img");

    //конструктор
    public PageForm(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения плейсхолдера поля Номер карты
    public String getCardPlaceholder() { return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(card)).getText(); }

    //метод получения плейсхолдера поля Срок действия
    public String getExpPlaceholder() {
        return driver.findElement(exp).getText();
    }

    //метод получения плейсхолдера поля CVC
    public String getCvcPlaceholder() {
        return driver.findElement(cvc).getText();
    }

    //метод получения плейсхолдера поля Имя держателя
    public String getHolderPlaceholder() {
        return driver.findElement(holder).getText();
    }

    //метод получения суммы в хедере формы
    public String getHeaderSum() {
        return driver.findElement(sumHeader).getText();
    }

    //метод получения суммы на кнопке Оплатить
    public String getButtonSum() {
        return driver.findElement(sumButton).getText();
    }

    //метод получения номера телефона
    public String getPhone() {
        return driver.findElement(phone).getText();
    }

    //метод определения отображения лого платежных систем
    public boolean getLogos() {
        boolean flag = false;
        int countOfDisplayedLogos = 0;
        for (int i=0; i<driver.findElements(logos).size(); i++) {
            if (driver.findElements(logos).get(i).isDisplayed())
                countOfDisplayedLogos++;
        }
        if (countOfDisplayedLogos >=4) flag = true;
        return flag;
    }
}