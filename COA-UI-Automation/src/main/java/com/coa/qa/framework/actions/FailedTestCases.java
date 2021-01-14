package com.coa.qa.framework.actions;

public class FailedTestCases extends Exception
	{
	/**
	 * Added serializable varibale to remove warning
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public FailedTestCases() 
	{
		super();
	}
	 
	public FailedTestCases(String message) 
	{
	    super(message);
	    this.message = message;
	}
	 
}
