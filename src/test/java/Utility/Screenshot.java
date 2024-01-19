package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public String captureScreenShot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot scrshot = (TakesScreenshot) driver;

		File source = scrshot.getScreenshotAs(OutputType.FILE);



		String path = System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png";

		File destination = new File(path);

		FileHandler.copy(source, destination);
		
		return path ;
		
	}

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://paytm.com/recharge");

		TakesScreenshot scrshot = (TakesScreenshot) driver;

		File source = scrshot.getScreenshotAs(OutputType.FILE);

		String path = "F:\\Desktop\\Katraj\\20 Aug Katraj\\Selenium\\paytm.png";

		File destination = new File(path);

		FileHandler.copy(source, destination);

	}

}
