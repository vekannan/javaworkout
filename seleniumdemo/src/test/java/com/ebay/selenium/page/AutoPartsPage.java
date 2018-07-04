package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoPartsPage {
	@FindBy(className = "b-pageheader__text")
	private WebElement searchResultHeader;

	public WebElement getSearchResultHeader() {
		return searchResultHeader;
	}
}
