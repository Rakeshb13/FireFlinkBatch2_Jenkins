package org.automation.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath="//td[@class='remove-from-cart']//input[@type='checkbox']")
	private List<WebElement> allCartProduct;
	
	@FindBy(xpath="//td[@class='remove-from-cart']//input[@type='checkbox']")
	private List<WebElement> removeProductsCheckBoxs;
	
	@FindBy(xpath="//input[@name='updatecart']")
	private WebElement updateCartButton;

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllCartProduct() {
		return allCartProduct;
	}

	public List<WebElement> getRemoveProductsCheckBoxs() {
		return removeProductsCheckBoxs;
	}

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}

}
