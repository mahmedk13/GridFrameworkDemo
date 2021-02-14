package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FlightSearchPage;
import pages.FlightSearchResultsPage;
import pages.HomePage;
import utilities.DataUtils;

public class FlightSearchTest extends BaseTest {
	
	HomePage hp;
	FlightSearchPage fsp;
	FlightSearchResultsPage fsrp;
	
	@Parameters({"grid", "browser", "url"})
	@BeforeClass
	public void setUp(String grid, String browser, String url) {
		launchBrowser(grid, browser, url);
		hp = new HomePage();

	}
	
	@Test(dataProvider="getData", dataProviderClass = DataUtils.class)
	public void searchFlight(String origin, String destination, String checkinDate, String checkoutDate) {
		fsp = hp.navigateToFlightTab();
		fsrp =fsp.searchFlight(origin, destination, checkinDate, checkoutDate);
		String title = fsrp.fetchTitle();
		System.out.println("Title is "+title);
		Assert.assertTrue(title.contains("Hyderabad"));
	
	}
	
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

}
