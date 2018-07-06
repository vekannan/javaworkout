package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumDropDownDemo {

	@FindBy(id = "select-demo")
	private WebElement dropDown;
	
	@FindBy(className = "selected-value")
	private WebElement selectedResult;
	
	public WebElement getDropDownElement() {
		return dropDown;
	}
	
	public WebElement getResultElement() {
		return selectedResult;
	}
}
