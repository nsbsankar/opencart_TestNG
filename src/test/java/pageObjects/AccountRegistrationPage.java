package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	// Elements
	@FindBy(id = "input-firstname")
	private WebElement txtFirstname;

	@FindBy(id = "input-lastname")
	private WebElement txtLastname;

	@FindBy(id = "input-email")
	private WebElement txtEmail;
	
	@FindBy(id = "input-telephone")
	private WebElement txtTelephone;

	@FindBy(id = "input-password")
	private WebElement txtPassword;
	
	@FindBy(id = "input-confirm")
	private WebElement txtCnfPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement chkPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;

	// Action Methods

	public void enterFirstName(String fname) {

		txtFirstname.sendKeys(fname);
	}

	public void enterLastName(String lname) {

		txtLastname.sendKeys(lname);
	}

	public void enterEmail(String email) {

		txtEmail.sendKeys(email);
	}
	
	public void enterTelephone(String Telephone) {

		txtTelephone.sendKeys(Telephone);
	}

	public void enterPassword(String password) {

		txtPassword.sendKeys(password);
	}
	
	public void enterCnfPassword(String password) {

		txtCnfPassword.sendKeys(password);
	}
	
	public void clickOnPrivacyPolicy() {

		chkPolicy.click();
	}
	
	public void clickOnContinue() {

		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
}
