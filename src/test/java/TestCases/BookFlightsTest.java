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

	@Test(priority = 1)
	public void testValidatePageBaner() {

		String actual = bookFlight.validateBaner();
		String expected = "Find Flight";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 2)
	public void findFlightTest() throws InterruptedException {
		bookFlight.enterFlightDetails();
		String Actual =bookFlight.clickContinue();
		String Expectecd ="Flight departing from Los Angeles to Paris on 05/12/2024"; 
		Assert.assertEquals(Actual, Expectecd);
	}
	
	
	@Test(priority = 3)
	public void findFlightTest2() throws InterruptedException {
		bookFlight.enterFlightDetails();
		bookFlight.clickContinue();
		bookFlight.selectFlightNumber();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
