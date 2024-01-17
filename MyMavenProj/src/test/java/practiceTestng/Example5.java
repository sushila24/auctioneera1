package practiceTestng;

import org.testng.annotations.Test;

public class Example5 {
	@Test(priority=1)
	  public void signUp() {
		  System.out.println("Running signUp ");
	  }
	  @Test(priority=2)
	  public void login() {
		  System.out.println("login successfull ");
	  }
	  @Test(priority=3,enabled=false)
	  public void logOut() {
		  System.out.println("logOut successfull ");
		  calling();
	  }
public void calling() {
	  System.out.println("I am calling");
}
}
/*
arguments in @Test()
1.priority: By default all @Test() will have priority as 0
2.enabled: By default all @Test() will have true for enabled 
     false:not eligible for execution
*/