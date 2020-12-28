package studi.co.testScripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageModules.Model_Receive_MCQ_Questions_DefaultState;
import studi.co.pageModules.Model_Receive_MCQ_Questions_Revision;
import studi.co.pageModules.Model_View_Chapter_Listing;
import studi.co.pageModules.Module_Completed_In_School;
import studi.co.pageModules.Module_Create_Study_Plan;
import studi.co.pageModules.Module_Excluded_From_Syllabus_Manually;
import studi.co.pageModules.Module_Get_Syllabus_Tab_Label;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Mark_Completed_In_School_Manually;
import studi.co.pageModules.Module_Navigate_Revision_From_Topic_Listing;
import studi.co.pageModules.Module_Receive_MCQ_Questions_Practice;
import studi.co.pageModules.Module_Review_Plan_Tab;
import studi.co.pageModules.Module_Syllabus_Tappable;
import studi.co.pageModules.Module_Verify_Abandon_Quiz_From_Revision;
import studi.co.pageModules.Module_Verify_Answer_Feedback_In_Practice;
import studi.co.pageModules.Module_Verify_Answer_Feedback_In_Revision;
import studi.co.pageModules.Module_Verify_Answer_Options_In_Practice;
import studi.co.pageModules.Module_Verify_Attempt_In_Practice;
import studi.co.pageModules.Module_View_Chapter_Details;
import studi.co.pageObjects.Object_Login;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;

public class AFS_UserStory_76 extends BaseClass {

