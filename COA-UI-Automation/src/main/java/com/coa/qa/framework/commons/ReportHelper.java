package com.coa.qa.framework.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import java.net.InetAddress;

import net.masterthought.cucumber.*;

public class ReportHelper {

	public static void generateCucumberReport() {

		try{

			Properties config;
			config = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config/config.properties");

			config.load(ip);

			File reportOutputDirectory = new File("target");
			ArrayList<String> jsonFiles = new ArrayList<String>();
			jsonFiles.add("target/json-reports/CucumberTestReport.json");

//			File[] files = new File("target/json-reports/").listFiles();
//			for(int i =0; i<files.length;i++){
//				if(files[i].isFile()){
//					System.out.println(files[i].getName());
//					jsonFiles.add(files[i].getName());
//					System.out.println(jsonFiles.get(0).getBytes());
//				}
//			}


//			int fileSize = new File("target/json-reports/").listFiles().length;
//			System.out.println("FIle Size " + fileSize);
//			ArrayList<String> jsonFiles = new ArrayList<String>();
////			jsonFiles.addAll("target/json-reports/CucumberTestReport.json");
//			for(int i =0; i<fileSize;i++){
//				System.out.println(new File("target/json-reports/").getName());
//				jsonFiles.add(new File("target/json-reports/").getName());
//			}


			String projectName = config.getProperty("project");

			Configuration configuration = new Configuration(reportOutputDirectory, projectName); 

			configuration.addClassifications("Platform", System.getProperty("os.name"));
			//			configuration.addClassifications("Browser", "Browserless");
			configuration.addClassifications("Environment", config.getProperty("env"));

			configuration.addClassifications("Browser", config.getProperty("browserType") + "-" + config.getProperty("mode"));
			configuration.addClassifications("Branch", "Master");
			configuration.addClassifications("Host IP", InetAddress.getLocalHost().getHostAddress().trim());

			//        // optionally add metadata presented on main page via properties file
			//        List<String> classificationFiles = new ArrayList<String>();
			//        classificationFiles.add("src/test/resources/config/config.properties");
			//        configuration.addClassificationFiles(classificationFiles);

			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

			//  These are to create a subject line in Emailable report       

			Reportable reports = reportBuilder.generateReports();
			//        System.out.println("Reports -> "+reports.toString());
			int totalPassOrFail = reports.getFailedFeatures();
			//        System.out.println("Total -> "+totalPassOrFail);

			if(totalPassOrFail <= 0){

				File file = new File(System.getProperty("user.dir") + "/PassOrFailFile.txt");
				//Write Content
				FileWriter writer = new FileWriter(file);
				writer.write("Test Pass");
				writer.close();     

			}else if(totalPassOrFail > 0) {

				File file = new File(System.getProperty("user.dir") + "/PassOrFailFile.txt");
				//Write Content
				FileWriter writer = new FileWriter(file);
				writer.write("Test Fail");
				writer.close(); 

			} 

		}catch(Exception e){
			System.out.println("Exception in  generating Cucumber Report -> " + e);
		}
	}

}