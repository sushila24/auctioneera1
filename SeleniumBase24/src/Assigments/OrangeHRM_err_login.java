package Assigments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_err_login {

	public static void main(String[] args) {
		// TODO 1.open chrome-orangeHrm url
		//2.click on login
		//3.validate 1.error msg color 2.error msg below username field
		//4.get username n password from UI
		//5.enter username n pass
		//6.click on login
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(500,600));
		driver.manage().window().maximize();
		//get url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//click on login
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//click on login
		//WebElement Login=
		driver.findElement(By.className("orangehrm-login-button")).click();
		//Login.click();
		//add conditional wait
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				//String expTitle="OrangeHRM";
				//wait.until(ExpectedConditions.titleIs(expTitle));

		WebElement err_msg=driver.findElement(By.className("oxd-input-field-error-message"));
		
		wait.until(ExpectedConditions.visibilityOf(err_msg));
		
		String err_msg_color=err_msg.getCssValue("color");
		System.out.println("Error msg color:"+err_msg_color);
		
		//validate error below username field
		//get cords of username
		WebElement username=driver.findElement(By.name("username"));
		Point username_cords=username.getLocation();
		//int username_Xcord=username_cords.getX();
		int username_Ycord=username_cords.getY();
		
		//get cords of err msg
		Point errMsg_cords=err_msg.getLocation();
		//int err_msg_Xcord=errMsg_cords.getX();
		int err_msg_Ycord=errMsg_cords.getY();
		System.out.println("Y cord of username:"+username_Ycord+" and Error msg:"+err_msg_Ycord);
		System.out.println("Is error msg displayed below uername field:"+(username_Ycord<err_msg_Ycord));
		//get username n pass from UI
		
		//WebElement usernameValue=driver.findElement(By.className("oxd-text oxd-text--p"));
		
		username.sendKeys("");
		driver.findElement(By.name("password")).sendKeys("");
		//Login.click();
		
	}

}
