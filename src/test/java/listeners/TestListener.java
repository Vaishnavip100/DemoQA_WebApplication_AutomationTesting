package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import base.BaseTest;
import com.aventstack.extentreports.*;
import utils.ExtentManager;

public class TestListener extends BaseTest implements ITestListener {

    ExtentReports extent=ExtentManager.getReport();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	test.get().fail("Test Failed");

        String testName = result.getName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File dir = new File("screenshots");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dest = new File(dir, testName + "_" + timestamp + ".png");
        try {
            FileUtils.copyFile(src, dest);
            test.get().addScreenCaptureFromPath(dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}