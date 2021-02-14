package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.HotelSearchPage;
import pages.HotelSearchResultsPage;
import utilities.DataUtils;

public class HotelSearchTest extends BaseTest {
	
	HomePage hp;
	HotelSearchPage hsp;
	HotelSearchResultsPage hsrp;
	
	@BeforeTest
	public void init() {

	}
	
	@Parameters({"grid","browser", "url"})
	@BeforeClass
	public void setUp(String grid, String browser, String url) {
		launchBrowser(grid, browser, url);
		hp = new HomePage();
	}
	
	

	
	@Test(dataProvider="getData", dataProviderClass = DataUtils.class)
	public void searchHotel(String destination, String checkinDate, String checkoutDate) {
		hsp = hp.navigateToHotelTab();
		hsrp = hsp.searchHotel(destination, checkinDate, checkoutDate);
		String title = hsrp.fetchTitle();
		System.out.println("title is "+title);
		Assert.assertTrue(title.contains("Hyderabad"));
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
