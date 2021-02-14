package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DriverManager;

public class BasePage {
	
	
	public WebDriver driver;
	
	public BasePage() {
		this.driver=DriverManager.getDriver();
		
	}

	public void click(WebElement ele, String elementName) {
		ele.click();
		ExtentListeners.testReport.get().info("Clicking on "+elementName);
	}
	
	public void type(WebElement ele, String value, String elementName) {
		ele.sendKeys(value);
		ExtentListeners.testReport.get().info("Entering "+value+ " in "+elementName);
	}
	
	public void typeWithEnter(WebElement ele, String value, String elementName) {
		ele.sendKeys(value, Keys.ENTER);
		ExtentListeners.testReport.get().info("Entering "+value+ " in "+elementName);
	}
	
	
	
	
	
	
	
	
	

}
