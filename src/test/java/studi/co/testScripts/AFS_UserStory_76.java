package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.*;

public class AFS_UserStory_76 extends BaseClass {

	public AFS_UserStory_76() {
		super();
	}

	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

////////////////////////////////////////////Practice-MCQ////////////////////////////////////////////////////////

	@Test(enabled = true)
	public void TC12_Verify_MCQ_Questions_In_Pratice() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_MCQ_Questions_Practice(prop.getProperty("msubject"), prop.getProperty("mtopic"));
	}

	@Test(enabled = true)
	public void TC13_To_Verify_MCQ_Answers_Is_In_Default_State_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_MCQ_Answers_In_Default_State_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));
	}

	@Test(enabled = true)
	public void TC14_To_Verify_Multiple_Answers_Shown_For_MCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));
	}

	@Test(enabled = true)
	public void TC15_To_Verify_MCQ_Answers_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_MCQ_Answer_Can_Be_Slect_In_Practice(prop.getProperty("msubject"), prop.getProperty("mtopic"));
		
	}

	@Test(enabled = true)
	public void TC16_To_Verify_Multiple_MSQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_Multiple_MCQ_Answer_Can_Be_Select_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));
	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC17_To_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Practice()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));

	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC18_To_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Practice()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_MCQ_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));

	}

	@Test(enabled = true)
	public void TC19_To_Verify_Attempting_MCQ_Quiz_Is_Mandatory_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_Attempting_MCQ_Quiz_Is_Mandatory_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));

	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC20_To_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_MCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_MCQ_In_Practice(
				prop.getProperty("msubject"), prop.getProperty("mtopic"));
	}

	@Test(enabled = true)
	public void TC21_To_Verify_User_Can_Abond_MCQ_Quiz_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqt = new Module_Receive_Questions_Practice();
		rqt.Module_Verify_User_Can_Abond_MCQ_Quiz_In_Practice(prop.getProperty("msubject"), prop.getProperty("mtopic"));

	}

	@Test(enabled = true)
	public void TC01_Verify_MCQ_Questions_In_Revision() throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_MCQ_Questions_Revision(prop.getProperty("msubject"), prop.getProperty("mtopic"));
	}

	@Test(enabled = true) // Blocked
	public void TC02_To_Verify_MCQ_Answers_Is_In_Default_State_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_MCQ_Answers_In_Default_State_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));
	}

	@Test(enabled = true) // Blocked
	public void TC03_To_Verify_Multiple_Answers_Shown_For_MCQ_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Practice(prop.getProperty("msubject"),
				prop.getProperty("mtopic"));
	}

	@Test(enabled = true) // Blocked
	public void TC04_To_Verify_MCQ_Answers_Can_Be_Select_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Assert.assertTrue(false);
	}

	@Test(enabled = true) // Blocked
	public void TC05_To_Verify_Multiple_MSQ_Answer_Can_Be_Select_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC06_To_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);

	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC07_To_Verify_State_Of_Answer_Should_Be_Maintained_For_MCQ_Answer_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);

	}

	@Test(enabled = true) // needs questions data
	public void TC08_To_Verify_Correct_Incorrect_Feedback_Shown_After_MCQ_Answer_Selection_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
	}

	@Test(enabled = true)
	public void TC09_To_Verify_Attempting_MCQ_Quiz_Is_Not_Mandatory_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_Attempting_Quiz_Is_Not_Mandatory_In_Revision(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = true) // Blocked
	public void TC10_To_Verify_User_Can_Click_On_All_MCQ_Answers_In_Revision()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
	}

	@Test(enabled = true)
	public void TC11_To_Verify_User_Can_Abandon_MCQ_Quiz_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_User_Can_Abandon_Quiz_In_Revision(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(enabled = true)
	public void TC22_To_Verify_Receive_MCQ_Questions_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_MCQ_Questions_Test(prop.getProperty("msubject"));

	}

	@Test(enabled = true)
	public void TC23_Module_Receive_MCQ_Answers_In_Default_State_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_MCQ_Answers_In_Default_State_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC24_To_Verify_Multiple_Answers_Shown_For_MCQ_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Multiple_Answers_Shown_For_MCQ_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = true)
	public void TC25_To_Verify_MCQ_Answers_Can_Be_Select_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_MCQ_Answer_Can_Be_Slect_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = true)
	public void TC26_To_Verify_Multiple_MSQ_Answer_Can_Be_Select_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Multiple_MCQ_Answer_Can_Be_Select_In_Test(prop.getProperty("Psubject"));
	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC27_To_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Test()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_After_MCQ_Answer_Selection_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true) // needs questions data // Failed for now
	public void TC28_To_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test()
			throws MalformedURLException, InterruptedException {
		Assert.assertTrue(false);
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_MCQ_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC29_To_Verify_Attempting_MCQ_Quiz_Is_Not_Mandatory_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Attempting_MCQ_Quiz_Is_Not_Mandatory_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC30_To_Verify_User_Should_Be_Able_To_Flag_The_MCQ_Question_With_Hamburger_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Should_Be_Able_To_Flag_The_Question_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC31_To_Verify_User_Should_Be_Able_To_Flag_The_MCQ_Question_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Should_Be_Able_To_Flag_The_Questions_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC32_To_Verify_Marks_Shown_With_MCQ_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Marks_Shown_With_MCQ_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = true)
	public void TC33_To_Verify_User_Can_Abond_MCQ_Quiz_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Can_Abond_MCQ_Quiz_In_Test(prop.getProperty("Psubject"));

	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

	/*
	 * @Test(enabled = false) public void
	 * TC04_Verify_MCQ_Answers_Can_Be_Select_or_Unselect_In_Revision() throws
	 * WebDriverException, IOException, InterruptedException {
	 * Module_Verify_Answers_Can_Be_Select_or_Unselect_In_Revision mvma = new
	 * Module_Verify_Answers_Can_Be_Select_or_Unselect_In_Revision();
	 * mvma.Verify_MCQ_Answers_Can_Be_Select_or_Unselect_In_Revision(); }
	 * 
	 * @Test(enabled = false) public void TC03_Verify_Answer_Options_In_Revision()
	 * throws WebDriverException, IOException, InterruptedException {
	 * Module_Verify_Answer_Options_In_Revision vao = new
	 * Module_Verify_Answer_Options_In_Revision();
	 * vao.Verify_Answer_Options_In_Revision(); }
	 * 
	 * @Test(enabled = false) public void
	 * TC08_Verify_Feedback_For_Answers_In_Revision() throws InterruptedException,
	 * AWTException, IOException { Module_Verify_Answer_Feedback_In_Revision mva =
	 * new Module_Verify_Answer_Feedback_In_Revision();
	 * mva.verify_Answer_Feedback(); }
	 * 
	 * @Test(enabled = false) public void
	 * TC10_Select_All_Answers_And_Verify_Feedback() throws InterruptedException,
	 * AWTException, HeadlessException, IOException {
	 * Module_Verify_Answer_Feedback_In_Revision mvaf = new
	 * Module_Verify_Answer_Feedback_In_Revision();
	 * mvaf.Verify_Feedback_On_All_Answers_In_Revision(); }
	 * 
	 * @Test(enabled = false) public void TC11_Verify_Abandon_Quiz_From_Revision()
	 * throws InterruptedException { Module_Verify_Abandon_Quiz_From_Revision mvaqfr
	 * = new Module_Verify_Abandon_Quiz_From_Revision(); mvaqfr.verifyAbandonQuiz();
	 * }
	 * 
	 * 
	 * @Test(enabled = false) public void TC12_Verify_MCQ_Questions_In_Pratice()
	 * throws InterruptedException, IOException {
	 * Module_Verify_Answer_Options_In_Practice mvaoip = new
	 * Module_Verify_Answer_Options_In_Practice();
	 * mvaoip.module_Verify_Answer_Options_In_Practice();
	 * mvaoip.verify_Question_Count_In_Practice(); }
	 * 
	 * 
	 * @Test(enabled = false) public void TC14_Verify_Answer_Options__In_Practice()
	 * throws InterruptedException, IOException {
	 * Module_Verify_Answer_Options_In_Practice mvaoip = new
	 * Module_Verify_Answer_Options_In_Practice();
	 * mvaoip.module_Verify_Answer_Options_In_Practice(); }
	 * 
	 * @Test(enabled = false) public void
	 * TC15_Verify_Answers_Are_Selectable_And_Deselectable_In_Practice() throws
	 * InterruptedException, IOException { Module_Verify_Answer_Options_In_Practice
	 * mvaoip = new Module_Verify_Answer_Options_In_Practice();
	 * mvaoip.verify_Answers_Selectable_Deselectable(); }
	 * 
	 * @Test(enabled = false) public void
	 * TC18_Verify_Answer_Feedback_Is_Correct_In_Practice() throws
	 * InterruptedException, IOException {
	 * Module_Verify_Answer_Feedback_Is_Correct_In_Practice mva = new
	 * Module_Verify_Answer_Feedback_Is_Correct_In_Practice();
	 * mva.verify_Answer_Feedback(); }
	 * 
	 * @Test(enabled = false) public void TC20_Verify_Attempts_In_Practice_Module()
	 * throws InterruptedException, IOException { Module_Verify_Attempt_In_Practice
	 * mvaip = new Module_Verify_Attempt_In_Practice();
	 * mvaip.verify_Attempt_In_Practice(); }
	 * 
	 * @Test(enabled = false) public void View_Chapter_Details() throws
	 * InterruptedException, AWTException { Model_View_Chapter_Listing MRMQP = new
	 * Model_View_Chapter_Listing(); MRMQP.Verify_View_Chapter_Listing(); }
	 * 
	 * @Test(enabled = false) public void View_Chapter_Listing_Page_Content() throws
	 * InterruptedException, AWTException { Module_View_Chapter_Details MRMQP = new
	 * Module_View_Chapter_Details(); MRMQP.Verify_View_Chapter_Details(); }
	 * 
	 * @Test(enabled = false) public void Review_Plan_Tab() throws
	 * InterruptedException, AWTException { Module_Review_Plan_Tab MRMQP = new
	 * Module_Review_Plan_Tab(); MRMQP.Verify_Review_Plan_Tab(); }
	 * 
	 * @Test(enabled = false) public void Recieve_MCQ_Questions_DefaultState()
	 * throws InterruptedException, AWTException {
	 * 
	 * Model_Receive_MCQ_Questions_DefaultState MRMQP = new
	 * Model_Receive_MCQ_Questions_DefaultState();
	 * MRMQP.Verify_MCQ_Questions_DefaultState(); }
	 * 
	 * @Test(enabled = false) public void Receive_MCQ_Questions_Practice() throws
	 * Exception {
	 * 
	 * Module_Receive_MCQ_Questions_Practice MRMQP = new
	 * Module_Receive_MCQ_Questions_Practice();
	 * MRMQP.Verify_Student_Receives_MCQ_Questions_Practice();
	 * 
	 * }
	 * 
	 * @Test(enabled = false) public void Recieve_MCQ_Questions_Revision() throws
	 * InterruptedException, AWTException { Model_Receive_MCQ_Questions_Revision
	 * MRMQP = new Model_Receive_MCQ_Questions_Revision();
	 * MRMQP.Verify_Navigate_Revision_From_Topic_Listing(); }
	 * 
	 * @Test(enabled = false) public void Navigate_Revision_From_Topic_Listing()
	 * throws InterruptedException, AWTException {
	 * Module_Navigate_Revision_From_Topic_Listing MRMQP = new
	 * Module_Navigate_Revision_From_Topic_Listing();
	 * MRMQP.Verify_Navigate_Revision_From_Topic_Listing(); }
	 * 
	 * @Test(enabled = false) public void Mark_Excluded_From_Syllabus_Manually()
	 * throws InterruptedException { Module_Excluded_From_Syllabus_Manually CSP =
	 * new Module_Excluded_From_Syllabus_Manually();
	 * CSP.Verify_Excluded_From_Syllabus(); }
	 * 
	 * @Test(enabled = false) public void Mark_Completed_In_School_Manaually()
	 * throws InterruptedException { Module_Mark_Completed_In_School_Manually CSP =
	 * new Module_Mark_Completed_In_School_Manually();
	 * CSP.Verify_Completed_In_School_Status(); }
	 * 
	 * @Test(enabled = false) public void Verify_Create_Study_Plan() throws
	 * InterruptedException { Module_Create_Study_Plan CSP = new
	 * Module_Create_Study_Plan(); CSP.Validate_create_study_plan(); }
	 * 
	 * @Test(enabled = false) public void Confirm_Syllabus_Tab() throws
	 * InterruptedException { Module_Get_Syllabus_Tab_Label CSP = new
	 * Module_Get_Syllabus_Tab_Label(); CSP.Verify_Syllabus_Tab_Label(); }
	 * 
	 * @Test(enabled = false) public void Confirm_Syllabus_Page_Tappable() throws
	 * InterruptedException { Module_Syllabus_Tappable CSP = new
	 * Module_Syllabus_Tappable(); CSP.Verify_Syllabus_Tappable(); }
	 * 
	 * @Test(enabled = false) public void Completed_In_School_Status_Chapter()
	 * throws InterruptedException { Module_Completed_In_School CSP = new
	 * Module_Completed_In_School(); CSP.Verify_Completed_In_School_Status(); }
	 * 
	 * @Test(enabled = false) public void
	 * TC03_Verify_RadioButtons_For_Answers_In_Revision() {
	 * 
	 * }
	 */
}
