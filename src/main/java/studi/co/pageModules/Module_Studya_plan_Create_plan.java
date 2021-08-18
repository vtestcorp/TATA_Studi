package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Study_Plan_Create_Plan;

public class Module_Studya_plan_Create_plan  extends BaseClass{
	Object_Study_Plan_Create_Plan ospcp = new Object_Study_Plan_Create_Plan();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	public void To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention(String subject,String topic) {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;

		status = ospcp .profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		System.out.println("Clicking on Test Unit Module");
		clickOnElement(ospcp .testUnitModule);
		scrollTo2("Create");

		clickOnElement(ospcp .managePlanBtn);
		System.out.println("Clicked on Manage and Create plan Tab");

		status = ospcp .createStudyPlanBtn.isDisplayed();

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}

		System.out.println("Clicking on Create a Study Plan");
		test.log(Status.INFO, "Clicking on Create a Study Plan");
		clickOnElement(ospcp .createStudyPlanBtn);
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Create Study Plan button is tappable");
		test.log(Status.INFO, "Create Study Plan button is tappable");
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Subject list displayed to select portion");
		test.log(Status.INFO, "Subject list displayed to select portion");

		assert1.assertTrue(status);
		if (status) {
			System.out.println("Instruction to select Book in the bookshelf page Displayed");
			test.log(Status.INFO, "Instruction to select Book in the bookshelf page Displayed");
		}
		create_plan(subject, topic);
		clickOnElement(findElementByText("Add to portion"));

