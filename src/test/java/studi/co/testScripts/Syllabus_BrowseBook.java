package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Syllabus_BrowseBook;

public class Syllabus_BrowseBook extends BaseClass{

	//Total=13
	//TC6,TC7,TC8=Pending. Functions not yet implimented
	// 5 Pass, 5 Fail	
	
	public Syllabus_BrowseBook() {
		super();
	}
	
	@Test(enabled= true)
	public void TC09_To_Verify_Only_Single_Radio_Button_Can_Be_Select_At_Time() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_radio_buttons();
	}
	
	@Test(enabled= true)
	public void TC10_To_Verify_Revision_Functionality() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_revision_functionality();
	}
	
	@Test(enabled= true)
	public void TC11_To_Verify_Practice_Functionality() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_practice_functionality();
	}
	
	@Test(enabled= true)
	public void TC12_To_Verify_Revision_Is_Disabled_If_Excluded_From_Syllabus() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_revision_excludeFromSyllabus_functionality();	
	} 
	
	@Test(enabled= true)
	public void TC13_To_Verify_Practice_Is_Disabled_If_Excluded_From_Syllabus() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_practice_excludeFromSyllabus_functionality();	
	}
	
	@Test(enabled= true)
	public void TC14_To_Verify_Revision_Is_Disabled_If_Completed_In_School() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_revision_completedInSchool_functionality();	
	} 
	
	@Test(enabled= true)
	public void TC15_To_Verify_Practice_Is_Disabled_If_Completed_In_School() throws MalformedURLException, InterruptedException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.traverse_To_Topic(prop.getProperty("subject77"), prop.getProperty("topic77"));
		msb.validate_practice_completedInSchool_functionality();	
	} 
	
	@Test(enabled= true)
	public void TC16_To_Verify_User_Can_Navigate_To_Create_Oral_Test_Page() throws MalformedURLException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.validate_create_oral_test_page();
	}
	
	@Test(enabled= true)
	public void TC17_To_Verify_User_Can_Navigate_To_Create_Oral_Test_Page() throws MalformedURLException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.validate_study_plan_page();
	}
	
	@Test(enabled= true)
	public void TC18_To_Verify_User_Can_Navigate_To_Create_Oral_Test_Page() throws MalformedURLException {
		Module_Syllabus_BrowseBook msb=new Module_Syllabus_BrowseBook();
		msb.validate_digital_test_page();
	}
	
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}
