package MouseOpertn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.SeleniumUtil;

public class DragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://jqueryui.com/droppable/");
//drag 1 source to destination
WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
WebElement dest=driver.findElement(By.xpath("//div[@id='droppable']"));
Actions action=new Actions(driver);
driver.switchTo().frame(0);//compulsary to switch to the frame 
action.dragAndDrop(source, dest).build().perform();
//if destination element not known
//action.dragAndDropBy(source, 50, 50).build().perform();

	}

}
