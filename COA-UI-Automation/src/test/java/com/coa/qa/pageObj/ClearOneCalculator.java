package com.coa.qa.pageObj;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import com.coa.qa.framework.actions.FailedTestCases;
import com.coa.qa.framework.helper.BaseTest;
import com.coa.qa.properties.ClearOneCalculatorProperties;
import cucumber.deps.com.thoughtworks.xstream.mapper.SystemAttributeAliasingMapper;



public class ClearOneCalculator extends BaseTest implements ClearOneCalculatorProperties{

	
	
	
	public void enterEmail() throws Throwable{
		waitTimeObj.Thread(3000);
		
		inputObj.enterText(loginEmailSelectorType, loginEmailValue, loginEmailSelector);
		
		
	}
	
	public void enterPassword() throws Throwable{
		waitTimeObj.Thread(3000);
		
		inputObj.enterText(passwordSelectorType, passwordvalue, passwordSelector);
		
	}
	
	public void signInClick() throws Throwable{
		waitTimeObj.Thread(3000);
		
		clickObj.click(signInSelectorType, signInSelector);
		
		
	}
	
	public void clearOnedebt() throws Throwable{
		waitTimeObj.Thread(4000);
		
		clickObj.click(clearOneDebtSelectorType, clearOneDebtSelector);
		
		
	}
	
	public void nevigateClient() throws Throwable{
		waitTimeObj.Thread(3000);
		
		clickObj.click(clientSelectorType, clientSelector);
		
	}
	
	public void searchClient() throws Throwable{
		waitTimeObj.Thread(3000);
		
		inputObj.enterText(clientRecordIdSelectorType, clientRecordId, clientRecordIdSelector);
		
		
		waitTimeObj.Thread(2000);
		
		clickObj.click(searchBtnSelectorType, searchBtnSelector);
	}
	
	public void clientrecord()  throws Throwable{
		
		waitTimeObj.Thread(3000);
		
		clickObj.click(clientProfileSelectorType, clientProfileSelector);
		
		
	}
	
	public void newCalculator() throws Throwable{
		
		waitTimeObj.Thread(3000);
		
		clickObj.click(calculatorNewSelectorType, calculatorNewSelector);
		
		
	}
	public void moveToAdvantagePointWindow() throws Throwable {
		
		waitTimeObj.Thread(3000);
		
		navigationObj.moveToNextWindow();
		
	}
	

	public void advantagePointLogIN() throws Throwable{
		
		
		waitTimeObj.Thread(2000);
		
		inputObj.enterText(advantagepointUserNameSelectorType, advantagepointUserName, advantagepointUserNameSelector);
		
		waitTimeObj.Thread(2000);
		
		inputObj.enterText(advantagepointPasswordSelectorType, advantagepointPassword, advantagepointPasswordSelector);
		
		waitTimeObj.Thread(2000);
		
		clickObj.click(advantagepointLogInSelectorType, advantagepointLogInSelector);
	
	}
	
	public void logInNow() throws Throwable{
		waitTimeObj.Thread(2000);
		
		
		clickObj.click(advantagepointLogInSelectorType, advantagepointLogInSelector);
		
	}
	public void clickNegotitionCalculator() throws Throwable{
		waitTimeObj.Thread(2000);
		
		clickObj.click(negotitionCalculatorSelectorType, negotitionCalculatorSelector);
		
	}
	public void moveToNegotitionCalc() throws Throwable {
		
		waitTimeObj.Thread(2000);
		navigationObj.moveToNextWindow();
		
	}
	public void directOpenNegotitionCalc() throws Throwable{
		
		
		 navigationObj.navigateTo(ClearOneCalculatorProperties.negoCalcUrl);
		
	}
	public void advantageLogIn() throws Throwable{
		
		waitTimeObj.Thread(2000);
		
		inputObj.enterText(advantagepointUserNameSelectorType, advantagepointUserName, advantagepointUserNameSelector);
		
		waitTimeObj.Thread(2000);
		
		inputObj.enterText(advantagepointPasswordSelectorType, advantagepointPassword, advantagepointPasswordSelector);
		
		waitTimeObj.Thread(2000);
		
		clickObj.click(advantagepointLogInSelectorType, advantagepointLogInSelector);
	}
	
	public void selectOptionOne() throws Throwable{
		
		waitTimeObj.Thread(2000);
		
		clickObj.click(optionOneSelectorType, optionOneSelector);
		
	}
	
