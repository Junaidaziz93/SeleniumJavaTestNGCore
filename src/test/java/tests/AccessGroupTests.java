package tests;

import Pages.LoginPage;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Pages.Add_Edit_AcessGroupPage;

public class AccessGroupTests extends BaseTest{
	
	@Test(priority=0)
	public void addAccessGroup() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(Add_Edit_AcessGroupPage.class).addAccessGroup();
	}
	
	@Test(priority=1)
	public void editAccessGroup() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(Add_Edit_AcessGroupPage.class).editAccessGroup("Selenium-3" + Keys.ENTER);

	}
	
	@Test(priority=2)
	public void deleteAccessGroup() throws InterruptedException {
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);
		page.GetInstance(Add_Edit_AcessGroupPage.class).deleteAccessGroup();

	}

}
