package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Assignment_Listing extends BaseClass {
	public Object_Assignment_Listing() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Assignment\")")
	public WebElement assignment;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/header\").textContains(\"Today\")")
	public WebElement today;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/header\").textContains(\"Upcoming\")")
	public WebElement upcoming;

	@AndroidFindBy(id="com.tce.studi:id/viewCompletedAssignment")
	public WebElement completed;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/dueDate\").textContains(\"Completed On\")")
	public WebElement completedDate;

	@AndroidFindBy(id="com.tce.studi:id/subHeading")
	public WebElement due_resource;

	@AndroidFindBy(id="com.tce.studi:id/fabAssignment")
	public WebElement add_assignment;

	@AndroidFindBy(id="com.tce.studi:id/tvIntentHeading")
	public WebElement intent_Creation;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/subHeading\").textContains(\"assignments due\")")
	public WebElement Todays_assignments;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/subHeading\").textContains(\"assignments scheduled\")")
	public WebElement upcomig_assignments;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Digital Test\")")
	public WebElement digital_tets;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Task\")")
	public WebElement task;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Next\")")
	public WebElement next1;

	@AndroidFindBy(id="com.tce.studi:id/tvAssign")
	public WebElement assignTask;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrimaryAction")
	public WebElement primaryAction;

	@AndroidFindBy(id ="com.tce.studi:id/tvNew")
	public WebElement new_icon;

	@AndroidFindBy(id ="com.tce.studi:id/iv_left_icon")
	public WebElement back_btn;

	@AndroidFindBy(id="com.tce.studi:id/dueDate")
	public WebElement due_date;

	@AndroidFindBy(id="com.tce.studi:id/overdue")
	public WebElement over_due;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvOverdue\").textContains(\"days\")")
	public WebElement extra_days;

	@AndroidFindBy(id="com.tce.studi:id/linearListBg")
	public List<MobileElement> list_bag;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvTitle\").textContains(\"Digital Test is Ready!\")")
	public WebElement notification;

	@AndroidFindBy(id="com.tce.studi:id/txtNegativeBtn")
	public WebElement hideReport;
	@AndroidFindBy(id="com.tce.studi:id/listAttachment")
	public WebElement attachmentIcon;

	@AndroidFindBy(id="com.tce.studi:id/listTitle")
	public WebElement assignmentTitle;

	@AndroidFindBy(id="com.tce.studi:id/etTitle")
	public WebElement taskTitle;

	@AndroidFindBy(id="com.tce.studi:id/etInstructions")
	public WebElement taskInstruction;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Assign\")")
	public WebElement assign;

	@AndroidFindBy(id="com.tce.studi:id/listTime")
	public WebElement duration;

	@AndroidFindBy(id="com.tce.studi:id/imgGallery")
	public WebElement imgGallery;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"android:id/text1\").textContains(\"Camera\")")
	public WebElement cameraAttachment;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView")
	public WebElement gallery_Attachment;

	@AndroidFindBy(id="com.android.camera2:id/shutter_button")
	public WebElement clickCamera;


	@AndroidFindBy(id="com.android.camera2:id/done_button")
	public WebElement attachmentDone;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@AndroidFindBy(id="com.sec.android.gallery3d:id/thumbnail")
	public WebElement img_from_gallery;

	@AndroidFindBy(id="com.tce.studi:id/txtMediaFileName")
	public WebElement img_media_name;

	@AndroidFindBy(id="com.tce.studi:id/showMore")
	public WebElement show_more;

}
