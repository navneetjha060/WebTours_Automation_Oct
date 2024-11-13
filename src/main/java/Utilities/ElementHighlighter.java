package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class ElementHighlighter extends BaseClass {

	public ElementHighlighter() {
		super();
	}

	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'; arguments[0].style.backgroundColor='yellow'",
				element);

	}

}
