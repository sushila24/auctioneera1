package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(500,600));
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
		//validate login page
		String expTitle="Swag Labs";
		String actTitle=driver.getTitle();
		System.out.println("is login page validate?"+expTitle.equals(actTitle));
		//enter username n pass
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//click on navigation panel
		driver.findElement(By.id("react-burger-menu-btn")).click();
		//click on logout
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
