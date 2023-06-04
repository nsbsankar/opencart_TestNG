package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//Elements
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement lnkMyAccount;
	
	@FindBy(linkText = "Register")
	private WebElement lnkRegister;
	
	@FindBy(linkText = "Login")
	private WebElement lnkLogin;
	
	//Action methods
	
	public void clickOnMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickOnRegister() {
		lnkRegister.click();
	}
	
	public void clickOnLogin() {
		lnkLogin.click();
	}
	
}
