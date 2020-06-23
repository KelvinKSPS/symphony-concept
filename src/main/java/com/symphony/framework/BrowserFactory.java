package com.symphony.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	private GenericBrowserFactory browserFactory;
	
	public WebDriver getDriver() {
		return browserFactory.getDriver();
	}
	
	public GenericBrowserFactory getBrowserFactory() {
		return browserFactory;
	}
	public BrowserFactory(String browser) throws Exception {
		this(browser, false);
	}
	
	public BrowserFactory(String browser, boolean middleScreen) throws Exception {
		switch(browser.toLowerCase()) {
			case "firefox": {
				browserFactory = new FirefoxFactory();
				break;
			}
			case "chrome": {
				browserFactory = new ChromeFactory(middleScreen);
				break;
			}
			default: throw new Exception("Not Supported Browser");
			
		}
	}	
}
