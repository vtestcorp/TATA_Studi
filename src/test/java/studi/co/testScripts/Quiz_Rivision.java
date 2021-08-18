package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Quiz_Revision;

public class Quiz_Rivision extends BaseClass{
	static int flag = 0;

	public Quiz_Rivision() {
		super();


	}

	@Test(enabled= true)
	public void TC03_To_verify_not_mandatory_in_Revise_module_to_attempt_each_question () throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_not_mandatory_in_Revise_module_to_attempt_each_question(prop.getProperty("subject77"),prop.getProperty("topic77"));
	}
	@Test(enabled= true)
	public void TC04_To_verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_user_can_easily_skip_continue_to_next_question_without_attempting_current_one(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}
	@Test(enabled= true)
	public void TC06_To_verify_Feedback_provided_at_the_click_of_options_itself() throws MalformedURLException, InterruptedException {
		Module_Quiz_Revision mqr=new Module_Quiz_Revision();
		mqr.to_Verify_user_Feedback_provided_at_the_click_of_options_itself(prop.getProperty("subject77"),prop.getProperty("topic77"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}


}