		if (status) {
			System.out.println("Clicked on Add to Portion");
			test.log(Status.INFO, "Clicked on Add to Portion");
		}

		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		clickOnElement(findElementByText("Next Step"));
		if (status) {
			System.out.println("Clicked on Next Step on Create Study Plan");
			test.log(Status.INFO, "Clicked on Next Step on Create Study Plan");
		}
		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");
		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");
		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		// clickOnElement(findElementByText(subject));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to Select the Flag");
			test.log(Status.INFO, "User is Able to Select the Flag");
		}

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, false);
			System.out.println("User is Able to DeSelect the Flag");
			test.log(Status.INFO, "User is Able to DeSelect the Flag");
			System.out.println("User is able to unflag the Book for which the user don't wants to pay extra attention");
			test.log(Status.INFO, "User is able to unflag the Book for which the user don't wants to pay extra attention");
		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}
	public void To_Verify_user_is_able_create_another_study_plan(String subject, String topic) throws MalformedURLException {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;

		status = ospcp.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}


		status = ospcp.testUnitModule.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(ospcp.testUnitModule);
		scrollTo1("Manage and Create Plans");


		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(ospcp.managePlanBtn);
		//create_plan(subject, topic);
		applyExplicitWaitsUntilElementClickable(ospcp.createStudyPlanBtn);
		System.out.println("Clicking on Study Plan");
		test.log(Status.INFO, "Clicking on Study Plan");
		clickOnElement(ospcp.plan_on_MyPlans);

		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		System.out.println("Clicking on Edit Plan Button");
		test.log(Status.INFO, "Clicking on Edit Plan Button");

		clickOnElement(ospcp.editPlan);

		//applyExplicitWaitsUntilElementClickable(ospcp.object44);
		scrollTo2("Portion");

		applyExplicitWait(5);


		clickOnElement(findElementByText("Portion"));
		applyExplicitWait(5);
		//applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));

		clickOnElement(findElementByText("Next Step"));

		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");

		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		// clickOnElement(findElementByText(subject));

		//Thread.sleep(500);

		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to add Spaced Practice2 if parent practice is incomplete");
			test.log(Status.INFO, "User is Able to add Spaced Practice2 if parent practice is incomplete");
			applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		}
		clickOnElement(findElementByText("Next Step"));
		System.out.println("Started calender");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				List<MobileElement> dates = driver.findElements(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.GridView/android.view.View["
								+ (i + 1) + "]/android.view.View[" + (j + 1) + "]"));
				for (MobileElement date : dates) {
					System.out.println(date.getText() + " " + date.getAttribute("focused"));
					if (date.getAttribute("focused").contains("true")) {
						date.click();
					}
				}
			}
		}
		try {
			applyExplicitWaitsUntilElementVisible(findElementByText("Next"));
			clickOnElement(findElementByText("Next"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//clickOnElement(findElementByText("Continue"));


		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("User is able to create another study plan");
		test.log(Status.INFO, "User is able to create another study plan");

		assert1.assertAll();
	}
	public void To_Verify_user_is_able_to_see_previous_plan(String subject,String topic) {
		SoftAssert assert1 = new SoftAssert();
		Boolean status;
		status = ospcp.profilePic.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		status = ospcp.testUnitModule.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(ospcp.testUnitModule);
		scrollTo1("Manage and Create Plans");
		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(ospcp.managePlanBtn);
		applyExplicitWaitsUntilElementClickable(ospcp.createStudyPlanBtn);
		System.out.println("Clicking on Study Plan");
		test.log(Status.INFO, "Clicking on Study Plan");
		clickOnElement(ospcp.plan_on_MyPlans);

		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);

		System.out.println("Clicking on Edit Plan Button");
		test.log(Status.INFO, "Clicking on Edit Plan Button");

		applyExplicitWaitsUntilElementClickable(ospcp.editPlan);
		clickOnElement(ospcp.editPlan);
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		applyExplicitWaitsUntilElementClickable(findElementByText("Portion"));
		clickOnElement(findElementByText("Portion"));
		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		clickOnElement(findElementByText("Next Step"));

		System.out.println("Moving to \"Pay Extra Attention\" Window");
		test.log(Status.INFO, "Moving to \"Pay Extra Attention\" Window");

		System.out.println("Try to flag the Subject");
		test.log(Status.INFO, "Try to flag the Subject");

		applyExplicitWaitsUntilElementClickable(ospcp.getFlagIcon());
		clickOnElement(ospcp.getFlagIcon());
		status = Boolean.parseBoolean(ospcp.getFlagIcon().getAttribute("focused"));
		System.out.println("Flag focus : " + ospcp.getFlagIcon().getAttribute("focused"));
		if (status) {
			ospcp.subjectFlag.put(subject, true);
			System.out.println("User is Able to add Spaced Practice2 if parent practice is incomplete");
			test.log(Status.INFO, "User is Able to add Spaced Practice2 if parent practice is incomplete");
			applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		}
		clickOnElement(findElementByText("Next Step"));
		System.out.println("Started calender");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				List<MobileElement> dates = driver.findElements(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.GridView/android.view.View["
								+ (i + 1) + "]/android.view.View[" + (j + 1) + "]"));
				for (MobileElement date : dates) {
					System.out.println(date.getText() + " " + date.getAttribute("focused"));
					if (date.getAttribute("focused").contains("true")) {
						date.click();
					}
				}
			}
		}
		try {
			applyExplicitWaitsUntilElementVisible(findElementByText("Next"));
			clickOnElement(findElementByText("Next"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		try {
			applyExplicitWait(5);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("User is able to see the previous plan");
		test.log(Status.INFO, "User is able to see the previous plan");
		assert1.assertAll();
	}
	public void create_plan(String subject,String topic)
	{
		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic);
		scrollTo2(topic);
		clickOnElement(findElementByText(topic));
	}
	public void To_Verify_check_uncheck_for_Filteration(String property, String property2) {
		try {
			to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ospcp.filter.click();
		try {
			applyExplicitWaitsUntilElementVisible(ospcp.filterHeading);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean filterHeading=ospcp.filterHeading.isDisplayed();
		if(filterHeading) {
			System.out.println("Filter Icon  of the Full schedule list page is tappable");
			test.log(Status.INFO, "Filter Icon of the Full schedule list page is tappable");
		}
		assert1.assertTrue(filterHeading);
		//ospsv.sub_checked.getAttribute("")
		clickOnElement(ospcp.sub_checked);
		{
			System.out.println("Selecting the All SUbjects Checkbox");
			test.log(Status.INFO, "Selecting the All SUbjects Checkbox");
		}
		clickOnElement(findElementByText("Apply"));
		{
			System.out.println("Clicked on Apply Button");
			test.log(Status.INFO, "Clicked on Apply Button");

		}
		assert1.assertAll();
	}
	public void to_verify_scheduled_plan_view_for_plan_not_started(String subject_english, String topic_not_started) throws Exception {
		to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		scrollTo2("Sat");
		status=ospcp.not_studied.isDisplayed();
		{
			System.out.println("If plan is created and user still not completed any task from started date then status is getting displayed as plan not started");
			test.log(Status.INFO, "If plan is created and user still not completed any task from started date then status is getting displayed as plan not started");

		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}
	public void to_verify_Week_Cycle_plan_which_is_started_in_the_middle_of_week_days() throws Exception {
		to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		scrollTo2("Sat");
		status=ospcp.not_started.isDisplayed();
		{
			System.out.println("If the plan start date is middle of the week days then plan not started message is getting displayed for the date which is less than plan start date");
			test.log(Status.INFO, "If the plan start date is middle of the week days then plan not started  message is getting displayed for the date which is less than plan start date");

		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}
	public void to_verify_scheduled_plan_view_for_no_lesson_scheduled() throws Exception {
		to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		scrollTo2("Sat");
		status=ospcp.no_scheduled.isDisplayed();//change locator of no scheduled lession
		{
			System.out.println("If the plan end date is middle of the week days then no lesson schedule message is getting displayed for the date which is greater than plan end date");
			test.log(Status.INFO, "If the plan end date is middle of the week days then no lesson scheduled message is getting displayed for the date which is greater than plan end date");

		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}


	public void to_Verify_functionality_of_Filter_Icon_On_Schedule_List() throws Exception {
		Object_Study_Plan_Create_Plan ospcp= new Object_Study_Plan_Create_Plan();
		SoftAssert assert1=new SoftAssert();

		Boolean landingPage=ospcp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");
		}
		assert1.assertTrue(landingPage);

		Boolean testUnit=ospcp.test_unit.isDisplayed();
		if(testUnit) {
			System.out.println("In the landing page,Active StudyPlan tab is displayed");
			test.log(Status.INFO, "In the landing page,Active StudyPlan tab is displayed");
		}
		assert1.assertTrue(testUnit);
		ospcp.test_unit.click();
		applyExplicitWait(5);
		Boolean myLessonPage=ospcp.planTestUnit.isDisplayed();
		if(myLessonPage) {
			System.out.println("User able to navigate to MyLessons Page,after tapping on active study plan");
			test.log(Status.INFO, "User able to navigate to MyLessons Page,after tapping on active study plan");
		}
		assert1.assertTrue(myLessonPage);
		scrollTo2("View");
		applyExplicitWaitsUntilElementVisible(findElementByText("View Full Schedule"));
		clickOnElement(findElementByText("View Full Schedule"));

		Boolean scheduleListPage=ospcp.fullSchedule.isDisplayed();
		if(scheduleListPage) {
			System.out.println("On tapping View Full Schedule, user navigated to the Schedule list page");
			test.log(Status.INFO, "On tapping View Full Schedule, user navigated to the Schedule list page");
		}
		assert1.assertTrue(scheduleListPage);

		applyExplicitWaitsUntilElementVisible(ospcp.filter);
		Boolean filter=ospcp.filter.isDisplayed();
		if(filter) {
			System.out.println("Filter Icon  of the Full schedule list page is shown to the User");
			test.log(Status.INFO, "Filter Icon of the Full schedule list page is shown to the User");
		}
		assert1.assertTrue(filter);		

	}

		public void create_plan_for_not_started(String subject_History, String topic_not_started) throws MalformedURLException, InterruptedException
	{		
		clickOnElement(findElementByText("Plan"));

		scrollTo2("Manage and Create Plans");
		clickOnElement(findElementByText("Manage and Create Plans"));
		clickOnElement(findElementByText("Create Plan"));



		System.err.println("Clicked on " + subject_History);
		scrollTo2(subject_History);
		clickOnElement(findElementByText(subject_History));

		System.err.println("Clicked on " + topic_not_started);
		scrollTo2(topic_not_started);
		clickOnElement(findElementByText(topic_not_started));


		clickOnElement(findElementByText("Add to Portion"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Next Step"));

		//calender
		Thread.sleep(2000);
		clickOnElement(findElementByText("Next Step"));

		clickOnElement(findElementByText("Activate Plan"));
		System.out.println("Activating tha plan for Given Subject and Topic");
		test.log(Status.INFO, "Activating tha plan for Given Subject and Topic");
		applyExplicitWait(3);
		clickOnElement(findElementByText("Bagin Studying"));
		applyExplicitWait(3);

		applyExplicitWaitsUntilElementVisible(findElementByText("Today"));
		System.out.println("The plan has been successfully created");
		test.log(Status.INFO, "The plan has been successfully created");



	}


}
