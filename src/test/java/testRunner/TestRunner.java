package testRunner;

import io.cucumber.testng.*;
import org.testng.annotations.*;
import utils.*;


//@CucumberOptions(
//        features = {"src/test/java/features/"},
//        glue = {"stepDefinitions"},
//        monochrome = true
//)

@CucumberOptions(
        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        tags = "@highpriority or @mediumpriority",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
