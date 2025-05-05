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
		//these is advance search result page is display then we click on search
		logger.info("Starting of advance search");
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
	   //validation product clicked means pass otherwise fail
	   boolean productClicked=sp.clickOnProductFromResults(p.getProperty("item"));
	 logger.info("product clicked");
	   Assert.assertTrue(productClicked);
	   
		}
		catch(Exception e) {
			Assert.fail();
		}
			logger.info("finish of advance search");
		
   
		}
}

