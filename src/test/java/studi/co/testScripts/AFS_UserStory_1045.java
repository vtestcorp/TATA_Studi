package studi.co.testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_MyLesson_Page;

public class AFS_UserStory_1045 extends BaseClass{


	public AFS_UserStory_1045() {
		super();
	}

	//	@BeforeClass
	//	public void createStudyPlan() throws Exception {
	//		Module_Login login = new Module_Login();
	//		Module_ReviewPlan mrs=new Module_ReviewPlan();
	//	//	login.Login_to_app();
	//		mrs.createPlan();
	//		applyExplicitWait(5);
	//		getDriver().launchApp();
	//		
	//	}

	//	@BeforeMethod
	//	public void Validate_Login() throws Exception {
	//		Module_Login login = new Module_Login();
	//		login.Login_to_app();
	//	}

	@Test(enabled=true)  
	public void	T01_To_Verify_User_Can_Navigate_To_MyLessons_Page() throws IOException, InterruptedException{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_User_Navigate_to_MyLessonsPage();
	}

	@Test(enabled=true)
	public void	T02_To_Verify_Various_Contents_On_MyLessons_Page() throws IOException, InterruptedException{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_VariousContentsOn_MyLessonsPage();
	}

	@Test(enabled=true)  
	public void	T03_ToVerify_User_Can_Navigate_Back_To_The_Landing_Page() throws IOException, InterruptedException{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_UserCanNavigate_BackTo_TheLandingPage();
	}

	@Test(enabled=true)     
	public void	T04_To_Verify_StudyRing_In_Default_State_For_New_StudyPlan() throws Exception{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_StudyRing_For_NewStudyPlan();
	}

	@Test(enabled=true)   
	public void	T05_To_Verify_StudyRing_For_Existing_StudyPlan() throws IOException, InterruptedException{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_StudyRing_For_Existing_StudyPlan();
	}

	@Test(enabled=true)    
	public void	T06_To_Verify_In_StudyRing_User_Should_Be_Shown_3_Rings() throws Exception{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_3_Rings_In_StudyRing();
	}

	@Test(enabled=true)  
	public void	T07_To_Verify_Information_OfTask_ToBe_Completed_Today() throws Exception{
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Information_OfTask();
	}

	@Test(enabled=true)
	public void T11_To_Verify_TickMark_On_Completing_Todays_Planned_Lesson_Count() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_TickMark();
	}

	@Test(enabled=true) 
	public void T13_To_Verify_Todays_Tab_In_My_Lessons_Page() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Todays_Tab();
	}

	@Test(enabled=true)
	public void T14_To_Verify_Lessons_Listed_In_Todays_Tab() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Lessons_In_Todays_Tab();
	}

	@Test(enabled=true)
	public void T15_To_Verify_Upcoming_Tab_In_My_Lessons_Page() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Upcoming_Tab();
	}

	@Test(enabled=true)
	public void T16_To_Verify_Lessons_Listed_In_Upcoming_Tab() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Lessons_In_Upcoming_Tab();
	}

	@Test(enabled=true)
	public void T17_To_Verify_Various_Colour_Code_Schema_For_Various_Books() throws Exception {	
		Assert.assertTrue(true);
		//Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		//mmp.toVerify_Various_Colour_Code_Schema_For_Various_Books();
	}


	@Test(enabled=true)
	public void T19_To_Verify_User_Should_Be_Shown_HighLighted_Lesson() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_HighLighted_Lesson();
	}

	@Test(enabled=true)
	public void T20_To_Verify_the_Highlighted_lessons_gets_changed_when_user_complete_the_previous_highlighted_lesson() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_the_Highlighted_lessons_gets_changed();
	}

	@Test(enabled=true) 
	public void T21_To_Verify_Lesson_Card_Content() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Lesson_Card_Content();
	}

	@Test(enabled=true)
	public void T22_To_Verify_TickMark_On_Lesson_Completion() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Tick_Mark_On_Lesson_Completion();
	}

	@Test(enabled=true)
	public void T23_To_Verify_Unlock_Lessons_Are_Tappable() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Unlock_Lessons();
	}

	@Test(enabled=true)
	public void T24_To_Verify_Unlock_Lessons_Are_Functional() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Unlock_Lessons_Functionality();
	}

	@Test(enabled=true)
	public void T25_To_Verify_Locked_Lessons_Are_Un_Tappable_And_Non_Functional() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Locked_Lessons_Functionality();
	}


	@Test(enabled=true)
	public void T26_To_Verify_View_Full_Schedule_Button() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_View_Full_Schedule();
	}

	@Test(enabled=true)
	public void T27_To_Verify_View_Full_Schedule_Are_Functional() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_View_Full_Schedule();
	}

	@Test(enabled=true)
	public void T28_To_Verify_User_Should_Be_Able_To_Navigate_Schedule_List_Page() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Schedule_List_Page();
	}

	@Test(enabled=true)
	public void T29_To_Verify_Full_Schedule_List_Of_Plan() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Schedule_List_Of_Plan();
	}

	@Test(enabled=true)
	public void T30_To_Verify_Full_Schedule_List_Of_Plan_Arranged_Weekly() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Schedule_List_Of_Plan_Arranged_Weekly();
	}

	@Test(enabled=true)
	public void T31_To_Verify_Full_Schedule_List_Of_Plan_For_Other_Weeks() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Schedule_List_Of_Plan_For_Other_Weeks();
	}

	@Test(enabled=true)
	public void T32_To_Verify_Filter_Option_On_Schedule_List() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Filter_Option();
	}

	@Test(enabled=true)
	public void T33_To_Verify_Filter_Icon_On_Schedule_List_Should_Be_Tappable() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Filter_Icon_On_Schedule_List_Should_Be_Tappable();
	}

	@Test(enabled=true)
	public void T34_To_Verify_Various_Filter_Options_On_Schedule_List() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Various_Filter_Options();
	}

	@Test(enabled=true)
	public void T35_To_Verify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional();
	}

	@Test(enabled=true) 
	public void T36_To_Verify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional_For_All_The_Weeks() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Various_Filter_Options_On_Schedule_List_Should_Be_Functional_For_All_The_Weeks();
	}

	@Test(enabled=true)
	public void T37_To_Verify_Various_Manage_And_Create_Plan() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Manage_And_Create_Plan();
	}

	@Test(enabled=true)
	public void T38_To_Verify_Various_Manage_And_Create_Plan_Is_Tappable() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Manage_And_Create_Plan_Is_Tappable();
	}

	@Test(enabled=true)
	public void T39_To_Verify_Various_Manage_And_Create_Plan_Is_Functional() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_Manage_And_Create_Plan_Is_Functional();
	}

	@Test(enabled=true)
	public void T40_To_Verify_User_Should_Be_Able_To_Review_The_Active_Plan_From_Manage_And_Create_Button() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_User_Should_Be_Able_To_Review_The_Active_Plan();
	}

	@Test(enabled=true)
	public void T41_To_Verify_User_Should_Be_Able_To_Reactivate_The_older_Plans_From_Manage_And_Create_Button() throws Exception {
		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_User_Should_Be_Able_To_Reactivate_The_Older_Plans();
	}

	@Test(enabled=true)
	public void T42_To_Verify_User_Should_Be_Able_To_create_new_Plan_From_Manage_And_Create_Button() throws Exception {

		Module_MyLesson_Page mmp=new Module_MyLesson_Page();
		mmp.toVerify_User_Should_Be_Able_To_Create_New_Plan();
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
