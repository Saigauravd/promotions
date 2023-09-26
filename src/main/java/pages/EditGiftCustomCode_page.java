package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditGiftCustomCode_page {
	WebDriver driver;
	
	@FindBy(xpath = "(//*[@data-clickable='Edit'])[1]")
	WebElement editbutton;
	
	@FindBy(xpath = "//label[@for='Unlimited']")
	WebElement Unlimited;
	
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement update;
	
	
	public EditGiftCustomCode_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Editing_coupon()
	{
		editbutton.click();
		Unlimited.click();
		update.click();
	}

}
