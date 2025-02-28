package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.FlightsPage;
import Pages.InvoicePage;
import Pages.WebTours_HomePage;
import Pages.paymentPage;

public class BookFlightsTest extends BaseClass {

	// Create Page References
	WebTours_HomePage homePage;
	FlightsPage bookFlight;
	paymentPage payPage;
	InvoicePage invoice;

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
		bookFlight.enterFlightDetails("Los Angeles", "Paris", "1", "Window", "Coach");
		String Actual = bookFlight.clickContinue();
		String Expectecd = "Flight departing from Los Angeles to Paris on 05/12/2024";
		Assert.assertEquals(Actual, Expectecd);
	}

	@Test(priority = 3)
	public void findFlightSelectFlightTest() throws InterruptedException {
		bookFlight.enterFlightDetails("Los Angeles", "Paris", "1", "Aisle", "First");
		bookFlight.clickContinue();
		bookFlight.selectFlightNumber();
		payPage = bookFlight.clickContinueBtn2();
		Assert.assertTrue(payPage.validatePaymentPageBaner());
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void E2EbookFlightTest() throws InterruptedException {
		bookFlight.enterFlightDetails("Los Angeles", "Paris", "1", "Aisle", "First");
		bookFlight.clickContinue();
		bookFlight.selectFlightNumber();
		payPage = bookFlight.clickContinueBtn2();
		Assert.assertTrue(payPage.validatePaymentPageBaner());
		invoice = payPage.enterPaymentDetails();
		Assert.assertTrue(invoice.validateInvoiceBaner());
		String Expected = "Thank you for booking through Web Tours.";
		String Actual = invoice.validateThanksMessage();
		Assert.assertEquals(Actual, Expected);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
