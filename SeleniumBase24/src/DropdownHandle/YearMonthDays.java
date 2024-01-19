package DropdownHandle;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YearMonthDays {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=autoTestReg.setUp("chrome", "https://demo.automationtesting.in/Register.html");
validateYear(driver);
Month(driver);
day(driver);

	}
//year dropdown 
	static void validateYear(WebDriver driver) throws InterruptedException
	{ 
		WebElement year=driver.findElement(By.id("yearbox"));
		Select yearSelect=new Select(year);
		System.out.println("Is year box is multiSelect?"+yearSelect.isMultiple());
		System.out.println(" year fields default selected value is: "+yearSelect.getFirstSelectedOption().getText());
		//year.click();
		List<WebElement> yearList=yearSelect.getOptions();

		for(int i=0;i<yearList.size();i++)
		{
			System.out.print(yearList.get(i).getText()+",");
		}
		yearSelect.selectByIndex(4);
		Thread.sleep(1000);
		yearSelect.selectByValue("1916");
		Thread.sleep(1000);
		yearSelect.selectByVisibleText("1917");
		System.out.println("Selected year is:"+yearSelect.getFirstSelectedOption().getText());

		String exp_yr_list="year,1916,1917,1918,1919,1920,1921,1922,1923,1924,1925,1926,1927,1928,1929,1930,1931,1932,1933,1934,1935,1936,1937,1938,1939,1940,1941,1942,1943,1944,1945,1946,1947,1948,1949,1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015";
		String act_yr_list="";
		for(int i=0;i<yearList.size();i++)
		{
			if(i<yearList.size()-1)
			act_yr_list=act_yr_list+yearList.get(i).getText()+",";
			else
				act_yr_list=act_yr_list+yearList.get(i);
		}
		System.out.println();
		System.out.println("Is year in particular order?"+act_yr_list.equals(exp_yr_list));
	}
	
	//Month
	static void Month(WebDriver driver) throws InterruptedException {
		//month dropdown
//WebDriver driver=null;
		WebElement month=driver.findElement(By.cssSelector("select[placeholder='Month']"));
		Select month_select=new Select(month);
		System.out.println("Is month dropdown is multi select"+month_select.isMultiple());
		System.out.println("Default value of month dropdown= "+month_select.getFirstSelectedOption().getText());
		System.out.println("Month list:");
		List<WebElement> month_list=month_select.getOptions();

		for(int i=0;i<month_list.size();i++)
		{
			System.out.print(month_list.get(i).getText()+",");
		}

		month_select.selectByIndex(2);
		Thread.sleep(1000);
		month_select.selectByVisibleText("June");//month_select.selectByValue("June");
		System.out.println();
		System.out.println("currently selected month="+month_select.getFirstSelectedOption().getText());
		String exp_mnthList="January, February, March, April, May, June, July, August, September, October, November, December";
		String act_mnthList="";

		for(int i=1;i<month_list.size();i++)
		{
			if(i<month_list.size()-1)
				act_mnthList=act_mnthList+month_list.get(i).getText()+", ";
			else
				act_mnthList=act_mnthList+month_list.get(i).getText();
		}

		System.out.println("Is month dropdown is in ordered list?"+act_mnthList.equals(exp_mnthList));
	}
	//Day
	static void day(WebDriver driver)
	{
		//day dropdown
//WebDriver driver=null;
		WebElement day=driver.findElement(By.id("daybox"));
		Select sel_day=new Select(day);
		System.out.println("Is day dropdown multiselect?"+sel_day.isMultiple());
		System.out.println("Default value of Day dropdown is:"+sel_day.getFirstSelectedOption().getText());

		List<WebElement> day_list=sel_day.getOptions();
		System.out.println("No.of Days in dropdownList:"+day_list.size());
		for(int i=0;i<day_list.size();i++)
		{
			System.out.print(day_list.get(i).getText()+",");
			
		}
		sel_day.selectByIndex(4);//Thread.sleep(2000);
		sel_day.selectByValue("5");
		sel_day.selectByVisibleText("12");
		System.out.println();
		System.out.println("*********************************");
		System.out.println("current selected day is:"+sel_day.getFirstSelectedOption().getText());

		String exp_dayList="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31";
		String act_dayList="";
		//List<Integer> days=new ArrayList<Integer>();
		for(int i=1;i<day_list.size();i++)
		{
			if(i<day_list.size()-1)
			{
				act_dayList=act_dayList+day_list.get(i).getText()+",";
				//days.add(Integer.parseInt(day_list.get(i).getText());
			}
			else
			{
				act_dayList=act_dayList+day_list.get(i).getText();
			}
		}
System.out.println();
System.out.println("Is day dropdown is in ordered list?"+act_dayList.equals(exp_dayList));
	}
}
