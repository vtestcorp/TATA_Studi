package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Get_Syllabus_Tab_Label;

public class Confirm_Syllabus_Tab extends BaseClass {
	
	public Confirm_Syllabus_Tab() {
		super();
}
	@Test
	public void Validate_complited_in_school_status() throws Exception {
		Module_Get_Syllabus_Tab_Label CSP = new Module_Get_Syllabus_Tab_Label();
		CSP.Verify_Syllabus_Tab_Label();
	}
	
	}
