package studi.co.pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Quiz_Revision extends BaseClass {
	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"nextBtn\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextButton;
	@AndroidFindBy(id="com.tce.studi:id/tvName")
	public WebElement userName;
	@AndroidFindBy(id ="com.tce.studi:id/tvOverview")
	public WebElement why_tested_msg;

	@iOSFindBy(id = "WebviewQuiz")
	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	public WebElement question;

	@iOSFindBy(id = "backWithBackground")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\")")
	public WebElement backBtn;

	@AndroidFindBy(id ="com.tce.studi:id/iv_right_action_primary")
	public WebElement skip;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/ib_create_note\")")
	public WebElement addNotesBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;

	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextBtn;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestBtnOnPopup;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement exitTestOK;
	
	@AndroidFindBy(id = "com.tce.studi:id/vp_lesson_cards")
	public WebElement objectiveCard;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement conti_nue;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I don't know\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement dontKnowBtn;
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I'll attempt later\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement attempt_later;
	@iOSFindBy(id = "You're close! Try again.")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You're close! Try again.\")" )
	public WebElement answerPartialCorrectMsg1;


	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"CHECK ANSWER\"]")
	@AndroidFindBy(xpath ="com.tce.studi:id/tvPrimaryAction")
	public WebElement check_answer;

	@iOSFindBy(id = "Great job! Let's continue.")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Great job! Let's continue.\")" )
	public WebElement answerCorrectMsg1;




	public int get_Total_Number_Of_Questions_InRevision() {
		if (device.equalsIgnoreCase("Android"))
			return getDriver().findElementsByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView").size();
		//"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView").size();
		else {
			MobileElement ele=driver.findElementByXPath("//*[@type=\"XCUIElementTypePageIndicator\"]");

			String temp[] = ele.getAttribute("value").split(" ");
			int temp1=Integer.parseInt(temp[temp.length-1]);
			System.err.println("que1 :"+ele.getAttribute("value"));
			return temp1;
		}
	}

}

