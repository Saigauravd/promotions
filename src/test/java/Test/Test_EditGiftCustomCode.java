package Test;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class Test_EditGiftCustomCode extends TestNGListeners{
	
	
	@Test(priority = 10)
	public void test_EditGiftCustomCode() throws InterruptedException {
		editgift.Editing_coupon();
	}

}
