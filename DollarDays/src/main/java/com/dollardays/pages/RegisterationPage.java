package com.dollardays.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dollardays.commonutilities.BasePage;

public class RegisterationPage extends BasePage {

	public RegisterationPage(WebDriver driver) {
		super(driver);
         PageFactory.initElements(driver,this);       
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="ctl00$cphContent$txtFName")
	public WebElement firstName;
	
	@FindBy(css="input[id$='_txtLName']")
	public WebElement lastName;
	
	@FindBy(css="input[id$='_txtClientEmail']")
	public WebElement emailaddress;
	
	@FindBy(css="input[id$='_txtPhoneMain']")
	public WebElement phoneNo;
	
	@FindBy(css="input[id$='_txtPassword']")
	public WebElement password;
	
	@FindBy(css="input[id$='_txtPasswordConfirm']")
	public WebElement confirmPassword;
	
	@FindBy(css="input[class$='btn-block']")
	public WebElement createAccount;
	
	//@FindBy(css="label[class='error']");
	
	
	
	
	

	public void setData(String firstname,String lastname,String emailaddres,String phoneno,String passWord,String ConfirmPassword) {
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		emailaddress.sendKeys(emailaddres);
		phoneNo.sendKeys(phoneno);
		password.sendKeys(passWord);
	    confirmPassword.sendKeys(ConfirmPassword);
		confirmPassword.sendKeys("");
		createAccount.click();
		
	}
	
	
}
