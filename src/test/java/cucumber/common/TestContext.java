package cucumber.common;

import org.openqa.selenium.WebDriver;
import utils.config.Config;
import utils.driver.DriverFactory;

public class TestContext {

    private WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            System.out.println("Initializing WebDriver...");
            Config.getInstance().getConfig();
            driver = DriverFactory.getInstance().CreateDriver();
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            System.out.println("Quitting WebDriver...");
            driver.quit();
            driver = null;
        }
    }
}
