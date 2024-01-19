package MouseOpertn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.SeleniumUtil;

public class HoverOnAutoReg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.automationtesting.in/Register.html");
List<WebElement> list=driver.findElements(By.cssSelector(".navbar-nav>li"));
Actions action=new Actions(driver);
System.out.println("Menu list size=:"+list.size());
for(int i=0;i<list.size();i++)
{
	String menu=list.get(i).getText();
	action.moveToElement(list.get(i)).perform();
}
//hover on particular element

//action.moveToElement(list.get(2)).perform();//webTable
//action.moveToElement(list.get(2),100,0).perform();
//WebElement ele=list.get(3);
//action.moveToElement(ele,100, 0);
	}

}
