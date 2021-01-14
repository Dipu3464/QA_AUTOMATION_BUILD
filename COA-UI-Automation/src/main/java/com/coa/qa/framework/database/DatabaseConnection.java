package com.coa.qa.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DatabaseConnection {

//	private Connection connection = null;
//	private Statement statement = null;
//	private ResultSet resultSet = null;
//
//	/**This method is used to create a Connection to the specified db 
//	 * 
//	 * 
//	 * @param dbType - the type of database against which queries are to be executed
//	 * @param creds - Credentials to be used in connecting to the db
//	 * @return Connection  - Connection object to the specified db
//	 */
//	   public void getConnection() {
//		   
//		   String connectionUrl =
//	                "jdbc:sqlserver:172.27.235.216:1434\\COA-BALT-DBDEV\\COABALTSQL02;"
//	                        + "database=Quickbase;"
//	                        + "user=SLFG\\dhossain;"
//	                        + "password=Hos3454#;"
//	                        + "encrypt=true;"
//	                        + "trustServerCertificate=false;"
//	                        + "loginTimeout=30;";
//		   
//
//	        try (Connection connection = DriverManager.getConnection(connectionUrl);
//	                Statement statement = connection.createStatement();) {
//
//	            // Create and execute a SELECT SQL statement.
//	            String selectSql = "SELECT TOP (1000) [Record Id]\n"
//	            		+ "      ,[First Name]\n"
//	            		+ "      ,[Last Name]\n"
//	            		+ "      ,[Pay Date]\n"
//	            		+ "      ,[Minutes]\n"
//	            		+ "      ,[Notes]\n"
//	            		+ "      ,[Date Created]\n"
//	            		+ "  FROM [Quickbase].[dbo].[ADP]";
//	            resultSet = statement.executeQuery(selectSql);
//
//	            // Print results from select statement
//	            while (resultSet.next()) {
//	                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
//	            }
//	        }
//	        catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        
//	        
//
////		      try {
////		    	  
////
////
//////jdbc:sqlserver://ipAddress:portNumber/dbName
////
////		         if(dbType.equals("sqlserver")) {
////
////		            Class.forName("org.postgresql.Driver");
////		            connection = DriverManager
////		                  .getConnection("jdbc:postgresql://" + creds.get("host") + ":5432/" + creds.get("database") + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", creds.get("user"),creds.get("password"));
////
////		         }
//////		            else if(dbType.equals("MySQL")) {
//////
//////		            connection = DriverManager
//////		                  .getConnection("jdbc:mysql://" + creds.get("host") + ":3306/"+creds.get("database")+"?"
//////		                        + "user=" + creds.get("user") + "&password=" + creds.get("password") );
//////		         } 
////		         
////		         return connection;
////
////		      } catch (Exception e) {
////
////		         System.out.println("Exception in establishing DB connection");
////		         e.printStackTrace();
////		         return null;
////
////		      } 
//
//		   }
//
//	
//	
//	
//	
//	
//	
//	
////	public Connection getConnection(String dbType, Map<String,String> creds) {
////
////		try {
////
////			if(dbType.equals("PostGres")) {
////
////				Class.forName("org.postgresql.Driver");
////				connection = DriverManager
////						.getConnection("jdbc:postgresql://" + creds.get("host") + ":5432/" + creds.get("Quickbase") + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", creds.get("SLFG\\dhossain"),creds.get("Hos3454#"));
////
////			} else if(dbType.equals("MySQL")) {
////
////				connection = DriverManager
////						.getConnection("jdbc:mysql://" + creds.get("coa-balt-dbdev\\COABALTSQL02") + ":1434/"+creds.get("Quickbase")+"?"
////								+ "user=" + creds.get("SLFG\\dhossain") + "&password=" + creds.get("Hos3454#") );
////			} 
////			
////			return connection;
////
////		} catch (Exception e) {
////
////			System.out.println("Exception in establishing DB connection");
////			e.printStackTrace();
////			return null;
////
////		} 
////
////	}
//
//	/**This method is used to run queries that retrieve data using executeQuery() method 
//	 * Ex : SELECT
//	 * 
//	 * 
//	 * @param query - the query to be executed as a string 
//	 * @param conn - Connection object to the db against which this query is to be executed
//	 * @return ResultSet obtained from execution of the query
//	 */
//public String query = "Select * from Quickbase.dbo.QB_Leads\n"
//		+ "Where [Record ID#] =27025";
//	public ResultSet queryDB(String query, Connection conn) {
//
//		try {
//
//			statement = conn.createStatement();
//			resultSet = statement.executeQuery(query);
//			return resultSet;
//
//		} catch (Exception e) {
//
//			System.out.println("Exception in executing the query ->"+query);
//			e.printStackTrace();
//			return null;
//
//		} 
//
//	}
//
//	/**This method is used to run queries that use executeUpdate() method
//	 * Ex : INSERT, DELETE
//	 * 
//	 * @param query - the query to be executed as a string 
//	 * @param conn - Connection object to the db against which this query is to be executed
//	 * 
//	 */
//
//	public void runExecuteUpdate(String query, Connection conn) {
//		try {
//
//			statement = conn.createStatement();
//			statement.executeUpdate(query);
//
//		} catch (Exception e) {
//
//			System.out.println("Exception in executing the query "+query);
//			e.printStackTrace();
//
//		} 
//
//	}
//	
//	/**This method closes the resources used in querying a db
//	 *
//	 * 
//	 */
//
//	public void close() {
//
//		try {
//
//			if (resultSet != null) {
//				resultSet.close();
//			}
//
//			if (statement != null) {
//				statement.close();
//			}
//
//			if (connection != null) {
//				connection.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	
	
	private java.sql.Connection con = null;
    private final String url = "jdbc:microsoft:sqlserver://";
    private final String serverName = "localhost";
    private final String portNumber = "1434";
    private final String databaseName = "Quickbase";
    private final String userName = "SLFG\\dhossain";
    private final String password = "Hos3454#";

    // Constructor
    public DatabaseConnection() {
    }

    private String getConnectionUrl() {
        return url + serverName + ":" + portNumber + ";databaseName=" + databaseName ;
    }

    private java.sql.Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            con = java.sql.DriverManager.getConnection(getConnectionUrl(), userName, password);
            if (con != null) {
                System.out.println("Connection Successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return con;
    }

    public void displayDbProperties() {
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet rs = null;
        try {
            con = this.getConnection();
            if (con != null) {
                dm = con.getMetaData();
                System.out.println("Driver Information");
                System.out.println("\tDriver Name: " + dm.getDriverName());
                System.out.println("\tDriver Version: " + dm.getDriverVersion());
                System.out.println("\nDatabase Information ");
                System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
                System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());
                System.out.println("Avalilable Catalogs ");
                rs = dm.getCatalogs();
                while (rs.next()) {
                    System.out.println("\tcatalog: " + rs.getString(1));
                }
                rs.close();
                rs = null;
                closeConnection();
            } else {
                System.out.println("Error: No active Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm = null;
    }

    private void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
