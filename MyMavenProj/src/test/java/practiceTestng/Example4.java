package practiceTestng;

import org.testng.annotations.Test;

public class Example4 {
	 @Test
	  public void signUp() {
		  System.out.println("Running signUp ");
	  }
	  @Test
	  public void login() {
		  System.out.println("login successfull ");
	  }
	  @Test
	  public void logOut() {
		  System.out.println("logOut successfull ");
		  calling();
	  }
  public void calling() {
	  System.out.println("I am calling");
  }
}
//test count is 3 here it depends on @Test()