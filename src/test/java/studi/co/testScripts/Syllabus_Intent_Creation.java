package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Oral_Test;
import studi.co.pageModules.Module_Syllabus_Intent_Creation;

public class Syllabus_Intent_Creation extends BaseClass {
	public  Syllabus_Intent_Creation() {
		super();
	}

	@Test(enabled = true)
	public void TC01_To_Verify_when_click_on_Syllabus_shown_all_the_Chapters_Topics_from_BrowseBook_section() throws Exception {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_all_the_Chapters_Topics_from_BrowseBook_section();
	}

	@Test(enabled = true)
	public void TC02_To_Verify_user_should_be_able_to_view_the_link_to_create_Digital_test() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_be_able_to_view_the_link_to_create_Digital_test(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}

	@Test(enabled = true)
	public void TC03_To_Verify_user_should_be_able_to_add_the_Content_even_if_striked_off() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_be_able_to_add_the_Content_even_if_striked_off(prop.getProperty("subject"),prop.getProperty("topic1"));
	}

	@Test(enabled = true)
	public void TC04_To_Verify_On_click_one_of_the_topic_or_chapter_next_button_shown() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.On_click_one_of_the_topic_or_chapter_next_button_shown(prop.getProperty("subject"),prop.getProperty("topic_1"));
	}
	@Test(enabled = true)
	public void TC05_To_Verify_click_on_delete_icon_test_creation_will_be_aborted() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_Verify_click_on_delete_icon_test_creation_will_be_aborted(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = false)//Hold
	public void TC06_To_Verify_user_should_not_be_allowed_to_proceed_further_keeping_Title_field_blank () throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_not_be_allowed_to_proceed_further_keeping_Title_field_blank(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}

	@Test(enabled = true)
	public void TC07_To_verify_user_should_be_able_to_Choose_difficulty_level() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_be_able_to_Choose_difficulty_level(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}
	@Test(enabled = true)
	public void TC08_To_verify_user_should_be_able_to_select_Duration() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_be_select_duration(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}
	@Test(enabled = true)
	public void TC09_To_verify_user_should_be_able_to_select_date_for_the_test() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.to_verify_user_should_be_able_to_select_date_for_the_test(prop.getProperty("subject_History"),prop.getProperty("topic_H"));

	}

	@Test(enabled = true)
	public void TC11_To_verify_test_should_be_created_on_clicking_the_Assign_button() throws MalformedURLException, InterruptedException {
		Module_Syllabus_Intent_Creation  msic =new Module_Syllabus_Intent_Creation();
		msic.test_should_be_created_on_clicking_the_Assign_button(prop.getProperty("subject_History"),prop.getProperty("topic_H"));
	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}