package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.WebTours_HomePage;
import Utilities.ReadExcelData;

public class loginTest extends BaseClass {

	// Create Page References
	WebTours_HomePage homePage;

	// Constructor
	public loginTest() {
		super();
	}

	@BeforeMethod
	public void steup() throws IOException {
		launchWebTours();
		homePage = new WebTours_HomePage();

	}

	// Provide Test Cases
	@Test(priority = 1)
	public void loginFunctionTest() {

		String actual = homePage.login("jojo", "bean");
		if (actual.contains("Welcome")) {
			System.out.println("Login Successful ");
			Assert.assertTrue(true);
		}

		else if (actual.contains("Web Tours Error")) {
			System.out.println("Login Failed ");
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2, dataProviderClass = ReadExcelData.class, dataProvider = "readCustomerDataValues")
	public void loginFunctionTestTwo(String Uname, String Pass, String Fname, String Lname, String Add1, String Zip) {
		String actual = homePage.login(Uname, Pass);
		if (actual.contains("Welcome")) {
			System.out.println("Login Successful ");
			Assert.assertTrue(true);
		}

		else if (actual.contains("Web Tours Error")) {
			System.out.println("Login Failed ");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3, dataProviderClass = ReadExcelData.class, dataProvider = "readDemoData")
	public void sampleDataDemoTest(String fName,String lName) {
		
		System.out.println("Test Demo Data ----> "+fName+" "+lName);
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
