package com.dollardays.commonutilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class TestListeners  implements ITestListener{
      

	ExtentReports extent = ExtentManager.extentReportGenerator();
       ExtentTest test;
       private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		 String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Successful</b>";
	       Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
	       extentTest.get().log(Status.PASS, m);
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		String exceptionmsg = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>Exception Occured,click to see details:"
	            +"</font></b></summary>"+exceptionmsg.replaceAll(",","<br>")+
	            "</details>\n");
		 WebDriver driver = ((BaseTest)result.getInstance()).driver;
		
		
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodname,driver),methodname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String logText = "<b>Test Method "+methodname +" Failed</b>";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
		
	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP,m);
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	public String getScreenShotPath(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Reports/"+testcasename+".png";
		FileUtils.copyFile(source, new File(path));
		return path;
		
	}
		

}
