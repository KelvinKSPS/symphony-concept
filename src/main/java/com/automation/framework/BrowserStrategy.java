package com.automation.framework;

import java.awt.Toolkit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserStrategy {

	private GenericBrowserFactory browserFactory;
	public WebDriver driver;

	public BrowserStrategy(String browser) throws Exception {
		this(browser, false);
	}

	/**
	 * 
	 * @param browser      = desired Web Browser
	 * @param middleScreen = if the user wants to have a windows from the middle of
	 *                     the screen
	 * @throws Exception
	 */
	public BrowserStrategy(String browser, boolean middleScreen) throws Exception {
		// default browser
		if (browser == null) {
			browser = "chrome";
		}
		switch (browser.toLowerCase()) {
		case "firefox": {
			browserFactory = new FirefoxFactory();
			break;
		}
		case "chrome": {
			browserFactory = new ChromeFactory(middleScreen);
			break;
		}
		default:
			throw new Exception("Not Supported Browser");

		}
	}

	public WebDriver getDriver() {
		return browserFactory.getDriver();
	}

	public GenericBrowserFactory getBrowserFactory() {
		return browserFactory;
	}

}
