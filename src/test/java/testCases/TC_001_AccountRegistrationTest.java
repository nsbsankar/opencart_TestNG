package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void test_account_registration() {
		
		logger.debug("Application logs..........!");
		logger.info("<====== Starting TC_001_AccountRegistrationTest =======> ");

		try {

			HomePage hp = new HomePage(driver);
		
			hp.clickOnMyAccount();
			
			logger.info("<====== Clicked on my account link =======> ");

			hp.clickOnRegister();
			
			logger.info("<====== Clicked on register link =======> ");


			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			
			logger.info("<====== Providing customer data =======> ");


			arp.enterFirstName(randomString().toUpperCase());	//randomly generated name
			arp.enterLastName(randomString().toLowerCase());	//randomly generated name
			arp.enterEmail(randomString()+"@gmail.com");		// randomly generated email
			arp.enterTelephone(randomNumber());
			String password = randomAlphaNumeric();
			arp.enterPassword(password);			//randomly generated password
			arp.enterCnfPassword(password);
			//Thread.sleep(3000);
			arp.clickOnPrivacyPolicy();
			//Thread.sleep(3000);
			arp.clickOnContinue();
			
			logger.info("<====== Clicked on continue =======> ");

			String confirmationMsg = arp.getConfirmationMsg();

			logger.info("<====== Validating expected message =======> ");

			Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!","Test Failed");

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Test failed");
			Assert.fail("Test Case Failed", e.getCause());
		}
		logger.info("<====== Starting TC_001_AccountRegistrationTest =======> ");

	}

}
