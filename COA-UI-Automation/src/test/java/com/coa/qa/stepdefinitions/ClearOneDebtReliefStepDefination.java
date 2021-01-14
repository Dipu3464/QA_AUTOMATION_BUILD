package com.coa.qa.stepdefinitions;

import com.coa.qa.framework.helper.BaseTest;
import com.coa.qa.pageObj.debtReifForm;
import com.coa.qa.properties.ClearOneDebtReliefProperties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClearOneDebtReliefStepDefination extends BaseTest {
	debtReifForm dbf = new debtReifForm();
	
	
	@Given("^User nevigate to COA Debt Relief form using Chrome Browser")
	public void User_nevigate_to_COA_Debt_Relief_form_using_Chrome_Browser() {

		navigationObj.navigateTo(ClearOneDebtReliefProperties.debtRelief);  

	}

	@When("^User Select Credit Debt Button")
	public void User_Select_Credit_Debt_Button() throws Throwable {
		
		
		dbf.chckCreditDebtBx();
	
	}



	@Then("^User Select Debt Amount")
	public void User_Select_Debt_Amount() throws Throwable {
		
		dbf.debtAmountSelect();
	
	}
	
	
	@Then("^User click See Your Savings In Minutes Button")
	public void User_click_See_Your_Savings_In_Minutes_Button() throws Throwable {
	
		dbf.seeYourSavingsInMinutes();
		
	
	
	}
	
	@Then ("^User Fill Up and submit the Form")
	public void User_Fill_Up_and_submit_the_Form () throws Throwable {
		
		dbf.fillUpForm();
		
		dbf.clickFreeEstBtn();
		
	}
	
	
	@When("^User Enter First Name$")
	public void user_Enter_First_Name() throws Throwable {
		
		dbf.enterFirstName();
	    
	}

	@When("^User Enter Last Name$")
	public void user_Enter_Last_Name() throws Throwable {
	    
		dbf.enterlastName();
	 
	}
	
	@When("^User Enter Phone Number$")
	public void user_Enter_Phone_Number() throws Throwable {
	
		dbf.enterPhoneNumer();
		
	}

	@Then("^User Click on GetFreeSavingsEstimate Button$")
	public void user_Click_on_GetFreeSavingsEstimate_Button() throws Throwable {
	 
		dbf.clickGetFreesavingsEst();
		
	   
	}
	
	@When("^user Enter Street Address$")
	public void user_Enter_Street_Address() throws Throwable {
	   
		dbf.enterStreetAddress();
	}

	@When("^User Enter City$")
	public void user_Enter_City() throws Throwable {
	    
		dbf.enterCity();
	}

	@When("^User Enter Zip Code$")
	public void user_Enter_Zip_Code() throws Throwable {
		
	   dbf.enterZipCode();
	}

	@When("^user Select Date Of Birth$")
	public void user_Select_Date_Of_Birth() throws Throwable {
		
	dbf.enterDateofbirth();
	    
	}

	@Then("^user Click On GetfreeEstBtn$")
	public void user_Click_On_GetfreeEstBtn() throws Throwable {
		
		dbf.clickGetFreeEstSaveBtn();
	   
	}
	
	@Given("^User launch and nevigate to new web$")
	public void user_launch_and_nevigate_to_new_web() throws Throwable {
	    
		dbf.clickGetFreeEstSaveBtn();
	
	}
	
	
	
	
	
	
	
	
	

	
	

}
