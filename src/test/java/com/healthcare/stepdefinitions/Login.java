package com.healthcare.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.healthcare.factory.BrowserFactory;
import com.healthcare.pageobject.Loginpage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	Loginpage lp;
	
	@Given("User enter the url as {string}")
	public void user_enter_the_url_as(String Url) {
	   driver=BrowserFactory.getDriver();
	   driver.get(Url);
	}
	@When("User enter the username as {string}")
	public void user_enter_the_username_as(String Uname) {
	 lp=new Loginpage(driver);
	 lp.setTxtUsername(Uname);
	}
	@And("User enter the password as {string}")
	public void user_enter_the_password_as(String pwsd) {
	    lp.setTxtPassword(pwsd);
	}
	@And("User click on the login button")
	public void user_click_on_the_login_button() {
	   lp.setBtnLogin();
	}
	@Then("User should navigate to the make appointment page")
	public void user_should_navigate_to_the_make_appointment_page() {
	    Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Make Appointment']")).getText(), "Make Appointment");
	}
	@Then("Proper error message should displayed")
	public void proper_error_message_should_displayed() {
	 Assert.assertEquals(driver.findElement(By.xpath("//p[@class='lead text-danger']")).getText(), "Login failed! Please ensure the username and password are valid.");
	}

	

}
