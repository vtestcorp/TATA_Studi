package studi.co.pageModules;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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
		boolean status;
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
		//		status = oas.profilePic.isDisplayed();
		//		assert1.assertTrue(status);
		//		if (status) {
		//			System.out.println("Logged in successfully");
		//			test.log(Status.INFO, "Logged in successfully");
		//		}
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
		//		status = oas.profilePic.isDisplayed();
		//		assert1.assertTrue(status);
		//		if (status) {
		//			System.out.println("Logged in successfully");
		//			test.log(Status.INFO, "Logged in successfully"); 
		//		}
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
		//		status = oas.profilePic.isDisplayed();
		//		assert1.assertTrue(status);
		//		if (status) {
		//			System.out.println("Logged in successfully");
		//			test.log(Status.INFO, "Logged in successfully");
		//		}
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
		try {
			//oas.show_more.isDisplayed();
			scrollTo2("Show more");
			Thread.sleep(500);
			clickOnElement(findElementByText("Show more"));

		}
		catch (NoSuchElementException e) {

			System.out.println("New_icon is not shown to the user");
			test.log(Status.INFO, "New_icon is not shown to the user");
		}


		Boolean new_assignment=oas.new_icon.isDisplayed();
		if(new_assignment) {
			System.out.println("Newly Created Assignmentsin today's tasks are shown with new icon which indicates that they have not seen yet");
			test.log(Status.INFO, "Newly Created Assignmentsin today's tasks are shown with new icon which indicates that they have not seen yet");
		}
		assert1.assertTrue(new_assignment);
		assert1.assertAll();
	}
	public void to_verify_new_created_tasks_icon_once_user_exits_the_current_screen_and_comes_back_New_will_not_be_shown(String subject, String topic) throws MalformedURLException, InterruptedException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		boolean status;
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);

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
		//oas.assign.click();
		scrollTo2("Assign");
		clickOnElement(findElementByText("Assign"));
		System.out.println("Created New Assignment");
		status=oas.notification.isDisplayed();
		{
			test.log(Status.INFO, "Notification after creation of new assignment is shown" );
			System.out.println("Notification after creation of new assignment is shown");
		}

		//Thread.sleep(1000);

		try {
			status=oas.new_lbl.isDisplayed();
			{
				test.log(Status.INFO, "Newly created assignment is shown with lable NEW" );
				System.out.println("Newly created assignment is shown with lable NEW");
				clickOnElement(oas.new_lbl);

				applyExplicitWaitsUntilElementVisible(findElementByText("you will be tested"));
				test.log(Status.INFO, "Newly created assignment is Open Now" );
				System.out.println("Newly created assignment is Open Now");
				clickOnElement(oas.back_btn);
				applyExplicitWaitsUntilElementVisible(findElementByText("My Assignments"));

				status = oas.new_icon.isDisplayed();
				assert1.assertFalse(false);
				if (status) 
					System.out.println("NEW icon not shown for opened Assignment ");
				test.log(Status.INFO, "NEW icon not shown for opened Assignment ");
			}
			try {

				scrollTo2("Show");	
				clickOnElement(findElementByText("Show"));
			}

			catch(Exception ex) {


				status=oas.new_lbl.isDisplayed();
				{
					test.log(Status.INFO, "Newly created assignment is shown with lable NEW" );
					System.out.println("Newly created assignment is shown with lable NEW");
					clickOnElement(oas.new_lbl);

					applyExplicitWaitsUntilElementVisible(findElementByText("you will be tested"));
					test.log(Status.INFO, "Newly created assignment is Open Now" );
					System.out.println("Newly created assignment is Open Now");
					clickOnElement(oas.back_btn);
					applyExplicitWaitsUntilElementVisible(findElementByText("My Assignments"));

					status = oas.new_icon.isDisplayed();
					assert1.assertFalse(false);
					if (status) 
						System.out.println("NEW icon not shown for opened Assignment ");
					test.log(Status.INFO, "NEW icon not shown for opened Assignment ");
				}

			}
		}

		catch (Exception e) {


			scrollTo2("Show");	
			clickOnElement(findElementByText("Show"));

			System.out.println("New Icon not shown for Opened Assignment");
			test.log(Status.INFO, "New Icon not shown for Opened Assignment");

		}

	}


	public void to_verify_all_assignmenta_are_represents_with_due_date_of_that_assignment() throws MalformedURLException
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		int size_ass=0,size_due=0;
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

		List<MobileElement> assignments = getDriver().findElementsById("com.tce.studi:id/linearListBg");
		size_ass=assignments.size();
		System.out.println("Assignments are :-->"+ size_ass);
		for (MobileElement ass : assignments ) {
			assert1.assertTrue(ass.isDisplayed());
		}

		List<MobileElement> due_dates = getDriver().findElementsById("com.tce.studi:id/linearListBg");
		size_due =due_dates.size();
		System.out.println("Due Dates are :-->" +size_due);
		for (MobileElement due : due_dates ) {
			assert1.assertTrue(due.isDisplayed());
		}
		if( size_ass==size_due)
		{
			System.out.println("all assignments are represents with due date of that assignment");
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

		clickOnElement(oas.assignment);

		System.out.println("Clicked On Assignments that will Navigate user to My Assignments page");
		test.log(Status.INFO, "Clicked On Assignments that will Navigate user to My Assignments page");
		applyExplicitWait(5);
		try {
			Boolean extra=oas.extra_days.isDisplayed();
			if(extra) {
				System.out.println("When User does not complete the assignment on certain due date, count of extra days are shown above the date");
				test.log(Status.INFO, "When User does not complete the assignment on certain due date, count of extra days are shown above the date");
				assert1.assertTrue(extra);
			}


		} catch (Exception e) {

			System.out.println("User has completed all the assisgnments in stipulated period of time , No Extra days shown");
			test.log(Status.INFO, "User has completed all the assisgnments in stipulated period of time , No Extra days shown");

		}

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
		clickOnElement(findElementByText("Task"));
		oas.taskTitle.clear();
		oas.taskTitle.sendKeys("TaskTest");
		oas.taskInstruction.sendKeys("TATA Studi Task Test1");
		scrollTo2("Attachment");

		clickOnElement(oas.attachmentIcon);
		MobileElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("user.dir\")//img.jpg");


		//clickOnElement(oas.imgGallery);

		//caps.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"\\img2.jpg");

		status = oas.img_media_name.isDisplayed();

		if (status) {
			System.out.println("Attachment attached successfully and shown ");
			test.log(Status.INFO, "Attachment attached successfully and shown ");
		}
		assert1.assertTrue(status);
		assert1.assertAll();


	}
	public void to_verify_completed_assignments_marked_as_striked() throws MalformedURLException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();

		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		assert1.assertTrue(status);
		status = findElementByText("Assignments").isDisplayed();

		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}
		assert1.assertTrue(status);
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		applyExplicitWait(5);



	}

	public void to_verify_new_assignment_created_after_selecting_new_topic(String subject, String topic) throws MalformedURLException, InterruptedException {
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
		clickOnElement(oas.assignment);
		//oas.assignment.click();
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
		//oas.assign.click();
		scrollTo2("Assign");
		clickOnElement(findElementByText("Assign"));
		System.out.println("Created New Assignment");

		status=oas.notification.isDisplayed();
		{
			test.log(Status.INFO, "Notification after creation of new assignment is shown" );
			System.out.println("Notification after creation of new assignment is shown");
		}

		Thread.sleep(1000);

		try {
			status=oas.new_lbl.isDisplayed();
			{
				test.log(Status.INFO, "Newly created assignment is shown with lable NEW" );
				System.out.println("Newly created assignment is shown with lable NEW");
			}


		} catch (Exception e) {

		}

		assert1.assertAll();

	}
	public void to_verify_once_the_assignment_is_created_alert_notification_of_Success_message(String subject, String topic) throws MalformedURLException, InterruptedException {
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		status = oas.profilePic.isDisplayed();

		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		assert1.assertTrue(status);

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


	public void to_verify_the_scrolling_functionality()
	{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		Boolean status;
		scrollTo2("Assignments");
		oas.assignment.click();


		scrollTo2("View");
		status=oas.add_assignment.isDisplayed();
		if (status) {
			System.out.println("Scrolling down successfully");
			test.log(Status.INFO, "Scrolling down successfully");
		}
		assert1.assertTrue(status);

		//swipeDown();
		scrollTo2("Today");
		status=oas.today.isDisplayed();
		if (status) {
			System.out.println("Scrolling Up successfully");
			test.log(Status.INFO, "Scrolling Up successfully");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}



	public void to_verify_total_due_resources_shown_to_user_In_each_section() throws MalformedURLException, InterruptedException
	{

		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		scrollTo2("Assignments");
		clickOnElement(findElementByText("Assignment"));
		applyExplicitWaitsUntilElementVisible(findElementByText("Today"));
		Boolean due=oas.due_resource.isDisplayed();
		if(due) {
			System.out.println("Due resources shown in Today Tab");
			test.log(Status.INFO, "Due resources shown in Today Tab");
		}
		String due_count=oas.due_resource.getText();
		Thread.sleep(2000);
		System.out.println(due_count);
		assert1.assertTrue(due);
		assert1.assertAll();

	}
	public void to_verify_on_completed_assignment_list_actul_task_complete_date_is_Shown(String subject,String topic) throws MalformedURLException, InterruptedException{
		Object_Assignment_Listing oas=new Object_Assignment_Listing();
		SoftAssert assert1=new SoftAssert();
		boolean status;
		scrollTo2("Assignments");
		clickOnElement(oas.assignment);
		applyExplicitWait(5);
		scrollTo2("Completed");
		clickOnElement(oas.completed);
		System.out.println("Clicked on View Completed Assignments Tab to open Completed Assignments ");
		test.log(Status.INFO, "Clicked on View Completed Assignments Tab to open Completed Assignments ");
		status=oas.heading_on_completed_ass.isDisplayed();
		if(status)
		{
			System.out.println("List of COmpleted Assignments is shown to user");
			test.log(Status.INFO, "List of COmpleted Assignments is shown to user");

		}
		status=oas.completion_date.isDisplayed();
		if(status)
		{
			System.out.println("Date is shown to user on which assignment is has been completed");
			test.log(Status.INFO, "Date is shown to user on which assignment is has been completed");

		}
		assert1.assertAll();
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


		applyExplicitWait(4);;
		test.log(Status.INFO, "Clicking on Back to Test Unit, Syllabus ans Assignment page" );
		System.out.println("Clicking on Back to Test Unit, Syllabus ans Assignment page");
		clickOnElement(oas.back_btn);
		applyExplicitWaitsUntilElementVisible(oas.assignment);
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
		applyExplicitWait(2);

		clickOnElement(oas.assignTask);

		status = oas.today.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Task is created and Added in Todays Tab");
			test.log(Status.INFO, "Task is created and Added in Todays Tab");
		}

		assert1.assertAll();

	}



	public void creat_assignment(String subject,String topic) throws MalformedURLException {

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
		//oas.assign.click();
		test.log(Status.INFO, "New assignment created successfully " );
		System.out.println("New assignment created successfully ");


	}
}







