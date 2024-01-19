package UiValidateOnActitime;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Acti_UIValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//minimize
		driver.manage().window().setSize(new Dimension(400,600));
		//maximize window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open url
		driver.get("https://online.actitime.com/testing/login.do");
		//validation on username input field
		WebElement username=driver.findElement(By.id("username"));
		//username field visible /enabled(editable)/username field default value
		System.out.println("is Username field visible??"+username.isDisplayed());
		System.out.println("is Username field editable??"+username.isEnabled());
		System.out.println(" username field default value is-- "+username.getAttribute("placeholder"));
		//password
		WebElement password=driver.findElement(By.id("pwd"));
		//pass field is visible/enabled(functional)/default value
		System.out.println("Is password field is visible"+password.isDisplayed());
		System.out.println("Is password field is visible"+password.isEnabled());
		System.out.println("Default value of password field is :"+password.getAttribute("passsword"));
		
		//Keep Me Login Button Chckbox visible/clickable/selected?
		
		WebElement keepLoginChkBox=driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println("Is checkbox visible?"+keepLoginChkBox.isDisplayed());
		System.out.println("Is checkbox already selected?"+keepLoginChkBox.isSelected());
		System.out.println("Is checkbox clickable?"+keepLoginChkBox.isEnabled());
		keepLoginChkBox.click();
		System.out.println("Is checkbox  selected now?"+keepLoginChkBox.isSelected());
		
		//Login Button visible/clickable/print text on login button?
		
		WebElement login=driver.findElement(By.id("loginButton"));
		System.out.println("Is login button visible?"+login.isDisplayed());
		System.out.println("Is login button clickable?"+login.isEnabled());
		System.out.println("Text on login button:"+login.getText());

	}

}
