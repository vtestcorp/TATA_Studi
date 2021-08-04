package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Browsebook_Chapter_Listing extends BaseClass {
	public Object_Browsebook_Chapter_Listing() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	@AndroidFindBy(id="com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@AndroidFindBy(id="com.tce.studi:id/tvName")
	public WebElement userName;
	
	@AndroidFindBy(id="com.tce.studi:id/headerBarContainer")
	public MobileElement subjectHeading;

	@AndroidFindBy(id="com.tce.studi:id/tvChapter")
	public MobileElement chapterHeading;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;
	
	@AndroidFindBy(uiAutomator="new UiSelector().class(\"android.widget.TextView\").textContains(\"All Subjects\")")
	public WebElement all_Subjects;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvCS\").textContains(\"Completed in School\")")
	public WebElement completedInSchool;

	@AndroidFindBy(id="com.tce.studi:id/tv_grade")
	public WebElement grade;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement syllabusSectionHeading;
	
	
	@AndroidFindBy(id="com.tce.studi:id/tv_book_name")
	public WebElement book_name;
	

	@AndroidFindBy(id="com.tce.studi:id/clTopic")
	public List<MobileElement> topics;

	@AndroidFindBy(id="com.tce.studi:id/tvTopic")
	public WebElement topic_for;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvLesson\").textContains(\"Begin Revision\")")
	public WebElement revision;
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvPrimaryAction\").textContains(\"Begin Revision\")")
	public WebElement revision1;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvLesson\").textContains(\"Begin Practice\")")
	public WebElement practice;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvLesson\").textContains(\"Begin Practice\")")
	public WebElement practic1;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvLesson\").textContains(\"Notes\")")
	public WebElement notes;

}



