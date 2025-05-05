package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddProductPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC009_AddProduct extends BaseClass{
	
	@Test
	public void verify_AddProduct() throws InterruptedException {
		
		logger.info("starting of addproduct");
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
	   sp.clickOnProductFromResults(p.getProperty("item"));
	   
	 AddProductPage ap=new AddProductPage(driver);
	String quantities=p.getProperty("quantity");
     ap.add_quantity(String.valueOf(quantities));
    Thread.sleep(500);
	   ap.add_Product();
	  Thread.sleep(3000);
	   String expectedmssg="Success: You have added ";
	   String actualmssg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	   logger.info("product add to cart");
	 Assert.assertEquals(actualmssg.contains(expectedmssg),true);
	
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("finish of add product");
}
}
