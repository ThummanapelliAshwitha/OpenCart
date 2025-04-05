package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC006_SearchDDT extends BaseClass {
   
	@Test(dataProvider="SearchData",dataProviderClass=DataProviders.class,groups="Data Driven Testing")
public void verify_search(String item,String Exp) {
		//these code is for search product and click on it
	try {
		HomePage hp=new HomePage(driver); 
		
		hp.search_box(item);
		hp.click_search();
		Thread.sleep(500);
		List<WebElement>li=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]//div[@class='product-thumb']"));
		boolean found=false;
		if(li.size()>0) {
			if(Exp.equalsIgnoreCase("valid"))
			{
			for(WebElement list:li) {
				if(list.getText().toLowerCase().contains(item.toLowerCase())) {
					list.click();
					Thread.sleep(5000);
					found=true;
					
					break;
				}
				
				if(found==true) {
					driver.navigate().back();
					Thread.sleep(500);
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
		}
			if(Exp.equalsIgnoreCase("invalid"))
			{
			for(WebElement list:li) {
				if(list.getText().toLowerCase().contains(item.toLowerCase())) {
					list.click();
					Thread.sleep(500);
					found=true;
					
					break;
				}
				
				if(found==true) {
					driver.navigate().back();
					Thread.sleep(500);
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
	}	
}
		
		}
	catch(Exception e) {
		Assert.fail();
	}
	
}
}
