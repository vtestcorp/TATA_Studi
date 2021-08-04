package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Subscription extends BaseClass{

	public Object_Subscription() {
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

	@AndroidFindBy(id = "com.tce.studi:id/txtCreateNewProfile")
	public WebElement createNewProfile;

	@AndroidFindBy(id = "com.tce.studi:id/edtChildName")
	public WebElement childNameTB;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"CBSE - Imprint\")")
	public WebElement selectCurriculam;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Class 2\")")
	public WebElement selectClass;

	@AndroidFindBy(id = "com.tce.studi:id/txtContinue")
	public WebElement continueBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Subscribe to plan\")")
	public WebElement subscribeToPlan;

	@AndroidFindBy(id ="com.tce.studi:id/txtSelectNewPlan")
	public WebElement selectNewPlan;

	@AndroidFindBy(id = "com.tce.studi:id/tvFreeTrial")
	public WebElement freeTrail;

	@AndroidFindBy(id = "com.tce.studi:id/txtActionBtn")
	public WebElement acceptTermsBtn;

	//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"on Thu, 15 Jul, 2021.\")")
	//public WebElement freeTrailValidity;

	@AndroidFindBy(id ="com.tce.studi:id/tvFreeTrial")
	public WebElement free_plan;

	@AndroidFindBy(id ="com.tce.studi:id/tv_started")
	public WebElement get_Stared;

	@AndroidFindBy(id ="com.tce.studi:id/edtFirstName")
	public WebElement first_name;

	@AndroidFindBy(id ="com.tce.studi:id/edtLastName")
	public WebElement last_name;

	@AndroidFindBy(id ="com.tce.studi:id/edtSendInvoiceTo")
	public WebElement mail_id;


	//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"- Select State -\")")
	@AndroidFindBy(id ="com.tce.studi:id/stateSpinner")
	public WebElement state;

	@AndroidFindBy(id ="com.tce.studi:id/edtPinCode")
	public WebElement pin_code;

	@AndroidFindBy(id ="com.tce.studi:id/txtProceedToPay")
	public WebElement proceed_to_pay_btn;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[11]")
	public WebElement state_name;

	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView")
	public WebElement subscribe1;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.tce.studi:id/tvName\").textContains(\"Liam\")")
	public WebElement new_user_name;

	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.TextView\").textContains(\"Order Summary\")")
	public WebElement order_Summary;

	@AndroidFindBy(id ="com.android.vending:id/0_resource_name_obfuscated")
	public WebElement start_by_Adding_payment_method_msg;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Order Summary\")")
	public WebElement billing_details;
	


}
