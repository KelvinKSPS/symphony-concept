package Symphony.WebApp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.symphony.framework.BrowserStrategy;
import com.symphony.helpers.ReceiveSmsObject;
import com.symphony.helpers.TempEmailObject;
import com.symphony.helpers.Constants.*;
import com.symphony.page.ResetPasswordObject;
import com.symphony.page.SignInObject;
import com.symphony.page.SignUpObject;
import static com.symphony.helpers.MostCommonFlows.*;

public class FullIntegrationTests {
	
	public BrowserStrategy browser;
	public BrowserStrategy auxBrowser;
	public SignInObject signInPage;
	public SignUpObject signUpPage;
	public ResetPasswordObject resetPasswordPage;
	public TempEmailObject emailPage;
	public ReceiveSmsObject smsPage;
	public WebDriver webdriver;
	public WebDriver auxWebdriver;

	@Before
	public void preconditions() throws Exception {
		String browserName = System.getProperty("browser");
		browser = new BrowserStrategy(browserName);
		webdriver = browser.getDriver();
		auxBrowser = new BrowserStrategy(browserName, true);
		auxWebdriver = auxBrowser.getDriver();
		
		
	}
	
	@Test
	public void Should_CreateAccount_When_FillingAllFieldsAndValidateEmailAndSMS() throws InterruptedException {
		signUpPage = new SignUpObject(webdriver);
		emailPage = new TempEmailObject(auxWebdriver);
		signInPage = new SignInObject(auxWebdriver);
		
		String email = fullSignUpFlow(signUpPage, signInPage, emailPage);
		signInPage.submitCredentials(email, Valid.PASSWORD);
		
		assertEquals(signInPage.getCurrentUrl(), signInPage.getSuccessUrl());
		
	}

	
	@After
	public void cleanUp() {
		webdriver.close();
		auxWebdriver.close();
	}
	
//	Ready for Two Factory Authentication
//	Symphony WebSite was requiring that on June 22nd 
//	smsPage = new ReceiveSmsObject(webdriver);
//	String phone = smsPage.getNumber();
//	emailPage.submitPhone(phone, signUpPage);
//			
//	// wait SMS - explicit to avoid multiples PIN to the same US Number 
//	Thread.sleep(30000);
//	smsPage.open();
//	String pin = smsPage.getSmsPin(90);
//	emailPage.submitPin(pin, signUpPage);

}
