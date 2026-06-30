package com.runTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/SignUp.feature"},
		glue = {"com.stepDefinitions"},
		dryRun = false,
		monochrome = false,
		plugin = {"pretty"}
)

public class RunTest extends AbstractTestNGCucumberTests{

}
