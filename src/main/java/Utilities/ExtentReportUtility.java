package Utilities;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports extentReportsUtil() {

		String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("Automation Test Report");
		sparkReporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		return extent;

	}

}
