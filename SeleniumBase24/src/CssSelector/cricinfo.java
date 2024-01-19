package CssSelector;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();

driver.manage().window().setSize(new Dimension(500,600));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//driver.navigate().back();driver.navigate().refresh();driver.navigate().forward();driver.navigate().to("https://www.google.com/");
driver.get("https://www.espncricinfo.com/");

List<WebElement> menuList=driver.findElements(By.cssSelector("div.ds-items-center.ds-justify-between>*:nth-child(1)>div>a"));
System.out.println("Menu count:"+menuList.size());

//for 
for(int i=0;i<menuList.size();i++)
{
	WebElement list=menuList.get(i);
	String list_item=list.getText();
	System.out.println(list_item);
	//or
	//System.out.println(menuList.get(i).getText());
}
//for each
//for(WebElement menuList1:menuList)
//{
//	System.out.println(menuList1.getText());
//}

driver.close();	
	}

}
