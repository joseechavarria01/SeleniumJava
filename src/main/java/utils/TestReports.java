/**
 * @author Jose Francisco Echavarria
 */
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helper.DriverHelper;
import helper.TakeScreenshotHelper;
import utils.config.Config;
import utils.driver.DTO.ScreenshotsDTO;
import utils.logger.LogController;

public class TestReports {
    private final LogController LOGGER = new LogController(TestReports.class);
    private static TestReports instance = null;
    private ScreenshotsDTO screenshots;
    private ExtentReports extent;
    private ExtentTest extentTest;

    private TestReports() {
        screenshots = Config.getInstance().getConfig().getScreenshots();
    }

    public static TestReports getInstance() {
        if (instance == null) {
            synchronized (TestReports.class) {
                if (instance == null) {
                    instance = new TestReports();
                }
            }
        }
        return instance;
    }

    public void configReport() {
        // Inicialización del reporte HTML
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(TestConstant.REPORT_PATH);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void createTest(String method) {
        extentTest = extent.createTest(method);
    }

    public void infoStep(String step) {

        this.LOGGER.info(step);
        if(screenshots.getEnabled() && DriverHelper.driverIsCreated()) {
            String fileName = String.format("%s", System.currentTimeMillis());
            TakeScreenshotHelper.takeScreenshot(screenshots.getPath(), fileName);
            this.extentTest.addScreenCaptureFromPath(String.format("/%s/%s.png", screenshots.getPath(),fileName), step);
        } else {
            this.extentTest.info(step);
        }
    }

    public void failStep(String step) {
        this.extentTest.fail(step);
        this.LOGGER.error(step);
    }

    public void passStep(String step) {
        this.extentTest.pass(step);
        this.LOGGER.info(step);
    }

    public void failStepAddScreenCapture(String step,String name) {
        String path = screenshots.getPath();
        this.LOGGER.error(step);
        TakeScreenshotHelper.takeScreenshot(path, name);
        this.extentTest.addScreenCaptureFromPath(String.format("/%s/%s.png", path, name), step);
    }

    public void flush() {
        extent.flush();
    }
}
