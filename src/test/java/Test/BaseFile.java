package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Utility.proper;
import pages.AddCoupon_page;
import pages.DeleteCoupon_Page;
import pages.EditGiftCustomCode_page;
import pages.Login_Page;



public class BaseFile{
	public  static WebDriver driver;
	Login_Page login;
  public AddCoupon_page Addc;
  public EditGiftCustomCode_page editgift;
  public DeleteCoupon_Page delete;
	@BeforeSuite
	public void init() throws InterruptedException, IOException

	{

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get(proper.prop("Url"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		

	}

	@BeforeClass
	public void Obj()
	{
		login= new Login_Page(driver);
	Addc = new AddCoupon_page(driver);
	editgift = new EditGiftCustomCode_page(driver);
	delete = new DeleteCoupon_Page(driver);
	}
	
	@BeforeClass
	public  void log() throws Throwable 
	{login.credentialsuser(proper.prop("user"));
	login.credentialspass(proper.prop("pass"));
	login.SwitchPromotions();
		
	}
	@AfterClass
public void End () {
	driver.quit();
}
	
	
	
	public String  excel(int row, int colomn) throws IOException
	{
		String path = System.getProperty("user.dir")+".//Excel.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = book.getSheet("Coupons");
		
		DataFormatter df =new  DataFormatter();
	String value = df.formatCellValue(sheet1.getRow(row).getCell(colomn));
	

    return value;
	}
	}
