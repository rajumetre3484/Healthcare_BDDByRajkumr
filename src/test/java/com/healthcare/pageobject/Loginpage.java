package com.healthcare.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthcare.utilities.Generic;

public class Loginpage {
	@FindBy(id="txt-username")
	private WebElement txtUsername;
	
	@FindBy(id="txt-password")
	private WebElement txtPassword;
	
	@FindBy(id="btn-login")
	private WebElement btnLogin;
	
	WebDriver ldriver;
	Generic common;
	
	public Loginpage(WebDriver driver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
		common=new Generic(driver);
	}
	
	
	public void setTxtUsername(String Username) {
		common.typeTextInElement(txtUsername, 30, Username);
	}
	public void setTxtPassword(String Password) {
		common.typeTextInElement(txtPassword, 30, Password);
		
	}
	public void setBtnLogin() {
		common.clickOnElement(btnLogin, 20);
	}	
			

}
