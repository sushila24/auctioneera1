package switchFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class ActiveElement extends SeleniumUtility{
	@Test
	public void loginwithoutFindEle()
	{
		WebDriver driver=setUp("chrome", "https://demowebshop.tricentis.com/login");
		driver.findElement(By.className("ico-login")).click();
		//WebElement Email field getAttribute
		WebElement email=driver.switchTo().activeElement();
		String activeObjName=email.getAttribute("name");
		String expName="Email";
		Assert.assertEquals(activeObjName,expName,"Cursor pointer validation unsuccessful");
		//login into appln without identifying any object
		driver.switchTo().activeElement().sendKeys("tester01@vomoto.com",Keys.TAB);//email.sendKeys("",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Abc@12345",Keys.ENTER);
		System.out.println("Login successfull");
	}

	
}
