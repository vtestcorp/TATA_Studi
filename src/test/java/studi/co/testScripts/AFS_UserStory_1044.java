package studi.co.testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Create_Study_Plan;
import studi.co.pageModules.Module_Login;

public class AFS_UserStory_1044 extends BaseClass {

	public AFS_UserStory_1044() {
		super();
	}

	@BeforeMethod
	public void Validate_Login(Method m) throws Exception {
		Properties props = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/java/studi/co/Config/config.properties";
		File f = new File(path);
		Test t = m.getAnnotation(Test.class);
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			if (t.groups()[0].equalsIgnoreCase("NewUser"))
				props.setProperty("mobileNumber", prop.getProperty("newUser"));
			else
				props.setProperty("mobileNumber", prop.getProperty("existingUser"));
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		//(String) contextNames.toArray()[1]
		//getDriver().context("WEBVIEW_1");

		 //Module_Login login = new Module_Login();
		// login.Login_to_app();
	}

	@Test(enabled = true, groups = "NewUser") // only for new user(No previously active study plan)
	public void TC01_Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser") // Validate only if user has created a plan previously
	public void TC02_Verify_Existing_User_Should_Be_Able_To_Navigate_Create_Study_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser") // Validate only if user has created a plan and the plan is still
													// active
	public void TC03_Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_To_Test_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser") // Validate only if user has created a plan and the plan is paused
	public void TC04_Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser") // Validate only if user has created a plan previously
	public void TC05_Verify_User_Should_Not_Be_Able_Create_Study_Plan_Unless_Selecting_Syllabus()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_User_Should_Not_Be_Able_Create_Study_Plan_Unless_Selecting_Syllabus(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "NewUser") // only for new user(No previously active study plan)
	public void TC06_Verify_Create_Study_Plan_Button_Is_Tappable_On_Landing_Page()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Create_Study_Plan_Button_Is_Tappable_On_Landing_Page(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "NewUser") // only for new user(No previously active study plan)
	public void TC08_Verify_After_Create_Study_Plan_Button_User_Navigate_To_Bookshelf()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_Create_Study_Plan_Button_User_Navigate_To_Bookshelf(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC26_Verify_Each_Topic_Have_5Lessons_With_One_Spaced_Practice() throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Each_Topic_Have_5Lessons_With_One_Spaced_Practice(prop.getProperty("subject"), prop.getProperty("topic"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC27_Verify_Each_Flagged_Subject_Have_5Lessons_With_Two_Spaced_Practice() throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.TC27_Verify_Each_Flagged_Subject_Have_5Lessons_With_Two_Spaced_Practice(prop.getProperty("subject"), prop.getProperty("topic"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC28_Verify_Lesson_Order_In_Test_Unit() throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Lesson_Order_In_Test_Unit(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC29_Verify_Lesson_Order_After_Complting_Lessons_In_Test_Unit()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Lesson_Order_After_Complting_Lessons_In_Test_Unit(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC30_Verify_BigIdea_Revise_And_Practice_Unlocked_Together_In_Test_Unit()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_BigIdea_Revise_And_Practice_Unlocked_Together_In_Test_Unit(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	// need 2 topics with same chapter
	@Test(enabled = true, groups = "ExistingUser")
	public void TC31_Verify_After_First_Topic_Completion_Second_Topic_Will_Unlocked_In_Test_Unit() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_First_Topic_Completion_Second_Topic_Will_Unlocked_In_Test_Unit(prop.getProperty("subject"),
				prop.getProperty("topic"), prop.getProperty("topic2"));
	}

	// need 2 topics with same chapter
	@Test(enabled = true, groups = "ExistingUser")
	public void TC32_Verify_BigIdea_Revise_And_Practice_Unlocked_Together_For_Upcoming_Topic_In_Test_Unit()
			throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_BigIdea_Revise_And_Practice_Unlocked_Together_For_Upcoming_Topic_In_Test_Unit(
				prop.getProperty("subject"), prop.getProperty("topic"), prop.getProperty("topic2"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC33_Verify_Order_Of_Release_As_BigIdea_Revise_And_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Order_Of_Release_As_BigIdea_Revise_And_Practice(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC34_Verify_After_Chapter_Complition_Summary_And_Test_Will_Released()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_Chapter_Complition_Summary_And_Test_Will_Released(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	//Failed as Build behaviour not as expected
	@Test(enabled = true, groups = "ExistingUser")
	public void TC35_Verify_After_Completing_Only_Practice_Lessons_Of_Upcoming_Topic_Unlocked()
			throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_Completing_Only_Practice_Lessons_Of_Upcoming_Topic_Unlocked(prop.getProperty("subject"),
				prop.getProperty("topic"),prop.getProperty("topic2"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC36_Verify_After_Completing_Test_Lessons_Of_Upcoming_Topic_Unlocked()
			throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_Completing_Test_Lessons_Of_Upcoming_Topic_Unlocked(prop.getProperty("subject"),
				prop.getProperty("topic"),prop.getProperty("topic2"));
	}
	
	@Test(enabled = true, groups = "ExistingUser")
	public void TC37_Verify_Listing_Of_Scheduled_Lessons()
			throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Listing_Of_Scheduled_Lessons(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}
	
	
	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC42_Verify_One_Spaced_Practice_For_All_ParentLesson_In_Test_Unit() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_One_Spaced_Practice_For_All_ParentLesson_In_Test_Unit(prop.getProperty("subject"),
				prop.getProperty("topic"), prop.getProperty("topic2"));
	}

	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC43_Verify_Two_Spaced_Practice_For_All_Flaged_ParentLesson_In_Test_Unit() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Two_Spaced_Practice_For_All_Flaged_ParentLesson_In_Test_Unit(prop.getProperty("subject"),
				prop.getProperty("topic"), prop.getProperty("topic2"));
	}

	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC44_Verify_Spaced2_Practice_Only_Added_If_Parent_Practice_Is_Incomplete_In_Test_Unit()
			throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Spaced2_Practice_Only_Added_If_Parent_Practice_Is_Incomplete_In_Test_Unit(
				prop.getProperty("subject"), prop.getProperty("topic"));
	}

	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC45_Verify_Spaced_Practice1_And_Prctice2_Not_Come_In_Same_Day() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Spaced_Practice1_And_Prctice2_Not_Come_In_Same_Day(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC46_Verify_Spaced_Practice_And_Parent_Prctice_Not_Come_In_Same_Day() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Spaced_Practice_And_Parent_Prctice_Not_Come_In_Same_Day(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC49_Verify_Lesson_Status_Will_Reflects_In_Lessons_Today_Tab()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Lesson_Status_Will_Reflects_In_Lessons_Today_Tab(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC50_Verify_After_Completing_Lesson_Not_Reflects_In_Upcoming_Today_Tab() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_After_Completing_Lesson_Not_Reflects_In_Upcoming_Today_Tab(prop.getProperty("subject"),
				prop.getProperty("topic"), prop.getProperty("topic2"));
	}

	@Test(enabled = true, groups = "ExistingUser")
	public void TC52_Verify_Past_Completed_Lessons_Can_Be_Attempted_Again() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Past_Completed_Lessons_Can_Be_Attempted_Again(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	// only for one subject---> one or two topics
	@Test(enabled = true, groups = "ExistingUser")
	public void TC60_Verify_User_Should_Be_Able_To_Create_Study_Plan_Via_Syllabus_Module() throws Exception {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_User_Should_Be_Able_To_Create_Study_Plan_Via_Syllabus_Module(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

	@AfterClass
	private void setUserID() {
		Properties props = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\studi\\co\\Config\\config.properties";
		File f = new File(path);
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			props.setProperty("mobileNumber", prop.getProperty("existingUser"));
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
