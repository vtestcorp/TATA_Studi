package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Excluded_From_Syllabus_Manually;

public class Mark_Excluded_From_Syllabus_Manually extends BaseClass{

		public Mark_Excluded_From_Syllabus_Manually() {
			super();

	}
		@Test
		public void Validate_complited_in_school_status() throws Exception {
			Module_Excluded_From_Syllabus_Manually CSP = new Module_Excluded_From_Syllabus_Manually();
			CSP.Verify_Excluded_From_Syllabus();
		}
	}
