package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class HRMHomePage extends SeleniumUtility {
	public HRMHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.oxd-main-menu>*:nth-of-type(2) span") // ul.oxd-main-menu>li:nth-of-type(2) span
	private WebElement PIMLink;

	@FindBy(css = ".oxd-userdropdown-icon")
	private WebElement userProfileIcon;

	public void setPIMLink(WebElement pIMLink) {
		PIMLink = pIMLink;
	}

	public void setUserProfileIcon(WebElement userProfileIcon) {
		this.userProfileIcon = userProfileIcon;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	public WebElement getPIMLink() {
		return PIMLink;
	}

	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void clickOnPIM() {
		clickOnElement(PIMLink);
	}
	
	public void logoutFromHRM() {
		clickOnElement(userProfileIcon);
		clickOnElement(logout);
	}
}
