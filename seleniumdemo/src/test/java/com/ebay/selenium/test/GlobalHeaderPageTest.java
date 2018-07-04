package com.ebay.selenium.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebay.selenium.page.GlobalHeaderPage;
import com.ebay.selenium.page.SearchResultPage;

public class GlobalHeaderPageTest {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajbhoop/Downloads/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void testAdvancedLink() {
		driver.get("http://www.ebay.com");
		GlobalHeaderPage globalHeaderPage = PageFactory.initElements(driver, GlobalHeaderPage.class);
		Assert.assertEquals("Advanced", globalHeaderPage.getAdvancedLink().getText());
	}

	@Test
	public void testSearchButton() {
		String searchKeyword = "iphone 7 plus";
		driver.get("https://www.ebay.com");
		GlobalHeaderPage globalHeaderPage = PageFactory.initElements(driver, GlobalHeaderPage.class);
		globalHeaderPage.search(searchKeyword);
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
