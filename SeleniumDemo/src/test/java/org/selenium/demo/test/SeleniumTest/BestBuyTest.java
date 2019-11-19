package org.selenium.demo.test.SeleniumTest;

import org.selenium.demo.SeleniumDemo.BestBuyFunctions;
import org.selenium.demo.utils.CommonUtilities;
import org.selenium.demo.utils.CustomSoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BestBuyTest extends CommonUtilities {

	BestBuyFunctions functions = new BestBuyFunctions();
	CustomSoftAssert softAssert = new CustomSoftAssert();
	boolean testResult = false;

	@Test(priority = 1, enabled = true)//, /*dataProvider = "TC001DataProvider"*/)
	public void TC001_BestBuy_Country_SearchData(/*String country, String searchKey*/) {
		test = report.startTest("TC001_BestBuy_Country_SearchData");
		softAssert.assertEquals(true, false);
		//return testResult;
	}

	@DataProvider(name = "TC001DataProvider")
	public Object[][] TC001DataProvider() {
		return new Object[][] { { "Canada", "Bear" }, { "Mexico", "Whirlpool" } };
	}

	@AfterTest()
	public void AfterTest() {
		report.flush();
	}

	@AfterMethod()
	public void AfterMethod() {
		report.endTest(test);
	}
}
