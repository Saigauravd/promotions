package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCoupon_page {
	
	WebDriver driver ;
	
	@FindBy(xpath = "//span[normalize-space()='General']")
	WebElement GeneralSetting;
	
	
	@FindBy(xpath = "//a[normalize-space()='Coupons']")
	WebElement CouponM;
	
	@FindBy(xpath = "//*[@src='https://venus-scocu-assets.s3.amazonaws.com/3829490578289078']")
	WebElement AddB;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement Name;
	
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement Desc;
	
	@FindBy(xpath = "//select[@id='category']")
	WebElement SelectCategory;
	
	@FindBy(xpath = "//input[@id='start-date']")
	WebElement StartDate;
	
	@FindBy(xpath = "//input[@id='expiration-date']")
	WebElement ExpirationDate;
	
	@FindBy(xpath = "//label[@for='Advanced_coupon_settings']")
	WebElement Advancebotton;
	
	@FindBy(xpath = "//label[@for='Custom_Code']")
	WebElement CustomCodetoggle;
	
	@FindBy(xpath = "//input[@id='is_custom']")
	WebElement CustomCodetab;
	
	@FindBy(xpath = "//input[@id='redemption_limit']")
	WebElement redemptionTab;
	
	@FindBy(xpath = "//label[@for='Unlimited']")
	WebElement Unlimited;
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement Giftamount;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save;
	
	@FindBy(xpath = "//select[@id='charsetTypeselect']")
	WebElement SelectCharset;
	
	@FindBy(xpath = "//input[@id='prefix']")
	WebElement prefix;
	
	@FindBy(xpath = "//input[@id='suffix']")
	WebElement suffix;
	
	@FindBy(xpath = "//input[@id='code_length']")
	WebElement code_length;
	
	public AddCoupon_page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Add_Coupon_with_Gift_and_Custom_Code() throws Throwable
	{
		
		GeneralSetting.click();
		CouponM.click();
		Thread.sleep(10000);
		AddB.click();
		Name.sendKeys("Coupon with Gift and Custom Code");
		Desc.sendKeys("Is this is Description tab?");
		Select SelCat = new Select(SelectCategory);
		SelCat.selectByValue("gift");
		Giftamount.sendKeys("21");
//		StartDate.sendKeys("28092023");
//		ExpirationDate.sendKeys("30102023");
//		
		Advancebotton.click();
		Thread.sleep(3000);
		CustomCodetoggle.click();
		
		CustomCodetab.sendKeys("Saigaurav");
		redemptionTab.sendKeys("1");
		Save.click();
		
	}
	public void Add_Coupon_with_gift_and_systemGenerated_code() throws Throwable {
		
		Thread.sleep(10000);
		AddB.click();
		Name.sendKeys("Coupon with Gift and systemGenerated code");
		Desc.sendKeys("Is this is Description tab?");
		Select SelCat = new Select(SelectCategory);
		SelCat.selectByValue("gift");
		Giftamount.sendKeys("21");
//		StartDate.sendKeys("28092023");
//		ExpirationDate.sendKeys("30102023");
//		
		Advancebotton.click();
		redemptionTab.sendKeys("1");
		Select Selchar = new Select(SelectCharset);
		Selchar.selectByValue("Number");
		prefix.sendKeys("AA");
		suffix.sendKeys("ZZ");
		code_length.sendKeys("8");
		Save.click();
	}
}
