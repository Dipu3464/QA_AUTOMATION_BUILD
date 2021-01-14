package com.coa.qa.pageObj;


import org.openqa.selenium.support.ui.Select;

import com.coa.qa.framework.helper.BaseTest;
import com.coa.qa.properties.ClearOneDebtReliefProperties;

public class debtReifForm extends BaseTest implements ClearOneDebtReliefProperties{
	


	
	public void chckCreditDebtBx() throws Throwable{
		waitTimeObj.Thread(3000);
		
		clickObj.click(creditDbtBtnSelectorType,creditDbtBtnSelector);
		
	}

	
	
	public void debtAmountSelect() {
		
		
//		JavascriptExecutor js = (JavascriptExecutor)driver; 
//		js.executeScript(
//		    "document.getElementByclass('gvLocationHorizontalRail').scrollLeft += 250", "");
//	
		
	}
	
	public void seeYourSavingsInMinutes ()throws Throwable {
		
		waitTimeObj.Thread(3000);
		clickObj.click(seeYourSavingsInMinutesType, seeYourSavingsInMinutesSelector);
		
	}
	
	public void fillUpForm() throws Throwable {
		
		waitTimeObj.Thread(4000);
		
		try {
		Select state = new Select(getElementsObj.getElement(stateSelectorType, stateSelector));
		
		state.selectByVisibleText("Maryland");
		
			waitTimeObj.Thread(3000);
			
			inputObj.enterText(emailSelectorType, emailSelectorValue, emailSelector);
			
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}	
	}
	
	public void clickFreeEstBtn () throws Throwable {
		
		waitTimeObj.Thread(4000);
		
		clickObj.click(freeEstBtnSelectorType, freeEstbtnSelector);
		
	
	}
	public void enterFirstName() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(firstNameSelectorType, firstNameSelectorValue, firstNameSelector);
	
	}
	
	public void enterlastName() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(lastNameSelectorType, lastNameSelectorValue, lastNameSelector);
		
	}
	
	public void enterPhoneNumer() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(PhoneNumberSelectorType, PhoneNumberSelectorValue, PhoneNumberSelector);
	}
	
	public void clickGetFreesavingsEst() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		clickObj.click(getFreeSavingsEstSelectorType, getFreeSavingsEstSelector);
	}
	
	public void enterStreetAddress() throws Throwable {
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(streetAddressSelectorType, streetAddressSelectorValue, streetAddressSelector);
		
	}
	public void enterCity() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(citySelectortype, citySelectorValue, citySelectorSelector);
	
	}
	public void enterZipCode() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		inputObj.enterTextForcefully(zipCodeSelectorType, zipCodeSelectorValue, zipCodeSelector);
		
	}
	public void enterDateofbirth() throws Throwable{
		waitTimeObj.Thread(4000);
		
		Select month = new Select(getElementsObj.getElement(dobMonthSelectorType, dobMonthSelector));
		month.selectByValue(dobMonthSelectorValue);
		
		waitTimeObj.Thread(4000);
		
		Select day = new Select(getElementsObj.getElement(dobDaySelectorType, dobDaySelector));
		day.selectByIndex(21);
		
		waitTimeObj.Thread(4000);
		
		Select year = new Select(getElementsObj.getElement(dobYearSelectorType, dobYearselector));
		year.selectByIndex(20);
		

	}
	
	public void clickGetFreeEstSaveBtn() throws Throwable{
		
		waitTimeObj.Thread(4000);
		
		clickObj.click(getFreeSaveEstBtnSelectorType, getfreeSaveEstSelector);
	}
	
	
}
