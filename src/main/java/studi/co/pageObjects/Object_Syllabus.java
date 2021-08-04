package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Syllabus extends BaseClass{

	public Object_Syllabus() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Syllabus\"]")
	public WebElement syllabus; 

	@AndroidFindBy(id="com.tce.studi:id/tvName")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Syllabus\"]")
	public WebElement userName;

	@AndroidFindBy(id = "com.tce.studi:id/header_bar_container")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Syllabus\"]")
	public WebElement syllabusSectionHeading;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Class 6\"])[1]")
	@AndroidFindBy(id="com.tce.studi:id/tv_grade")
	public WebElement grade;
	
	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Class 6\"])[1]")
	public WebElement profilePic;

	@iOSFindBy(xpath ="//XCUIElementTypeButton[@name=\"intentCreationButton\"]")
	@AndroidFindBy(id="com.tce.studi:id/fab_assignment")
	public WebElement editButton;

	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Assign\"]")
	@AndroidFindBy(id="com.tce.studi:id/tvIntentHeading")
	public WebElement assign;

	@iOSFindBy(xpath ="//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
	@AndroidFindBy(id="com.tce.studi:id/img_confidence_id")
	public WebElement status;
	
	@iOSFindBy(xpath ="//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
	@AndroidFindBy(id="com.tce.studi:id/ivConfidence")	
	public WebElement target;
	
	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"On the banks of which river did the earliest people live in the Indian Subcontinent?\"]")
	@AndroidFindBy(id ="com.tce.studi:id/layoutQuiz")
	public WebElement question1_part_Text;

	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"1 of 5\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionNumber")
	public WebElement quetionCount;

	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"You’ve got it!\"]")
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.view.View")
	public WebElement right_Answer_message;
	
	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Completed in school\"]")
	@AndroidFindBy(id="com.tce.studi:id/ivCSToggle")
	public WebElement completedInSchool;

	@iOSFindBy(xpath ="//XCUIElementTypeButton[@name=\"tertiaryBtn\"]")
	@AndroidFindBy(id="com.tce.studi:id/ivTertiaryAction")
	public WebElement hamBurgerMenu;
	
	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Return to Subject\"]")
	@AndroidFindBy(id="com.tce.studi:id/title")
	public WebElement returnTitle;
	
	@iOSFindBy(xpath ="//(//XCUIElementTypeStaticText[@name=\"Exclude from syllabus\"])[3]")
	@AndroidFindBy(id="com.tce.studi:id/ivESToggle")
	public WebElement excludeFromSyllabus;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.ImageView[1]")
	public WebElement statusOfChapter;

	@iOSFindBy(xpath ="//XCUIElementTypeButton[@name=\"backWithBackground\"]")
	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backButton;

	@AndroidFindBy(id="com.tce.studi:id/tv_book_name")
	public List<MobileElement> books;

	@AndroidFindBy(xpath="//*[contains(@text, '1. The Earth in the Solar System')]/parent::*/following-sibling::androidx.recyclerview.widget.RecyclerView")
	public MobileElement lessonPanel08;

	@AndroidFindBy(id="com.tce.studi:id/tv_book_name")
	public List<MobileElement> lessons08;

	@AndroidFindBy(xpath="//*[contains(@text, '1. The Earth in the Solar System')]/parent::*/following-sibling::androidx.recyclerview.widget.RecyclerView")
	public MobileElement lessonPanel12;
	
	@iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"History\"]")
	@AndroidFindBy(id="com.tce.studi:id/headerBarContainer")
	public MobileElement subjectHeading;

	@iOSFindBy(xpath ="//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
	@AndroidFindBy(id="com.tce.studi:id/tvConfidence")
	public WebElement confidence_status;





}
