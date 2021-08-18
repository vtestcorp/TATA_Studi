package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_My_Account;

public class My_Account_Tests extends BaseClass {
	
	public My_Account_Tests(){
		super();
	}
	//TC17, 18 hold
	
	@Test(enabled = true)//pass,done
	public void TC_01_Verify_Choose_A_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
		Module_My_Account account=new Module_My_Account();
		account.verify_Choose_A_Profile_Functionality_On_Profile_Page();
		
	}
	
	@Test(enabled = true)//pass,done
	public void TC_02_Verify_Sign_Out_Functionality_On_Choose_Profile_Page() throws MalformedURLException {
		Module_My_Account account=new Module_My_Account();
		account.verify_Sign_Out_Functionality_On_Choose_Profile_Page();
	}
	
	@Test(enabled = true)//pass done
	public void TC_03_Verify_Choose_A_Profile_Functionality_On_My_Account_Page() throws MalformedURLException {
		Module_My_Account account=new Module_My_Account();
		account.verify_Choose_A_Profile_Functionality_On_My_Account_Page();
	}
	
	@Test(enabled = true)//pass done
	public void TC_04_Verify_Choose_A_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User() throws MalformedURLException {
		Module_My_Account account=new Module_My_Account();
		account.verify_Choose_A_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User();
	}
	
	@Test(enabled = true)//pass done
	public void TC_05_Verify_Expired_Plan_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
		Module_My_Account account=new Module_My_Account();
		account.verify_Expired_Plan_Profile_Functionality_On_Profile_Page();
		
	}
	
    @Test(enabled = true)//pass done
	public void TC_06_Verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page();
	}
    
    
    @Test(enabled = true)//done, pass
    public void TC_07_Verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User();
    	
    }
    
    @Test(enabled = false)//$19 Plan is not available so far its on hold
    public void TC_08_Verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page() {
    	Module_My_Account account=new Module_My_Account();
    }
    
    
    
    @Test(enabled = true)//pass but actual fail
    public void TC_09_Verify_The_Functionality_Of_Contact_Us_To_Add_More_Link_On_Profile() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Functionality_Of_Contact_Us_To_Add_More_Link_On_Profile();
    	
    }
    
    @Test(enabled = true)//we are unable to see "Studi" logo for mobile App
    public void TC_10_Verify_The_Functionality_Of_Profile_Icon() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Functionality_Of_Profile_Icon();
    	
    }
    
    @Test(enabled = true)//done pass
    public void TC_11_Verify_The_Functionality_Of_Profile_Popup_For_Close() throws MalformedURLException{
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Functionality_Of_Profile_Popup_For_Close();
    	
    	
   }
    
   @Test(enabled = true)//done pass
    public void TC_12_Verify_The_Functionality_Of_Profile_Popup_For_Switch_Profile() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Profile_Popup_For_Switch_profile();
    	
    }
   
   @Test(enabled = true, priority=-1)//fail done only two profile supported
   public void TC_13_Verify_The_Functionality_Of_Profile_Popup_For_Add_New_Profile() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Profile_Popup_For_Add_New_Profile();
	   
   }
   
   @Test(enabled = true)//pass done
   public void TC_14_Verify_The_Functionality_Of_Profile_Popup_For_Profile_Link() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Profile_Popup_For_Profile_Link();
	   
   }
   
   @Test(enabled= true)//pass done
   public void TC_15_Verify_The_Functionality_Of_Profile_Popup_For_Syllabus_Link() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Profile_Popup_For_Syllabus_Link();
	   
   }
  
   @Test(enabled = true)//pass done
   public void TC_16_Verify_The_Functionality_Of_Profile_Popup_For_Account_Link() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Profile_Popup_For_Account_Link();
   }
   
  
   @Test(enabled = true)//we can not redirect to TATA done
   public void TC_21_Verify_The_Logo_Of_The_Application_Is_clickable() throws MalformedURLException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Logo_Of_The_Application_Clickable();
	   
   }
   
   @Test(enabled = true)//pass done
   public void TC_22_Verify_The_Functionality_Of_Carousel_What_Would_You_Like_To_Do_Next() throws MalformedURLException, InterruptedException {
	   Module_My_Account account=new Module_My_Account();
	   account.verify_The_Functionality_Of_Carousel_What_Would_You_Like_To_Do_Next();
	   
   }
   
    @Test(enabled = true)//done fail
    public void TC_23_Verify_The_Functionality_Of_Each_Carousel_Page() throws MalformedURLException, InterruptedException {
	    Module_My_Account account=new Module_My_Account();
	    account.verify_The_Functionality_Of_Each_Carousel_Page();
   }
   
    @Test(enabled = true, priority=-1)//done wip fail
    public void TC_24_Verify_The_Functionality_Of_Assignments_Carousel() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Functionality_Of_Assignments_Carousel();
    	
     } 
    
    @Test(enabled = true, priority=-1)//WIp
    public void TC_25_Verify_The_Functionality_Of_Carousel_In_Case_Of_Update_Delete() throws MalformedURLException, InterruptedException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Functionality_Of_Carousel_In_Case_Of_Update_Delete();
    	
    }
    
    @Test(enabled = false)//we dont have multiuser for this profile so for now this is on hold
    public void TC_26_Verify_The_Data_In_Carousel_What_Would_You_Like_To_Do_Next_In_Case_Of_Multiuser() {
    	Module_My_Account account=new Module_My_Account();
    	
    }
    
    @Test(enabled = false)//we dont have multiuser for this profile so for now this is on hold
    public void TC_27_Verify_The_Data_In_Carousel_What_Would_You_Like_To_Do_Next_In_Case_Of_Religion() {
    	Module_My_Account account=new Module_My_Account();
    	
    }
    
    
    
    @Test(enabled = true, priority=-1)//done
    public void TC_32_Verify_Logout_Functionality() throws MalformedURLException {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_Logout_Functionality();
    	
    }
    
    @Test(enabled =true)//done
    public void TC_33_Verify_The_Data_At_Footer() {
    	Module_My_Account account=new Module_My_Account();
    	account.verify_The_Data_At_Footer();
    	
    }
    
   @Test(enabled = false)// Report An Issues not available for mobile App hold
   public void TC_28_Verify_The_Functionality_Of_Reprot_An_Issues() {
	   Module_My_Account account=new Module_My_Account();
	  
   }
   
   @AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}
}
