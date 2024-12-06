package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLoginTestDataDrivenTest extends BaseTest 
{

	@Test(priority=3)
	public void testInvalidLoginDataDriven()
	{
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		//Here we are starting from the count one because the 0th row contains row header/title
		//Here keep the coloumn const and the code should traverse to subsequent rows
		for(int i=1;i<rc;i++)
		{
			String un=Excel.getData(XL_PATH, "InvalidLogin", i, 0);
			String pw=Excel.getData(XL_PATH, "InvalidLogin", i, 1);
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
}
