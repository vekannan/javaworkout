package com.ebay.selenium.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.selenium.page.SeleniumDropDownDemo;

public class SelectPageTest {
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesan\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectSamples()
	{
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		SeleniumDropDownDemo seleniumDropDownDemo = PageFactory.initElements(driver, SeleniumDropDownDemo.class);
		WebElement element=seleniumDropDownDemo.getDropDownElement();
		Select se=new Select(element);
		se.selectByIndex(1);
		List<WebElement> l = se.getOptions();
		Assert.assertTrue(l.size() > 0);
	}
	
	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}
}
