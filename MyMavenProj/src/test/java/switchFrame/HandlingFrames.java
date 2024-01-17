package switchFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlingFrames extends SeleniumUtility {
	@Test
	public void testFrames()
	{
		WebDriver driver=setUp("chrome", "https://jqueryui.com/droppable/");
		//Drag me to My target is present inside another frame so switch to thar frame
		//switch ur control to frame using WebElement
		WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(frame);//driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		//or driver.switchTo().frame(0);frameName/index/WebElement
		//use Actions class dragAndDrop(src,dest)
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dest=driver.findElement(By.id("droppable"));
		action.dragAndDrop(src, dest).build().perform();
		//get control back to main page
		driver.switchTo().defaultContent();
		//click on logo
		driver.findElement(By.cssSelector(".logo>a")).click();
		
	}

}
