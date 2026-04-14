package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getReport() {
        if (extent==null) {
        	File dir=new File("reports");
        	if (!dir.exists()) {
        	    dir.mkdirs();
        	}
        	ExtentSparkReporter reporter=new ExtentSparkReporter("reports/ExtentReport.html");
            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent=new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}