package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;
;
public class Object_Home_Page extends BaseClass{
	
	public Object_Home_Page() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.tce.studi:id/edtMobileNumber")
	public WebElement mobileNoTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnLogin")
	public WebElement loginBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/edtPassword")
	public WebElement passwordTB;
	
	@AndroidFindBy(id = "com.tce.studi:id/btnVerify")
	public WebElement verifyBtn;
	@AndroidFindBy(id = "com.tce.studi:id/tvAlreadyUser")
    public WebElement alreadyUser;
	
	//@AndroidFindBy(id = "com.tce.studi:id/logo")
	@AndroidFindBy(id ="com.tce.studi:id/imgStudiLogo")
	public WebElement logo;
	
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
