package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Model_Receive_Subjective_Questions_Revision;
import studi.co.pageModules.Module_Login;


public class AFS_UserStory_80 extends BaseClass {

	int flag;

	public AFS_UserStory_80()
	{
		super();
		flag=0;

	}
	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	////////////////////////////////////////////Practice-Subjective////////////////////////////////////////////////////////

	@Test(enabled= true)
	public void TC01_Verify_questionset_along_with_Show_Button_is_Available() throws InterruptedException, WebDriverException, IOException {
		Model_Receive_Subjective_Questions_Revision rsqr = new Model_Receive_Subjective_Questions_Revision();
		rsqr.Module_Receive_Subjective_Questions_Revision(prop.getProperty("subject76"),
				prop.getProperty("topic76"));
	}

	@Test(enabled= false)
	public void TC02_To_verify_that_user_should_be_able_to_attempt_the_subjective_type_question()throws InterruptedException, WebDriverException, IOException {

		Model_Receive_Subjective_Questions_Revision rsqr = new Model_Receive_Subjective_Questions_Revision();
		rsqr.Module_Receive_Subjective_Questions_Revision(prop.getProperty("subject76"), prop.getProperty("topic76"));

	}
	@Test(enabled=false)
	public void TC_03_Verify_that_on_navigating_back_to_the_question_last_selected_option_should_be_displayed_as_highlighted()
	{

	}
	@Test(enabled=false)
	public void TC_04_To_verify_that_Subjective_questions_will_only_be_displayed_on_Revise_section_only()

	{

	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}

