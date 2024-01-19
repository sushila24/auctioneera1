package Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	public static WebDriver setUp(String browser, String url) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().setSize(new Dimension(500, 600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.navigate().refresh();
//		driver.navigate().back();
//		driver.navigate().forward();
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get(url);

		return driver;
	}

	// ****************sleep*******************
	public static void setSleep(long time) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// **************WaitForElementToBeClickable
	public static void waitForElementToBeCliickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// **************WaitForElementToBeVisible
	public static void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//// **************WaitForRequiredTitle
	public static void waitForrequiredTitle(String exp_Title) {
		wait.until(ExpectedConditions.titleIs(exp_Title));

	}

	// ********enter value into WebElement
	public static void typeInput(WebElement element, String value) {
		waitForElementToBeCliickable(element);
		element.clear();
		element.sendKeys(value);
	}

	// ********clickOnElement
	public static void clickOnElement(WebElement element) {
		waitForElementToBeCliickable(element);
		element.click();
	}

	// *******COPY-PASTE by Keyboard
	public static void copyPaste(WebElement src, WebElement dest) {
		src.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "C"));
		dest.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	// *******getPageTitle
	public static String getPageTitle(String title) {
		if (title != null) {
			waitForrequiredTitle(title);
			return driver.getTitle();
		} else {
			return driver.getTitle();
		}

	}
	//******1.get attributeValue based on attributeName
	public static String getAttriValue(WebElement element,String attributeName)
	{   wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute(attributeName);
	}
	//******2.Get Text from required WebElement
	public static String getText(WebElement element)
	{
		return element.getText();
	}
//*******3.get dropdown<select>
	public static List getDropdown(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		return options;
	}
	//******4.getDropdown option count
	public static int getDropdownOptionCount(WebElement element)
	{
		List<WebElement> options=getDropdown(element);
		return options.size();
	}
	//****5.get Select option from dropdown
	public static void selectFromDropDownBasedOnIndex(WebElement element,int index,String value)
	{  
		//List<WebElement> options=getDropdown(element);
	 Select select=new Select(element);
	 List<WebElement> list1=select.getOptions();
	 //list1.get(index).getText().click();
	 select.selectByIndex(index);
	 //select.selectByValue(value);//String value
	// select.selectByVisibleText(visibleText);//String visibleText
	  }
	//****6.check multiselect dropdown
	public static boolean isMultiSlect(WebElement element)
	{
		Select select=new Select(element);
		return select.isMultiple();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
