package org.selenium.demo.test.SeleniumTest;

import org.selenium.demo.utils.CommonUtilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteSetup  extends CommonUtilities{
	
	

	@BeforeSuite
	public void beforeSuite() {
		/*
		 * String exePath = "../chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", exePath); WebDriver driver =
		 * new ChromeDriver(); driver.get("http://www.bestbuy.com");
		 */
	}

	@AfterSuite
	public void afterSuite() {

	}
}
