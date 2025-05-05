package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC0011_Logout extends BaseClass {
	@Test
	public void verify_logout() {

	logger.info("****starting of logout*********");
	try {
		
	HomePage hp=new HomePage(driver);
	hp.setAccount();
	hp.setLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.onClick_login();
	Thread.sleep(5000);
	
	MyAccountPage mcp=new MyAccountPage(driver);
	Thread.sleep(5000);
	mcp.onClick_Account();
	Thread.sleep(500);
	mcp.onClick_Logout();
	
	LogoutPage lop=new LogoutPage(driver);
	boolean display=lop.isDisplay_logout();
	Assert.assertTrue(display);
	
}
	catch(Exception e) {
		Assert.fail();
	}
	logger.info("******finish of logout**********");
}
}