	public void getSelectOptionsElements(String anyOption)  throws Throwable{
		
		List<WebElement> options = new ArrayList();
		List<WebElement> allFields = new ArrayList();
		
		options = getElementsObj.getElementList(optionsSelectorType, optionsSelector);
		
		WebElement option = getElementsObj.getElementFromListByContainText(options, anyOption);
		
		allFields = option.findElements(By.cssSelector("span.pl-2"));
//		System.out.println(allFields.size());
		String fieldOne = allFields.get(0).getText();
		String fieldTwo = allFields.get(1).getText();
		String fieldThree = allFields.get(3).getText();
		String fieldFour = allFields.get(4).getText();
//		System.out.println(fieldFour);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void optionsDebtAmontValidate(String selectType) throws Throwable{
		
		
		List<WebElement> selectOptions = new ArrayList();
		List<WebElement> selectOptionOne = new ArrayList();
	
		selectOptions = getElementsObj.getElementList(optionsSelectorType, optionsSelector);
		
		WebElement selectOption = getElementsObj.getElementFromListByContainText(selectOptions, selectType);
			
		selectOptionOne =selectOption.findElements(By.cssSelector("span.pl-2"));
				
//		System.out.println("SIZE:::::: "+ selectOptionOne.size());
			
			WebElement element= getElementsObj.getElement(currentBalanceselectorType, currentBalanceselector);
			 String curentblns = element.getText();
//			 
//			 String debtAmount = selectOptionOne.get(0).getText();
//			 String[] debtAmt = debtAmount.split(":");
//			 System.out.println(debtAmt.length);
//			 System.out.println(debtAmt[0]);
//			 System.out.println(debtAmt[1]);
			String setle = selectOptionOne.get(1).getText();
			 System.out.println(setle);
			 
			 
			if(selectType.equalsIgnoreCase("Select Option #1")) {

			if(selectOptionOne.get(0).getText().contains(curentblns)) {
				System.out.println("Select Option #1: Debt Validation: Success");
				System.out.println("Expected : " + selectOptionOne.get(0).getText() + "Actual : " + curentblns);
			}
			}
			 
		else if(selectType.equalsIgnoreCase("Select Option #2")) {
				
			 if(selectOptionOne.get(0).getText().contains(curentblns)) {
					
					System.out.println("Select Option #2: Debt Validation: Success");
					System.out.println("Expected : " + selectOptionOne.get(0).getText() + "Actual : " + curentblns);											
			 }
			 }
		else if(selectType.equalsIgnoreCase("Select Option #3")) {
					
			 if(selectOptionOne.get(0).getText().contains(curentblns)) {
						
						System.out.println("Select Option #3: Debt Validation: Success");
						System.out.println("Expected : " + selectOptionOne.get(0).getText() + "Actual : " + curentblns);														
			 }
			 }
		else if(selectType.equalsIgnoreCase("Select Option #4")) {
						
			 if(selectOptionOne.get(0).getText().contains(curentblns)) {
							
							System.out.println("Select Option #4: Debt Validation: Success");
							System.out.println("Expected : " + selectOptionOne.get(0).getText() + "Actual : " + curentblns);
			 }
			 }
		else {
					System.out.println("Select Option #: Debt Validation: failed");
					System.out.println("Expected : " + selectOptionOne.get(0).getText() + "Actual : " + curentblns);
					}
				 
				
			
				
						 
			 
				
		}			
			
	
	public void optionTwo(String selectType) throws Throwable{
		
		
		List<WebElement> allTable = new ArrayList();
		List<WebElement> CreditorInfo = new ArrayList();
		List<WebElement> SettelmentAmt = new ArrayList();

		
		
		allTable = getElementsObj.getElementList(credirInfoSelectortype, creditorInfoSelector);
		
		System.out.println(allTable.size());
		
		WebElement elm =getElementsObj.getElementFromListByContainText(allTable, selectType);
		
//	System.out.println(elm.getText());
	
	CreditorInfo= elm.findElements(By.tagName("tr"));
	
	System.out.println(CreditorInfo.size());
	
		WebElement elm1 = getElementsObj.getElementFromListByContainText(CreditorInfo, "Estimated Settlement Amount:");
		
	SettelmentAmt= elm1.findElements(By.tagName("td"));
		
	System.out.println(SettelmentAmt.size());	
	System.out.println(SettelmentAmt.get(3).getText());
	String estsetlamnt = SettelmentAmt.get(3).getText();
	String estimatedSettlementAmount[] = estsetlamnt.split(":");
//	System.out.println(estimatedSettlementAmount[0]);	
	System.out.println(estimatedSettlementAmount[1]);
	String estimateSettlementAmountValue = estimatedSettlementAmount[1];
	System.out.println(estimateSettlementAmountValue);
//		WebElement elm2 = getElementsObj.getElementFromListByContainText(SettelmentAmt, "CI Settlement Amount:");
//		
//		System.out.println(elm2.getText());
//		
//		String sttelementAmt = elm2.getText();
//		
//		System.out.println(sttelementAmt);
	
	List<WebElement> selectOptions = new ArrayList();
	List<WebElement> selectOptionOne = new ArrayList();

	selectOptions = getElementsObj.getElementList(optionsSelectorType, optionsSelector);
	
	WebElement selectOption = getElementsObj.getElementFromListByContainText(selectOptions, "Select Option #1");
		
	selectOptionOne =selectOption.findElements(By.cssSelector("span.pl-2"));
	String setle = selectOptionOne.get(1).getText();
	String settlementAmt[] = setle.split(":");
	
	 System.out.println(settlementAmt[0]);
	 System.out.println(settlementAmt[1]); 
	 String settlementAmount = settlementAmt[1];
	 
	 if(estimateSettlementAmountValue.equalsIgnoreCase(settlementAmount)) {
		 
		 System.out.println("Settelement validation success");
	 }
	 else {System.out.println("Settelement validation Faild");}

	}
	
	
	
	
	
	
	public String getTotallsettlementamount() throws Throwable{
		
		List<WebElement> paymentsfield = new ArrayList();
		
		paymentsfield = getElementsObj.getElementList(selectorType, selector);
		
//		System.out.println(paymentsfield.size());
		
//		System.out.println(paymentsfield.get(0).getText());
//		System.out.println(paymentsfield.get(1).getText());
//		System.out.println(paymentsfield.get(2).getText());
///		System.out.println(paymentsfield.get(3).getText());
//		System.out.println(paymentsfield.get(4).getText());
//		System.out.println(paymentsfield.get(5).getText());
//		System.out.println(paymentsfield.get(6).getText());
//		System.out.println(paymentsfield.get(7).getText());
//		System.out.println(paymentsfield.get(8).getText());
//		System.out.println(paymentsfield.get(9).getText());
//		System.out.println(paymentsfield.get(10).getText());
//		System.out.println(paymentsfield.get(11).getText());
		
		String totall = paymentsfield.get(10).getText();

//		System.out.println("payment fields total amount " + totall);
	
		return totall;
	}
	
	
	
