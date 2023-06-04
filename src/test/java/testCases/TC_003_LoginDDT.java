package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class) 
	public void test_LoginDDT(String email, String password, String expected) {
		
		logger.info("=====Starting TC_003_LoginDDT=====");
		try {
			
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickOnLogin();
		
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean pageExists = myAcc.isMyAccountPageExists();
		
		if(expected.equalsIgnoreCase("valid")) {
			if(pageExists==true) {
				myAcc.clickOnLogOut();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);

			}
		}
		
		if(expected.equalsIgnoreCase("invalid")) {
			if(pageExists==true) {
				myAcc.clickOnLogOut();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		logger.info("=====Finished TC_003_LoginDDT======");
	}
}
