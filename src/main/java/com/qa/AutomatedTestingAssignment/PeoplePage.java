package com.qa.AutomatedTestingAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PeoplePage 
{
	
	
	@FindBy(xpath = "//*[@id=\"person-JavaNum2\"]/td[2]/a")
	WebElement createdUserName;
	
	@FindBy(xpath = "//*[@id=\"people\"]")
	WebElement peopleTable;
	
	boolean Namecreated = false;
	
	
	
	
	public String getUserName()
	{
		
		return createdUserName.getText();
		
	}
	
	public boolean getIfNameExist()
	{
		return Namecreated = true;
	}

}
