package MouseOpertn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.SeleniumUtil;

public class DragDropTolocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://jqueryui.com/droppable/");

Actions action=new Actions(driver);
driver.switchTo().frame(0);
WebElement src=driver.findElement(By.id("draggable"));
Thread.sleep(1000);
action.dragAndDropBy(src,100, 0).build().perform();
	}

}
