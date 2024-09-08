import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cookiePopUp {
    private static int cookieCount=0; //счетчик принятия куки, нет необходимости их ждать и принимать второй раз

    public static void cookieAgree(WebDriver driver) {
        if (cookieCount==0) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='cookie-agree']"))).click();
                System.out.println("(Куки приняты)");
                Thread.sleep(Duration.ofSeconds(2));
                cookieCount++;
            } catch (TimeoutException | InterruptedException e) {
                System.out.println("(Запроса на куки не было)");
            } catch (ElementClickInterceptedException e) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn_gray cookie__cancel']"))).click();
            }
        }
    }
}