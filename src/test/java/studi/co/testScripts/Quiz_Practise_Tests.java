package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Quiz_Practise;

public class Quiz_Practise_Tests extends BaseClass {
	public Quiz_Practise_Tests() {
		super();
	}

//	@Test(enabled = false) // Hold
//	public void TC_07_verify_That_User_Is_Not_Able_To_Submit_Answer_Without_Selecting_All_The_Options_For_Sorting_Question() {
//		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
//
//	}
//
//	@Test(enabled = false) // hold
//	public void TC_08_verify_That_In_Order_To_Answer_The_Sorting_Question_User_Is_Able_To_Drag_And_Drop_The_Options_In_The_Placeholder() {
//		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
//	}

	@Test(enabled = true)
	public void TC_09_Verify_All_Questions_Are_Mandatory_In_Practise_Module()
			throws MalformedURLException, InterruptedException {
		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
		quiz.verify_All_Questions_Are_Mandatory_In_Practise_Module(prop.getProperty("subject77"),
				prop.getProperty("topic77"));

	}

	@Test(enabled = true)
	public void TC_10_verify_That_User_Can_Skip_The_Question_And_Navigate_To_Next_Question_But_Doesnot_Navigate_To_Test_Without_Submitting_Answers_For_All_Questions()
			throws MalformedURLException, InterruptedException {
		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
		quiz.to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(
				prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = true)
	public void TC_11_verify_That_Feedback_Will_Be_Provided_At_The_Click_Of_Check_Answer()
			throws MalformedURLException, InterruptedException {
		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
		quiz.Module_Verify_Feedback_Shown_For_Correct_Answer_Selection_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = true)
	public void TC_12_Verify_That_User_Is_Able_Reattempt_The_Question_One_More_Time_If_One_Attempt_Is_Wrong()
			throws Exception {
		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
		quiz.Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt(prop.getProperty("subject77"),
				prop.getProperty("topic77"));

	}

	@Test(enabled = false) // hold
	public void TC_13_verify_That_User_Chooses_One_Option_Right_And_Another_Wrong_Or_viceversa_The_Answers_Are_Considered_Partially_Correct_In_Case_Of_Sorting_Question() {
		Module_Quiz_Practise quiz = new Module_Quiz_Practise();
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}