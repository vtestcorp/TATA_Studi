package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_StudyPlan_ScheduledPlanView;
import studi.co.pageModules.Module_Studya_plan_Create_plan;

public class StudyPlan_ScheduledPlanView extends BaseClass{
	static int flag = 0;

	public StudyPlan_ScheduledPlanView() {
		super();


	}

	@Test(enabled= true)
	public void TC04_To_Verify_check_uncheck_for_Filteration() throws MalformedURLException, InterruptedException {
		Module_StudyPlan_ScheduledPlanView mspsv=new Module_StudyPlan_ScheduledPlanView();
		mspsv.To_Verify_check_uncheck_for_Filteration(prop.getProperty("subject"),prop.getProperty("topic"));

	}

	@Test(enabled= true)
	public void TC06_To_verify_scheduled_plan_view_for_plan_not_started() throws Exception {
		Module_StudyPlan_ScheduledPlanView mspsv=new Module_StudyPlan_ScheduledPlanView();
		mspsv.to_verify_scheduled_plan_view_for_plan_not_started(prop.getProperty("subject"),prop.getProperty("topic"));


	}
	@Test(enabled= true)
	public void TC07_To_verify_Week_Cycle_plan_which_is_started_in_the_middle_of_week_days() throws Exception {
		Module_StudyPlan_ScheduledPlanView mspsv=new Module_StudyPlan_ScheduledPlanView();
		mspsv.to_verify_Week_Cycle_plan_which_is_started_in_the_middle_of_week_days();

	}
	@Test(enabled= true)
	public void TC08_To_verify_scheduled_plan_view_for_no_lesson_scheduled() throws Exception {
		Module_StudyPlan_ScheduledPlanView mspsv=new Module_StudyPlan_ScheduledPlanView();
		mspsv.to_verify_scheduled_plan_view_for_no_lesson_scheduled();
	}

	@Test(enabled= true)
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
