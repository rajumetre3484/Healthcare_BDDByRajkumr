package com.healthcare.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthcare.utilities.Generic;

public class Appointmentpage {
	
@FindBy(id="combo_facility")
private WebElement dropDown;

@FindBy(id="chk_hospotal_readmission")
private WebElement clickReadmission;

@FindBy(id="radio_program_medicare")
private  WebElement radioMedicare;

@FindBy(id="radio_program_medicaid")
private WebElement radioMedicaid;

@FindBy(id="txt_visit_date")
private WebElement datePicker;

@FindBy(xpath = "//textarea[@name='comment'] ")
private WebElement txtComment;

@FindBy(id="btn-book-appointment")
private WebElement btnBookappointment;

@FindBy(xpath = "//h2[text()='Appointment Confirmation']")
private WebElement checkConfirmation;


WebDriver ldriver;
Generic common;
public  Appointmentpage(WebDriver driver)
{
	this.ldriver=driver;
	PageFactory.initElements(driver, this);
	common=new Generic(driver);
}
public void setDropDown(String optionSelect) {
common.selectOptionInDropdown(dropDown, 30, optionSelect);
}
public void setClickReadmission() {
	common.clickOnElement(clickReadmission, 30);
}
public void setRadioMedicare() {
	common.clickOnElement(radioMedicare, 30);
}
public void setRadioMedicaid() {
	common.clickOnElement(radioMedicaid, 30);
}
public void setDatePicker(String date) {
	common.typeTextInElement(datePicker, 30, date);
}
public void setTxtComment(String Comment) {
	common.typeTextInElement(txtComment, 30, Comment);
}
public void setBtnBookappointment() {
	common.clickOnElement(btnBookappointment, 30);
}
public String setCheckConfirmation() {
  return common.getTextFromElement(checkConfirmation, 30);
}

}

