package studi.co.pageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;

public class Object_Login_Signup_Page extends BaseClass {
	
	public Object_Login_Signup_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@iOSFindBy(id = "Already a User? Log In")
	@AndroidFindBy(id = "com.tce.studi:id/tvAlreadyUser")
    public WebElement alreadyUser;
	
	@iOSFindBy(id = "Don’t have an account?")
	@AndroidFindBy(id = "com.tce.studi:id/tvDoNotHaveAccount")
    public WebElement dontHaveAccountBtn;
	
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Enter your child's name\"]")
	@AndroidFindBy(id = "com.tce.studi:id/edtChildName")
	public WebElement childNameTB;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value=\"Sign up\"]")
	@AndroidFindBy(id = "com.tce.studi:id/btnSignUp")
	public WebElement signupBtn;
	
	@iOSFindBy(id = "CBSE - Imprint")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.wid")
	public WebElement selectCurriculam;
	
	@iOSFindBy(id = "Class 6")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.wid")
	public WebElement selectClass;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtContinue")
	public WebElement continueBtn;
	
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Enter number\"]")
	@AndroidFindBy(id = "com.tce.studi:id/edtMobileNumber")
	public WebElement mobileNoTB;
	
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
	@AndroidFindBy(id = "com.tce.studi:id/edtEmailId")
	public WebElement primaryEmailTB;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Verify Mobile\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtVerifyMobile")
	public WebElement verifyMobileBtn;
	
	@iOSFindBy(id = "Sign in")
	@AndroidFindBy(id = "com.tce.studi:id/btnLogin")
	public WebElement loginBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvSignupTitle")
    public WebElement signinTitle;
	
	@iOSFindBy(id = "Enter mobile number")
	@AndroidFindBy(id = "com.tce.studi:id/txtMobNum")
	public WebElement mobileNoTxt;
	
	@iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Enter password\"]")
	@AndroidFindBy(id = "com.tce.studi:id/edtPassword")
	public WebElement passwordTB;
	
	@iOSFindBy(id = "Verify")
	@AndroidFindBy(id = "com.tce.studi:id/btnVerify")
	public WebElement verifyBtn;
	
	@iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Enter password\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtEnterYourPassword")
	public WebElement passwordTxt;
	
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"The account credentials you entered did not match.\"])[2]")
	@AndroidFindBy(id = "com.tce.studi:id/txtTitle")
	public WebElement errorMsg;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Re-enter password\"]")
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Re-enter password\")")
	public WebElement passwdErrorMsg;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign-out\"]")
	@AndroidFindBy(id = "com.tce.studi:id/txtSignOut")
	public WebElement signoutBtn;
	

}
