package studi.co.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_My_Account_Page extends BaseClass{
	public Object_My_Account_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.tce.studi:id/tvAlreadyUser")
    public WebElement alreadyUser;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtMobileNumber")
	public WebElement mobileNoTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnLogin")
	public WebElement loginBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtPassword")
	public WebElement passwordTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnVerify")
	public WebElement verifyBtn;
	
	@AndroidFindBy(id= "com.tce.studi:id/txtSignOut")
	public WebElement signout1;
	
   @AndroidFindBy(id = "com.tce.studi:id/tvSignOut")
   public WebElement signoutBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/imgStudiLogo")
   public WebElement logo;
   
   @AndroidFindBy(id="com.tce.studi:id/tvManagePlans")
	public WebElement manageAndCreatePlan;
   
   
   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtChildName\").textContains(\"cris\")")
   public WebElement profileFirst;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"cris\")")
   public WebElement userProfileName;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
   public WebElement hideMessage;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
   public WebElement sessionStart;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Choose a profile\")")
   public WebElement chooseAProfile;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvSignupTitle")
   public WebElement welcomeMsg;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Your Annual subscription will expire on Fri, 31 Dec, 2021 at 6 am.\")")
   public WebElement userDetails;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtSelectNewPlan")
   public WebElement selectNewPlan;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Subscribe to plan\")")
   public WebElement selectPlanPage;
   
   @AndroidFindBy(id = "com.tce.studi:id/incSubscriptionList")
   public WebElement planList;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Contact us to add more!\")")
   public WebElement contactUsLink;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/txtChildName\").textContains(\"aaa\")")
   public WebElement expiredPlanUser;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Choose a profile\")")
   public WebElement chooseProfile;
   
   @AndroidFindBy(id = "com.tce.studi:id/rvChildProfile")
   public WebElement childProfilePage;
   
   @AndroidFindBy(id = 	"com.tce.studi:id/tvName")
   public WebElement firstProfileName;
   
   @AndroidFindBy(id = "com.tce.studi:id/ivProfile")
   public WebElement profileIcon;
   
   @AndroidFindBy(id = "com.tce.studi:id/iv_setting_close")
   public WebElement closeBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/switchProfile")
   public WebElement switchProfile;
   
   @AndroidFindBy(id = "com.tce.studi:id/addNewProfile")
   public WebElement addNewProfile;
   
   @AndroidFindBy(id = "com.tce.studi:id/profile")
   public WebElement profileLink;
   
   @AndroidFindBy(id ="com.tce.studi:id/valueName")
   public WebElement ProfileName;
   
   @AndroidFindBy(id = "com.tce.studi:id/subsPlanCard")
   public WebElement subscriptionCard;
   
   @AndroidFindBy(id = "com.tce.studi:id/syllabus")
   public WebElement syllabusLink;
   
   @AndroidFindBy(id = "com.tce.studi:id/valueCurriculum")
   public WebElement boardDetails;
   
   @AndroidFindBy(id = "com.tce.studi:id/valueGrade")
   public WebElement gradeDetail;
   
   @AndroidFindBy(id = "com.tce.studi:id/account")
   public WebElement acountLink;
   
   @AndroidFindBy(id = "com.tce.studi:id/valMobNo")
   public WebElement mobileNo;
   
   @AndroidFindBy(id = "com.tce.studi:id/valEmailId")
   public WebElement emailId;
   
   @AndroidFindBy(id = "com.tce.studi:id/valStateResidency")
   public WebElement stateDetail;
   
   @AndroidFindBy(id = "com.tce.studi:id/valPinCode")
   public WebElement pinCode;
   
   //@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Deadline Passed\")")
  //@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"1. Understanding Diversity\")")
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
   public WebElement carousel1; 
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Digital Test: Natural Vegetation\")")
  //@AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")
  public WebElement carousel2; 
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Test Unit\")")
   public WebElement page1; 
   
   @AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
   public WebElement page2;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Assignments\")")
   public WebElement assignments; 
   
   @AndroidFindBy(id = "com.tce.studi:id/fabAssignment")
   public WebElement createTask;
   
  
   @AndroidFindBy(id="com.tce.studi:id/tvAssign")
	public WebElement assignTask;

   @AndroidFindBy(id = "com.tce.studi:id/etTitle")
   public WebElement taskTitle;
   
   @AndroidFindBy(id="com.tce.studi:id/etInstructions")
	public WebElement taskInstruction;
   
   @AndroidFindBy(id ="com.tce.studi:id/assignmentViewed")
	public WebElement assignmentViewed;

   @AndroidFindBy(id ="com.tce.studi:id/btnFive")
	public WebElement taskDuration;	

   
   @AndroidFindBy(id = "com.tce.studi:id/tvAssign")
   public WebElement assignBtn;
   
   @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvType\").textContains(\"Task\")")
	public WebElement createdTask;
   
  // @AndroidFindBy(id = "com.tce.studi:id/vpNotification")
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
   public WebElement corousel1;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtTopButton")
   public WebElement modifyBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
   public WebElement backBtn;
   
   @AndroidFindBy(id= "com.tce.studi:id/txtPositiveBtn")
   public WebElement yesBtn;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Test\")")
   //@AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup")
   public WebElement corousel2;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
   public WebElement redoTestBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
   public WebElement leftIcon;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Study from your school syllabus\")")
   public WebElement corousel3;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Syllabus\")")
   public WebElement syllabustab;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Clarify concepts\")")
   public WebElement corousel4;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Manage your schedules in one place\")")
   public WebElement corousel5;
   
  // @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Weekly Progress Report\")")
   @AndroidFindBy(id = "com.tce.studi:id/tvViewReport")
   public WebElement corousel6;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvWeek")
   public WebElement weeklyReport;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvPrivacy")
   public WebElement footerMsg;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").textContains(\"Terms & Conditions\")")
   public WebElement terms_ConditionPage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").textContains(\"Privacy Policy\")")
   public WebElement privacyPolicyPage;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtSignOut")
   public WebElement signout;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvSignupTitle")
   public WebElement welcomeTitle;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Plan : Test Unit\")")
   public WebElement planTestUnit;

   @AndroidFindBy(id = "com.tce.studi:id/txtBottomButton")
   public WebElement selectAnotherPlan;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvCreatePlan")
   public WebElement createPlan;
   
   @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.TabWidget[2]/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View")
   public WebElement checkBoxGeography;
   
   //@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.Button[2]")
   @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Add to portion\")")
   public WebElement addToPortion;
   
   @AndroidFindBy(id = "com.tce.studi:id/tvChapter")
   public WebElement chapterName;
   
   @AndroidFindBy(id = "com.tce.studi:id/pausePlan")
   public WebElement pauseBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
   public WebElement proceedBtn;
   
   @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
   public WebElement secondstudyplan;
   
   @AndroidFindBy(id = "com.tce.studi:id/fabEditStudyPlan")
   public WebElement editBtn;
   
   @AndroidFindBy(id = "com.tce.studi:id/tv_intent_title")
   public WebElement activatePlan;
   
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button")
	public WebElement nextStep;
   
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.Button")
	public WebElement nextStep1;

   
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.Button")
	public WebElement activateplan;
   
   @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.app.Dialog/android.view.View/android.view.View/android.view.View/android.widget.Button")
	public WebElement beginStudying;
   
   @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Assignment\")")
	public WebElement assignment;
   
   @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tv_intent_title\").textContains(\"Task\")")
	public WebElement task;
   
   @AndroidFindBy(id="com.tce.studi:id/fabAssignment")
	public WebElement add_assignment;
   
   //temporary for add new profile
   @AndroidFindBy(id = "com.tce.studi:id/txtCreateNewProfile")
	public WebElement createNewProfile;
}
