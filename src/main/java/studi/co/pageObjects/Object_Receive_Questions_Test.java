package studi.co.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Receive_Questions_Test extends BaseClass {



	public Object_Receive_Questions_Test() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnit;

	@AndroidFindBy(id = "com.tce.studi:id/ivNext")
	public WebElement nextBtn;

	@AndroidFindBy(id ="com.tce.studi:id/tvPrimaryAction")
	public WebElement checkAns;

	@AndroidFindBy(id = "com.tce.studi:id/ivPrevious")
	public WebElement previousBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/iv_left_icon\").index(0)")
	public WebElement hamburgerBtn;

	
	
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]")
	@AndroidFindBy(id = "com.tce.studi:id/layoutQuiz")
	public WebElement question;

	@AndroidFindBy(id ="com.tce.studi:id/tvSubmitTest")
	public WebElement submitTestBtn;

	@AndroidFindBy(id ="com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestPopup;

	@AndroidFindBy(id ="com.tce.studi:id/txtNegativeBtn")
	public WebElement returnToTestPopup;

	@AndroidFindBy(id ="com.tce.studi:id/txtSubtitle")
	public WebElement unattemtQueTxt;

	//@AndroidFindBy(id = "com.tce.studi:id/tv_review_id")
	@AndroidFindBy(id ="com.tce.studi:id/tvCheckAnswer")
	public WebElement reviewAttemt;

	@AndroidFindBy(id = "com.tce.studi:id/ivFlag")
	public WebElement queFlag; 

	//@AndroidFindBy(id = "com.tce.studi:id/imgFlagId")
	@AndroidFindBy(id = "com.tce.studi:id/ivFlag")
	public WebElement hamFlag;

	@AndroidFindBy(id = "com.tce.studi:id/tvQuestionMarks")
	public WebElement marks;

	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@AndroidFindBy(id = "com.tce.studi:id/vp_lesson_cards")
	public WebElement objectiveCard;

	//@AndroidFindBy(id = "com.tce.studi:id/cl_confidence_container")
	@AndroidFindBy(id = "com.tce.studi:id/ivConfidence")
	public WebElement confidenceCtnr;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement submitTestBtnOnPopup;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement exitTestOK;

	@AndroidFindBy(id ="com.tce.studi:id/tvChapter")
	public WebElement openTest;


	@AndroidFindBy(id ="com.tce.studi:id/tvCheckAnswer")
	public WebElement checkAnswers;

	public Boolean selectCorrectOption(int queNumber) {
		switch (queNumber) {

		case 1:
				
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4')]")));
			test.log(Status.INFO, "Selecting option 4");
			return true;
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '1512')]")));
			test.log(Status.INFO, "Selecting option 1512");
			return true;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '40 ÷ [5 × (3 + 5)]')]")));
			test.log(Status.INFO, "Selecting option 40 ÷ [5 × (3 + 5)]");
			return true;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3')]")));
			test.log(Status.INFO, "Selecting option 3");
			return true;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3 × (3 + 5)')]")));
			test.log(Status.INFO, "Selecting option 3 × (3 + 5)");
			return true;
		case 6:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '44')]")));
			test.log(Status.INFO, "Selecting option 44");
			return true;
		default:
			return false;
		}

	}

}
