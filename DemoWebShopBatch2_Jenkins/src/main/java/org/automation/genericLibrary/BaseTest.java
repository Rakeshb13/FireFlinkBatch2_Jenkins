package org.automation.genericLibrary;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseTest {
	
	public WebDriver driver;
	static WebDriver listenersDriver;
	public DataUtility data_Utility = new DataUtility();
	public CommonUtility common_Utility = new CommonUtility();
	public HomePage home_Page;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		sparkReporter = new ExtentSparkReporter("./Reports/"+common_Utility.getCurrenttime()+".html");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
	}
	
	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome") String browserName) throws IOException
	{
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browserName.equals("Edge")) {
			
			driver = new EdgeDriver();
			
		}
		else
			System.out.println("Enter Valid Browser Name");
		
		listenersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameWorkConstants.implicitWaitSec));
		driver.get(data_Utility.getDataFromProperties("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void performLogin(Method method) throws IOException
	{
		test = report.createTest(method.getName());
		home_Page = new HomePage(driver);
		home_Page.getLoginLink().click();
		
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getEmailTextFeild().sendKeys(data_Utility.getDataFromProperties("email"));
		login_Page.getPasswordTextFeild().sendKeys(data_Utility.getDataFromProperties("pwd"));
		login_Page.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void perfromLogout()
	{
		home_Page.getLogoutLink().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		report.flush();
	}
}
