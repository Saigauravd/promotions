package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AddCoupon_page  {

	WebDriver driver ;

	@FindBy(xpath = "//span[normalize-space()='General']")
	WebElement GeneralSetting;


	@FindBy(xpath = "//a[normalize-space()='Coupons']")
	WebElement CouponM;

	@FindBy(xpath = "//*[@onclick='openCreate()']")
	WebElement AddB;

	@FindBy(xpath = "//input[@id='nameCreate']")
	WebElement Name;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement Desc;

	@FindBy(xpath = "//*[@for='gift']")
	WebElement GCategory;
	@FindBy(xpath = "//*[@for='discount']")
	WebElement DCategory;

	@FindBy(xpath = "//*[@id='discountTypeCreate']")
	WebElement SelectdiscountCategory;

	@FindBy(xpath= "//*[@id='amountDiscountCreate']")
	WebElement Damount;

	@FindBy(xpath= "//*[@id='percentageCreate']")
	WebElement Dpercentage;


	@FindBy(xpath= "//*[@id='amountLimit']")
	WebElement amountLimit;

	@FindBy(xpath= "//*[@id='unitTypeCreate']")
	WebElement selectunittype;

	@FindBy(xpath= "//*[@id='unitValueCreate']")
	WebElement unitvalue;

	@FindBy(xpath= "//*[@id='otherUniteType']")
	WebElement otherunittype;

	@FindBy(xpath= "//*[@id='otherUnitValue']")
	WebElement otherunitvalue;

	@FindBy(xpath= "//*[@id='amountGiftCreate']")
	WebElement amount;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement StartDate;

	@FindBy(xpath = "//input[@id='endDate']")
	WebElement ExpirationDate;

	@FindBy(xpath = "(//*[@class='custom-control-label switch-label'])[2]")
	WebElement Advancebotton;


	@FindBy(xpath = "//input[@id='customCodeCreate']")
	WebElement CustomCodetab;

	@FindBy(xpath = "//*[@id='redemptionLimitCreate']")
	WebElement redemptionTab;

	@FindBy(xpath = "(//*[@class='custom-control-label switch-label'])[1]")
	WebElement Unlimited;



	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save;

	@FindBy(xpath = "//select[@id='charsetCreate']")
	WebElement SelectCharset;

	@FindBy(xpath = "//input[@id='prefixCreate']")
	WebElement prefix;

	@FindBy(xpath = "//input[@id='suffixCreate']")
	WebElement suffix;

	@FindBy(xpath = "//input[@id='codeLengthCreate']")
	WebElement code_length;

	@FindBy(xpath = "//*[@onclick='getAllCoupons()']")
	WebElement refresh;

	public AddCoupon_page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1));
	public void Add_Coupon_with_Gift_and_Custom_Code(String GName, String GDesc) throws InterruptedException 
	{

		GeneralSetting.click();
		CouponM.click();
		//wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
	AddB.click();
		Name.sendKeys( GName);
		Desc.sendKeys( GDesc);
		GCategory.click();

		amount.sendKeys("21");
		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		redemptionTab.sendKeys("1");
		Advancebotton.click();
		Thread.sleep(3000);
		Select ccharset = new Select(SelectCharset);
		ccharset.selectByValue("custom");


		CustomCodetab.sendKeys("Saigaurav");
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();


		String expectedCouponName = "Coupon with Gift and Custom Code";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Coupon with Gift and Custom Code']")).getText();
		Assert.assertEquals( expectedCouponName, actualCouponName);

	}
	public void Add_Coupon_with_gift_and_systemGenerated_code(String GName, String GDesc) throws InterruptedException  {
		//	Random rad = new Random();
		//	int num = 234;
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys(GName);
		Desc.sendKeys(GDesc);
		GCategory.click();
		//		SelCat.selectByValue("gift");
		amount.sendKeys("21");
		StartDate.sendKeys("22122023");
		ExpirationDate.sendKeys("28122023");
		Unlimited.click();
		Advancebotton.click();
		Thread.sleep(3000);
		Select ccharset = new Select(SelectCharset);
		ccharset.selectByValue("Number");
		//		ccharset.selectByValue("AlphaNumeric");
		//		ccharset.selectByValue("custom");
		//		ccharset.selectByValue("Alphabet");
		Select Listof = new Select(SelectCharset);
		List<WebElement> E = Listof.getOptions();
		for(WebElement Print : E) {
			System.out.println(Print.getText());

		}
		prefix.sendKeys("AA");
		suffix.sendKeys("ZZ");
		code_length.sendKeys("8");
		Thread.sleep(2000);
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Coupon with Gift and systemGenerated code";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Coupon with Gift and systemGenerated code']")).getText();
		Assert.assertEquals( expectedCouponName, actualCouponName);
	}

	public void Add_Coupon_Discount_Amount_with_additional_Setting(String DaName, String DaDesc) throws InterruptedException 
	{
		//wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys(DaName);
		Desc.sendKeys(DaDesc);
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("amount");
		Damount.sendKeys("25");
		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		redemptionTab.sendKeys("1");
		Advancebotton.click();
		Thread.sleep(3000);
		Select ccharset = new Select(SelectCharset);
		ccharset.selectByValue("AlphaNumeric");
		prefix.sendKeys("AA");
		suffix.sendKeys("ZZ");
		code_length.sendKeys("8");
		Thread.sleep(2000);
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Disc Amt With Adv Setting";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc Amt With Adv Setting']")).getText();
		Assert.assertEquals(expectedCouponName, actualCouponName);
	}

	public void Add_Coupon_Dicount_amt_without_Adv(String DaName, String DaDesc)  
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys("Coupon with Disc without adv");
		Desc.sendKeys("Is this is Description tab?");
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("amount");
		Damount.sendKeys("21");
		StartDate.sendKeys("22122023");
		ExpirationDate.sendKeys("28122023");
		Unlimited.click();
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Coupon with Disc without adv";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Coupon with Disc without adv']")).getText();
		Assert.assertEquals(expectedCouponName, actualCouponName);
	}
	public void Add_Coupon_Disount_percentage_with_adv(String DpName, String DpDesc) throws InterruptedException  {
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
	Name.sendKeys(DpName);
		Desc.sendKeys(DpDesc);
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("percentage");
		Dpercentage.sendKeys("25");

		amountLimit.sendKeys("30");
		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		redemptionTab.sendKeys("1");
		Advancebotton.click();
		Thread.sleep(3000);
		Select ccharset = new Select(SelectCharset);
		ccharset.selectByValue("AlphaNumeric");
		prefix.sendKeys("AA");
		suffix.sendKeys("ZZ");
		code_length.sendKeys("8");
		Thread.sleep(2000);
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Disc pert With Adv Setting";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc pert With Adv Setting']")).getText();
		Assert.assertEquals( expectedCouponName, actualCouponName);
	}

	public void Add_Coupon_Discount_percentage_without_adv(String DpName, String DpDesc)  
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys(DpName);
		Desc.sendKeys(DpDesc);
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("percentage");
		Dpercentage.sendKeys("25");
		amountLimit.sendKeys("30");
		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		Unlimited.click();
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Disc pert Without Adv Setting";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc pert Without Adv Setting']")).getText();
		Assert.assertEquals("Coupon name doesn't match", expectedCouponName, actualCouponName);
	}
	public void Add_coupon_Discount_unit_with_adv(String DuName, String DuDesc)  {
		try {
		//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
			AddB.click();
			Name.sendKeys(DuName);
			Desc.sendKeys(DuDesc);
			DCategory.click();
			Select cate = new Select(SelectdiscountCategory);
			cate.selectByValue("units");
			Thread.sleep(3000);
			Select type = new Select(selectunittype);
			type.selectByValue("miles");
			unitvalue.sendKeys("34");

			StartDate.sendKeys("18122023");
			ExpirationDate.sendKeys("28122023");	
			redemptionTab.sendKeys("1");
			Advancebotton.click();
			Thread.sleep(3000);
			Select ccharset = new Select(SelectCharset);
			ccharset.selectByValue("Alphabet");
			prefix.sendKeys("AA");
			suffix.sendKeys("ZZ");
			code_length.sendKeys("8");
			Thread.sleep(2000);
			Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
			Save.click();
			refresh.click();
			String expectedCouponName = "Disc unit With Adv Setting";
			String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc unit With Adv Setting]")).getText();
			Assert.assertEquals( expectedCouponName, actualCouponName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Add_Coupon_Discount_unit_without_adv(String DuName, String DuDesc) 
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys(DuName);
		Desc.sendKeys(DuDesc);
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("units");
		Select type = new Select(selectunittype);
		type.selectByValue("miles");
		unitvalue.sendKeys("34");

		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		redemptionTab.sendKeys("1");
		Unlimited.click();
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Disc  unit Without Adv Setting";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc  unit Without Adv Setting']")).getText();
		Assert.assertEquals( expectedCouponName, actualCouponName);
	}
	public void Add_Coupon_Discount_other_with_Adv(String DoName, String DoDesc) throws InterruptedException  
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(AddB)).click();
		AddB.click();
		Name.sendKeys(DoName);
		Desc.sendKeys(DoDesc);
		DCategory.click();
		Select cate = new Select(SelectdiscountCategory);
		cate.selectByValue("units");
		Select type = new Select(selectunittype);
		type.selectByValue("others");
		otherunittype.sendKeys("KM");
		otherunitvalue.sendKeys("21");
		redemptionTab.sendKeys("1");
		StartDate.sendKeys("18122023");
		ExpirationDate.sendKeys("28122023");	
		Advancebotton.click();
		Thread.sleep(3000);
		Select ccharset = new Select(SelectCharset);
		ccharset.selectByValue("Alphabet");
		prefix.sendKeys("AA");
		suffix.sendKeys("ZZ");
		code_length.sendKeys("8");
		Thread.sleep(2000);
		Assert.assertTrue(Save.isDisplayed(), "Save button is not displayed" );
		Save.click();
		refresh.click();
		String expectedCouponName = "Disc  other Without Adv Setting";
		String actualCouponName = driver.findElement(By.xpath("//*[text()='Disc  other Without Adv Setting']")).getText();
		Assert.assertEquals( expectedCouponName, actualCouponName);
	}


	

}
