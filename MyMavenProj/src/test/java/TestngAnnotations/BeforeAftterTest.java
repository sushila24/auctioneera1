package TestngAnnotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAftterTest {

	@BeforeSuite
	public void befSuit()
	{//necessary info about suite before executing Test cases
		System.out.println("I am before suit method");
		
	}
	@BeforeTest
	public void display()
	{
		System.out.println("I am @BeforeTest code");
	}
	@Test
	public void TC1()
	{
		System.out.println("I am TC1 method code");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("I am @afterTest code");
	}
	@AfterSuite
	public void afterSuit()
	{
		//necessary info about suite after executing Test cases
				System.out.println("I am after suit method");
	}
}
