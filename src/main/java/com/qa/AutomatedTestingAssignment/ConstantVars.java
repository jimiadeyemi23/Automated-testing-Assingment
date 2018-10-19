package com.qa.AutomatedTestingAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstantVars 
{
	
	public static final String JenkinsHome = "http://localhost:8080/";	
	public static final String securityRealm = "http://localhost:8080/securityRealm/";
	public static final String addUser = "http://localhost:8080/securityRealm/addUser";	
	public static final String LoginPage = "http://localhost:8080/login?from=%2F";
	public static final String PeoplePage = "http://localhost:8080/asynchPeople/";
	
	public static final String chrisPage = "http://localhost:8080/user/chris95/";
	
	public static final String username = "root";
	public static final String password = "root";
	
	public static final String jimiusername = "JavaNum2";
	public static final String jimipassword = "Reference";
	public static final String jimifirstname = "jimi";
	public static final String jimiSecondName = "ade";
	public static final String jimiemail = "test@test.com";
	
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	WebElement ManageJenKins;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[17]/a/dl/dt")
	WebElement ManageUsers;

}
