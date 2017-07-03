package NikiTest.com.NikiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Niki.pageObjects.NikiPageObject;
import com.Niki.utils.SetUp;

public class NikiTestCases extends SetUp {
	@Test
	public void verifyPrepaidRechargeFeature() throws InterruptedException {
		NikiPageObject pageObj = new NikiPageObject(driver);

		String feature = "Prepaid Recharge";
		pageObj.startChat(prop.getProperty("chatStart"));
		pageObj.selectFeatureOptionList(feature);
		try {
			Assert.assertEquals(pageObj.getSelectedFeature(), feature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageObj.startChat(prop.getProperty("chatCancel"));
	}

	@Test
	public void verifyBusBookingFeature() throws InterruptedException {
		NikiPageObject pageObj = new NikiPageObject(driver);

		String feature = "Bus Booking";
		String busTime = "After 6 PM";
		String busType = "AC";
		String busSeatType = "Semi Sleeper";
		pageObj.startChat(prop.getProperty("chatStart"));
		pageObj.selectFeatureOptionList(feature);
		try {
			Assert.assertEquals(pageObj.getSelectedFeature(), feature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageObj.startChat(prop.getProperty("source"));
		Thread.sleep(10000);
		pageObj.startChat(prop.getProperty("destination"));
		Thread.sleep(10000);
		pageObj.selectFeatureOptionList(busTime);
		Thread.sleep(5000);
		pageObj.selectFeatureOptionList(busType);
		Thread.sleep(5000);
		pageObj.selectFeatureOptionList(busSeatType);
		pageObj.startChat(prop.getProperty("chatCancel"));
	}
}
