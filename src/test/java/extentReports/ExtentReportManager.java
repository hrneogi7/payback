package extentReports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static final String fileSeparator = System.getProperty("file.separator");
    private static final String reportFolderPath = System.getProperty("user.dir") + fileSeparator + "TestReport";
    private static final String reportFileName = "Test-Automaton-Report.html";
    private static final String reportFilePath = reportFolderPath + fileSeparator + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static void createInstance() {
        String fileName = getReportPath();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("AUT", "QA");

    }

    //Create the report path
    private static String getReportPath() {
        File testDirectory = new File(reportFolderPath);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                return reportFilePath;
            } else {
                return System.getProperty("user.dir");
            }
        }
        return reportFilePath;
    }
}
