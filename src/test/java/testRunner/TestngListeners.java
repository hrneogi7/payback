package testRunner;

import com.aventstack.extentreports.*;
import extentReports.*;
import org.testng.*;
import utils.*;

public class TestngListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("SCENARIO PASSED :D");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + InitializeWebDriver.getCurrentScenario());
        ExtentTestManager.getTest().log(Status.PASS, "Scenario Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("SCENARIO FAILED :(");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + InitializeWebDriver.getCurrentScenario());
        ExtentTestManager.getTest().log(Status.FAIL, "Scenario Failed");
        try {
            String ssPath = ScreenshotUtil.getLastScreenshotFilename();
            ExtentTestManager.getTest().log(
                    Status.FAIL,
                    "Screenshot of the failed scenario",
                    MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error while taking/saving screenshot!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SCENARIO SKIPPED :|");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + InitializeWebDriver.getCurrentScenario());
        ExtentTestManager.getTest().log(Status.SKIP, "Scenario Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentReportManager.getInstance().flush();
    }
}