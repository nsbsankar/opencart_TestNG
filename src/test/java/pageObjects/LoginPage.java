package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "input-email")
	private WebElement txtEmailAddress;
	
	@FindBy(id = "input-password")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement msgWarning;
	
	public void enterEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickOnLogin() {
		btnLogin.click();
	}
	
	public boolean isWarningMessageExists() {
		try {
			return (msgWarning.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
}
