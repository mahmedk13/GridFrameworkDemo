package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	
	
	
	public void launchBrowser(String grid, String browser, String url) {
		
		if(grid.equalsIgnoreCase("true")) {
			DesiredCapabilities caps =null;
			if(browser.equalsIgnoreCase("chrome")) {
				caps = DesiredCapabilities().chrome();
				caps.setBrowserName("chrome");
				caps.setPlatform(Platform.ANY);
			}else if (browser.equalsIgnoreCase("firefox")) {
				caps = DesiredCapabilities().firefox();
				caps.setBrowserName("firefox");
				caps.setPlatform(Platform.ANY);
				
			}else if (browser.equalsIgnoreCase("ie")) {
				caps = DesiredCapabilities().internetExplorer();
				caps.setBrowserName("iexplore");
				caps.setPlatform(Platform.WIN10);
			}
			
			try {
				driver =new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {

			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		}
		
		
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().get(url); //
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	private DesiredCapabilities DesiredCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeBrowser() {
		DriverManager.getDriver().quit();
	}
	
	
	
	//wherever I will create webdriver instance I will pass that webdriver instance to 
	//threadlocal method so that it can become thread safe
	
	
	
	

}
