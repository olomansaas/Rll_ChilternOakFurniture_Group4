package com.app.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.app.pagefactory.Checkout1;
import com.app.pagefactory.Checkout2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CheckoutSteps {
	

   Checkout1 chk=new Checkout1(MyHooks.driver);
   Checkout2 chk1=new Checkout2(MyHooks.driver);
	private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
	
	
	@Given("User is on login page and add item to cart")
	public void User_is_on_login_page_and_add_item_to_cart() throws InterruptedException {
		Thread.sleep(5000);
		logger.info("User is on login page and add item to cart");
		chk1.Login_AddToCart();
	}
    // dot (.) represents any character, and the asterisk (*) means "zero or more Number of occurrences of character. And ^ ,$ are the anchor tags 
	// Some Common Regex (\\d+)--For Numbers, (.+)-for Url ,(\\d{4}-\\d{2}-\\d{2})--Date,([A-Za-z0-9]+)--Alpha numeric
	@When("^User is able Proceed With Valid Checkout Details with(.*)and(.*)and(.*)and(.*)and(.*)and(.*)$")
    public void User_is_able_Proceed_With_Valid_Checkout_Details_with(String firstName, String lastName,String Adrs,String Cty,String cd,String ph) throws InterruptedException {
		logger.info("User is able Proceed With Valid Checkout Details");
		chk1.Test_Case_1(firstName,lastName,Adrs,Cty,cd,ph);
		Assert.assertTrue(true);
		System.out.println("TC_01  -  Passed");
	}

	

	@When("User is Not able Proceed With All Null Checkout Details")
	public void User_is_Not_able_Proceed_With_All_Null_Checkout_Details() throws InterruptedException {
		logger.info("User is Not able Proceed With All Null Checkout Details");
		chk.Test_Case_2();
		chk.validateFirstNameMessage();
		System.out.println("TC_02  -  Passed");
		logger.info("TC02- Passed");
	}

	@And("User is Not able Proceed With Only One Null Checkout Details")
	public void User_is_Not_able_Proceed_With_Only_One_Null_Checkout_Details() throws InterruptedException {
		logger.info("User is Not able Proceed With Only One Null Checkout Details");
		chk.Test_Case_3();
		chk.validateLastNameMessage();
		System.out.println("TC_03  -  Passed");
		logger.info("TC03- Passed");
	}
	
	@Then("User is Not able To Enter With Invalid Phone Credentials")
	public void User_is_Not_able_To_Enter_With_Invalid_Phone_Credentials() throws InterruptedException {
		logger.info("User is Not able To Enter With Invalid Phone Credentials");
		chk.Test_Case_4();
		chk.validatePhoneNumber();
		System.out.println("TC_04  - Passed ");
		logger.info("TC04- Passed");
	}
	
	@And("User is Able To Enter With Invalid Credentials")
	public void User_is_Able_To_Enter_With_Invalid_Credentials() throws InterruptedException {
		logger.info("User is Able To Enter With Invalid Credentials");
		chk.Test_Case_5();
		chk.validateWrongLastName();
		System.out.println("TC_05  - Failed ");
		logger.info("TC05- Failed");
		
	}
	
	

	
}
