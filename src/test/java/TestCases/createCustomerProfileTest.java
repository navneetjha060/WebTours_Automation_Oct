package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.WebTours_HomePage;
import Pages.customerProfilePage;
import Utilities.ReadExcelData;

public class createCustomerProfileTest extends BaseClass {

	// Create Page References
	WebTours_HomePage homePage;
	customerProfilePage cp;

	// Constructor
	public createCustomerProfileTest() {
		super();
	}

	@BeforeMethod
	public void steup() throws IOException {
		launchWebTours();
		homePage = new WebTours_HomePage();
		cp = new customerProfilePage();

	}

	// Provide Test Cases
	@Test(priority = 1)
	public void validateCustomerProfilePageLabelTest() throws InterruptedException {
		cp = homePage.clickSignUp();
		Assert.assertTrue(cp.customerPageLabel());

	}

	@Test(priority = 2, dataProviderClass = ReadExcelData.class, dataProvider = "readDataValues")
	public void createCustomerTest(String Uname, String Pass, String Fname, String Lname,String Add1, String Zip)
			throws InterruptedException {
		cp = homePage.clickSignUp();
		String res = cp.addDetails(Uname, Pass, Fname, Lname, Add1, Zip);
		Thread.sleep(4000);
		if (res.contains("Thank you, ")) {
			System.out.println("Data created successfully");
			Assert.assertTrue(true);
		}

		else if (res.contains("First time registering?")) {
			System.out.println("Data creation failed");
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
