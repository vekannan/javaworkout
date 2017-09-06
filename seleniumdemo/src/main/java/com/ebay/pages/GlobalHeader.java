package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalHeader {

	@FindBy(id = "gh-ac")
	private WebElement searchText;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;
	
	@FindBy(id = "gh-as-a")
	private WebElement advancedLink;

	@FindBy(id = "akdjfalkdsjf")
	private WebElement sample;
	
	/**
	 * Enters search keyword in the search text box and clicks search button
	 * @param searchKeyword
	 */
	public void search(String searchKeyword) {
		searchText.sendKeys(searchKeyword);
		searchButton.click();
	}
	
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getAdvancedLink() {
		return advancedLink;
	}
}
