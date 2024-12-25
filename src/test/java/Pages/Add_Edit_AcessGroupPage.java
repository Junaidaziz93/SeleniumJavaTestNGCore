package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Edit_AcessGroupPage extends BasePage {

	public Add_Edit_AcessGroupPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//locators
	By accessGroupName = By.name("AccessGroupName");
	By inputCategories = By.xpath("//input[@placeholder='Select categories...']");
	By editBtn = By.xpath("//td[text()=' Selenium']//..//td[3]//span//button//mat-icon[text()='edit']");
	By deleteBtn = By.xpath("//td[text()=' Selenium']//..//td[3]//span//button[2]//mat-icon[text()='delete']");
	
	By selenium1Cat = By.xpath("//span[text()='Selenium-1 ']");
	By selenium2Cat = By.xpath("//span[text()='Selenium-2 ']");
	By selenium3Cat = By.xpath("//span[text()='Selenium-3 ']");

	//methods
	
	public void addAccessGroup() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAddAccessGroups); click(clickAddAccessGroups);
		waitVisibility(accessGroupName);writeText(accessGroupName, "Selenium");
		Thread.sleep(1000);
		waitVisibility(inputCategories); writeText(inputCategories, "Selenium-1");
		waitVisibility(selenium1Cat); click(selenium1Cat);
		Thread.sleep(3000);
		writeText(inputCategories, "Selenium-2");
		waitVisibility(selenium2Cat); click(selenium2Cat);
		Thread.sleep(3000);
		waitVisibility(clickSave); click(clickSave);
		
		Thread.sleep(2000);
	}
	
	public void editAccessGroup(String accessgroup) throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAccessGroups); click(clickAccessGroups);
		Thread.sleep(2000);
		waitVisibility(editBtn); click(editBtn);
		Thread.sleep(1000);
		waitVisibility(inputCategories); writeText(inputCategories, accessgroup);
		waitVisibility(selenium3Cat); click(selenium3Cat);
		Thread.sleep(500);
		waitVisibility(clickUpdate); click(clickUpdate);
		Thread.sleep(2000);
		
	}
	
	public void deleteAccessGroup() {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAccessGroups); click(clickAccessGroups);
		waitVisibility(deleteBtn); click(deleteBtn);
		waitVisibility(deleteYesBtn); click(deleteYesBtn);
		assertEquals(deleteSuccess, "Deleted successfully.");

	}
}

