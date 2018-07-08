package com.ebay.selenium.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.selenium.page.AutoPartsPage;
import com.ebay.selenium.page.GlobalHeaderPage;
import com.ebay.selenium.page.SearchResultPage;

public class GlobalHeaderPageTest {

	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesan\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testAdvancedLink() {
		driver.get("http://www.ebay.com");
		GlobalHeaderPage globalHeaderPage = PageFactory.initElements(driver, GlobalHeaderPage.class);
		Assert.assertEquals("Advanced", globalHeaderPage.getAdvancedLink().getText());
		//Assert.assertTrue(globalHeaderPage.getCatLiElements().size() == 12);
	}
	
	@Test
	public void testCategory() {
		driver.get("http://www.ebay.com");
		GlobalHeaderPage globalHeaderPage = PageFactory.initElements(driver, GlobalHeaderPage.class);
		globalHeaderPage.clickMototsCatLiElement();
		AutoPartsPage auto = PageFactory.initElements(driver, AutoPartsPage.class);
		System.out.println(auto.getSearchResultHeader().getText());
		Assert.assertEquals("Auto Parts and Vehicles", auto.getSearchResultHeader().getText());
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
	
	
	@Test
	public void testOverlay() {
		
		driver.get("http://www.ebay.com");
		GlobalHeaderPage globalHeaderPage = PageFactory.initElements(driver, GlobalHeaderPage.class);
		Actions actions = new Actions(driver);
		WebElement mainMenu = globalHeaderPage.navigateToGotorsLink();
		actions.moveToElement(mainMenu);
		WebElement subMenu = globalHeaderPage.navigateToVehicleLink();
		actions.perform();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.MILLISECONDS.toSeconds(50000) );
		wait.until(ExpectedConditions.visibilityOf(globalHeaderPage.catOverlay()));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		
	}
	
	
	

	
	
	
	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}
}
