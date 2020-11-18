package com.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxFactory extends GenericBrowserFactory {

	private WebDriver driver;

	public FirefoxFactory() {
		if (System.getProperty("headless").contains("true")) {
			System.out.println("Headless is not supported for firefox");
			System.exit(1);
		}
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "/resources/" + this.getOs() + "/firefox/geckodriver");
		driver = new FirefoxDriver();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
