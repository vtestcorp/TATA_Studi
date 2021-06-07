package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Assignment_Oral_Task;

public class Assignment_Oral_Task  extends BaseClass {
	public  Assignment_Oral_Task() {
		super();
	}

	@Test(enabled = true)
	public void TC07_To_Verify_that_from_syllabus_menu_user_should_be_able_to_Navigate_Oral_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Task  maot=new Module_Assignment_Oral_Task();
		maot.to_verify_that_from_syllabus_menu_user_should_be_able_to_navigate_oral_test();
	}

	@Test(enabled = true)
	public void TC08_To_Verify_After_Clicking_On_Oral_Test_User_Should_be_able_to_View_Oral_Test_Option() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Task  maot=new Module_Assignment_Oral_Task();
		maot.to_verify_after_clicking_on_oral_test_user_should_be_able_to_view_oral_test_option();
	}
	@Test(enabled = true)
	public void TC09_To_Verify_that_User_Should_be_able_to_Add_the_Content_Even_if_Striked_off_for_Creating_Oral_Test() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Task  maot=new Module_Assignment_Oral_Task();
		maot.to_verify_that_user_should_be_able_to_add_the_Content_even_if_striked_off_for_creating_oral_test(prop.getProperty("subject"),prop.getProperty("topic1"));
	}
	@Test(enabled = true,priority=-1)
	public void TC10_To_Verify_That_User_is_Able_to_Select_the_Chapters_from_Subject() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Task  maot=new Module_Assignment_Oral_Task();
		maot.to_verify_that_user_is_able_to_select_the_chapters_from_subject(prop.getProperty("subject"),prop.getProperty("topic1"));
	}
	@Test(enabled = false)
	public void TC11_To_Verify_That_User_is_Able_to_Select_the_Topics_from_Subject() throws MalformedURLException, InterruptedException {
		Module_Assignment_Oral_Task  maot=new Module_Assignment_Oral_Task();
		maot.to_verify_that_user_is_able_to_select_the_topics_from_subject();
	}
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
