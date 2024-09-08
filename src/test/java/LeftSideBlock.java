import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftSideBlock {
    WebDriver driver;
    By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    By logos = By.xpath("//div[@class='pay__partners']");
    By detailsLink = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");

    //конструктор
    public LeftSideBlock(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения заголовка блока
    public String blockTitle () {
        return driver.findElement(blockTitle).getText();
    }

    //метод поиска лого
    public boolean logosPresent () {
        return driver.findElement(logos).isDisplayed();
    }

    //метод получения ссылки "Подробнее о сервисе"
    public boolean detailsLinkPresent () {
        return driver.findElement(detailsLink).getAttribute("href").contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }
}