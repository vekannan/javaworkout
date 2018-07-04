package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

	@FindBy(className = "rcnt")
	private WebElement searchResultCount;

	public WebElement getSearchResultCount() {
		return searchResultCount;
	}
}
