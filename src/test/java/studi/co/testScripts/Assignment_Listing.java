package studi.co.testScripts;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Listing;
import studi.co.pageModules.Module_Login;

public class Assignment_Listing extends BaseClass {

	public Assignment_Listing() {
		super();

	}
	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled= true)//passed
	public void TC01_Verify_User_Should_Be_Able_To_See_Listing_Of_Today_Upcoming_Completed_Assignments()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.toVerify_User_Should_Be_Able_To_See_Listing_Of_Today_Upcoming_Completed_Assignments();
	}

	@Test(enabled= true)//passed
	public void TC02_Verify_intent_creation_module_using_that_User_can_create_test_for_Students()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.Verify_User_Able__to_Create_test_for_Students_Using_intent_creation_module();

	}
	@Test(enabled =true)//passed
	public void TC03_To_verify_items_of_today_Upcoming_shown_prominently_on_the_listing_page()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.toVerify_User_Should_Be_Able_To_See_Listing_Of_Today_Upcoming_Completed_Assignments();

	}
	@Test(enabled= true,priority=-3)//passed
	public void TC04_To_verify_Newly_Created_Assignments_In_Todays_Task_Are_Shown_With_New_Icon()
			throws MalformedURLException, InterruptedException {

		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.toverify_newly_created_assignments_in_today_tasks_are_shown_with_new_icon(prop.getProperty("subject77"),prop.getProperty("topicmaths"));
	}

	@Test(enabled= false)//isdisplayed need help to update
	public void TC05_To_Verify_New_Created_Tasks_Icon_Once_User_Exits_The_Current_Screen_And_Comes_Back_New_will_not_be_shown()throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_new_created_tasks_icon_once_user_exits_the_current_screen_and_comes_back_New_will_not_be_shown(prop.getProperty("subject77"),prop.getProperty("topicmaths"));
	}
	@Test(enabled= true)//update
	public void TC06_To_Verify_All_Assignments_are_Represents_With_Due_Date_of_That_Assignment()throws MalformedURLException, InterruptedException {

		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_all_assignmenta_are_represents_with_due_date_of_that_assignment();
	}

	@Test(enabled = true)//passed
	public void TC07_To_Verify_If_User_Does_Not_Complete_The_Assignment_On_Certain_Due_Date_Count_Of_Extra_Days_Will_Be_Shown_Above_The_Date()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_extra_days_are_shown_on_certain_assigments_when_user_not_completed_within_stipulate_time();
	}
	@Test(enabled =true) //pass
	public void TC08_attachment_icon_will_be_shown_in_case_there_any_attachment_assignment()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_attachment_icon_on_particular_assignments();
	}
	@Test(enabled = false)//Can't validate using attribute or value..need diff values 
	public void TC09_Assignment_wil_be_strikedThrough_if_user_completed_the_assignment_either_by_Mark_as_complete_or_actual_completion()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_completed_assignments_marked_as_striked();
	}

	@Test(enabled = true)//passed
	public void TC11_after_selecting_topic_new_assignment_is_created_with_label_new()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_new_assignment_created_after_selecting_new_topic(prop.getProperty("subject"),prop.getProperty("topic"));
	}
	@Test(enabled = true)//passed
	public void TC12_Once_the_Assignment_is_created__Alert_Notification_of_Success_message_should_be_Displayed()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_once_the_assignment_is_created_alert_notification_of_Success_message(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled= true)//passed
	public void TC14_To_Verify_when_User_clicks_on_View_completed_link_all_completed_assignments_shown_to_user()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_when_User_clicks_on_View_completed_all_completed_assignments_shown_to_user();
	}

	@Test(enabled = false)//future
	public void TC15_To_Verify_Filter_option_is_availabe_on_listing_page_and_it_Works()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_filter_functinality();
	}

	@Test(enabled= true)//pass
	public void TC16_To_Verify_the_scrolling_functionality()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_the_scrolling_functionality();
	}
	@Test(enabled = false)//future
	public void TC17_To_Verify_the_search_functionality()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_the_search_functionality();
	}

	@Test(enabled = true)//pass -TC22 -21 are same 
	public void TC21_To_Verify_Total_Due_Resources_shown_to_user_In_each_section()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_total_due_resources_shown_to_user_In_each_section();
	}


	@Test(enabled= true)//pass
	public void TC23_To_Verify_On_Completed_Assignment_List_actul_Task_Complete_Date_is_Shown()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_on_completed_assignment_list_actul_task_complete_date_is_Shown(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled= true)//pass
	public void TC24_To_Verify_that_On_Listing_Page_User_able_to_Create_Task_And_Both_Type_of_Test()
			throws MalformedURLException, InterruptedException {
		Module_Assignment_Listing as = new Module_Assignment_Listing();
		as.to_verify_that_on_listing_page_user_able_to_create_task_and_both_type_of_test(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}



