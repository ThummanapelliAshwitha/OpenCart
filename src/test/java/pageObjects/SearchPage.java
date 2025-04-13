package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage  {

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//select[@name='category_id']") WebElement drop_allcategory;
	@FindBy(xpath="//input[@name='sub_category']") WebElement checkbox_subcategory;
	@FindBy(xpath="//input[@id='description']") WebElement checkbox_productdes;
	@FindBy(xpath="//input[@id='button-search']") WebElement click_searchbutton;
	public void selectCategory(String categoryname) throws InterruptedException {
		Select drop=new Select(drop_allcategory);
		//drop.selectByVisibleText(categoryname);
		List<WebElement> li=drop.getOptions();
		for(WebElement list:li) {
			String catename=list.getText().trim().toLowerCase();
			if(catename.contains(categoryname)) {
				
				drop.selectByVisibleText(list.getText().trim());
				Thread.sleep(5000);
			}
		}
		
	}
	
	public void isSubcatgory_selected() throws InterruptedException {
		if(!checkbox_subcategory.isSelected()) {
			Thread.sleep(500);
			checkbox_subcategory.click();
		}
	}
	
	public void isProductDes_selected() throws InterruptedException {
		if(!checkbox_productdes.isSelected()) {
			Thread.sleep(5000);
			checkbox_productdes.click();
		}
	}
	public void searchbtn_click() throws InterruptedException {
		Thread.sleep(5000);
		click_searchbutton.click();
	}
	

}
