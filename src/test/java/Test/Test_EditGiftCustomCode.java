package Test;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
@Test(priority = 2)
public class Test_EditGiftCustomCode extends TestNGListeners{
	public void test_EditGiftCustomCode() {
		editgift.Editing_coupon();
	}

}
