package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("******** Starting Testcase TC0001_AccountRegistrationTest *********");
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("***Clicked on My Account Link***");
		
		hp.clickRegister();
		
		logger.info("***Clicked on Register Link***");
	
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("**Providing Customer details to register the account**");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		
		String password=randomAlphNumeric();
		
		regpage.setpaswd(password);
		regpage.confirmpswd(password);
		
		regpage.setprivacypolicy();
		regpage.clickContinue();
		
		//validation part.
		logger.info("*** Validating Expected Message **** ");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test case displayed with error..");
		    logger.debug("Test displayed with debug");
			Assert.assertTrue(false);
		}
		
		
	    //Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Completed,  TC0001_AccountRegistrationTest ****");
		
	}	
}
