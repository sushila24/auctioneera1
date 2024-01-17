package switchFrame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class promptPopup extends SeleniumUtility {
	@Test
	public void prompt()
	{
		WebDriver driver=setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		//as the required elemnet is present inside another frame switchTo() that frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		System.out.println("Alert text message is:"+driver.switchTo().alert().getText());
		//to perform another action on alert we need to switch control again to the alert
		driver.switchTo().alert().sendKeys("Pune");
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}

}
