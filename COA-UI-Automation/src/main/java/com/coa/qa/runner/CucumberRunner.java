package com.coa.qa.runner;
import com.coa.qa.framework.commons.ReportHelper;
import com.coa.qa.framework.helper.WebDriverFactory;

import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions (monochrome = false,
features = "src\\test\\resources\\features",

glue = {"com.coa.qa.framework.actions","com.coa.qa.framework.commons","com.coa.qa.framework.database","com.coa.qa.framework.helper",
		"com.coa.qa.properties","com.coa.qa.framework","com.coa.qa.stepdefinitions"},

plugin = {"pretty",
"json:target/json-reports/CucumberTestReport.json"},

		tags = {"@calCulator"}

		)

public class CucumberRunner {


    public TestNGCucumberRunner testNGCucumberRunner;
    //	@Parameters(value={"browser"})

    @BeforeTest(alwaysRun = true)
    public void setUpClass() {
//       WebDriverFactory.initiateDriver();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "COA", description = "COA Feature", dataProvider = "features")
    public void authenticationFeature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @After
    public void screenshot(Scenario sc) {
    	WebDriverFactory.endTestScreenshots(sc);
    	
    }

    
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        ReportHelper.generateCucumberReport();
    }

    
//    @AfterSuite(alwaysRun=true)
//    public void generateHTMLReports() {
//        com.coa.qa.framework.helper.WebDriverFactory.quitDriver();
////        ReportHelper.generateCucumberReport();
//        FeatureCount.countFeatures(Props.getDBCreds("TestRunStats"));

//    }


}