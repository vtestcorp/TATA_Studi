package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Login_Signup_Page extends BaseClass {
	
	public Object_Login_Signup_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.tce.studi:id/tvAlreadyUser")
    public WebElement alreadyUser;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvDoNotHaveAccount")
    public WebElement dontHaveAccountBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtChildName")
	public WebElement childNameTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnSignUp")
	public WebElement signupBtn;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.wid")
	public WebElement selectCurriculam;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.wid")
	public WebElement selectClass;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtContinue")
	public WebElement continueBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtMobileNumber")
	public WebElement mobileNoTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtEmailId")
	public WebElement primaryEmailTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtVerifyMobile")
	public WebElement verifyMobileBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnLogin")
	public WebElement loginBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/tvSignupTitle")
    public WebElement signinTitle;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtMobNum")
	public WebElement mobileNoTxt;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtPassword")
	public WebElement passwordTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnVerify")
	public WebElement verifyBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtEnterYourPassword")
	public WebElement passwordTxt;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtTitle")
	public WebElement errorMsg;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement passwdErrorMsg;
	
	@AndroidFindBy(id = "com.tce.studi:id/txtSignOut")
	public WebElement signoutBtn;
	

}
