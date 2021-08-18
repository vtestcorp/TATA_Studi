package studi.co.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;


public class Object_Syllabus_BrowseBook extends BaseClass {

	public Object_Syllabus_BrowseBook() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Syllabus\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plan: Test Unit\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;
	
	@AndroidFindBy(id = "com.tce.studi:id/ivESToggle")
	public WebElement exclude_From_Syllabus_Switch;

	@AndroidFindBy(id = "com.tce.studi:id/ivCSToggle")
	public WebElement completed_In_School_Switch;

	@AndroidFindBy(id = "com.tce.studi:id/iv_right_action_primary")
	public WebElement skip;
	
	@AndroidFindBy(id ="com.tce.studi:id/layoutQuiz")
	public WebElement question;

	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement primaryAction;
	
	@iOSFindBy(id = "backWithBackground")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\")")
	public WebElement backBtn;

	@AndroidFindBy(id = "com.tce.studi:id/fab_assignment")
	public WebElement assignmentButton;

}
