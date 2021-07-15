package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Syllabus_Intent_Creation extends BaseClass {
	public Object_Syllabus_Intent_Creation() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@AndroidFindBy(id="com.tce.studi:id/tv_book_name")
	public List<MobileElement> list_Books;

	@AndroidFindBy(id="com.tce.studi:id/tvChapter")
	public List<MobileElement> list_chapters;

	@AndroidFindBy(id="com.tce.studi:id/tvTopic")
	public List<MobileElement> list_topics;

	@AndroidFindBy(id="com.tce.studi:id/fab_assignment")
	public WebElement add_assignment;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Digital Test\")")
	public WebElement digital_tets;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvIntentHeading\").textContains(\"Assign\")")
	public WebElement assign_Heading;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Assign a digital test\")")
	public WebElement assign_heading_OnBookShelf;


	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvAssignDigitalTest\").textContains(\"Enter test details\")")
	public WebElement enter_test_details;

	@AndroidFindBy(id="com.tce.studi:id/helpSwitch")
	public WebElement help;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/helpSwitch\").textContains(\"ON\")")
	public WebElement help_ON;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/helpSwitch\").textContains(\"OFF\")")
	public WebElement help_OFF;

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

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvTitle\").textContains(\"Digital Test is Ready!\")")
	public WebElement notification;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Next\")")
	public WebElement next;

	@AndroidFindBy(id ="com.tce.studi:id/imgDeleteSheet")
	public WebElement delete_test ;

	@AndroidFindBy(id ="com.tce.studi:id/txtPositiveBtn")
	public WebElement please_Discard ;

	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement take_me_Back ;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/txtTitle\").textContains(\"Are you sure you want to discard?\")")
	public WebElement dlt_Confirmation;

	@AndroidFindBy(id ="com.tce.studi:id/tvChapter")
	public WebElement chapter ;

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

	@AndroidFindBy(id ="com.tce.studi:id/tvDueDateSpinner")
	public WebElement select_Date;
	
	@AndroidFindBy(xpath="//*[contains(@text, '1, 2021')]")
	public WebElement date1;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Next month\"]")
	public WebElement nextMonthButton;
	
	
	public void create_test_changeDate(int day) throws Exception {
	}
}
