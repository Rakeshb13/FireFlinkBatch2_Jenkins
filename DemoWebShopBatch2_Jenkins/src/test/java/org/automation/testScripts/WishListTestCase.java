package org.automation.testScripts;

import org.automation.elementRepository.BooksPage;
import org.automation.genericLibrary.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WishListTestCase extends BaseTest{
	
	@Test
	public void wishListTestCase()
	{
		
		home_Page.getBooksLinks().click();
		
		BooksPage books_Page = new BooksPage(driver);
		
		books_Page.getFictionExProductName().click();
		
		Reporter.log("WishList Test case Pass..",true);
		
		
		
	}
	

}
