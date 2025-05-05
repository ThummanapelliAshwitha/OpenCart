package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddProductPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC0010_AddProductDDT extends BaseClass {
	@Test(dataProvider="AddProductData",dataProviderClass=DataProviders.class,groups="Data Driven Testing")
	public void verify_AddProduct(String item,String category,String subcategory, String productdes, String quantity,String Exp) throws InterruptedException {
		logger.info("starting of addproductDDT");
		try {
		HomePage hp=new HomePage(driver);
		hp.search_box(item);
		hp.click_search();
		
		 SearchPage sp=new SearchPage(driver);
		   
		   sp.selectCategory(category);
		   sp.isSubcatgory_selected(subcategory);
		   sp.isProductDes_selected(productdes);
		   sp.searchbtn_click();
		  //sp.clickOnProductFromResults(item);
		   boolean isProductFound = sp.clickOnProductFromResults(item);

           if (!isProductFound) {
               logger.warn("Product not found in search results");
               if (Exp.equalsIgnoreCase("valid")) {
                   Assert.fail("Expected product not found");
               } else if (Exp.equalsIgnoreCase("invalid")) {
                   Assert.assertTrue(true); // Negative test passed
               }
               return;
           }
           
		   AddProductPage ap=new AddProductPage(driver);
			
		     ap.add_quantity(String.valueOf(quantity));
		     Thread.sleep(500);
			ap.add_Product();
			  Thread.sleep(3000);
			  ap.isDisplay_cart();
			  Thread.sleep(500);
			  String actproduct=ap.product_tbl();
			  String actquantity=ap.quantity_tbl();
			
			 // System.out.println(actproduct+" "+actquantity);
			  if (Exp.equalsIgnoreCase("valid")) {
				 if(actproduct.toLowerCase().contains(item)&&actquantity.toLowerCase().contains(quantity)) {
				
					  logger.info("matching in valid case");
					  Assert.assertTrue(true);
				  }
				  else {
					  logger.info("not matching in valid case");
					  Assert.assertTrue(false);
				  }
			  }
			  if (Exp.equalsIgnoreCase("invalid")) {
				 if(actproduct.toLowerCase().contains(item)&&actquantity.toLowerCase().contains(quantity)) {
		
					  logger.info("matching in invalid case");
					  Assert.assertTrue(false);
				  }
				  else {
					  logger.info("not matching in invalid case");
					  Assert.assertTrue(true);
				  }
			  } 
		}

		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finish of addproductDDt");

}
}
