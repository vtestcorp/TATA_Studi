package studi.co.pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import studi.co.Base.*;

public class Object_Login extends BaseClass {

	// @AndroidFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[1]")
	// public WebElement username;
	//
	// @iOSFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[1]")
	// public WebElement iusername;
	//
	// @AndroidFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[2]")
	// public WebElement password;
	//
	// @iOSFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[2]")
	// public WebElement ipassword;
	//
	// @AndroidFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	// public WebElement login_button;
	//
	// @iOSFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	// public WebElement ilogin_button;
	//
	// @AndroidFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	// public WebElement homepage_title;
	//
	// @iOSFindBy(xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	// public WebElement ihomepage_title;

	// Page 1
	@FindBy(id = "com.tce.studi:id/tvAlreadyUser")
	public WebElement alreadyAUser;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText")
	public WebElement nameTextBox;

	@FindBy(id = "com.tce.studi:id/tv")
	public WebElement signOut;
	
	// Page 2

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement welcomeBackText;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText")
	public WebElement mobileNumberTextBox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
	public WebElement loginButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement dontHaveAnAccount;

	// Page 3
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.EditText\n")
	public WebElement passwordTextBox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
	public WebElement verifypasswordButton;

	@FindBy(id = "com.tce.studi:id/txtChildName")
	public WebElement registeredUserName;

	public WebElement getAlreadyAUser() {
		System.out.println("Performing operation on alreadyUser");
		return alreadyAUser;
	}

	public void setAlreadyAUser(WebElement alreadyAUser) {
		this.alreadyAUser = alreadyAUser;
	}

	public WebElement getNameTextBox() {
		System.out.println("Performing operation on nameTextBox");
		return nameTextBox;
	}

	public void setNameTextBox(WebElement nameTextBox) {
		this.nameTextBox = nameTextBox;
	}

	public WebElement getWelcomeBackText() {
		System.out.println("Performing operation on welcomeBackText");
		return welcomeBackText;
	}

	public void setWelcomeBackText(WebElement welcomeBackText) {
		this.welcomeBackText = welcomeBackText;
	}

	public WebElement getMobileNumberTextBox() {
		System.out.println("Performing operation on mobileNumberTextBox");
		return mobileNumberTextBox;

	}

	public void setMobileNumberTextBox(WebElement mobileNumberTextBox) {
		this.mobileNumberTextBox = mobileNumberTextBox;
	}

	public WebElement getLoginButton() {
		System.out.println("Performing Operation on loginButton");
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getDontHaveAnAccount() {
		System.out.println("Performing Operation on dontHaveAnAccount");
		return dontHaveAnAccount;
	}

	public void setDontHaveAnAccount(WebElement dontHaveAnAccount) {
		this.dontHaveAnAccount = dontHaveAnAccount;
	}

	public WebElement getPasswordTextBox() {
		System.out.println("Performing operation on passwordTextBox");
		return passwordTextBox;
	}

	public void setPasswordTextBox(WebElement passwordTextBox) {
		this.passwordTextBox = passwordTextBox;
	}

	public WebElement getVerifypasswordButton() {
		System.out.println("Performing operation on verifypasswordButton");
		return verifypasswordButton;
	}

	public void setVerifypasswordButton(WebElement verifypasswordButton) {
		this.verifypasswordButton = verifypasswordButton;
	}

	public WebElement getRegisteredUserName() throws MalformedURLException {
		System.out.println("Performing Operation on registeredUserName");
		applyExplicitWaitsUntilElementVisible(registeredUserName);
		return registeredUserName;
	}

	public void setRegisteredUserName(WebElement registeredUserName) {
		this.registeredUserName = registeredUserName;
	}

	public Object_Login() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

}
