package test;

import helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.TestConstant;
import utils.TestReports;
import utils.config.Config;
import utils.driver.DriverService;
import utils.logger.LogController;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class baseTest {

    private Config config =  Config.getInstance();
    protected String baseUrl = TestConstant.URL;
    protected LogController LOGGER = new LogController(baseTest.class);
    protected TestReports reports = TestReports.getInstance();;
    protected DriverService driverService = DriverService.getInstance();
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        // Inicialización del reporte HTML
        reports.configReport();
    }

    @BeforeMethod
    public void setUp(Method method) {

        config.getConfig();
        // Código para inicializar recursos necesarios para los logs
        config.sepRunId(method.getName());
        reports.createTest(method.getName());

        reports.infoStep("1. Launch browser");
        driverService.createDriver();
        driver = driverService.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(TestConstant.TIMEOUT_IN_SECOND));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void close(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            reports.failStepAddScreenCapture("Test failed at step: " + result.getName(),result.getName());
            reports.failStep(result.getThrowable().toString());
        } else {
            reports.passStep("The test " +result.getName() + " is successful");
        }
        driverService.quit();
        reports.flush();
    }

}
