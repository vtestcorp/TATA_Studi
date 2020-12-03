package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Verify_Answer_Options_In_Practice;

public class TC14_Verify_Answer_Options_in_Practice_Quiz extends BaseClass {
	
	public TC14_Verify_Answer_Options_in_Practice_Quiz() {
		super();
		
	}
	
	@Test
	public void verifyAnswerOptions() throws InterruptedException {
		Module_Verify_Answer_Options_In_Practice mvaoip=new Module_Verify_Answer_Options_In_Practice();
		mvaoip.module_Verify_Answer_Options_In_Practice();
	}

}
