package Assignment;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class swagLab extends SeleniumUtility{
	@BeforeTest
	  public void openConnection()
	  {
		  setUp("chrome", "https://www.saucedemo.com/");
		  typeInput(driver.findElement(By.id("user-name")), "standard_user");
		  typeInput(driver.findElement(By.id("password")), "secret_sauce");
		  clickOnElement(driver.findElement(By.id("login-button")));
	  }
  @Test
  public void swag() {
	  
	 
	  //add to cart
	
	  clickOnElement(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")));
	  clickOnElement(driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")));
	  
	  
	  //click on the shopping cart button
	  driver.findElement(By.className("shopping_cart_link")).click();//By.id("shopping_cart_container")
	  
	  //click on the checkout button
	  driver.findElement(By.className("checkout_button")).click();
	  
	  //fill the personal details
	  typeInput(driver.findElement(By.id("first-name")), "ABC");
	  typeInput(driver.findElement(By.id("last-name")), "XYZ");
	  typeInput(driver.findElement(By.id("postal-code")), "411054");
	  clickOnElement(driver.findElement(By.id("continue")));
	  //driver.findElement(By.className("cart_button")).click();//id=continue
	  
	  //items purchased list
	  List<WebElement> items=driver.findElements(By.cssSelector(".inventory_item_name"));
	  //concept of Independant(Item) n dependant child(Item price)
	  List<WebElement> prices=driver.findElements(By.xpath("//div[a[div[@class='inventory_item_name']]]/div[2]/div"));
	  
	  System.out.println("Items purchased:");
	  for(int i=0;i<items.size();i++)
	  {
		  System.out.println(items.get(i).getText()+":"+prices.get(i).getText());
	  }
	  //check total without tax
	  String itemsTotal=driver.findElement(By.cssSelector(".summary_subtotal_label")).getText();
	  System.out.println("Purchased items total withot tax="+itemsTotal);
	  //.cart_item>*:nth-child(2)>a>div-cart item list
	  //click on finish
	  driver.findElement(By.xpath("//button[text()='Finish']")).click();
	  //Assert
	  Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText(), "Thank you for your order!","Assertion Failed");
	  System.out.println("Order placed successfully!");
	  //click on BackToHome
	  //clickOnElement(driver.findElement(By.id("back-to-products")));
}
  @AfterTest
  public void closeConnection()
  {
	  //cleanUp();
  }
}