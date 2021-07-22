package studi.co.pageModules;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Login;
import studi.co.pageObjects.Object_Subscription;

public class Module_Subscription extends BaseClass {

	Object_Subscription osp = new Object_Subscription();
	SoftAssert assert1=new SoftAssert();

	public void verify_New_Plan_Functionality() throws MalformedURLException {
		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);

		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");

		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}
		else
		{
			System.out.println("Adding New profile");

			//applyExplicitWaitsUntilElementVisible(findElementByText("Create new profile"));
			clickOnElement(osp.createNewProfile);
			sendText(osp.childNameTB, prop.getProperty("childName"));
			clickOnElement(osp.selectCurriculam);//CBSC
			clickOnElement(osp.selectClass);//2

			clickOnElement(findElementByText("Continue"));
			status =osp.selectNewPlan.isDisplayed();
			if ( status) {
				System.out.println("New profile with user Liam has been succeefully created");
				test.log(Status.INFO, "New profile with user Liam has been succeefully created");
			}
			assert1.assertTrue(status);

			clickOnElement(osp.subscribeToPlan);

			status =osp.selectNewPlan.isDisplayed();
			if ( status) {
				System.out.println("User is able to redirect to the select subscription page");
				test.log(Status.INFO, "User is able to redirect to the select subscription page");
			}
			assert1.assertTrue(status);
		}
		assert1.assertAll();
	}

	public void verify_Functionality_Of_Free_Plan() throws MalformedURLException {
		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);

		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}
		else
		{	

			clickOnElement(osp.createNewProfile);
			sendText(osp.childNameTB, prop.getProperty("childName"));
			clickOnElement(osp.selectCurriculam);//CBSC
			clickOnElement(osp.selectClass);//2

			clickOnElement(findElementByText("Continue"));
			status =osp.selectNewPlan.isDisplayed();
			if ( status) {
				System.out.println("New profile with user Liam has been succeefully created");
				test.log(Status.INFO, "New profile with user Liam has been succeefully created");
			}
			assert1.assertTrue(status);

			clickOnElement(osp.subscribeToPlan);

			status =osp.selectNewPlan.isDisplayed();
			if ( status) {
				System.out.println("User is able to redirect to the select subscription page");
				test.log(Status.INFO, "User is able to redirect to the select subscription page");
			}
			assert1.assertTrue(status);
			clickOnElement(osp.free_plan);
			clickOnElement(findElementByText("Accept Terms"));
			applyExplicitWaitsUntilElementVisible(findElementByText("Get Stared"));

			clickOnElement(osp.get_Stared);
			status =osp.new_user_name.isDisplayed();
			if ( status) {
				System.out.println("User is be able to avail the free trail of Only one Day");
				test.log(Status.INFO, "User is be able to avail the free trail of Only one Day");
			}
			assert1.assertTrue(status);
		}
		assert1.assertAll();
	}

	public void _To_validate_user_should_be_shown_subscription_plan() throws MalformedURLException {
		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);
		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);
		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}

		status=osp.selectNewPlan.isDisplayed();
		{
			if (status) {
				System.out.println("Select New Plan Tab shown to user");
				test.log(Status.INFO, "Select New Plan Tab shown to user");
			}
			assert1.assertTrue(status);
			clickOnElement(findElementByText("Select new plan"));			
			status=osp.subscribeToPlan.isDisplayed();
			{
				if (status) {
					System.out.println("User has been redirected to the select subscription page");
					test.log(Status.INFO, "User has been redirected to the select subscription page");
				}
				assert1.assertTrue(status);

			}

		}
		assert1.assertAll();

	}

	public void Verify_the_functionality_of_select_new_plan_on_expired_plan_profile() throws MalformedURLException {
		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);
		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}

		status=osp.selectNewPlan.isDisplayed();
		{
			if (status) {
				System.out.println("Select New Plan Tab shown to user");
				test.log(Status.INFO, "Select New Plan Tab shown to user");
			}
			assert1.assertTrue(status);
			clickOnElement(findElementByText("Select new plan"));			
			status=osp.subscribeToPlan.isDisplayed();
			{
				if (status) {
					System.out.println("User has been redirected to the select subscription page");
					test.log(Status.INFO, "User has been redirected to the select subscription page");
				}
				assert1.assertTrue(status);

			}

		}
		assert1.assertAll();
	}

	public void To_validate_user_should_be_shown_subscription_plan_on_the_select_subscription_page() throws MalformedURLException {

		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);
		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}

		status=osp.selectNewPlan.isDisplayed();
		{
			if (status) {
				System.out.println("Select New Plan Tab shown to user");
				test.log(Status.INFO, "Select New Plan Tab shown to user");
			}
			assert1.assertTrue(status);
			clickOnElement(findElementByText("Select new plan"));	
		}
		status=osp.subscribeToPlan.isDisplayed();
		{
			if (status) {
				System.out.println("User has been redirected to the select subscription page");
				test.log(Status.INFO, "User has been redirected to the select subscription page");
			}
			assert1.assertTrue(status);
		}

		List<MobileElement> plans = getDriver().findElementsById("com.tce.studi:id/linearPlanName");
		int total_plans= plans.size();
		System.out.println("Total "+ total_plans + "Plans Exists there on Subscribe to plan Page");
		test.log(Status.INFO, "Total "+ total_plans + "Plans Exists there on Subscribe to plan Page");



	}

	public void to_validate_the_fields_values_of_Order_Summery_Page() {


	}


	public void to_validate_the_Proceed_to_PayButton() throws MalformedURLException {
		Boolean status;
		to_select_subscription();
		clickOnElement(osp.subscribe1);
		status=osp.order_Summary.isDisplayed();
		{
			if (status) {
				System.out.println("Order Summary Page shown ");
				test.log(Status.INFO, "Order Summary Page shown ");
			}
			assert1.assertTrue(status);
		}
		osp.first_name.sendKeys("Liam");
		scrollTo2("Proceed");
		osp.last_name.sendKeys("Ray");
		osp.mail_id.sendKeys("Liam123@gmail.com");	
		osp.state.click();
		osp.state_name.click();
		osp.pin_code.sendKeys("567890");
		clickOnElement(findElementByText("Proceed to Pay"));

		status=osp.start_by_Adding_payment_method_msg.isDisplayed();
		{
			if (status) {
				System.out.println("When user is clicked on Proceed to Pay button then a new Checkout page is shown with starting payment Method");
				test.log(Status.INFO, "When user is clicked on Proceed to Pay button then a new Checkout page is shown with starting payment Method");
			}
			assert1.assertTrue(status);
		}
		assert1.assertAll();

	}

	public void to_validate_Order_Summary_Checkout_page() throws MalformedURLException {
		Boolean status;
		to_select_subscription();
		status=osp.order_Summary.isDisplayed();
		{
			if (status) {
				System.out.println("Order Summary Section is  Shown");
				test.log(Status.INFO, "Order Summary Section is  Shown");
			}
			assert1.assertTrue(status);


			status=osp.billing_details.isDisplayed();
			{
				if (status) {
					System.out.println("Billing Details Section is Shown");
					test.log(Status.INFO, "Billing Details Section is Shown");
				}
				assert1.assertTrue(status);
			}
			assert1.assertAll();

		}

	}





	public void to_select_subscription() throws MalformedURLException
	{
		Boolean status;
		getDriver().resetApp();
		Object_Login ol = new Object_Login();
		applyExplicitWaitsUntilElementVisible(ol.logo);
		clickOnElement(ol.getAlreadyAUser());
		sendText(ol.mobileNumberTextBox, prop.getProperty("mobileNumber2_nick"));
		System.out.println("Entered Mobile Number");
		applyExplicitWait(2);
		clickOnElement(ol.getLoginButton());
		applyExplicitWait(2);
		sendText(ol.getPasswordTextBox(), prop.getProperty("pass_nick"));
		System.out.println("Entered Password");
		applyExplicitWait(2);

		clickOnElement(ol.getVerifypasswordButton());
		applyExplicitWait(2);
		System.out.println("Credentials verified");
		List<MobileElement> profiles = getDriver().findElementsById("com.tce.studi:id/txtChildName");
		int total_users= profiles.size();
		if(total_users==2)
		{
			System.out.println("Already added 2 users: Gives message- Contact us to add more!!");
			test.log(Status.INFO, "Already added 2 users: Gives message- Contact us to add more!!");
		}

		status=osp.selectNewPlan.isDisplayed();
		{
			if (status) {
				System.out.println("Select New Plan Tab shown to user");
				test.log(Status.INFO, "Select New Plan Tab shown to user");
			}
			assert1.assertTrue(status);
			clickOnElement(findElementByText("Select new plan"));	
		}
		status=osp.subscribeToPlan.isDisplayed();
		{
			if (status) {
				System.out.println("User has been redirected to the select subscription page");
				test.log(Status.INFO, "User has been redirected to the select subscription page");
			}
			assert1.assertTrue(status);
		}

	}

	public void to_validate_Order_Summary_Checkout_page_section_with_Details() throws MalformedURLException {
		to_select_subscription();
		clickOnElement(osp.subscribe1);



	}

	public void To_validate_Payment_information_section_with_details_of_Checkout_page() {


	}



	public void to_payment_method() throws MalformedURLException
	{	
		Boolean status;

		to_select_subscription();

		clickOnElement(osp.subscribe1);
		status=osp.order_Summary.isDisplayed();
		{
			if (status) {
				System.out.println("Order Summary Page shown ");
				test.log(Status.INFO, "Order Summary Page shown ");
			}
			assert1.assertTrue(status);
		}
		osp.first_name.sendKeys("Liam");
		scrollTo2("Proceed");
		osp.last_name.sendKeys("Ray");
		osp.mail_id.sendKeys("Liam123@gmail.com");


		osp.state.click();
		osp.state_name.click();


		osp.pin_code.sendKeys("567890");
		clickOnElement(findElementByText("Proceed to Pay"));

		status=osp.start_by_Adding_payment_method_msg.isDisplayed();
		{
			if (status) {
				System.out.println("When user is clicked on Proceed to Pay button then a new Checkout page is shown with starting payment Method");
				test.log(Status.INFO, "When user is clicked on Proceed to Pay button then a new Checkout page is shown with starting payment Method");
			}
			assert1.assertTrue(status);
			
			


		}

	}
}






