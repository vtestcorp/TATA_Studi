package studi.co.testScripts;

import java.io.IOException;

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
	
	@Test(enabled=false)    
    public void	T01_To_Verify_Syllabus_Options_In_The_Landing_Page() throws IOException, InterruptedException{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Syllabus_Option();
	}
	
	@Test(enabled=false)    
    public void	T02_To_Verify_Syllabus_Options_Should_Be_Tappable() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Syllabus_Options_Should_Be_Tappable();
	}
	
	@Test(enabled=false)    
    public void	T03_To_Verify_User_Should_Be_Able_To_View_The_Available_Resource_Of_The_BookShelf() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_The_Available_Resource_Of_The_BookShelf();
	}
	
	@Test(enabled=false)    
    public void	T04_To_Verify_User_Should_Be_Able_To_View_Its_Grade_School_Details_And_Education_Board_Details() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_Grade_School_Details_And_Education_Board_Details();
	}
	
	@Test(enabled = false)    
    public void	T08_To_Verify_User_Should_Be_Shown_Completed_In_School_Status() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Completed_In_School_Status();
	}
	
	@Test(enabled = false)    
    public void	T12_To_Verify_User_Should_Be_Shown_Excluded_From_Syllabus_Status() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Excluded_From_Syllabus_Status();
	}
	
	@Test(enabled = false)    
    public void	T14_To_Verify_User_Should_Be_Able_To_Mark_The_Chapter_As_Completed_In_School_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_Chapter_As_Completed_In_School_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}
	
	@Test(enabled = false)    
    public void	T15_To_Verify_User_Should_Be_Able_To_Mark_The_Chapter_As_Excluded_From_Syllabus_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_Chapter_As_Excluded_From_Syllabus_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}
	
	@Test(enabled=false)    
    public void	T17_To_Verify_User_Should_Be_Shown_Status_Of_Each_TP() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Status_Of_Each_TP(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}
	
	@Test(enabled = false)
    public void	T20_To_Verify_User_Should_Be_Shown_Low_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Low_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject2"),prop.getProperty("topic2"));
	}
	
	@Test(enabled=false) 
    public void	T21_To_Verify_User_Should_Be_Shown_Medium_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_Medium_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject2"),prop.getProperty("topic2"));
	}
	
	@Test(enabled=false)   
    public void	T22_To_Verify_User_Should_Be_Shown_High_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Be_Shown_High_Confidence_Status_For_The_Tp_In_Which_User_Has_Scored_Low_Confidence(prop.getProperty("subject2"),prop.getProperty("topic2"));
	}
	
	@Test(enabled = false)  
    public void	T25_To_Verify_User_Should_Be_Able_To_Mark_The_TPs_As_Completed_In_School_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_TPs_As_Completed_In_School_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}
	
	
	@Test(enabled=true)    
    public void	T26_To_Verify_User_Should_Be_Able_To_Mark_The_TPs_As_Excluded_From_Syllabus_Manually() throws Exception{
		Module_Syllabus_Section mss=new Module_Syllabus_Section();
		mss.toVerify_User_Should_Able_To_Mark_The_TPs_As_Excluded_From_Syllabus_Manually(prop.getProperty("subject1"),prop.getProperty("topic1"));
	}
	
}
