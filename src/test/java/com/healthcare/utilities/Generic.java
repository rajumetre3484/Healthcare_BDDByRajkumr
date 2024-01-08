package com.healthcare.utilities;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {

	WebDriver driver;
	
	public Generic(WebDriver driver) 
	{
	 this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForElement(element, durationInSeconds);
        webelement.click();
	}
	
	public void typeTextInElement(WebElement element,long durationInSeconds,String textToBeType) {
		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeType);
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		WebElement webelement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void selectOptionInDropdown(WebElement element,long durationInSeconds,String dropDownOption) {
		WebElement webelement = waitForElement(element, durationInSeconds);
        Select sc=new Select(webelement);
        sc.selectByVisibleText(dropDownOption);
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForElement(element, durationInSeconds);
	   return webelement.getText();
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();;
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element,durationInSeconds);
		Actions action=new Actions(driver);
		action.moveToElement(webelement).build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		WebElement webelement=null;
	try{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.visibilityOf(element));
	}catch (Throwable e) {
		e.printStackTrace();
	}
	return webelement;	
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webelement);
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String testToBeType) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+testToBeType+"'",webelement);
	}
	
	
	public static String  randomemail()
	{
		 String generateEmail = RandomStringUtils.randomAlphabetic(10);
		 return("ram"+generateEmail+"@gmail.com");
	}
	public static String  randoname()
	{
		 String generateName= RandomStringUtils.randomAlphabetic(10);
		 return("ram"+generateName);
	}
	public static String  randonumber()
	{
		 String generateNo= RandomStringUtils.randomNumeric(10);
		 return("+91"+generateNo);
	}
	public static String  randopassword()
	{
		 String generatePswd= RandomStringUtils.randomAlphanumeric(10);
		 return(generatePswd);
	}
}
