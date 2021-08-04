package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Studya_plan_Create_plan;

public class Study_Plan_Create_Plan extends BaseClass{
	static int flag = 0;

	public Study_Plan_Create_Plan() {
		super();


	}

	@Test(enabled= true)
	public void TC01_To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_to_unflag_Book_for_which_the_user_dont_wants_to_pay_extra_attention(prop.getProperty("subject"),prop.getProperty("topic"));

	}

	@Test(enabled= true,priority=-2)
	public void TC02_To_Verify_user_is_able_create_another_study_plan() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_create_another_study_plan(prop.getProperty("subject"),prop.getProperty("topic"));


	}
	public void TC03_To_verify_user_is_able_to_see_the_previous_plan() throws MalformedURLException, InterruptedException {
		Module_Studya_plan_Create_plan mspcp=new Module_Studya_plan_Create_plan();
		mspcp.To_Verify_user_is_able_to_see_previous_plan(prop.getProperty("subject"),prop.getProperty("topic"));

	}
}

