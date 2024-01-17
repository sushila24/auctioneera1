package switchWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class testNewWindow extends SeleniumUtility{
	@Test
	public void testWindow()
	{
		WebDriver driver=setUp("chrome", "https://etrain.info/in");
		//get current window uniqueId
		String homeWindowId=driver.getWindowHandle();
		System.out.println("Home page window Handle="+homeWindowId);
		//click on facebook link
		driver.findElement(By.xpath("//div[p[text()='Connect With Us']]/div/a[1]")).click();
		//connect with us independant child FB Twitter/LinkedIn/youTube-dependant child
		//get all windows unique Ids in set which are opened by driver(selenium current instance)
		Set<String> allWindowIds=driver.getWindowHandles();
		System.out.println("All window Ids:"+allWindowIds);
		//remove homeWindowId from set to get childWimdow Id
		allWindowIds.remove(homeWindowId);
		System.out.println("After removing HomeWindow Id,allWindowId:"+allWindowIds);
		//get child window Id using iterator
		Iterator<String> itr=allWindowIds.iterator();
		String childWinId=itr.next();
		//switch to child window
		driver.switchTo().window(childWinId);
		//or
		//driver.switchTo().window(allWindowIds.iterator().next());
		
		//now we can identify any element from child window
		System.out.println("Facebook page title:"+driver.getTitle());
		System.out.println("Facebook page Url:"+driver.getCurrentUrl());
		
		driver.close();//closes current instance of browserwindow
		//driver.quit();//closes all windows which are opened by selenium driver
		//switch back to home page window in order to perform any required operation on that
		driver.switchTo().window(homeWindowId);
		//now u r allowed to identify any element from homeWindow
		System.out.println("Etrain page title:"+driver.getTitle());
		System.out.println("Etrain page URL"+driver.getCurrentUrl());
		driver.close();
		//driver.quit();
		
	}

}
