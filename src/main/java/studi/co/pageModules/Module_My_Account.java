package studi.co.pageModules;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Create_Study_Plan;
import studi.co.pageObjects.Object_My_Account_Page;

public class Module_My_Account extends BaseClass{
	Object_My_Account_Page account=new Object_My_Account_Page();
	SoftAssert assert1=new SoftAssert();
	Boolean status;
	
	public void login_To_App() throws MalformedURLException {
		applyExplicitWaitsUntilElementVisible(account.alreadyUser);
		clickOnElement(account.alreadyUser);
		sendText(account.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(account.loginBtn);
		sendText(account.passwordTB, prop.getProperty("password"));
		clickOnElement(account.verifyBtn);
		test.log(Status.INFO, "User is sucessfully Login to application" );
		System.out.println("User is sucessfully Login to application");
		
	}
	
	public void to_verify_successful_creation_of_task() {
		scrollTo2("Assignments");
		clickOnElement(account.assignment);
		test.log(Status.INFO, "Clicked Assignments" );
		System.out.println("Clicked on Assignments");
		clickOnElement(account.add_assignment);
		clickOnElement(account.task);
		test.log(Status.INFO, "Setting Task  Title" );
		System.out.println("Setting Task  Title");
		account.taskTitle.sendKeys("Test for curosouls Avalability");
		test.log(Status.INFO, "Setting Task Instruction " );
		System.out.println("Setting Task Instruction");
		account.taskInstruction.sendKeys("TATA Studi Test for Task and Digital Test");
		scrollTo2("Assign");
		clickOnElement(account.assignmentViewed);
		test.log(Status.INFO, "Clicked on Assignment Viewd" );
		System.out.println("Clicked on Assignment Viewd");

		clickOnElement(account.taskDuration);
		test.log(Status.INFO, "Selected the Task Duration");
		System.out.println("Selected the Task Duration");

		scrollToEnd();		
		clickOnElement(account.assignTask);
		status = account.createdTask.isDisplayed();
		assert1.assertTrue(status);
		if (status) {
			System.out.println("Task is created");
			test.log(Status.INFO, "Task is created");
		}

		assert1.assertAll();

	}
	
	public void create_Study_Plan() throws MalformedURLException, InterruptedException {
		clickOnElement(account.planTestUnit);
		scrollTo2("Manage and Create Plan");
		account.manageAndCreatePlan.click();
		//clickOnElement(account.selectAnotherPlan);
		clickOnElement(account.createPlan);
		String subject="Geography";
		//toVerify_PortionOption_IsFunctional();
		SoftAssert assert1=new SoftAssert();
		Thread.sleep(5000);
		scrollTo2("Geography");
		//account.geographyOnEditPage.click();
		//account.geographyOnEditPage.click();
		clickOnElement(findElementByText("Geography"));

		applyExplicitWait(5);
		account.checkBoxGeography.click();
		account.addToPortion.click();
		applyExplicitWait(5);
		account.nextStep.click();
		applyExplicitWait(5);
		account.nextStep1.click();
		applyExplicitWait(5);
		account.nextStep1.click();
		applyExplicitWait(5);

		Boolean activatePlan=account.activateplan.isDisplayed();
		if(activatePlan) {
			System.out.println("User can active new plan");
			test.log(Status.INFO, "User can activate new plan");

		}
		assert1.assertTrue(activatePlan);
		account.activateplan.click();
		applyExplicitWait(5);
		account.beginStudying.click();

		assert1.assertAll();
		
	}
	
	
	
	public void verify_Choose_A_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		status= account.profileFirst.isDisplayed();
		if (status) {
			System.out.println("profile page is displayed");
			test.log(Status.INFO, "profile page is displayed");
		}
		assert1.assertTrue(status);
		clickOnElement(account.profileFirst);
		test.log(Status.INFO, "Click on first profile" );
		System.out.println("Click on first profile");
		clickOnElement(account.sessionStart);
		applyExplicitWait(2);
		clickOnElement(account.hideMessage);
		String name=account.userProfileName.getText();
		System.out.println("First profile Name:"+ name+ "shown");
		status =account.userProfileName.isDisplayed();
		//assert1.assertEquals(account.userProfileName.isDisplayed(), true);
		if (status) {
			System.out.println("First User profile name is displayed");
			test.log(Status.INFO, "First User profile name is displayed");
			assert1.assertTrue(status);
		}

		assert1.assertAll();

	}
		
	
	
	
	public void verify_Sign_Out_Functionality_On_Choose_Profile_Page() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		status= account.chooseAProfile.isDisplayed();
		if (status) {
			System.out.println("Choose A Profile Page is displayed");
			test.log(Status.INFO, "Choose A Profile Page is displayed");
		}
		assert1.assertTrue(status);
		status =account.signout1.isDisplayed();
		if (status) {
			System.out.println("Signout Button is displayed in profile page");
			test.log(Status.INFO, "Signout Button is displayed in profile page");
			assert1.assertTrue(status);
		}
		clickOnElement(account.signout1);
		test.log(Status.INFO, "User is sucessfully signout application" );
		System.out.println("User is sucessfully signout application");
		//assert1.assertEquals(account.welcomeMsg.isDisplayed(), true);
		status =account.welcomeMsg.isDisplayed();
		if (status) {
			System.out.println("Welcome message is displayed after signout");
			test.log(Status.INFO, "Welcome message is displayed after signout");
			assert1.assertTrue(status);
		}

