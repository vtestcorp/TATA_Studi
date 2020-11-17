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
	
	
	@Test(description="To Verify user should be able to navigate to review plan", priority=1, threadPoolSize=1)
	public void Verify_Navigation_To_Review_Plan_Page() throws Exception 
	{
		Module_Study_Plan_Review_Active_Plan activePlan = new Module_Study_Plan_Review_Active_Plan();
		activePlan.Validate_Home_Page_Header();
		activePlan.Navigate_To_Active_Study_Plan_Page();
		activePlan.Validate_Mylessons_Page_Header();
//		activePlan.Navigate_To_Review_Plan_Page();
	
	
	}
}
