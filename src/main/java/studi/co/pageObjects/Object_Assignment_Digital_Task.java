package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Assignment_Digital_Task  extends BaseClass {
	public Object_Assignment_Digital_Task() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Assignment\")")
	public WebElement assignment;

	@AndroidFindBy(id="com.tce.studi:id/fabAssignment")
	public WebElement add_assignment;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Digital Test\")")
	public WebElement digital_tets;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Assign\")")
	public WebElement assign;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Next\")")
	public WebElement next1;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvTitle\").textContains(\"Digital Test is Ready!\")")
	public WebElement notification;


	@AndroidFindBy(id ="com.tce.studi:id/ivCross")
	public WebElement closeNotification;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvView\").textContains(\"View Assignment\")")
	public WebElement viewAssignmenBtn;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrimaryAction")
	public WebElement beginTest;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvSecondaryAction\").textContains(\"Return to Assignment\")")
	public WebElement returnToAssignment;

	@AndroidFindBy(id ="com.tce.studi:id/ivConfidence")
	public WebElement confidenceStatus;

	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]")
	public WebElement questionView;


	@AndroidFindBy(id ="com.tce.studi:id/layoutQuiz")
	public WebElement quiz_Layout;

	@AndroidFindBy(id ="com.tce.studi:id/pbTestTime")
	public WebElement testTimer;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backTo;

	@AndroidFindBy(id="com.tce.studi:id/ivFlag")
	public WebElement flag;

	@AndroidFindBy(id="com.tce.studi:id/helpSwitch")
	public WebElement help;

	@AndroidFindBy(id="com.tce.studi:id/tvTitleTest")
	public WebElement title;

	@AndroidFindBy(id="com.tce.studi:id/tvTitleInstructionTest")
	public WebElement titleHelp;

	@AndroidFindBy(id="com.tce.studi:id/tvDifficulty")
	public WebElement difficultyLevel;

	@AndroidFindBy(id="com.tce.studi:id/tvDifficultyInstruction")
	public WebElement difficultyLevelHelp ;

	@AndroidFindBy(id="com.tce.studi:id/tvTentativeDurationTest")
	public WebElement duration;

	@AndroidFindBy(id="com.tce.studi:id/tvTentativeDurationInstructionTest")
	public WebElement durationHelp;

	@AndroidFindBy(id="com.tce.studi:id/tvDueDateTest")
	public WebElement dueDate;

	@AndroidFindBy(id="com.tce.studi:id/tvDueDateInstructionTest")
	public WebElement dueDateHelp;

	@AndroidFindBy(id="com.tce.studi:id/tvAttempted")
	public WebElement attempted;

	@AndroidFindBy(id="com.tce.studi:id/tvPending")
	public WebElement pending;

	@AndroidFindBy(id="com.tce.studi:id/tvFlagged")
	public WebElement flagged;

	@AndroidFindBy(id="com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTest;

	@AndroidFindBy(id="com.tce.studi:id/txtNegativeBtn")
	public WebElement returnToTest;

	@AndroidFindBy(id="com.tce.studi:id/imgClose")
	public WebElement closeTest;

	@AndroidFindBy(id="com.tce.studi:id/ivNext")
	public WebElement next_questin_Arrow;

	@AndroidFindBy(id="com.tce.studi:id/tvCheckAnswer")
	public WebElement check_Answer;

	@AndroidFindBy(id="com.tce.studi:id/tvExitReview")
	public WebElement exit_Review;

	@AndroidFindBy(id="com.tce.studi:id/tvQuestionNumbe")
	public WebElement ques_Number;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.view.View")
	//@AndroidFindBy(uiAutomator="new UiSelector().class(\"android.view.View\").textContains(\"Oops! You missed this.\")")
	public WebElement wrong_ans_msg;

	@AndroidFindBy(id="com.tce.studi:id/tvPrimaryAction")
	public WebElement redo_Test;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvOverview\").textContains(\"What you were tested on:\")")
	public WebElement summary_Heading;

	//@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement backBtn;

	@AndroidFindBy(id="com.tce.studi:id/tvAbandonTest")
	public WebElement abandon;

	@AndroidFindBy(id="com.tce.studi:id/tvAbandonTest")
	public WebElement abandonTest;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/txtSubtitle\").textContains(\"Your Progress will be lost. Are you sure want to go Away?\")")
	public WebElement abandon_msg;

	@AndroidFindBy(id="com.tce.studi:id/iv_right_action_primary")
	public WebElement closeTest2;

}