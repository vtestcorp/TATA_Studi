package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_BrowseBook_Resource_Listing;
import studi.co.pageModules.Module_Syllabus_Notes_Listing;

public class Syllabus_Notes_Listing extends BaseClass {
	public  Syllabus_Notes_Listing() {
		super();
	}

	@Test(enabled = false)//hold --'Search' text box and Search icon and 'X' icon to close the modal window
	public void TC01_To_verify_user_should_be_able_to_view_the_added_notes_from_the_hamburger_menu() throws Exception {
		Module_Syllabus_Notes_Listing  msnl =new Module_Syllabus_Notes_Listing();
		msnl.To_verify_user_should_be_able_to_view_the_added_notes_from_the_hamburger_menu(prop.getProperty("subject"),prop.getProperty("topic_2"));
	}
	

	@Test(enabled = true)//pass
	public void TC02_To_verify_user_should_be_able_to_view_the_added_note_in_detail_in_expanded_form () throws Exception {
		Module_Syllabus_Notes_Listing  msnl =new Module_Syllabus_Notes_Listing();
		msnl.To_verify_user_should_be_able_to_view_the_added_notes_from_the_expanded_form(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC03_To_verify_that_user_should_be_able_to_Edit_Delete_the_note() throws Exception {
		Module_Syllabus_Notes_Listing  msnl =new Module_Syllabus_Notes_Listing();
		msnl.To_verify_that_user_should_be_able_to_Edit_Delete_the_note(prop.getProperty("subject"),prop.getProperty("topic"));
	}

	@Test(enabled = true)
	public void TC04_To_verify_user_should_be_able_to_navigate_to_note_location_after_clicking_GoToNote_location() throws Exception {
		Module_Syllabus_Notes_Listing  msnl =new Module_Syllabus_Notes_Listing();
		msnl.to_verify_user_should_be_able_to_navigate_to_note_location_after_clicking_GoToNote_location(prop.getProperty("subject_eng"),prop.getProperty("topic_eng"));
	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}
