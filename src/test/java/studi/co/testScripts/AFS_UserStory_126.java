package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_MyLesson_Page;
import studi.co.pageModules.Module_Syllabus_Section;

public class AFS_UserStory_126 extends BaseClass {

	public AFS_UserStory_126() {
		super();
	}
	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled=true)    
	public void	T01_To_Verify_Syllabus_Options_In_The_Landing_Page() throws IOException, InterruptedException{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Syllabus_Option();
	}

	@Test(enabled=true)    
	public void	T02_To_Verify_Syllabus_Options_Should_Be_Tappable() throws Exception{

		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Syllabus_Options_Should_Be_Tappable();
	}

	@Test(enabled=true)    
	public void	T03_To_Verify_User_Should_Be_Able_To_View_The_Available_Resource_Of_The_BookShelf() throws Exception{

		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_The_Available_Resource_Of_The_BookShelf();
	}

	@Test(enabled=true)    
	public void	T04_To_Verify_User_Should_Be_Able_To_View_Its_Grade_School_Details_And_Education_Board_Details() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Grade_School_Details_And_Education_Board_Details();
	}

	@Test(enabled=true)    
	public void	T08_To_Verify_User_Should_Be_Shown_Completed_In_School_Status() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Completed_In_School_Status();
	}

	@Test(enabled=true)    
	public void	T12_To_Verify_User_Should_Be_Shown_Excluded_From_Syllabus_Status() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Excluded_From_Syllabus_Status();
	}

	@Test(enabled = true)    
	public void	T14_To_Verify_User_Should_Be_Able_To_Mark_The_Chapter_As_Completed_In_School_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_Chapter_As_Completed_In_School_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}

	@Test(enabled = true)    
	public void	T15_To_Verify_User_Should_Be_Able_To_Mark_The_Chapter_As_Excluded_From_Syllabus_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_Chapter_As_Excluded_From_Syllabus_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}

	@Test(enabled=true)    
	public void	T17_To_Verify_User_Should_Be_Shown_Status_Of_Each_TP() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Status_Of_Each_TP(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}

	@Test(enabled = true)
	public void	T20_To_Verify_User_Should_Be_Shown_Low_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Low_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject_low"),prop.getProperty("topic_low"));
	}

	@Test(enabled=true) 
	public void	T21_To_Verify_User_Should_Be_Shown_Medium_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Medium_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject_eng"),prop.getProperty("topic_medium"));
	}

	@Test(enabled=true)   
	public void	T22_To_Verify_User_Should_Be_Shown_High_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_High_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject2"),prop.getProperty("topic2"));
	}

	@Test(enabled = true)  
	public void	T25_To_Verify_User_Should_Be_Able_To_Mark_The_TPs_As_Completed_In_School_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_TPs_As_Completed_In_School_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}


	@Test(enabled=true)    
	public void	T26_To_Verify_User_Should_Be_Able_To_Mark_The_TPs_As_Excluded_From_Syllabus_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_TPs_As_Excluded_From_Syllabus_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}
