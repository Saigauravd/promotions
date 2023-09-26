package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	

	private WebDriver driver;


@FindBy(xpath = ("//*[@id='username']"))

WebElement username ;

 @FindBy(xpath = ("//*[@id='password']"))
	WebElement pass;
 
 @FindBy(xpath = ("//*[@class='phone-number']"))
	WebElement  productButton;
 
 @FindBy(xpath = ("//a[normalize-space()='Promotions']"))
	WebElement PromotionsM;
 
 @FindBy(xpath = ("//div[@title='My Promotion']"))
	WebElement PromotionsSwitch;
 

 @FindBy(xpath = ("//*[@class='btn btn-primary px-2']"))
	WebElement PromotionsSelect;
 
 
	public Login_Page (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	

	public void credentialsuser(String use)
	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		Actions act = new Actions(driver);
		username.sendKeys(use);

		act.sendKeys(Keys.ENTER).build().perform();
	}





	public void credentialspass(String pas) {




	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions act = new Actions(driver);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		pass.sendKeys(pas);

		act.sendKeys(Keys.ENTER).build().perform();

	}

	public void SwitchPromotions() throws InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		
		productButton.click();
		
Thread.sleep(1000);
		PromotionsM.click();
		PromotionsSwitch.click();
		
		PromotionsSelect.click();
	}

}
