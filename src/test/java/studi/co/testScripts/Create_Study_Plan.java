package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.*;
import studi.co.pageModules.*;

public class Create_Study_Plan extends BaseClass{

	// Calling base class constructor.
	public Create_Study_Plan() {
		super();
	}

	@Test
	public void Validate_create_study_plan() throws Exception {
		Module_Create_Study_Plan CSP = new Module_Create_Study_Plan();
		CSP.Validate_create_study_plan();
	}

}
