package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
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
		
   List<WebElement>li=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]//div[@class='product-thumb']"));
   if(li.size()>0) {
	  
	   logger.info("Product found");
	   Assert.assertTrue(true);
   }
	   
   else {
	   logger.warn("no result found");
	   Assert.assertTrue(false);
   }
   
	}
		
		catch(Exception e) {
			logger.error("Exception occurred during search test: " + e.getMessage());
			Assert.fail();
		}
}
}

