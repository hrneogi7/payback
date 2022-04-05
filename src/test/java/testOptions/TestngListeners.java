package testOptions;

import com.aventstack.extentreports.*;
import extentReports.*;
import org.testng.*;
import utils.*;

import java.io.File;

public class TestngListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("HOORRAAYYY! :D");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("SAAADDD :(");
        try {
            String filePath = ScreenshotUtil.takeScreenshot();
            ExtentTestManager.getTest().fail(
                    "Error Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(filePath).build()
            );
            System.out.println("Error Screenshot saved at " + filePath);
        } catch (Exception e) {
            System.out.println("Screenshot not found!");
        }
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
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
