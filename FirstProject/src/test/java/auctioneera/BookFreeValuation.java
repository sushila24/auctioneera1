package auctioneera;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class BookFreeValuation extends SeleniumUtility{

	@BeforeTest
	public void pre()
	{
		setUp("chrome", "https://www.auctioneera.ie/");
	}
		@Test(priority=1,enabled=false)
		public void reqCallback()
		{
			//driver.get("https://www.auctioneera.ie/book-free-valuation");
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[4]/a[1]")).click();
			WebElement countyDropdown=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[1]/select[1]"));
			
			Select select=new Select(countyDropdown);
			List<WebElement> countyList=select.getOptions();
			select.selectByIndex(2);
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[2]/input[1]")).sendKeys("Tester");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sushilasym@gmail.com");
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[4]/input[1]")).sendKeys("1231233111");
			WebElement requestCallback=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/p[1]"));
			System.out.println(requestCallback.getText());
	
		}
		@Test(priority=2)
		public void scheduleValuation()
		{
			driver.findElement(By.linkText("Home")).click();
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[4]/a[1]")).click();
			WebElement countyDropdown=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[1]/select[1]"));
			
			Select select=new Select(countyDropdown);
			List<WebElement> countyList=select.getOptions();
			select.selectByIndex(2);
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[2]/input[1]")).sendKeys("Tester");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sushilasym@gmail.com");
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/p[4]/input[1]")).sendKeys("1231233111");
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/p[1]")).click();//schedule valuation btn
			String expTitle="Add Property";
			wait.until(ExpectedConditions.titleIs(expTitle));
			//property radiobox
			driver.findElement(By.xpath("//input[@id='estate_property']")).click();
			//property address
			driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("south");
			driver.findElement(By.xpath("//select[@id='area_id']")).click();
			//Area Id dropdown List
			WebElement areaDropdown=driver.findElement(By.xpath("//select[@id='area_id']"));
			Select area=new Select(areaDropdown);
			area.selectByIndex(3);
			//System.out.println(area.getOptions());
			//property condition New/Secondhand
			WebElement propCondition=driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]"));
			Select propConditionSel=new Select(propCondition);
			propConditionSel.selectByIndex(1);
			//bedrooms
			driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/label[3]/input[1]")).click();
			WebElement bedrooms=driver.findElement(By.xpath("//select[@id='bedrooms']"));
			Select bedroom=new Select(bedrooms);
			bedroom.selectByIndex(3);
			//No.of Bathrooms
			WebElement bathrooms=driver.findElement(By.xpath("//select[@id='add_bathrooms']"));
			Select bathroom=new Select(bathrooms);
			bathroom.selectByIndex(3);
			//ensuite bathrooms
			WebElement ensuit_bathrooms=driver.findElement(By.xpath("//select[@id='add_ensuite_bathrooms']"));
			Select ensuit_bathroom=new Select(ensuit_bathrooms);
			ensuit_bathroom.selectByIndex(3);
			//occupancy
			WebElement occupancy=driver.findElement(By.xpath("//select[@id='occupancy']"));
			Select occupancy_sel=new Select(occupancy);
			occupancy_sel.selectByIndex(1);
			
			//select date //div[1]/div[4]/div[7]//div[2]/div[3]//select
			WebElement selectDate=driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[4]/div[7]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]"));
			Select date_sel=new Select(selectDate);
			date_sel.selectByIndex(2);
			
			//select time
			driver.findElement(By.xpath("//div[contains(text(),'11:00')]")).click();
			
			//schedule my valuation
			driver.findElement(By.xpath("//input[@value='Schedule My Valuation']"));//.click
			
			//wait.until(ExpectedConditions.visibilityOf(selectDate))
			
			
		}
}
