package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Assignment_Oral_Test extends BaseClass {
	public Object_Assignment_Oral_Test() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Assignment\")")
	public WebElement assignment;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@AndroidFindBy(id ="com.tce.studi:id/fab_assignment")
	public WebElement add_Symbol;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Oral Test\")")
	public WebElement oral_Test;

	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.TextView\").textContains(\"Create an oral test\")")
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement oral_Test_Heading;

	@AndroidFindBy(id ="com.tce.studi:id/tvNextStep")
	public WebElement next1 ;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrevious")
	public WebElement previous_btn ;

	@AndroidFindBy(id ="com.tce.studi:id/tvNextStep")
	public WebElement start_Test ;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrimaryAction")
	public WebElement begin_Test ;

	@AndroidFindBy(id ="com.tce.studi:id/imgDeleteSheet")
	public WebElement delete_note ;

	@AndroidFindBy(id ="com.tce.studi:id/txtPositiveBtn")
	public WebElement please_Discard ;

	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement take_me_Back ;

	//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.tce.studi:id/tvAssignDigitalTest\").textContains(\"All Subjects\")")
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement all_Sub;

	@AndroidFindBy(id ="com.tce.studi:id/tvAssignDigitalTest")
	public WebElement test_Details ;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/helpSwitch\").textContains(\"ON\")")
	public WebElement help_ON;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/helpSwitch\").textContains(\"OFF\")")
	public WebElement help_OFF;

	@AndroidFindBy(id ="com.tce.studi:id/tvTitleInstructionTest")
	public WebElement title_Instruction ;

	@AndroidFindBy(id ="com.tce.studi:id/tvDifficultyInstruction")
	public WebElement difficulty_level_Instruction ;

	@AndroidFindBy(id ="com.tce.studi:id/tvTentativeDurationInstructionTest")
	public WebElement duration_instruction ;

	@AndroidFindBy(id ="com.tce.studi:id/iv_left_icon")
	public WebElement back_btn ;

	@AndroidFindBy(id ="com.tce.studi:id/etTitleTest")
	public WebElement title_field;

	@AndroidFindBy(id ="com.tce.studi:id/difLow")
	public WebElement low;

	@AndroidFindBy(id ="com.tce.studi:id/difMedium")
	public WebElement medium;

	@AndroidFindBy(id ="com.tce.studi:id/difHigh")
	public WebElement high;

	@AndroidFindBy(id ="com.tce.studi:id/btnFive")
	public WebElement five;

	@AndroidFindBy(id ="com.tce.studi:id/btnTen")
	public WebElement ten;

	@AndroidFindBy(id ="com.tce.studi:id/btnFifteen")
	public WebElement fifteen;

	@AndroidFindBy(id ="com.tce.studi:id/btnThirty")
	public WebElement thirty;

	@AndroidFindBy(id ="com.tce.studi:id/ivPlayVideo")
	public WebElement video_icon;

	@AndroidFindBy(id ="com.tce.studi:id/ib_close_video")
	public WebElement video_close;

	@AndroidFindBy(id ="com.tce.studi:id/tvQuestionNumber")
	public WebElement question_count;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Oral Test: Natural Vegetation\")")
	public WebElement topic_name;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").textContains(\"The correct answer is\")")
	public WebElement question_Text;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement question_1;

	@AndroidFindBy(id ="com.tce.studi:id/ivNext")
	public WebElement next_arrow;

	@AndroidFindBy(id ="com.tce.studi:id/tvCorrect")
	public WebElement correct_option;

	@AndroidFindBy(id ="com.tce.studi:id/tvPartiallyCorrect")
	public WebElement partially_correct;

	@AndroidFindBy(id ="com.tce.studi:id/ivPrevious")
	public WebElement previous_arrow;

	@AndroidFindBy(id ="com.tce.studi:id/tvIncorrect")
	public WebElement incorrect_option;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtTitle\").textContains(\"End of Test\")")
	public WebElement end_Test_Title;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvPrimaryAction\").textContains(\"Redo Test\")")
	public WebElement redo_Test;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtTitle\").textContains(\"Redo test for a better score\")")
	public WebElement redo_Test_popup_Title;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtSubtitle\").textContains(\"All previous scores will be lost.\")")
	public WebElement redo_Test_popup_SubTitle;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtPositiveBtn\").textContains(\"Return\")")
	public WebElement return_redo_Test;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtNegativeBtn\").textContains(\"Redo Test\")")
	public WebElement redo_Test_on_popup;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvSecondaryAction\").textContains(\"Return to Subject\")")
	public WebElement return_to_Subject;

	@AndroidFindBy(id ="com.tce.studi:id/txtPositiveBtn")
	public WebElement submit_Test;

	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement Return_To_Test;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtSubtitle\").textContains(\"You have reached the end of test.\")")
	public WebElement end_subtitle;


	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvShowHide\").textContains(\"Hide Answer\")")
	public WebElement hide_Ans;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvShowHide\").textContains(\"Show Answer\")")
	public WebElement show_Ans;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.CheckBox")
	public WebElement correct_ans;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/etTitleTest\").textContains(\"Oral Test: The Universe\")")
	public WebElement title_filled;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/etTitleTest\").textContains(\" \")")
	public WebElement title_blank;

	public int get_Total_Number_Of_Questions_In_oral_Test() {
		if (device.equalsIgnoreCase("Android"))
		{
			MobileElement ele=findElementByText("1 of");
			String temp[] = ele.getText().split(" ");
			int temp1=Integer.parseInt(temp[temp.length-1]);
			System.err.println("que1 :"+ele.getText());
			return temp1;
		}


		else {
			MobileElement ele=driver.findElementByXPath("//*[@type=\"XCUIElementTypePageIndicator\"]");

			String temp[] = ele.getAttribute("value").split(" ");
			int temp1=Integer.parseInt(temp[temp.length-1]);
			System.err.println("que1 :"+ele.getAttribute("value"));
			return temp1;
		}
	}




}