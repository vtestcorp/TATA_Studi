package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Mark_Completed_In_School_Manually;

public class Mark_Completed_In_School_Manually extends BaseClass{

	public Mark_Completed_In_School_Manually() {
		super();

}
	@Test
	public void Validate_complited_in_school_status() throws Exception {
		Module_Mark_Completed_In_School_Manually CSP = new Module_Mark_Completed_In_School_Manually();
		CSP.Verify_Completed_In_School_Status();
	}
}
