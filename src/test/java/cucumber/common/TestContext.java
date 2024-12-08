package cucumber.common;

import org.openqa.selenium.WebDriver;
import utils.TestReports;
import utils.config.Config;
import utils.driver.DriverFactory;
import utils.driver.DriverService;

public class TestContext {
    private  TestReports  reports = TestReports.getInstance();
    private Config config =  Config.getInstance();
    protected DriverService driverService = DriverService.getInstance();
    private WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            reports.infoStep("Initializing WebDriver...");
            config.getConfig();
            config.sepRunId("");
            driverService.createDriver();
            driver = driverService.getDriver();
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            reports.infoStep("Quitting WebDriver...");
            driver.quit();
            driver = null;
        }
    }

    public TestReports report() {
        return reports;
    }

    public void configReport() {
        reports.configReport();
    }

    public void createTest(String nameMethod) {
        reports.createTest(nameMethod);
    }
}
