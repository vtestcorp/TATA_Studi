package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Syllabus_Notes_Listing extends BaseClass {
	public Object_Syllabus_Notes_Listing() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	//@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	public WebElement syllabus;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/ib_create_note\")")
	public WebElement addNotesBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\").index(0)")
	public WebElement hamburgerBtn;

	@AndroidFindBy(id = "com.tce.studi:id/etNotes")
	public WebElement noteTxtArea;

	@AndroidFindBy(id = "com.tce.studi:id/tvSaveNote")
	public WebElement saveNoteBtn;

	@AndroidFindBy(id ="com.tce.studi:id/ib_create_note")
	public WebElement create_note;

	@AndroidFindBy(id = "com.tce.studi:id/tvDiscard")
	public WebElement discardNoteBtn;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\").index(0)")
	public WebElement backBtn;

	@AndroidFindBy(id = "com.tce.studi:id/ivDeleteNote")
	public WebElement delete_icon;

	@AndroidFindBy(id = "com.tce.studi:id/ivEditNote")
	public WebElement edit_icon;

	@AndroidFindBy(id = "com.tce.studi:id/tvDuration")
	public WebElement note_duration;

	@AndroidFindBy(id = "com.tce.studi:id/tvNoteLocation")
	public WebElement to_note_location;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvLesson\").textContains(\"Notes\")")
	public WebElement notes_list;
	//@AndroidFindBy(id = "com.tce.studi:id/tvNote")

	@AndroidFindBy(id ="com.tce.studi:id/clScrollableView")
	public WebElement note_address;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_ffwd\").className(\"android.widget.ImageButton\")")
	public WebElement fwdBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtTitle\").textContains(\"Are you sure you want to delete this note?\")")
	public WebElement dlt_warning_msg;


	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtPositiveBtn\").textContains(\"Delete Note\")")
	public WebElement dlt_note;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtNegativeBtn\").textContains(\"Return to Note\")")
	public WebElement return_to_note;


	@AndroidFindBy(id ="com.tce.studi:id/etNotes")
	public WebElement notes_container;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvSaveNote\").textContains(\"Updating TATA Test@1\")")
	public WebElement update_note;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvSaveNote\").textContains(\"Update Note\")")
	public WebElement update_note_final;
}

