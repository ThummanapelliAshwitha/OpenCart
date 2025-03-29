package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_RegistrationDDT extends BaseClass {
	@Test(dataProvider="RegisterData",dataProviderClass=DataProviders.class,groups="Data Driven Testing")
public void test_Register(String firstname,String lastname,String email,String Telephone,String Password, String confirmpassword,String Expresult) throws InterruptedException {
		
		logger.info("****starting of RegistrationDDT********");
		try {
		HomePage hp=new HomePage(driver);
		hp.setAccount();
		
		
		hp.setRegister();
		
		
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		MyAccountPage mcp=new MyAccountPage(driver);
		
		logger.info("providing user information");
		rp.firstName(firstname);
		rp.lastName(lastname);
		rp.email(email);
		rp.phone(Telephone);
		//String password=randomAlphaNumeric();
		rp.passWord(Password);
		rp.confirmPassword(confirmpassword);
		rp.checkBox();
		rp.button();
		if(Expresult.equalsIgnoreCase("valid")) {
			String mssg=rp.getConfirmationmessage();
			if(mssg.equals("Your Account Has Been Created!")) {
				
				mcp.onClick_Logout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		
		
	}
		if(Expresult.equalsIgnoreCase("invalid")) {
			String mssg=rp.getConfirmationmessage();
			if(mssg.equals("Your Account Has Been Created!")) {
				
				mcp.onClick_Logout();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
			}
		
		
	}
		}	
	catch(Exception e) {
		
		Assert.fail();
	}
		logger.info("****finish TC003_RegistrationDDT*********");
		Thread.sleep(5000);
		}

}
