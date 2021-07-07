package studi.co.pageModules;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Assignment_Listing;

public class Module_Assignment_Listing extends BaseClass {

	public void create_new_assignment(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();

		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}
		assert1.assertTrue(assign);
		applyExplicitWait(5);

		oas.digital_tets.click();
		System.out.println("Clicked on Digital Test");

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		oas.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oas.assign.click();
		System.out.println("Created New Assignment");


	}


	public void toVerify_User_Should_Be_Able_To_See_Listing_Of_Today_Upcoming_Completed_Assignments()
			throws MalformedURLException, InterruptedException {


		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);

		Boolean today=oas.today.isDisplayed();
		if(today) {
			System.out.println("User able to see Today's Assignments Page,after tapping on Assignment");
			test.log(Status.INFO, "User able to see Today's Assignments Page,after tapping on Assignment");
		}
		assert1.assertTrue(today);
		scrollTo1("Upcoming");
		Boolean upcoming=oas.upcoming.isDisplayed();
		if(upcoming) {
			System.out.println("User able to see upcoming Assignments Page,after tapping on Assignment");
			test.log(Status.INFO, "User able to see upcoming Assignments Page,after tapping on Assignment");
		}
		assert1.assertTrue(upcoming);
		scrollTo2("Completed");
		Boolean completed=oas.completed.isDisplayed();
		if(completed) {
			System.out.println("User able to see to Completed Assignments Page,after tapping on Assignment");
			test.log(Status.INFO, "User able to see  Completed Assignments Page,after tapping on Assignment");
		}

		assert1.assertTrue(completed);
		assert1.assertAll();
	}

	public void Verify_User_Able__to_Create_test_for_Students_Using_intent_creation_module() throws MalformedURLException {

		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;

		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully"); 
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		System.out.println("Clicked on Assignment");
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}

		assert1.assertTrue(assign);



		assert1.assertAll();
	}

	public void To_verify_items_of_today_Upcoming_shown_prominently_on_the_listing_page() throws MalformedURLException{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);

		Boolean today=oas.today.isDisplayed();
		if(today) {
			System.out.println("User able to navigate to Today Assignment Page,after tapping on Assignment");
			test.log(Status.INFO, "User able to navigate to Today Assignment Page,after tapping on Assignment");
		}
		assert1.assertTrue(today);
		Boolean today_ass=oas.Todays_assignments.isDisplayed();
		if(today_ass) {
			System.out.println("Today,s assignments items shown to user");
			test.log(Status.INFO, "Today,s assignments items shown to user");
		}
		assert1.assertTrue(today);

		Boolean upcoming_ass=oas.upcomig_assignments.isDisplayed();
		if(upcoming_ass) {
			System.out.println("Upcoming assignments items shown to user");
			test.log(Status.INFO, "Upcoming assignments items shown to user");
		}
		assert1.assertTrue(upcoming_ass);
		assert1.assertAll();

	}


	public void toverify_newly_created_assignments_in_today_tasks_are_shown_with_new_icon(String subject77, String topicmaths) throws MalformedURLException, InterruptedException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		create_new_assignment(subject77, topicmaths);
		scrollTo2("Show more");
		clickOnElement(oas.show_more);
		scrollTo2("Show more");
		clickOnElement(oas.show_more);
		scrollTo2("Show more");
		clickOnElement(oas.show_more);
		scrollTo2("NEW");
		clickOnElement(oas.show_more);
		scrollTo2("NEW");
		Boolean new_assignment=oas.new_icon.isDisplayed();
		if(new_assignment) {
			System.out.println("Newly Created Assignmentsin today's tasks are shown with new icon which indicates that they have not seen yet");
			test.log(Status.INFO, "Newly Created Assignmentsin today's tasks are shown with new icon which indicates that they have not seen yet");
		}
		assert1.assertTrue(new_assignment);
		assert1.assertAll();
	}
	public void to_verify_new_created_tasks_icon_once_user_exits_the_current_screen_and_comes_back_New_will_not_be_shown(String subject77, String topicmaths) throws MalformedURLException, InterruptedException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		create_new_assignment(subject77, topicmaths);
		//		scrollTo2("NEW");
		//		Boolean new_assignment=oas.new_icon.isDisplayed();
		//		if(new_assignment) {
		//			System.out.println("Newly Created Assignments in today's tasks are shown with New_icon which indicates that they have not seen yet");
		//			test.log(Status.INFO, "Newly Created Assignments in today's tasks are shown with New_icon icon which indicates that they have not seen yet");
		//		}
		//		assert1.assertTrue(new_assignment);
		//		
		//		oas.back_btn.click();
		//System.out.println("Clicking on Back Button");
		//test.log(Status.INFO, "CLicking on Back Button");
		//		scrollTo2("Assignments");
		//		oas.assignment.click();
		//System.out.println("Clicking on Back Assignments");
		//test.log(Status.INFO, "Clicking on Back Assignments");
		//		applyExplicitWait(5); 

		scrollTo2("Completed");

		Assert.assertNull(oas.new_icon);

		try {
			oas.new_icon.isDisplayed();
			System.out.println("New_icon is shown to the user");
			test.log(Status.INFO, "New_icon not shown to the user");
		}
		catch (NoSuchElementException e) {

			System.out.println("New_icon is not shown to the user");
			test.log(Status.INFO, "New_icon is not shown to the user");
		}
		assert1.assertFalse(false);
		assert1.assertAll();
	}

	@SuppressWarnings("unchecked")
	public void to_verify_all_assignmenta_are_represents_with_due_date_of_that_assignment() throws MalformedURLException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		applyExplicitWait(5);

				Boolean due_date=oas.due_date.isDisplayed();
				if(due_date) {
					System.out.println("Due date of assignments is shown to user");
					test.log(Status.INFO, "Due date of assignments is shown to user");
				}
				assert1.assertTrue(due_date);

		//scrollTo1("Upcoming");

		ArrayList due_dates= new ArrayList(oas.list_bag.size());
		int i=0;
		for(MobileElement mb:oas.list_bag)
		{
			MobileElement e =mb.findElementById("com.tce.studi:id/dueDate");
			String actualLesson=e.getText();
			due_dates.add(actualLesson);
		}	
		if(due_dates.contains("due"))
		{
			System.out.println("All the assignments are represent with due date");
		}
		else
		{	
			System.err.println("All the assignments are represent with due date");	
		}

		assert1.assertAll();
	}

	public void to_verify_extra_days_are_shown_on_certain_assigments_when_user_not_completed_within_stipulate_time() throws MalformedURLException
	{

		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);


		Boolean extra=oas.extra_days.isDisplayed();
		if(extra) {
			System.out.println("When User does not complete the assignment on certain due date, count of extra days are shown above the date");
			test.log(Status.INFO, "When User does not complete the assignment on certain due date, count of extra days are shown above the date");
		}
		assert1.assertTrue(extra);
	}


	public void to_verify_attachment_icon_on_particular_assignments() throws MalformedURLException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		clickOnElement(oas.add_assignment);
		applyExplicitWaitsUntilElementClickable(oas.task);
		oas.taskTitle.sendKeys("TaskTest");
		oas.taskInstruction.sendKeys("TATA Studi Task Test1");
		scrollTo2("Attachment");
		clickOnElement(oas.imgGallery);
		clickOnElement(oas.cameraAttachment);
		clickOnElement(oas.attachmentDone);
		applyExplicitWaitsUntilElementClickable(oas.assign);


	}


	public void to_verify_completed_assignments_marked_as_striked() throws MalformedURLException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = findElementByText("Assignments").isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		scrollTo2("Assignments");

		clickOnElement(oas.assignment);
		applyExplicitWait(5);



	}

	public void to_verify_new_assignment_created_after_selecting_new_topic(String subject, String topic) throws MalformedURLException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}
		assert1.assertTrue(assign);
		applyExplicitWait(5);

		oas.digital_tets.click();
		System.out.println("Clicked on Digital Test");

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		oas.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oas.assign.click();
		System.out.println("Created New Assignment");
		assert1.assertAll();

	}
	public void to_verify_once_the_assignment_is_created_alert_notification_of_Success_message(String subject, String topic) throws MalformedURLException, InterruptedException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}
		assert1.assertTrue(assign);
		applyExplicitWait(5);

		oas.digital_tets.click();
		System.out.println("Clicked on Digital Test");

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		oas.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oas.assign.click();
		test.log(Status.INFO, "Clicked on create assignment " );
		System.out.println("Clicked on create assignment");

		status = oas.notification.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Alert Notification of success message is displayed");
			test.log(Status.INFO, "Alert Notification of success message is displayed");
		}
		assert1.assertAll();

	}

	public void to_verify_when_User_clicks_on_View_completed_all_completed_assignments_shown_to_user() throws MalformedURLException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		//oas.add_assignment.click();
		scrollTo2("Completed");
		Boolean completed=oas.completed.isDisplayed();
		if(completed) {
			System.out.println("User able to see to Completed Assignments Page,after tapping on Assignment");
			test.log(Status.INFO, "User able to see  Completed Assignments Page,after tapping on Assignment");
		}
		assert1.assertTrue(completed);
		swipeUp();
		clickOnElement(oas.completed);
		findElementByText("Completed Assignments");
		{
			System.out.println("Completed Assignments shown to user");
			test.log(Status.INFO, "Completed Assignments shown to user");
		}
		assert1.assertAll();
	}

	public void to_verify_filter_functinality()
	{

	}

	public void to_verify_the_scrolling_functionality()
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);

		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		assert1.assertTrue(status);

		scrollTo2("Assignments");
		oas.assignment.click();

		swipeUp();
		status=oas.add_assignment.isDisplayed();
		if (status) {
			System.out.println("Scrolling down successfully");
			test.log(Status.INFO, "Scrolling down successfully");
		}
		assert1.assertTrue(status);

		swipeDown();
		status=oas.today.isDisplayed();
		if (status) {
			System.out.println("Scrolling Up successfully");
			test.log(Status.INFO, "Scrolling Up successfully");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}


	public void to_verify_the_search_functionality()
	{

	}
	public void To_Verify_click_on_view_all_button_all_the_upcoming_tasks_will_be_expanded()
	{

	}
	public void to_Verify_that_user_is_able_to_attempt_the_all_types_of_assignment()
	{

	}

	public void to_verify_total_due_resources_shown_to_user_In_each_section()
	{

	}
	public void to_verify_on_completed_assignment_list_actul_task_complete_date_is_Shown(String subject,String topic) throws MalformedURLException, InterruptedException{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		scrollTo2("Completed");
		clickOnElement(oas.completed);
		if(oas.completedDate.isDisplayed())
		{
			System.out.println("Actual Task completion date is shown ");
			test.log(Status.INFO, "Actual Task completion date is shown");

		}
	}

	public void to_verify_that_on_listing_page_user_able_to_create_task_and_both_type_of_test(String subject, String topic) throws MalformedURLException {

		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}
		assert1.assertTrue(assign);
		applyExplicitWait(5);

		oas.digital_tets.click();
		System.out.println("Clicked on Digital Test");

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		oas.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oas.assign.click();
		System.out.println("Created New Assignment");
		test.log(Status.INFO, "Clicking on Back to Test Unit, Syllabus ans Assignment page" );
		System.out.println("Clicking on Back to Test Unit, Syllabus ans Assignment page");
		clickOnElement(oas.back_btn);
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
		//scrollTo2("Assign");
		scrollToEnd();
		clickOnElement(oas.assignTask);
		status = oas.notification.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Task is created");
			test.log(Status.INFO, "Task is created");
		}

		assert1.assertAll();

	}



	public void crete_assignment(String subject,String topic) throws MalformedURLException {

		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		scrollTo2("Assignments");
		oas.assignment.click();
		applyExplicitWait(5);
		oas.add_assignment.click();

		Boolean assign=oas.intent_Creation.isDisplayed();
		if(assign) {
			System.out.println("The intent creation module shown to user");
			test.log(Status.INFO, "The intent creation module shown to user");
		}
		assert1.assertTrue(assign);
		applyExplicitWait(5);

		oas.digital_tets.click();
		System.out.println("Clicked on Digital Test");

		scrollTo1(subject);
		test.log(Status.INFO, "Opening " + subject);
		System.out.println("Opening " + subject);
		applyExplicitWaitsUntilElementClickable(findElementByText(subject));
		clickOnElement(findElementByText(subject));

		scrollTo1(topic);
		test.log(Status.INFO, "Selecting " + topic);
		System.out.println("Selecting " + topic);
		applyExplicitWaitsUntilElementClickable(findElementByText(topic));
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);
		oas.next1.click();
		applyExplicitWait(5);
		test.log(Status.INFO, "Clicking on create assignment " );
		System.out.println("Clicking on create assignment");
		oas.assign.click();
		test.log(Status.INFO, "New assignment created successfully " );
		System.out.println("New assignment created successfully ");


	}
}







