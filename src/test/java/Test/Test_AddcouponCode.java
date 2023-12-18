package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class Test_AddcouponCode  extends TestNGListeners  {
	
	BaseFile based = new BaseFile(); 
@Test(priority = 1)
	public void execute () throws Throwable {

	
		Addc.Add_Coupon_with_Gift_and_Custom_Code( based.excel(1, 0),based.excel(1, 1));
	}
@Test(priority = 2)
public void Add_Couponwith_gift_and_systemGenerated_code() throws Throwable
{
	Addc.Add_Coupon_with_gift_and_systemGenerated_code( based.excel(2, 0),based.excel(2, 1));
}
@Test(priority = 3)
public void Test_Add_Coupon_Discount_Amount_with_additional_Setting() throws InterruptedException, IOException
{
	Addc.Add_Coupon_Discount_Amount_with_additional_Setting( based.excel(3, 0),based.excel(3, 1));
}
@Test(priority = 4)
public void Test_Add_Coupon_Dicount_amt_without_Adv() throws InterruptedException, IOException
{
	Addc.Add_Coupon_Dicount_amt_without_Adv( based.excel(4, 0),based.excel(4, 1));
}
@Test(priority = 5)
public void Test_Add_Coupon_Disount_percentage_with_adv() throws InterruptedException, IOException
{
	Addc.Add_Coupon_Disount_percentage_with_adv( based.excel(5, 0),based.excel(5, 1));
}
@Test(priority = 6)
public void Test_Add_Coupon_Discount_percentage_without_adv() throws InterruptedException, IOException 
{
	Addc.Add_Coupon_Discount_percentage_without_adv( based.excel(6, 0),based.excel(6, 1));
}
@Test(priority = 7)
public void Test_Add_coupon_Discount_unit_with_adv() throws IOException
{
	Addc.Add_coupon_Discount_unit_with_adv( based.excel(7, 0),based.excel(7, 1));
}
@Test(priority = 8)
public void Test_Add_Coupon_Discount_unit_without_adv() throws IOException
{
	Addc.Add_Coupon_Discount_unit_without_adv( based.excel(8, 0),based.excel(8, 1));
}
@Test(priority = 9)
public void Test_Add_Coupon_Discount_other_with_Adv() throws InterruptedException, IOException
{
	Addc.Add_Coupon_Discount_other_with_Adv( based.excel(9, 0),based.excel(9, 1));
}

}
