package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement txt_myAccount;
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement btn_fromAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btn_logout;
	public boolean ismyAccountExist() {
		try {
		return(txt_myAccount.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void onClick_Account() {
		btn_fromAccount.click();
	}
	public void onClick_Logout() {
		btn_logout.click();
	}
}
