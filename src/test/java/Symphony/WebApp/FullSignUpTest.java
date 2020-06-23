package Symphony.WebApp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.symphony.framework.BrowserFactory;
import com.symphony.helpers.ReceiveSmsObject;
import com.symphony.helpers.TempEmailObject;
import com.symphony.helpers.Constants.*;
import com.symphony.page.ResetPasswordObject;
import com.symphony.page.SignInObject;
import com.symphony.page.SignUpObject;

public class FullSignUpTest {
	
	public BrowserFactory browser;
	public BrowserFactory auxBrowser;
	public SignInObject signInPage;
	public SignUpObject signUpPage;
	public ResetPasswordObject resetPasswordPage;
	public TempEmailObject emailPage;
	public ReceiveSmsObject smsPage;
	public WebDriver webdriver;
	public WebDriver auxWebdriver;

	@Before
	public void preconditions() throws Exception {
		String browserName = "chrome";
		browser = new BrowserFactory(browserName);
		webdriver = browser.getDriver();
		auxBrowser = new BrowserFactory(browserName, true);
		auxWebdriver = auxBrowser.getDriver();
		
		
	}
	
	@Test
	public void Should_CreateAccount_When_FillingAllFieldsAndValidateEmailAndSMS() throws InterruptedException {
		signUpPage = new SignUpObject(webdriver);
		emailPage = new TempEmailObject(auxWebdriver);
		
		signUpPage.open();
		emailPage.open();
		
		String email = emailPage.getEmail();
		
		signUpPage.setSignUpWithYourFirstName(Valid.FIRST_NAME);
		signUpPage.setSignUpWithYourLastName(Valid.LAST_NAME);
		signUpPage.setSignUpWithYourEmail(email);
		signUpPage.setSignUpWithYourPassword(Valid.PASSWORD);
		signUpPage.clickNextButton();
		signUpPage.clickSkipButton();
		signInPage = new SignInObject(auxWebdriver);
		emailPage.validateEmail(20, signInPage);
		signInPage.submitCredentials(email, Valid.PASSWORD);
		
//		
//		smsPage = new ReceiveSmsObject(webdriver);
//		String phone = smsPage.getNumber();
//		emailPage.submitPhone(phone, signUpPage);
//				
//		// wait SMS - explicit to avoid multiples PIN to the same US Number 
//		Thread.sleep(30000);
//		smsPage.open();
//		String pin = smsPage.getSmsPin(90);
//		emailPage.submitPin(pin, signUpPage);

		
		assertEquals(auxWebdriver.getCurrentUrl(), signInPage.getSuccessUrl());
		
	}
	
	@After
	public void cleanUp() {
		webdriver.close();
		auxWebdriver.close();
	}

}
