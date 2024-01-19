package Assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangeHRM_muliElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().setSize(new Dimension(500,600));

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//get username n passs in single locator
List<WebElement> elements=driver.findElements(By.className("oxd-input"));
System.out.println("Identified list elements:"+elements);
System.out.println("List size:"+elements.size());
System.out.println("1st element is:"+elements.get(0).getAttribute("placeholder"));
System.out.println("2nd element is:"+elements.get(1).getAttribute("placeholder"));

elements.get(0).sendKeys("Admin");
elements.get(1).sendKeys("admin123");
driver.findElement(By.className("orangehrm-login-button")).click();
driver.close();


	}

}
