package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Landing_Page extends Object_Login {

	public Object_Landing_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Spinner")
	public WebElement userNameDropDown;
	
	//Locators Inside the userNameDropDownButton
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView")
	public WebElement switchProfile;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView")
	public WebElement setting; 
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.TextView")
	public WebElement logOut;
	
	//Locators for the main LandingPage
	@AndroidFindBy(id = "com.tce.afs:id/textHeader")
	public WebElement textTitle;
	
	@AndroidFindBy(id = "com.tce.afs:id/signout")
	public WebElement signout_Button; 
	
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
	//public WebElement browseBooks;
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	public WebElement syllabus; 
	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	public WebElement assignments; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	public WebElement activeplan; 
	
//	@AndroidFindBy(xpath = "com.tce.afs:id/dont_like_study")
//	public WebElement dontlikestudyText; 
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
	public WebElement reportAnIssue;

	public WebElement getUserNameDropDown() {
		System.out.println("Performing operation on userNameDropDown");
		return userNameDropDown;
	}

	public void setUserNameDropDown(WebElement userNameDropDown) {
		this.userNameDropDown = userNameDropDown;
	}

	public WebElement getSwitchProfile() {
		System.out.println("Performing operation on switchProfile");
		return switchProfile;
	}

	public void setSwitchProfile(WebElement switchProfile) {
		this.switchProfile = switchProfile;
	}

	public WebElement getSetting() {
		System.out.println("Performing operation on setting");
		return setting;
	}

	public void setSetting(WebElement setting) {
		this.setting = setting;
	}

	public WebElement getLogOut() {
		System.out.println("Performing operation on logOut");
		return logOut;
	}

	public void setLogOut(WebElement logOut) {
		this.logOut = logOut;
	}

	public WebElement getTextTitle() {
		System.out.println("Performing operation on textTitle");
		return textTitle;
	}

	public void setTextTitle(WebElement textTitle) {
		this.textTitle = textTitle;
	}

	public WebElement getSignout_Button() {
		System.out.println("Performing operation on signout button");
		return signout_Button;
	}

	public void setSignout_Button(WebElement signout_Button) {
		this.signout_Button = signout_Button;
	}

	public WebElement getSyllabus() {
		System.out.println("Performing operation on syllabus");
		return syllabus;
	}

	public void setSyllabus(WebElement syllabus) {
		this.syllabus = syllabus;
	}

	public WebElement getAssignments() {
		System.out.println("Performing operation on assignments");
		return assignments;
	}

	public void setAssignments(WebElement assignments) {
		this.assignments = assignments;
	}

	public WebElement getActiveplan() {
		System.out.println("Performing operation on activeplan");
		return activeplan;
	}

	public void setActiveplan(WebElement activeplan) {
		this.activeplan = activeplan;
	}

	public WebElement getReportAnIssue() {
		System.out.println("Performing operation on reportAnIssue");
		return reportAnIssue;
	}

	public void setReportAnIssue(WebElement reportAnIssue) {
		this.reportAnIssue = reportAnIssue;
	} 
	
	
}
