package MouseOpertn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.SeleniumUtil;

public class RegUsingMouseOp {

	public static void main(String[] args) {
	WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.automationtesting.in/Register.html");
	//inspect firstname
	WebElement firstname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	firstname.sendKeys("manager");
	//Using Mouse Actions class copy content of firstname field select all
	Actions action=new Actions(driver);
	action.moveToElement(firstname).doubleClick().perform();
	//press CONTROL then c
	action.keyDown(Keys.CONTROL).sendKeys("c");
	//release control button
	action.keyUp(Keys.CONTROL).build().perform();
	//control+V to lastname 
	
	WebElement lastname=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
	lastname.click();
	action.moveToElement(lastname).keyDown(Keys.CONTROL).sendKeys("v");
	action.keyUp(Keys.CONTROL).build().perform();
	

	}

}
