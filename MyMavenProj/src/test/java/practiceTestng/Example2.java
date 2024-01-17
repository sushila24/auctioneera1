package practiceTestng;

import org.testng.annotations.Test;

public class Example2 {
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
  }
  
}
/*
In testNG no main() is there
Everything is controlled by @Test()
testng class creation
1.right click on required package->TestNG->Create TestNG class-->give TestNG classname(e.g Example2 -without.java) and finish
2. create java file->write @Test() by own main() not required delete it
when u have more than 1 @Test() execution will be in alphabetical order
login->logOut->signUp
Test run count always depends on @Test method
*/