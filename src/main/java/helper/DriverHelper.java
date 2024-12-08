package helper;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.driver.DriverService;

public class DriverHelper {

    public static boolean driverIsCreated() {
        try{
            WebDriver driver = DriverService.getInstance().getDriver();

            return  driver != null && ((RemoteWebDriver)driver).getSessionId() != null;
        }catch (NoSuchDriverException | NoSuchSessionException | TimeoutException exception) {
            return false;
        }
    }
}
