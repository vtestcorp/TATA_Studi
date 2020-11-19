package studi.co.testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Create_Study_Plan;
import studi.co.pageModules.Module_Study_Plan_Review_Active_Plan;

public class Study_Plan_Review_Active_Plan extends BaseClass{
  
	public Study_Plan_Review_Active_Plan()
	{
		super();
	}
	
	@Test(description="To Verify user should be able to navigate to review plan", priority=1, threadPoolSize=1, enabled=false)
	public void Verify_user_should_be_able_to_navigate_to_review_plan() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Active_Study_Plan_Page();
		activePlan.Verify_Review_Plan_Button();
		activePlan.Validate_Mylessons_Page_Header();
	}
	
	@Test(description="To Verify a user should be able to view the available Resource of the bookshelf", priority=2, threadPoolSize=1, enabled=false)
	public void Verify_user_should_be_able_to_view_the_available_Resource_of_bookshelf() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		//How to Check Users Cirriculam
	}
	
	@Test(description="To Verify a user should be able to view its grade, School Detail and Education Board details", priority=3, threadPoolSize=1, enabled=false)
	public void Verify_user_should_be_able_to_view_the_available_Resource_of_bookshelf_1() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Bottom_Of_Books_Page();
		activePlan.Verify_Edit_Icon_On_Bottom_Of_Books_Page();
		activePlan.Verify_Edit_Icon_Is_tappable_Books_Page();
		activePlan.Verify_Navigation_After_Tapping_On_Edit_On_Books_Page();
	}
	
	
	@Test(description="To Verify the user should be able to Mark the TP status as Completed In School Manually", priority=4, threadPoolSize=1, enabled=false)
	public void Verify_the_user_should_be_able_to_Mark_the_TP_status_as_Completed_In_School_Manually() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter();
		activePlan.Verify_Tapping_On_TP();
	}
	
	@Test(description="To Verify User should be shown Excluded from Syllabus Status for the chapter which is excluded from the users curriculum", priority=5, threadPoolSize=1, enabled=false)
	public void Verify_User_should_be_shown_Excluded_from_Syllabus_Status_for_the_chapter_which_is_excluded_from_the_users_curriculum() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter();
	}
	
	@Test(description="To Verify the user should be able to Mark the TP status as Excluded from Syllabus Manually", priority=6, threadPoolSize=1, enabled=false)
	public void Verify_the_user_should_be_able_to_Mark_the_TP_status_as_Excluded_from_Syllabus() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter_Myself();
		activePlan.Navigate_To_TP_AboutMe_And_Verify_Presence_Of_Toggle_Switch_Options();
	}
	
	@Test(description="To Verify User should be shown the Status / Confidence score of TP", priority=7, threadPoolSize=1, enabled=false)
	public void Verify_User_should_be_shown_the_Status_Confidence_score_of_TP() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter_Myself();
		activePlan.Verify_Confidence_Present_Against_TP();
	}
	
	
	@Test(description="AFS-127: TC-15: To Verify the user should be able to Navigate to Practice from Topic", priority=8, threadPoolSize=1, enabled=false)
	public void Verify_the_user_should_be_able_to_Navigate_to_Practice_from_Topic() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter_MyBody(4);
	}
	
	@Test(description="AFS-127: TC-16: To Verify the user should be able to Navigate to Notes listing page", priority=8, threadPoolSize=1, enabled=false)
	public void Verify_the_user_should_be_able_to_Navigate_to_Notes_listing_page() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		activePlan.Verify_Tapping_On_Book();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Tapping_And_Navigation_To_Chapter_MyBody_Check_Notes(4);
	}
	
	@Test(description="AFS-127: TC-22: To Verify user should be able to navigate to  the StrikedOut Topics", priority=8, threadPoolSize=1, enabled=true)
	public void Verify_user_should_be_able_to_navigate_to_the_StrikedOut_Topics() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Navigate_To_Book1();
		activePlan.Verify_Highlight_Pop_Up();
	}
	
	
	
	
}
