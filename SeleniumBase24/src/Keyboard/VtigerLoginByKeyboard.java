package Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.SeleniumUtil;

public class VtigerLoginByKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
username.clear();
username.sendKeys("admin",Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));pass.clear();
pass.sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
System.out.println("Login successful");
	}

}
/**
 * xpath for Sony xperia z5:   //div[h4[a[text()='Sony xperia z5']]]/h5
 * flipkart samsung Tv price:
 * //div[div[div[text()='SAMSUNG Crystal 4K iSmart Series 108 cm (43 inch) Ultra HD (4K) LED Smart Tizen TV 2023 Edition']]]/div[2]/div[1]/div[1]/div[text()='₹30,990']
 
 *Anniversary
 * //span[text()='Anniversary']
 * //span[text()='Just Because']//preceding::span[text()='Anniversary']
		 
 *birthday //span[text()='Anniversary']//following::span[text()='Birthday']
 *         //span[text()='Just Because']//preceding::span[text()='Birthday']
 *
 *friendship //span[text()='Anniversary']//following::span[text()='Friendship']
 *           //span[text()='Just Because']//preceding::span[text()='Friendship']
 *           //span[text()="Anniversary"]//following-sibling::span[text()="Friendship"] 
 */
