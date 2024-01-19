package Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class ActiLoginByKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://online.actitime.com/testing/login.do");

WebElement username=driver.findElement(By.id("username"));
username.sendKeys("tester01@vomoto.com");//,Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"C"));
//login without clicking on login button
driver.findElement(By.name("pwd")).sendKeys("manager",Keys.ENTER);//(Keys.chord(Keys.CONTROL,"v"));

System.out.println("login successfull");
	}

}
