package studi.co.testScripts;

import org.testng.annotations.Test;

import studi.co.Base.*;
import studi.co.pageModules.*;

public class Login extends BaseClass {

	// Calling base class constructor.
	public Login() {
		super();
	}

	@Test
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

}
