package com.dollardays.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.dollardays.commonutilities.BaseTest;
import com.dollardays.pages.HomePage;
import com.dollardays.pages.SiteLoginPage;

public class signInTest extends BaseTest{
      HomePage homePage = null;
      SiteLoginPage siteLogin = null;
      
 
      
 @Test(priority=6)
 public void signIn() {
	 homePage = new HomePage(driver);
	 siteLogin = homePage.ClicksignIn();
	 siteLogin.signInAccount();
 }
 @Test(priority=7)
	 public void verfiySignInName() {
	 homePage = new HomePage(driver);
	 siteLogin = homePage.ClicksignIn();
	 siteLogin.signInAccount();
	 String nameText = siteLogin.returnSignInName();
	 Assert.assertEquals(nameText, "Srikanths T.");
	 
 }

	
}
