package studi.co.pageObjects;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;

public class Object_Create_Study_Plan extends BaseClass {
	public Object_Create_Study_Plan() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

		// public String[] expectedLessonOrder={"Big Idea", "Revise", "Practice",
		// "Summary", "Test"};

		expectedLessonOrder.put("Big Idea",
				//"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout");
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
		expectedLessonOrder.put("Revise",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
		expectedLessonOrder.put("Practice",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup");
		expectedLessonOrder.put("Summary",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup");

		expectedLessonOrder.put("Test",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup");

		upcomingLesson.put("Big Idea",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
		upcomingLesson.put("Revise",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
		upcomingLesson.put("Practice",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
		upcomingLesson.put("Summary",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
		upcomingLesson.put("Test",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");

		subjectFlag.put("", false);

	}

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

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Paused\").resourceId(\"com.tce.studi:id/tvSubHeading\")")
	//@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Paused Plan\").resourceId(\"com.tce.studi:id/txtTitle\")")
	public WebElement testPauselbl;

	//@FindBy(id = "com.tce.studi:id/tv_manage_plans")		
	@FindBy(id = "com.tce.studi:id/tvManagePlans")
	public WebElement managePlanBtn;

	@FindBy(id = "com.tce.studi:id/tvCreatePlan")
	public WebElement createStudyPlanBtn;


	@FindBy(id ="com.tce.studi:id/fabEditStudyPlan")
	public WebElement editPlan;

	@FindBy(className  = "android.widget.Image")
	public WebElement image;

	@FindBy(xpath = "com.tce.studi:id/fab_edit")
	public WebElement actualLesson28;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Next Step\")")
	public WebElement nextStepBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.tce.studi:id/tv_intent_title\").textContains(\"Portionp\")")
	public WebElement portion;
	
	@FindBy(id = "com.tce.studi:id/tv_coming_soon")
	public WebElement taskCountInUpcoming;

	public Map<String, String> expectedLessonOrder = new LinkedHashMap<String, String>();
	public Map<String, String> upcomingLesson = new LinkedHashMap<String, String>();
	public Map<String, Boolean> subjectFlag = new HashMap<String, Boolean>();

	@FindBy(id = "com.tce.studi:id/imgOverflow")
	//@FindBy(id = "com.tce.studi:id/completed")
	public WebElement topLessonStatus;


	@FindBy(id ="com.tce.studi:id/imgOverflow")
	public WebElement markAsComplete;

	@FindBy(id = "com.tce.studi:id/recycler_today")
	public WebElement todaysLessonPanel;

	@FindBy(id = "com.tce.studi:id/viewSchedule")
	public WebElement viewFullScheduleBtn;

	@FindBy(id = "com.tce.studi:id/imgFilter")
	public WebElement fullSchedule_filter;
	
	@FindBy(id = "com.tce.studi:id/search_id")
	public WebElement fullScheduleLbl;

	@AndroidFindBy(id = "com.tce.studi:id/recycler_full_schedule")
	public MobileElement fullscedulerecyclere;

	@AndroidFindBy(id="com.tce.studi:id/tvAlmostHereDesc")
	public WebElement taskToBeCompletedToday;

	@AndroidFindBy(id="com.tce.studi:id/imgOverflow")
	public WebElement kebabMenu;

	//public String topicName1="com.tce.studi:id/tv_date";

	@AndroidFindBy(id="com.tce.studi:id/tv_due_today")
	public WebElement taskCompleted;

	@AndroidFindBy(id="com.tce.studi:id/tick")
	public WebElement tick;


	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backButton;

	@AndroidFindBy(id="com.tce.studi:id/txtPositiveBtn")
	public WebElement yesBtn;
	
	@AndroidFindBy(id="com.tce.studi:id/imgOverflowNormal")
	public WebElement lessonStatus1;

	@AndroidFindBy(id="com.tce.studi:id/txtPositiveBtn")
	public WebElement positiveButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement question1_part_Text;

	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionNumber")
	public WebElement quetionCount;

	@AndroidFindBy(id="com.tce.studi:id/tv_primary_action")
	public WebElement practise_Again1;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[4]/android.widget.CheckBox")
	public WebElement right_Answer_message;

	@AndroidFindBy(id="com.tce.studi:id/tvTarget")
	public WebElement target;

	//@AndroidFindBy(id="com.tce.studi:id/tv_day_name")
	@AndroidFindBy(id="com.tce.studi:id/txtWeekDayName")
	public WebElement today;

	@AndroidFindBy(id="com.tce.studi:id/tv_due")
	public WebElement pastLessons;

	public String box="com.tce.studi:id/row_lesson_main_view";

	public String status="//android.widget.ImageView[@resource-id='com.tce.studi:id/completed' or @resource-id='com.tce.studi:id/img_overflow' or @resource-id='com.tce.studi:id/locked']";

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]")
	public MobileElement todayMainView;


	@AndroidFindBy(xpath="//*[contains(@text, 'overdue')]/preceding-sibling::android.widget.TextView[3]")
	public WebElement inputLesson;

	@AndroidFindBy(xpath="//*[contains(@text, 'Today')]/parent::*/ancestor::androidx.recyclerview.widget.RecyclerView")
	public MobileElement lessonPanel1;

	//@AndroidFindBy(xpath="//*[contains(@text, 'Today')]/following-sibling::androidx.recyclerview.widget.RecyclerView")
	@AndroidFindBy(id="com.tce.studi:id/todayViewId")
	public MobileElement lessonPanel;

	@AndroidFindBy(xpath="//*[contains(@text, 'Today')]/parent::*/following-sibling::*")
	public MobileElement lessonPanel53;
	//*[contains(@text, 'Today')]/parent::*/following-sibling::androidx.recyclerview.widget.RecyclerView

	@AndroidFindBy(xpath="//*[contains(@text, 'Today')]/parent::*/following-sibling::androidx.recyclerview.widget.RecyclerView")
	public MobileElement lessonPanel38;

	//@AndroidFindBy(id="com.tce.studi:id/plan_right_view")
	@AndroidFindBy(id="com.tce.studi:id/clActivePlan")
	public WebElement element44;

	//@AndroidFindBy(id="com.tce.studi:id/cl_intent")
	@AndroidFindBy(id="com.tce.studi:id/tv_intent_title")
	public WebElement object44;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.view.ViewGroup")
	public WebElement element52;

	@AndroidFindBy(xpath="//*[contains(@text, '1, 2021')]")
	public WebElement date1;

	@AndroidFindBy(id="com.tce.studi:id/header_bar_container")
	public WebElement bigIdeaHeading;

	@AndroidFindBy(id="com.tce.studi:id/tv_due")
	public List<MobileElement> pastLessons1;

	@AndroidFindBy(id="com.tce.studi:id/tv_date")
	public List<MobileElement> topicName;

	@AndroidFindBy(id="com.tce.studi:id/upcomingMainView")
	public List<MobileElement> mainView;

	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	//@iOSFindBy(id = "White 2")
	public WebElement backBtnTestUnit;

	//	@AndroidFindBy(id="com.tce.studi:id/tv_due")
	//	public List<MobileElement> pastLesson;


	// 1.Big Idea, 2.Revise, 3.Practice, 4.Summary, 5.Test
	//public String lessonType ="/android.widget.ImageView[2]";
	public String lessonType ="/android.widget.TextView[1]";	

	public String lessonStatus ="/android.view.ViewGroup/android.widget.ImageView[2]";


	public String lessonSubjectName = "android.view.ViewGroup/android.widget.TextView[3]";
	//@AndroidFindBy(id="com.tce.studi:id/tvSubjectName")
	//public WebElement lessonSubjectName;


	public String lessonDueDate="android.view.ViewGroup/android.widget.TextView[4]";

	//public String upcomingLessonsPanel = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView";
	public String upcomingLessonsPanel = "com.tce.studi:id/upcomingLayout";

	@AndroidFindBy(id="com.tce.studi:id/pausePlan")
	public WebElement pausePlan;

	@AndroidFindBy(id="com.tce.studi:id/txtPositiveBtn")
	public WebElement proceedButton;


	@AndroidFindBy(id="com.tce.studi:id/txtTopButto")
	public WebElement resumePlan;

	//@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select another plan\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtBottomButton")
	public WebElement selectAnotherPlanBtn;

	//	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	//	public WebElement backButton;

	public void traverse_toward_create_study_plan() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = testUnitModule.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}

		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(testUnitModule);

		status = studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}

		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(managePlanBtn);

		status = createStudyPlanBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create study plan Button displayed");
			test.log(Status.INFO, "Create study plan Button displayed");
		}

		sAss.assertAll();
	}

	// Started from Landing Page. Initian start on "Test Unit" button
	public void createPlan(String subject, String topic) throws MalformedURLException {
		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(managePlanBtn);

		applyExplicitWaitsUntilElementClickable(createStudyPlanBtn);
		applyExplicitWait(5);
		System.out.println("Clicking on Create Study Plans");
		test.log(Status.INFO, "Clicking on Create Study Plans");
		clickOnElement(createStudyPlanBtn);

		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic);
		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);