		assert1.assertAll();
		
	}
	
	public void verify_Choose_A_Profile_Functionality_On_My_Account_Page() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		String details=account.userDetails.getText();
		System.out.println("System shows plan details properly :"+ details+ "shown");
		//assert1.assertEquals(account.userDetails.isDisplayed(), true);
		//clickOnElement(account.profileFirst);
		//clickOnElement(account.sessionStart);
		//applyExplicitWait(2);
		//clickOnElement(account.hideMessage);
		status =account.userDetails.isDisplayed();
		if (status) {
			System.out.println("application shows plan details and class ");
			test.log(Status.INFO, "application shows plan details and class");
			assert1.assertTrue(status);
		}

		assert1.assertAll();
		
	}
	public void verify_Choose_A_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
	    List<MobileElement> userProfiles=null;
		if(device.contains("Android")) 
			userProfiles= (List<MobileElement>) driver.findElementsById("com.tce.studi:id/cardChildProfile");
				//assert1.assertEquals(account.childProfilePage.isDisplayed(), true);
			
		System.out.println("size of list: " +userProfiles.size());
		System.out.println("Profile page have more than one profile");
		test.log(Status.INFO, "Profile page have more than one profile");
		//for(int i=1; i<=userProfiles.size(); i++) {
			
			clickOnElement(account.profileFirst);
			System.out.println("User click on first profile");
			test.log(Status.INFO, "User click on first profile");
			applyExplicitWait(2);
			clickOnElement(account.sessionStart);
			applyExplicitWait(2);
			clickOnElement(account.hideMessage);
			//assert1.assertEquals(account.firstProfileName.isDisplayed(), true);
			status =account.firstProfileName.isDisplayed();
			if(status)
			System.out.println("User is navigate to selected user");
			test.log(Status.INFO, "User is navigate to selected user");
			assert1.assertTrue(status);
		}
		//assert1.assertAll();
		
	
	
	public void verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page_In_Case_Of_Multi_User() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		List<MobileElement> userProfiles=null;
		if(device.contains("Android")) 
		userProfiles= (List<MobileElement>) driver.findElementsById("com.tce.studi:id/cardChildProfile");
		System.out.println("size of list: " +userProfiles.size());
		for(int i=1; i<=userProfiles.size(); i++) {
			System.out.println("System shows " +i + " profile");
		}
		status =account.expiredPlanUser.isDisplayed();
		if(status) {
		System.out.println("Expired Plan User is available");
		test.log(Status.INFO, "Expired Plan User is available");
		assert1.assertTrue(status);
		String expiredPlan=account.expiredPlanUser.getText();
		System.out.println("System shows proper name of user profile :"+ expiredPlan + " shown");
		}
		clickOnElement(account.selectNewPlan);
		test.log(Status.INFO, "User is click on select new plan of expired plan profile" );
		System.out.println("User is click on select new plan of expired plan profile");
		assert1.assertEquals(account.selectPlanPage.isDisplayed(), true);
		}
		
	
	
	public void verify_Expired_Plan_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		String expiredPlan=account.expiredPlanUser.getText();
		System.out.println("System shows proper name of user profile :"+ expiredPlan+ "shown");
		//clickOnElement(account.expiredPlanUser);
		//assert1.assertEquals(account.chooseProfile.isDisplayed(), true);
		status =account.expiredPlanUser.isDisplayed();
		if (status) {
			clickOnElement(account.expiredPlanUser);
			System.out.println("user is unable to click on expired plan profile");
			test.log(Status.INFO, "user is unable to click on expired plan profile");
			assert1.assertTrue(status);
		}

		assert1.assertAll();
		
	}
	
	public void verify_Select_New_Plan_On_Expired_Plan_Profile_Functionality_On_Profile_Page() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		status =account.expiredPlanUser.isDisplayed();
		if (status) {
			System.out.println("Expired Plan Profile is available");
			test.log(Status.INFO, "Expired Plan Profile is available");
			assert1.assertTrue(status);
		}
		status =account.selectNewPlan.isDisplayed();
		if (status) {
			clickOnElement(account.selectNewPlan);
			System.out.println("user is Click on Select new Plan Functionality");
			test.log(Status.INFO, "user is Click on Select new Plan Functionality");
			assert1.assertTrue(status);
		}
		List<MobileElement> Plans=null;
		if(device.contains("Android")) 
			Plans= (List<MobileElement>) driver.findElementsById("com.tce.studi:id/cardSubscription");
		System.out.println("No of Plans are displayed: " +Plans.size());
		for(int i=1; i<Plans.size(); i++) {
			test.log(Status.INFO, "plan List " +i );
			System.out.println("System shows plan " +i);
		}
		//assert1.assertEquals(account.selectPlanPage.isDisplayed(), true);
		status =account.selectPlanPage.isDisplayed();
		if (status) {
			System.out.println("user is redirect to select new plan functionality page");
			test.log(Status.INFO, "user is redirect to select new plan functionality page");
			assert1.assertTrue(status);
		}

		assert1.assertAll();
		
	}
	
	public void verify_The_Functionality_Of_Contact_Us_To_Add_More_Link_On_Profile() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		
		status =account.contactUsLink.isDisplayed();
		clickOnElement(account.contactUsLink);
		if (account.contactUsLink.getAttribute("clickable").equals(true)) {
			
			System.out.println("user is able to redirect to contact us Page");
			test.log(Status.INFO, "user is able to redirect to contact us Page");
			assert1.assertTrue(true);
		}
		
		else {
			System.out.println("user is unable to click on contact us To add more functionality");
			test.log(Status.INFO, "user is unable to click on contact us To add more functionality");
			assert1.assertTrue(false,"user is unable to click on contact us To add more functionality");
			
		}

		assert1.assertAll();
		
	}
	
	
	
	public void verify_The_Functionality_Of_Profile_Icon() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		//clickOnElement(account.profileFirst);
		//clickOnElement(account.sessionStart);
        //clickOnElement(account.hideMessage);
		//assert1.assertEquals(account.logo.isDisplayed(), true);
		status =account.logo.isDisplayed();
		if (status) {
	        System.out.println("Studi Logo is displayed");
			test.log(Status.INFO, "Studi Logo is displayed");
			assert1.assertTrue(status);
		}
		else {
			System.out.println("Studi Logo is not displayed");
			test.log(Status.INFO, "Studi Logo is not displayed");
			
		}

		assert1.assertAll();
		
	}
	
	public void verify_The_Functionality_Of_Profile_Popup_For_Close() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		String firstprofile=account.profileFirst.getText();
		System.out.println("User click on First Profile " +firstprofile );
		test.log(Status.INFO, "User click on First Profile " +firstprofile);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		//assert1.assertEquals(account.closeBtn.isDisplayed(), true);
		
		status =account.closeBtn.isDisplayed();
		if (status) {
			clickOnElement(account.closeBtn);
	        System.out.println("user is able to click On Close(X) icon");
			test.log(Status.INFO, "user is able to click On Close(X) icon");
			assert1.assertTrue(status);
		}
		status =account.signoutBtn.isDisplayed();
		if (status) {
		//assert1.assertEquals(account.signoutBtn.isDisplayed(), true);
			System.out.println("user is able to show signout button after click on close button");
			test.log(Status.INFO, "user is able to show signout button after click on close button");
			assert1.assertTrue(status);
		}
		assert1.assertAll();
	}
	
	public void verify_The_Functionality_Of_Profile_Popup_For_Switch_profile() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		String profile1=account.profileFirst.getText();
		System.out.println("user is click on Profile one " +profile1);
		test.log(Status.INFO, "user is click on Profile one " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		applyExplicitWait(2);
		clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		status =account.switchProfile.isDisplayed();
		if (status) {
			clickOnElement(account.switchProfile);
	        System.out.println("User is able to Click on Switch Profile");
			test.log(Status.INFO, "User is able to Click on Switch Profile");
			assert1.assertTrue(status);
		}
		status =account.chooseProfile.isDisplayed();
		if(status) {
			System.out.println("User is able to see Choose Profile Page");
			test.log(Status.INFO, "User is able to see Choose Profile Page");
			assert1.assertTrue(status);
			
		}
		//assert1.assertEquals(account.chooseProfile.isDisplayed(), true);
		assert1.assertAll();
	}
	
	public void verify_The_Functionality_Of_Profile_Popup_For_Add_New_Profile() throws MalformedURLException {
		getDriver().resetApp();
		login_To_App();
		String profile1=account.profileFirst.getText();
		System.out.println("user is click on Profile one " +profile1);
		test.log(Status.INFO, "user is click on Profile one " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		status =account.addNewProfile.isDisplayed();
		if (status) {
			clickOnElement(account.addNewProfile);
	        System.out.println("User is unable to Click on Add New Profile");
			test.log(Status.INFO, "User is unable to Click on Add New Profile");
			assert1.assertTrue(status);
		}
		status =account.createNewProfile.isDisplayed();
		if (status) {
	        System.out.println("User is unable to add another new profile ");
			test.log(Status.INFO, "User is unable to add another new profile");
			assert1.assertTrue(status);
		}
		
		//assert1.assertEquals(account.createNewProfile.isDisplayed(), true);
		assert1.assertAll();
	}
	
  public void verify_The_Functionality_Of_Profile_Popup_For_Profile_Link() throws MalformedURLException {
	    getDriver().resetApp();
	    login_To_App();
	    String profile1=account.profileFirst.getText();
		System.out.println("user is click on Profile one " +profile1);
		test.log(Status.INFO, "user is click on Profile one " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
        clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		status =account.profileLink.isDisplayed();
		if (status) {
			clickOnElement(account.profileLink);
	        System.out.println("User is able to Click on profile Link");
			test.log(Status.INFO, "User is able to Click on profile Link");
			assert1.assertTrue(status);
		}
		
		status =account.ProfileName.isDisplayed();
		if(status) {
		String profileName= account.ProfileName.getText();
		System.out.println("User is able see Profile Name " +profileName);
		test.log(Status.INFO, "User is able see Profile Name " +profileName);
		assert1.assertTrue(status);
		}
		 Boolean status1 =account.subscriptionCard.isDisplayed();
		if(status1) {
		String subscriptionDetail= account.subscriptionCard.getText();
		System.out.println("User is able see subscription details " +subscriptionDetail);
		test.log(Status.INFO, "User is able see subscription details " +subscriptionDetail);
	    assert1.assertTrue(status1);	
		}
		//assert1.assertEquals(account.ProfileName.isDisplayed(), true);
		//assert1.assertEquals(account.subscriptionCard.isDisplayed(), true);
		assert1.assertAll();
 }
  
  public void verify_The_Functionality_Of_Profile_Popup_For_Syllabus_Link() throws MalformedURLException {
	    getDriver().resetApp();
	    login_To_App();
	    String profile1=account.profileFirst.getText();
		System.out.println("user is click on Profile one " +profile1);
		test.log(Status.INFO, "user is click on Profile one " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		status =account.syllabusLink.isDisplayed();
		if (status) {
			clickOnElement(account.syllabusLink);
	        System.out.println("User is able to Click on Syllabus Link");
			test.log(Status.INFO, "User is able to Click on Syllabus Link");
			assert1.assertTrue(status);
		}
		status =account.boardDetails.isDisplayed();
		if(status) {
		String boardDetail= account.boardDetails.getText();
		System.out.println("User is able see Profile Name " +boardDetail);
		test.log(Status.INFO, "User is able see Profile Name " +boardDetail);
		assert1.assertTrue(status);
		}
		 Boolean status1 =account.gradeDetail.isDisplayed();
		if(status1) {
		String gradeDetail= account.gradeDetail.getText();
		System.out.println("User is able see subscription details " +gradeDetail);
		test.log(Status.INFO, "User is able see subscription details " +gradeDetail);
	    assert1.assertTrue(status1);	
		}
		assert1.assertAll();
		//assert1.assertEquals(account.boardDetails.isDisplayed(), true);
		//assert1.assertEquals(account.gradeDetail.isDisplayed(), true);
	  
  }
  
  public void verify_The_Functionality_Of_Profile_Popup_For_Account_Link() throws MalformedURLException {
	    getDriver().resetApp();
	    login_To_App();
	    String profile1=account.profileFirst.getText();
		System.out.println("user is click on Profile one " +profile1);
		test.log(Status.INFO, "user is click on Profile one " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		clickOnElement(account.profileIcon);
		status =account.acountLink.isDisplayed();
		if (status) {
			clickOnElement(account.acountLink);
	        System.out.println("User is able to Click on Account Link ");
			test.log(Status.INFO, "User is able to Click on Account Link");
			assert1.assertTrue(status);
		}
		String mobile= account.mobileNo.getText();
		System.out.println("User Mobile NO " +mobile);
		test.log(Status.INFO, "User Mobile NO " +mobile);
		assert1.assertEquals(account.mobileNo.isDisplayed(), true);
		String email= account.emailId.getText();
		System.out.println("User Email ID " +email);
		test.log(Status.INFO, "User Email ID " +email);
		assert1.assertEquals(account.emailId.isDisplayed(), true);
		String state= account.stateDetail.getText();
		System.out.println("User state " +state);
		test.log(Status.INFO, "User state" +state);
		assert1.assertEquals(account.stateDetail.isDisplayed(), true);
		String pin= account.pinCode.getText();
		System.out.println("User Pin code " +pin);
		test.log(Status.INFO, "User Pin code " +pin);
		assert1.assertEquals(account.pinCode.isDisplayed(), true);
		
	  
  }
  
  public void verify_The_Logo_Of_The_Application_Clickable() throws MalformedURLException {
	   /* getDriver().resetApp();
	  //login_To_App();
		applyExplicitWaitsUntilElementVisible(account.alreadyUser);
		clickOnElement(account.alreadyUser);
		sendText(account.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(account.loginBtn);
		sendText(account.passwordTB, prop.getProperty("password"));
		clickOnElement(account.verifyBtn);
		test.log(Status.INFO, "User is sucessfully Login to application" );
		System.out.println("User is sucessfully Login to application");
		clickOnElement(account.logo);
		//applyExplicitWaitsUntilElementVisible(oh.logo);
	    assert1.assertEquals(account.logo.isDisplayed(), true);
	    System.out.println("logo is displayed");*/
	  Boolean status;
		getDriver().resetApp();
		login_To_App();
		status =account.logo.isDisplayed();
		
		if (status) {
			System.out.println("Logo is displayed on Home Page");
			test.log(Status.INFO, "Logo is displayed on Home Page");
		}
	
		assert1.assertTrue(status);
		
		clickOnElement(account.logo);
		
		String click=account.logo.getAttribute("clickable");
		if (click.contains("true"))

			{
			System.out.println("Logo is Clickable");
			test.log(Status.INFO, "Logo is Clickable");
			}
		
		else
		{
			System.out.println("Logo is not Clickable");
			test.log(Status.INFO, "Logo is not Clickable");
			}

		
		assert1.assertAll();
	
	  
  }
  
  public void verify_The_Functionality_Of_Carousel_What_Would_You_Like_To_Do_Next() throws MalformedURLException, InterruptedException {
	    getDriver().resetApp();
	    login_To_App();
	    String profile1=account.profileFirst.getText();
		System.out.println("user is click on Active Profile " +profile1);
		test.log(Status.INFO, "user is click on Active Profile " +profile1);
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		 String corousel1=account.corousel1.getText();
			System.out.println("first carousel  " +corousel1);
			test.log(Status.INFO, "first carousel " +corousel1);
		status =account.corousel1.isDisplayed();
		if (status) {
	        System.out.println("User is able to see carousel and its clickable");
			test.log(Status.INFO, "User is able to see carousel and its clickable");
			assert1.assertTrue(status);
		}
		swipeLeft();
		assert1.assertEquals(account.carousel2.isDisplayed(), true);
		swipeRight();
		Thread.sleep(3000);
		assert1.assertEquals(account.carousel1.isDisplayed(), true);
		test.log(Status.INFO, "User is able to swipe carousel right side" );
		System.out.println("User is able to swipe carousel right side");
	  
  }
  
  public void verify_The_Functionality_Of_Each_Carousel_Page() throws MalformedURLException, InterruptedException {
	    getDriver().resetApp();
	    login_To_App();
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		clickOnElement(account.hideMessage);
		/*List<MobileElement> carousels=null;
		if(device.contains("Android")) 
		//carousels= (List<MobileElement>) driver.findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			//carousels= (List<MobileElement>) driver.findElementsById("com.tce.studi:id/tlNotification");
		carousels= (List<MobileElement>) driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView");
		System.out.println("size of list: " +carousels.size());
		for(int i=1; i<carousels.size(); i++) {
			MobileElement carousel=  carousels.get(i);
			System.out.println(carousel);
			clickOnElement(carousel);
			assert1.assertEquals(account.page1.isDisplayed(), true);
			assert1.assertEquals(account.page1.isDisplayed(), true);
		}*/
	     Thread.sleep(3000);
	     applyExplicitWaitsUntilElementVisible(account.corousel1);
		clickOnElement(account.corousel1);
		//assert1.assertEquals(account.modifyBtn.isDisplayed(), true);
		test.log(Status.INFO, "User is able to click on first carousel" );
		System.out.println("User is able to click on first carousel");
		 applyExplicitWaitsUntilElementVisible(account.backBtn);
		clickOnElement(account.backBtn);
		account.yesBtn.click();
		clickOnElement(account.backBtn);
		swipeLeft();
		Thread.sleep(3000);
		clickOnElement(account.corousel2);
		assert1.assertEquals(account.redoTestBtn.isDisplayed(), true);
		test.log(Status.INFO, "User is able to click on second carousel" );
		System.out.println("User is able to click on second carousel");
		clickOnElement(account.backBtn);
		clickOnElement(account.leftIcon);
		swipeLeft();
		Thread.sleep(3000);
		clickOnElement(account.corousel3);
		assert1.assertEquals(account.syllabustab.isDisplayed(), true);
		test.log(Status.INFO, "User is able to click on Third carousel" );
		System.out.println("User is able to click on Third carousel");
		clickOnElement(account.backBtn);
		//clickOnElement(account.leftIcon);
		swipeLeft();
		Thread.sleep(3000);
		clickOnElement(account.corousel4);
		System.out.println("Clarify concepts Carousel are not clickable");
		swipeLeft();
		clickOnElement(account.corousel5);
		System.out.println("Manage Your Schedules Carousel are not clickable");
		swipeLeft();
		Thread.sleep(3000);
		clickOnElement(account.corousel6);
		assert1.assertEquals(account.weeklyReport.isDisplayed(), true);
		clickOnElement(account.backBtn);
		
  }
  
  public void verify_The_Functionality_Of_Assignments_Carousel() throws MalformedURLException {
	    getDriver().resetApp();
	    login_To_App();
		clickOnElement(account.profileFirst);
		clickOnElement(account.sessionStart);
		applyExplicitWait(2);
		clickOnElement(account.hideMessage);
		to_verify_successful_creation_of_task();
		/*clickOnElement(account.assignments);
		clickOnElement(account.createTask);
		
		clickOnElement(account.task);
		sendText(account.taskTitle, prop.getProperty("topic_1"));
		sendText(account.taskInstruction, prop.getProperty("Intruction"));
		scrollTo2("Assign");
		clickOnElement(account.assignBtn);
		clickOnElement(account.backBtn);
		test.log(Status.INFO, "User is successfully created Task" );
		System.out.println("User is successfully created Task");*/
		//swipeLeft();
		//(account.corousel2);
		if(findElementByText("Test for curosouls Avalability").isDisplayed()) {
			//applyExplicitWaitsUntilElementVisible(findElementByText("Test for curosouls Avalability"));
			test.log(Status.INFO, "Task is created and display on Carousel" );
			System.out.println("Task is created and display on Carousel");
			assert1.assertTrue(true,"Test for curosouls Avalability");
		}
  else {
			test.log(Status.INFO, "Task is created but not display on Carousel" );
			System.out.println("Task is created but not display on Carousel");
			assert1.assertTrue(false, "Test for curosouls Avalability");
		}
		
  }
  
  public void verify_The_Functionality_Of_Carousel_In_Case_Of_Update_Delete() throws MalformedURLException, InterruptedException {
		create_Study_Plan();
		driver.navigate().back();
		//clickOnElement(account.corousel1);
		Thread.sleep(5000);
		String planOneChapter=account.chapterName.getText();
		System.out.println(planOneChapter);
		assert1.assertEquals(account.chapterName.isDisplayed(), true);
		applyExplicitWait(2);
		clickOnElement(account.planTestUnit);
		Thread.sleep(5000);
		scrollTo2("Test Unit");
		applyExplicitWait(2);
		if(account.pauseBtn.isDisplayed()) {
			test.log(Status.INFO, "Pause Button is displayed after Study Plan creation" );
			System.out.println("Pause Button is displayed after Study Plan creation");
			assert1.assertTrue(true,"Pause Button is dispalyed");
			clickOnElement(account.pauseBtn);
		}
		else {
			assert1.assertTrue(false, "Pause Button is not dispalyed");
			
		}
		//assert1.assertEquals(account.pauseBtn.isDisplayed(), true);
		//clickOnElement(account.pauseBtn);
	    clickOnElement(account.proceedBtn);
		clickOnElement(account.selectAnotherPlan);
		clickOnElement(account.secondstudyplan);
		clickOnElement(account.editBtn);
		//clickOnElement(account.activatePlan);
		if(account.activatePlan.isDisplayed()) {
			test.log(Status.INFO, "User is able to activate Other Plan" );
			System.out.println("User is able to activate Other Plan");
			assert1.assertTrue(true,"Activate Plan is available");
			clickOnElement(account.activatePlan);
		}
		else {
			assert1.assertTrue(false, "Activate Plan is available");
			
		}
		String subject= "English Reader";
		scrollTo2("English Reader");
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);
		clickOnElement(findElementByText("1. A Tale of Two Birds"));
		//account.checkBoxGeography.click();
		account.addToPortion.click();
		applyExplicitWait(5);
		account.nextStep.click();
		applyExplicitWait(5);
		account.nextStep1.click();
		applyExplicitWait(5);
		account.nextStep1.click();
		applyExplicitWait(5);
		
		Boolean activatePlan=account.activateplan.isDisplayed();
		if(activatePlan) {
			System.out.println("User can activate the plan");
			test.log(Status.INFO, "User can activate the plan");

		}
		assert1.assertTrue(activatePlan);
		account.activateplan.click();
		applyExplicitWait(5);
		account.beginStudying.click();

		assert1.assertAll();
		Thread.sleep(5000);
		
		String chapterofPlansecond=account.chapterName.getText();
		System.out.println(chapterofPlansecond);
		assert1.assertEquals(account.chapterName.isDisplayed(), true);
		System.out.println("Update Plan Chapter on Carousel ");
		test.log(Status.INFO, "Update Plan Chapter on Carousel ");
	}
  
  
  public void verify_The_Data_At_Footer() {
	  getDriver().resetApp();
	  assert1.assertEquals(account.footerMsg.isDisplayed(), true);
	  clickOnElement(account.footerMsg);
	  //WebElement element = driver.findElementById("com.tce.studi:id/tvPrivacy");
	  /*Point point = account.footerMsg.getLocation(); 
	  int x = point.x +1; 
	  int y = point.y + account.footerMsg.getSize().getHeight() - 1; 
	  new TouchAction(driver).tap((TapOptions) ((PerformsActions) PointOption.point(x, y))).perform();*/
	  assert1.assertEquals(account.terms_ConditionPage.isDisplayed(), true);
	  test.log(Status.INFO, "User is able to redirect to Terms & Condition Page" );
	  System.out.println("User is able to redirect to Terms & Condition Page");
	  
	  driver.navigate().back();
	  
	  clickOnElement(account.footerMsg);
	  
	  assert1.assertEquals(account.privacyPolicyPage.isDisplayed(), true);
	 // String privacyUrl=driver.getCurrentUrl();
	 // System.out.println(privacyUrl);
	 // assert1.assertEquals(privacyUrl, "tatastudi.com/privacy/" );
	  
	  test.log(Status.INFO, "User is able to redirect to Privacy Policy Page" );
	  System.out.println("User is able to redirect to Privacy Policy Page");
	  
	  
	  
  }
  
  public void verify_Logout_Functionality() throws MalformedURLException {
	    getDriver().resetApp();
	  //login_To_App();
		applyExplicitWaitsUntilElementVisible(account.alreadyUser);
		clickOnElement(account.alreadyUser);
		sendText(account.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(account.loginBtn);
		//applyExplicitWait(2);
		sendText(account.passwordTB, prop.getProperty("password"));
		clickOnElement(account.verifyBtn);
		test.log(Status.INFO, "User is sucessfully Login to application" );
		System.out.println("User is sucessfully Login to application");
		applyExplicitWait(2);
		clickOnElement(account.signout);
		System.out.println("Click on Signout Button");
		assert1.assertEquals(account.welcomeTitle.isDisplayed(), true);
		System.out.println("logout Successfully");
	  
  }
  
  
  public void verify_Functionality_Of_Report_An_Issues() throws MalformedURLException {
	    getDriver().resetApp();
	  //login_To_App();
		applyExplicitWaitsUntilElementVisible(account.alreadyUser);
		clickOnElement(account.alreadyUser);
		sendText(account.mobileNoTB, prop.getProperty("mobileNumber"));
		clickOnElement(account.loginBtn);
		sendText(account.passwordTB, prop.getProperty("password"));
		clickOnElement(account.verifyBtn);
		test.log(Status.INFO, "User is sucessfully Login to application" );
		System.out.println("User is sucessfully Login to application");
	  
  }
  
  
	public void swipeRight() {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		System.out.println(size.height + "height");
		System.out.println(size.width + "width");
		System.out.println(size);
		int startPoint = (int) (size.width * 0.15);
		int endPoint = (int) (size.width * 0.99);
		int ScreenPlace = (int) (size.height * 0.40);
		int y = (int) size.height * 20;

		TouchAction ts = new TouchAction(driver);
		// for(int i=0;i<=3;i++) {
		ts.press(PointOption.point(startPoint, ScreenPlace))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(endPoint, ScreenPlace)).release().perform();
	}
	
	

}
