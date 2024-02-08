package org.automation.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.RegisterPage;
import org.automation.genericLibrary.BaseTest;
import org.automation.genericLibrary.DataUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class RegisterTestCase extends BaseTest{
	
	@Test(dataProvider = "RegisterData")
	public void registerTestCase(String firstName,String lastName, String email, String password, String confirmPassword) throws IOException
	{
		home_Page.getLogoutLink().click();
		
		home_Page.getRegisterLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Register");
		Reporter.log("Register Page is Displayed...",true);
		test.log(Status.INFO, "Register Page is Displayed...");
		
		RegisterPage register_Page=new RegisterPage(driver);
		register_Page.getMaleRadioButton().click();
		register_Page.getFirstNameTextFeild().sendKeys(firstName);
		register_Page.getLastNameTextFeild().sendKeys(lastName);
		register_Page.getEmailTextFeild().sendKeys(common_Utility.getRandomNumber()+email);
		register_Page.getPasswordTextFeild().sendKeys(password);
		register_Page.getConfirmPasswordTextFeild().sendKeys(confirmPassword);
		
		register_Page.getRegisterButton().click();
		
		Assert.assertEquals(register_Page.getSuccessfullMessage().getText(), "Your registration completed","Register Test Case Fail");
		Reporter.log("Register Test Case Pass...",true);
		test.log(Status.PASS, "Register Test Case Pass...");
	}
	
	@DataProvider(name="RegisterData")
	public Object[][] dataSupply() throws EncryptedDocumentException, IOException
	{
		return DataUtility.getMultipleDataFromExcel("RegisterTestData");
	}
}
