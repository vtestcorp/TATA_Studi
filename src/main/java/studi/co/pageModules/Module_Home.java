package studi.co.pageModules;
import java.net.MalformedURLException;

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
		getDriver().resetApp();
		applyExplicitWaitsUntilElementVisible(oh.alreadyUser);
		clickOnElement(oh.alreadyUser);
		applyExplicitWaitsUntilElementVisible(oh.mobileNoTB);
		sendText(oh.mobileNoTB, prop.getProperty("mobileNumber"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(oh.clickLoginButton());
		applyExplicitWait(2);

		sendText(oh.passwordTB, prop.getProperty("password"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(oh.clickOnVerify());
		applyExplicitWait(2);
		System.out.println("login sucessfully");

			status =oh.logo.isDisplayed();
		
		if (status) {
			System.out.println("Logo is displayed on Home Page");
			test.log(Status.INFO, "Logo is displayed on Home Page");
		}
	
		assert1.assertTrue(status);
		
		clickOnElement(oh.logo);
		
		String click=oh.logo.getAttribute("clickable");
		if (click.contains("true"))

			{
			System.out.println("Logo is Clickable");
			test.log(Status.INFO, "Logo is Clickable");
			}
		
		else
		{
			System.out.println("Logo is not Clickable");
			test.log(Status.INFO, "Logo is not Clickable");
			}

		
		assert1.assertAll();
	}
	
	public void verify_country_code() throws InterruptedException, MalformedURLException {
		Object_Home_Page oh=new Object_Home_Page();
		getDriver().resetApp();
		Thread.sleep(3000);
		applyExplicitWaitsUntilElementVisible(oh.alreadyUser);
		clickOnElement(oh.alreadyUser);
		assert1.assertEquals(oh.countrycode.isDisplayed(), true);
		System.out.println("By Default country code is displayed");
		
	}
	

}
