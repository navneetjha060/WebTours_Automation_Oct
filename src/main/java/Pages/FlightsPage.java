package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import Utilities.FrameSwitch;

public class FlightsPage extends BaseClass {

	// Define Page References
	FrameSwitch fs = new FrameSwitch();

	// Define WebElements|Locators
	@FindBy(xpath = "//b[text()='Find Flight']")
	private WebElement findFlightBaner;

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

}
