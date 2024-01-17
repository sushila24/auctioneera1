package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HRM extends SeleniumUtility{
	@BeforeTest
	public void loginHRM()
	{
		WebDriver driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Orange HRm login Title:"+driver.getTitle());
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    String expTitle="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actTitle=driver.getCurrentUrl();
		Assert.assertEquals(expTitle, actTitle,"login failed");
		System.out.println("login successful");
	}
	@Test
	public void createPIM()
	{
		driver.findElement(By.cssSelector("ul.oxd-main-menu>*:nth-child(2)")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys("soham");
		driver.findElement(By.name("middleName")).sendKeys("prashant");
		driver.findElement(By.name("lastName")).sendKeys("Khunte");
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.cssSelector(".oxd-form *:nth-child(2)>div>*:nth-child(2)")).sendKeys("soahm");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		//WebElement employee=driver.findElement(By.cssSelector("div.oxd-table.orangehrm-employee-list>*:nth-child(2)>*:last-child>div>*:nth-child(3)>div"));
//	    Assert.assertTrue(employee.isDisplayed(),"Employee not added");
	    System.out.println("Employee added successfully");
		
	}
	@Test
	public void modifyPIM()
	{
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.cssSelector(".oxd-form *:nth-child(2)>div>*:nth-child(2)")).sendKeys("soahm");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector(".oxd-table-body div.oxd-table-card-cell-checkbox")).click();
		driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")).click();
		driver.findElement(By.xpath("//a[text()='Contact Details']")).click();
		driver.findElement(By.cssSelector(".oxd-form>div>div>*:nth-child(2)>div>*:last-child")).click();
		
		
	}

	@AfterTest
	public void logoutHRM()
	{
		driver.findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("logout successful");
		driver.close();
	}
	}


