package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_StudyPlan_ScheduledPlanView;

public class Module_StudyPlan_ScheduledPlanView extends BaseClass
{
	Object_StudyPlan_ScheduledPlanView ospsv = new Object_StudyPlan_ScheduledPlanView();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	public void To_Verify_check_uncheck_for_Filteration(String property, String property2) {
		try {
			to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ospsv.filter.click();
		try {
			applyExplicitWaitsUntilElementVisible(ospsv.filterHeading);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean filterHeading=ospsv.filterHeading.isDisplayed();
		if(filterHeading) {
			System.out.println("Filter Icon  of the Full schedule list page is tappable");
			test.log(Status.INFO, "Filter Icon of the Full schedule list page is tappable");
		}
		assert1.assertTrue(filterHeading);
		//ospsv.sub_checked.getAttribute("")
		clickOnElement(ospsv.sub_checked);
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
	public void to_verify_scheduled_plan_view_for_plan_not_started(String property, String property2) throws Exception {
		to_Verify_functionality_of_Filter_Icon_On_Schedule_List();
		scrollTo2("Sat");
		status=ospsv.not_studied.isDisplayed();
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
		status=ospsv.not_started.isDisplayed();
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
		status=ospsv.no_scheduled.isDisplayed();//change locator of no scheduled lession
		{
			System.out.println("If the plan end date is middle of the week days then no lesson schedule message is getting displayed for the date which is greater than plan end date");
			test.log(Status.INFO, "If the plan end date is middle of the week days then no lesson scheduled message is getting displayed for the date which is greater than plan end date");

		}
		assert1.assertTrue(status);
		assert1.assertAll();

	}


	public void to_Verify_functionality_of_Filter_Icon_On_Schedule_List() throws Exception {
		Object_StudyPlan_ScheduledPlanView ospsv= new Object_StudyPlan_ScheduledPlanView();
		SoftAssert assert1=new SoftAssert();

		Boolean landingPage=ospsv.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
			test.log(Status.INFO, "User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
			test.log(Status.INFO, "User can not be navigated to the landing page after login");
		}
		assert1.assertTrue(landingPage);

		Boolean testUnit=ospsv.test_unit.isDisplayed();
		if(testUnit) {
			System.out.println("In the landing page,Active StudyPlan tab is displayed");
			test.log(Status.INFO, "In the landing page,Active StudyPlan tab is displayed");
		}
		assert1.assertTrue(testUnit);
		ospsv.test_unit.click();
		applyExplicitWait(5);
		Boolean myLessonPage=ospsv.planTestUnit.isDisplayed();
		if(myLessonPage) {
			System.out.println("User able to navigate to MyLessons Page,after tapping on active study plan");
			test.log(Status.INFO, "User able to navigate to MyLessons Page,after tapping on active study plan");
		}
		assert1.assertTrue(myLessonPage);
		scrollTo2("View");
		applyExplicitWaitsUntilElementVisible(findElementByText("View Full Schedule"));
		clickOnElement(findElementByText("View Full Schedule"));

		Boolean scheduleListPage=ospsv.fullSchedule.isDisplayed();
		if(scheduleListPage) {
			System.out.println("On tapping View Full Schedule, user navigated to the Schedule list page");
			test.log(Status.INFO, "On tapping View Full Schedule, user navigated to the Schedule list page");
		}
		assert1.assertTrue(scheduleListPage);

		applyExplicitWaitsUntilElementVisible(ospsv.filter);
		Boolean filter=ospsv.filter.isDisplayed();
		if(filter) {
			System.out.println("Filter Icon  of the Full schedule list page is shown to the User");
			test.log(Status.INFO, "Filter Icon of the Full schedule list page is shown to the User");
		}
		assert1.assertTrue(filter);		




	}

	public void create_plan_for_not_studied()
	{

	}



	public void create_plan_for_not_started()
	{

	}

	public void create_plan_for_no_scheduled()
	{

	}
}
