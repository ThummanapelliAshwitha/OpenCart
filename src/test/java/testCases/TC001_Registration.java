package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_Registration extends BaseClass {
	
	
	@Test(groups={"Regression","master"})
	public void test_Register() {
		
		logger.info("****starting of Registration********");
		try {
		HomePage hp=new HomePage(driver);
		hp.setAccount();
		logger.info("clicked on account");
		
		hp.setRegister();
		logger.info("clicked on register");
		
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		logger.info("providing user information");
		rp.firstName(randomString().toUpperCase());
		rp.lastName(randomString().toUpperCase());
		rp.email(randomString()+"@gmail.com");
		rp.phone(randomNumeric());
		String password=randomAlphaNumeric();
		rp.passWord(password);
		rp.confirmPassword(password);
		rp.checkBox();
		rp.button();
		
		logger.info("validating expected message");
		
		String mssg=rp.getConfirmationmessage();
		if(mssg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test fail");
			logger.debug("Debug logs.....");
			Assert.assertTrue(false);
		}
		
	
	}
	catch(Exception e) {
		
		Assert.fail();
	}
		logger.info("*****finish of Registration");
}
	
}
