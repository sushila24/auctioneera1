package DropdownHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Example2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=autoTestReg.setUp("chrome", "https://www.letskodeit.com/practice");
WebElement dropdown=driver.findElement(By.id("multiple-select-example"));
Select sel=new Select(dropdown);
System.out.println("Is fruit dropdown is multiselect?"+sel.isMultiple());//true

List<WebElement> fruitList=sel.getOptions();
System.out.println("No.of options available:"+fruitList.size());
for(int i=0;i<fruitList.size();i++)
{
	System.out.println(fruitList.get(i).getText());
}

sel.selectByIndex(2);
Thread.sleep(2000);
sel.selectByValue("apple");
Thread.sleep(2000);
sel.selectByVisibleText("Orange");

System.out.println("Selected options from the list:"+sel.getAllSelectedOptions());

sel.deselectByIndex(2);
sel.deselectByValue("Apple");
sel.deselectByVisibleText("orange");
//or
//sel.deselectAll();
	}

}
