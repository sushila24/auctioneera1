package DropdownHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class countryDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=autoTestReg.setUp("chrome", "https://thompsonsj.com/bootstrap-select-dropdown/");

driver.findElement(By.cssSelector(".btn-primary")).click();

List<WebElement> countryList=driver.findElements(By.cssSelector(".dropdown-menu-right.show>div>a"));
System.out.println("No.of countries:"+countryList.size());

for(WebElement list:countryList)
{
	System.out.println(list.getText());
}
//for(int i=0;i<countryList.size();i++)
//{
//	System.out.println(countryList.get(i).getText());
//}
countryList.get(3).click();

	}

}
