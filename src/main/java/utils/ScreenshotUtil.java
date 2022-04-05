package utils;

import org.openqa.selenium.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class ScreenshotUtil {
    public static String takeScreenshot() {
        TakesScreenshot ss = (TakesScreenshot) InitializeWebDriver.webDriver;
        File screenshot = ss.getScreenshotAs(OutputType.FILE);
        String filePath = getFilePath();
        File destinationFile = new File(filePath);
        try {
            Files.copy(screenshot.toPath(), destinationFile.toPath());
            return filePath;
        } catch (Exception e) {
            System.out.println("Error saving screenshot!");
            return filePath;
        }
    }

    private static String getFilePath() {
        final String fileSeparator = System.getProperty("file.separator");
        final String folderPath = System.getProperty("user.dir") + fileSeparator + "TestReport" + fileSeparator + "Screenshots";
        final String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss"));
        final String fileName = "TestSS_" + timeStamp + ".png";
        final String filePath = folderPath + fileSeparator + fileName;

        File ssDirectory = new File(folderPath);
        if (!ssDirectory.exists()) {
            if (ssDirectory.mkdir()) {
                return filePath;
            }
        }
        return filePath;
    }
}
