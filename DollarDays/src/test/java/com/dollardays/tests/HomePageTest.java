package com.dollardays.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dollardays.commonutilities.BaseTest;
import com.dollardays.pages.HomePage;


public class HomePageTest extends BaseTest{
	HomePage homePage = null;
    
	
	 @Test(priority=1)
	  public void VerfiyTiltle() {
		  homePage = new HomePage(driver);
		  String expectitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		  String actualtitle = homePage.PageTitle();
		  System.out.println(actualtitle+"***************************");
		  Assert.assertEquals(actualtitle, expectitle);
	  }
	  @Test(priority=2)
	  public void verfiyDdLogo() {
		  homePage = new HomePage(driver);
		  boolean ddLogo = homePage.isDdLogoPresent();
		  Assert.assertTrue(ddLogo);
	 }
	  @Test(priority=3)
	  public void verfiySignInLogo() {
		  homePage = new HomePage(driver);
		  boolean signInLogo = homePage.isSignInIconPresent();
		  Assert.assertTrue(signInLogo);
	  }
	  @Test(priority=4)
	  public void verfiyWishListLogo() {
		  homePage = new HomePage(driver);
		  boolean wishListLogo = homePage.isWishListIconPresent();
		  Assert.assertTrue(wishListLogo);
	  }
	  @Test(priority=5)
	  public void verfiyCartLogo() {
		  homePage = new HomePage(driver);
		  boolean wishListLogo = homePage.isCartIconPresent();
		  Assert.assertTrue(wishListLogo);
	  }
}
