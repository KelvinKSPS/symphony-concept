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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpObject extends GenericPageObject {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "//button[@class=\'button green invalid']")
	private WebElement nextInvalid;
	
	@FindBy(xpath = "//button[@class=\'button green']")
	private WebElement next;
	
	@FindBy(xpath = "//*[contains(text(), 'Invite Your Team')]")
	WebElement secondStepScreenHeader;
	
	@FindBy(xpath = "//*[contains(text(), 'Skip')]")
	WebElement SkipButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Please Verify Your Email')]")
	WebElement emailHeader;
	
	@FindBy(xpath = "//*[contains(text(), 'Two Factor Authentication Setup')]")
	WebElement smsHeader;
	
	@FindBy(id = "mobile-phone-number")
	WebElement phoneField;
	
	@FindBy(id = "mobile-verification-code")
	WebElement pinField;
	
	public WebElement getPinField() {
		return pinField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}
	
	public WebElement getSmsHeader() {
		return smsHeader;
	}

	public WebElement getNextInvalid() {
		return nextInvalid;
	}

	public WebElement getNext() {
		return next;
	}

	private final String pageLoadedText = "one letter, number, special character and one letter in uppercase";

	private static final String pageUrl = "https://my.symphony.com/#signup";

	@FindBy(css = "a[href='https://symphony.com/legal/privacy']")
	@CacheLookup
	private WebElement privacyPolicy;

	@FindBy(css = "a[href='#login']")
	@CacheLookup
	private WebElement signIn;

	@FindBy(id = "signup-first")
	@CacheLookup
	private WebElement signUpWithYourFirstName;

	@FindBy(id = "signup-last")
	@CacheLookup
	private WebElement signUpWithYourLastName;

	@FindBy(id = "signup-email")
	@CacheLookup
	private WebElement signUpWithYourEmail;

	@FindBy(id = "signup-password")
	@CacheLookup
	private WebElement signUpWithYourPassword;

	@FindBy(css = "a[href='https://symphony.com/legal/public-eula']")
	@CacheLookup
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "//li[@class=\'passcode-low']")
	private WebElement lowercaseDisabled;
	
	@FindBy(xpath = "//li[@class=\'passcode-low checked']")
	private WebElement lowercaseEnabled;
	
	@FindBy(xpath = "//li[@class=\'passcode-cap']")
	private WebElement uppercaseDisabled;
	
	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	public WebElement getLowercaseDisabled() {
		return lowercaseDisabled;
	}

	public WebElement getLowercaseEnabled() {
		return lowercaseEnabled;
	}

	public WebElement getUppercaseDisabled() {
		return uppercaseDisabled;
	}

	public WebElement getUppercaseEnabled() {
		return uppercaseEnabled;
	}

	public WebElement getSpecialcaseDisabled() {
		return specialcaseDisabled;
	}

	public WebElement getSpecialcaseEnabled() {
		return specialcaseEnabled;
	}

	public WebElement getNumberDisabled() {
		return numberDisabled;
	}

	public WebElement getNumberEnabled() {
		return numberEnabled;
	}

	@FindBy(xpath = "//li[@class=\'passcode-cap checked']")
	private WebElement uppercaseEnabled;

	@FindBy(xpath = "//li[@class=\'passcode-spec']")
	private WebElement specialcaseDisabled;
	
	@FindBy(xpath = "//li[@class=\'passcode-spec checked']")
	private WebElement specialcaseEnabled;
	
	@FindBy(xpath = "//li[@class=\'passcode-num']")
	private WebElement numberDisabled;
	
	@FindBy(xpath = "//li[@class=\'passcode-num checked']")
	private WebElement numberEnabled;
	
	public SignUpObject(WebDriver driver) {
		super(driver, pageUrl);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignUpObject(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public SignUpObject(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Next Button.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject clickNextButton() {
		next.click();
		new WebDriverWait(super.driver, 5).until(ExpectedConditions.elementToBeClickable(SkipButton));
		return this;
	}
	
	/**
	 * Click on Skip Button
	 */
	public SignUpObject clickSkipButton() {
		SkipButton.click();
		new WebDriverWait(super.driver, 10).until(ExpectedConditions.elementToBeClickable(emailHeader));
		return this;
	}

	/**
	 * Click on Privacy Policy Link.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject clickPrivacyPolicyLink() {
		privacyPolicy.click();
		return this;
	}

	/**
	 * Click on Sign In Link.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject clickSignInLink() {
		signIn.click();
		return this;
	}

	/**
	 * Click on Terms And Conditions Link.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject clickTermsAndConditionsLink() {
		termsAndConditions.click();
		return this;
	}
	
	public SignUpObject open() {
		super.open();
		this.verifyPageLoaded();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject fill() {
		setSignUpWithYourFirstName();
		setSignUpWithYourLastName();
		setSignUpWithYourEmail();
		setSignUpWithYourPassword();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourFirstName() {
		return setSignUpWithYourFirstName(data.get("SIGN_UP_WITH_YOUR_DETAILS_1"));
	}

	/**
	 * Set value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourFirstName(String signUpWithYourDetails1Value) {
		signUpWithYourFirstName.sendKeys(signUpWithYourDetails1Value);
		return this;
	}

	/**
	 * Set default value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourLastName() {
		return setSignUpWithYourLastName(data.get("SIGN_UP_WITH_YOUR_DETAILS_2"));
	}

	/**
	 * Set value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourLastName(String signUpWithYourDetails2Value) {
		signUpWithYourLastName.sendKeys(signUpWithYourDetails2Value);
		return this;
	}

	/**
	 * Set default value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourEmail() {
		return setSignUpWithYourEmail(data.get("SIGN_UP_WITH_YOUR_DETAILS_3"));
	}

	/**
	 * Set value to Sign Up With Your Details Text field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourEmail(String signUpWithYourDetails3Value) {
		signUpWithYourEmail.sendKeys(signUpWithYourDetails3Value);
		return this;
	}

	/**
	 * Set default value to Sign Up With Your Details Password field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourPassword() {
		return setSignUpWithYourPassword(data.get("SIGN_UP_WITH_YOUR_DETAILS_4"));
	}

	/**
	 * Set value to Sign Up With Your Details Password field.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject setSignUpWithYourPassword(String password) {
		signUpWithYourPassword.sendKeys(password);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject submit() {
		clickNextButton();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject verifyPageLoaded() {
		new WebDriverWait(super.driver, 5).until(ExpectedConditions.elementToBeClickable(privacyPolicy));
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the SignUpObject class instance.
	 */
	public SignUpObject verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}