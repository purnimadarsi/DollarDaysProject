package com.dollardays.commonutilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
   public static ExtentReports extent;
   public static ExtentReports extentReportGenerator() {
	  
	   String path = System.getProperty("user.dir")+"/Reports/index.html";
	  
	   ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	   reporter.config().setReportName("Test Automation Results");
	   reporter.config().setDocumentTitle("Auomation Reports");
	   extent = new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Tester", "purnima");
	   extent.setSystemInfo("Browser", "Chrome");
	   return extent;
	   
	   
	
	   
   }
  
}
