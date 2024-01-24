package com.app.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(   //This annotation is used to provide additional configuration options for Cucumber when running tests.
    features = "src/test/java/features",
    glue = { "com.app.stepdefs" },
    dryRun=false,  // it means you want Cucumber to execute the actual test code associated with the Gherkin's steps during the test run and if you give true it will only provide the steps that are not glued.
    plugin = {
        "html:target/Login_Functionality_Report.html",
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"
    },
    tags="@login"
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
	
	
    
}

//Change SignUp Data & Data driven Xlsx Sheet

//AbstractTestNGCucumberTests- Runs each cucumber scenario found in the features as separated test.