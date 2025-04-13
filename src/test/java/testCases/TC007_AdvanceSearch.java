package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC007_AdvanceSearch extends BaseClass{
	@Test
   public void verify_advanceSearch() throws InterruptedException {
		//these is advance search result page is display then we click on product
		try {
	   HomePage hp=new HomePage(driver);
	   String item=p.getProperty("item");
	   hp.search_box(item);
	   hp.click_search();
	  
	   SearchPage sp=new SearchPage(driver);
	   String categoryname=p.getProperty("categoryname");
	   sp.selectCategory(categoryname);
	   sp.isSubcatgory_selected();
	   sp.isProductDes_selected();
	   sp.searchbtn_click();
	   List<WebElement>li=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]//div[@class='product-thumb']"));
	   boolean found=false;
	   if(li.size()>0) {
	   for(WebElement list:li) {
		  if(list.getText().toLowerCase().contains(item)) {
			  list.click();
			found=true;
			  Thread.sleep(500);
			  break;
		  }	 
		  }
	   }
	   
		  if(found==true) {
				
				Thread.sleep(500);
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
	   
	  
	   
		}
		catch(Exception e) {
			Assert.fail();
		
   }
}
}
