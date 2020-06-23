package com.symphony.framework;

import java.awt.Toolkit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class GenericBrowserFactory {

	private String os;
	public WebDriver driver;

	public GenericBrowserFactory() {
		this.setOs();
	}

	public void setOs() {
		this.os = System.getProperty("os.name").toLowerCase();
		this.os = this.os.contains("win") ? "windows" : this.os;
	}
	
	public String getOs() {
		return this.os;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}	

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * get properties from the middle of the screen to have two browsers displayed together
	 */
	public void setMiddleScreen() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Point screenResolution = new Point((int) 
		                    toolkit.getScreenSize().getWidth()/2, (int) 
		                    toolkit.getScreenSize().getHeight());
		this.driver.manage().window().setPosition(new Point(0,0));
		this.driver.manage().window().setPosition(screenResolution);
	}
}
