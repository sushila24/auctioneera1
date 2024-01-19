package Day1BrowserOpen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		String actTitle=driver.getTitle();
		String expTitle="Swag Labs";
		//page validation
		System.out.println("Is login page opened?"+actTitle.equals(expTitle));

	}

}
