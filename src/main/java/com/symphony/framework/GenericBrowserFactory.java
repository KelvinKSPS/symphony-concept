package com.symphony.framework;

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
}
