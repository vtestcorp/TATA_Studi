package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Task;

public class Module_Assignment_Task extends BaseClass {
	Object_Assignment_Task oas = new Object_Assignment_Task();
	SoftAssert assert1=new SoftAssert();
	Boolean status;


	public void creation_of_task()
	{
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		test.log(Status.INFO, "Setting Task  Title" );
		System.out.println("Setting Task  Title");
		oas.taskTitle.sendKeys("Task Test");
		test.log(Status.INFO, "Setting Task Instruction " );
		System.out.println("Setting Task Instruction");
		oas.taskInstruction.sendKeys("TATA Studi Test for Task and Digital Test");
		scrollTo2("Assign");
		clickOnElement(oas.assignmentViewed);
		test.log(Status.INFO, "Clicked on Assignment Viewd" );
		System.out.println("Clicked on Assignment Viewd");

		clickOnElement(oas.taskDuration);
		test.log(Status.INFO, "Selected the Task Duration");
		System.out.println("Selected the Task Duration");

		scrollToEnd();		
		clickOnElement(oas.assignTask);
		test.log(Status.INFO,"Task created successfully");
		System.out.println("Task created successfully");

	}
	public void to_verify_successful_creation_of_task() {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		test.log(Status.INFO, "Setting Task  Title" );
		System.out.println("Setting Task  Title");
		oas.taskTitle.sendKeys("Task Test");
		test.log(Status.INFO, "Setting Task Instruction " );
		System.out.println("Setting Task Instruction");
		oas.taskInstruction.sendKeys("TATA Studi Test for Task and Digital Test");
		scrollTo2("Assign");
		clickOnElement(oas.assignmentViewed);
		test.log(Status.INFO, "Clicked on Assignment Viewd" );
		System.out.println("Clicked on Assignment Viewd");

		clickOnElement(oas.taskDuration);
		test.log(Status.INFO, "Selected the Task Duration");
		System.out.println("Selected the Task Duration");

		scrollToEnd();		
		clickOnElement(oas.assignTask);
		status = oas.createdTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Task is created");
			test.log(Status.INFO, "Task is created");
		}

