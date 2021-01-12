package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageModules.*;

public class AFS_UserStory_77 extends BaseClass {

	public AFS_UserStory_77() {
		super();

	}

	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = false)
	public void TC01_To_Verify_Receive_SCQ_Questions_In_Revision()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Revision(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = false)
	// @Test(enabled = false, dataProvider = "Political_Science_Data",
	// dataProviderClass = DataProviders.class)
	// public void
	// TC02_Verify_Receive_SCQ_Questions_Default_State_In_Revision(String subject,
	// String topic)
	public void TC02_To_Verify_SCQ_Answers_In_Default_State_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Default_State_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
		// rqr.Module_Receive_SCQ_Questions_Default_State_In_Revision(subject, topic);
	}

	@Test(enabled = false) // Blocked
	public void TC03_To_Verify_Answer_Layout_Of_SCQ_Answers_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Assert.assertTrue(false);
	}

	@Test(enabled = false)
	public void TC04_To_Verify_SCQ_Answers_Can_Be_Select_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Answer_Can_Be_Select_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false) // Blocked
	public void TC05_To_Verify_Single_Answer_Is_Correct_For_SCQ_Question_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Single_Answer_Is_Correct_For_SCQ_Question_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false) // Blocked
	public void TC06_To_Verify_Student_Should_Get_Instant_Feedback_For_SCQ_Question_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Assert.assertTrue(false);
	}

	@Test(enabled = false) // Blocked
	public void TC07_To_Verify_State_Of_Answer_Should_Be_Maintained_For_SCQ_Question_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Assert.assertTrue(false);
	}

	@Test(enabled = false) // needs questions data
	public void TC08_To_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
	}

	@Test(enabled = false)
	public void TC09_To_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_Attempting_Quiz_Is_Not_Mandatory_In_Revision(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false) // Blocked
	public void TC10_To_Verify_User_Can_Click_On_All_SCQ_Answers_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC11_To_Verify_User_Can_Abandon_SCQ_Quiz_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_User_Can_Abandon_Quiz_In_Revision(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC12_To_Verify_Receive_SCQ_Questions_In_Practice()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Questions_Practice(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC13_To_Verify_SCQ_Answers_Is_In_Default_State_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Answers_In_Default_State_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC14_To_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC15_To_Verify_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC16_To_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false) // needs questions data
	public void TC17_To_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));

	}

	@Test(enabled = false) // needs questions data
	public void TC18_To_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(
				prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC19_To_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false) /// need data
	public void TC20_To_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
				prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC21_To_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC22_To_Verify_Receive_SCQ_Questions_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_SCQ_Questions_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC23_Module_Receive_SCQ_Answers_In_Default_State_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_SCQ_Answers_In_Default_State_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC24_To_Verify_Multiple_Answers_Shown_For_SCQ_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = false)
	public void TC25_To_Verify_SCQ_Answers_Can_Be_Select_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_SCQ_Answer_Can_Be_Slect_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = false)
	public void TC26_To_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = false) // needs questions data
	public void TC27_To_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false) // needs questions data
	public void TC28_To_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC29_To_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Test()
			throws MalformedURLException, InterruptedException {

		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC30_To_Verify_User_Should_Be_Able_To_Flag_The_SCQ_Question_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Should_Be_Able_To_Flag_The_Question_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC32_To_Verify_Marks_Shown_With_SCQ_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Marks_Shown_With_SCQ_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC33_To_Verify_User_Can_Abond_SCQ_Quiz_In_Test() throws MalformedURLException, InterruptedException {
		System.out.println("Test started");
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Can_Abond_SCQ_Quiz_In_Test(prop.getProperty("Psubject"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
