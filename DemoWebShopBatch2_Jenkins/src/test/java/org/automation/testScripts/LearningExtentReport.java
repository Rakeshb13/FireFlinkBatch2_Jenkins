package org.automation.testScripts;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReport {
	
	@Test
	public void testCase()
	{
//		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/Demo1.html");
//		ExtentReports report = new ExtentReports();
//		report.attachReporter(sparkReporter);
//		
		//ExtentTest test = report.createTest("RegisterTestCase");
//		
//		test.assignCategory("Smoke");
//		test.assignAuthor("Basavaraj");
//		
//		test.log(Status.INFO, "Launching Browser");
//		
//		test.log(Status.INFO, "Navigated to Demo Web Shop");
//		
//		test.log(Status.INFO, "Performing Register");
//		
//		test.log(Status.PASS, "Register Test case Pass..");
//		
//		report.flush();
		
		System.out.println( LocalDateTime.now().toString());
	}
}
