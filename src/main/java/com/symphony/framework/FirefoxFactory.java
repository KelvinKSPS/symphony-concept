package com.symphony.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxFactory extends GenericBrowserFactory {
	
	private WebDriver driver;
	
	public FirefoxFactory() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/"+this.getOs()+"/firefox/geckodriver");
		driver = new FirefoxDriver();
			
	}

	public WebDriver getDriver() {
		return driver;
	}	

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
