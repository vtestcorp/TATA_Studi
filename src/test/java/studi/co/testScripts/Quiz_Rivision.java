package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Quiz_Revision;

public class Quiz_Rivision extends BaseClass{
	static int flag = 0;

	public Quiz_Rivision() {
		super();


	}

	@Test(enabled= true)//select topic.. contains Sorting question
	public void TC01_To_Verify_User_Attempt_sorting_question_in_revision_module() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_user_attempt_sorting_question_in_revision_module(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled= true)//need sorting ques topic
	public void TC_02_To_verify_user_is_able_to_drag_drop_all_options_in_place_holder_to_answer_the_sorting_question() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_verify_user_is_able_to_drag_drop_all_options_in_place_holder_to_answer_the_sorting_question(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled= true,priority=-3)//done
	public void TC03_To_verify_not_mandatory_in_Revise_module_to_attempt_each_question () throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_not_mandatory_in_Revise_module_to_attempt_each_question(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled= true)
	public void TC04_To_verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled= true,priority=-2)//done
	public void TC05_To_verify_If_user_chooses_1option_right_another_wrong_the_answers_considered_partially_correct_in_sorting_question() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_If_user_chooses_1option_right_another_wrong_the_answers_considered_partially_correct_in_sorting_question(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled= true,priority=-1)//done
	public void TC06_To_verify_Feedback_provided_at_the_click_of_options_itself() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_user_Feedback_provided_at_the_click_of_options_itself(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}


}

