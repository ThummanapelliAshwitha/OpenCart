package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LogoutPage extends BasePage{
	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") WebElement btn_logout;
	public boolean isDisplay_logout() {
	    try {
	        return btn_logout.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}


}
