package com.automation.symphony;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.GenericPageObject;
import com.automation.helpers.TempEmailObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordObject extends GenericPageObject {
    
	private final static String pageUrl = "https://my.symphony.com/#forgot-password";

	@FindBy(id = "sysMsg")
	private WebElement systemMessage;
	
	@FindBy(xpath = "//*[contains(text(), 'Password reset email sent')]")
	WebElement resetSent;
	
    @FindBy(css = "a.signup-link.link")
    @CacheLookup
    private WebElement cancel;

    @FindBy(name = "recover-email")
    @CacheLookup
    private WebElement emailAddressField;

    @FindBy(css = "#rc-anchor-container > div.rc-anchor-content > div:nth-child(1) > div > div")
    private WebElement captchaCheck;

    @FindBy(name = "recover-submit")
    @CacheLookup
    private WebElement recoverPassword;
    
    
    public WebElement getRecoverPassword() {
		return recoverPassword;
	}
    /**
     * get system messages for email/captcha validation
     */
    public String getSystemMessage() {
    	new WebDriverWait(super.driver, 10).until(ExpectedConditions.visibilityOf(systemMessage));
 		return systemMessage.getText();
	}	

    public ResetPasswordObject(WebDriver driver) {
        super(driver, pageUrl);
        this.driver = driver;
		PageFactory.initElements(driver, this);
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
    
    public ResetPasswordObject open() {
		super.open();
		return this.verifyPageLoaded();
	}

    /**
     * Click on Recover Password Button.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject clickRecoverPasswordButton() {
    	new WebDriverWait(super.driver, 5).until(ExpectedConditions.elementToBeClickable(recoverPassword));
        recoverPassword.click();
        return this;
    }


    /**
     * Set value to Enter Your Email Address To Begin Textarea field.
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject enterEmail(String email) {
        emailAddressField.sendKeys(email);
        return this;
    }


    /**
     * Click Captcha
     *
     * @return the ResetPasswordObject class instance.
     */
    public ResetPasswordObject clickCaptcha() {
    
    	WebElement frame = driver.findElement(By.cssSelector("#recover-form > div.recover-form__captcha-container > div > div > div > iframe"));
    	driver.switchTo().frame(frame);
    	
    	captchaCheck.click();
    	
    	driver.switchTo().defaultContent();
    	
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
    	new WebDriverWait(super.driver, 10).until(ExpectedConditions.visibilityOf(recoverPassword));
		return this;
    }

}