package testRunner;

import io.cucumber.testng.*;
import org.testng.annotations.*;
import utils.*;

@CucumberOptions(
        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        tags = "@lowpriority",
        monochrome = true
)
public class TestRunner2 extends AbstractTestNGCucumberTests {

}