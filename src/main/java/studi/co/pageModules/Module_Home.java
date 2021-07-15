package studi.co.pageModules;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import studi.co.Base.*;
import studi.co.pageObjects.Object_Home_Page;

public class Module_Home extends BaseClass{
	SoftAssert assert1=new SoftAssert();
	//Object_Home_Page oh=new Object_Home_Page();
	
	
	public void login_To_App() throws MalformedURLException {
		Object_Home_Page oh=new Object_Home_Page();
		getDriver().resetApp();
		
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
		//applyExplicitWaitsUntilElementClickable(oh.logo);
		//System.out.println("Logo is clickable");
		applyExplicitWaitsUntilElementVisible(oh.logo);
	    assert1.assertEquals(oh.logo.isDisplayed(), true);
	    System.out.println("logo is displayed");
		
	}
	
	public void verify_country_code() throws InterruptedException {
		Object_Home_Page oh=new Object_Home_Page();
		getDriver().resetApp();
		Thread.sleep(3000);
		assert1.assertEquals(oh.countrycode.isDisplayed(), true);
		System.out.println("By Default country code is displayed");
		
	}
	

}
