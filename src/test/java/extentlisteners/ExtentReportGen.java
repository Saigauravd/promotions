package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportGen {
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator()
	{
		
		String filename = "Promotions"+ ".html";
		String path = System.getProperty("user.dir")+"//report//"+filename;
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setTheme(Theme.DARK);
		
		reporter.config().setReportName("Promotions");
				
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Application Name", "Growith");
		
		extent.setSystemInfo("Environment", "QA");
		
		extent.setSystemInfo("Executed by", "Saigaurav Dambhe");
		
		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
		
		
	}

}
