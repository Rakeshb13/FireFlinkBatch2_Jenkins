package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	
	@FindBy(xpath = "//a[text()='Fiction EX']")
	private WebElement fictionExProductName;
	
	public BooksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFictionExProductName() {
		return fictionExProductName;
	}
	
	
	

}