	public String selectOptionOneElement()throws Throwable {
		

		List<WebElement> options = new ArrayList();
		List<WebElement> allFields = new ArrayList();
		
		options = getElementsObj.getElementList(optionsSelectorType, optionsSelector);
		
		WebElement option = getElementsObj.getElementFromListByContainText(options, "Select Option #1");
		
		allFields = option.findElements(By.cssSelector("span.pl-2"));
//  	System.out.println(allFields.size());
//		String fieldOne = allFields.get(0).getText();
		String settlement = allFields.get(1).getText();
//		String fieldThree = allFields.get(3).getText();
//		String fieldFour = allFields.get(4).getText();
//		System.out.println(settlement);
		
		String settlementAmt[] = settlement.split(":");
		String settlementAmount = settlementAmt[1];
//		System.out.println(settlementAmount);
		return settlementAmount;
		
	}
	
	public void validateSettlementAmountWithPaymenttotal() throws Throwable{
		
		String money = getTotallsettlementamount();
		
		String honey = selectOptionOneElement();
		
//		Assert.assertEquals(money, honey);
		Assert.assertEquals(money, honey, "Validation success");
//		System.out.println(money + "&" + honey);
//		
//		if(money.equalsIgnoreCase(honey)) {
//			
//			System.out.println("Validation Success...Settlement Amount is matching with total amount");
//		}
//		else {
//			System.out.println("Validation failed. didn't match total amount on payment section");
//		}
	}
	
	
	
	public void clickOptionTwo() throws Throwable {
		
		waitTimeObj.Thread(2000);
		
		clickObj.click(optionTwoSelectorType, optionTwoSelector);
	}
	
	public void totalPayments() throws Throwable {
		waitTimeObj.Thread(2000);
		List<WebElement> paymentsfield = new ArrayList();
		
		paymentsfield = getElementsObj.getElementList(selectorType, selector);
		System.out.println(paymentsfield.size());
		String totall = paymentsfield.get(10).getText();
		
		System.out.println("payment fields total amount for select option Two " + totall);
		
	}
	
	public void selectOptionTwo() throws Throwable{
		
		List<WebElement> options = new ArrayList();
		List<WebElement> allFields = new ArrayList();
		
		options = getElementsObj.getElementList(optionsSelectorType, optionsSelector);
		
		WebElement option = getElementsObj.getElementFromListByContainText(options, "Select Option #2");
		
		allFields = option.findElements(By.cssSelector("span.pl-2"));
		
		
	}
	
	
	
	
	
	
	
	
	
}
