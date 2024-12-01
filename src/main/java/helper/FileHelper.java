package helper;

import org.openqa.selenium.io.FileHandler;
import utils.logger.LogController;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    protected static LogController LOGGER = new LogController(FileHelper.class);

    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static void createFile(File srcFile, String dirPath, String name) {
        File destFile = new File(String.format("%s/%s", dirPath, name));
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            LOGGER.info("Error while saving screenshot: " + e.getMessage());
        }
    }

    public static void createDir(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
