package switchFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlealertPopup extends SeleniumUtility{
	@Test
	public void tsetAlert()
	{
		WebDriver driver=setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		//click on try it!
		//as try it button is present inside the frame,so need to switch our control inside the frame<iframe>
		//driver.switchTo().frame(0);//frameNumber
		driver.switchTo().frame("iframeResult");//frameName
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));//
//Now click on try it!
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		System.out.println("Alert popup Text msg is:"+driver.switchTo().alert().getText());
		//To perform another action on alert,we need to again switch our contrl to the alert
		//now popup will come dn click ok //no inspect//no HTML code
		//javascript popup
		driver.switchTo().alert().accept();
	/*In order to handle any JavaScript PopUp we need driver.switchTo().alert();
	 * bcoz JavaScript PopUp doesnt contain any HTML code
	 * 	We use Predefined functions of Alert class to perform operations 
	 * after every action control goes back to main page
	 */
		
	}

}
