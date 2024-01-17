package practiceTestng;

import org.testng.annotations.Test;

public class Example6 {
	@Test(priority=1,enabled=true,description="user account created")//additional data about method
	  public void signUp() {
		  System.out.println("Running signUp ");
	  }
	  @Test(priority=2,enabled=true,invocationCount=3)//helps to execute same () multiple times based on number given
	  public void login() {//login() method executes 3 times
		  System.out.println("login successfull ");
	  }
	  @Test(priority=3,enabled=false)//will not ready for execution
	  public void logOut() {
		  System.out.println("logOut successfull ");
		  
	  }
}
