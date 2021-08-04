package studi.co.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import studi.co.Base.BaseClass;

public class Object_Study_Plan_Create_Plan extends BaseClass {
	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Plan : Test Unit\")")
	public WebElement testUnitModule;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabusUnitModule;

	// + button in syllabus module
	@FindBy(id = "com.tce.studi:id/fab_assignment")
	public WebElement assignBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Study Plan\")")
	public WebElement studyPlanSyl;

	//	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Create Study Plan\")")
	//	public WebElement studyPlanTab;

	@AndroidFindBy(id = "com.tce.studi:id/tvHeading")
	public WebElement studyPlanTab;

	//@AndroidFindBy(id = "com.tce.studi:id/study_layout")
	@AndroidFindBy(id = "com.tce.studi:id/studyLayout")
	public WebElement studyLayout;
	
	public Map<String, Boolean> subjectFlag = new HashMap<String, Boolean>();


	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Paused\").resourceId(\"com.tce.studi:id/tvSubHeading\")")
	//@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Paused Plan\").resourceId(\"com.tce.studi:id/txtTitle\")")
	public WebElement testPauselbl;

	//@FindBy(id = "com.tce.studi:id/tv_manage_plans")		
	@FindBy(id = "com.tce.studi:id/tvManagePlans")
	public WebElement managePlanBtn;

	@FindBy(id = "com.tce.studi:id/tvCreatePlan")
	public WebElement createStudyPlanBtn;
	
	@AndroidFindBy(id="com.tce.studi:id/clActivePlan")
	public WebElement plan_on_MyPlans;



	@FindBy(id ="com.tce.studi:id/fabEditStudyPlan")
	public WebElement editPlan;
	public WebElement getFlagIcon() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button");

	}

	
}
