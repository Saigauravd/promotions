package extentlisteners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import Test.BaseFile;


public class TestNGListeners extends BaseFile   implements ITestListener {

	public ExtentReports extent = ExtentReportGen.extentReportGenerator();
	
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started : "+ result.getName());
		
		 test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed : "+ result.getName());
		
		test.log(Status.PASS, "Test case passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
System.out.println("Test case failed : "+ result.getName());

		test.fail(result.getThrowable());
		 if (driver instanceof TakesScreenshot) {
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String screenshotPath = "screenshots/" +  result.getName() + ".png"; // Customize the path as needed
	            try {
	                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	                System.out.println("Screenshot captured: " + screenshotPath);
	            }
		 catch (IOException e) {
	                e.printStackTrace();
		 }}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped : "+ result.getName());	
		
		test.log(Status.SKIP, "Test case got skipped");
	}

	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test tag started : "+ context.getName());	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test tag finished : "+ context.getName());
		
		extent.flush();
	}
	
	

}
