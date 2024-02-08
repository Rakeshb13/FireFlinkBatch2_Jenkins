package org.automation.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(partialLinkText = "Log")
	private WebElement loginLink;

	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	@FindBy(partialLinkText = "Digital downloads")
	private WebElement digitalDownloadsLink;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;

	@FindBy(partialLinkText = "Books")
	private WebElement booksLinks;

	public WebElement getDigitalDownloadsLink() {
		return digitalDownloadsLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getBooksLinks() {
		return booksLinks;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

}
