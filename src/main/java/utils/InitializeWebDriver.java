package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InitializeWebDriver {
    public static WebDriver webDriver;
    public Properties properties;

    public void initializeWebDriver()throws IOException {
        properties= new Properties();
        FileInputStream fis=new FileInputStream("src/main/java/utils/data.properties");

        properties.load(fis);
        String browserName=properties.getProperty("browser");

        if(browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\HNEOGI\\OneDrive - Capgemini\\Documents\\L1 Training\\Drivers_cge\\msedgedriver.exe");
            webDriver = new EdgeDriver();
        }
        else if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HNEOGI\\OneDrive - Capgemini\\Documents\\L1 Training\\Drivers_cge\\chromedriver.exe");
            webDriver= new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\HNEOGI\\OneDrive - Capgemini\\Documents\\L1 Training\\Drivers_cge\\geckodriver.exe");
            webDriver= new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
    }

    public void closeAllBrowserWindows() {

        webDriver.quit();
    }
}
