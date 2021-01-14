package com.coa.qa.framework.helper;//package com.bss.qa.framework.actions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;

import java.util.HashMap;

public class WebDriverFactory {

	public  static RemoteWebDriver driver;
	public  static Properties config ;


	public static void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");


		config.load(ip);
	}


	public static void configureDriverPath() throws IOException {

		if(System.getProperty("os.name").startsWith("Linux")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Mac")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Windows")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}

	}


	public static  RemoteWebDriver initiateDriver()
	{
		try {
			LoadConfigProperty();
			configureDriverPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//		 configures the driver path

		if (config.getProperty("browserType").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			

		} else if (config.getProperty("browserType").equalsIgnoreCase("chrome")) {
//			System.out.println("Driver name : "+);
			
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("profile.default_content_settings.popups", 0);

//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
		}

		return driver;
	}

	public static  void quitDriver()
	{
		driver.quit();
	}

	public static void endTestScreenshots(Scenario scenario){
        if (scenario.isFailed()) {

           try {
//         scenario.write(scenario.getName() + " is Failed");
              final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
              scenario.embed(screenshot, "image/png"); // ... and embed it in
           } catch (WebDriverException e) {
              e.printStackTrace();
           }

        } else {
           try {
//         scenario.write(scenario.getName() + " is pass");
              scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
           } catch (Exception e) {
              e.printStackTrace();
           }
        }
  }

	
	public static  void closeDriver()
	{
		driver.close();
	}

	public static RemoteWebDriver getDriver()
	{
		return driver;
	}


}