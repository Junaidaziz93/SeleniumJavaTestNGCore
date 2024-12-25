package Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Edit_ItemsPage extends BasePage {

	public Add_Edit_ItemsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	By enterName = By.xpath("//input[@data-placeholder='Enter your Item Name']");
	By enterCode = By.xpath("//input[@data-placeholder='Enter Code']");
	By enterModel = By.name("ItemModel");
	By enterSerial = By.name("SerialNo");
	By enterQuantity = By.xpath("(//input[@data-placeholder='Enter your Quantity'])[1]");
	By enterDescription = By.xpath("//textarea[@data-placeholder='Enter your Description']");
	By enterResponsible = By.name("responsibleUser");
	By openLocation = By.xpath("//mat-select[@name='location']");
	By clickLocation = By.xpath("(//span[text()=' I8 Office '])[1]");
	By openCategory = By.xpath("//mat-select[@name='Category']");
	By clickCategory = By.xpath("//span[text()=' Selenium-1 ']");
	By openSubCategory = By.xpath("//mat-select[@name='SubCategory']");
	By clickSubCategory = By.xpath("//span[text()=' Sub-A ']");
	By enterProcurementURL = By.name("ProcurementURL");
	By enterPurchaseCost = By.name("PurchaseCost");
	By enterTags = By.xpath("//input[@placeholder='New Tag']");
	By enterSpecifications = By.name("SpecificationName");
	By enterValue = By.xpath("//input[@data-placeholder='Enter your Value']");
	By specificationsAddBtn = By.xpath("//span[text()='Add']");
	
	By newItemAddSuccess = By.xpath("//span[text()='Item Added Successfully']");
	By editSuccess = By.xpath("//span[text()='Item Updated Successfully']");
	By extraClick = By.xpath("//span[contains(text(),'All Rights Reserved')]");
	
	//------------------Page Methods-------------------////
	
	public Add_Edit_ItemsPage AddNewItem(
			String Name,
//			String code,
			String model,
			String serialno,
			String quantity,
			String description,
			String procurementUrl,
			String purchasecost,
			String addtags,
			String specificationName,
			String specificationValue) throws InterruptedException {
		Thread.sleep(2000);
		waitVisibility(enterName); writeText(enterName, Name);
//		waitVisibility(enterCode); writeText(enterCode, code);
		waitVisibility(enterModel); writeText(enterModel, model);
		waitVisibility(enterSerial); writeText(enterSerial, serialno);
		waitVisibility(enterQuantity); clearField(enterQuantity); writeText(enterQuantity, quantity);
		waitVisibility(enterDescription); clearField(enterDescription); writeText(enterDescription, description);
		waitVisibility(openLocation); click(openLocation);
		waitVisibility(clickLocation); click(clickLocation);		
		waitVisibility(openCategory); waitElementToBeClickable(openCategory); click(openCategory);
		waitVisibility(clickCategory); click(clickCategory);		
		waitVisibility(openSubCategory); click(openSubCategory);
		waitVisibility(clickSubCategory);click(clickSubCategory);
		scrollPage(0,1500);
		waitVisibility(enterProcurementURL); writeText(enterProcurementURL, procurementUrl);
		waitVisibility(enterPurchaseCost); writeText(enterPurchaseCost, purchasecost);
		waitVisibility(enterTags); writeText(enterTags, addtags);
		waitVisibility(extraClick);click(extraClick);
		waitVisibility(enterSpecifications); writeText(enterSpecifications, specificationName);
		waitVisibility(enterValue); writeText(enterValue, specificationValue);
		waitVisibility(specificationsAddBtn); click(specificationsAddBtn);
		scrollPage(0,0);
		waitVisibility(clickSave); click(clickSave);
		Thread.sleep(5000);
		assertEquals(newItemAddSuccess, "Item Added Successfully");
		Thread.sleep(2000);
		return this;	
	}
	
	public Add_Edit_ItemsPage editAnItem(
//			String code,
			String model,
			String serialno,
//			String quantity,
			String description,
			String purchasecost,
			String addtags) throws InterruptedException {
		
		Thread.sleep(2000);
	
//		waitVisibility(enterCode); clearField(enterCode); writeText(enterCode, code);
		waitVisibility(enterModel); clearField(enterModel); writeText(enterModel, model);
		waitVisibility(enterSerial); clearField(enterSerial); writeText(enterSerial, serialno);
//		waitVisibility(enterQuantity); clearField(enterQuantity); writeText(enterQuantity, quantity);
		waitVisibility(enterDescription); clearField(enterDescription); writeText(enterDescription, description);
		scrollPage(0,1500);
		waitVisibility(enterPurchaseCost); clearField(enterPurchaseCost);writeText(enterPurchaseCost, purchasecost);
		waitVisibility(enterTags); writeText(enterTags, addtags);
		Thread.sleep(1000);
		scrollPage(0,0);
		waitVisibility(clickUpdate); click(clickUpdate);
		Thread.sleep(2000);
		assertEquals(editSuccess, "Item Updated Successfully");
		Thread.sleep(2000);

		return this;
	}
	
	public void cloneItem(String model, String serialno, String quantity, String description) throws InterruptedException {
			ArrayList<String> tabs;	
			tabs = new ArrayList<String>(driver.getWindowHandles());
			//switch to the child tab
			driver.switchTo().window(tabs.get(1)); //Tab number
			waitVisibility(enterModel); clearField(enterModel); writeText(enterModel, model);
			waitVisibility(enterSerial); clearField(enterSerial); writeText(enterSerial, serialno);
			waitVisibility(enterQuantity); clearField(enterQuantity); clearField(enterQuantity); writeText(enterQuantity, quantity);
			waitVisibility(enterDescription); clearField(enterDescription); writeText(enterDescription, description);
			//wait for add button and click on it.
			Thread.sleep(2000);
			waitVisibility(clickAdd); click(clickAdd);	
			waitVisibility(newItemAddSuccess); assertEquals(newItemAddSuccess, "Item Added Successfully");
			driver.close();
		
			driver.switchTo().window(tabs.get(0)); //Tab number
			Thread.sleep(5000);
		
		
	}

}
