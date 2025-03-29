package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
		@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
		@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
		@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
		@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
		@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
		@FindBy(xpath="//input[@id='input-confirm']")  WebElement txt_confirm;
		@FindBy(xpath="//input[@name='agree']") WebElement chk_box;
		@FindBy(xpath="//input[@value='Continue']")WebElement btn_continue;
        @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]") WebElement txt_mssg;
        
		public void firstName(String firstname) {
			txt_firstname.sendKeys(firstname);
		}
		
		public void lastName(String lastname) {
			txt_lastname.sendKeys(lastname);
		}
		
		public void email(String emailid) {
			txt_email.sendKeys(emailid);
		}
		
		public void phone(String telephone) {
			txt_telephone.sendKeys(telephone);;
		}
		
		public void passWord(String password) {
			txt_password.sendKeys(password);;
		}
		
		public void confirmPassword(String conpassword) {
			txt_confirm.sendKeys(conpassword);;
		}
		
		public void checkBox() {
			
			chk_box.click();
		}
		public void button() {
			btn_continue.click();
			/*sol2
			 * chk_box.submit();
			 */
			/*sol3
			 * Actions act=new Actions(driver);
			 * act.moveToElement(chk_box).click().perform();*/
			/*sol4
			 * JavascriptExecutor js=(JavascriptExecutor)driver;
			 * js.executeScript("arguments[0].click();", chk_box)*/
			
			/*sol5
			 * chk_box.sendKeys(Keys.RETURN);
			 */
			/*sol6
			 * WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
			 * mywait.util(ExpectedConditions.elementToBeClickable(chk_box)).click();*/
		}
		public String getConfirmationmessage() {
			try {
				return (txt_mssg.getText());
			}
			catch(Exception e) {
				return(e.getMessage());
			}
		}
		
}
