package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Quiz_Practise extends BaseClass {
	public Object_Quiz_Practise() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Syllabus\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plan: Test Unit\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;
	
	@iOSFindBy(id = "WebviewQuiz")
	@AndroidFindBy(id ="com.tce.studi:id/layoutQuiz")
	public WebElement question;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I'll attempt later\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvSecondaryAction")
	public WebElement attempt_later;
   
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Check Answer\"]")
	@AndroidFindBy(xpath ="com.tce.studi:id/tvPrimaryAction")
	public WebElement check_answer;
	
	@iOSFindBy(id = "Uh-oh! Give it another shot!")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Uh-oh! Give it another shot!\")")
	public WebElement answerWrongMsg;
	
	@iOSFindBy(id = "You have one attempt left")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"attempt left\")")
	public WebElement attemptLeftsMsg;
	
	@iOSFindBy(id = "Retry")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement tryAgain;
	
	@iOSFindBy(id = "Great job! Let's continue.")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Great job! Let's continue.\")" )
	public WebElement answerCorrectMsg1;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement conti_nue;
	
	@AndroidFindBy(id ="com.tce.studi:id/iv_right_action_primary")
	public WebElement skip;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"nextBtn\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextButton;
	
	public int get_Total_Number_Of_Questions_InRevision() {
		if (device.equalsIgnoreCase("Android"))
			return getDriver().findElementsByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView").size();
		else {
			MobileElement ele=driver.findElementByXPath("//*[@type=\"XCUIElementTypePageIndicator\"]");

			String temp[] = ele.getAttribute("value").split(" ");
			int temp1=Integer.parseInt(temp[temp.length-1]);
			System.err.println("que1 :"+ele.getAttribute("value"));
			return temp1;
		}
	}

}
