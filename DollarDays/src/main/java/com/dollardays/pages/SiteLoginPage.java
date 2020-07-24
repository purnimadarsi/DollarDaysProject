package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.commonutilities.BasePage;

public class SiteLoginPage extends BasePage {

	@FindBy(id="inputLoginUsername")
	public WebElement emailAddr;

	@FindBy(id="inputLoginPassword")
	public WebElement passWord;

	@FindBy(className="btn")
	public WebElement SignIn;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']/child::span[contains(text(),'Srikanth')]")
	public WebElement signInName;

	public SiteLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	public void signInAccount() {
		verifyElementpresent(emailAddr);
		emailAddr.sendKeys("srikanthtesting100@gmail.com");
		verifyElementpresent(passWord);
		passWord.sendKeys("password123");
		SignIn.click();

	}
	public String returnSignInName() {
		String nameText="";
		if(signInName.isDisplayed()) {
			nameText = signInName.getText();
			
		}
		
		return nameText;
	}
	
}
