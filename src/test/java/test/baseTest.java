package test;

import helper.TakeScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.TestReports;
import utils.config.Config;
import utils.driver.DriverFactory;
import utils.logger.LogController;

import java.lang.reflect.Method;

public class baseTest {

    protected String baseUrl = "https://automationexercise.com/";
    protected LogController LOGGER = new LogController(baseTest.class);
    protected TestReports reports = null;
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        // Inicialización del reporte HTML
        reports = TestReports.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Código para inicializar recursos necesarios para los logs
        Config.getInstance().getConfig();
        String runId = String.format("%s:%s", method.getName(), System.currentTimeMillis());
        LOGGER.info(String.format("Setting runId to %s", runId));
        System.setProperty("runId", runId);
        reports.configReport(method.getName());

        this.writeLogs("1. Launch browser");
        driver = DriverFactory.getInstance().CreateDriver();
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void writeLogs(String log) {
        LOGGER.info(log);
        reports.infoStep(log);
    }

    @AfterMethod(alwaysRun = true)
    public void close(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String path = "screenshots";
            String fileName = result.getName() + ".png";
            TakeScreenshotHelper.takeScreenshot(driver, path, fileName);
            reports.failStepAddScreenCapture("Test failed at step: " + result.getName(),path + "/" + fileName);
            reports.failStep(result.getThrowable().toString());
        } else {
            reports.passStep("The test " +result.getName() + " is successful");
        }

        if(driver != null) {
            driver.close();
        }
        reports.flush();
    }

}
