package Pages;

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

}
