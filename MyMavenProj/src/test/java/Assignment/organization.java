package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class organization extends SeleniumUtility {
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
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("ul.dropdown-menu._mCS_1.mCS_no_scrollbar>div>div>li>a>*:nth-of-type(2)"))));
		// clickOnElement(driver.findElement(By.cssSelector("ul.dropdown-menu._mCS_1.mCS_no_scrollbar>div>div>li:nth-of-type(4)>a>*:nth-of-type(2)")));
		// select contact option
		// driver.findElement(By.xpath("//div[@id='mCSB_1_container']/li[3]")).click();
		List<WebElement> options = driver.findElements(By.cssSelector("ul.dropdown-menu._mCS_1.mCS_no_scrollbar>div>div>li>a>*:nth-of-type(2)"));
		WebElement contact = options.get(2);
		clickOnElement(contact);
		// click on Add contact
		clickOnElement(driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")));
		// enter firstname n lastname
		typeInput(driver.findElement(By.id("Contacts_editView_fieldName_firstname")), "Media");
		typeInput(driver.findElement(By.id("Contacts_editView_fieldName_lastname")), "com");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		clickOnElement(driver.findElement(By.cssSelector(".Contacts-module-action-content>div:nth-of-type(1)>p>a")));
		//checkbox
		clickOnElement(driver.findElement(By.cssSelector(".overflow-y>tr>td>div>span>input")));
		//click on edit pencil
		clickOnElement(driver.findElement(By.id("Contacts_listView_massAction_LBL_EDIT")));
		typeInput(driver.findElement(By.id("Contacts_editView_fieldName_title")), "MRS");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		System.out.println("Contact updated successfully!!");
		
		//select contact
		clickOnElement(driver.findElement(By.cssSelector(".overflow-y>tr>td>div>span>input")));
		//click on delete pencil
		clickOnElement(driver.findElement(By.id("Contacts_listView_massAction_LBL_DELETE")));
		//click on yes
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
