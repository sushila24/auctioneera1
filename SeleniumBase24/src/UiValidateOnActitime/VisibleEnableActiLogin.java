package UiValidateOnActitime;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibleEnableActiLogin {

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
//click on login
		driver.findElement(By.id("loginButton")).click();
		//locate username
		WebElement username=driver.findElement(By.id("username"));
		//get location of username field
		Point usernameFieldCords=username.getLocation();
		
		int username_Xcord=usernameFieldCords.getX();
		int username_Ycord=usernameFieldCords.getY();
		
		System.out.println("Username field X cordinate: "+username_Xcord);
		System.out.println("Username field Y cordinate: "+username_Ycord);
		
		//locate error msg
		WebElement errMsg=driver.findElement(By.id("errorMessagesArea"));
		
		//wait until error msg visible
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(errMsg));
	//location of errmsg
		Point errMsgCords=errMsg.getLocation();
		int errMsg_XCord=errMsgCords.getX();
		int errMsg_YCord=errMsgCords.getY();
		
		System.out.println("errMsg_XCord field X cordinate: "+errMsg_XCord);
		System.out.println("errMsg_YCord field Y cordinate: "+errMsg_YCord);
		
		//compare Y cords of username field n error msg
		
		System.out.println("Is error message getting displayed above username field?"+(errMsg_YCord<username_Ycord));
		
		
		

	}

}
