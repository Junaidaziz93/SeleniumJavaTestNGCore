package tests;

import org.testng.annotations.Test;

import Pages.Add_Edit_LocationPage;
import Pages.ListOfLocationsPage;
import Pages.LoginPage;

public class LocationTests extends BaseTest {
	
	@Test(priority=0)
	public void addNewLocation() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(Add_Edit_LocationPage.class).addNewLocation(
				"Abpara - Automation",
				"03130000000", 
				"Abpara Chowk", 
				"Nasir Sultan");
	}
	@Test(priority=1)
	public void editLocation () throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(ListOfLocationsPage.class).openEditItem();
		page.GetInstance(Add_Edit_LocationPage.class).editLocation("New Edited Address");

	}
	@Test(priority=2)
	public void deleteLocation () throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(ListOfLocationsPage.class).deleteLocation();
		
	}
}
