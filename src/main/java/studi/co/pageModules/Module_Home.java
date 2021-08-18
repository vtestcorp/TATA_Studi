package studi.co.pageModules;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import studi.co.Base.*;
import studi.co.pageObjects.Object_Home_Page;

public class Module_Home extends BaseClass{
	SoftAssert assert1=new SoftAssert();
	//Object_Home_Page oh=new Object_Home_Page();

	
	public void login_To_App() throws MalformedURLException {
		Object_Home_Page oh=new Object_Home_Page();
		Boolean status;
		if(device.contains("Android"))
			getDriver().resetApp();
			else
			{
				try {
					clickOnElement(findElementByText("Sign-out"));}
				catch(Exception e) {System.out.println("Already logged out");}
			}
		try{applyExplicitWaitsUntilElementVisible(oh.alreadyUser);
		clickOnElement(oh.alreadyUser);}
		catch(Exception e) {}
		applyExplicitWaitsUntilElementVisible(oh.mobileNoTB);
		sendText(oh.mobileNoTB, prop.getProperty("mobileNumber"));
		System.out.println("Entered Mobile Number");
		if(device.equalsIgnoreCase("ios"))
			{clickOnElement(findElementByText("Done"));
				tapOnElement(oh.loginBtn);
			}
		else {		
		clickOnElement(oh.clickLoginButton());
		}

		sendText(oh.passwordTB, prop.getProperty("password"));
		System.out.println("Entered Password");
		if(device.equalsIgnoreCase("ios"))
			clickOnElement(findElementByText("Done"));
		applyExplicitWait(2);

		tapOnElement(oh.clickOnVerify());
		applyExplicitWaitsUntilElementVisible(oh.logo);
		System.out.println("login sucessfully");

			status =oh.logo.isDisplayed();
		
		if (status) {
			System.out.println("Logo is displayed on Home Page");
			test.log(Status.INFO, "Logo is displayed on Home Page");
		}
	
		assert1.assertTrue(status);
		assert1.assertAll();
	}
	
	public void verify_country_code() throws InterruptedException, MalformedURLException {
		Object_Home_Page oh=new Object_Home_Page();
		if(device.contains("Android"))
		getDriver().resetApp();
		else
		{
			try {
			clickOnElement(findElementByText("out"));}
			catch(Exception e) {System.out.println("Already logged out");}
		}
		Thread.sleep(3000);
		try{
		applyExplicitWaitsUntilElementVisible(oh.alreadyUser);
		clickOnElement(oh.alreadyUser);
		}
		catch(Exception e) {}
		assert1.assertEquals(oh.countrycode.isDisplayed(), true);
		System.out.println("By Default country code is displayed");
		
	}
	

}
