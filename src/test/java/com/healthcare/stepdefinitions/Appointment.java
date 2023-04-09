package com.healthcare.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.healthcare.factory.BrowserFactory;
import com.healthcare.pageobject.Appointmentpage;
import com.healthcare.utilities.Readconfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Appointment {
	WebDriver driver;
	Appointmentpage ap;
	
	@When("User enters the all the field")
	public void user_enters_the_all_the_field() throws IOException {
	   driver=BrowserFactory.getDriver();
	   
	   ap=new Appointmentpage(driver);
	   ap.setDropDown("Hongkong CURA Healthcare Center");
	   ap.setClickReadmission();
	   ap.setRadioMedicaid();
	   ap.setDatePicker(Readconfig.initializeproperties().getProperty("date"));
	   ap.setTxtComment(Readconfig.initializeproperties().getProperty("comments"));

	}
	@And("Click on the book appointment button")
	public void click_on_the_book_appointment_button() {
      ap.setBtnBookappointment();
	}
	@Then("Appointment confirmation message should be displayed.")
	public void appointment_confirmation_message_should_be_displayed() {
	 Assert.assertEquals(ap.setCheckConfirmation(), "Appointment Confirmation");
	}

}

