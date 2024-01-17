package DDTExcel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.SeleniumUtility;

public class orangeHRMLogin extends SeleniumUtility{
	String appUrl;
	String username;
	String password;
	static int row=4;
	static String expTitle;
	static String actTitle;
	String filepath=".\\src\\test\\resources\\testdata\\AppTest.xlsx";
	@BeforeMethod
	public void getData()
	{
		appUrl=ExcelUtility.getCellvalue(filepath, "TC", row, 0);
		username=ExcelUtility.getCellvalue(filepath, "TC", row, 1);
		password=ExcelUtility.getCellvalue(filepath, "TC", row, 2);
		expTitle=ExcelUtility.getCellvalue(filepath, "TC", row, 3);
		
	}
	@Test
	public void testOrangeHRMLogin()
	{
		setUp("chrome", appUrl);
		typeInput(driver.findElement(By.name("username")), username);
		typeInput(driver.findElement(By.name("password")), password);
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		actTitle=getCurrentTitleOfApplication();
		Assert.assertEquals(actTitle,expTitle);
	}
	@AfterMethod
	public void cleanUp1()
	{
		ExcelUtility.updateExcelContent(filepath, "TC", row,4,actTitle);//row=5
		if(actTitle.equals(expTitle))
		{
			ExcelUtility.updateExcelContent(filepath, "TC", row,5, "PASSED");
		}
		else
			ExcelUtility.updateExcelContent(filepath, "TC", row,5,"FAiled");
	}
	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
		super.cleanUp();
	}
	

}
