package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotHelper {

    public static void takeScreenshot(WebDriver driver, String path, String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        if(!FileHelper.fileExists(path)) {
            FileHelper.createDir(path);
        }
        FileHelper.createFile(takesScreenshot.getScreenshotAs(OutputType.FILE), path, name);
    }
}
