package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriverException;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.pageModules.*;
import studi.co.pageObjects.Object_Create_Study_Plan;

public class AFS_UserStory_77 extends BaseClass {

	static int flag = 0;

	public AFS_UserStory_77() {
		super();

	}

	@Test(enabled = false)
	public void TC12_To_Verify_Receive_SCQ_Questions_In_Practice()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Questions_Practice(prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC13_To_Verify_SCQ_Answers_Is_In_Default_State_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Receive_SCQ_Answers_In_Default_State_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC14_To_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {	
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC15_To_Verify_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_SCQ_Answer_Can_Be_Slect_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC16_To_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Practice(prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC17_To_Verify_Feedback_Shown_For_Correct_Answer_Selection_In_SCQ_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Feedback_Shown_For_Correct_Answer_Selection_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));

	}

	@Test(enabled = false)
	public void TC18_To_Verify_Feedback_Shown_For_Incorrect_Answer_Selection_In_SCQ_Practice()
			throws Exception {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Feedback_Shown_For_Incorrect_Answer_Selection_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC19_To_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_Attempting_SCQ_Quiz_Is_Mandatory_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC20_To_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice()
			throws Exception {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_In_Wrong_Answer_Selection_User_Should_Get_1_More_Attempt_For_SCQ_In_Practice(
				prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC21_To_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Practice rqr = new Module_Receive_Questions_Practice();
		rqr.Module_Verify_User_Should_Be_Able_To_Abandon_The_SCQ_In_Practice(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC01_To_Verify_Receive_SCQ_Questions_In_Revision()
			throws WebDriverException, IOException, InterruptedException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Revision(prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC02_To_Verify_SCQ_Answers_In_Default_State_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Default_State_In_Revision(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC03_To_Verify_Various_SCQ_Answers_Available_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_Various_SCQ_Answers_Available_In_Revision(prop.getProperty("subject77"),
				prop.getProperty("subject77"));

	}

	@Test(enabled = false)
	public void TC04_To_Verify_SCQ_Answers_Can_Be_Select_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Receive_SCQ_Questions_Answer_Can_Be_Select_In_Revision(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC05_To_Verify_Only_Single_Answer_Can_Be_Select_For_SCQ_Question_In_Revision() throws Exception {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Verify_Only_Single_Answer_Can_Be_Select_For_SCQ_Question_In_Revision(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = true)
	public void TC06_To_Verify_Instant_Feedback_Shown_After_CQ_Correct_Answer_Selection_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Verify_Student_Should_Get_Instant_Feedback_For_SCQ_Question(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC07_To_Verify_State_Of_Answer_Should_Be_Maintained_For_SCQ_Question_In_Revision()
			throws WebDriverException, InterruptedException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Verify_State_Of_Answer_Should_Be_Maintained_For_SCQ_Question(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC09_To_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_Attempting_Quiz_Is_Not_Mandatory_In_Revision(prop.getProperty("subject77"),
				prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC11_To_Verify_User_Can_Abandon_SCQ_Quiz_In_Revision()
			throws InterruptedException, WebDriverException, IOException {
		Module_Receive_Questions_Revision rqr = new Module_Receive_Questions_Revision();
		rqr.Module_Verify_User_Can_Abandon_Quiz_In_Revision(prop.getProperty("subject77"), prop.getProperty("topic77"));
	}

	@Test(enabled = false)
	public void TC22_To_Verify_Receive_SCQ_Questions_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_SCQ_Questions_Test(prop.getProperty("subject77"));

	}

	@Test(enabled = false)
	public void TC23_Module_Receive_SCQ_Answers_In_Default_State_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Receive_SCQ_Answers_In_Default_State_In_Test(prop.getProperty("subject77"));

	}

	@Test(enabled = false)
	public void TC24_To_Verify_Multiple_Answers_Shown_For_SCQ_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Multiple_Answers_Shown_For_SCQ_In_Test(prop.getProperty("subject77"));
	}

	@Test(enabled = false)
	public void TC25_To_Verify_SCQ_Answers_Can_Be_Select_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_SCQ_Answer_Can_Be_Slect_In_Test(prop.getProperty("subject77"));
	}

	@Test(enabled = false)
	public void TC26_To_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Only_Single_SCQ_Answer_Can_Be_Select_In_Test(prop.getProperty("subject77"));
	}

	@Test(enabled = false)
	public void TC27_To_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_After_SCQ_Answer_Selection_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false) // needs questions data
	public void TC28_To_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test()
			throws MalformedURLException, InterruptedException {

		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Correct_Feedback_Shown_Under_Hamburger_Menu_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC29_To_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Test()
			throws MalformedURLException, InterruptedException {

		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Attempting_SCQ_Quiz_Is_Not_Mandatory_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC30_To_Verify_User_Should_Be_Able_To_Flag_The_SCQ_Question_In_Test()
			throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Should_Be_Able_To_Flag_The_Question_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC32_To_Verify_Marks_Shown_With_SCQ_In_Test() throws MalformedURLException, InterruptedException {
		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_Marks_Shown_With_SCQ_In_Test(prop.getProperty("Psubject"));

	}

	@Test(enabled = false)
	public void TC33_To_Verify_User_Can_Abond_SCQ_Quiz_In_Test() throws MalformedURLException, InterruptedException {

		Module_Receive_Questions_Test rqt = new Module_Receive_Questions_Test();
		rqt.Module_Verify_User_Can_Abond_SCQ_Quiz_In_Test(prop.getProperty("Psubject"));
	}

	//@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

	//@BeforeClass
	public void createPlan() throws MalformedURLException {

		Object_Create_Study_Plan temp = new Object_Create_Study_Plan();
		clickOnElement(temp.testUnitModule);
		scrollTo1("Manage and Create Plans");
		applyExplicitWait(5);
		System.out.println("Clicking on Manage and Create Plans");
		clickOnElement(temp.managePlanBtn);

		
		applyExplicitWait(5);
		System.out.println("Clicking on Create Study Plans");
		applyExplicitWaitsUntilElementClickable(temp.createStudyPlanBtn);
		clickOnElement(temp.createStudyPlanBtn);

		System.err.println("Clicked on " + prop.getProperty("subject77"));
		scrollTo2(prop.getProperty("subject77"));
		applyExplicitWaitsUntilElementVisible(findElementByText(prop.getProperty("subject77")));
		clickOnElement(findElementByText(prop.getProperty("subject77")));

		System.err.println("Clicked on " + prop.getProperty("topic77"));
		scrollTo2(prop.getProperty("topic77"));
		applyExplicitWaitsUntilElementVisible(findElementByText(prop.getProperty("topic77")));
		clickOnElement(findElementByText(prop.getProperty("topic77")));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);

		Boolean status = Boolean.parseBoolean(driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
				.getAttribute("focused"));
		if (status) {
			temp.subjectFlag.put(prop.getProperty("subject77"), true);
		} else {
			temp.subjectFlag.put(prop.getProperty("subject77"), false);
		}

		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);
		applyExplicitWaitsUntilElementClickable(temp.nextStepBtn);
		clickOnElement(temp.nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");
		for (int i = 0; i < 3; i++) {
			applyExplicitWaitsUntilElementClickable(temp.topLessonStatus);
			clickOnElement(temp.topLessonStatus);
			applyExplicitWait(5);
			clickOnElement(temp.markAsComplete);

		}
		applyExplicitWait(5);
		clickOnElement(getDriver().findElementById("com.tce.studi:id/iv_left_icon"));

	}

}
