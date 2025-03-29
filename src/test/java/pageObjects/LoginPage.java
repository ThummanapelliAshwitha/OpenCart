package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
@FindBy(xpath="//input[@id='input-password']")WebElement txt_password;
@FindBy(xpath="//input[@value='Login']")WebElement btn_loginbutton;

public void setEmail(String email) {
	txt_email.sendKeys(email);
}
public void setPassword(String password) {
	txt_password.sendKeys(password);
}
public void onClick_login() {
	btn_loginbutton.click();
}
}
