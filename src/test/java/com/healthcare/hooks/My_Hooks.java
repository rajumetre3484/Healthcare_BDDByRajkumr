package com.healthcare.hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.healthcare.factory.BrowserFactory;
import com.healthcare.utilities.Readconfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class My_Hooks 
 {
	WebDriver driver;
	
	@Before
	public void setup() throws IOException
	{
	Properties read = Readconfig.initializeproperties();
	BrowserFactory.initializeBrowser(read.getProperty("browser"));	
	driver = BrowserFactory.getDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void teardown(Scenario scenario) {
		String scenarioname = scenario.getName().replace(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioname);
		}
		
		driver.quit();
	}

}
