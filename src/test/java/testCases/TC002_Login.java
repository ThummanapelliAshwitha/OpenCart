package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {

	@Test(groups= {"Sanity","master"})
	public void verify_account() {
		logger.info("****starting of login*********");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.setAccount();
		hp.setLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.onClick_login();
		
		MyAccountPage mcp=new MyAccountPage(driver);
		boolean targetpage=mcp.ismyAccountExist();
		
		Assert.assertEquals(targetpage,true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*******finish of login*******");
	}
}
