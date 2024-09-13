package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageForm {
    WebDriver driver;
    By card = By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']");
    By exp = By.xpath("//div[@class='content ng-tns-c46-4']//label");
    By cvc = By.xpath("//div[@class='content ng-tns-c46-5']//label");
    By holder = By.xpath("//div[@class='content ng-tns-c46-3']//label");
    By sumHeader = By.xpath("//div[@class='pay-description__cost']/span");
    By sumButton = By.xpath("//div[@class='card-page__card']/button");
    By phone = By.xpath("//div[@class='pay-description__text']/span");
    By logos = By.xpath("//div[@class='cards-brands ng-tns-c46-1']//img");
    WebElement frameForm;

    //конструктор
    public PageForm(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))).isDisplayed();
        frameForm = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //метод получения плейсхолдера поля Номер карты
    public String getCardPlaceholder() { return driver.switchTo().frame(frameForm).findElement(card).getAttribute("innerText"); }

    //метод получения плейсхолдера поля Срок действия
    public String getExpPlaceholder() {
        return driver.findElement(exp).getAttribute("innerText");
    }

    //метод получения плейсхолдера поля CVC
    public String getCvcPlaceholder() {
        return driver.findElement(cvc).getAttribute("innerText");
    }

    //метод получения плейсхолдера поля Имя держателя
    public String getHolderPlaceholder() {
        return driver.findElement(holder).getAttribute("innerText");
    }

    //метод получения суммы в хедере формы
    public String getHeaderSum() {
        return driver.findElement(sumHeader).getAttribute("innerText");
    }

    //метод получения суммы на кнопке Оплатить
    public String getButtonSum() {
        return driver.findElement(sumButton).getAttribute("innerText");
    }

    //метод получения номера телефона
    public String getPhone() {
        return driver.findElement(phone).getAttribute("innerText");
    }

    //метод определения отображения лого платежных систем
    public boolean getLogos() {
        boolean flag = false;
        int countOfDisplayedLogos = 0;

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logos));
        for (int i=0; i<driver.findElements(logos).size(); i++) {
            if (driver.findElements(logos).get(i).isDisplayed())
                countOfDisplayedLogos++;
        }
        if (countOfDisplayedLogos >=4) flag = true;
        return flag;
    }
}