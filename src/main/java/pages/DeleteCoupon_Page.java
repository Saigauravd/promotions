package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCoupon_Page {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='General']")
    WebElement GeneralSetting;

    @FindBy(xpath = "//a[normalize-space()='Coupons']")
    WebElement CouponM;

    public DeleteCoupon_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void delete() throws InterruptedException {
        GeneralSetting.click();
        CouponM.click();
        Thread.sleep(3000);

        for (int i = 1; i <= 9; i++) {
        	  try {
                  WebElement deleteButton = driver.findElement(By.xpath("(//*[@rv-on-click='rv.openDelete'])[" + i + "]"));
                  deleteButton.click();
              } catch (StaleElementReferenceException e) {
                  // Element might have become stale, re-locate and click again
                  WebElement deleteButton = driver.findElement(By.xpath("(//*[@rv-on-click='rv.openDelete'])[" + i + "]"));
                  deleteButton.click();
              }

            WebElement deleteConfirmationButton = driver.findElement(By.xpath("//*[@rv-on-click='rv.deletePopup']"));
            deleteConfirmationButton.click();
        }
    }
}
