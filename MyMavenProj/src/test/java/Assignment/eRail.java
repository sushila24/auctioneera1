package Assignment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class eRail extends SeleniumUtility {
	@Test
	public void catering()
	{
		WebDriver driver=setUp("chrome", "https://erail.in/");
		String homeWinId=driver.getWindowHandle();
		System.out.println("Home window id:"+homeWinId);
		System.out.println("Home page title:"+driver.getTitle());
		driver.findElement(By.xpath("//a[text()='eCatering']")).click();
		Set<String> allWinIds=driver.getWindowHandles();
		System.out.println("Opened window ids:"+allWinIds);
		allWinIds.remove(homeWinId);
		Iterator<String> itr=allWinIds.iterator();
		String cateringWin=itr.next();
		System.out.println("Catering window id:"+cateringWin);
		driver.switchTo().window(cateringWin);
		
		WebElement PNR=driver.findElement(By.xpath("//input[@placeholder='Search Train or Station to explore']"));
		//wait.until(ExpectedConditions.visibilityOf(PNR));
		PNR.click();//sendKeys("12627");
		driver.findElement(By.xpath("//input[@placeholder='Start typing Nagpur, NGP, Rajdhani']")).sendKeys("12627");
		driver.findElement(By.xpath("//button[text()='12627']")).click();
		WebElement dateSelect=driver.findElement(By.xpath("//input[@placeholder='Boarding Date']"));
		dateSelect.click();
	
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		//WebElement boardingStation=driver.findElement(By.cssSelector("div.relative.mb-6>select[placeholder=\"Boarding Station\"]"));
		WebElement boardingStation=driver.findElement(By.xpath("//select[@placeholder='Boarding Station']"));//.click();
		//boardingStation.click();
		
		//List<WebElement> station=driver.findElements(By.xpath(""));
		Select select=new Select(boardingStation);
		select.selectByValue("ET");
		driver.findElement(By.xpath("//button[text()='FIND FOOD']")).click();
		List<WebElement> hotelList=driver.findElements(By.cssSelector(".flex.bg-white.min-h-43.cursor-pointer.flex-wrap.gap-6.rounded.shadow-md>*:nth-child(2)>div>h5"));
		System.out.println("Hotel list:"+hotelList.size());
		for(int i=0;i<hotelList.size();i++)
		{
			System.out.println(hotelList.get(i).getText());	
		}
		driver.switchTo().window(homeWinId);
		WebElement from=driver.findElement(By.id("txtStationFrom"));
		action.moveToElement(from).doubleClick().sendKeys("pune").build().perform();
		driver.findElement(By.cssSelector("div[id^='Autocomplete_']>*:first-child")).click();
//		from.clear();
//		from.sendKeys("Pune");
		WebElement toStation=driver.findElement(By.id("txtStationTo"));
		action.moveToElement(toStation).doubleClick().sendKeys("Bangalore").build().perform();
//		toStation.clear();
//		toStation.sendKeys("Banglore");
		driver.findElement(By.cssSelector("")).click();
		System.out.println("Done");
		//driver.close();
//driver.findElement(By.xpath("//button[text()='Submit']")).click();
//		Set<String> allWinIds1=driver.getWindowHandles();
//		System.out.println("Opened window ids:"+allWinIds1);
		//driver.close();
		
	}

}
