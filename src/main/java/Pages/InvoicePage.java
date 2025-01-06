package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import Utilities.FrameSwitch;

public class InvoicePage extends BaseClass {

	// Define Page References
	FrameSwitch fs = new FrameSwitch();

	// Define WebElements|Locators

	@FindBy(xpath = "//b[text()='Invoice']")
	private WebElement invoicePageBaner;

	@FindBy(xpath = "//b[text()='Thank you for booking through Web Tours.']")
	private WebElement thanksMessage;

	// Define Constructor

	public InvoicePage() {
		PageFactory.initElements(driver, this);

	}

	// Define Methods

	// Validate Page Banner
	public boolean validateInvoiceBaner() {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		return invoicePageBaner.isDisplayed();

	}

	// Validate Thanks Message
	public String validateThanksMessage() {
		fs.switchParentFrame();
		fs.switchFrameName("info");
		return thanksMessage.getText();

	}

}
