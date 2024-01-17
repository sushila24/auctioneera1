package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class PIMOrangeHRM extends SeleniumUtility {
	@BeforeTest
	public void openConnection()
	{
		WebDriver driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Orange HRm login Title:"+driver.getTitle());
	}
	@Test(priority=1)
		public void craetePIM() {
			
			WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		username.clear();username.sendKeys("Admin");
			typeInput(username, "Admin");
			WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
	// apass.clear();pass.sendKeys("admin123");
			typeInput(pass, "admin123");
			// click login
			//driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
			clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
			// click on PIM
			driver.findElement(By.xpath("//span[text()='PIM']")).click();// ul.oxd-main-menu>*:nth-child(2)
			// click on Add Employee
			driver.findElement(By.linkText("Add Employee")).click();
			// enter firstname
			driver.findElement(By.name("firstName")).sendKeys("soham");
			// enter middlename
			driver.findElement(By.name("middleName")).sendKeys("Prashant");
			// enter lastname
			driver.findElement(By.name("lastName")).sendKeys("Khunte");
			// enter id as 1007
			WebElement empId=driver.findElement(By.cssSelector(".orangehrm-employee-form>div>*:nth-child(2)>div>div>*:nth-child(2)>input"));
			action.doubleClick(empId).sendKeys("111");
//			empId.clear();
//			empId.sendKeys("111");
			// click on save
			driver.findElement(By.cssSelector(".orangehrm-left-space")).click();
			//
			System.out.println("PIM Created successfully"); 
	}
	@Test(priority = 2)
	public void editPIM() {
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		WebElement empId=driver.findElement(By.cssSelector(".oxd-table-filter-area *:nth-child(2) *:nth-of-type(2)>input"));
		empId.clear();
		empId.sendKeys("100");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// click on checkbox
		driver.findElement(By.cssSelector(".oxd-table-body div.oxd-table-card-cell-checkbox")).click();
		// click on edit
		driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")).click();
		driver.findElement(By.xpath("//a[text()='Contact Details']")).click();
		driver.findElement(By.cssSelector(".oxd-form-row div:nth-child(5) div:nth-child(2)>input")).sendKeys("411028");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("PIM record Edited successfully");
		//find record in below list
		//Assert.assertEquals

	}
	@Test(priority = 3)
	public void deletePIM() {
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		//driver.findElement(By.cssSelector(".oxd-table-filter-area *:nth-child(2) *:nth-of-type(2)>input")).sendKeys("100");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// click on checkbox
		driver.findElement(By.cssSelector(".oxd-table-body div.oxd-table-card-cell-checkbox")).click();
		// click on delete button
		driver.findElement(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space")).click();
		System.out.println("PIM record deleted successfully");

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
