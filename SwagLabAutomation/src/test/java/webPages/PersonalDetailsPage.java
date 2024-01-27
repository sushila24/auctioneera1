package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PersonalDetailsPage extends SeleniumUtility{
public PersonalDetailsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
//Job Link
@FindBy(xpath="//a[text()='Job']")
private WebElement jobTab;
//Job Title Dropdown
@FindBy(css=".oxd-form div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2)")
private WebElement jobDropdown;

	//Job Title Dropdown Elements
	
	//Save Button
	
	//Function: Update PIM
}
