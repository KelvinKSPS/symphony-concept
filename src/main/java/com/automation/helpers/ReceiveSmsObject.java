package com.automation.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.GenericPageObject;
import com.automation.symphony.SignInObject;

public class ReceiveSmsObject extends GenericPageObject {
	
	public final static String pageUrl = "http://receivesms.co/us-phone-number/3419/";
	public final String number = "2678462671";
	
	@FindBy(xpath = "//*[contains(text(), 'is your Symphony verification code.')]")
	WebElement smsContent;

	@FindBy(xpath = "//*[contains(text(), 'USA - US Phone Number')]")
	WebElement smsTitle;

	/**
	 * getting number for SMS testing 
	 */
	public String getNumber() {
		return number;
	}

	public ReceiveSmsObject(WebDriver driver) {
		super(driver, pageUrl);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * getSmsPin - get the SMS Pin for Two-Factory-Authentication
	 * @param timeout - the maximum time to receive the PIN
	 * @return the SMS Pin
	 */
	public String getSmsPin(int timeout) {
		new WebDriverWait(this.driver, timeout).until(ExpectedConditions.elementToBeClickable(smsContent));
		return smsContent.getText().substring(0, 6);
	};
	
	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the SignInObject class instance.
	 */
	public ReceiveSmsObject verifyPageLoaded() {
		new WebDriverWait(super.driver, 5).until(ExpectedConditions.visibilityOf(smsTitle));
		return this;
	}



}
