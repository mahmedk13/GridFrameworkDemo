package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelSearchPage extends BasePage {
	
	
	
	@FindBy(css="button[data-stid=location-field-destination-menu-trigger]")
	private WebElement destinationField;
	
	@FindBy(id="location-field-destination")
	private WebElement destinationTxtbx;
	
	@FindBy(id="d1-btn")
	private WebElement checkinCalendar;
	
	@FindBy(css="button[data-stid=apply-date-picker]")
	private WebElement applyBtn;
	
	@FindBy(id="d2-btn")
	private WebElement checkoutCalendar;
	
	@FindBy(css="button[data-testid=submit-button]")
	private WebElement submitBtn;
	
	
	public HotelSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HotelSearchResultsPage searchHotel(String destination, String checkinDate, String checkoutDate) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		//destinationField.click();	
		click(destinationField, "Destination Field");
		
		//destinationTxtbx.sendKeys(destination, Keys.ENTER);
		typeWithEnter(destinationTxtbx, destination, "Destination Text Box");
		
		//checkinCalendar.click();
		click(checkinCalendar, "Checkin Calendar");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkinDate+"']")));
		//driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")).click();
		click(driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")), "Checkin Date: "+checkinDate);
		
		
		//applyBtn.click();
		click(applyBtn, "Apply Button");
		
		
		//checkoutCalendar.click();
		click(checkoutCalendar, "Checkout Calendar");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkoutDate+"']")));
		//driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")).click();
		click(driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")), "Checkin Date: "+checkoutDate);

		//applyBtn.click();
		click(applyBtn, "Apply Button");


		
		//submitBtn.click();
		click(submitBtn, "Submit Button");
		
		return new HotelSearchResultsPage();
	}
	
	
	
	
	

}
