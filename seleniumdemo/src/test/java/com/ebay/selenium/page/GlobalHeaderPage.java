package com.ebay.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalHeaderPage {

	@FindBy(id = "gh-ac")
	private WebElement searchText;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;
	
	@FindBy(id = "gh-as-a")
	private WebElement advancedLink;

	@FindBy(id = "akdjfalkdsjf")
	private WebElement sample;
	
	@FindBy(id = "s0-container")
	private WebElement categoryContainer;
	
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
	
	public WebElement getCatUlElement() {
		return categoryContainer;
	}
	
	public List<WebElement> getCatLiElements() {
		return categoryContainer.findElements(By.className("hl-cat-nav__js-tab"));
	}
	
	public void clickMototsCatLiElement() {
		List<WebElement> webElements = categoryContainer.findElements(By.className("hl-cat-nav__js-tab"));
		webElements.get(0).click();
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)));
//		driver.findElement(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)).click();

		//webElements.get(0).get
	}
}
