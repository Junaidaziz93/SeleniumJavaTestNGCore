package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Add_Edit_LocationPage extends BasePage {

	public Add_Edit_LocationPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	//Locators
		By enterLocation = By.name("LocationName");
		By enterPhone = By.name("Phone");
		By enterAddress = By.name("address");
		By enterResponsible = By.name("responsibleUser");
		By saveBtn = By.xpath("//span[text()='Save']");
	//verifications
		By updateLocSuccess = By.xpath("//span[text()='Location updated successfully!']");
		By addLocSuccess = By.xpath("//span[text()='Location added successfully!']");
		
	//methods
	public void addNewLocation(String location, String phone, String address, String responsible) throws InterruptedException {
		
		waitInvisibility(loginSucessful);
		waitVisibility(clickMaintenance); click(clickMaintenance); 
		Reporter.log("Maintenace tab is expaned");
		waitVisibility(clickAddNewLocation); click(clickAddNewLocation); 
		Reporter.log("Add new location Page is opened");
		waitVisibility(enterLocation); writeText(enterLocation, location); 
		Reporter.log(location + " is entered");
		waitVisibility(enterPhone);  writeText(enterPhone, phone); 
		Reporter.log(phone + " is entered");
		waitVisibility(enterAddress); writeText(enterAddress, address); 
		Reporter.log(address + " is entered");
		waitVisibility(enterResponsible); writeText(enterResponsible, responsible + Keys.ENTER);
		waitVisibility(saveBtn); click(saveBtn);
		assertEquals(addLocSuccess,"Location added successfully!");
		Thread.sleep(2000);
	}		

	
	
	public void editLocation (String Adress) throws InterruptedException {
		waitVisibility(enterAddress); clearField(enterAddress); writeText(enterAddress, Adress);
		Thread.sleep(2000);
		waitVisibility(saveBtn); click(saveBtn);
		assertEquals(updateLocSuccess,"Location updated successfully!");
		Thread.sleep(2000);
	}
}
