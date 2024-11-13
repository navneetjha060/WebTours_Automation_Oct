package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.captureScreenShot;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("------------Test Started------------" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--------Test Passed Successfully---------"+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("--------!!!!! Test Failed !!!!!!--------"+ result.getName());
		captureScreenShot SS = new captureScreenShot();
		try {
			SS.captureSS(result.getName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------Test Skipped-------"+ result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("------Test Failed due to timeout issue-------"+ result.getName());
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
