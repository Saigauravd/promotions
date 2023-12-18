package Test;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class Test_Delete extends TestNGListeners {

	@Test
	public void testDelete() throws InterruptedException
	{
		delete.delete();
	}
}
