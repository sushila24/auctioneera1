package CssSelector;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gsmarena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().setSize(new Dimension(500,600));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.gsmarena.com/");
List<WebElement> deviceList=driver.findElements(By.cssSelector("div.brandmenu-v2>*:nth-child(2)>li>a"));

System.out.println("Phone finder list size:"+deviceList.size());

for(WebElement ele:deviceList)
{
	System.out.println(ele.getText());
}
//for(int i=0;i<deviceList.size();i++)
//{
//	System.out.println(deviceList.get(i).getText());
//}


	}

}
