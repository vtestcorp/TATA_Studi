package studi.co.testScripts;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Digital_Test;


public class Assignment_Digital_Test extends BaseClass{


	public  Assignment_Digital_Test() {
		super();
	}

	@Test(enabled = true)
	public void TC01_To_Verify_Test_Duration_should_be_display_as_per_selection_in_the_test_Settings() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_display_of_test_duration(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC02_To_Verify_That_After_Test_Begin_Timer_Should_Get_Start() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_that_after_test_begin_timer_should_get_start(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled = true)
	public void TC03_To_Verify_while_Entering_Test_Setting_Details_User_Able_To_ON_Help_Toggle() throws MalformedURLException, InterruptedException {

		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_that_User_able_to_ON_Help_toggle(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC04_To_Verify_while_Entering_Test_Setting_Details_User_Able_To_OFF_Help_Toggle() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_that_User_able_to_OFF_Help_toggle(prop.getProperty("subject"),prop.getProperty("topic"));
	}


	@Test(enabled = true)
	public void TC05_To_Verify_Assign_Digital_Test_and_success_message() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_assign_digital_test_and_success_message(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC06_To_Verify_Add_Flag_For_Review_Before_Submission() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_add_flag_for_review_before_submission(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true, priority=-1)
	public void TC07_To_verify_that_at_time_of_test_submission_count_of_attempted_Pending_Flagged_questions_should_be_display() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_Count_of_attempted_Pending_Flagged_questions_should_be_display(prop.getProperty("subject"),prop.getProperty("topic"));;
	}

	@Test(enabled = true, priority=-1)
	public void TC08_To_Verify_the_review_of_Digital_test() throws MalformedURLException, InterruptedException {

		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_review_of_digital_test(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true, priority=-1)
	public void TC09_To_Verify_The_Flag_Reflection_On_Review() throws MalformedURLException, InterruptedException {

		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_the_flag_reflection_on_Review(prop.getProperty("subject"),prop.getProperty("topic"));
	}

//	@Test(enabled = false)//Emoticons need diff values for pink green
//	public void TC10_To_Verify_the_Correct_Incorrect_answers_on_review_page() throws MalformedURLException, InterruptedException {
//
//		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
//		mas.to_verify_the_Correct_Incorrect_answers_on_review_page(prop.getProperty("subject"),prop.getProperty("topic"));
//	}

	@Test(enabled = true)
	public void TC11_To_Verify_the_review_Scrolling() throws MalformedURLException, InterruptedException {

		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_review_Scrolling(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)//pass
	public void TC12_To_Verify_the_Close_Review() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_close_review(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled = true, priority=-1)
	public void TC13_To_Verify_The_Exit_Review() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_exit_review(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC14_To_Verify_From_Review_User_Should_be_Able_To_Redirect_The_Test_Summary_and_Redo_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_from_review_user_should_be_able_to_redirect_the_Test_Summary_and_redo_test(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true, priority=-1)
	public void TC15_To_verify_for_the_Abondon_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_for_the_Abondon_Test(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC16_To_verify_the_message_After_abandon_the_test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_the_message_After_abandon_the_test(prop.getProperty("subject"),prop.getProperty("topic"));
	}


	@Test(enabled = true)
	public void TC17_To_verify_after_submitting_the_test_user_should_be_able_to_Check_Answers() throws MalformedURLException, InterruptedException {
		Module_Assignment_Digital_Test  mas=new Module_Assignment_Digital_Test();
		mas.to_verify_after_submitting_the_test_user_should_be_able_to_Check_Answers(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}
