package org.selenium.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonUtilities {
	
	public static String userDirectory = System.getProperty("user.dir");
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static final String CONFIG_PATH = userDirectory + "/src/main/Resources/config/config.properties";
	public static Properties prop;

	static {
		String exePath = userDirectory + "/src/main/Resources/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bestbuy.com");

		try {
			InputStream input = new FileInputStream(CONFIG_PATH);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		String extentReportFileName = "BestBuyReport_" + ts + ".html";
		String extentReportPath = prop.getProperty("extent.report.path") + extentReportFileName;

		htmlReporter = new ExtentHtmlReporter(extentReportPath);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

	}
}