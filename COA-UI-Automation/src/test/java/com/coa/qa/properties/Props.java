package com.coa.qa.properties;

	import java.util.HashMap;
	import java.util.Map;

	public class Props {
	 
	    public static Map<String, String> getDBCreds(String db){
	        try {
	            Map<String,String> dbDetails = new HashMap<String, String>();
	            if(db.equalsIgnoreCase("rdsTest")) {
	                System.out.println("Setting rdsTest props");
	                dbDetails.put("host", "snardstest-writer.beaconstreetservices.com");
	                dbDetails.put("user", "snadbtest");
	                dbDetails.put("password", "Stansb3rryRpt");
	                dbDetails.put("database", "snadb");
	            }
	            if(db.equalsIgnoreCase("rdsProd")){
	                System.out.println("Setting rdsProd props");
	                dbDetails.put("host", "snardsprod-writer.beaconstreetservices.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "snadb");
	            }
	            if(db.equalsIgnoreCase("TestRunStats")) {
	                System.out.println("Setting TestRunStats props");
	                dbDetails.put("host", "snardsprod-writer.beaconstreetservices.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "qa_testing");
	            }
	            if(db.equalsIgnoreCase("OData")) {
	                System.out.println("Setting New ODataTest props");
	                dbDetails.put("host", "odatardstest-writer.beaconstreetservices.com");
//	                dbDetails.put("user", "gbodapati");
//	                dbDetails.put("password", "gbodapati@b3rry");
//	                dbDetails.put("database", "odatatest");
////	                dbDetails.put("host", "odatardstest-writer.beaconstreetservices.com");
//////	                dbDetails.put("port", "3306");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "odatatest");
	            }
	            if(db.equalsIgnoreCase("Old_rdsTest")) {
	                System.out.println("Setting rdsTest props");
	                dbDetails.put("host", "test.data.stansberrycloud.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "snadb");
	            }
	            if(db.equalsIgnoreCase("Old_rdsProd")){
	                System.out.println("Setting rdsProd props");
	                dbDetails.put("host", "prod.data.stansberrycloud.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "snadb");
	            }
	            if(db.equalsIgnoreCase("Old_TestRunStats")) {
	                System.out.println("Setting TestRunStats props");
	                dbDetails.put("host", "prod.data.stansberrycloud.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "qa_testing");
	            }
	            if(db.equalsIgnoreCase("Old_OData")) {
	                System.out.println("Setting ODataTest props");
	                dbDetails.put("host", "odata.data.stansberrycloud.com");
	                dbDetails.put("user", "mrahman");
	                dbDetails.put("password", "mrahman@b3rry");
	                dbDetails.put("database", "odata");
	            }
	            if(db.equalsIgnoreCase("PostGres")){
	                System.out.println("Setting PostGres props");
	                dbDetails.put("host", "ec2-35-174-67-244.compute-1.amazonaws.com");
	                dbDetails.put("user", "u2b0j0t9o2u5n0");
	                dbDetails.put("password", "p35d2c9aea77f52a983e52176727c4cf2aee10df981eb29987f276c7ac692f140");
	                dbDetails.put("database", "db2eumdgdbtqbc");
	            }
	          
	            return dbDetails;
	        }catch(Exception e) {
	            System.out.println("Exception in setting credentials for DB connection");
	            e.printStackTrace();
	            return null;
	        }
	    }



	
	
	
	
	
	
	
	
	
	

}
