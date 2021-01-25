package studi.co.testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Create_Study_Plan;
import studi.co.pageModules.Module_Login;

public class AFS_UserStory_1044 extends BaseClass {

	public AFS_UserStory_1044() {
		super();
	}

	@BeforeMethod
	public void Validate_Login(Method m) throws Exception {
		Properties props = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\studi\\co\\Config\\config.properties";
		File f = new File(path);
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			if (m.getName().equals("TC01_Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan"))
				props.setProperty("mobileNumber", prop.getProperty("newUser"));
			else
				props.setProperty("mobileNumber", prop.getProperty("existingUser"));
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = false)// only for new user(No previously active study plan)
	public void TC01_Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false) //Validate only if user has created a plan previously
	public void TC02_Verify_Existing_User_Should_Be_Able_To_Navigate_Create_Study_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}

	@Test(enabled = false) //Validate only if user has created a plan and the plan is still active
	public void TC03_Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_To_Test_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}
	
	@Test(enabled = true) //Validate only if user has created a plan and the plan is paused
	public void TC04_Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan()
			throws MalformedURLException, InterruptedException {
		Module_Create_Study_Plan csp = new Module_Create_Study_Plan();
		csp.Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan(prop.getProperty("subject"),
				prop.getProperty("topic"));
	}
	
	
	
	
	
	
	
	
	
	/*
	 * @AfterMethod public void restApp() throws MalformedURLException {
	 * applyExplicitWait(5); getDriver().launchApp(); }
	 */

	@AfterClass
	private void setUserID() {
		Properties props = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\studi\\co\\Config\\config.properties";
		File f = new File(path);
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			props.setProperty("mobileNumber", prop.getProperty("existingUser"));
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
