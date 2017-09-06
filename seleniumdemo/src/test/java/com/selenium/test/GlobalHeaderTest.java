package com.selenium.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebay.pages.GlobalHeader;
import com.ebay.pages.SearchResultPage;

public class GlobalHeaderTest {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
	}

	@Test
	public void testAdvancedLink() {
		driver.get("http://www.ebay.com");
		GlobalHeader homePage = PageFactory.initElements(driver, GlobalHeader.class);
		Assert.assertEquals("Advanced", homePage.getAdvancedLink().getText());
	}

	@Test
	public void testSearchButton() {
		String searchKeyword = "iphone 7 plus";
		driver.get("https://www.ebay.com");
		GlobalHeader homePage = PageFactory.initElements(driver, GlobalHeader.class);
		homePage.search(searchKeyword);
		SearchResultPage srp = PageFactory.initElements(driver, SearchResultPage.class);
		Assert.assertNotEquals(0, srp.getSearchResultCount());
	}
	
	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}
}
