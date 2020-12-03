package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Verify_Answer_Options_In_Practice;

public class TC12_Verify_MCQ_Questions_In_Practice_Module extends BaseClass{
	
	public TC12_Verify_MCQ_Questions_In_Practice_Module() {
		super(); 
	}
	@Test
	public void verify_MCQ_Questions_In_Practice_Module() throws InterruptedException {
		Module_Login login = new Module_Login();
		login.Login_to_app();
		
		Module_Verify_Answer_Options_In_Practice mvaoip=new Module_Verify_Answer_Options_In_Practice(); 
		mvaoip.module_Verify_Answer_Options_In_Practice();
		mvaoip.verify_Question_Count_In_Practice();
		
	}
}
