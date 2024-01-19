package DropdownHandle;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class autoTestReg {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=autoTestReg.setUp("chrome","https://demo.automationtesting.in/Register.html");
		//locate dropdown element uniquely
		WebElement skillsDropdown=driver.findElement(By.id("Skills"));
		//.click();
		//create an instance of select class n pass dropdown elemnt
		Select select=new Select(skillsDropdown);
		//operations on dropdown list
		System.out.println("Default selected option: "+select.getFirstSelectedOption().getText());
		List<WebElement> dropdownList=select.getOptions();
		for(int i=0;i<dropdownList.size();i++)
		{
			System.out.println(dropdownList.get(i).getText());
		}
		Thread.sleep(2000);
		select.selectByIndex(2);
		Thread.sleep(2000);
		select.selectByValue("C");
		Thread.sleep(2000);
		select.selectByVisibleText("Documentation");
		System.out.println("Is dropdown multiselected??"+select.isMultiple());
		System.out.println("Current selected option is:"+select.getFirstSelectedOption().getText());
		
		//Validate skill order
		String exp_skills="Select Skills\r\n"
				+ ":Adobe InDesign\r\n"
				+ ":Adobe Photoshop\r\n"
				+ ":Analytics\r\n"
				+ ":Android\r\n"
				+ ":APIs\r\n"
				+ ":Art Design\r\n"
				+ ":AutoCAD\r\n"
				+ ":Backup Management\r\n"
				+ ":C\r\n"
				+ ":C++\r\n"
				+ ":Certifications\r\n"
				+ ":Client Server\r\n"
				+ ":Client Support\r\n"
				+ ":Configuration\r\n"
				+ ":Content Managment\r\n"
				+ ":Content Management Systems (CMS)\r\n"
				+ ":Corel Draw\r\n"
				+ ":Corel Word Perfect\r\n"
				+ ":CSS\r\n"
				+ ":Data Analytics\r\n"
				+ ":Desktop Publishing\r\n"
				+ ":Design\r\n"
				+ ":Diagnostics\r\n"
				+ ":Documentation\r\n"
				+ ":End User Support\r\n"
				+ ":Email\r\n"
				+ ":Engineering\r\n"
				+ ":Excel\r\n"
				+ ":FileMaker Pro\r\n"
				+ ":Fortran\r\n"
				+ ":HTML\r\n"
				+ ":Implementation\r\n"
				+ ":Installation\r\n"
				+ ":Internet\r\n"
				+ ":iOS\r\n"
				+ ":iPhone\r\n"
				+ ":Linux\r\n"
				+ ":Java\r\n"
				+ ":Javascript\r\n"
				+ ":Mac\r\n"
				+ ":Matlab\r\n"
				+ ":Maya\r\n"
				+ ":Microsoft Excel\r\n"
				+ ":Microsoft Office\r\n"
				+ ":Microsoft Outlook\r\n"
				+ ":Microsoft Publisher\r\n"
				+ ":Microsoft Word\r\n"
				+ ":Microsoft Visual\r\n"
				+ ":Mobile\r\n"
				+ ":MySQL\r\n"
				+ ":Networks\r\n"
				+ ":Open Source Software\r\n"
				+ ":Oracle\r\n"
				+ ":Perl\r\n"
				+ ":PHP\r\n"
				+ ":Presentations\r\n"
				+ ":Processing\r\n"
				+ ":Programming\r\n"
				+ ":PT Modeler\r\n"
				+ ":Python\r\n"
				+ ":QuickBooks\r\n"
				+ ":Ruby\r\n"
				+ ":Shade\r\n"
				+ ":Software\r\n"
				+ ":Spreadsheet\r\n"
				+ ":SQL\r\n"
				+ ":Support\r\n"
				+ ":Systems Administration\r\n"
				+ ":Tech Support\r\n"
				+ ":Troubleshooting\r\n"
				+ ":Unix\r\n"
				+ ":UI / UX\r\n"
				+ ":Web Page Design\r\n"
				+ ":Windows\r\n"
				+ ":Word Processing\r\n"
				+ ":XML\r\n"
				+ ":XHTML";
		
		String act_skill="";
		for(int i=0;i<dropdownList.size();i++)
		{
			if(i<dropdownList.size()-1)
			{
				act_skill=act_skill+dropdownList.get(i).getText()+":";
			}
			else
			{
				act_skill=act_skill+dropdownList.get(i).getText();
			}
		}
		System.out.println("Is skill set is in ordered list?"+act_skill.equals(exp_skills));
	}

	//SetUp code
	public static WebDriver setUp(String browser,String url)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().setSize(new Dimension(500,600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter url
		driver.get(url);
		
		return driver;
	}
	
	
}
