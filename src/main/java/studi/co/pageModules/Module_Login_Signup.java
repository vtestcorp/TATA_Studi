package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Login_Signup_Page;

public class Module_Login_Signup extends BaseClass {
	Object_Login_Signup_Page signup=new Object_Login_Signup_Page();
	SoftAssert assert1=new SoftAssert();
	
	public void signup_To_App() throws MalformedURLException {
		
		getDriver().resetApp();
		applyExplicitWait(2);
		clickOnElement(signup.dontHaveAccountBtn);
		applyExplicitWait(2);
		sendText(signup.childNameTB, prop.getProperty("childName"));
		applyExplicitWait(2);
		clickOnElement(signup.signupBtn);
		//Select Curriculam and class
		clickOnElement(signup.selectCurriculam);
		clickOnElement(signup.selectClass);
		applyExplicitWait(2);
		clickOnElement(signup.continueBtn);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberNew"));
		sendText(signup.primaryEmailTB, prop.getProperty("primaryEmail"));
		applyExplicitWait(2);
		clickOnElement(signup.verifyMobileBtn);
		
	}
	
	public void click_On_Login_WithOut_MobileNo() throws MalformedURLException, InterruptedException{
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		clickOnElement(signup.loginBtn);
	   // assert1.assertEquals(signup.signinTitle.isDisplayed(), true);
		assert1.assertEquals(signup.mobileNoTxt.isDisplayed(), true);
		//Thread.sleep(3000);
		//assert1.assertEquals(findElementByExactText("Please enter the mobile number."), true);
		assert1.assertAll();
	}
	
	public void enter_Valid_MobileNo_And_Blank_Password_Field() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		clickOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.passwordTxt.isDisplayed(), true);
		assert1.assertAll();
		
	}
	
	public void enter_Invalid_Credentials() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberinvalid"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("passwordinvalid"));
		clickOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.errorMsg.getText(), "The account credentials you entered did not match");
		
	}
	
	public void enter_Valid_MobileNo_And_Invalid_Password() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("passwordinvalid"));
		clickOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.passwdErrorMsg.getText(), "Re-enter password");
		
	}
	
	public void enter_Invalid_MobilieNo_And_Valid_Password() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberinvalid"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("password"));
		clickOnElement(signup.verifyBtn);
	}
	
	public void enter_Valid_Credentials() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("password"));
		clickOnElement(signup.verifyBtn);
		assert1.assertEquals(findElementByExactText("Choose a profile"), true);
		
		
	}
	
	public void verify_Logout_Functionality() throws MalformedURLException {
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
		clickOnElement(signup.alreadyUser);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("password"));
		clickOnElement(signup.verifyBtn);
		applyExplicitWait(2);
		assert1.assertEquals(signup.signoutBtn.isDisplayed(), true);
		clickOnElement(signup.signoutBtn);
		
	}
	
	public void press_Enter_Button() throws AWTException, MalformedURLException {
		getDriver().resetApp();
		applyExplicitWait(2);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("password"));
		//clickOnElement(signup.verifyBtn);
		assert1.assertEquals(findElementByExactText("Choose a profile"), true);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	

}
