package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.BaseClass;
import Utilities.FrameSwitch;

public class FlightsPage extends BaseClass {

	// Define Page References
	FrameSwitch fs = new FrameSwitch();

	// Define WebElements|Locators
	@FindBy(xpath = "//b[text()='Find Flight']")
	private WebElement findFlightBaner;

	@FindBy(xpath = "//input[@name='findFlights']")
	private WebElement continueBtn;

	@FindBy(xpath = "//select[@name='depart']")
	private WebElement departCity;

	@FindBy(xpath = "//select[@name='arrive']")
	private WebElement arrivalCity;

	@FindBy(name = "numPassengers")
	private WebElement passengerCount;

	@FindBy(xpath = "//input[@value='Aisle']")
	private WebElement aisleSeat;

	@FindBy(xpath = "//input[@value='Window']")
	private WebElement windowSeat;

	@FindBy(xpath = "//input[@value='None']")
	private WebElement noneSeat;

	@FindBy(xpath = "//input[@value='First']")
	private WebElement firstClassSeat;

	@FindBy(xpath = "//input[@value='Business']")
	private WebElement businessClassSeat;

	@FindBy(xpath = "//input[@value='Coach']")
	private WebElement coachSeat;

	@FindBy(xpath = "//input[@name='roundtrip']")
	private WebElement roundTripCheck;

	@FindBy(xpath = "//input[@name='departDate']")
	private WebElement departDate;

	@FindBy(xpath = "//input[@name='returnDate']")
	private WebElement returnDate;
	
	@FindBy(xpath = "(//blockquote)[2]")
	private WebElement fligtQuoteMessage;
	
	@FindBy(xpath = "(//input[@name='outboundFlight'])[1]")
	private WebElement flightNumber1;

	// Define Constructor

	public FlightsPage() {
		PageFactory.initElements(driver, this);

	}

	// Define Methods

	// Validate Baner
	public String validateBaner() {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		return findFlightBaner.getText();
	}

	
	// Populate Flight Details
	public void enterFlightDetails() throws InterruptedException {
		fs.switchParentFrame();
		fs.switchFrameName("info");

		Select selectDepart = new Select(departCity);
		selectDepart.selectByValue("Los Angeles");
		//Thread.sleep(3000);

		Select selectArrive = new Select(arrivalCity);
		selectArrive.selectByValue("Paris");
		//Thread.sleep(3000);

		passengerCount.clear();
		passengerCount.sendKeys("1");
		//Thread.sleep(3000);

		windowSeat.click();
		//Thread.sleep(3000);

		businessClassSeat.click();
		//Thread.sleep(3000);

		//roundTripCheck.click();
		//Thread.sleep(3000);
		
		departDate.clear();
		departDate.sendKeys("05/12/2024");
		//Thread.sleep(3000);
		
		returnDate.clear();
		returnDate.sendKeys("10/12/2024");
		//Thread.sleep(3000);

	}

	// Click Continue Btn
	public String clickContinue() throws InterruptedException {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		continueBtn.click();
		//Thread.sleep(3000);
		return fligtQuoteMessage.getText();
		
	}
	
	public void selectFlightNumber() throws InterruptedException {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		flightNumber1.click();
		//Thread.sleep(3000);
	}

}
