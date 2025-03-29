package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Data Driven Testing")
	public void verify_account(String email, String password,String exp) {
		logger.info("****starting TC003_Login DDT*********");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.setAccount();
		hp.setLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.onClick_login();
		
		MyAccountPage mcp=new MyAccountPage(driver);
		boolean targetpage=mcp.ismyAccountExist();
		/*Data is valid  - login success-test pass-logout
		                   login failed-test fail
		                   
		 Data is invalid - login success-test fail-logout
		                   login failed-test pass
		                   */
		if(exp.equalsIgnoreCase("valid")) {
			if(targetpage==true) {
				mcp.onClick_Logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetpage==true) {
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
		logger.info("****finish TC003_Login DDT*********");
}
}
