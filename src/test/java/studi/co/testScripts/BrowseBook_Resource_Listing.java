package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_BrowseBook_Resource_Listing;

public class BrowseBook_Resource_Listing extends BaseClass {
	public  BrowseBook_Resource_Listing() {
		super();
	}

	@Test(enabled = true)//pass
	public void TC_06_To_Verify_User_should_be_shown_Confidence_score_of_each_chapter_against_every_book() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_Verify_User_should_be_shown_Confidence_score_of_each_chapter_against_every_book(prop.getProperty("subject_eng"),prop.getProperty("topic_eng"));
	}
	@Test(enabled = true)//pass
	public void TC_07_To_Verify_User_should_be_shown_Not_Accessed_Status_when_user_has_not_started_that_particular_chapter() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_verify_user_should_be_shown_Not_Accessed_Status_when_user_has_not_started_that_particular_chapter(prop.getProperty("not_accessed_sub"),prop.getProperty("not_accessed_topic"));
	}
	@Test(enabled = true)//pass
	public void TC_09_To_Verify_User_should_be_shown_Low_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_verify_User_should_be_shown_Low_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(prop.getProperty("subject_low"),prop.getProperty("topic_eng"));
	}
	@Test(enabled = true)//pass
	public void TC_10_To_Verify_User_should_be_shown_medium_Confidence_Status_for_the_chapter_in_which_user_has_scored_medium_Confidence() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_verify_User_should_be_shown_medium_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(prop.getProperty("subject_eng"),prop.getProperty("topic_medium"));
	}
	@Test(enabled = true)//pass
	public void TC_11_To_Verify_User_should_be_shown_Hign_Confidence_Status_for_the_chapter_in_which_user_has_scored_Hign_Confidence() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_verify_User_should_be_shown_High_Confidence_Status_for_the_chapter_in_which_user_has_scored_Low_Confidence(prop.getProperty("subject2"),prop.getProperty("topic2"));
	}
	@Test(enabled = true)//pass
	public void TC_18_To_Verify_User_should_be_shown_Not_Accessed_Status_for_the_TP_when_user_has_not_started_that_particular_TP() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_Verify_User_should_be_shown_Not_Accessed_Status_for_the_TP_when_user_has_not_started_that_particular_TP(prop.getProperty("subject_eng"),prop.getProperty("topic_eng2"));
	}
	@Test(enabled = true)//pass
	public void TC_19_To_Verify_User_should_be_shown_Completed_In_School_Status() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.to_Verify_User_should_be_shown_Completed_In_School_Status(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)//pass
	public void TC_23_To_Verify_User_should_be_shown_Excluded_from_Syllabus_Status_for_the_TP() throws Exception {
		Module_BrowseBook_Resource_Listing  msic =new Module_BrowseBook_Resource_Listing();
		msic.To_Verify_User_should_be_shown_Excluded_from_Syllabus_Status_for_the_TP(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
