package studi.co.testScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_ReviewPlan;

public class AFS_UserStory_1046 extends BaseClass{
	
	
	public AFS_UserStory_1046() {
		super();
	}
	
//	@BeforeClass
//	public void createStudyPlan() throws Exception {
//		Module_Login login = new Module_Login();
//		Module_ReviewPlan mrs=new Module_ReviewPlan();
//		login.Login_to_app();
//		mrs.createPlan();
//		
//	}
	
	//@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}
	
	@Test(enabled=true)    
    public void	T01_To_Verify_User_Navigate_To_ReviewPlan() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_User_Navigate_to_ReviewPlan();
	}
	
	@Test(enabled=true)
    public void	T02_To_Verify_Review_Plan_tab() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ReviewPlan_Tab();
	}
	
	@Test(enabled=true)
    public void	T03_To_Verify_Contents_on_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Contents_on_ReviewPlan_Page();
	}
	
	@Test(enabled=true)
    public void	T04_To_Verify_Contents_of_Graph() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Contents_of_graph();
	}
	
	@Test(enabled=true) 
    public void	T05_To_Verify_Progress_of_Active_Plan_Datewise() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Progress_of_Active_Plan_Datewise();
	}

	@Test(enabled=true)  
    public void	T06_To_Verify_Filter_Option() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Filter_Option();
	}
	
	@Test(enabled=true)  
    public void	T07_To_Verify_Full_Plan_in_Graph() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Full_Plan_in_Graph();
	}
	
	@Test(enabled=true) //Monthly option
    public void	T08_To_Verify_Monthly_Option_in_Filter() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Monthly_Option();
	}
	
	@Test(enabled=true)	//Weekly Option is not displayed
    public void	T09_To_Verify_Weekly_Option_in_Filter() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Weekly_Option();
	}

	@Test(enabled=true)
    public void	T10_To_Verify_ProgressBar_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ProgressBar_InReviewPage();
	}
	
	@Test(enabled=true)
    public void	T11_To_Verify_ProgressBar_of_Each_Subject_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ProgressBar_ofEachSubject_InReviewPage();
	}
	
	@Test(enabled=true)
    public void	T12_To_Verify_By_Using_ProgressBar_How_Much_User_Has_Moved_Further_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_SeekBar_InReviewPage();
	}
	
	@Test(enabled=true)
    public void	T13_To_Verify_Turtle_Icon_On_Slow_Progress_of_Subject_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Turtle_Icon();
	}
	
	@Test(enabled=true)
    public void	T14_To_Verify_Rabbit_Icon_On_Fast_Progress_of_Subject_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Rabbit_Icon();
	}
	
	
	@Test(enabled=true)
    public void	T15_To_Verify_Subject_Shown_In_Review_Page_Is_Tappable() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_SubjectShown_In_ReviewPage_IsTappable();
	}
	
	@Test(enabled=true)
    public void	T16_To_Verify_Portions_Added_To_The_Subject_In_Active_Plan() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Portions_AddedToTheSubject_In_ActivePlan();
	}
	
	@Test(enabled=true)
    public void	T17_To_Verify_Total_No_Of_Topics_And_Chapters_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_TopicsAndChapters_InReviewPlanPage();
	}
	
	@Test(enabled=true)
    public void	T18_To_Verify_Plan_Detail_Tab_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_PlanDetailtab();
	}
	
	@Test(enabled=true)
    public void	T19_To_Verify_Details_In_Plan_Detail_Tab_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_DetailsIn_PlanDetailtab();
	}
	
	@Test(enabled=true)
    public void	T20_To_Verify_Modify_Tab_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ModifyTab_PlanDetailtab();
	}
	
	@Test(enabled=true)
    public void	T21_To_Verify_DeadLine_Tab_Under_Modify_Tab_In_Review_Plan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_DeadLineTab();
	}
	
	@Test(enabled=true)
    public void	T22_To_Verify_DeadLine_Tab_Under_Modify_Tab_Is_Functional() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_DeadLineTab_UnderModifyTab();
	}
	
	@Test(enabled=true)
    public void	T23_To_Verify_User_Should_Be_Able_To_Modify_The_Plans_DeadLine() throws Exception{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ToModify_ThePlansDeadLine();
	}
	
	@Test(enabled=true)
	 public void T24_To_Verify_Plan_Activation_with_Modified_Deadline() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_ModifiedDeadline();
		}
	
	@Test(enabled=true)
	 public void T25_To_Verify_Activation_Of_Plan_With_Unfeasible_Deadline() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_UnfeasibleDeadline();
		}
	
	@Test(enabled=true)
	 public void T26_To_Verify_User_Able_To_View_Modified_DeadLine_of_The_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_ModifiedDeadline_InMyLessonsPage();
		}
	
	@Test(enabled=true)
	 public void T27_To_Verify_Portion_Option_Under_Modify_Tab() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_PortionOption();
		}
	
	@Test(enabled=true)
	 public void T28_To_Verify_Portion_Option_Under_Modify_Tab_Is_Functional() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_PortionOption_IsFunctional();
		}
	
	@Test(enabled=true)   // Delete option is not visible
	 public void T29_To_Verify_User_able_to_Modify_the_Portion_added_To_The_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_toModify_thePortion();
		}
	
	@Test(enabled=true)
	 public void T30_To_Verify_Count_Of_Chapters_Edited_After_Modifying_The_Portion() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_toModify_CountOfChapters();
		}
	
	@Test(enabled=true)
	 public void T31_To_Verify_User_Can_Discard_The_Modified_Portion_During_Editing() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_UserCan_Discard_TheModifiedPortion();
		}
	
	@Test(enabled=true)
	 public void T32_To_Verify_User_Should_Be_Able_To_Activate_Modified_Portion_To_The_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_Activation_ofModifiedPortion_ToThePlan();
		}
	
	@Test(enabled=true)
	 public void T33_To_Verify_User_Should_Be_Able_To_View_The_Modified_Portion_Added_To_The_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_Activation_ofModifiedPortion();
		}
	
	@Test(enabled=true)
	 public void T34_To_Verify_Pause_Tab_In_Review_Page() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_PauseTab();
		}
	
	@Test(enabled=true)
	 public void T35_To_Verify_Pause_Tab_Is_Functional() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_PauseTab_IsFunctional();
		}
	
	@Test(enabled=true)
	 public void T36_To_Verify_User_Able_To_Pause_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_UserAbleTo_PausePlan();
		}
	
	@Test(enabled=true)
	 public void T37_To_Verify_User_Able_To_Activate_Pause_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_UserAbleTo_Activate_PausePlan();
		}
	
	@Test(enabled=true)
	 public void T38_To_Verify_User_Able_To_Activate_Any_Other_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_UserAbleTo_Activate_AnyOtherPlan();
		}
	
	
	@Test(enabled=true)
	 public void T39_Verify_On_Tapping_Paused_Plan_User_Should_Not_be_shown_MyLessons_Page() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_OnTapping_PausedPlan_UserShouldNotbe_shown_MyLessons_Page();
		}
	
	@Test(enabled=true)
	 public void T40_Verify_On_Tapping_Paused_Plan_User_Should_Not_be_shown_StudyRing() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_OnTapping_PausedPlan_UserShouldNotbe_shown_StudyRing();
		}
	
	@Test(enabled=true)
	 public void T41_Verify_Once_Active_Plan_isPaused_User_Can_Reactivate_It_Or_Can_Activate_Any_Other_Plan() throws IOException, InterruptedException, ParseException{
			Module_ReviewPlan mrs=new Module_ReviewPlan();
			mrs.toVerify_Paused_ActivePlan();
		}
	
	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
	
}
