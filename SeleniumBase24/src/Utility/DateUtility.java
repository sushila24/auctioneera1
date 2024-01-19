package Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	//date after specified no_of_days
public static String getDateBasedOnNoOfDays(String format,int no_of_days)
{
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DATE,no_of_days);
	SimpleDateFormat sdf=new SimpleDateFormat(format);
	 return sdf.format(new Date(cal.getTimeInMillis()));
	
}
//date after specified no_of_months
public static String getDateBasedOnNoOfMonth(String format,int no_of_months)
{
	Calendar cal=Calendar.getInstance();
			cal.add(Calendar.MONTH, no_of_months);
	SimpleDateFormat sdf=new SimpleDateFormat(format);
	return sdf.format(new Date(cal.getTimeInMillis()));
			
}
//date after specified no_of_years
public static String getDateBasedOnNoOfYears(String format,int no_of_years)
{
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.YEAR, no_of_years);
	SimpleDateFormat sdf=new SimpleDateFormat(format);
	return sdf.format(new Date(cal.getTimeInMillis()));
}


	

}
