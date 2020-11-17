package studi.co.testScripts;

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
	public void To_Verify_user_should_be_able_to_navigate_to_review_plan() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Active_Study_Plan_Page();
		activePlan.Verify_Review_Plan_Button();
		activePlan.Validate_Mylessons_Page_Header();
	}
	
	@Test(description="To Verify a user should be able to view the available Resource of the bookshelf", priority=2, threadPoolSize=1, enabled=false)
	public void To_Verify_user_should_be_able_to_view_the_available_Resource_of_bookshelf() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Books_Page();
		//How to Check Users Cirriculam
	}
	
	@Test(description="To Verify a user should be able to view its grade, School Detail and Education Board details", priority=3, threadPoolSize=1, enabled=true)
	public void To_Verify_user_should_be_able_to_view_the_available_Resource_of_bookshelf_1() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Books_Shelf_Page();
		activePlan.Verify_Bottom_Of_Books_Page();
		activePlan.Verify_Edit_Icon_On_Bottom_Of_Books_Page();
		activePlan.Verify_Edit_Icon_Is_tappable_Books_Page();
		activePlan.Verify_Navigation_After_Tapping_On_Edit_On_Books_Page();
	}
	
	
}
