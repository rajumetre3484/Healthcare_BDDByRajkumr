package com.healthcare.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/Login.feature",".//Features/Appointment.feature"},
		glue = {"com.healthcare.stepdefinitions","com.healthcare.hooks"},
		dryRun = false,
		publish = true,
		plugin = {"pretty","html:target/cucumber_report/cucmber_report.html"}
		)
public class TestRunner_Junit {

}

