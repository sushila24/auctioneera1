package UiValidateOnActitime;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiChkboxValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(500, 700));
//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//get url
//		driver.get("https://online.actitime.com/testing/login.do");
		
		//locate checkbox
		WebElement chkBox=driver.findElement(By.id("keepLoggedInCheckBoxContainer"));
		//isdisplayed
		System.out.println("is chkbox visible?"+chkBox.isDisplayed());
		System.out.println("is keep me login chkbox Enabled?"+chkBox.isEnabled());
		System.out.println("is keep me login chkbox already selected?"+chkBox.isSelected());
		chkBox.click();
		//System.out.println("is keep me login chkbox Enabled?"+chkBox.isEnabled());
		System.out.println("is keep me login chkbox  selected now?"+chkBox.isSelected());
		
		//get xy cords
		Point chkBoxCords=chkBox.getLocation();
		int chkBox_Xcord=chkBoxCords.getX();
		int chkBox_Ycord=chkBoxCords.getY();
		System.out.println("Checkbox field X co-ordinate:"+chkBox_Xcord);
		System.out.println("Checkbox field Y co-ordinate:"+chkBox_Ycord);
		//locate keep me login msg
		WebElement keepLogin=driver.findElement(By.id("keepLoggedInLabel"));
		
		System.out.println("Is Keep me sign In msg visible?"+keepLogin.isDisplayed());
		System.out.println("Keep me msg: "+keepLogin.getText());
		
		//get keepmelogin msg cords
		Point KeepMeLoginCords=keepLogin.getLocation();
		int KeepMeLogin_Xcord=KeepMeLoginCords.getX();
		int KeepMeLogin_Ycord=KeepMeLoginCords.getY();
		
		System.out.println("KeepMeLogin field X co-ordinate:"+KeepMeLogin_Xcord);
		System.out.println("KeepMeLogin field Y co-ordinate:"+KeepMeLogin_Ycord);
	//compare x cords of chkbox n KeepMeLoginmsg
		System.out.println("Is chkBox is before Keep Me Login Msg?? "+(chkBox_Xcord<KeepMeLogin_Xcord));
		driver.close();
	
	}

}
