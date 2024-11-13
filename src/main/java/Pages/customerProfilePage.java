package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class customerProfilePage extends BaseClass {

	// Define WebElements|Locators

	@FindBy(xpath = "//b[normalize-space()='Customer Profile']")
	private WebElement custProfileLabel;

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(name = "passwordConfirm")
	private WebElement confirmPass;

	@FindBy(name = "firstName")
	private WebElement fName;

	@FindBy(name = "lastName")
	private WebElement lName;

	@FindBy(name = "address1")
	private WebElement streetAdd;

	@FindBy(name = "address2")
	private WebElement zip;

	@FindBy(name = "register")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//blockquote")
	private WebElement responseText;

	// Define Constructor

	public customerProfilePage() {
		PageFactory.initElements(driver, this);
	}

	// Define Methods

	// Validate Label
	public boolean customerPageLabel() {
		return custProfileLabel.isDisplayed();
	}

	public String addDetails(String name, String pass, String firstName, String lastName, String sAdd, String Zip) {

		userName.sendKeys(name);

		pwd.sendKeys(pass);

		confirmPass.sendKeys(pass);

		fName.sendKeys(firstName);

		lName.sendKeys(lastName);

		streetAdd.sendKeys(sAdd);

		zip.sendKeys(Zip);

		continueBtn.click();
		
		return responseText.getText();

	}

}
