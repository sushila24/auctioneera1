package Day1BrowserOpen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class makeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
//open url makeMyTrip

driver.get("https://www.makemytrip.com/");

String expTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
//get actual title
String actTitle=driver.getTitle();
//validate
System.out.println("Is home page validate?"+actTitle.equals(expTitle));

	}

}
