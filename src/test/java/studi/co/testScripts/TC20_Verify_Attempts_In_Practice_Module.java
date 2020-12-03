package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Verify_Attempt_In_Practice;

public class TC20_Verify_Attempts_In_Practice_Module extends BaseClass{
	
	public TC20_Verify_Attempts_In_Practice_Module() {
		super(); 
	}
	@Test
	public void verify_Attempt() throws InterruptedException {
		Module_Verify_Attempt_In_Practice mvaip=new Module_Verify_Attempt_In_Practice(); 
		mvaip.verify_Attempt_In_Practice();
	}
}
