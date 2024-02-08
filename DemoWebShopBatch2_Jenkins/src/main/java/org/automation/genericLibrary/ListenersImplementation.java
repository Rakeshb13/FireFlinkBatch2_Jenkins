package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot)BaseTest.listenersDriver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./ScreenShot/"+result.getName()+".png");
		try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
