package com.qa.AutomatedTestingAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUsersPage 
{
	

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	WebElement Emailaddress;
	
	@FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
	WebElement createUserButton;
	

	
	public boolean allinputed = false;
	public boolean submitClicked = false;
	
	
	public void inputUserName(String username)
	{
		userName.sendKeys(username);
	}
	
	public void inputPassword(String password)
	{
		Password.sendKeys(password);
		confirmpassword.sendKeys(password);
	}
	
	public void inputFullName(String first, String second)
	{
		fullName.sendKeys(first,second);
	}
	
	public void inputEmail(String email)
	{
		Emailaddress.sendKeys(email);
		allinputed = true;
		createUserButton.submit();
	}
	
	public boolean submitdetails()
	{
		createUserButton.submit();
		return submitClicked = true;
	}
	
	public boolean inputAllData(String username, String password,String confirmPass , String FullName ,String email )
	{
		userName.sendKeys(username);
		Password.sendKeys(password);
		confirmpassword.sendKeys(password);
		fullName.sendKeys(FullName);
		Emailaddress.sendKeys(email);
		createUserButton.submit();
		
		return allinputed = true;
			
	}
	
	public String getUserName()
	{
		return userName.getAttribute("value");
	}
	
	public void checkNames(String username)
	{

	}
	
	
	
	
	
}
