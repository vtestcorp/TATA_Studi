package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Assignment_Task extends BaseClass {

	public Object_Assignment_Task () {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.tce.studi:id/ivProfile")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Assignment\")")
	public WebElement assignment;

	@AndroidFindBy(id ="com.tce.studi:id/assignmentViewed")
	public WebElement assignmentViewed;

	@AndroidFindBy(id ="com.tce.studi:id/markAsCompleted")
	public WebElement markAsCompleted;

	@AndroidFindBy(id ="com.tce.studi:id/deleteIntent")
	public WebElement deleteTask;

	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement enterTaskDetails;
	
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	public WebElement myAssignments;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/txtTitle\").textContains(\"Are you sure you want to discard?\")")
	public WebElement deletePopup;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/txtPositiveBtn\").textContains(\"Yes,Please discard\")")
	public WebElement discardBtn;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/txtNegativeBtn\").textContains(\"Take me back\")")
	public WebElement takeBack;

	@AndroidFindBy(id ="com.tce.studi:id/btnFive")
	public WebElement taskDuration;	

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvType\").textContains(\"Task\")")
	public WebElement createdTask;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/header\").textContains(\"Today\")")
	public WebElement today;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvDetails\").textContains(\"Assignment Details\")")
	public WebElement assignmentDetails;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement closeTaskDetails;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/header\").textContains(\"Upcoming\")")
	public WebElement upcoming;

	@AndroidFindBy(id="com.tce.studi:id/viewCompletedAssignment")
	public WebElement completed;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/dueDate\").textContains(\"Completed On\")")
	public WebElement completedDate;

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
	//title with error message same id

	@AndroidFindBy(id="com.tce.studi:id/etInstructions")
	public WebElement taskInstruction;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvNextStep\").textContains(\"Assign\")")
	public WebElement assign;

	@AndroidFindBy(id="com.tce.studi:id/listTime")
	public WebElement duration;

	@AndroidFindBy(id="	com.tce.studi:id/imgGallery")
	public WebElement imgGallery;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"android:id/text1\").textContains(\"Camera\")")
	public WebElement cameraAttachment;

	@AndroidFindBy(id="com.android.camera2:id/shutter_button")
	public WebElement clickCamera;

	@AndroidFindBy(id="com.android.camera2:id/done_button")
	public WebElement attachmentDone;

	@AndroidFindBy(id="com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

}
