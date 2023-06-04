package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']") //MyAccountPage heading element
	private WebElement msgHeading;
	
	@FindBy(linkText = "Logout")
	private WebElement lnkLogOut;
	
	public boolean isMyAccountPageExists() {
		
		try {
			return (msgHeading.isDisplayed());
		}catch(Exception e) {
			return false;
		}	
	}
	
	public void clickOnLogOut() {
		
		lnkLogOut.click();
	}
}
