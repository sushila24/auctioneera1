package TestngAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
	@BeforeSuite
	public void befSuit()
	{
		System.out.println("Before suit success");
	}
	@BeforeTest
	public void openbrwser()
	{
		System.out.println("open chrome success");
	}
	@BeforeMethod
	public void  befMethdisp()
	{
		System.out.println("App url success");	
	}
	@AfterMethod
	public void afterMeth()
	{
		System.out.println("Logout from appl");
	}
	@Test
	public void TC1()
	{
		System.out.println("Login success");
	}
	@Test
	public void TC2()
	{
		System.out.println("create task success");
	}
	@Test
	public void TC3()
	{
		System.out.println("Logout success");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("close browser success");
	}
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("after suit success");
	}
}
