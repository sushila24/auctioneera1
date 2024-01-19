package CssSelector;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoblaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().setSize(new Dimension(500,600));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.demoblaze.com/");
List<WebElement> deviceList=driver.findElements(By.cssSelector("div#tbodyid>div>div>*:nth-child(2)>h4>a"));
List<WebElement> devicePrice=driver.findElements(By.cssSelector("div#tbodyid>div>div>*:nth-child(2)>h5"));

System.out.println("Device list count is:"+deviceList.size());

for(int i=0;i<deviceList.size();i++)
{
//	WebElement device=deviceList.get(i);
//	String devicename=device.getText();
//	System.out.println(devicename);
	System.out.println(deviceList.get(i).getText()+": "+devicePrice.get(i).getText());
				
}
	}

}
