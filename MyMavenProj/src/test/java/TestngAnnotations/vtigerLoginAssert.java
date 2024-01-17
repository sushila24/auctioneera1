package TestngAnnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class vtigerLoginAssert {
	@Test
	public void LoginLogoutVTiger()
	{
		SeleniumUtility util=new SeleniumUtility();
		WebDriver driver=util.setUp("chrome","https://demo.vtiger.com/vtigercrm/index.php");
		System.out.println("Before login pageTitle is: "+driver.getTitle());
		//enter username
		util.typeInput(driver.findElement(By.id("username")), "admin");
		//locate password
		//driver.findElement(By.id("password")).clear();
		//driver.findElement(By.id("password")).sendKeys("admin");//or
		util.typeInput(driver.findElement(By.id("password")), "admin");
		//click on login
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		//or
		//util.clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));
		
		//locate userProfile
		WebElement userProfile=driver.findElement(By.cssSelector(".userName"));
		
		//explicit wait for element to be clickable
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(userProfile));
		//or
		//util.waitForElementToBeClickable(userProfile);
		System.out.println("After login page title:"+driver.getTitle());
		//or
		//System.out.println("After login page title:"+util.getCurrentTitleOfApplication());
		userProfile.click();//or util.clickOnElement(userProfile);
		
		//click on logout link
		driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")).click();
		//or
		//util.clickOnElement(driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		//title validation using TestNG
		Assert.assertEquals(driver.getTitle(), "vtiger","Either logout not done/login page title changed");
		System.out.println("After successfull logout title is: "+driver.getTitle());
		System.out.println("Assertion done successfully");
		//or
		//Assert.assertEquals(util.getCurrentTitleOfApplication(), "vtiger","Either logout not done/login page title changed");
		driver.close();
		
	}

}
