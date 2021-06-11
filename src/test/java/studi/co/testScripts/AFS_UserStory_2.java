package studi.co.testScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Syllabus_Options;

public class AFS_UserStory_2 extends BaseClass {

	public AFS_UserStory_2() {
		super();
	}

	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = true)
	public void TC01_Verify_User_Should_Be_Able_To_Navigate_To_Revision_Via_MySyllabus()
			throws MalformedURLException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Navigate_To_Revision_Via_MySyllabus(prop.getProperty("subject"),
				prop.getProperty("topic")); 
	}

	@Test(enabled = true)
	public void TC02_Verify_User_Should_Be_Able_To_Launch_Revision_Via_MySyllabus()
			throws MalformedURLException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Launch_Revision_Via_MySyllabus(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC03_Verify_Revision_Overview_() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Revision_Overview(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC04_Verify_User_Should_Be_Able_To_Begin_Revision_From_Syllabus()
			throws WebDriverException, IOException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Begin_Revision(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true)//java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence

	public void TC05_Verify_User_Should_Be_Able_To_View_Video_In_Revision_From_Syllabus()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_View_Video(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true) //pass  need to delete note manually(if any already created).
	public void TC08_Verify_User_Should_Be_Able_To_Create_Note_During_Video_In_Revision_From_Syllabus()
			throws WebDriverException, IOException, InterruptedException, AWTException, ParseException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Create_Note_During_Video(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true) // each time need to send new subject. As it check initial revision completes
	public void TC10_Verify_User_Should_Be_Able_To_View_Summary_Pages() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_View_Summary_Pages(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled =true)
	public void TC11_Verify_User_Should_Be_Able_To_Abondon_The_Revision() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Abondon_The_Revision(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true)//pass
	public void TC12_Verify_User_Should_Be_Able_To_Attempt_Revision_Multiple_Times()
			throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Attempt_Revision_Multiple_Times(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true)//org.openqa.selenium.UnsupportedCommandException: Unknown mobile command "alert".


	public void TC13_Verify_Functionality_After_Killing_The_App() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Functionality_After_Killing_The_App(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true) //// only worked with emulator
	public void TC14_Verify_Functionality_The_App_After_Network_Loss_() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Functionality_After_Network_Loss_The_App(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true) // f for emulator only
	public void TC15_Verify_Functionality_Of_App_After_Call_Interrupt() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Functionality_The_App_After_Call_Interrupt(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true)//f
	public void TC16_Verify_Functionality_Of_App_In_App_Background_Scenario() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Functionality_Of_App_In_App_Background_Scenario(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true)//pass
	public void TC17_Verify_Behaviour_In_Landscape_And_Portrait_Mode_Transition()
			throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Behaviour_In_Landscape_And_Portrait_Mode_Transition(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC_18_Verify_Behaviour_In_Sleep_Mode() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Behaviour_In_Sleep_Mode(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = true)//ClassCastException: class io.appium.java_client.AppiumDriver cannot be cast to class 
	public void TC19_Verify_Behaviour_In_Locking_and_Unlocking_Transition() throws InterruptedException, IOException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Behaviour_In_Locking_and_Unlocking_Transition(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
