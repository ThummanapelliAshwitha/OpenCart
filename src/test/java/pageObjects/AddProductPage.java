package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductPage extends BasePage{

	public AddProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-quantity']") WebElement txt_quantity;
	@FindBy(xpath="//button[@id='button-cart']") WebElement btn_addProduct;
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']") WebElement btn_cart;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//td[@class='text-left']/a") WebElement tbl_productname;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//td[@class='text-left']//input[contains(@name,'quantity')]")WebElement tbl_quantity;
	public void add_quantity(String quantity) {
		txt_quantity.clear();
		txt_quantity.sendKeys(quantity);
	}
	 public void update_quantity(String quantity) {
	        txt_quantity.clear();
	        txt_quantity.sendKeys(quantity);
	    }
	public void add_Product() throws InterruptedException {
	btn_addProduct.click();
		Thread.sleep(5000);
	}
	public void isDisplay_cart() {
		btn_cart.click();
	}
	
     public String product_tbl() {
    	String productname= tbl_productname.getText();
    	return productname;
     }
     public String quantity_tbl() {
     	String quantitynum= tbl_quantity.getAttribute("value");;
     	return quantitynum;
      }
}
