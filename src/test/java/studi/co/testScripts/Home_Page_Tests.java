package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Home;

public class Home_Page_Tests extends BaseClass{

	public Home_Page_Tests() {
		super();
	}

	@Test(enabled = true )
	public void TC_04_verify_Logo_Is_Visible() throws MalformedURLException {
		Module_Home mobileHome= new Module_Home();
		mobileHome.login_To_App();


	}

	@Test(enabled = true)
	public void TC_05_Verify_Default_Data_Of_The_Mobile_Number_Text_Field_On_The_Home_Page() throws InterruptedException, MalformedURLException {
		Module_Home mobileHome= new Module_Home();
		mobileHome.verify_country_code();
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}


}
