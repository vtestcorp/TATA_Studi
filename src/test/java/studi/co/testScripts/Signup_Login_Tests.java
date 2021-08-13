package studi.co.testScripts;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login_Signup;

public class Signup_Login_Tests extends BaseClass {
	
	public Signup_Login_Tests(){
		super();
	}
	
//	@Test(enabled = false)// we can not automate OTP
//	public void  verify_The_SignUp_Functionality_For_New_User_Who_Dont_Have_An_Account() throws MalformedURLException {
//		Module_Login_Signup loginsignup = new Module_Login_Signup();
//		loginsignup.signup_To_App();
//	}
	
	
	@Test(enabled = true)
	public void TC_03_Verify_Loginin_Functionality_With_Blank_Mobile_Number() throws MalformedURLException, InterruptedException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.click_On_Login_WithOut_MobileNo();
		
	}
	
	@Test(enabled = true)
	public void TC_04_Verify_SingIn_Functionality_With_Valid_Username_And_Blank_Password() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.enter_Valid_MobileNo_And_Blank_Password_Field();
	}
	
	@Test(enabled = true)
	public void TC_05_Verify_User_Entered_Invalid_Credentials() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.enter_Invalid_Credentials();
		
	}
	
	@Test(enabled = true )
	public void TC_06_Verify_User_Entered_Valid_MobileNo_And_Invalid_Password() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.enter_Valid_MobileNo_And_Invalid_Password();
		
	}
	
	@Test(enabled = true)
	public void TC_07_Verify_User_Entered_Invalid_MobileNo_And_Valid_PAssword() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.enter_Invalid_MobilieNo_And_Valid_Password();
		
	}

	@Test(enabled = true)
	public void TC_08_Verify_User_Entered_Valid_Credentials() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.enter_Valid_Credentials();
		
	}
	
	@Test(enabled = true)
	public void TC_11_Verify_Logout_Functionality() throws MalformedURLException {
		Module_Login_Signup loginsignup = new Module_Login_Signup();
		loginsignup.verify_Logout_Functionality();
		
	}
//	
//	@Test(enabled = false)//we can not perform "enter" action on mobile App
//	public void TC_13_Verify_Functionality_After_Adding_Valid_Username_And_Valid_Password_In_Application_URL() throws MalformedURLException, AWTException {
//		Module_Login_Signup loginsignup = new Module_Login_Signup();
//		//loginsignup.enter_Valid_Credentials();
//		loginsignup.press_Enter_Button();
//	}
}
