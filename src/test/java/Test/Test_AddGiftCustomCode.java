package Test;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class Test_AddGiftCustomCode  extends TestNGListeners{
@Test(priority = 1)
	public void execute () throws Throwable {
		Addc.Add_Coupon_with_Gift_and_Custom_Code();
		//Addc.Add_Coupon_with_gift_and_systemGenerated_code();
	}
}
