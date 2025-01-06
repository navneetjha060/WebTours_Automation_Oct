package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import Utilities.FrameSwitch;

public class paymentPage extends BaseClass {

	// Define Page References
	FrameSwitch fs = new FrameSwitch();

	// Define WebElements|Locators
	@FindBy(xpath = "//b")
	private WebElement paymentPageLogo;
	
	@FindBy(name = "firstName")
	private WebElement fName;

	@FindBy(name = "lastName")
	private WebElement lName;
	
	@FindBy(name = "address1")
	private WebElement streetAddress;
	
	@FindBy(name = "address2")
	private WebElement zip;
	
	@FindBy(name = "pass1")
	private WebElement passName;
	
	@FindBy(name = "creditCard")
	private WebElement creditCardNumber;
	
	@FindBy(name = "expDate")
	private WebElement expDateValue;
	
	@FindBy(name = "saveCC")
	private WebElement save;
	
	@FindBy(name = "buyFlights")
	private WebElement contBtn;

	// Define Constructor

	public paymentPage() {
		PageFactory.initElements(driver, this);

	}

	// Define Methods

	// Validate Baner
	public boolean validatePaymentPageBaner() {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		return paymentPageLogo.isDisplayed();
	}
	
	// Enter Payment Details
	public InvoicePage enterPaymentDetails() throws InterruptedException {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		streetAddress.sendKeys("Wakad");
		zip.sendKeys("411057");
		creditCardNumber.sendKeys("58768");
		expDateValue.sendKeys("02/26");
		save.click();
		contBtn.click();
		Thread.sleep(2000);
		return new InvoicePage();
		
	}

}
