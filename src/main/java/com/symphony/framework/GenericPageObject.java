package com.symphony.framework;

import org.openqa.selenium.WebDriver;

public abstract class GenericPageObject {
	private String pageUrl;
	public WebDriver driver;
	
	public String getUrl() {
		return pageUrl;
	}

	public void setUrl(String url) {
		this.pageUrl = url;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public GenericPageObject(WebDriver driver, String pageUrl) {
		this.driver = driver;
		this.pageUrl = pageUrl;
	}
	
	public GenericPageObject open() {
		this.driver.get(pageUrl);
		return this;
	}
	
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
}
