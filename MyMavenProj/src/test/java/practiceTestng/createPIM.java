package practiceTestng;

import org.testng.annotations.Test;

public class createPIM {
	@Test(priority=1,enabled=true,description="user account created")//additional data about method
	  public void signUp() {
		  System.out.println("Running signUp ");
	  }
	  @Test(priority=2,enabled=true,invocationCount=3)//helps to execute same () multiple times based on number given
	  public void login() {//login() method executes 3 times
		  System.out.println("login successfull ");
	  }
  @Test(priority=3,enabled=true,timeOut=2000)//gives timeout 2milliseconds
  //timeOut(time)-helps to make sure () will get finished within given time
  public void create() throws InterruptedException {
	  Thread.sleep(2000);//this will fail  this ()
	  System.out.println("PIM created");
  }
  @Test(priority=4,enabled=false,description="logout method",invocationCount=2,timeOut=2000)
  public void logOut()
  {
	  System.out.println("Logout successful");
  }
}
