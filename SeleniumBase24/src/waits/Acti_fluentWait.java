package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Acti_fluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().setSize(new Dimension(500,600));
driver.manage().window().maximize();
//implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//enter url
driver.get("");
//username
driver.findElement(By.id("username")).sendKeys("tester01@vomoto.com");
//pass
driver.findElement(By.id("pwd")).sendKeys("manager");
//signin button
	driver.findElement(By.id("loginButton")).click();
	
	//validate home page
	String ExpHomeTitle="actiTIME - Enter Time-Track";
	//here we need to add conditional wait as  page title taking time to update
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	//wait.until(ExpectedConditions.titleIs(ExpHomeTitle));
	
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(20))//max time
			.pollingEvery(Duration.ofSeconds(5))//retry
			.ignoring(NoSuchElementException.class);//to handle exception
	
	wait.until(ExpectedConditions.titleIs(ExpHomeTitle));
	
	String ActHomeTitle=driver.getTitle();
	System.out.println("Is home page validate?"+ExpHomeTitle.equals(ActHomeTitle));
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
	driver.findElement(By.id("logoutLink")).click();
	driver.close();
	
	}

}
