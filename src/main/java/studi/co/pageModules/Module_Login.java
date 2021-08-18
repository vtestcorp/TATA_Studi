package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.mail.imap.Utility.Condition;

import io.appium.java_client.functions.ExpectedCondition;
import studi.co.Base.*;
import studi.co.pageObjects.*;

public class Module_Login extends BaseClass {

	public static String homepage_title;


	public void Login_to_app() throws InterruptedException, IOException {
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		/*
		 * try { clickOnElement(ol.getAlreadyAUser()); } catch(Exception e) {
		 * System.err.println("Continue to login"); } applyExplicitWait(2);
		 */
		//clearText(ol.getMobileNumberTextBox());
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);

		sendText(ol.getPasswordTextBox(), prop.getProperty("password"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		//try{clickOnElement(findElementByText("Refresh"));}
		//catch(Exception e) {}


		clickOnElement(ol.getRegisteredUserName());
		applyExplicitWait(2);
		try {
			clickOnElement(findElementByText("Start new session"));			
		}
		catch(Exception e)
		{
			System.out.println("Duplicate login - started new session");
		}

		try {

			applyExplicitWaitsUntilElementVisible(ol.hideMessage);
			clickOnElement(ol.hideMessage);
		}
		catch(Exception e)
		{
			System.err.println("Pop-up not appear");
		}
		//scrollTo1("Report an issue");
		System.out.println("Login is Successful");


	}
}