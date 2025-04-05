package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) { //passing driver to parent class
		super(driver);/*without calling this constructor we can't invoke parent constructor(we invoke parent variable,parent method,parent constructor by using super keyword)*/
		
	}

 @FindBy(xpath="//a[@title='My Account']") WebElement btn_account;
 @FindBy(xpath="//a[normalize-space()='Register']") WebElement btn_register;
 @FindBy(linkText="Login") WebElement btn_login;
 @FindBy(xpath="//input[@placeholder='Search']") WebElement text_search;
 @FindBy(xpath="//i[@class='fa fa-search']") WebElement btn_search;
 
 public void setAccount() {
	 btn_account.click();
 }
 public void setRegister() {
	 btn_register.click();
 }
 public void setLogin() {
	 btn_login.click();
 }
 //searching product
 public void search_box(String item) {
	 text_search.clear();
	 text_search.sendKeys(item); 
}
public void click_search() {
	btn_search.click();
}

}
