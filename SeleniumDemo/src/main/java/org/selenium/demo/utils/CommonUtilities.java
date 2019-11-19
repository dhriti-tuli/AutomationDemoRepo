package org.selenium.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommonUtilities {

	public static String userDirectory = System.getProperty("user.dir");
	public static Date date;
	public static int year;
	public static int day;
	public static int month;
	public static long time;
	public static Timestamp ts;
	public static ExtentReports report;
	public static ExtentTest test;
	public static final String CONFIG_PATH = userDirectory + "/src/main/Resources/config/config.properties";
	public static Properties prop;
	public static WebDriver driver;
	public String status;
	static DateFormat dateFormat;
	static DateFormat timeFormat;

	static {
		String exePath = userDirectory + "/src/main/Resources/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.get("http://www.bestbuy.com");

		try {
			InputStream input = new FileInputStream(CONFIG_PATH);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		date = Calendar.getInstance().getTime();
		dateFormat = new SimpleDateFormat("yyyymmdd");
		timeFormat = new SimpleDateFormat("hhmmss");
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);
		String extentReportFileName = "BestBuyReport_" + strDate + "_" + strTime + ".html";
		String extentReportPath = userDirectory+prop.getProperty("extent.report.path") + extentReportFileName;
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		year = calendar.get(Calendar.YEAR);
		// Add one to month {0 - 11}
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		report = new ExtentReports(extentReportPath);
		report.flush();
	}

	public static void takeScreenshot(WebDriver driver, String fileName, String status) {
		date = Calendar.getInstance().getTime();
		time = date.getTime();
		ts = new Timestamp(time);
		String screenshotFilePath = "";
		String finalPath = "";
		if (status.equalsIgnoreCase("PASS")) {
			screenshotFilePath = prop.getProperty("screenshots.passed.file");
		} else if (status.equalsIgnoreCase("FAIL") || (status.equalsIgnoreCase("SKIP"))) {
			screenshotFilePath = prop.getProperty("screenshots.failed.file");
		} else {
			// throw error
		}
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		dateFormat = new SimpleDateFormat("yyyymmdd");
		timeFormat = new SimpleDateFormat("hhmmss");
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);
		finalPath = userDirectory + screenshotFilePath + year + "/" + month + "/" + day + "/" + fileName + "_" + strDate
				+ "_" + strTime + ".png";
		File destFile = new File(finalPath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}