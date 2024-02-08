package org.automation.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage {
	
	@FindBy(xpath="//input[@value='Add to cart']")
	private List<WebElement> allAddToCartButtons;
	
	public DigitalDownloadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllAddToCartButtons() {
		return allAddToCartButtons;
	}
	
	

}
