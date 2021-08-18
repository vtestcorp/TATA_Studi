package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.BaseClass;
;
public class Object_Home_Page extends BaseClass{
	
	public Object_Home_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Enter number\"]")
	@AndroidFindBy(id = "com.tce.studi:id/edtMobileNumber")
	public WebElement mobileNoTB;
	
	@iOSFindBy(id = "Sign in")
	@AndroidFindBy(id = "com.tce.studi:id/btnLogin")
	public WebElement loginBtn;
	
	@iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Enter password\"]")
	@AndroidFindBy(id = "com.tce.studi:id/edtPassword")
	public WebElement passwordTB;
	
	@iOSFindBy(id = "Verify")
	@AndroidFindBy(id = "com.tce.studi:id/btnVerify")
	public WebElement verifyBtn;
	
	@iOSFindBy(id = "Already a User? Log In")
	@AndroidFindBy(id = "com.tce.studi:id/tvAlreadyUser")
    public WebElement alreadyUser;
	
	@iOSFindBy(id = "Choose a Profile")
	@AndroidFindBy(id ="com.tce.studi:id/imgStudiLogo")
	public WebElement logo;
	
	@iOSFindBy(id = "+91 -")
	@AndroidFindBy(id = "com.tce.studi:id/txtCountryCode")
	public WebElement countrycode;
	
	public void enterMobileNo(WebElement mobileNoTB) {
		this.mobileNoTB=mobileNoTB;
		
	}
	
	public WebElement clickLoginButton() {
		System.out.println("click on loginButton");
		return loginBtn;
	}
	
	public void enterPassword(WebElement passwordTB) {
		this.passwordTB=passwordTB;
		
	}
	
	public WebElement clickOnVerify() {
		System.out.println("click on verifyButton");
		//verifyBtn.click();
		return verifyBtn;
		
	}
	

}
