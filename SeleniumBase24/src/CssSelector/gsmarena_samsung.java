package CssSelector;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gsmarena_samsung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(500,600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.gsmarena.com/");
driver.findElement(By.cssSelector("div.brandmenu-v2>*:nth-child(2)>li>*:first-child")).click();

List<WebElement> samsungList=driver.findElements(By.cssSelector("div.makers>ul>li>a>*:nth-child(2)>*:nth-child(1)"));

System.out.println("samsung device count:"+samsungList.size());

for(WebElement samsung_devices:samsungList)
{
	System.out.println(samsung_devices.getText());
}

//or if
//for(int i=0;i<samsungList.size();i++)
//{
//	System.out.println(samsungList.get(i).getText());
//}
	}

}
