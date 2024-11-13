package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import Utilities.ElementHighlighter;
import Utilities.FrameSwitch;

public class WebTours_HomePage extends BaseClass {

	// Define Page References
	FrameSwitch fs = new FrameSwitch();

	// Define WebElements|Locators

	@FindBy(xpath = "//input[@name='username']")
	private WebElement Uname;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Pwd;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//blockquote")
	private WebElement loginMessage;

	@FindBy(xpath = "//a[normalize-space()='sign up now']")
	private WebElement signUpNow;

	// Define Constructor

	public WebTours_HomePage() {
		PageFactory.initElements(driver, this);

	}

	// Define Methods

	// Validate Title
	public String homePageTitle() {
		return driver.getTitle();
	}

	// Login Functionality
	public String login(String username, String password) {

		// Provide utility to switch frames

		ElementHighlighter hl = new ElementHighlighter();
		fs.switchFrameName("body");
		fs.switchFrameName("navbar");

		hl.highlightElement(Uname);
		Uname.sendKeys(username);
		hl.highlightElement(Pwd);
		Pwd.sendKeys(password);
		hl.highlightElement(loginBtn);
		loginBtn.click();

		fs.switchParentFrame();
		fs.switchFrameName("info");
		hl.highlightElement(loginMessage);
		String loginStatus = loginMessage.getText();
		return loginStatus;

	}

	public customerProfilePage clickSignUp() {

		fs.switchFrameName("body");
		fs.switchFrameName("info");
		signUpNow.click();
		return new customerProfilePage();
	}

}
