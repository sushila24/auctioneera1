package waits;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actitime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(500, 700));
//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//get url
		driver.get("https://online.actitime.com/testing/login.do");
//username

		WebElement username = driver.findElement(By.id("username"));

		username.clear();
		username.sendKeys("tester01@vomoto.com");
//pass
		WebElement pass = driver.findElement(By.name("pwd"));
		pass.sendKeys("manager");
//login button
		driver.findElement(By.id("loginButton")).click();

//validate home page
		String expTitle = "actiTIME - Enter Time-Track";
//we need external(conditional) wait as home page title taking time to update 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(expTitle));

		String actTitle = driver.getTitle();
		System.out.println("Home page title:"+actTitle);
		System.out.println("Home page validate?" + expTitle.equals(actTitle));

//wait until user clicks on logout
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));

		driver.findElement(By.id("logoutLink")).click();
		driver.close();

	}

}
