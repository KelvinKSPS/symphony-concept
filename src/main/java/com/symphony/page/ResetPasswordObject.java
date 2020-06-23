package com.symphony.page;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.symphony.framework.GenericPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordObject extends GenericPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    
    public WebElement getRecoverPassword() {
		return recoverPassword;
	}

	private int timeout = 15;
    
	private final static String pageUrl = "https://my.symphony.com/#forgot-password";

    @FindBy(css = "a.signup-link.link")
    @CacheLookup
    private WebElement cancel;

    @FindBy(name = "recover-email")
    @CacheLookup
    private WebElement enterYourEmailAddressToBegin1;

    @FindBy(id = "g-recaptcha-response")
    @CacheLookup
    private WebElement enterYourEmailAddressToBegin2;

    private final String pageLoadedText = "Enter your email address to begin";

    @FindBy(name = "recover-submit")
    @CacheLookup
    private WebElement recoverPassword;

    public ResetPasswordObject(WebDriver driver) {
        super(driver, pageUrl);
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public ResetPasswordObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ResetPasswordObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Cancel Link.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject clickCancelLink() {
        cancel.click();
        return this;
    }

    /**
     * Click on Recover Password Button.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject clickRecoverPasswordButton() {
        recoverPassword.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject fill() {
        setEnterYourEmailAddressToBegin1TextareaField();
        setEnterYourEmailAddressToBegin2TextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Enter Your Email Address To Begin Textarea field.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject setEnterYourEmailAddressToBegin1TextareaField() {
        return setEnterYourEmailAddressToBegin1TextareaField(data.get("ENTER_YOUR_EMAIL_ADDRESS_TO_BEGIN_1"));
    }

    /**
     * Set value to Enter Your Email Address To Begin Textarea field.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject setEnterYourEmailAddressToBegin1TextareaField(String enterYourEmailAddressToBegin1Value) {
        enterYourEmailAddressToBegin1.sendKeys(enterYourEmailAddressToBegin1Value);
        return this;
    }

    /**
     * Set default value to Enter Your Email Address To Begin Textarea field.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject setEnterYourEmailAddressToBegin2TextareaField() {
        return setEnterYourEmailAddressToBegin2TextareaField(data.get("ENTER_YOUR_EMAIL_ADDRESS_TO_BEGIN_2"));
    }

    /**
     * Set value to Enter Your Email Address To Begin Textarea field.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject setEnterYourEmailAddressToBegin2TextareaField(String enterYourEmailAddressToBegin2Value) {
        enterYourEmailAddressToBegin2.sendKeys(enterYourEmailAddressToBegin2Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject submit() {
        clickRecoverPasswordButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}