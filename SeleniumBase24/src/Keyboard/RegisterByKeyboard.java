package Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class RegisterByKeyboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.automationtesting.in/Register.html");

WebElement firstname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
firstname.sendKeys("admin",Keys.chord(Keys.CONTROL,"A"),Keys.chord(Keys.CONTROL,"c"));
driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
Thread.sleep(2000);
//driver.navigate().refresh();
driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
	}

}
//Refresh the page