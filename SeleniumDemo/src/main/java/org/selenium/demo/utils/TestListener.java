package org.selenium.demo.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends CommonUtilities implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName().toString().trim();
		//ITestContext context = result.getTestContext();
		//WebDriver driver = (WebDriver) context.getAttribute("driver");
		status = "FAIL";
		takeScreenshot(driver, methodName, status);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		status = "SKIP";
		takeScreenshot(driver, methodName, status);

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		status = "PASS";
		takeScreenshot(driver, methodName, status);

	}

}
