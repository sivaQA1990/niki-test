package com.Niki.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SetUp extends Utils {
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		  dc = new DesiredCapabilities();
		  dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		  dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		  dc.setCapability(MobileCapabilityType.DEVICE_NAME, "3300ae635e841473");
		  dc.setCapability(MobileCapabilityType.APP_ACTIVITY,prop.getProperty("appActivity"));
		  dc.setCapability(MobileCapabilityType.APP_PACKAGE,prop.getProperty("appPackage"));
		  driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  System.out.println("Application launched successfully");
	  }

}
