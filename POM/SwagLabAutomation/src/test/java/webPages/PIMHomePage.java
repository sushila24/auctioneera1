package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PIMHomePage extends SeleniumUtility{
public PIMHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(css=".orangehrm-header-container>button")
private WebElement addEmpButton;

@FindBy(xpath="//div[div[label[text()='Employee Id']]]/div[2]/input")//directIndirectChild
private WebElement empIdInputField;

@FindBy(xpath="//button[@type='submit']")
private WebElement searchButtonOnPimPage;

@FindBy(css=".orangehrm-vertical-padding>span")
private WebElement searchResultCountMsg;

@FindBy(css=".oxd-table-body>div:nth-child(1) label")
private WebElement firstEmpCheckBox;

@FindBy(css=".oxd-table-body>div:nth-child(1) .bi-pencil-fill")
private WebElement firstEmpEditSymbol;//.oxd-table-body>div:nth-child(1)>div>div:nth-child(9)>div>button>.bi-pencil-fill

@FindBy(css=".oxd-table-body>div:nth-child(1) .bi-trash")
private WebElement firstEmpDeleteSymbol;

@FindBy(css=".orangehrm-modal-footer>button:nth-of-type(2)")
private WebElement yesButtonOnConfirmationPopup;
//Function: clickOn Add button
public void clickOnAddButton()
{
	clickOnElement(addEmpButton);
}
//Function: search employee
public void searchCreatedEmployee(int empId)
{
	typeInput(empIdInputField,String.valueOf(empId));
	setSleepTime(2000);
	clickOnElement(searchButtonOnPimPage);
	setSleepTime(2000);	
}
//Function: getSearchResultMsg
public String getSearchResultMsg()
{
	isElementExist(searchResultCountMsg);
	setSleepTime(2000);
	return getText(searchResultCountMsg);
}
//Function: clickOnEditSymbolOfCreatedEmployee
public void editCreatedEmployee(String jobTitle)
{
	clickOnElement(firstEmpCheckBox);
	clickOnElement(firstEmpEditSymbol);
}
//Function: deleteCreatedEmployee
	public void deleteCreatedEmployee() {
	clickOnElement(firstEmpCheckBox);
	clickOnElement(firstEmpDeleteSymbol);
	clickOnElement(yesButtonOnConfirmationPopup);
		
	}
}
