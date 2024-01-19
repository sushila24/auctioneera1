package PropFileSeleniumActi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.SeleniumUtil;

public class autoTestRegWthProp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
String filepath=".\\TestData\\automateTestReg.properties";//D:\\workspace2023\\seleniumBasic\\TestData\\automateTestReg.properties

FileInputStream fis=new FileInputStream(filepath);
Properties prop=new Properties();
prop.load(fis);
WebDriver driver=SeleniumUtil.setUp("chrome", prop.getProperty("appurl"));
//xpatth://input[@placeholder='First Name']
driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(prop.getProperty("firstname"));
//xpatth://input[@placeholder='Last Name']
driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(prop.getProperty("lastname"));
//address .form-group .form-control.ng-untouched.ng-valid //div>.form-control.ng-untouched.ng-valid .ng-valid.ng-touched
driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(prop.getProperty("address"));
//email input.ng-pristine.ng-untouched.ng-valid-email
driver.findElement(By.cssSelector(".ng-untouched.ng-valid-email")).sendKeys(prop.getProperty("email"));
//phone .ng-untouched.ng-valid-pattern
driver.findElement(By.cssSelector(".ng-untouched.ng-valid-pattern")).sendKeys(prop.getProperty("phone"));
//language
driver.findElement(By.id("msdd")).click();
driver.findElement(By.cssSelector(".ui-corner-all>li:nth-of-type(2)>a")).click();
//skills
WebElement skills=driver.findElement(By.id("Skills"));//skills.click();
Select select=new Select(skills);
select.selectByValue("Android");
//countries
WebElement country=driver.findElement(By.id("countries"));
Select sel_Contry=new Select(country);
//sel_Contry.selectByIndex(2);Select Country
sel_Contry.selectByVisibleText("Select Country");

//password
driver.findElement(By.cssSelector("#firstpassword")).sendKeys(prop.getProperty("password"));
//confirm pass
driver.findElement(By.cssSelector("#secondpassword")).sendKeys(prop.getProperty("confirm_pass"));

System.out.println("Registration form filled successfully");
	}

}
