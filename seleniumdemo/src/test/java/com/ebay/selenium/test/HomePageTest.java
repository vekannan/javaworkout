package com.ebay.selenium.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebay.selenium.page.HomePage;

public class HomePageTest {
	
	

	@Test
	public void testShopByCategoryDropDownText() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajbhoop/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		System.out.println(homePage.getShopByCategoryText());
	}
}
