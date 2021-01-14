package com.coa.qa.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqldbConnect {
	
	
public static void main(String[]args) {
	

	
	String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	
	
	String URL ="jdbc:sqlserver://COA-BALT-DBDEV\\COABALTSQL02;databaseName=Quickbase;integratedSecurity=true";
	String userName ="SLFG\\dhossain";
	String password ="Hos3454#";
	
	try {
		
		Connection connection = DriverManager.getConnection(URL, userName, password);
		
		System.out.println("Great....dtabase connection successful.. you are the best... ");

		Statement statment = connection.createStatement();
	
		ResultSet results = statment.executeQuery("SELECT TOP (10) [Record_Id]\r\n"
				+ "      ,[Type]\r\n"
				+ "      ,[Related_Table]\r\n"
				+ "      ,[Related_Id]\r\n"
				+ "      ,[Caller]\r\n"
				+ "      ,[Call_Time]\r\n"
				+ "  FROM [Quickbase].[dbo].[Call_Log]");
		
		while(results.next()) {
			System.out.println(results.getString("Type")+"******"+results.getString("Related_Id"));
		}
	
	} 
	
	
	catch (SQLException e) {
		System.out.println("oops...There is connecting issue.. please check back on the code..");
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 
	

}
