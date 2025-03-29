package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//below constructor used in every page so we place it in separate.and we access this constructor by extends this class and in child class
//we explicit call/invoke constructor.
public class BasePage {
	 WebDriver driver;
    public BasePage(WebDriver driver){//inside the parent class with this constructor will receive driver and initiate driver
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
    	 
     }
}
