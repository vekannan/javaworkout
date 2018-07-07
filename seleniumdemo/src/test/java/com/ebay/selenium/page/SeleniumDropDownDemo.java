package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumDropDownDemo {

	@FindBy(id = "select-demo")
	private WebElement dropDown;
	
	@FindBy(className = "selected-value")
	private WebElement selectedResult;
	
	@FindBy(name = "States")
	private WebElement multiSelect;
	
	@FindBy(className = "getall-selected")
	private WebElement multiSelectedResult;
	
	
	@FindBy(id = "printAll")
	private WebElement printAllButton;
	
	public WebElement getDropDownElement() {
		return dropDown;
	}
	
	public WebElement getResultElement() {
		return selectedResult;
	}
	
	public WebElement getMultiSelectElement() {
		return multiSelect;
	}
	
	public WebElement getMultiSelectResultElement() {
		return multiSelectedResult;
	}
	
	public WebElement getPrintAllElement() {
		return printAllButton;
	}
	
	public void clickPrintAllElement() {
		 printAllButton.click();
	}
	
	
}
