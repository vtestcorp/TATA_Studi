package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.*;

public class AFS_UserStory_77 extends BaseClass {
	public AFS_UserStory_77() {
		super();
	}

	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = false)
	public void TC01_To_Verify_Receive_SCQ_Questions_In_Revision()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Revision(prop.getProperty("subject"), prop.getProperty("topic"));
	}

	@Test(enabled = false)
	// @Test(enabled = false, dataProvider = "Political_Science_Data",
	// dataProviderClass = DataProviders.class)
	// public void
	// TC02_Verify_Receive_SCQ_Questions_Default_State_In_Revision(String subject,
	// String topic)
	public void TC02_To_Verify_SCQ_Answers_In_Default_State_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Default_State_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
		// rqr.Module_Receive_SCQ_Questions_Default_State_In_Revision(subject, topic);
	}

	@Test(enabled = false)
	public void TC04_To_Verify_SCQ_Answers_Can_Be_Select_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Answer_Can_Be_Select_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false)
	public void TC05_To_Verify_Single_Answer_Is_Correct_For_SCQ_Question_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Single_Answer_Is_Correct_For_SCQ_Question_In_Revision(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false)
	public void TC12_To_Verify_Receive_SCQ_Questions_In_Practice()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Questions_Practice(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC13_To_Verify_SCQ_Answers_Is_In_Default_State_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Answers_In_Default_State_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC14_To_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC15_To_Verify_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(prop.getProperty("Psubject"), prop.getProperty("Ptopic"));
	}

	@Test(enabled = false)
	public void TC16_To_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));
	}

	@Test(enabled = false) // needs questions data
	public void TC17_To_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(prop.getProperty("Psubject"),
				prop.getProperty("Ptopic"));

	}

	@Test(enabled = true)
	public void TC18_To_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Correct_Incorrect_Feedback_Shown_After_SCQ_Answer_Selection_In_Practice(
				prop.getProperty("Psubject"), prop.getProperty("Ptopic"));

	}
	/*
	 * @AfterMethod public void restApp() { // getDriver().resetApp();
	 * getDriver().launchApp(); }
	 */
}
