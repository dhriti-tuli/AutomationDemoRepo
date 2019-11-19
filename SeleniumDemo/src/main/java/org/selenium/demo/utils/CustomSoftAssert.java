package org.selenium.demo.utils;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert {
	
	@Override
	public void onAssertFailure(IAssert a) {
		CommonUtilities.takeScreenshot(CommonUtilities.driver, a.getMessage(), "FAIL");
	}

	/*
	 * @Override public void executeAssert(IAssert a) { try { a.doAssert(); } catch
	 * (AssertionError ex) { onAssertFailure(a);
	 * CommonUtilities.takeScreenshot(CommonUtilities.driver, a.getMessage(),
	 * "FAIL"); m_errors.put(ex, a); } }
	 */
}
