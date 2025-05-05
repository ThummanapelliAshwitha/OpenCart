package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC008_AdvanceSearchDDT extends BaseClass {

     @Test(dataProvider="AdvanceSearchData",dataProviderClass=DataProviders.class,groups="Data Driven Testing")
	public void verify_search(String item,String category,String subcategory, String productdes, String Exp) {
    	 logger.info("start Advancesearching for productDDT");
	try {
		HomePage hp=new HomePage(driver);
		hp.search_box(item);
		hp.click_search();
		
		 SearchPage sp=new SearchPage(driver);
		   
		   sp.selectCategory(category);
		   sp.isSubcatgory_selected(subcategory);
		   sp.isProductDes_selected(productdes);
		   sp.searchbtn_click();
		   boolean product_clicked = sp.clickOnProductFromResultsDDT(item);
			if (Exp.equalsIgnoreCase("valid")) {
	            if (product_clicked) {
	                logger.info("Product clicked");
	                Assert.assertTrue(true);
	            } else {
	                logger.error("Product not clicked, but expected in valid case");
	                Assert.assertTrue(false);
	            }
	        } 
			if (Exp.equalsIgnoreCase("invalid")) {
	            if (product_clicked) {
	                logger.error("Product clicked, but not expected in invalid case");
	                Assert.assertTrue(false);
	            } else {
	                logger.info("Product not clicked as expected (invalid case)");
	                Assert.assertTrue(true);
	            }
	        } 
		   
		  
			}
	catch(Exception e) {
		logger.error("Exception occurred during search test: " + e.getMessage());
		Assert.fail();
	}
	logger.info("finish of AdvancesearchDDT");
}
}
