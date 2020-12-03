package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Verify_Answer_Options_In_Practice;

public class TC15_Verify_Answers_are_Selectable_and_Deselectable_in_Practice extends BaseClass{
	
public TC15_Verify_Answers_are_Selectable_and_Deselectable_in_Practice() {
	super(); 
}

@Test 
public void verify_Answers_Are_Selectable_Deselectable() throws InterruptedException {
	Module_Verify_Answer_Options_In_Practice mvaoip=new Module_Verify_Answer_Options_In_Practice(); 
	mvaoip.verify_Answers_Selectable_Deselectable();
}
}
