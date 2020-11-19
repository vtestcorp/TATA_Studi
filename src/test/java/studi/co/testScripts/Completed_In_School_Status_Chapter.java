package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Completed_In_School;
import studi.co.pageModules.Module_Create_Study_Plan;

public class Completed_In_School_Status_Chapter extends BaseClass {
	
	public Completed_In_School_Status_Chapter() {
		super();

}
	@Test
	public void Validate_complited_in_school_status() throws Exception {
		Module_Completed_In_School CSP = new Module_Completed_In_School();
		CSP.Verify_Completed_In_School_Status();
	}
}
