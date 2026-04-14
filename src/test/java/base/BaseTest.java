package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	ConfigReader config=new ConfigReader();
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeMethod
	public void setup() {
		String browser=config.getBrowser();
		if (browser.equalsIgnoreCase("chrome")) {
		    WebDriverManager.chromedriver().setup();
		    driver.set(new ChromeDriver());
		} else {
		    throw new RuntimeException("Only Chrome is supported");
		}
		getDriver().manage().window().maximize();
		getDriver().get(config.getBaseUrl());
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
		driver.remove();
	}
}
