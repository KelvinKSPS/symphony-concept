package com.symphony.framework;

import java.awt.Toolkit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends GenericBrowserFactory {
	
	public ChromeFactory(boolean middleScreen) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/"+this.getOs()+"/chrome/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		this.driver = new ChromeDriver(options);
		
		if(middleScreen) {
			this.setMiddleScreen();
		}
	}
	
	public ChromeFactory() {
		this(false);
	}
	
	public void setMiddleScreen() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Point screenResolution = new Point((int) 
		                    toolkit.getScreenSize().getWidth()/2, (int) 
		                    toolkit.getScreenSize().getHeight());
		this.driver.manage().window().setPosition(new Point(0,0));
		this.driver.manage().window().setPosition(screenResolution);
	}


}