package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.driver.DriverService;

public class TakeScreenshotHelper {

    public static void takeScreenshot(String path, String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverService.getInstance().getDriver();
        if(!FileHelper.fileExists(path)) {
            FileHelper.createDir(path);
        }
        FileHelper.createFile(takesScreenshot.getScreenshotAs(OutputType.FILE), path, String.format("%s.png",name));
    }
}
