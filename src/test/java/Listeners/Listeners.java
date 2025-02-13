package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportUtility;
import Utilities.captureScreenShot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listeners implements ITestListener {

	ExtentReports extent = ExtentReportUtility.extentReportsUtil();
	ExtentTest test;
	static Logger Log = LogManager.getLogger(Listeners.class);

	public void onTestStart(ITestResult result) {
		System.out.println("------------Test Started------------" + result.getName());
		test = extent.createTest(result.getName());
		Log.info("Logs-----Test Started------------" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--------Test Passed Successfully---------" + result.getName());
		test.pass("Test Passed Successfully");
		Log.info("Logs-----Test Passed Successfully------------" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("--------!!!!! Test Failed !!!!!!--------" + result.getName());
		test.fail("Test Failed");
		Log.error("Log-------❌ Login failed!"+ result.getName());
		captureScreenShot SS = new captureScreenShot();
		try {
			SS.captureSS(result.getName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------Test Skipped-------" + result.getName());
		test.skip("Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("------Test Failed due to timeout issue-------" + result.getName());
		test.fail("Failed due to timeout issue");
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
