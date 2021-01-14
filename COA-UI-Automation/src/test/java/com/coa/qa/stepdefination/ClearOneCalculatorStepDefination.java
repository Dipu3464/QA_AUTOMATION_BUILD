package com.coa.qa.stepdefination;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.coa.qa.framework.database.DatabaseConnection;
import com.coa.qa.framework.helper.BaseTest;
import com.coa.qa.pageObj.ClearOneCalculator;
import com.coa.qa.properties.ClearOneCalculatorProperties;
import com.coa.qa.properties.Props;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClearOneCalculatorStepDefination extends BaseTest {
	
	ClearOneCalculator calculator = new ClearOneCalculator();
	
	DatabaseConnection dbConn = new DatabaseConnection();
	
  @Given("^User nevigate to QuickBase SignIn Page")
  public void User_nevigate_to_QuickBase_SignIn_Page() throws Throwable {
	  
	  navigationObj.navigateTo(ClearOneCalculatorProperties.quickBaseURL);
	  
	  
  }

  @And("^User Provide Email Or Username")
  public void User_Provide_Email_Or_Username() throws Throwable {
	  
	  calculator.enterEmail();
	  
	  
  }

  @And("^User provide Password")
  public void User_provide_Password() throws Throwable {
	  
	  calculator.enterPassword();
	  
	  
	  
  }

  @Then("^User Click On SignIn button")
  public void User_Click_On_SignIn_button() throws Throwable {
	  
	  
	  calculator.signInClick();
	  
	  
  }
  
  @Given("^User Click On Clear One Debt button")
  public void User_Click_On_Clear_One_Debt_Button() throws Throwable{
	  
	  calculator.clearOnedebt();
	  
  }

 @And("^User Nevigate To Client")
 public void User_Nevigate_To_Client() throws Throwable{
	 
	 calculator.nevigateClient();
	 
 }
  
 @And("^User Search For Client")
 public void User_Search_For_Client() throws Throwable{
	 
	 calculator.searchClient();
	 
	 
 }
 
 @And("^User Click On Client Record")
 public void User_Click_On_Client_Record() throws Throwable{
	 
	 calculator.clientrecord();
	 
	 
 }
 
 @Then("^User Click On New Calculator")
 public void User_Click_On_New_Calculator() throws Throwable{
	 
	 
	 calculator.newCalculator();
	 
	 
 }
 @When("^User Move To Advantage point Window")
 public void User_Move_To_Advantage_point_Window() throws Throwable {
	 
	 calculator.moveToAdvantagePointWindow();
 }
 
 @Given("^User Enter Credential")
 public void User_Enter_Credential() throws Throwable{
	 
	 
	 calculator.advantagePointLogIN();
	  
 }

 @Then("^User Click on Log In Now Btn")
 public void User_Click_on_Log_In_Now_Btn() throws Throwable{
	 
	 calculator.logInNow();
	  
 }
 @Given("^User Click On To Calculator 3")
 public void User_Click_On_To_Calculator_3() throws Throwable{
	 
	 calculator.clickNegotitionCalculator();
	 
 }
 @And("^User Move To Negotition Calculator window")
 public void User_Move_To_Negotition_Calculator_window() throws Throwable{
	 
	 calculator.moveToNegotitionCalc();
	 
 }
 @Given("^User Provide appropriate Calculator URL")
 public void User_Provide_appropriate_Calculator_URL() throws Throwable{
	 
	 
	 calculator.directOpenNegotitionCalc();
	 
 }
 @And("^LogIn To Advantage Point")
 public void LogIn_To_Advantage_Point() throws Throwable{
	 
	 calculator.advantageLogIn();
 }
 
 @Given("^User Click On Select Option 1")
 public void User_Click_On_Select_Option_1() throws Throwable{
	 
	 calculator.selectOptionOne();
	 
 }
 
 
 @Then("^Validate Debt Amount for \"([^\"]*)\"$")
 public void validate_Debt_Amount_for(String selectType) throws Throwable {
	 
//	 calculator.optionsDebtAmontValidate(selectType);
	 
	 calculator.optionTwo(selectType);

 }
 
 
 @Given("^Validate Settlement Amount With \\\"([^\\\"]*)\\\"$")
 public void Validate_Settlement_Amount_With (String anyOption) throws Throwable{
	 
	 
//	 calculator.optionTwo(selectType);
	 
	 dbConn.displayDbProperties();
	 
	 
//	 calculator.getSelectOptionsElements(anyOption);
	 
	 
 }

 @When("^User click on select option one")
 public void User_click_on_select_option_one()throws Throwable{
	 
	 
	 calculator.selectOptionOne();
	 
	 
 }
 
 @And("^Get settlement amount from payments field")
 public void Get_settlement_amount_from_payments_field()throws Throwable{
	 
	 calculator.getTotallsettlementamount();
	  
 }
 
 @And("^Get Settlement Amount from Select option One")
 public void Get_Settlement_Amount_from_Select_option_One()throws Throwable{
	 
	 calculator.selectOptionOneElement();
 }
 
 @Then("^Validate settlement Amount With Payment total Amount")
public void  Validate_settlement_Amount_With_Payment_total_Amount()throws Throwable{
	 
	 calculator.validateSettlementAmountWithPaymenttotal();
 }
 
 
 @When("^User Click On Select Option Two$")
 public void user_Click_On_Select_Option_Two() throws Throwable {
     
	 calculator.clickOptionTwo();
 
 }
 
 @When("^Get Settlement Amount Totall From Payments Table$")
 public void get_Settlement_Amount_Totall_From_Payments_Table() throws Throwable {
     
	 calculator.totalPayments();
	 
 }
 
 @When("^Get Settlement Amount From Select Option Two$")
 public void get_Settlement_Amount_From_Select_Option_Two() throws Throwable {
     

	 
 }
 
 
 
 
 
 
 
 
 ////////////////**************///////////////////
 
 
 
 
 
 
 
 
 @Given("^User run a valid query for \"([^\"]*)\"$")
 public void userRunAValidQueryFor(String optinType) throws Throwable {
    	 String url ="jdbc:jtds:sqlserver://MYPC/MYDB;instance=SQLEXPRESS";
	String dbURL = "jdbc:sqlserver:172.27.235.216:1434/COA-BALT-DBDEV\\COABALTSQL02";
	String username = "SLFG\\dhossain";
        String password = "Hos3454#";
        //Load MS SQL JDBC Driver
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //Creating connection to the database
        Connection con = DriverManager.getConnection(dbURL,username,password);
        //Creating statement object
    	Statement st = con.createStatement();
    	String selectquery = "SELECT * FROM dbo.adp";
        //Executing the SQL Query and store the results in ResultSet
    	ResultSet rs = st.executeQuery(selectquery);
    	//While loop to iterate through all data and print results
    	while (rs.next()) {
    		System.out.println(rs.getString("Record Id"));
    	}
        //Closing DB Connection
    	con.close();
	}
 }
