package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_Search extends BaseClass{
	@Test
   public void verify_search() throws InterruptedException  {
		logger.info("start searching for product");
		try {
		HomePage hp=new HomePage(driver); 
		String item=p.getProperty("item");
		hp.search_box(item);
		hp.click_search();
		Thread.sleep(500);
		 SearchPage sp=new SearchPage(driver);
  /* List<WebElement>li=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]//div[@class='product-thumb']"));
   if(li.size()>0) {
	  
	   logger.info("Product found");
	   Assert.assertTrue(true);
   }
	   
   else {
	   logger.warn("no result found");
	   Assert.assertTrue(false);
   }
   */
		boolean product_clicked= sp.clickOnProductFromResults(p.getProperty("item"));
		logger.info("product clicked");
		Assert.assertTrue(product_clicked);
		
	}
		
		catch(Exception e) {
			logger.error("Exception occurred during search test: " + e.getMessage());
			Assert.fail();
		}
		logger.info("finish of search");
}
}

