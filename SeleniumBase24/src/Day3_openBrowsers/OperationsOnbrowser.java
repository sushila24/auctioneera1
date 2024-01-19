package Day3_openBrowsers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperationsOnbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.google.com");

//maximize 
driver.manage().window().maximize();
//min
driver.manage().window().setSize(new Dimension(500,600));
//get url
String url=driver.getCurrentUrl();
//get title
String title=driver.getTitle();
//get pagesource
String pagesource=driver.getPageSource();
System.out.println("CurrentUrl length:"+url.length());
System.out.println("title length:"+title.length());
System.out.println("pagesource length:"+pagesource.length());

	}

}