		Boolean status = Boolean.parseBoolean(driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
				.getAttribute("focused"));
		if (status) {
			subjectFlag.put(subject, true);
		} else {
			subjectFlag.put(subject, false);
		}

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");
		test.log(Status.INFO, "New plan created");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object_Create_Study_Plan temp = new Object_Create_Study_Plan();
		int j = 0;
		for (int k = 0; k < 4; k++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			applyExplicitWaitsUntilElementClickable(temp.topLessonStatus);
			clickOnElement(temp.topLessonStatus);
			applyExplicitWait(5);
			//clickOnElement(temp.markAsComplete);
			clickOnElement(findElementByText("Mark"));

		}

	}

	public void createPlan(String subject, String topic_1, String topic_2) throws Exception {
		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(managePlanBtn);

		applyExplicitWaitsUntilElementClickable(createStudyPlanBtn);
		System.out.println("Clicking on Create Study Plans");
		test.log(Status.INFO, "Clicking on Create Study Plans");
		clickOnElement(createStudyPlanBtn);

		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic_1);
		scrollTo2(topic_1);
		clickOnElement(findElementByText(topic_1));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		scrollTo1(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic_2);
		scrollTo2(topic_2);
		clickOnElement(findElementByText(topic_2));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Update portion"));

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);
//
//		Boolean status = Boolean.parseBoolean(driver.findElementByXPath(
//				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
//						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
//				.getAttribute("focused"));
//		
//		if (status) {
//			subjectFlag.put(subject, true);
//		} else {
//			subjectFlag.put(subject, false);
//		}

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");
		test.log(Status.INFO, "New plan created");
	}

	// one subject-->one topic list
	public void createPlan(String[] subjects, String[] topics) throws Exception {
		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(managePlanBtn);

		applyExplicitWaitsUntilElementClickable(createStudyPlanBtn);
		System.out.println("Clicking on Create Study Plans");
		test.log(Status.INFO, "Clicking on Create Study Plans");
		clickOnElement(createStudyPlanBtn);

		for (int i = 0; i < subjects.length; i++) {
			System.err.println("Clicked on " + subjects[i]);
			scrollTo2(subjects[i]);
			clickOnElement(findElementByText(subjects[i]));

			System.err.println("Clicked on " + topics[i]);
			scrollTo2(topics[i]);
			clickOnElement(findElementByText(topics[i]));

			applyExplicitWait(5);
			try {
				clickOnElement(findElementByText("Add to portion"));
			} catch (Exception e) {
				clickOnElement(findElementByText("Update portion"));
			}
			applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		}

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWait(5);
		action = new TouchAction(driver);
		for (int i = 0; i < subjects.length; i++) {
			Boolean status = Boolean.parseBoolean(driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
							+ (i + 1)
							+ "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
					.getAttribute("focused"));
			if (status) {
				subjectFlag.put(subjects[i], true);
			} else {
				subjectFlag.put(subjects[i], false);
			}
			action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
			.moveTo(PointOption.point(115, 550)).release().perform();
		}
		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");
		test.log(Status.INFO, "New plan created");

	}

	public String getUpcommingLesson(int i) {
		return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+(i+1)+"]";
	}

	//Flag the Subject
	public void createPlan(String subject, String topic, boolean flag) throws MalformedURLException {
		scrollTo1("Manage and Create Plans");

		System.out.println("Clicking on Manage and Create Plans");
		test.log(Status.INFO, "Clicking on Manage and Create Plans");
		clickOnElement(managePlanBtn);

		applyExplicitWaitsUntilElementClickable(createStudyPlanBtn);
		System.out.println("Clicking on Create Study Plans");
		test.log(Status.INFO, "Clicking on Create Study Plans");
		clickOnElement(createStudyPlanBtn);

		System.err.println("Clicked on " + subject);
		scrollTo2(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic);
		scrollTo2(topic);
		clickOnElement(findElementByText(topic));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWait(5);

		action = new TouchAction(driver);

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button").click();

		applyExplicitWait(5);

		Boolean status = Boolean.parseBoolean(driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
				.getAttribute("focused"));
		if (status) {
			subjectFlag.put(subject, true);
		} else {
			subjectFlag.put(subject, false);
		}

		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);
		applyExplicitWaitsUntilElementClickable(nextStepBtn);
		clickOnElement(nextStepBtn);

		applyExplicitWaitsUntilElementClickable(findElementByText("Activate Plan"));
		applyExplicitWait(5);
		clickOnElement(findElementByText("Activate Plan"));
		clickOnElement(findElementByText("Begin Studying"));

		System.out.println("New plan created");
		test.log(Status.INFO, "New plan created");


		Object_Create_Study_Plan temp = new Object_Create_Study_Plan();
		int j = 0;
		for (int k = 0; k < 4; k++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			applyExplicitWaitsUntilElementClickable(temp.topLessonStatus);
			clickOnElement(temp.topLessonStatus);
			applyExplicitWait(5);
			//clickOnElement(temp.markAsComplete);
			clickOnElement(findElementByText("Mark"));

		}


	}

	public WebElement getFlagIcon() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View["
						+ 1 + "]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button");

	}


	public int getTaskCountForUpcomingPlan() {
		String msg=taskCountInUpcoming.getText();
		String[] sep=msg.split(" ");
		int count=Integer.parseInt(sep[0]);
		return count;
	}

	public MobileElement getDate(int days) {
		MobileElement date1=getDriver().findElement(By.xpath("//*[contains(@text, '"+days+", 2021')]"));
		return date1;
	}
}
