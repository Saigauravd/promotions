package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditGiftCustomCode_page {
	WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='General']")
	WebElement GeneralSetting;


	@FindBy(xpath = "//a[normalize-space()='Coupons']")
	WebElement CouponM;

	@FindBy(xpath = "(//*[@rv-on-click='rv.openEdit'])[2]")
	WebElement editbutton;
	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement Desc;

	@FindBy(xpath = "(//*[@class='custom-control-label switch-label'])[1]")
	WebElement Unlimited;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement update;


	public EditGiftCustomCode_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Editing_coupon() throws InterruptedException {
		StringBuilder updatedata = new StringBuilder();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	//	wait.until(ExpectedConditions.elementToBeClickable(
				//GeneralSetting.click();
		GeneralSetting.click();
		CouponM.click();
	///	wait.until(ExpectedConditions.elementToBeClickable(
		editbutton.click();


		
		// Append the text from the textarea and mark it as edited
		updatedata.append("--Edited");
		Desc.sendKeys(updatedata);
		Unlimited.click();


		String expectedresult = "Is this is Description tab?--Edited";
		String actualresult = Desc.getAttribute("value");
		//
		Assert.assertEquals(actualresult, expectedresult, "Description is not edited");
		update.click();
	}

}
