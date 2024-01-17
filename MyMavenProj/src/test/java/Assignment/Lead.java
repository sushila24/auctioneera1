package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class Lead extends SeleniumUtility {
	@BeforeTest
	public void openConnection() {
		setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		typeInput(driver.findElement(By.id("username")), "admin");
		typeInput(driver.findElement(By.id("password")), "admin");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));
		System.out.println("Login successful");
	}

	@Test(priority = 1)
	public void createContact() throws InterruptedException {
		clickOnElement(driver.findElement(By.cssSelector("#appnavigator>div>span")));
		clickOnElement(driver.findElement(By.cssSelector("#MARKETING_modules_dropdownMenu")));
		clickOnElement(driver.findElement(By.xpath("//a[@title='Leads']")));
		// click on Add Lead
		clickOnElement(driver.findElement(By.id("Leads_listView_basicAction_LBL_ADD_RECORD")));
		// enter firstname n lastname
		typeInput(driver.findElement(By.id("Leads_editView_fieldName_firstname")), "Media");
		typeInput(driver.findElement(By.id("Leads_editView_fieldName_lastname")), "com");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		clickOnElement(driver.findElement(By.cssSelector(".Leads-module-action-content>div:nth-of-type(1)>p>a")));
		// checkbox
		clickOnElement(driver.findElement(By.cssSelector(".overflow-y>tr>td>div>span>input")));
		// click on edit pencil
		clickOnElement(driver.findElement(By.id("Leads_listView_massAction_LBL_EDIT")));
		// edit company name
		typeInput(driver.findElement(By.id("Leads_editView_fieldName_company")), "TESLA");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		System.out.println("Contact updated successfully!!");
		// select lead
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#Leads_listView_row_1>td>div>span>input"))));
		clickOnElement(driver.findElement(By.cssSelector("#Leads_listView_row_1>td>div>span>input")));
		// click on delete pencil
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Leads_listView_massAction_LBL_DELETE"))));
		clickOnElement(driver.findElement(By.id("Leads_listView_massAction_LBL_DELETE")));
		// click on yes
		clickOnElement(driver.findElement(By.xpath("//button[text()='Yes']")));
		System.out.println("record deleted successfully");

	}
	@AfterTest(enabled=false)
	public void logOut()
	{
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		clickOnElement(driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		cleanUp();
	}
}
