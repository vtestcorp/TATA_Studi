package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_MyLesson_Page extends BaseClass{

	public Object_MyLesson_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(id="com.tce.studi:id/tvName")
	public WebElement userName;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
	public WebElement test_unit;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement planTestUnit;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement menuIcon;

	@AndroidFindBy(id="com.tce.studi:id/outer_ring")	
	public WebElement studyRing;

	@AndroidFindBy(id="com.tce.studi:id/inner_ring")
	public WebElement innerRing;  //Reward(Stars)

	@AndroidFindBy(id="com.tce.studi:id/middle_ring")
	public WebElement middleRing;  //Lesson

	@AndroidFindBy(id="com.tce.studi:id/outer_ring") 
	public WebElement outerRing;  //Time

	@AndroidFindBy(id="com.tce.studi:id/tv_almost_here_desc")
	public WebElement taskToBeCompletedToday;

	@AndroidFindBy(id="com.tce.studi:id/imgOverflow") 
	public WebElement kebabMenu;

	public String topicName1="com.tce.studi:id/tv_date";

	@AndroidFindBy(id="com.tce.studi:id/title")
	public WebElement markAsComplete;

	@AndroidFindBy(id="com.tce.studi:id/tv_due_today")
	public WebElement taskCompleted;

	@AndroidFindBy(id="com.tce.studi:id/tick")
	public WebElement tick;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[2]")
	public WebElement backicon;

	@AndroidFindBy(id="com.tce.studi:id/tv_header_today")
	public WebElement todayTab;

	@AndroidFindBy(id="com.tce.studi:id/tv_due_today")
	public WebElement todaysCount;

	@AndroidFindBy(id="com.tce.studi:id/completed")
	public WebElement completedLessons;

	@AndroidFindBy(id="com.tce.studi:id/tv_upcoming")
	public WebElement upcomingTab;

	@ AndroidFindBy(id="com.tce.studi:id/upcoming_main_view")
	public List <MobileElement> topicsInUpcoming;

	@AndroidFindBy(id="com.tce.studi:id/tv_topic")
	public WebElement topicName;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	//@AndroidFindBy(xpath="com.tce.studi:id/tvTopic")
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvTopic\").textContains(\"Aspects and Influence of Diversity\")")
	public WebElement topic;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[3]")
	public WebElement topic1;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[3]")
	public WebElement topic2;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	public WebElement topicSchedule;

	@AndroidFindBy(id="com.tce.studi:id/list_title")
	public WebElement topicSchedule1;

	@AndroidFindBy(id="com.tce.studi:id/tv_subject_name")
	public WebElement subjectName;

	//	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	//	public WebElement topicPageHeading;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]")
	public WebElement topicPageHeading;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	public WebElement topicPageHeading1;

	//	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	//	public WebElement topicPageHeading2;




	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backIcon;

	@AndroidFindBy(id="com.tce.studi:id/view_schedule")
	public WebElement viewFullSchedule;

	@AndroidFindBy(id="com.tce.studi:id/locked")
	public List<MobileElement> lockedList;

	@AndroidFindBy(id="com.tce.studi:id/img_overflow")
	public List<MobileElement> unlockedList;

	@AndroidFindBy(id="com.tce.studi:id/imgFilter")
	public WebElement imagefilterScheduldePage;

	@AndroidFindBy(	xpath="//android.widget.TextView[@text='Aspects and Influence of Diversity']")
	public WebElement aspectsAndInfluence;

	@AndroidFindBy(id="com.tce.studi:id/tv_create_plan")
	public WebElement createStudyplan;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
	public WebElement fullSchedule;

	@AndroidFindBy(id="com.tce.studi:id/list_title")
	public List<MobileElement> listOfLessons;

	@AndroidFindBy(id="com.tce.studi:id/tv_days")
	public WebElement datesTab;

	@AndroidFindBy(id="com.tce.studi:id/img_next")
	public WebElement nextWeek;

	@AndroidFindBy(id="com.tce.studi:id/tvWeek") 	
	public WebElement weeks;

	@AndroidFindBy(id="com.tce.studi:id/locked")
	public List<MobileElement> lockedList1;

	@AndroidFindBy(id="com.tce.studi:id/img_overflow")
	public List<MobileElement> unlockedList1;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup")
	public List<MobileElement> subjects;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup")
	public List<MobileElement> lessonStatus1;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup")
	public List<MobileElement> lessonStatus2;

	@AndroidFindBy(id="com.tce.studi:id/tv_type")
	public List<MobileElement> lessonType;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup")

	@AndroidFindBy(id="com.tce.studi:id/cl_data")
	public WebElement highLightedLesson;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup")
	public WebElement highLightedLesson1;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.ImageView[2]")
	public WebElement subject36;

	@AndroidFindBy(id="com.tce.studi:id/imgFilter") 
	public WebElement filter;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement filterHeading;

	@AndroidFindBy(id="com.tce.studi:id/tv_subjects")
	public WebElement filterSubject;

	@AndroidFindBy(id="com.tce.studi:id/tv_lesson_type")
	public WebElement filterLessonType;

	@AndroidFindBy(id="com.tce.studi:id/tv_lesson_status")
	public WebElement filterLessonStatus;

	@AndroidFindBy(id="com.tce.studi:id/tv_manage_plans")
	public WebElement manageAndCreatePlan;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement myStudyPlan;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement practice;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]")
	//@AndroidFindBy(id="com.tce.studi:id/layoutQuiz")
	public WebElement quetionText;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backButton;

	@AndroidFindBy(id="com.tce.studi:id/txtPositiveBtn")
	public WebElement yesButton;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement practiceGeography;

	@AndroidFindBy(id="com.tce.studi:id/tv_objective")
	public MobileElement objective;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement practicePoliticalScience;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement practiceUpcoming;

	@AndroidFindBy(xpath="//tce-scq")
	public WebElement colour;

	@AndroidFindBy(id="com.tce.studi:id/tv_subject_name")
	public WebElement subject;

	@AndroidFindBy(id="com.tce.studi:id/locked")
	public WebElement locked;

	@AndroidFindBy(id="com.tce.studi:id/img_overflow")
	public WebElement unlocked;

	@AndroidFindBy(id="com.tce.studi:id/img_overflow")
	public WebElement lessonStatus;

	@AndroidFindBy(id="com.tce.studi:id/tv_chapter_type")
	public WebElement typeOfLesson;

	@AndroidFindBy(id="com.tce.studi:id/main_view_today")
	public List<MobileElement> todayList;

	@AndroidFindBy(id="com.tce.studi:id/upcoming_main_view")
	public List<MobileElement> upcomingList;

	@AndroidFindBy(id="com.tce.studi:id/tvActivePlan")
	public WebElement activePlan;

	@AndroidFindBy(id="com.tce.studi:id/tvOthersPlan")
	public WebElement otherPlans;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.ImageView[2]")
	public WebElement revise;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup")
	@AndroidFindBy(id="com.tce.studi:id/clActivePlan")
	public WebElement detailsOfActivePlan;

	@AndroidFindBy(id="com.tce.studi:id/tv_plan_name")
	public List<MobileElement> otherPlan;

	@AndroidFindBy(id="com.tce.studi:id/tvCreatePlan")
	public WebElement createAStudyPlan;

	@AndroidFindBy(id="com.tce.studi:id/tv_apply")
	public WebElement applyButton;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
	@AndroidFindBy(id="com.tce.studi:id/clActivePlan")
	public WebElement testPlan;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
	@AndroidFindBy(id="com.tce.studi:id/tvPlanName")
	public WebElement testUnit;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement testPlanHeading;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
	public List<MobileElement> lessons;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement testPlanHeading1;

	@AndroidFindBy(id="com.tce.studi:id/fabEditStudyPlan")	
	public WebElement editButton;

	@AndroidFindBy(id= "com.tce.studi:id/tv_intent_title")
	public WebElement activatePlanButton;

	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]")
	@AndroidFindBy(id="com.tce.studi:id/quiz_web_view")
	public WebElement subjectAtCreatePlan;
	
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement testUnitHeading;


	@AndroidBy(xpath="tce.studi:id/tvPrimaryAction")
	public WebElement Begin_Practice;


}
