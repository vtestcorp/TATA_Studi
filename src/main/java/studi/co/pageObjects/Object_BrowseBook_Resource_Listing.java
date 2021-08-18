package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_BrowseBook_Resource_Listing extends BaseClass {
	public Object_BrowseBook_Resource_Listing() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	//@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	public WebElement syllabus; 

	@AndroidFindBy(id="com.tce.studi:id/tvName")
	public WebElement userName;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement syllabusSectionHeading;

	@AndroidFindBy(id="com.tce.studi:id/tv_grade")
	public WebElement grade;

	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(id="com.tce.studi:id/img_confidence_id")
	public WebElement status;

	@AndroidFindBy(id="com.tce.studi:id/ivConfidence")	
	public WebElement target;

	@AndroidFindBy(id="com.tce.studi:id/tv_book_name")
	public List<MobileElement> books;

	@AndroidFindBy(id="com.tce.studi:id/headerBarContainer")
	public MobileElement subjectHeading;

	@AndroidFindBy(id="com.tce.studi:id/ivTopic")
	public MobileElement initial_status;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement question1_part_Text;

	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionNumber")
	public WebElement quetionCount;
	
	@AndroidFindBy(id="com.tce.studi:id/ivCSToggle")
	public WebElement completedInSchool;

	@AndroidFindBy(id="com.tce.studi:id/ivTertiaryAction")
	public WebElement hamBurgerMenu;

	@AndroidFindBy(id="com.tce.studi:id/title")
	public WebElement returnTitle;

	@AndroidFindBy(id="com.tce.studi:id/ivESToggle")
	public WebElement excludeFromSyllabus;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.ImageView[1]")
	public WebElement statusOfChapter;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backButton;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.view.View")
	public WebElement right_Answer_message;
	
	@AndroidFindBy(id="com.tce.studi:id/tvConfidence")
	public WebElement confidence_status;


}
