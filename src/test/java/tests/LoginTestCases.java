package tests;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTestCases extends BaseTest{
	
	
	private String verificationText = "Both Password and user name are required.";
	
	//LoginPage loginpage = new LoginPage(driver, wait);
		
	
	@Test(priority=0)
	public void Valid_Login_To_AMS() throws InterruptedException {
		
		page.GetInstance(LoginPage.class).LoginToAMS(username, password);		
		page.GetInstance(LoginPage.class).ValidLoginVerification();
		page.GetInstance(LoginPage.class).logOut();
		
//		loginpage.LoginToAMS(username, password);
	}
	
	@Test(priority=1)
	public void Empty_Login_To_AMS() throws InterruptedException {
		
		page.GetInstance(LoginPage.class).LoginToAMS("", "");
		page.GetInstance(LoginPage.class).EmptyLoginVerification(verificationText);
		
//		loginpage.LoginToAMS("","");
//		loginpage.EmptyLoginVerification("Both Password and user name are required.");
	}
	
	@Test(priority=2)
	public void UserName_EmptyPassword() throws InterruptedException {
		
		page.GetInstance(LoginPage.class).LoginToAMS(username, "");
		page.GetInstance(LoginPage.class).EmptyLoginVerification(verificationText);
		
//		loginpage.LoginToAMS(username,"");
//		loginpage.EmptyPasswordVerification("Both Password and user name are required.");
	}
	
	@Test(priority=4)
	public void EmptyUserName_PasswordFill( ) throws InterruptedException {
		
		page.GetInstance(LoginPage.class).LoginToAMS("", password);
		page.GetInstance(LoginPage.class).EmptyLoginVerification(verificationText);
		
//		loginpage.LoginToAMS("", password);
//		loginpage.EmptyUserNameVerification("Both Password and user name are required.");
	}
	

}
