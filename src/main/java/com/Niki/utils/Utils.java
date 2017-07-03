package com.Niki.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Utils {
	DesiredCapabilities dc;
	public static AppiumDriver<WebElement> driver;
	public static Properties prop=new Properties();
	static FileInputStream fis;
	
	static{
		try {
			fis=new FileInputStream("D:\\Mobile Automation\\com.NikiTest\\src\\main\\java\\com\\Niki\\properties\\prop.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
