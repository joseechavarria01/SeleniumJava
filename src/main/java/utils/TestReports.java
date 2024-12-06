package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReports {
    private static TestReports instance = null;
    private static ExtentReports extent;
    private ExtentTest extentTest;

    private TestReports() {
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

    public void configReport(String method) {
        // Inicialización del reporte HTML
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(TestConstant.REPORT_PATH);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extentTest = extent.createTest(method);
    }

    public void infoStep(String step) {
        this.extentTest.info(step);
    }

    public void failStep(String step) {
        this.extentTest.fail(step);
    }

    public void passStep(String step) {
        this.extentTest.pass(step);
    }

    public void failStepAddScreenCapture(String step,String path) {
        this.extentTest.fail(step).addScreenCaptureFromPath(path);
    }

    public void flush() {
        extent.flush();
    }
}
