package com.ebay.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id = "gh-shop-a")
	private WebElement shopByCategory;
	
	public String getShopByCategoryText() {
		return shopByCategory.getText();
	}
}
