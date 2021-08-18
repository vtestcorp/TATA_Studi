package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Studya_plan_Create_plan;

public class Study_Plan_Create_Plan extends BaseClass{
	static int flag = 0;

	public Study_Plan_Create_Plan() {
		super();


	}

	@Test(enabled= true)//pass
	public void TC01_To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention(prop.getProperty("subject"),prop.getProperty("topic"));

	}

	@Test(enabled= true)
	public void TC02_To_Verify_user_is_able_create_another_study_plan() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_create_another_study_plan(prop.getProperty("subject"),prop.getProperty("topic"));


	}
	@Test(enabled= true)
	public void TC03_To_verify_user_is_able_to_see_the_previous_plan() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_to_see_previous_plan(prop.getProperty("subject"),prop.getProperty("topic"));

	}
	@Test(enabled= true)
	public void TC04_To_Verify_check_uncheck_for_Filteration() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_check_uncheck_for_Filteration(prop.getProperty("subject"),prop.getProperty("topic"));

	}

	@Test(enabled= true)
	public void TC06_To_verify_scheduled_plan_view_for_plan_not_started() throws Exception {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.to_verify_scheduled_plan_view_for_plan_not_started(prop.getProperty("subject_english"),prop.getProperty("topic_not_started"));

	}
	@Test(enabled= true)
	public void TC07_To_verify_Week_Cycle_plan_which_is_started_in_the_middle_of_week_days() throws Exception {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.to_verify_Week_Cycle_plan_which_is_started_in_the_middle_of_week_days();

	}
	@Test(enabled= true)
	public void TC08_To_verify_scheduled_plan_view_for_no_lesson_scheduled() throws Exception {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.to_verify_scheduled_plan_view_for_no_lesson_scheduled();
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}

