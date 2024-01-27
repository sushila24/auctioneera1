package webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PIMAddEmployeePage extends SeleniumUtility{
	public PIMAddEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//input[@name='firstName']")
private WebElement firstNameField;

@FindBy(xpath="//input[@name='lastName']")
private WebElement lastNameField;

@FindBy(xpath="//div[div[label[text()='Employee Id']]]/div[2]/input")
private WebElement employeeIdField;

@FindBy(xpath="//button[@type='submit']")
private WebElement submitButton;

public void createEmployee(String fname,String lname,int empId)
{
	typeInput(firstNameField, fname);
	typeInput(lastNameField, lname);
	setSleepTime(2000);
	getActiveElement().sendKeys(Keys.TAB,Keys.BACK_SPACE);
	waitForElementDisplayed(employeeIdField);
	//employeeIdField.clear();
	typeInput(employeeIdField,String.valueOf(empId));
	clickOnElement(submitButton);
}
}
