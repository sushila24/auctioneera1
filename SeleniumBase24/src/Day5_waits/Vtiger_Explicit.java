package Day5_waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vtiger_Explicit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://demo.vtiger.com/vtigercrm/index.php");
driver.manage().window().maximize();
//implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//username
WebElement username=driver.findElement(By.id("username"));
username.clear();
username.sendKeys("admin");
//pass

WebElement pass=driver.findElement(By.id("password"));
pass.clear();
pass.sendKeys("admin");
//login
driver.findElement(By.linkText("Sign in")).click();

//validate homepage title

String expHomeTitle="Dashboard";
//conditional wait coz time taking to load home page title
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
wait.until(ExpectedConditions.titleIs(expHomeTitle));
String actHomeTitle=driver.getTitle();
System.out.println("Is homepageValidate?"+expHomeTitle.equals(actHomeTitle));

//logout
WebElement logout=driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT"));
logout.click();
wait.until(ExpectedConditions.elementToBeClickable(logout));






	}

}
