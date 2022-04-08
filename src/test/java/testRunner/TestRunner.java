package testRunner;

import io.cucumber.testng.*;
import org.testng.annotations.*;
import utils.*;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterMethod
    public void closeAllBrowserWindows() {
        InitializeWebDriver initializeWebDriver = new InitializeWebDriver();
        initializeWebDriver.closeAllBrowserWindows();
    }
}
