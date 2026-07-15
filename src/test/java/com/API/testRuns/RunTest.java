package com.api.testRuns;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {
				"src/test/resources/features/01_SignUp.feature",
				"src/test/resources/features/02_UserManagement.feature"
				},
		glue = {"com.api.stepDefinitions"},
		dryRun = false,
		monochrome = false,
		plugin = {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunTest extends AbstractTestNGCucumberTests{

}


//"src/test/resources/features/02_UserManagement.feature",
//"src/test/resources/features/03_AccountController.feature"
//"src/test/resources/features/01_SignUp.feature"