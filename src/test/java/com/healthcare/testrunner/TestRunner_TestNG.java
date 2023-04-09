package com.healthcare.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {".//Features/Login.feature",".//Features/Appointment.feature"},
		glue = {"com.healthcare.stepdefinitions","com.healthcare.hooks"},
		dryRun = false,
		publish = true,
		plugin = {"pretty","html:target/cucumber_report/cucmber_report.html"}
		)

public class TestRunner_TestNG extends AbstractTestNGCucumberTests {

}
