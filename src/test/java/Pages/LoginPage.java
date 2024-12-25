package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	By email = By.xpath("//input[@data-placeholder='Enter your username']");
	By pwd = By.xpath("//input[@data-placeholder='Enter your Password']");
	By LoginBtn = By.xpath("//button//span[text()='Login']");
	By clickUserName = By.xpath("//div[@class='user-profile']//..//button[1]");
	By logOutBtn = By.xpath("//span[text()='Logout']/parent::button");
	By emptyLoginVerification = By.xpath("//span[contains(text(),'Both Password and user name are required.')]");
	By emptyPasswordVerification = By.xpath("//span[contains(text(),'Both Password and user name are required.')]");
	By emptyUserNameVerification = By.xpath("//span[contains(text(),'Both Password and user name are required.')]");
	By validLoginVerification = By.xpath("//span[text()='Login Successful!']");
	By logOutVerification = By.xpath("//span[text()='Login to your account']");

	//methods
	public LoginPage LoginToAMS(String username, String password) throws InterruptedException {
		
		writeText(email, username);
		
		writeText(pwd, password);
		
		click(LoginBtn);
		
		Thread.sleep(5000);
		return this;
	}
	
	public LoginPage ValidLoginVerification (){
		
		waitVisibility(validLoginVerification);
		assertEquals(validLoginVerification, "Login Successful!");
		System.out.println("User has logged in successfully logged in!");
		return this;
	}
	
	public void logOut() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(clickUserName); click(clickUserName);
		waitVisibility(logOutBtn); click(logOutBtn);
		assertEquals(logOutVerification, "Login to your account");
		Thread.sleep(2000);
	}
	
	public LoginPage EmptyLoginVerification (String expectedText) {
		
		assertEquals(emptyLoginVerification, expectedText);
		
		return this;	
	}
	
	public LoginPage EmptyPasswordVerification (String expectedText) {
		
		assertEquals(emptyPasswordVerification, expectedText);
		
		return this;		
	}
	
	public LoginPage EmptyUserNameVerification (String expectedText) {
		
		assertEquals(emptyUserNameVerification, expectedText);
		
		return this;		
	}
}
