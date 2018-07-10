package com.ebay.selenium.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebay.selenium.page.SeleniumDropDownDemo;

public class SelectPageTest {
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesan\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesan\\Downloads\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"D:/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void selectSamples()
	{
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
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
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
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
		WebDriverWait wait = new WebDriverWait(driver,TimeUnit.MILLISECONDS.toSeconds(50000) );
		wait.until(ExpectedConditions.elementToBeClickable(seleniumDropDownDemo.getPrintAllElement()));
		seleniumDropDownDemo.clickPrintAllElement();
		wait.until(ExpectedConditions.textToBePresentInElement(seleniumDropDownDemo.getMultiSelectResultElement(), "Options selected are : "+sb.toString()));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeSelected(seleniumDropDownDemo.getPrintAllElement()));
		
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
