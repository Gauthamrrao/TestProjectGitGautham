package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLoginTest extends BaseTest
{
	@Test(priority=1)
	public void testValidLogin()
	{
		LoginPage loginpage=new LoginPage(driver);
		//1.Enter valid username
		loginpage.setUserName("admin");
		//2.Enter the valid password
		loginpage.setPassword("manager");
		//3.click Login Button
		loginpage.clickLoginButton();
		//4.verifyHomepage
		EnterTimeTrackPage homepage=new EnterTimeTrackPage(driver);
		boolean result = homepage.VerifyHomePageisDisplayed(wait);
		Assert.assertEquals(result, true);	
	}

}
