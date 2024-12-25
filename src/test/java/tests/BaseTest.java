package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.Page;


public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	public Page page;
	
	protected String username = "nasir.n@dplit.com";
	protected String password = "Dpl@1234";

	@BeforeMethod
	public void setup() {	
		
		String baseURL = "https://dev-ims.dplit.com/";
		String driverPath ="C:\\eclipse\\eclipse-workspace\\ams\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		page = new Page(driver, wait);	
		driver.manage().window().maximize();
		driver.get(baseURL);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
}
