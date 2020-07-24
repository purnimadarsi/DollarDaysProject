package com.dollardays.commonutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class BasePage {
	    protected WebDriver driver=null;
	    WebDriverWait w;
	    public static String TESTDATA_SHEET_PATH ="C:\\workspace\\eclipse\\DollarDays\\src\\main\\java\\com\\dollardays\\testdata\\DollarDaysTestData.xlsx";
	    
	    static Workbook book;
	    static Sheet sheet;

		
	public BasePage(WebDriver driver)
	{
			this.driver=driver;
			w = new WebDriverWait(driver, 10);
			//PageFactory.initElements(driver, this);	
	}
	public String verifyTitlepresent()
	{
	
		
			String actTitle = driver.getTitle();
		//	Assert.assertEquals(actTitle, expTitle);
			return actTitle;
	
}	
	public String getScreenShotPath(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Reports/"+testcasename+".png";
		FileUtils.copyFile(source, new File(path));
		return path;
		
	}
		
public void verifyElementpresent(WebElement ele)
{
		//WebDriverWait w = new WebDriverWait(driver, 10);
		
		try
		{
			w.until(ExpectedConditions.visibilityOf(ele));
			
			
		}
		
		catch(Exception e)
		{
			
			
		}
		
}
public boolean isDisplay(WebElement ele) {
	verifyElementpresent(ele);
	mouseOver(ele);
	boolean displayed = ele.isDisplayed();
	return displayed;
}
public void mouseOver(WebElement ele)
{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			
			
		}
		catch(Exception e)
		{
			
		}		
}
	
public void switchBrowser() 
{
		try 
		{
		      Set<String>handler=driver.getWindowHandles();
		      Iterator<String>it=handler.iterator();
		      String parentWindowId=it.next();
		      System.out.println("pwindowid:" +parentWindowId);
		      String childwindowId=it.next();
		      System.out.println("cwindowid:" +childwindowId);
		      driver.switchTo().window(childwindowId);
			

		} 
		catch (Exception e) 
		{
			
		}

}
/*public static ArrayList<Object[]> getDataFromExcel() {
	   
	   ArrayList<Object[]>  mydata = new ArrayList<Object[]>();
	   Xls_Reader reader = null;
	   try {
		   System.out.println("enter testutili");
		   
		   reader = new Xls_Reader("C:\\workspace\\eclipse\\DollarDays\\src\\excelExportAndFileIO\\CreateAccountTD.xlsx");
		  
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	for (int rownum=2; rownum<=reader.getRowCount("sheet1"); rownum++){
		
	   String firstname = reader.getCellData("sheet1", "firstname", rownum);
	   String lastname  = reader.getCellData("sheet1", "lastname", rownum);
	   String gmail  = reader.getCellData("sheet1", "email", rownum);
	   String phone = reader.getCellData("sheet1","phonenumber", rownum);
	   String password  = reader.getCellData("sheet1", "password", rownum);
	   Object ob[] = {firstname,lastname,gmail,phone,password};
	   mydata.add(ob);
	   System.out.println(firstname);
	   
			   
	  }
	   System.out.println(mydata);
	   return mydata;
}*/
public static Object[][] getDataFromExcel(String sheetName){
	  FileInputStream file = null;
	  try {
		  file = new FileInputStream(TESTDATA_SHEET_PATH);
		  
	  }catch(FileNotFoundException e) {
		  e.printStackTrace();
	  }
	  try {
		  book=WorkbookFactory.create(file);
		  
	  }catch(InvalidFormatException e) {
		  e.printStackTrace();
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
	  sheet= book.getSheet(sheetName);
	  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  for(int i=0;i<sheet.getLastRowNum();i++) {
		  for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			  data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			  System.out.println(data[i][k]);
			  //data[i][k] = sheet.getRow(i+1).getCell(k).toString()
		  }
	  }
	return data;
		  
}
}
