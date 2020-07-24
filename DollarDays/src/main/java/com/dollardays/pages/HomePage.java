package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.commonutilities.BasePage;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className="header-user")
	public WebElement signInElement;	

	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	public WebElement signInLink;

	@FindBy(xpath="//div[@class='mobile-menu-toggle']//following::img[contains(@class,'img-responsive ') and  @alt='DollarDays']")
	public WebElement ddLogo;

	@FindBy(className="header-user")
	public WebElement signinLogo;
    
	@FindBy(className="header-wishlist")
	public WebElement wistListLogo;
	
	@FindBy(className="header-cart")
	public WebElement cartLogo;
	
	@FindBy(xpath="//a[contains(text(),'account')]")
	public WebElement createAccount;


	public  SiteLoginPage ClicksignIn() {
		verifyElementpresent(signInElement);
		mouseOver(signInElement);
		signInElement.click();
		verifyElementpresent(signInLink);
		signInLink.click();
        return new SiteLoginPage(driver);

	} 
	public RegisterationPage selectCreateAccount() {
		verifyElementpresent(signInElement);
		mouseOver(signInElement);
		signInElement.click();
		
		verifyElementpresent(createAccount);
		mouseOver(createAccount);
		createAccount.click();
		return new RegisterationPage(driver);

	}
	public String PageTitle() {
		String title = verifyTitlepresent();
		return title;
	}
	public boolean isDdLogoPresent() {

		return isDisplay(ddLogo);

	}
	public boolean isSignInIconPresent() {

		return isDisplay(signinLogo);

	}
	public boolean isWishListIconPresent() {

		return isDisplay(wistListLogo);

	}
	public boolean isCartIconPresent() {

		return isDisplay(cartLogo);

	}


}
