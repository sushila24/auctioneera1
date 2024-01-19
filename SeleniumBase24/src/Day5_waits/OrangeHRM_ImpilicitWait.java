package Day5_waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_ImpilicitWait {

	public static void main(String[] args) {
		// generic way
		WebDriver driver=new ChromeDriver();
		//get url 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//maximize window
driver.manage().window().maximize();
//apply implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//username

WebElement username=driver.findElement(By.name("username"));
username.clear();
username.sendKeys("Admin");
//password

WebElement pass=driver.findElement(By.name("password"));
pass.clear();
pass.sendKeys("admin123");

//login
driver.findElement(By.className("orangehrm-login-button")).click();
//add conditional wait
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
String expTitle="OrangeHRM";
wait.until(ExpectedConditions.titleIs(expTitle));

String actTitle=driver.getTitle();

System.out.println("Is home page validate?"+expTitle.equals(actTitle));

//click on logout
//conditional  wait to click on logout
driver.findElement(By.className("oxd-userdropdown-name")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
driver.findElement(By.linkText("Logout")).click();;

driver.close();









	}

}
