package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.sun.mail.imap.Utility.Condition;

import io.appium.java_client.functions.ExpectedCondition;
import studi.co.Base.*;
import studi.co.pageObjects.*;

public class Module_Login extends BaseClass {

	public static String homepage_title;

	public void Login_to_app() throws InterruptedException, IOException {

		getDriver().resetApp();
//		login.username.clear();
//		login.username.sendKeys(prop.getProperty("username_password"));
//		login.password.clear();
//		login.password.sendKeys(prop.getProperty("username_password"));
//		login.login_button.click();
//		
//		Thread.sleep(5000);
//		
//		homepage_title = login.homepage_title.getText();
//		
//		if(homepage_title.equals("What would\n" + "you like to do next?"))
//			System.out.println("Login successfull");
//		else 
//			System.out.println("Login Failed");
		Object_Login ol = new Object_Login();
		//applyImplicitWait(20);
		applyExplicitWaitsUntilElementVisible(ol.getAlreadyAUser());
		clickOnElement(ol.getAlreadyAUser());

		applyExplicitWait(2);

		clearText(ol.getMobileNumberTextBox());
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
		clickOnElement(ol.getRegisteredUserName());
		applyExplicitWait(2);
		applyExplicitWaitsUntilElementVisible(ol.signOut);
		//scrollTo1("Report an issue");
		scrollToEnd();
		System.out.println("Scrolled across the entire viewport on the LandingPage successfully");
		System.out.println("Login is Successful");
	}
}