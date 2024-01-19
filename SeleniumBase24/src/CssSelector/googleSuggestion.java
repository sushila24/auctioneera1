package CssSelector;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().setSize(new Dimension(500,600));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.google.com/");
driver.findElement(By.name("q")).sendKeys("selenium");

List<WebElement> suggestion_list=driver.findElements(By.cssSelector("ul.G43f7e>li>div>*:nth-child(2)>*:first-child>*:first-child>span"));
System.out.println("Suggestion list count:"+suggestion_list.size());

for(int i=0;i<suggestion_list.size();i++)
{
	System.out.println(suggestion_list.get(i).getText());
	//WebElement element=suggestion_list.get(i);
	//String sugg=element.getText();System.out.println(sugg);
}

	}

}
