package studi.co.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Receive_Questions_Revision extends BaseClass {

	@iOSFindBy(id = "WebviewQuiz")
	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	public WebElement question;
	
	@iOSFindBy(id = "backWithBackground")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\")")
	public WebElement backBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/ib_create_note\")")
	public WebElement addNotesBtn;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestPopup;
	
	@iOSFindBy(id = "ic closs blue")
	@AndroidFindBy(id = "android:id/content")
	public WebElement exitPopup;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Syllabus\")")
	public WebElement syllabus;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout")
	public WebElement linearDots;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.Button")
	// @AndroidFindBy(xpath = "//[contains(text(),'Check Answer')]")
	public WebElement checkAnswer;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"nextBtn\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextButton;

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"previousBtn\"]")
	@AndroidFindBy(id = "com.tce.studi:id/ivPrevious")
	public WebElement prvsButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
	public WebElement popUpYes;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
	public WebElement popUpNo;

	@AndroidFindBy(id = "com.tce.studi:id/tv_lets_summarise")
	public WebElement letsSummriseTxt;

	



	public Object_Receive_Questions_Revision() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

	}

	public int get_Total_Number_Of_Questions_InRevision() {
		if (device == "Android")
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
