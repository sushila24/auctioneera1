package DDTExcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.SeleniumUtility;

public class VtigerLoginExcel extends SeleniumUtility {
	String appUrl;
	String username;
	String pass;
	static String actTitle;
	static String expTitle;
	static int row = 2;
	//String filepath = ".\\src\\test\\resources\\testdata\\AppTest.xlsx";
	String filePath2=".\\src\\test\\resources\\testdata\\AppTest.xlsx";

	@BeforeMethod
	public void getData() {
		appUrl = ExcelUtility.getCellvalue(filePath2, "TC", row, 0);
		username = ExcelUtility.getCellvalue(filePath2, "TC", row, 1);
		pass = ExcelUtility.getCellvalue(filePath2, "TC", row, 2);
		expTitle = ExcelUtility.getCellvalue(filePath2, "TC", row, 3);

	}

	@Test
	public void testVtigerLogin() {
		setUp("chrome", appUrl);
		typeInput(driver.findElement(By.id("username")), username);
		typeInput(driver.findElement(By.id("password")), pass);
		clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));
		actTitle = getCurrentTitleOfApplication(expTitle);
		Assert.assertEquals(expTitle, actTitle);

	}

	@AfterMethod
	public void cleanUp1() {
		// FileOutputStream fos=new FileOutputStream(filepath2);
		ExcelUtility.updateExcelContent(filePath2, "TC", row, 4, actTitle);

		if (actTitle.equals(expTitle))
			ExcelUtility.updateExcelContent(filePath2, "TC", row, 5, "Passed");
		else
			ExcelUtility.updateExcelContent(filePath2, "TC", row, 5, "FAILED");
		cleanUp();
	}
}
