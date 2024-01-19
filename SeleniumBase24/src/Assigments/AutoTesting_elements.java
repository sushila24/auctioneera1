package Assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTesting_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().minimize();
driver.manage().window().maximize();
driver.get("https://demo.automationtesting.in/Register.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//get all elements of registration page
List<WebElement> elements=driver.findElements(By.tagName("input"));//className:ng-invalid-required

System.out.println("Registration list elemnts count:"+elements.size());
//display all elements
for(int i=0;i<elements.size();i++)
{
	System.out.println("Element at "+i+" is : "+elements.get(i).getAttribute("placeholder"));
}
//for(Object obj:elements)
//{
//	System.out.println(obj);
//}
elements.get(0).sendKeys("sonali");
elements.get(1).sendKeys("khunte");
elements.get(2).sendKeys("Nanded city");
elements.get(3).sendKeys("abc@gmail.com");
elements.get(4).sendKeys("1234");
elements.get(5).click();
elements.get(8).sendKeys("English");
elements.get(9).sendKeys("India");
elements.get(10).sendKeys("goa");
//elements.get(11).sendKeys("admin");
//elements.get(12).sendKeys("admin");

//click on submit
driver.findElement(By.id("submitbtn")).click();
//click on reset
//driver.findElement(By.id("Button1")).click();
	}

}
