package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{
	
	@FindBy(css="a[href*=wizard-flight-pwa]")
	private WebElement flightTab;
	
	@FindBy(css="a[href*=wizard-hotel-pwa]")
	private WebElement hotelTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlightSearchPage navigateToFlightTab() {
		//flightTab.click();
		click(flightTab, "Flight Tab");
		return new FlightSearchPage();
	}
	
	public HotelSearchPage navigateToHotelTab() {
		//hotelTab.click();
		click(hotelTab, "Hotel Tab");
		return new HotelSearchPage();
	}

}
