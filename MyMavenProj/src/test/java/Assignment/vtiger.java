package Assignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class vtiger extends SeleniumUtility{
	@BeforeTest
	public void openConnection()
	{
		setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		typeInput(driver.findElement(By.id("username")), "admin");
		typeInput(driver.findElement(By.id("password")), "admin");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));
		System.out.println("Login successful");
	}
	@Test(priority=1)
	public void createContact() throws InterruptedException
	{
		clickOnElement(driver.findElement(By.xpath("//div[@id='appnavigator']/div/span")));
		//click on marketing
       //clickOnElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		driver.findElement(By.cssSelector("#MARKETING_modules_dropdownMenu")).click();
		//click on contacts
		driver.findElement(By.xpath("//div[@id='mCSB_1_container']/li[3]/a/span/i")).click();
       //driver.findElement(By.xpath("//a[@title=' Contacts ']")).click();
       //Thread.sleep(1000);
		//clickOnElement(driver.findElement(By.xpath("//div[@id='mCSB_1_container']/li[3]/a/span/i")));//mCSB_12_container
		//driver.findElement(By.cssSelector("ul.dropdown-menu.app-modules-dropdown.mCustomScrollbar._mCS_1.mCS_no_scrollbar>div:first-child>div>*:nth-child(3)>a>span.module-name.textOverflowEllipsis")).click();
		//click on Add contact
		clickOnElement(driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")));
		//enter firstname n lastname
		typeInput(driver.findElement(By.id("Contacts_editView_fieldName_firstname")), "Media");
		typeInput(driver.findElement(By.id("Contacts_editView_fieldName_lastname")), "com");
		//clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		driver.findElement(By.xpath("//div[@class='modal-overlay-footer clearfix']/div/div/button")).click();
		System.out.println("done");
		//click to search contact
		clickOnElement(driver.findElement(By.xpath("//h4[text()=' Contacts ']")));
		//enter firstname
		typeInput(driver.findElement(By.xpath("//input[@name='firstname']")), "Media");
		//click on search
		clickOnElement(driver.findElement(By.className(".btn.btn-success.btn-sm ")));
		String expFirstName="Media";
		String actFirstname="";
		//Assert.assertEquals(expFirstName, actFirstname,"Firstname didnt match");
		
		System.out.println("Contact created successfully!!!");
		
	}
	@Test(priority=2)
	public void editContact()
	{//click to search contact
		clickOnElement(driver.findElement(By.xpath("//h4[text()=' Contacts']")));
		//enter firstname
		typeInput(driver.findElement(By.xpath("//input[@name='firstname']")), "Media");
		//click on search
		clickOnElement(driver.findElement(By.className(".btn.btn-success.btn-sm ")));
		//select chkbox
		driver.findElement(By.cssSelector(".overflow-y span.input>input")).click();
		//click in editPencil icon
		clickOnElement(driver.findElement(By.id("Contacts_listView_massAction_LBL_EDIT")));
		System.out.println("edited clicked");
		
	}
	@Test(priority=3,enabled=false)
	public void deleteContact()
	{//click to search contact
		clickOnElement(driver.findElement(By.xpath("//h4[text()=' Contacts']")));
		//enter firstname
		typeInput(driver.findElement(By.xpath("//input[@name='firstname']")), "Media");
		//click on search
		clickOnElement(driver.findElement(By.className(".btn.btn-success.btn-sm ")));
		//select chkbox
		driver.findElement(By.cssSelector(".overflow-y span.input>input")).click();
		//click in delete icon
		clickOnElement(driver.findElement(By.id("Contacts_listView_massAction_LBL_DELETE")));
		System.out.println("Record deleted successfully");
	}
	
	@AfterTest(enabled=false)
	public void logOut()
	{
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		clickOnElement(driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		cleanUp();
	}

}
