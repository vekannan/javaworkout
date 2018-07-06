package com.ebay.selenium.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
		se.selectByValue("Wednesday");
		WebElement option = se.getFirstSelectedOption();
		WebElement ResulteElement = seleniumDropDownDemo.getResultElement();
		String result_text = ResulteElement.getText();
		Assert.assertTrue(result_text.equals("Day selected :- "+option.getText()));
		List<WebElement> l = se.getOptions();
		Assert.assertTrue(l.size() > 0);
	}
	
	@Test
	public void multiSelectExample() {
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		SeleniumDropDownDemo seleniumDropDownDemo = PageFactory.initElements(driver, SeleniumDropDownDemo.class);
		WebElement element = seleniumDropDownDemo.getMultiSelectElement();
		Select se=new Select(element);
		se.selectByIndex(0);
		se.selectByValue("Washington");
		List<WebElement> l = se.getAllSelectedOptions();
		StringBuilder sb = new StringBuilder();
		for(WebElement el : l) {
			sb.append(el.getText());
			sb.append(",");
		}
		sb.setLength(Math.max(sb.length() - 1, 0));
		
		seleniumDropDownDemo.clickPrintAllElement();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		String result_text = seleniumDropDownDemo.getMultiSelectResultElement().getText();
		
		Assert.assertTrue(result_text.equals("Options selected are : "+sb.toString()));
	}
	
	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}
}
