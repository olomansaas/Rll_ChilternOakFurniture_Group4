package com.app.stepdefs;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks {
	public static WebDriver driver;
	ChromeOptions options;  //A class that allows you to set various options and preferences for configuring the behavior of the Chrome browser 
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		options=new ChromeOptions();
		
		driver=new ChromeDriver(options);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.chilternoakfurniture.co.uk/");
		driver.manage().window().maximize();
		
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// capture screen ,  The use of final means that the variable cannot be reassigned.
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			// Attach the screenshot to the report
            scenario.attach(screenshot, "image/png", scenario.getName()); 
		}
		
		driver.quit();
	}
	

}


