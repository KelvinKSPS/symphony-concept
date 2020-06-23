package com.symphony.framework;

import java.awt.Toolkit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends GenericBrowserFactory {

	public ChromeFactory(boolean middleScreen) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/resources/" + this.getOs() + "/chrome/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		if (System.getProperty("headless").contains("true")) {
			options.addArguments("headless");
		}

		this.driver = new ChromeDriver(options);

		if (middleScreen) {
			this.setMiddleScreen();
		}
	}

	public ChromeFactory() {
		this(false);
	}

}