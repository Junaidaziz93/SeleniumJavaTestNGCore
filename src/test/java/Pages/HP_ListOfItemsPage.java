package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HP_ListOfItemsPage extends BasePage {

	public HP_ListOfItemsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	By clickAdd = By.xpath("(//span[text()='Add'])[1]");
	By editBtn = By.xpath("//button[text()='AutomationItem']/parent::td/following-sibling::td[8]//span//button[3]");
	By cloneBtn = By.xpath("//button[text()='AutomationItem']/parent::td/following-sibling::td[8]//span//a[1]");
	By deleteBtn = By.xpath("//button[text()='AutomationItem']/parent::td/following-sibling::td[8]//span//button[4]");
	By checkOutBtn = By.xpath("//button[text()='AutomationItem']/parent::td/following-sibling::td[8]//span//button[2]");
	By checkInBtn = By.xpath("//button[text()='AutomationItem']/parent::td/following-sibling::td[8]//span//button[1]");
	By checkOutTo = By.xpath("//input[@name='selectUserControl']");
	By clickUserLocationDropdown = By.xpath("//mat-select[@name='selectLocationControl']//div//div[2]");
	By clickDPLLocationDropdown = By.xpath("//mat-select[@name='selectDplLocationControl']//div//div[2]");
	By selectUser = By.xpath("(//span[text()=' Nasir Sultan '])[2]");
	By setAdress = By.xpath("//span[text()=' Add 2 ']");
	By setOfficeAdress = By.xpath("//div[@role='listbox']//*//span");
		
	//verifications locators
	
	By checkOutSuccess = By.xpath("//span[text()='Item Check-out successfully!']");
	By checkInSucess = By.xpath("//span[text()='Item Check-in successfully!']");	

	
	public void openAddNewItemsPage() {
		waitInvisibility(loginSucessful);
		waitVisibility(itemsClick); waitElementToBeClickable(itemsClick); click(itemsClick);
		waitVisibility(addNewItem);	click(addNewItem);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void openListOfLocationsPage () {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickListOfLocations);click(clickListOfLocations);
	}
	
	public void openAddNewLocationPage () {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAddNewLocation); click(clickAddNewLocation);
	}
	
	public void openAccessGroupListPage() {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAccessGroups); click(clickAccessGroups);
	}
	
	public void openAddAcessGroupsPage() {
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance);
		waitVisibility(clickAddAccessGroups); click(clickAddAccessGroups);
	}
	
	public void openEditItemPage() {
		waitInvisibility(loginSucessful);
		waitVisibility(editBtn); click(editBtn);
	}
	
	public void openCloneItemPage() {
		waitInvisibility(loginSucessful);
		waitVisibility(cloneBtn); click(cloneBtn);
	}
	
	public void deleteClonedItem() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(deleteBtn); click(deleteBtn);
		waitVisibility(deleteYesBtn); click(deleteYesBtn);
		Thread.sleep(5000);
		assertEquals(deleteSuccess, "Deleted successfully.");
	}
	
	public void deleteItem() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(deleteBtn); click(deleteBtn);
		waitVisibility(deleteYesBtn); click(deleteYesBtn);
		Thread.sleep(5000);
		assertEquals(deleteSuccess, "Deleted successfully.");
	}
	
	public void checkOutItem() throws InterruptedException {	
		waitInvisibility(loginSucessful);
		waitVisibility(checkOutBtn); click(checkOutBtn);
		waitVisibility(checkOutTo); Thread.sleep(2000); writeText(checkOutTo, "Nasir Sultan"); Thread.sleep(2000);
		waitVisibility(selectUser); click(selectUser);
		waitVisibility(clickUserLocationDropdown); click(clickUserLocationDropdown);
		Thread.sleep(2000); waitVisibility(setAdress); click(setAdress);
		waitVisibility(clickSave); click(clickSave);
		Thread.sleep(2000);
		assertEquals(checkOutSuccess, "Item Check-out successfully!");
		Thread.sleep(2000);
		}	

	public void checkInItem() throws InterruptedException {
		waitInvisibility(loginSucessful);
		waitVisibility(checkInBtn); click(checkInBtn);
		Thread.sleep(2000);
		waitVisibility(clickDPLLocationDropdown); click(clickDPLLocationDropdown);
		waitVisibility(setOfficeAdress); click(setOfficeAdress);
		waitVisibility(clickSave); click(clickSave);
		assertEquals(checkInSucess, "Item Check-in successfully!");
		Thread.sleep(2000);
		}	
		
}
