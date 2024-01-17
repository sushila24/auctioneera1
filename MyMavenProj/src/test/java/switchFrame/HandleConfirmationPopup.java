package switchFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandleConfirmationPopup extends SeleniumUtility{
	@Test
	public void testConfirmPopup()
	{
		WebDriver driver=setUp("chrome","https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//switch into frame as Try It button is in the frame
		driver.switchTo().frame(0);
		driver.switchTo().frame("iframeResult");//frameName
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));//frame web element
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//get text present on popUp window
		System.out.println("confirmation popup msg:"+driver.switchTo().alert().getText());
		//To perform another action on alert,we need to again switch our contrl to the alert
		
		//confirmation popup will come
		driver.switchTo().alert().accept();//to click OK
		//driver.switchTo().alert().dismiss();//to click cancel
		
		
		
	}

}
/*In order to handle any JavaScript PopUp we need driver.switchTo().alert();
 * bcoz JavaScript PopUp doesnt contain any HTML code
 * 	We use Predefined functions of Alert class to perform operations 
 * after every action control goes back to main page
 */
	