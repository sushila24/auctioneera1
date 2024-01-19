package Day1BrowserOpen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();

driver.get("https://www.amazon.com/");

String expTitle="Amazon.com. Spend less. Smile more.";
String actTitle=driver.getTitle();

System.out.println("Is home page validate?"+expTitle.equals(actTitle));
 
driver.close();

	}

}
