package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage extends Page{
	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
//    JavascriptExecutor js = (JavascriptExecutor) driver;

	//sidebar locators
	
	By itemsClick = By.xpath("//span[text()=' Items']/parent::div//..");
	By addNewItem = By.xpath("//span[contains(text(),'Add a New Item')]");
	By clickMaintenance = By.xpath("//span[text()=' Maintenance']");
	By clickAddNewLocation = By.xpath("//span[text()=' Add a New Location ']");
	By clickListOfLocations = By.xpath("//span[text()=' List of Locations ']");
	By clickAccessGroups = By.xpath("//span[text()=' Access Groups ']");
	By clickAddAccessGroups = By.xpath("//span[text()=' Add Access Groups ']");
	
	By loginSucessful = By.xpath("//span[text()='Login Successful!']/..");
	By clickSave = By.xpath("//span[text()='Save']");
	By clickUpdate = By.xpath("//span[text()='Update']");
	By deleteYesBtn = By.xpath("//span[text()='Yes']");
	By deleteSuccess = By.xpath("//span[text()='Deleted successfully.']");
	By clickAdd = By.xpath("(//span[text()='Add'])[1]");


	//Generic Methods
	
	public void click(By elementlocation) {
		driver.findElement(elementlocation).click();
	}
	
	public String writeText(By elementlocation, String text) {
		driver.findElement(elementlocation).sendKeys(text);
		return text;
	}
	
	public String readText(By elementlocation) {
		return driver.findElement(elementlocation).getText();
	}
	
	public void waitVisibility(By elementlocation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementlocation));
	}
	
	public void waitElementToBeClickable(By elementlocation ) {		
		wait.until(ExpectedConditions.elementToBeClickable(elementlocation));
	}
	
	public void waitInvisibility(By elementLocation) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocation));

	}
	
	public void assertEquals (By elementlocation, String expectedText) {
		waitVisibility(elementlocation);
		 Assert.assertEquals(readText(elementlocation), expectedText);
	}
	
	public void comboBox(By elementLocation, int index) {
		Select select= new Select(driver.findElement(elementLocation));
		select.selectByIndex(index);
	}
	
	public void clearField (By elementlocation) {
		driver.findElement(elementlocation).clear();
	}
	
	public void scrollPage(int x, int y) {
		Actions action = new Actions(driver);
		action.moveByOffset(x, y);
	}
}
