package com.qa.AutomatedTestingAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage 
{
	@FindBy(xpath = "//*[@id=\"j_username\"]")
	WebElement userName;
	
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	WebElement password;
	
	@FindBy(xpath = "/html/body/div/div/form/div[3]/input")
	WebElement SignInButton;
	
	
	
	public void userName(String input)
	{
		userName.sendKeys(input);
	}
	
	public void InputPassword(String pass)
	{
		password.sendKeys(pass);
		password.submit();
	}
}
