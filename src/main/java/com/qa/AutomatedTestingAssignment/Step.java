package com.qa.AutomatedTestingAssignment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step 
{
	WebDriver driver = null;
	
	String arg1Holder = "";
	
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\AssessmentReport.html", true);
	ExtentTest test;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() 
	{
		driver.navigate().to(ConstantVars.LoginPage);
	    // Write code here that turns the phrase above into concrete actions
		
		test = extent.startTest("that_you_are_on_the_create_UserScreen");
		test.log(LogStatus.INFO, "Start Test");
		
		LoginPage loginuser = PageFactory.initElements(driver, LoginPage.class);	
		//login in if taken to the login page
		loginuser.userName(ConstantVars.username);
		loginuser.InputPassword(ConstantVars.password);
		driver.get(ConstantVars.addUser);
		
		if(driver.getCurrentUrl().equals(ConstantVars.addUser))
		{
			test.log(LogStatus.PASS, "Managed to get to the add users page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Failed to get to add users page");
		}
		assertEquals(ConstantVars.addUser, driver.getCurrentUrl());


	   // driver.close();
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		test.log(LogStatus.INFO, "the User details are entered on the Create UserScreen");
		CreateUsersPage createuser = PageFactory.initElements(driver, CreateUsersPage.class);	
	    
		createuser.inputUserName(ConstantVars.jimiusername);
		createuser.inputPassword(ConstantVars.jimipassword);
		createuser.inputFullName(ConstantVars.jimifirstname, ConstantVars.jimiSecondName);
		createuser.inputEmail(ConstantVars.jimiemail);
		createuser.submitdetails();
			
		if(createuser.allinputed)
		{
			test.log(LogStatus.PASS, "All details entered and users created");
		}
		else
		{
			test.log(LogStatus.FAIL, "Some deatils are missing or Wrong");
		}
		
		assertEquals(true, createuser.allinputed);
		
		//extent.flush();
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		test.log(LogStatus.INFO, "the details are submitted on the Create UserScreen");
		
		driver.get("http://localhost:8080/securityRealm/addUser");
		CreateUsersPage createuser = PageFactory.initElements(driver, CreateUsersPage.class);	
		
		//createuser.submitdetails();
		
		if(createuser.fullName.isDisplayed())
		{
			test.log(LogStatus.PASS, "All details have been submitted");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Submit failed");
		}
		
		assertEquals(true, createuser.submitdetails() );
		//extent.flush();
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable 
	{
		driver.get(ConstantVars.PeoplePage);
		
		test.log(LogStatus.INFO, "Checking if the created users can been seen");
		PeoplePage people = PageFactory.initElements(driver, PeoplePage.class);	
	    
		if(people.getUserName().equals(ConstantVars.jimiusername))
		{
			test.log(LogStatus.PASS, "The user created can be seen");
		}
		else
		{
			test.log(LogStatus.FAIL, "The user could not be found");
		}
		assertEquals(ConstantVars.jimiusername, people.getUserName());
		
		//extent.flush();

	    // Write code here that turns the phrase above into concrete actions

	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		test = extent.startTest("Deatils Are pulled from feature file");
		test.log(LogStatus.INFO, "the User details username password confirm Password and Fullname are entered on the Create UserScreen");
		CreateUsersPage createuser = PageFactory.initElements(driver, CreateUsersPage.class);
		
		
		createuser.inputAllData(arg1, arg2, arg3, arg4, ConstantVars.jimiemail);
		arg1Holder = arg1;
		if(createuser.allinputed == true)
		{
			test.log(LogStatus.PASS, "All details inputed from feature file");
		}
		else
		{
			test.log(LogStatus.FAIL, "Details not inputed");
		}
		

		assertEquals(arg1, createuser.getUserName());
		//extent.flush();
		
		driver.close();
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "username should be visible on the UsersScreen");
		CreateUsersPage createuser = PageFactory.initElements(driver, CreateUsersPage.class);
		
		driver.close();
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "username is visible on the UsersScreen");
		driver.get(ConstantVars.PeoplePage);
		CreateUsersPage createuser = PageFactory.initElements(driver, CreateUsersPage.class);
		
		if(arg1.equals(createuser.getUserName()))
		{
			test.log(LogStatus.PASS, "name is visable");
		}
		
		else
		{
			test.log(LogStatus.FAIL, "name is not visable");
		}
		assertEquals(arg1, createuser.getUserName());
		
		driver.close();
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		

		
		driver.close();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@After
	public void tearDown()
	{
		extent.flush();
	}
}
