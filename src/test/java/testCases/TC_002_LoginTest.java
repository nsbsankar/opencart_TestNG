package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void test_Valid_Login() {
		
		try {
		logger.info("=====Starting TC_002_LoginTest======");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicked on Myaccount");
		
		hp.clickOnLogin();
		logger.info("Clicked on Login");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing Login Credentials");
		lp.enterEmail(bundle.getString("app.email")); //valid email from config.properties file
		lp.enterPassword(bundle.getString("app.password")); //valid password from config.properties file
		lp.clickOnLogin();
		logger.info("Clicked on Login button");
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean pageExists = myAcc.isMyAccountPageExists();
		Assert.assertEquals(pageExists, true,"Invalid login data");
		
		} catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("=====Finished TC_002_LoginTest=====");
	}
}
