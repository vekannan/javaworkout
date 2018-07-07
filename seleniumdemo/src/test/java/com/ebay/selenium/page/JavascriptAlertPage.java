package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavascriptAlertPage {
	
	@FindBy(id = "confirm-demo")
	private WebElement dialoage_confirmation_text;

	public void clickAlertButton() {
		
		
	}
	
	public WebElement getConfirmationElementText() {
		return dialoage_confirmation_text;
	}
}
