package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;

import studi.co.pageModules.Module_Browsebook_Chapter_Listing;
import studi.co.pageModules.Module_Login;

public class AFS_UserStory_127 extends BaseClass {
	public AFS_UserStory_127() {
		super();

	}
	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}
	@Test(enabled = true)
	public void TC05_To_Verify_Use_Must_be_Able_To_View_The_Content_of_the_Chapter_Listing_Pages()
			throws Exception {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_use_must_be_able_to_view_the_content_of_the_Chapter_Listing_page(prop.getProperty("subject"),prop.getProperty("topic"));

	}
	@Test(enabled = false)
	public void TC07_To_Verify_Use_Must_be_Able_To_View_The_Details_of_The_Chapters()
			throws Exception {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_use_must_be_able_to_view_the_details_of_the_chapters(prop.getProperty("subject"),prop.getProperty("topic"));

	}

	@Test(enabled = false)
	public void TC14_To_Verify_Use_Must_be_Able_To_Navigate_To_Revision_From_Topic()
			throws MalformedURLException, InterruptedException {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_use_must_be_able_to_navigate_to_practice_from_topic(prop.getProperty("subject"),prop.getProperty("topic"));

	}
	@Test(enabled = false)
	public void TC15_To_Verify_Use_Must_be_Able_To_Navigate_To_Practice_From_Topic()
			throws MalformedURLException, InterruptedException {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_use_must_be_able_to_navigate_to_practice_from_topic(prop.getProperty("subject"),prop.getProperty("topic"));

	}
	@Test(enabled = false)
	public void TC16_To_Verify_the_user_should_be_able_to_Navigate_to_Notes_listing_page()
			throws MalformedURLException, InterruptedException {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_the_user_should_be_able_to_Navigate_to_Notes_listing_page(prop.getProperty("subject"),prop.getProperty("topic"));

	}
	@Test(enabled = false)
	public void TC22_To_Verify_user_should_be_able_to_navigate_to_the_StrikedOut_Topics()
			throws MalformedURLException, InterruptedException {
		Module_Browsebook_Chapter_Listing mbcl=new Module_Browsebook_Chapter_Listing();
		mbcl.to_verify_user_should_be_able_to_navigate_to_the_StrikedOut_Topics(prop.getProperty("subject"),prop.getProperty("topic1"));

	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}

