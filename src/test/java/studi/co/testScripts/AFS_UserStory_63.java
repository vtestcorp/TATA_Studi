package studi.co.testScripts;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Syllabus_Options;

public class AFS_UserStory_63 extends BaseClass {

	public AFS_UserStory_63() {
		super();
	}

	// @BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}

	@Test(enabled = false)
	public void TC01_Verify_Create_Note_Icon_Should_Be_Visible_In_Video()
			throws MalformedURLException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Create_Note_Icon_Should_Be_Visible_In_Video(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
	@Test(enabled = false)
	public void TC02_Verify_Create_Note_Icon_Should_Be_Clickable_In_Video()
			throws MalformedURLException, InterruptedException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Create_Note_Icon_Should_Be_Clickable_In_Video(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
	@Test(enabled = false)
	public void TC05_Verify_User_Should_Be_Able_To_Write_Upto_3000_Charcters_In_Note()
			throws MalformedURLException, InterruptedException, AWTException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Should_Be_Able_To_Write_Upto_3000_Charcters_In_Note(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
	@Test(enabled = false)
	public void TC06_Verify_User_Is_Unable_To_Add_Empty_Note()
			throws MalformedURLException, InterruptedException, AWTException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Is_Unable_To_Add_Empty_Note(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
	@Test(enabled = false)
	public void TC07_Verify_User_Is_Able_To_Enter_Special_Characters_In_Note()
			throws MalformedURLException, InterruptedException, AWTException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_User_Is_Able_To_Enter_Special_Characters_In_Note(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
	
	@Test(enabled = true)
	public void TC14_Verify_Note_Module_Will_Cosed_Without_Warning()
			throws MalformedURLException, InterruptedException, AWTException {
		Module_Syllabus_Options so = new Module_Syllabus_Options();
		so.Verify_Note_Module_Will_Cosed_Without_Warning(prop.getProperty("Asubject"),
				prop.getProperty("Atopic"));
	}
}
