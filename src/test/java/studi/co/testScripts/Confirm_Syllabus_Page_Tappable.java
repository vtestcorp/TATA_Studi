package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Syllabus_Tappable;

public class Confirm_Syllabus_Page_Tappable extends BaseClass {

	public class Confirm_Syllabus_Page extends BaseClass {

		public Confirm_Syllabus_Page() {
			super();
		}

		@Test
		public void Validate_Syllabus_Tappable() throws Exception {
			Module_Syllabus_Tappable CSP = new Module_Syllabus_Tappable();
			CSP.Verify_Syllabus_Tappable();
		}

	}
}
