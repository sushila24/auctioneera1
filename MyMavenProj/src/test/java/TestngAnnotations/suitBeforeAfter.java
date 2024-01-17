package TestngAnnotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class suitBeforeAfter {
	@BeforeSuite
	public void befSuit()
	{//necessary info about suite before executing Test cases
		System.out.println("I am before suit method");
	}
	@Test
	public void tc1()
	{
		System.out.println("I am TC1");
	}
	@Test
	public void tc2()
	{
		System.out.println("I am TC2");
	}
 @AfterSuite
 public void afterSuit()
 {//Necessory info about suite after execution of all Test cases
	 System.out.println("I am after suite method");
 }
}
