package Day1BrowserOpen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipcartValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();

driver.get("https://www.flipkart.com/");

String expTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
 
String actTitle=driver.getTitle();

System.out.println("Is home page validate?"+expTitle.equals(actTitle));

	}

}
