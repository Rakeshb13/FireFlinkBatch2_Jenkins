package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(2000);
	}
	
	public String getCurrenttime()
	{
		LocalDateTime l = LocalDateTime.now();
		return l.toString().replace(":", "-");
	}
	
	public String toTakeScreenShot(WebDriver driver) throws IOException
	{
		String path=FrameWorkConstants.screenShot_Path+getCurrenttime()+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(path);
		FileHandler.copy(src, trg);
		return "."+path;
	}
	
	public void selectDropDownByIndex(WebElement dropDown, int indexNum)
	{
		Select s = new Select(dropDown);
		s.selectByIndex(indexNum);
	}
	
	
	
	
	
	
	
	

}
