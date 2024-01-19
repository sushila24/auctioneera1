package PropFileSeleniumActi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utility.SeleniumUtil;

public class ActiLogUsingProperty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//find location of property file
		String filepath=".\\TestData\\test.properties";//D:\\workspace2023\\seleniumBasic-System.getProperty('user.dir')
		//open FileInputStream
		FileInputStream fis=new FileInputStream(filepath);
		
		Properties prop=new Properties();
		prop.load(fis);
		WebDriver driver=SeleniumUtil.setUp("chrome",prop.getProperty("url"));
		
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
		//validate home page
		String expHomeTitle=prop.getProperty("expHomePageTitle");
		SeleniumUtil.wait.until(ExpectedConditions.titleIs(expHomeTitle));
		String actHomeTitle=driver.getTitle();
		System.out.println("Is home page validate?"+actHomeTitle.equals(expHomeTitle));
		SeleniumUtil.wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		driver.findElement(By.id("logoutLink"));
	}

}
