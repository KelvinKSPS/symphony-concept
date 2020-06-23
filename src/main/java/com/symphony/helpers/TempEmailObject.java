package com.symphony.helpers;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.symphony.framework.GenericPageObject;
import com.symphony.page.SignInObject;
import com.symphony.page.SignUpObject;

public class TempEmailObject extends GenericPageObject {

	@FindBy(id = "current-id")
	WebElement copyEmailButton;

	@FindBy(xpath = "//*[contains(text(), 'Confirm Your Email')]")
	WebElement emailConfirmation;

	@FindBy(xpath = "//*[contains(text(), 'Welcome to Symphony Email Verification.')]")
	WebElement emailSubject;

	public final static String pageUrl = "https://www.tempinbox.xyz/mailbox/";

	public TempEmailObject(WebDriver driver) {
		super(driver, pageUrl);
		PageFactory.initElements(driver, this);
	}

	public String getEmail() {
		return copyEmailButton.getAttribute("value");
	};

	public void submitPin(String pin, SignUpObject signUpPage) {
		WebElement pinField = signUpPage.getPinField();
		pinField.sendKeys(pin);
		pinField.submit();
	}

	public void submitPhone(String phone, SignUpObject signUpPage) {
		WebElement phoneField = signUpPage.getPhoneField();
		phoneField.sendKeys(phone);
		phoneField.submit();
	}

	public void validateEmail(int timeout, SignInObject signInPage) {
		new WebDriverWait(this.driver, timeout).until(ExpectedConditions.elementToBeClickable(emailSubject));
		try {
			emailSubject.click();
		} catch (Exception ex) {
			System.out.println("InterceptError, one more try");
			emailSubject.click();
		}
		
		new WebDriverWait(super.driver, timeout).until(ExpectedConditions.visibilityOf(emailConfirmation));

		super.driver.get(emailConfirmation.getAttribute("href"));

		new WebDriverWait(super.driver, timeout).until(ExpectedConditions.visibilityOf(signInPage.getEmailField()));

	};

	public TempEmailObject open() {
		super.open();
		this.verifyPageLoaded();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the SignInObject class instance.
	 */
	public TempEmailObject verifyPageLoaded() {
		new WebDriverWait(super.driver, 20).until(ExpectedConditions.visibilityOf(copyEmailButton));
		return this;
	}

}
