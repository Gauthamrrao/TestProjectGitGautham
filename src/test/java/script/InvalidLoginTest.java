package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLoginTest extends BaseTest 
{
@Test(priority=2)
public void testInvalidLogin()
{
	String un=Excel.getData(XL_PATH, "InvalidLogin", 1, 0);
	String pw=Excel.getData(XL_PATH, "InvalidLogin", 1, 1);
	//1.enter invalid un
	LoginPage page=new LoginPage(driver);
	page.setUserName(un);
	
	//2.enter invalid password
	page.setPassword(pw);
	//3.click on Login Button
	page.clickLoginButton();
	//4.Verify the Error message is displayed

	boolean result = page.verifyErrorMsgisDisplayed(wait);
	Assert.assertEquals(result, true);
	
}
}
