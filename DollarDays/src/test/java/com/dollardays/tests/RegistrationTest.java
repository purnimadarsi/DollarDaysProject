package com.dollardays.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dollardays.commonutilities.BasePage;
import com.dollardays.commonutilities.BaseTest;
import com.dollardays.pages.HomePage;
import com.dollardays.pages.RegisterationPage;

public class RegistrationTest extends BaseTest{
	 HomePage homePage = null;
     RegisterationPage regPage = null;
     BasePage basePage = null;
     
    
     @DataProvider
 	public Object[][] caDataSource() {
    	
 		Object[][] testData = basePage.getDataFromExcel("createaccount") ;//basepage.java have this method 
 		
 		return testData;
 	}
     @Test(dataProvider="caDataSource")
   
     public void CreateAccount(String firstname,String lastname,String emailaddres,String phoneno,String passWord,String ConfirmPassword) {
    	 homePage = new HomePage(driver);
    	   basePage = new BasePage(driver);
    	  regPage= homePage.selectCreateAccount();
    	 regPage.setData(firstname, lastname, emailaddres, phoneno, passWord, ConfirmPassword);
    	 String title = driver.getTitle();
    	 System.out.println(driver.getTitle()+"***************");
    	 Assert.assertEquals(title, "Thank you for registering - DollarDays");
    	//Assert.assertEquals(title, "Login or Register - DollarDays");
     }
}
