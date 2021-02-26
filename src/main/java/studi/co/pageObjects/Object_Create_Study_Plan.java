package studi.co.pageObjects;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup");
		expectedLessonOrder.put("Revise",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup");
		expectedLessonOrder.put("Practice",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup");
		expectedLessonOrder.put("Summary",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup");
		expectedLessonOrder.put("Test",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup");

		upcomingLesson.put("Big Idea",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
		upcomingLesson.put("Revise",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
		upcomingLesson.put("Practice",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
		upcomingLesson.put("Summary",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]");
		upcomingLesson.put("Test",
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]");

		subjectFlag.put("", false);
		
	}

	@AndroidFindBy(id = "com.tce.studi:id/profilePic")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").index(1)")
	public WebElement testUnitModule;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabusUnitModule;
	
	// + button in syllabus module
	@FindBy(id = "com.tce.studi:id/fab_assignment")
	public WebElement assignBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Study Plan\")")
	public WebElement studyPlanSyl;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Create Study Plan\")")
	public WebElement studyPlanTab;

	@AndroidFindBy(id = "com.tce.studi:id/study_layout")
	public WebElement studyLayout;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Paused\").resourceId(\"com.tce.studi:id/tvSubHeading\")")
	public WebElement testPauselbl;

	@FindBy(id = "com.tce.studi:id/tv_manage_plans")
	public WebElement managePlanBtn;

	@FindBy(id = "com.tce.studi:id/tv_create_plan")
	public WebElement createStudyPlanBtn;
	
	@FindBy(id = "com.tce.studi:id/fab_edit")
	public WebElement editPlan;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Next Step\")")
	public WebElement nextStepBtn;

	@FindBy(id = "com.tce.studi:id/tv_coming_soon")
	public WebElement taskCountInUpcoming;
	
	public Map<String, String> expectedLessonOrder = new LinkedHashMap<String, String>();
	public Map<String, String> upcomingLesson = new LinkedHashMap<String, String>();
	public Map<String, Boolean> subjectFlag = new HashMap<String, Boolean>();

	@FindBy(id = "com.tce.studi:id/img_overflow")
	public WebElement topLessonStatus;

	@FindBy(id = "com.tce.studi:id/title")
	public WebElement markAsComplete;
	
	@FindBy(id = "com.tce.studi:id/recycler_today")
	public WebElement todaysLessonPanel;
	
	@FindBy(id = "com.tce.studi:id/view_schedule")
	public WebElement viewFullScheduleBtn;
	
	@FindBy(id = "com.tce.studi:id/search_id")
	public WebElement fullScheduleLbl;
	
	@AndroidFindBy(id = "com.tce.studi:id/recycler_full_schedule")
	public MobileElement fullscedulerecyclere;

	// 1.Big Idea, 2.Revise, 3.Practice, 4.Summary, 5.Test
	public String lessonType = "/android.view.ViewGroup/android.widget.TextView[1]";
	public String lessonStatus = "/android.view.ViewGroup/android.widget.ImageView[2]";
	public String lessonSubjectName = "/android.widget.TextView";
	public String lessonDueDate="/android.view.ViewGroup/android.widget.TextView[5]";

	public String upcomingLessonsPanel = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView";

	public void traverse_toward_create_study_plan() throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
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

	}

	public void createPlan(String subject, String topic1, String topic2) throws Exception {
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

		System.err.println("Clicked on " + topic1);
		scrollTo2(topic1);
		clickOnElement(findElementByText(topic1));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Add to portion"));

		applyExplicitWaitsUntilElementClickable(findElementByText("Next Step"));
		scrollTo1(subject);
		clickOnElement(findElementByText(subject));

		System.err.println("Clicked on " + topic2);
		scrollTo2(topic2);
		clickOnElement(findElementByText(topic2));

		applyExplicitWait(5);
		clickOnElement(findElementByText("Update portion"));

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
}
