package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Begin_Revision_Topic1_Chapter1_Geography extends Object_Subject_Geography{
	
	public Object_Begin_Revision_Topic1_Chapter1_Geography() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement click_BeginRevision; 
	
	@AndroidFindBy (xpath = "//android.widget.FrameLayout[@content-desc=\"Hide player controls\"]/android.widget.FrameLayout[4]/android.view.View[2]")
	public WebElement video_Centre_tap;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Hide player controls\"]/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement videoTotalTime; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement hamburgerIcon;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Play\"]")
	public WebElement playButton;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement whatdoyouthink; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement continueButton; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement questionsText; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[1]/android.widget.CheckBox")
	public WebElement answer1Question1;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.widget.CheckBox")
	public WebElement answer2Question1; 
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]/android.widget.CheckBox")
	public WebElement answer3Question1; 
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[4]/android.widget.CheckBox")
	public WebElement answer4Question1;
	
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[5]/android.widget.CheckBox")
	public WebElement answer5Question1;

	public WebElement getClick_BeginRevision() {
		System.out.println("Performing Operation on click_BeginRevision");
		return click_BeginRevision;
	}

	public void setClick_BeginRevision(WebElement click_BeginRevision) {
		this.click_BeginRevision = click_BeginRevision;
	}

	public WebElement getVideo_Centre_tap() {
		System.out.println("Performing Operation on videoCentreTap");
		return video_Centre_tap;
	}

	public void setVideo_Centre_tap(WebElement video_Centre_tap) {
		this.video_Centre_tap = video_Centre_tap;
	}

	public WebElement getVideoTotalTime() {
		System.out.println("Performing Operation on videoTotalTime");
		return videoTotalTime;
	}

	public void setVideoTotalTime(WebElement videoTotalTime) {
		this.videoTotalTime = videoTotalTime;
	}

	public WebElement getHamburgerIcon() {
		System.out.println("Performing Operation on hamburgerIcon");
		return hamburgerIcon;
	}

	public void setHamburgerIcon(WebElement hamburgerIcon) {
		
		this.hamburgerIcon = hamburgerIcon;
	}

	public WebElement getPlayButton() {
		System.out.println("Performing Operation on playButton");
		return playButton;
	}

	public void setPlayButton(WebElement playButton) {
		this.playButton = playButton;
	}

	public WebElement getWhatdoyouthink() {
		System.out.println("Performing Operation on whatdoyouthink");
		return whatdoyouthink;
	}

	public void setWhatdoyouthink(WebElement whatdoyouthink) {
		this.whatdoyouthink = whatdoyouthink;
	}

	public WebElement getContinueButton() {
		System.out.println("Performing Operation on continueButton");
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	public WebElement getQuestionsText() {
		System.out.println("Performing Operation on questionsText");
		return questionsText;
	}

	public void setQuestionsText(WebElement questionsText) {
		this.questionsText = questionsText;
	}

	public WebElement getAnswer1Question1() {
		System.out.println("Performing Operation on answer1Question1");
		return answer1Question1;
	}

	public void setAnswer1Question1(WebElement answer1Question1) {
		this.answer1Question1 = answer1Question1;
	}

	public WebElement getAnswer2Question1() {
		System.out.println("Performing Operation on snwer2Question1");
		return answer2Question1;
	}

	public void setAnswer2Question1(WebElement answer2Question1) {
		this.answer2Question1 = answer2Question1;
	}

	public WebElement getAnswer3Question1() {
		System.out.println("Performing Operation on answer3Question1");
		return answer3Question1;
	}

	public void setAnswer3Question1(WebElement answer3Question1) {
		this.answer3Question1 = answer3Question1;
	}

	public WebElement getAnswer4Question1() {
		System.out.println("Performing operation on answer4Question1");
		return answer4Question1;
	}

	public void setAnswer4Question1(WebElement answer4Question1) {
		this.answer4Question1 = answer4Question1;
	}

	public WebElement getAnswer5Question1() {
		System.out.println("Performing operation on answer5Question1");
		return answer5Question1;
	}

	public void setAnswer5Question1(WebElement answer5Question1) {
		this.answer5Question1 = answer5Question1;
	} 
	
}