		assert1.assertAll();

	}



	public void to_verify_creation_of_task_and_visible_under_due_today(){
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		test.log(Status.INFO, "Setting Task  Title" );
		System.out.println("Setting Task  Title");
		oas.taskTitle.sendKeys("Task Test");
		test.log(Status.INFO, "Setting Task Instruction " );
		System.out.println("Setting Task Instruction");
		oas.taskInstruction.sendKeys("TATA Studi Test for Task and Digital Test");
		scrollTo2("Assign");
		clickOnElement(oas.assignmentViewed);
		test.log(Status.INFO, "Clicked on Assignment Viewd" );
		System.out.println("Clicked on Assignment Viewd");

		clickOnElement(oas.taskDuration);
		test.log(Status.INFO, "Selected the Task Duration");
		System.out.println("Selected the Task Duration");

		scrollToEnd();		
		clickOnElement(oas.assignTask);

		status = oas.today.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Today is displayed");
			test.log(Status.INFO,"Today is displayed");
		}

		status = oas.createdTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Task is created and visible under due Today");
			test.log(Status.INFO, "Task is created and visible under due Today");
		}

		assert1.assertAll();
	}


	public void to_verify_clicking_on_tasks_task_details_are_displayed() {
		//creation_of_task();
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);

		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");

		oas.createdTask.click();

		System.out.println("Clicked on created Task");
		test.log(Status.INFO,"Clicked on created Task");
		status = oas.assignmentDetails.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignment Details are displayed after clicking on Task");
			test.log(Status.INFO, "Assignment Details are displayed after clicking on Task");
		}

		assert1.assertAll();
	}

	public void to_verify_closing_task_details()
	{
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);

		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");

		oas.createdTask.click();

		System.out.println("Clicked on created Task");
		test.log(Status.INFO,"Clicked on created Task");
		status = oas.assignmentDetails.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignment Details are displayed after clicking on Task");
			test.log(Status.INFO, "Assignment Details are displayed after clicking on Task");
		}

		oas.closeTaskDetails.click();
		System.out.println("Clicked on close Task");
		test.log(Status.INFO,"Clicked on close Task");

		status = oas.today.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("My Assignments page is displayed after closing Assignment Details");
			test.log(Status.INFO, "My Assignments page is displayed after closing Assignment Details");
		}
		assert1.assertAll();
	}

	public void to_verify_marking_task_as_completed()
	{
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);

		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");

		oas.createdTask.click();

		System.out.println("Clicked on created Task");
		test.log(Status.INFO,"Clicked on created Task");
		status = oas.assignmentDetails.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignment Details are displayed after clicking on Task");
			test.log(Status.INFO, "Assignment Details are displayed after clicking on Task");
		}
		oas.markAsCompleted.click();

		System.out.println("Clicked on Mark as Completed");
		test.log(Status.INFO,"Clicked on Mark as Completed");

		//check task is striked through or not..now on Hold
	}

	public void to_verify_the_help_toggle_button_ON_functionality_at_time_of_task_creation() {
		//com.tce.studi:id/helpSwitch- help switch OFF
		//com.tce.studi:id/helpSwitch -help Switch ON
		//Need different values/attribute to validate

	}

	public void to_verify_the_help_toggle_button_OFF_functionality_at_time_of_task_creation() {
		//com.tce.studi:id/helpSwitch- help switch OFF
		//com.tce.studi:id/helpSwitch -help Switch ON
		//Need different values/attribute to validate

	}

	public void to_verify_delete_btn_functinality_at_the_time_of_task_creation() {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		status = oas.deleteTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Delete Button is displayed on Assignment Details");
			test.log(Status.INFO, "Delete Button is displayed on Assignment Details");
		}
		oas.deleteTask.click();
		System.out.println("Clicked -Delete Button on Assignment Details");
		test.log(Status.INFO, "Clicked -Delete Button on Assignment Details");

		status = oas.deletePopup.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Pop up is shown with message : Are you sure you want to discard?");
			test.log(Status.INFO,"Pop up is shown with message :  Are you sure you want to discard?");

		}
		assert1.assertAll();
	}


	public void to_verify_delete_btn_functinality_with_discard_at_task_creation() {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		status = oas.deleteTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Delete Button is displayed on Assignment Details");
			test.log(Status.INFO, "Delete Button is displayed on Assignment Details");
		}
		oas.deleteTask.click();
		System.out.println("Clicked -Delete Button on Assignment Details");
		test.log(Status.INFO, "Clicked -Delete Button on Assignment Details");

		status = oas.deletePopup.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Pop up is shown with message : Are you sure you want to discard?");
			test.log(Status.INFO,"Pop up is shown with message :  Are you sure you want to discard?");

		}

		status = oas.discardBtn.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Yes ,Please discard button is diplayed");
			test.log(Status.INFO,"Yes ,Please discard button is diplayed");
			clickOnElement(oas.discardBtn);
			System.out.println("The task is deleted using Delete button");
			test.log(Status.INFO,"The task is deleted using Delete button");
		}
		assert1.assertAll();
	}



	public void to_verify_delete_btn_functinality_with_take_back_btn_at_task_creation() {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);
		status = oas.deleteTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Delete Button is displayed on Assignment Details");
			test.log(Status.INFO, "Delete Button is displayed on Assignment Details");
		}
		oas.deleteTask.click();
		System.out.println("Clicked -Delete Button on Assignment Details");
		test.log(Status.INFO, "Clicked -Delete Button on Assignment Details");

		status = oas.deletePopup.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Pop up is shown with message : Are you sure you want to discard?");
			test.log(Status.INFO,"Pop up is shown with message :  Are you sure you want to discard?");
		}

		clickOnElement(oas.takeBack);
		System.out.println("Clicked - Take me Back Button");
		test.log(Status.INFO, "Clicked - Take me Back Button");
		status = oas.enterTaskDetails.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("User came back using Take me Back buttton");
			test.log(Status.INFO,"User came back using Take me Back buttton");
		}
		assert1.assertAll();
	}
	public void to_verify_creation_of_task_without_mandatory_fields() {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(oas.add_assignment);
		clickOnElement(oas.task);

		status = oas.enterTaskDetails.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assign task page is displayed");
			test.log(Status.INFO,"Assign task page is displayed");
		}
		oas.taskInstruction.sendKeys("Test: Creation of Task without mandatory fields");
		scrollTo2("Due Date");
		clickOnElement(oas.assignTask);
		scrollTo2("Title");
		//Title with and without error message has same attribute ,can't validate

	}

	public void to_verify_Back_to_Todays_Assignments_takes_user_back_to_My_Assignments_screen() throws MalformedURLException, InterruptedException {
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		scrollTo2("View");

		clickOnElement(oas.completed);
		test.log(Status.INFO, "Clicked Completed Assignments" );
		System.out.println("Clicked on Completed Assignments");
		applyExplicitWait(2000);
		//applyExplicitWaitsUntilElementVisible(oas.back_btn);
		swipeDown();
		oas.back_btn.click();
		test.log(Status.INFO, "Clicked on back to My Assignments" );
		System.out.println("Clicked on back to My Assignments");
		status = oas.myAssignments.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Back to Today's Assignments - takes user back to My Assignments screen");
			test.log(Status.INFO, "Back to Today's Assignments - takes user back to My Assignments screen");
		}

}





}