	public AFS_UserStory_76() {
		super();
	}

	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = true)
	public void TC04_Verify_MCQ_Answers_Can_Be_Select_or_Unselect_In_Revision()
			throws WebDriverException, IOException, InterruptedException {
		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
		RMQP.select_syllabus.click();
		applyExplicitWait(1);
		RMQP.select_subject.click();
		applyExplicitWait(1);
		System.out.println("Subject - Geography - Geography Grade 6 is shown");
		RMQP1.select_topic_from_chapter.click();
		applyExplicitWait(2);
		System.out.println("Selected Topic");
		RMQP1.select_Begin_Revision.click();
		applyExplicitWait(20);
		RMQP1.click_Begin_Revision.click();
		applyExplicitWait(2);
		
		System.out.println("Video started");
		forwardVideoTimerToEnd();
		applyExplicitWait(15);
		List<MobileElement> questions=getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView");
		System.out.println("Total questions : "+questions.size());
		
		for(int i=0;i<questions.size();i++)
		{
			applyExplicitWait(10);
		if (RMQP1.checkAnswer.isDisplayed()) {
			applyExplicitWait(5);
			clickOnElement(RMQP1.select_1st_Choice);
			System.out.println("1st option selected");
			applyExplicitWait(5);
			if (RMQP1.select_2nd_Choice.isDisplayed())
				{clickOnElement(RMQP1.select_2nd_Choice);System.out.println("2nd option selected");}
			
			applyExplicitWait(5);
			if (RMQP1.select_3rd_Choice.isDisplayed())
				{clickOnElement(RMQP1.select_3rd_Choice);System.out.println("3rd option selected");}
			
			applyExplicitWait(5);
			
			if (RMQP1.select_4th_Choice.isDisplayed())
				{clickOnElement(RMQP1.select_4th_Choice);System.out.println("4th option selected");}
			
			applyExplicitWait(5);
			clickOnElement(RMQP1.nextButton);
		}
		else
		{
			clickOnElement(RMQP1.checkAnswer);
			clickOnElement(RMQP1.nextButton);
			applyExplicitWait(5);
		}
		}
	}

	@Test(enabled = false)
	public void TC03_Verify_Answer_Options_In_Revision() {

	}

	@Test(enabled = false)
	public void TC08_Verify_Feedback_For_Answers_In_Revision() throws InterruptedException, AWTException, IOException {
		Module_Verify_Answer_Feedback_In_Revision mva = new Module_Verify_Answer_Feedback_In_Revision();
		mva.verify_Answer_Feedback();
	}

	@Test(enabled = false)
	public void TC10_Select_All_Answers_And_Verify_Feedback()
			throws InterruptedException, AWTException, HeadlessException, IOException {
		Module_Verify_Answer_Feedback_In_Revision mvaf = new Module_Verify_Answer_Feedback_In_Revision();
		mvaf.Verify_Feedback_On_All_Answers_In_Revision();
	}

	@Test(enabled = false)
	public void TC11_Verify_Abandon_Quiz_From_Revision() throws InterruptedException {
		Module_Verify_Abandon_Quiz_From_Revision mvaqfr = new Module_Verify_Abandon_Quiz_From_Revision();
		mvaqfr.verifyAbandonQuiz();
	}

	@Test(enabled = false)
	public void TC12_Verify_MCQ_Questions_In_Pratice() throws InterruptedException, IOException {
		Module_Verify_Answer_Options_In_Practice mvaoip = new Module_Verify_Answer_Options_In_Practice();
		mvaoip.module_Verify_Answer_Options_In_Practice();
		mvaoip.verify_Question_Count_In_Practice();
	}

	@Test(enabled = false)
	public void TC14_Verify_Answer_Options__In_Practice() throws InterruptedException, IOException {
		Module_Verify_Answer_Options_In_Practice mvaoip = new Module_Verify_Answer_Options_In_Practice();
		mvaoip.module_Verify_Answer_Options_In_Practice();
	}

	@Test(enabled = false)
	public void TC15_Verify_Answers_Are_Selectable_And_Deselectable_In_Practice()
			throws InterruptedException, IOException {
		Module_Verify_Answer_Options_In_Practice mvaoip = new Module_Verify_Answer_Options_In_Practice();
		mvaoip.verify_Answers_Selectable_Deselectable();
	}

	@Test(enabled = false)
	public void TC18_Verify_Answer_Feedback_In_Practice() {
		Module_Verify_Answer_Feedback_In_Practice mva = new Module_Verify_Answer_Feedback_In_Practice();
		mva.verify_Answer_Feedback();
	}

	@Test(enabled = false)
	public void TC20_Verify_Attempts_In_Practice_Module() throws InterruptedException, IOException {
		Module_Verify_Attempt_In_Practice mvaip = new Module_Verify_Attempt_In_Practice();
		mvaip.verify_Attempt_In_Practice();
	}

	@Test(enabled = false)
	public void View_Chapter_Details() throws InterruptedException, AWTException {
		Model_View_Chapter_Listing MRMQP = new Model_View_Chapter_Listing();
		MRMQP.Verify_View_Chapter_Listing();
	}

	@Test(enabled = false)
	public void View_Chapter_Listing_Page_Content() throws InterruptedException, AWTException {
		Module_View_Chapter_Details MRMQP = new Module_View_Chapter_Details();
		MRMQP.Verify_View_Chapter_Details();
	}

	@Test(enabled = false)
	public void Review_Plan_Tab() throws InterruptedException, AWTException {
		Module_Review_Plan_Tab MRMQP = new Module_Review_Plan_Tab();
		MRMQP.Verify_Review_Plan_Tab();
	}

	@Test(enabled = false)
	public void Recieve_MCQ_Questions_DefaultState() throws InterruptedException, AWTException {

		Model_Receive_MCQ_Questions_DefaultState MRMQP = new Model_Receive_MCQ_Questions_DefaultState();
		MRMQP.Verify_MCQ_Questions_DefaultState();
	}

	@Test(enabled = false)
	public void Receive_MCQ_Questions_Practice() throws Exception {

		Module_Receive_MCQ_Questions_Practice MRMQP = new Module_Receive_MCQ_Questions_Practice();
		MRMQP.Verify_Student_Receives_MCQ_Questions_Practice();

	}

	@Test(enabled = false)
	public void Recieve_MCQ_Questions_Revision() throws InterruptedException, AWTException {
		Model_Receive_MCQ_Questions_Revision MRMQP = new Model_Receive_MCQ_Questions_Revision();
		MRMQP.Verify_Navigate_Revision_From_Topic_Listing();
	}

	@Test(enabled = false)
	public void Navigate_Revision_From_Topic_Listing() throws InterruptedException, AWTException {
		Module_Navigate_Revision_From_Topic_Listing MRMQP = new Module_Navigate_Revision_From_Topic_Listing();
		MRMQP.Verify_Navigate_Revision_From_Topic_Listing();
	}

	@Test(enabled = false)
	public void Mark_Excluded_From_Syllabus_Manually() throws InterruptedException {
		Module_Excluded_From_Syllabus_Manually CSP = new Module_Excluded_From_Syllabus_Manually();
		CSP.Verify_Excluded_From_Syllabus();
	}

	@Test(enabled = false)
	public void Mark_Completed_In_School_Manaually() throws InterruptedException {
		Module_Mark_Completed_In_School_Manually CSP = new Module_Mark_Completed_In_School_Manually();
		CSP.Verify_Completed_In_School_Status();
	}

	@Test(enabled = false)
	public void Verify_Create_Study_Plan() throws InterruptedException {
		Module_Create_Study_Plan CSP = new Module_Create_Study_Plan();
		CSP.Validate_create_study_plan();
	}

	@Test(enabled = false)
	public void Confirm_Syllabus_Tab() throws InterruptedException {
		Module_Get_Syllabus_Tab_Label CSP = new Module_Get_Syllabus_Tab_Label();
		CSP.Verify_Syllabus_Tab_Label();
	}

	@Test(enabled = false)
	public void Confirm_Syllabus_Page_Tappable() throws InterruptedException {
		Module_Syllabus_Tappable CSP = new Module_Syllabus_Tappable();
		CSP.Verify_Syllabus_Tappable();
	}

	@Test(enabled = false)
	public void Completed_In_School_Status_Chapter() throws InterruptedException {
		Module_Completed_In_School CSP = new Module_Completed_In_School();
		CSP.Verify_Completed_In_School_Status();
	}

	@Test(enabled = false)
	public void TC03_Verify_RadioButtons_For_Answers_In_Revision() {

	}

}
