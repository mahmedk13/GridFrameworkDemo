package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightSearchPage extends BasePage {
	
	
	
	@FindBy(css="button[data-stid=location-field-leg1-origin-menu-trigger]")
	private WebElement originField;
	
	@FindBy(id="location-field-leg1-origin")
	private WebElement originTxbx;
	
	@FindBy(css="button[data-stid=location-field-leg1-destination-menu-trigger]")
	private WebElement destinationField;
	
	@FindBy(id="location-field-leg1-destination")
	private WebElement destinationTxbx;
	
	@FindBy(id="d1-btn")
	private WebElement checkinCalendar;
	
	@FindBy(css="button[data-stid=apply-date-picker]")
	private WebElement applyBtn;
	
	@FindBy(id="d2-btn")
	private WebElement checkoutCalendar;
	
	@FindBy(css="button[data-testid=submit-button]")
	private WebElement submitBtn;
	
	public FlightSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlightSearchResultsPage searchFlight(String origin, String dest, String checkinDate, String checkoutDate) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		
		//originField.click();
		click(originField, "Origin Field");
		
		//originTxbx.sendKeys(origin, Keys.ENTER);
		typeWithEnter(originTxbx, origin, "Origin Text box");
		
		
		//destinationField.click();
		click(destinationField, "Destination Field");
		
		
		//destinationTxbx.sendKeys(dest, Keys.ENTER);
		typeWithEnter(destinationTxbx, dest, "Destination Text box");

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
		

		
		return new FlightSearchResultsPage();
	}
	
	
	
	
	
	

}
