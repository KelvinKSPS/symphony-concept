package com.automation.helpers;

import com.automation.helpers.Constants.Valid;
import com.automation.symphony.SignInObject;
import com.automation.symphony.SignUpObject;

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
		try {
			emailPage.validateEmail(30, signInPage);
		} catch (Exception ex) {
			System.err.println(ex);
			System.out.println("Maybe it is an issue in the email service, trying again");
			emailPage.driver.get(emailPage.getCurrentUrl());
			emailPage.validateEmail(30, signInPage);
		}
		return email;
	}
}
