package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import Utility.DateUtility;

public class DateCurrentAfterBeforeDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Date d1=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/YYYY");
//todays date
System.out.println("Todays Date obj d1="+d1);//Fri Jan 05 21:14:29 IST 2024
System.out.println("Required formatted date:"+sdf.format(d1));//05/Jan/2024
//10 days back date
System.out.println("Date before 10 days:"+DateUtility.getDateBasedOnNoOfDays("yyyy/MM/dd", -10));
//date after 15 days
System.out.println("Date after 15 days:"+DateUtility.getDateBasedOnNoOfDays("yyyy/MM/dd", 15));

/**o/p
 * Todays Date obj d1=Fri Jan 05 21:45:27 IST 2024
Required formatted date:05/Jan/2024
Date before 10 days:2023/12/26
Date after 15 days:2024/01/20

 */
	}

}
