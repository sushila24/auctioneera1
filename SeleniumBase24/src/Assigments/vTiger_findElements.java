package Assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class vTiger_findElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://demo.vtiger.com/vtigercrm/index.php");
List<WebElement> elements=driver.findElements(By.className("used"));
System.out.println("Size of list"+elements.size());
System.out.println("1st element is:"+elements.get(0).getAttribute("placeholder"));
	System.out.println("2nd element is:"+elements.get(1).getAttribute("placeholder"));
	//username
	//elements.get(0).sendKeys("");
	WebElement username=elements.get(0);
	username.clear();
	username.sendKeys("admin");
	
	//elements.get(1).sendKeys("");-password
	WebElement pass=elements.get(1);
	pass.clear();
	pass.sendKeys("admin");
	System.out.println("credentials entered");
	driver.findElement(By.linkText("Sign in")).click();
	driver.close();
			
	}

}
