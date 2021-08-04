package studi.co.pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import studi.co.Base.BaseClass;

public class Object_StudyPlan_ScheduledPlanView extends BaseClass {
	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(id="com.tce.studi:id/tvName")
	public WebElement userName;

	@AndroidFindBy(uiAutomator ="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement test_unit;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement planTestUnit;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
	public WebElement fullSchedule;

	@AndroidFindBy(id="com.tce.studi:id/imgFilter") 
	public WebElement filter;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backIcon;

	@AndroidFindBy(id="com.tce.studi:id/viewSchedule")
	public WebElement viewFullSchedule;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement filterHeading;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[2]")
	public WebElement sub_checked;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().resourceId(\"com.tce.studi:id/tvChapterStatus\").textContains(\"Did not study\")")
	public WebElement not_studied;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().resourceId(\"com.tce.studi:id/tvChapterStatus\").textContains(\"plan not started\")")
	public WebElement not_started;

	
	@AndroidFindBy(uiAutomator ="new UiSelector().resourceId(\"com.tce.studi:id/tvChapterStatus\").textContains(\"plan not started\")")
	public WebElement no_scheduled;

}
