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
        Assert.assertTrue(leftSideBlock.blockTitle().contains("Онлайн пополнение"));
        System.out.println("1) Заголовок найден: '" + leftSideBlock.blockTitle() + "\'.");
    }

    // Проверка наличия логотипов платежных систем
    @Test(priority=2, description = "Проверка наличия логотипов платежных систем")
    public void logoPresenceCheck() {
        Assert.assertTrue(leftSideBlock.logosPresent());
        System.out.println("2) Лого платежных систем присутствуют.");
    }

    // Проверка работы ссылки "Подробнее о сервисе"
    @Test(priority=3, description = "Проверка работы ссылки 'Подробнее о сервисе'")
    public void detailsLinkCheck() {
        Assert.assertTrue(leftSideBlock.detailsLinkPresent());
        System.out.println("3) Ссылка 'Подробнее о сервисе' работает корректно.");
    }

    // Заполнение полей и проверка работы кнопки "Продолжить"
    @Test(priority=4, description = "Заполнение полей и проверка работы кнопки 'Продолжить'")
    public void checkSubmitButton() {
        pageConnection.enterPhone(tel);
        pageConnection.enterSum(sum);
        pageConnection.enterEmail("test@test.com");
        pageConnection.clickButton();

        // Если отображается фрейм для ввода данных карты, то кнопка работает корректно
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))).isDisplayed());
        System.out.println("4) Кнопка 'Продолжить' функционирует корректно.");
    }

    // Проверка плейсхолдеров формы
    @Test(priority=5, description = "Проверка плейсхолдеров формы")
    public void placeholdersCheck() {
        Assert.assertEquals(pageConnection.getPhonePlaceholder(), "Номер телефона");
        Assert.assertEquals(pageConnection.getSumPlaceholder(), "Сумма");
        Assert.assertEquals(pageConnection.getEmailPlaceholder(), "E-mail для отправки чека");
        System.out.println("5.1) Плейсхолдеры отображаются корректно для формы 'Услуги связи'");

        Assert.assertEquals(pageInternet.getPhonePlaceholder(), "Номер абонента");
        Assert.assertEquals(pageInternet.getSumPlaceholder(), "Сумма");
        Assert.assertEquals(pageInternet.getEmailPlaceholder(), "E-mail для отправки чека");
        System.out.println("5.2) Плейсхолдеры отображаются корректно для формы 'Интернет'");

        Assert.assertEquals(pageInstalment.getNumberPlaceholder(), "Номер счета на 44");
        Assert.assertEquals(pageInstalment.getSumPlaceholder(), "Сумма");
        Assert.assertEquals(pageInstalment.getEmailPlaceholder(), "E-mail для отправки чека");
        System.out.println("5.3) Плейсхолдеры отображаются корректно для формы 'Рассрочка'");

        Assert.assertEquals(pageArrear.getNumberPlaceholder(), "Номер счета на 2073");
        Assert.assertEquals(pageArrear.getSumPlaceholder(), "Сумма");
        Assert.assertEquals(pageArrear.getEmailPlaceholder(), "E-mail для отправки чека");
        System.out.println("5.4) Плейсхолдеры отображаются корректно для формы 'Задолженность'");
    }

    // Проверка отображения формы оплаты
    @Test(priority=6, description = "Проверка отображения формы оплаты")
    public void paymentFormCheck() {
        pageForm = new PageForm(driver); //инициализируем экземпляр здесь, чтобы фрейм успел подгрузиться

        //проверка плейсхолдеров на форме
        Assert.assertEquals(pageForm.getCardPlaceholder(), "Номер карты");
        Assert.assertEquals(pageForm.getExpPlaceholder(), "Срок действия");
        Assert.assertEquals(pageForm.getCvcPlaceholder(), "CVC");
        Assert.assertEquals(pageForm.getHolderPlaceholder(), "Имя держателя (как на карте)");

        //проверка суммы и номера телефона на форме
        Assert.assertTrue(pageForm.getHeaderSum().contains(sum));
        Assert.assertTrue(pageForm.getButtonSum().contains(sum));
        Assert.assertTrue(pageForm.getPhone().contains(tel));

        //проверка логотипов платежных систем на форме
        Assert.assertTrue(pageForm.getLogos());
        System.out.println("6) Плейсхолдеры, сумма (" + sum + "), телефон (" + tel + ") и лого платежных систем на форме оплаты отображаются корректно.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}