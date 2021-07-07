package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Task;

public class Assignment_Task extends BaseClass{

	//Total=12
	//TC 5,TC 6,TC 7,TC 11 =Pending. Functions not yet implimented
	//  Pass=8, Fail=0

	public  Assignment_Task() {
		super();
	}

	@Test(enabled = false)//pass
	public void TC01_To_Verify_Successful_Creation_of_Task() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_successful_creation_of_task();
	}

	@Test(enabled = false)//pass
	public void TC02_To_Verify_Creation_of_Task_and_Visible_Under_Due_Today() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_creation_of_task_and_visible_under_due_today();
	}

	@Test(enabled = false)//pass
	public void TC03_To_Verify_Clicking_on_Tasks_Task_Details_are_Displayed() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_clicking_on_tasks_task_details_are_displayed();
	}


	@Test(enabled = false)//pass
	public void TC04_To_Verify_Closing_Task_Details() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_closing_task_details();
	}

	@Test(enabled = false)//pending
	public void TC05_To_Verify_Marking_Task_as_Completed() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_marking_task_as_completed();
	}
	@Test(enabled = false)//pending
	public void TC06_To_verify_the_Help_Toggle_Button_ON_Functionality_At_Time_of_Task_Creation() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_the_help_toggle_button_ON_functionality_at_time_of_task_creation();
	}
	@Test(enabled = false)//pending
	public void TC07_To_verify_the_Help_Toggle_Button_OFF_Functionality_At_Time_of_Task_Creation() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_the_help_toggle_button_OFF_functionality_at_time_of_task_creation();
	}

	@Test(enabled = false)//pass
	public void TC08_To_verify_Delete_Btn_Functinality_at_the_time_of_task_creation() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_delete_btn_functinality_at_the_time_of_task_creation();
	}
	@Test(enabled = false)//pass
	public void TC09_To_verify_Delete_Btn_Functinality_at_the_time_of_task_creaetion() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_delete_btn_functinality_with_discard_at_task_creation();
	}
	@Test(enabled = false)//pass
	public void TC10_To_verify_Delete_Btn_Functinality_at_the_time_of_task_creation() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_delete_btn_functinality_with_take_back_btn_at_task_creation();
	}
	@Test(enabled = false)//pending due to validation
	public void TC11_To_verify_Creation_of_Task_Without_Mandatory_Fields() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_creation_of_task_without_mandatory_fields();
		//Title contains same value after blank title  with error
	}
	@Test(enabled = false)//pass
	public void TC12_To_verify_Back_to_Todays_Assignments_takes_user_back_to_My_Assignments_screen() throws MalformedURLException, InterruptedException {
		Module_Assignment_Task  mas=new Module_Assignment_Task();
		mas.to_verify_Back_to_Todays_Assignments_takes_user_back_to_My_Assignments_screen();


	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}

