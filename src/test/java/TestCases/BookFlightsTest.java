package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.FlightsPage;
import Pages.WebTours_HomePage;

public class BookFlightsTest extends BaseClass {

	// Create Page References
	WebTours_HomePage homePage;
	FlightsPage bookFlight;

	// Constructor
	public BookFlightsTest() {
		super();
	}

	@BeforeMethod
	public void steup() throws IOException {
		launchWebTours();
		homePage = new WebTours_HomePage();
		homePage.login("jojo", "bean");
		bookFlight = homePage.clickFlightsBtn();

	}

	@Test()
	public void testValidatePageBaner() {

		String actual = bookFlight.validateBaner();
		String expected = "Find Flight";
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
