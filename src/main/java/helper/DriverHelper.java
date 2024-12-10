package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.DriverService;

import java.time.Duration;

public class DriverHelper {

    public static boolean driverIsCreated() {
        try{
            WebDriver driver = DriverService.getInstance().getDriver();

            return  driver != null && ((RemoteWebDriver)driver).getSessionId() != null;
        }catch (NoSuchDriverException | NoSuchSessionException | TimeoutException exception) {
            return false;
        }
    }

    public static  void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
