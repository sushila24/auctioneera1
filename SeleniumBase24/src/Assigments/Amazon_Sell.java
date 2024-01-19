package Assigments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Sell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
//minimize screen
driver.manage().window().setSize(new Dimension(500,600));
//maximize
driver.manage().window().maximize();
//open url
driver.get("https://www.amazon.in/");

//implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//get home page title
String home_Title=driver.getTitle();
System.out.println("Amazon home page title is:"+home_Title);

//click on sell n print sell page title
driver.findElement(By.linkText("Sell")).click();
String Exp_Sell_Page_Title="Amazon.in: CrossShop1";
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

wait.until(ExpectedConditions.titleIs(Exp_Sell_Page_Title));
String Act_Sell_page_Title=driver.getTitle();
System.out.println("Sell page title is:"+Act_Sell_page_Title);
System.out.println("Is sell page validate?"+Act_Sell_page_Title.equals(Exp_Sell_Page_Title));
//navigate back'
driver.navigate().back();
System.out.println("Back to home");
String Current_home_title=driver.getTitle();
System.out.println("Home page title is:"+Current_home_title);
//compare current title with home page title
System.out.println("Is home page loaded again?"+Current_home_title.equals(home_Title));

driver.close();

	}

}
