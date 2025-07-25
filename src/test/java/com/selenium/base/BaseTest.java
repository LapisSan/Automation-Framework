package com.selenium.base;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.configuration.Theme;*/
import com.selenium.config.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import com.selenium.utils.WebDriverFactory;

import java.io.*;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setUpReport() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Test Execution Report");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@BeforeMethod
	public void setUp()throws IOException{
		configReader.init();
		driver = WebDriverFactory.getDriver(configReader.get("browser"));
		driver.get(configReader.get("url"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

}
