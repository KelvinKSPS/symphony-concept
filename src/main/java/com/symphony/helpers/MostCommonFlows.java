package com.symphony.helpers;

import com.symphony.helpers.Constants.Valid;
import com.symphony.page.SignInObject;
import com.symphony.page.SignUpObject;

/**
 * Most used flows from the automation to be stored here as static methods
 *
 */
public class MostCommonFlows {
	
	/**
	 * full success sign up flow for a random email
	 */
	public static String fullSignUpFlow(SignUpObject signUpPage, SignInObject signInPage, TempEmailObject emailPage) {
		signUpPage.open();
		emailPage.open();
		
		String email = emailPage.getEmail();
		
		signUpPage.setSignUpWithYourFirstName(Valid.FIRST_NAME);
		signUpPage.setSignUpWithYourLastName(Valid.LAST_NAME);
		signUpPage.setSignUpWithYourEmail(email);
		signUpPage.setSignUpWithYourPassword(Valid.PASSWORD);
		signUpPage.clickNextButton();
		signUpPage.clickSkipButton();
		emailPage.validateEmail(30, signInPage);
		return email;
	}
}
