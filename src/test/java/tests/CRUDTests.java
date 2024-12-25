package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Pages.Add_Edit_ItemsPage;
import Pages.HP_ListOfItemsPage;
import Pages.LoginPage;

public class CRUDTests extends BaseTest {
	
	
	@Test(priority=0)
	public void addNewItem() throws InterruptedException {
		
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).openAddNewItemsPage();
		page.GetInstance(Add_Edit_ItemsPage.class).AddNewItem(
				"AutomationItem",
//				"45678",
				"TestModel",
				"Auto123",
				"3",
				"This is the description of automatedly added itemm",
				"www.dpl.com",
				"500",
				"#autotag1" + Keys.ENTER,
				"HardDisk",
				"500GB");
	}
	@Test(priority=1)
	public void checkOut() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).checkOutItem();
		
	}
	
	@Test(priority=2)
	public void checkIn() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).checkInItem();
		
	}
	@Test(priority=3)
	public void editNewItem() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).openEditItemPage();
		page.GetInstance(Add_Edit_ItemsPage.class).editAnItem(
//				"45679",
				"TestModel-Edit",
				"Auto124",
//				"5",
				"This is the edited description",
				"1000",
				"#autotag2"
				);
		
	}
	@Test(priority=4)
	public void cloneItem() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).openCloneItemPage();
		page.GetInstance(Add_Edit_ItemsPage.class).cloneItem("45680",
				"Auto125-Cloned",
				"10",
				"This is the description of cloned Item");
	}
	@Test(priority=5)
	public void deleteClonedItem( ) throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).deleteClonedItem();  
	
	}
	@Test(priority=6)
	public void deleteItem() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(HP_ListOfItemsPage.class).deleteItem();

	}
}