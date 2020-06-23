package com.symphony.page;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.symphony.framework.GenericPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInObject extends GenericPageObject {
	private final static String pageUrl = "https://my.symphony.com";

	private Map<String, String> data;
	private String successUrl = "https://my.symphony.com/client/index.html?";
	
	
	@FindBy(css = "#sysMsg > span.message")
	private WebElement errorMessage;
	
	@FindBy(className = "language-label")
	private WebElement languageLabel;
	
	@FindBy(id = "signin-email")
	private WebElement emailField;
	
	@FindBy(id = "signin-password")
	private WebElement passwordField;
	
	@FindBy(className = "menu-tooltip-language-selected-language")
	private WebElement menuToolTipLanguage;

	@FindBy(css = "a[href='#forgot-password']")
	@CacheLookup
	private WebElement forgotYourPassword;

	
	@FindBy(id = "signin-password")
	@CacheLookup
	private WebElement passwordRequired;

	@FindBy(id = "signin-remember")
	@CacheLookup
	private WebElement rememberMyEmailAddress;

	@FindBy(name = "signin-submit")
	@CacheLookup
	private WebElement signInToAccount;

	
	@FindBy(css = "a[href='#signup']")
	@CacheLookup
	private WebElement signUp;

	@FindBy(id = "signin-email")
	@CacheLookup
	private WebElement usernameRequired;

	
	public WebElement getEmailField() {
		return emailField;
	}
	
	public String getSuccessUrl() {
		return successUrl;
	}
	
	public void submitCredentials(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		passwordField.submit();
		new WebDriverWait(super.driver, 15).until(ExpectedConditions.urlToBe(successUrl));
	}
	
	public WebElement languageLabel() {
		return languageLabel;
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	
	/**
	 * Select id by language
	 * @param language
	 */
	public SignInObject selectLanguage(String language) {
		menuToolTipLanguage.click();
		String id = null;
		switch(language) {
			case "english": id = "en-US";
			break;
			case "japanese": id = "ja-JP";
			break;
			case "french": id = "fr-FR";
			break;
		}
		super.driver.findElement(By.id(id)).click();
		return this;		
	}
	
	public WebElement getSignInToAccount() {
		return signInToAccount;
	}
	
	public SignInObject(WebDriver driver) {
		super(driver, pageUrl);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignInObject(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}


	public SignInObject open() {
		super.open();
		this.verifyPageLoaded();
		return this;
	}

	/**
	 * Click on Forgot Your Password Link.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject clickForgotYourPasswordLink() {
		forgotYourPassword.click();
		return this;
	}

	/**
	 * Click on Sign In To Account Button.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject clickSignInToAccountButton() {
		signInToAccount.click();
		return this;
	}

	/**
	 * Click on Sign Up Link.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject clickSignUpLink() {
		signUp.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject fill() {
		setUsernameRequiredTextField();
		setPasswordRequiredPasswordField();
		setRememberMyEmailAddressCheckboxField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Password Required Password field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject setPasswordRequiredPasswordField() {
		return setPasswordRequiredPasswordField(data.get("PASSWORD_REQUIRED"));
	}

	/**
	 * Set value to Password Required Password field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject setPasswordRequiredPasswordField(String passwordRequiredValue) {
		passwordRequired.sendKeys(passwordRequiredValue);
		return this;
	}

	/**
	 * Set Remember My Email Address Checkbox field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject setRememberMyEmailAddressCheckboxField() {
		if (!rememberMyEmailAddress.isSelected()) {
			rememberMyEmailAddress.click();
		}
		return this;
	}

	/**
	 * Set default value to Username Required Text field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject setUsernameRequiredTextField() {
		return setUsernameRequiredTextField(data.get("USERNAME_REQUIRED"));
	}

	/**
	 * Set value to Username Required Text field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject setUsernameRequiredTextField(String usernameRequiredValue) {
		usernameRequired.sendKeys(usernameRequiredValue);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject submit() {
		clickSignInToAccountButton();
		return this;
	}

	/**
	 * Unset Remember My Email Address Checkbox field.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject unsetRememberMyEmailAddressCheckboxField() {
		if (rememberMyEmailAddress.isSelected()) {
			rememberMyEmailAddress.click();
		}
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the SignInObject class instance.
	 */
	public SignInObject verifyPageLoaded() {
		new WebDriverWait(super.driver, 10).until(ExpectedConditions.elementToBeClickable(forgotYourPassword));
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the SignInObject class instance.
	 */
	public boolean verifyPageUrl() {
		new WebDriverWait(super.driver, 30).until(ExpectedConditions.urlContains(pageUrl));
		return super.getCurrentUrl().contains(pageUrl);
	}

	/**
	 * get text without line delimiters  
	 */
	public String languageLabelContent() {
		return this.languageLabel().getText().replace("\n", "");
	}
}