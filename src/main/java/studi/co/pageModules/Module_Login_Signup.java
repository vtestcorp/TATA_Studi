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
	Object_Login_Signup_Page signup = new Object_Login_Signup_Page();
	SoftAssert assert1 = new SoftAssert();

	public void signup_To_App() throws MalformedURLException {

		if (device.contains("Android"))
			getDriver().resetApp();
		else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		applyExplicitWait(2);
		clickOnElement(signup.dontHaveAccountBtn);
		applyExplicitWait(2);
		sendText(signup.childNameTB, prop.getProperty("childName"));
		applyExplicitWait(2);
		clickOnElement(signup.signupBtn);
		// Select Curriculam and class
		clickOnElement(signup.selectCurriculam);
		clickOnElement(signup.selectClass);
		applyExplicitWait(2);
		clickOnElement(signup.continueBtn);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberNew"));
		sendText(signup.primaryEmailTB, prop.getProperty("primaryEmail"));
		applyExplicitWait(2);
		clickOnElement(signup.verifyMobileBtn);

	}

	public void click_On_Login_WithOut_MobileNo() throws MalformedURLException, InterruptedException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
			applyExplicitWaitsUntilElementVisible(signup.mobileNoTxt);
		}

		tapOnElement(signup.loginBtn);

		assert1.assertEquals(signup.mobileNoTB.isDisplayed(), true);

		assert1.assertAll();
	}

	public void enter_Valid_MobileNo_And_Blank_Password_Field() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
			applyExplicitWaitsUntilElementVisible(signup.mobileNoTB);
		}

		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));

		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));

		tapOnElement(signup.loginBtn);

		tapOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.passwordTxt.isDisplayed(), true);
		assert1.assertAll();

	}

	public void enter_Invalid_Credentials() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}

		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberinvalid"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));

		tapOnElement(signup.loginBtn);

		sendText(signup.passwordTB, prop.getProperty("passwordinvalid"));

		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));

		tapOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.errorMsg.getText(), "The account credentials you entered did not match");

	}

	public void enter_Valid_MobileNo_And_Invalid_Password() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("passwordinvalid"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.passwdErrorMsg.getText(), "Re-enter password");

	}

	public void enter_Invalid_MobilieNo_And_Valid_Password() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumberinvalid"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.loginBtn);
		
		sendText(signup.passwordTB, prop.getProperty("password"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.verifyBtn);
		assert1.assertEquals(signup.passwdErrorMsg.getText(), "Re-enter password");
	}

	public void enter_Valid_Credentials() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.loginBtn);
		
		sendText(signup.passwordTB, prop.getProperty("password"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.verifyBtn);
		assert1.assertTrue(findElementByText("Choose").isEnabled());

	}

	public void verify_Logout_Functionality() throws MalformedURLException {
		if (device.contains("Android")) {
			getDriver().resetApp();
			applyExplicitWaitsUntilElementVisible(signup.alreadyUser);
			clickOnElement(signup.alreadyUser);
		} else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.loginBtn);
	
		sendText(signup.passwordTB, prop.getProperty("password"));
		if (device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		tapOnElement(signup.verifyBtn);
		
		assert1.assertEquals(signup.signoutBtn.isEnabled(), true);
		tapOnElement(signup.signoutBtn);

	}

	public void press_Enter_Button() throws AWTException, MalformedURLException {
		if (device.contains("Android"))
			getDriver().resetApp();
		else {
			try {
				clickOnElement(findElementByText("out"));
			} catch (Exception e) {
				System.out.println("Already logged out");
			}
		}
		applyExplicitWait(2);
		sendText(signup.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(signup.loginBtn);
		applyExplicitWait(2);
		sendText(signup.passwordTB, prop.getProperty("password"));
		// clickOnElement(signup.verifyBtn);
		assert1.assertEquals(findElementByExactText("Choose a profile"), true);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
