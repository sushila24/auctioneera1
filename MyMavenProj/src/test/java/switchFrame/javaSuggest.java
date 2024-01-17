package switchFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class javaSuggest extends SeleniumUtility {
	@Test
	public void testFrames()
	{
		WebDriver driver=setUp("chrome", "https://jqueryui.com/autocomplete/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("ja");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println("1st suggestion is:");//+list.get(0).getText());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		list.get(0).click();
	}
}
/**
===============================================
    Default test
    Tests run: 1, Failures: 1, Skips: 0
===============================================

#
# There is insufficient memory for the Java Runtime Environment to continue.
# Native memory allocation (malloc) failed to allocate 32784 bytes for Chunk::new
# An error report file with more information is saved as:
# D:\workspace2023\FirstProject\hs_err_pid11888.log

===============================================
Default suite
Total tests run: 1, Passes: 0, Failures: 1, Skips: 0
===============================================

[thread 3552 also had an error]
[thread 3100 also had an error]
#
# Compiler replay data is saved as:
# D:\workspace2023\FirstProject\replay_pid11888.log
*/


