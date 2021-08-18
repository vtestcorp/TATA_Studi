package studi.co.testScripts;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Oral_Test;

public class Assignment_Oral_Test  extends BaseClass {
	public  Assignment_Oral_Test() {
		super();
	}

	@Test(enabled = true)
	public void TC07_To_Verify_that_from_syllabus_menu_user_should_be_able_to_Navigate_Oral_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_from_syllabus_menu_user_should_be_able_to_navigate_oral_test();
	}

	@Test(enabled = true)
	public void TC08_To_Verify_After_Clicking_On_Oral_Test_User_Should_be_able_to_View_Oral_Test_Option() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_after_clicking_on_oral_test_user_should_be_able_to_view_oral_test_option();
	}
	@Test(enabled = true)
	public void TC09_To_Verify_that_User_Should_be_able_to_Add_the_Content_Even_if_Striked_off_for_Creating_Oral_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_user_should_be_able_to_add_the_Content_even_if_striked_off_for_creating_oral_test(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled = true)
	public void TC10_To_Verify_That_User_is_Able_to_Select_the_Chapters_from_Subject() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_user_is_able_to_select_the_chapters_from_subject(prop.getProperty("subject"),prop.getProperty("topic1"));
	}
	@Test(enabled = true)
	public void TC11_To_Verify_That_User_is_Able_to_Select_the_Topics_from_Subject() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_user_is_able_to_select_the_topics_from_subject(prop.getProperty("subject"),prop.getProperty("topic_1"),prop.getProperty("topic_2"));
	}

	@Test(enabled = true)
	public void TC12_To_verify_for_select_Deselect_of_chapters_and_Topics() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_for_select_Deselect_of_chapters_and_Topics(prop.getProperty("subject_ps"),prop.getProperty("topic_unity"));
	}
	
	@Test(enabled = true)
	public void TC17_To_Verify_that_user_should_be_able_to_move_from_current_step_to_next_step() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_user_should_be_able_to_move_from_current_step_to_next_step(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC18_To_Verify_that_user_should_be_able_to_move_from_current_step_to_previous_step() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_user_is_able_to_move_from_current_step_to_previous_step(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC19_To_Verify_that_on_all_steps_user_able_to_delete_it_the_all_oral_creation_process() throws MalformedURLException, InterruptedException {;
	Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
	maot.to_verify_that__on_all_steps_user_able_to_delete_it_the_all_oral_creation_process(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC20_To_Verify_that_after_click_on_delete_two_option_should_get_display() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_after_click_on_delete_two_option_should_get_display(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC21_To_Verify_that_With_YesPleaseDiscard_button() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_YesPleaseDiscard_button(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC22_To_Verify_With_TakeMeBack_Button() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_TakeMeBack_Button(prop.getProperty("subject"),prop.getProperty("topic_1"));
	} 
	@Test(enabled = true)
	public void TC23_To_Verify_on_step_3_Enter_Test_Settings_Screen_Should_Get_Display() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_enter_test_settings_screen_should_get_display(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC24_To_Verify_That_While_Entering_Test_Setting_Details_User_Able_To_ON_Help_Toggle() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_while_entering_test_setting_details_User_able_to_ON_Help_toggle(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)
	public void TC25_To_Verify_That_While_Entering_Test_Setting_Details_User_Able_To_OFF_Help_Toggle() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_while_entering_test_setting_details_User_able_to_OFF_Help_toggle(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC26_To_Verify_Default_Title_of_the_Oral_Test() throws MalformedURLException, InterruptedException {

		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify__default_title_of_the_oral_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled =true)
	public void TC28_To_Verify_Edit_Title_of_the_Oral_test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify__edit_title_of_the_oral_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC29_To_Verify_input_limitation_and_input_validation_for_the_title() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_input_limitation_and_input_validation_for_the_title(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC30_To_Verify_Set_Level_Of_Difficulty_For_The_Test() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_Set_level_of_difficulty_for_the_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC31_To_Verify_To_Set_Duration_For_The_Test() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_to_set_duration_for_the_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC32_To_Verify_the_navigation_from_Start_Test_Now() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_navigation_from_Start_Test_Now(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)

	public void TC33_To_Verify_the_Start_Test_UI() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_Start_Test_UI(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)
	public void TC34_To_Verify_When_click_on_start_test_button_before_starting_test_user_should_be_Able_to_view_Videos() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_When_click_on_start_test_button_before_starting_test_user_should_be_Able_to_view_Videos(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)
	public void TC35_To_verify_Begin_test() throws MalformedURLException{
		
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_begin_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)//f
	public void TC36_To_verify_the_question_with_Answer_appears_in_Green_Color() throws MalformedURLException{
		
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_question_with__Answer_appears(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	
	@Test(enabled = true)
	public void TC38_To_verify_the_Default_Correct_Answer_of_question_is_display() throws MalformedURLException, InterruptedException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_Default_Correct_Answer_of_question_is_display(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = true)
	public void TC39_To_verify_user_should_be_able_to_hide_answers() throws MalformedURLException{
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_user_should_be_able_to_hide_answers(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = true)
	public void TC40_To_verify_after_hiding_Answer_user_should_be_able_to_view_Answer_Again() throws MalformedURLException, InterruptedException{

		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_after_hiding_Answer_user_should_be_able_to_view_Answer_Again(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = true)
	public void TC41_To_verify_the_Answer_with_Did_you_get_it_right() throws MalformedURLException, InterruptedException{ 

		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_Answer_with_Did_you_get_it_righ(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
		
	@Test(enabled = true)
	public void TC45_To_verify_user_should_be_able_to_end_test_without_checking_the_Answer() throws MalformedURLException, InterruptedException{ 

		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_user_should_be_able_to_end_test_without_checking_the_Answer(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)
	public void TC46_To_verify_that_submit_Test_successfully() throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_that_submit_test_successfully(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled =true)
	public void TC47_To_verify_after_submit_oral_test_there_should_not_be_any_scoring_critria() throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_after_submi_oral_test_there_should_not_be_any_scoring_critria(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}


	@Test(enabled = true)
	public void TC51_Verify_the_actions_on_last_question_of_the_Oral_test() throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_actions_on_last_question_of_the_Oral_test(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}
	@Test(enabled = true)
	public void TC52_To_verify_Reurn_to_test_functionality_after_submission_of_test() throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_Reurn_to_test_functionality_after_submission_of_test(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = true)
	public void TC53_To_check_for_the_confirmation_Message_for_redo_test_after_submiting_test () throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_check_for_the_confirmation_Message_for_redo_test_after_submiting_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC54_To_verify_the_functionality_of_redo_test() throws MalformedURLException, InterruptedException{ 
		Module_Assignment_Oral_Test  maot=new Module_Assignment_Oral_Test();
		maot.to_verify_the_functionality_of_redo_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
