package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helper.TakeScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.config.Config;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.DriverFactory;
import utils.driver.DriverWrapper;
import utils.logger.LogController;

import java.lang.reflect.Method;

public class baseTest {


    protected String baseUrl = "https://automationexercise.com/";
    protected SeleniumConfig seleniumConfig = Config.getInstance().getConfig("config.json");
    protected DriverWrapper driverWrapper;
    protected LogController LOGGER = new LogController(baseTest.class);
    protected static ExtentReports extent;
    protected ExtentTest test;
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        // Inicialización del reporte HTML
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Código para inicializar recursos necesarios para los logs
        String runId = String.format("%s:%s", method.getName(), System.currentTimeMillis());
        LOGGER.info(String.format("Setting runId to %s", runId));
        System.setProperty("runId", runId);
        LOGGER.info("Se registra y obtine el driverWrapper desde DriverFactory");
        driverWrapper = DriverFactory.getInstance()
                .registerDriver(seleniumConfig.getBrowser())
                .getValue(); // Obtiene el wrapper del drive

        LOGGER.info("Se Inicializa el driver");
        driverWrapper.createDriver();
        test = extent.createTest(method.getName());

        this.writeLogs("1. Launch browser");
        driver = (WebDriver) driverWrapper.getDriver();
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void writeLogs(String log) {
        LOGGER.info(log);
        test.info(log);
    }

    @AfterMethod(alwaysRun = true)
    public void close(ITestResult result, ITestContext testContext) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String path = "screenshots";
            String fileName = result.getName() + ".png";
            testContext.getFailedTests();
            TakeScreenshotHelper.takeScreenshot(driver, path, fileName);
            test.fail("Test failed at step: " + result.getName()).addScreenCaptureFromPath(path + "/" + fileName);
            test.fail(result.getThrowable());
        } else {
            test.pass("The test " +result.getName() + " is successful");
        }

        if(driver != null) {
            driver.close();
        }

        extent.flush();
    }

    @AfterSuite
    public void tearDown() {
    }

}
