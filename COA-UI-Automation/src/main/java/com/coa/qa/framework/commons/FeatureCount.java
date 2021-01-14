package com.coa.qa.framework.commons;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.coa.qa.framework.database.DatabaseConnection;

public class FeatureCount {

	static Properties config;

	static long dur = 0;

	static List<Map<String, Object>> scenarioResults = new ArrayList<Map<String, Object>>();

	static String runResult = "Pass";
	
	static String currentTimeEST = CommonMethods.getCurrentTimeEST();

	public static void countFeatures(Map<String, String> creds) {
		//	public static void main(String[] args) {

		try {

			config = new Properties();

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config/config.properties");

//			config.load(ip);

	//		parseJSONReport();

		//	if(config.getProperty("writeToDB").equals("yes")) 
	//			updateResults(creds);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void parseJSONReport() {

		try {

			JSONArray expObject = (JSONArray) (new JSONParser().parse(
					new FileReader(System.getProperty("user.dir") + "/target/json-reports/CucumberTestReport.json")));

			// System.out.println("Feature Count ->" + expObject.size());

			for (int i = 0; i < expObject.size(); i++) {

				//				System.out.println("Feature -> " + (i + 1));

				JSONObject feature = (JSONObject) expObject.get(i);

				if (feature.get("keyword").equals("Feature")) {

					System.out.println("Feature -> " + feature.get("name"));

					JSONArray scenarios = (JSONArray) feature.get("elements");

					for (int j = 0; j < scenarios.size(); j++) {

						JSONObject scenario = (JSONObject) scenarios.get(j);

						if (scenario.get("keyword").equals("Scenario")) {

							Map<String, Object> scenarioMap = new HashMap<String, Object>();

							// System.out.println("Scenario ->" + (j + 1));
							// System.out.println("Scenario ->" + String.valueOf(scenario.get("name")));

							scenarioMap.put("ScenarioName", String.valueOf(scenario.get("name")));
							scenarioMap.put("FeatureName", String.valueOf(feature.get("name")));

							String scenarioTags = " ";

							JSONArray tags = (JSONArray) scenario.get("tags");

							for (int k = 0; k < tags.size(); k++) {

								String tag = String.valueOf(((JSONObject) tags.get(k)).get("name"));
								// System.out.println("Current Tag ->" + tag);
								scenarioTags = scenarioTags.concat(tag);
								scenarioTags = scenarioTags.concat(" ");

								if (tag.contains("@TestCase")) {
									scenarioMap.put("TestCaseID", "C".concat(tag.split("@TestCase")[1]));
								}

							}

							scenarioMap.put("ScenarioTags", scenarioTags);

							boolean scenarioResult = true;

							JSONArray steps = (JSONArray) scenario.get("steps");

							for (int l = 0; l < steps.size(); l++) {
								JSONObject stepResult = (JSONObject) ((JSONObject) steps.get(l)).get("result");
								dur = dur + (long) stepResult.get("duration");
								if (!String.valueOf(stepResult.get("status")).equals("passed")) {
									scenarioResult = false;
									break;
								}
							}

							if (scenarioResult)
								scenarioMap.put("ScenarioResult", "Pass");
							else {
								scenarioMap.put("ScenarioResult", "Fail");
								runResult = "Fail";
							}

							// System.out.println("Scenario Result Map ->" + scenarioMap);
							if(!String.valueOf(scenarioMap.get("ScenarioTags")).contains("@warm_up"))
								scenarioResults.add(scenarioMap);

						}

					}
					// System.out.println("Results -> " + scenarioResults);

					System.out.println("Duration ->" + dur / (1000 * 1000 * 1000));

				}

			}

		} catch (

				Exception e) {
			e.printStackTrace();
		}
	}
//
//	private static void updateResults(Map<String, String> creds) throws SQLException {
//
//		DatabaseConnection dbConn = new DatabaseConnection();
//		Connection conn = dbConn.getConnection("MySQL", creds);
//
//		for(Map<String, Object> tempResult : scenarioResults) {
//			dbConn.runExecuteUpdate(buildQuery(tempResult), conn);
//		}
//
////		conn.close();
//		dbConn.close();
//
//	}

	private static String buildQuery(Map<String, Object> tempResult) {

		String query = "INSERT INTO `qa_testing`.`test_run_stats`\n" + "(\n" +

					"`run_name`,\n" +

					"`tags`,\n" +

					"`test_end_time`,\n" +

					"`duration`,\n" +

					"`run_notes`,\n" +

					"`run_result`,\n" +

					"`module`,\n" +

					"`browser`,\n" +

					"`environment`,\n" +

					"`platform`,\n" +

					"`branch`,\n" +

					"`feature`,\n" +

					"`scenario`,\n" +

					"`scenario_result`,\n" +

					"`test_type`,\n" +

					"`execution_type`,\n" +

					"`test_case_id`,\n" +

					"`scenario_tags`,\n" +

					"`project`\n" +

					")\n" + "\n" +

					"VALUES\n" +

					"\n" + "(\n" +

					"\""

					+ config.getProperty("runName").toUpperCase() +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("tags") +

					"\""

					+ ",\n" +

					"\""

					+ currentTimeEST +

					"\""

					+ ",\n" +

					+ dur / (1000 * 1000 * 1000) +

					",\n" +

					"\""

					+ config.getProperty("runNotes") +

					"\""

					+ ",\n" +

					"\""

					+ runResult +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("module") +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("browserType") +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("env") +

					"\""

					+ ",\n" +

					"\""

					+ System.getProperty("os.name") +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("branch") +

					"\""

					+ ",\n" +

					"\""

					+ tempResult.get("FeatureName")

					+ "\""

					+ ",\n" +

					"\'"

					+ tempResult.get("ScenarioName")

					+ "',\n" +

					"\""

					+ tempResult.get("ScenarioResult")

					+ "\""

					+ ",\n" +

					"\""

					+ config.getProperty("testType") +

					"\""

					+ ",\n" +

					"\""

					+ config.getProperty("executionType") +

					"\""

					+ ",\n" +

					"\""

					+ tempResult.get("TestCaseID")

					+ "\""

					+ ",\n" +

					"\""

					+ tempResult.get("ScenarioTags")

					+ "\""

					+ ",\n" +

					"\""

					+ config.getProperty("project") +

					"\"" +

					");\n" + "\n" + "";

//		System.out.println(query);

		return query;
	}

}