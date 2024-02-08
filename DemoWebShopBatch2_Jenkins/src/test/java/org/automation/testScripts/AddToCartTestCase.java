package org.automation.testScripts;

import java.io.IOException;
import java.util.List;
import org.automation.elementRepository.DigitalDownloadsPage;
import org.automation.elementRepository.ShoppingCartPage;
import org.automation.genericLibrary.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@Listeners(org.automation.genericLibrary.ListenersImplementation.class)
public class AddToCartTestCase extends BaseTest {

	@Test
	public void addToCartTestCase() throws InterruptedException, IOException {
		
		//Step 1: Navigating to Digital Downloads Page
		home_Page.getDigitalDownloadsLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Digital downloads","Digital Downloads Page not Displayed");
		Reporter.log("Digital Downloads Page Displayed..", true);
		test.log(Status.INFO, "Digital Downloads Page Displayed..");

		DigitalDownloadsPage digital_Downloads = new DigitalDownloadsPage(driver);

		//Step 2: Adding all the products to Cart
		List<WebElement> allProductsAddToCartButton = digital_Downloads.getAllAddToCartButtons();
		int digitalDownloadsPageProducts = allProductsAddToCartButton.size();

		for (WebElement productAddToCart : allProductsAddToCartButton) {
			productAddToCart.click();
			Thread.sleep(500);
		}

		//Step 3: Navigating to Shopping Cart Page
		home_Page.getShoppingCartLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Shopping Cart", "Shopping Cart Page not Displayed");
		Reporter.log("Shopping Cart Page Displayed..", true);
		test.log(Status.INFO, "Shopping Cart Page Displayed..");
		ShoppingCartPage shopping_Cart = new ShoppingCartPage(driver);

		//Step 4: Verifying products added to cart or not
		Assert.assertEquals(shopping_Cart.getRemoveProductsCheckBoxs().size(), digitalDownloadsPageProducts,"AddToCartTestCase Fail");
		Reporter.log("AddToCartTestCase Pass...", true);
		test.log(Status.PASS, "AddToCartTestCase Pass...");
		test.addScreenCaptureFromPath(common_Utility.toTakeScreenShot(driver), "AddToCartTestCase Pass...");

		//Step 5: Removing all the products from cart
		List<WebElement> allRemoveCheckBoxs = shopping_Cart.getRemoveProductsCheckBoxs();
		for (WebElement removeCheckBox : allRemoveCheckBoxs) {
			removeCheckBox.click();
		}

		shopping_Cart.getUpdateCartButton().click();
	}
}
