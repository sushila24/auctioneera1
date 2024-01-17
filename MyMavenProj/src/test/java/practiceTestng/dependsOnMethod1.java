package practiceTestng;

import org.testng.annotations.Test;

public class dependsOnMethod1 {
	@Test(priority=1,enabled=true,description="user account created")//additional data about method
	  public void signUp() {
		  System.out.println("Running signUp ");
	  }
	  @Test(priority=2,enabled=true,invocationCount=3)//helps to execute same () multiple times based on number given
	  public void login() {//login() method executes 3 times
		  System.out.println("login successfull ");
	  }
	@Test(priority=3,enabled=true,timeOut=2000)
	public void createPIM() throws InterruptedException  {
		  Thread.sleep(2000);//this will fail  this () coz timeOut is 2000
		  System.out.println("PIM created");
	  }
	@Test(priority=4,dependsOnMethods="createPIM")
	public void deletePIM()  {
		  //this () will be skipped if createPIM() failed due to some reason
		  System.out.println("PIM  deleted");
	  }
//dependsOnMethods:use when 1() depends on another methods successful execution
	//ExceptionHandling:
	@Test(priority=5,enabled=true,expectedExceptions=ArithmeticException.class)//will fail this ()coz of exception
	public void chkNumber()//To avoid this() to be failed use expectedException=Exception.class
	{
		int num=10/0;//Arithmetic exception will occur n this TC will fail
		System.out.println("division:"+num);
	}
}
