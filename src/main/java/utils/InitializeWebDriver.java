package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class InitializeWebDriver {
    public static WebDriver webDriver;

    public static void initializeWebDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\HNEOGI\\OneDrive - Capgemini\\Documents\\L1 Training\\Drivers_cge\\msedgedriver.exe");
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
    }

    public static void closeAllBrowserWindows() {
        webDriver.quit();
    }
}
