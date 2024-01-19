package Day1_browseropen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class operationsOnBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open browser
				WebDriver driver=new ChromeDriver();//runtime poly Is-a overriding upcasting
				//Enter appl url
				driver.get("https://www.google.com");
				//get appln title
			String pageTitle=driver.getTitle();
			System.out.println("page title is:"+pageTitle);
			System.out.println("page title length:"+pageTitle.length());
				//get current url from browser
			String currUrl=	driver.getCurrentUrl();
			System.out.println("current url is:"+currUrl);
			System.out.println("current url length:"+currUrl.length());
				//get page sorce code of applS
			
			String pageSource=driver.getPageSource();
			System.out.println("pageSource is:"+currUrl);
			System.out.println("pageSource length:"+pageSource.length());
				
			//close the browser
			driver.close();
	}

}
