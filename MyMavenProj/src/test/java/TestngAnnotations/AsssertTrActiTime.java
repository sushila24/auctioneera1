package TestngAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class AsssertTrActiTime extends SeleniumUtility{
	@Test
	public void LoginValidationOnActiime()
	{
		
	
SeleniumUtility utility=new SeleniumUtility();

WebDriver driver=utility.setUp("chrome", "https://online.actitime.com/testing/login.do");
//before login page title
System.out.println("before login page title"+driver.getTitle());
//assertion using TestNG
//Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
//or
Assert.assertEquals(driver.getTitle(), "actiTIME - Login","Login page not opened/title got changed");
//username
//utility.typeInput("driver.findElement(By.id("username"))","admin" );
WebElement usernameField=driver.findElement(By.id("username"));
//chk username field visible/enabled/get attribute of it
Assert.assertTrue(usernameField.isDisplayed());
Assert.assertTrue(usernameField.isEnabled(),"usernameField not enabled/functional");
Assert.assertEquals(usernameField.getAttribute("placeholder"), "Username","UsernameFields placeholder value changed");
//identify remember me chkbox
WebElement  chkBox=driver.findElement(By.id("keepLoggedInCheckBox"));//By.name("remember")
Assert.assertTrue(chkBox.isDisplayed());
Assert.assertTrue(chkBox.isEnabled(),"Checkbox is not enabled/functional");
Assert.assertFalse(chkBox.isSelected(),"By default chkbox should not be selected");
chkBox.click();
Assert.assertTrue(chkBox.isSelected(),"chekbox is not working");
System.out.println("Username and chkbox field assertions done successfully");

driver.close();



}
}
