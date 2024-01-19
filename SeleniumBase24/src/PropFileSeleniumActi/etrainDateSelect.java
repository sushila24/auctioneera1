package PropFileSeleniumActi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.SeleniumUtil;

public class etrainDateSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=SeleniumUtil.setUp("chrome","https://www.etrain.info/in");
//locate source station
driver.findElement(By.name("station1")).sendKeys("pune");//By.xpath("//input[@name='station1']");
//get suggestion list after typing pune
driver.findElement(By.cssSelector(".ui-menu>div>a")).click();
//Thread.sleep(1000);
SeleniumUtil.setSleep(2000);
//locate destination
driver.findElement(By.name("station2")).sendKeys("Mumbai");
//get suggestions after enter Mumbai//.ui-menu>*:nth-child(3)>a
driver.findElements(By.cssSelector(".ui-menu>div>a")).get(1).click();

//input[name=date] click on date
driver.findElement(By.name("date")).click();

//click on next >
driver.findElement(By.cssSelector("input.nav")).click();
//select date from 2nd 3rd or 4th row
//calenders date select .tblCont>table>tbody tr:nth-of-type(4)>td:nth-of-type(4)>input
driver.findElement(By.cssSelector(".tblCont tr:nth-of-type(4)>td:nth-of-type(4)>input")).click();//.tblCont>table tr:nth-of-type(4)>td:nth-of-type(4)>input





	}

}
