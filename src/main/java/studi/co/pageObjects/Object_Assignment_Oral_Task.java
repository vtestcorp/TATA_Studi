package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Assignment_Oral_Task extends BaseClass {
	public Object_Assignment_Oral_Task() {
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

	//@AndroidFindBy(uiAutomator="new UiSelector().class(\"android.widget.TextView\").textContains(\"Create an oral test\")")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement oral_Test_Heading;

	@AndroidFindBy(id ="com.tce.studi:id/tvNextStep")
	public WebElement next1 ;

	@AndroidFindBy(id ="com.tce.studi:id/tvNextStep")
	public WebElement start_Test ;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrimaryAction")
	public WebElement begin_Test ;
}
