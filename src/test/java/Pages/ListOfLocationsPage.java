package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfLocationsPage extends BasePage{

	public ListOfLocationsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//locators
		
	By editBtn = By.xpath("//td[text()=' Abpara - Automation ']//..//td[4]//span[1]//button[@mattooltip='Edit']");
	By deleteBtn = By.xpath("//td[text()=' Abpara - Automation ']//..//td[4]//span[2]//button[@mattooltip='Delete']");
	By deleteYesBtn = By.xpath("//span[text()='Yes']");
	
	//verify
	By deleteLocSuccess = By.xpath("//span[text()='Deleted successfully.']");

	public void openEditItem() throws InterruptedException {
		
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickListOfLocations);click(clickListOfLocations);
		waitVisibility(editBtn); click(editBtn);
		Thread.sleep(2000);
	}
	
	public void deleteLocation() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickListOfLocations);click(clickListOfLocations);
		waitVisibility(deleteBtn); click(deleteBtn);
		waitVisibility(deleteYesBtn); click(deleteYesBtn);
		assertEquals(deleteLocSuccess, "Deleted successfully.");
		Thread.sleep(2000);
	}
}