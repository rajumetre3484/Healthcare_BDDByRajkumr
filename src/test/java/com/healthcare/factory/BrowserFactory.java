package com.healthcare.factory;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	static WebDriver driver;
	
	public static void initializeBrowser(String browser) {
		if(browser.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}
		else if (browser.equals("firefox")) {
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if (browser.equals("edge")) {
			driver=WebDriverManager.edgedriver().create();
		}
		else {
			driver=WebDriverManager.safaridriver().create();
		}	
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
