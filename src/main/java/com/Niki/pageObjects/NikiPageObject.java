package com.Niki.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Niki.utils.SetUp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NikiPageObject extends SetUp {
	public NikiPageObject(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);

	}

	@FindBy(id = "com.techbins.niki.beta:id/helpLayout")
	public WebElement chatOptionUpArrowBtn;

	@FindBy(id = "com.techbins.niki.beta:id/btnSend")
	public WebElement chatSendButton;

	@FindBy(id = "com.techbins.niki.beta:id/edtTxtInputMessage")
	public WebElement chatInputBox;

	// Prepaid recharge
	By listOfOptions = By.id("com.techbins.niki.beta:id/listOption");

	By listOfPaymentsOptions = By.id("com.techbins.niki.beta:id/listOption");// pick
																				// destonation

	// Movie ticket
	@FindBy(id = "com.techbins.niki.beta:id/recommendationActionButton2")
	public WebElement selectMovieLink;

	@FindBy(id = "com.techbins.niki.beta:id/recommendationActionButton1")
	public WebElement viewSeatsAndBookLink; // select link

	@FindBy(className = "android.widget.Button")
	public WebElement bookSeatsBtn;

	@FindBy(id = "theatreName")
	public WebElement theatreName;

	@FindBy(id = "com.techbins.niki.beta:id/outGoingMessage")
	public WebElement selectedFeature;

	// Bus booking
	By busTimingSeatTypeOptions = By.id("com.techbins.niki.beta:id/listOption");

	By busType = By.id("com.techbins.niki.beta:id/listOption");

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	public WebElement featureOssptions;

	By suggestionTxt = By.id("com.techbins.niki.beta:id/suggestionText");

	// My Account
	By myAccOptions = By.id("com.techbins.niki.beta:id/menuTitle");

	@FindBy(className = "android.widget.ImageButton")
	public WebElement threeLinkMenu;

	@FindBy(id = "com.techbins.niki.beta:id/layoutItem")
	public WebElement firstOrder;

	@FindBy(id = "com.techbins.niki.beta:id/orderStatus")
	public WebElement orderStatus;

	@FindBy(id = "com.techbins.niki.beta:id/orderId")
	public WebElement orderId;

	@FindBy(id = "com.techbins.niki.beta:id/title")
	public WebElement orderPageDetailPageTitle;

	public void startChat(String chatOpt) {
		chatInputBox.sendKeys(chatOpt);
		chatSendButton.click();
	}

	public void selectFeatureOptionList(String featureOption) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("List options=" + listOfOptions);
		List<WebElement> appFeatures = driver.findElements(listOfOptions);
		System.out.println("No.of App Features=" + appFeatures.size());
		System.out.println("The list of features of this app are :");
		for (int i = 0; i < appFeatures.size(); i++) {
			String featuresList = appFeatures.get(i).getText();
			Thread.sleep(2000);
			System.out.println(featuresList);
		}
		for (int i = 0; i < appFeatures.size(); i++) {
			WebElement requiredFeature = appFeatures.get(i);
			String featuresList = requiredFeature.getText();
			Thread.sleep(2000);
			if (featuresList.equalsIgnoreCase(featureOption)) {
				System.out.println("Selecting the option Prepaid Recharge");
				requiredFeature.click();
				break;
			}

		}
	}

	public String getSelectedFeature() {
		String selectedFeatureTxt = selectedFeature.getText();
		System.out.println("Selected Feature text=" + selectedFeatureTxt);
		return selectedFeatureTxt;
	}

	public void clickViewSeatsLink() {
		viewSeatsAndBookLink.click();
	}

}
