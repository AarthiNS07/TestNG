package org.testng.TestNGExtent;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 extends ExtentReport
{
	ExtentReport er=new ExtentReport();
	@Test
	public void test1()
	{
		Assert.assertTrue(true);
	}
	@Test
	public void test2()
	{
		Assert.assertTrue(true);
	}
	@Test
	public void test3()
	{
		Assert.assertTrue(false);
	}
	@Test
	public void test4()
	{
		Assert.assertTrue(true);
	}
	@AfterTest
	public void afterMethod()
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/extentreport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Login", "This is my login test");
		logger.log(Status.INFO, "Login to Amazon");
		
		logger.log(Status.PASS, "Title verified");
		
		logger.log(Status.FAIL, "Title not verified");
		extent.flush();
	}

}
