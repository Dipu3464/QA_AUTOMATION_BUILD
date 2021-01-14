package com.coa.qa.properties;

public interface ClearOneCalculatorProperties {

	public static String quickBaseURL = "https://clearonedebt.quickbase.com/db/main?a=SignIn";
	public static String loginEmailSelectorType = "name";
	public static String loginEmailSelector = "loginid";
	public static String loginEmailValue = "dhossain@clearoneadvantage.com";
	
	public static String passwordSelectorType ="name";
	public static String passwordSelector ="password";
	public static String passwordvalue ="01922Dipu";
	
	public static String signInSelectorType= "id";
	public static String signInSelector= "signin";
	
	public static String clearOneDebtSelectorType ="xpath";
	public static String clearOneDebtSelector ="//body/b[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[3]/a[1]/div[1]";
	
	public static String clientSelectorType ="id";
	public static String clientSelector ="tbl_bdp9uwef7";
	
	public static String clientRecordIdSelectorType ="id";
	public static String clientRecordIdSelector ="matchText_0";
	public static String clientRecordId ="153844";
//	153844(original recorID)
	
	public static String searchBtnSelectorType ="id";
	public static String searchBtnSelector ="tableHomePageSearch";
	
	public static String clientProfileSelectorType ="css";
	public static String clientProfileSelector ="tr.od";
	
	public static String calculatorNewSelectorType ="xpath";
	public static String calculatorNewSelector ="//a[contains(text(),'Calculator (New)')]";
	
	public static String advantagepointUserNameSelectorType ="id";
	public static String advantagepointUserNameSelector ="ctl00_ContentPlaceHolder1_Login1_UserName";
	public static String advantagepointUserName ="dhossain";
	
	public static String advantagepointPasswordSelectorType ="id";
	public static String advantagepointPasswordSelector ="ctl00_ContentPlaceHolder1_Login1_Password";
	public static String advantagepointPassword ="IDbREZF^tL+Omm";
	
	public static String advantagepointLogInSelectorType ="id";
	public static String advantagepointLogInSelector ="ctl00_ContentPlaceHolder1_Login1_LoginButton";
	
	public static String negotitionCalculatorSelectorType ="id";
	public static String negotitionCalculatorSelector ="ctl00_ContentPlaceHolder1__HyperLink_To_Calculator_2";
	
	
	public static String recordId ="1181611";
//	1181611(original recordID)
	public static String negoCalcUrl ="https://iweb.clearoneadvantage.com/Internal_website/Internal/ClearOne/Calculator.aspx?Topbar=0&RecordID="+recordId+"&Cal_ID=11651520";
//  1190179(alter recordID)
	public static String optionOneSelectorType ="xpath";
	public static String optionOneSelector ="//a[@id='ctl00_ContentPlaceHolder1__Creditor_Settlement_Automation__FormView_Settlement_Options_ctl00_BTN_Option']";
	
	public static String optionsSelectorType="css";
	public static String optionsSelector="td.col-sm-5ths";
	
	public static String settelementSelectorType ="class";
	public static String settelementSelector ="pl-2";
	
	public static String settlementFieldSelectorType = "name";
	public static String settlementFieldSelector ="ctl00$ContentPlaceHolder1$_Creditor_Settlement_Automation$_FormView_Settlement_Info$Label_Settlement";
	
	public static String currentBalanceselectorType="xpath"; 
	public static String currentBalanceselector="//span[@id='currentBalanceText']";
	
	
	
	public static String credirInfoSelectortype="css";
	public static String creditorInfoSelector="table.Gridview_Table";
	
	public static String selectorType ="css";
	public static String selector ="span[class=mx-auto]";
	
	public static String optionTwoSelectorType = "id";
	public static String optionTwoSelector ="ctl00_ContentPlaceHolder1__Creditor_Settlement_Automation__FormView_Settlement_Options_ctl01_BTN_Option";
	
	
	
	
	
}
