package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.GooglePage;

public class DemoTest extends BaseTest
{
	@Test
	public void demotest1() throws InterruptedException
	{
		String data = Excel.getData(XL_PATH,"sheet1",1,0);
		Reporter.log("testdata:"+data,true);
		Reporter.log(driver.getTitle(), true);
		GooglePage g=new GooglePage(driver);
		g.setSearch(data);
		Thread.sleep(3000);
	}

}
