package studi.co.testScripts;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Subscription;

public class Subscription extends BaseClass {

	public Subscription(){
		super();
	}

	@Test(enabled = true)//pass
	public void TC01_verify_The_Functionality_Of_Select_New_Plan_For_Adding_New_Profile_On_Choose_Profile_Page() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.verify_New_Plan_Functionality();
	}

	@Test(enabled = true)//TBD instead of 15 ..1 days free trial is there
	public void TC02_Verify_The_Functionality_Of_Select_Free_Trail_For_Newly_Added_Profile_On_Choose_Profile_Page() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.verify_Functionality_Of_Free_Plan();
	}

	@Test(enabled = true)//pass
	public void TC05_Verify_the_functionality_of_select_new_plan_on_expired_plan_profile() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.Verify_the_functionality_of_select_new_plan_on_expired_plan_profile();
	}

//	@Test(enabled = false)//Hold ..need 5 there r 3 plans
//
//	public void TC_06_To_validate_user_should_be_shown_subscription_plan_on_the_select_subscription_page () throws MalformedURLException {
//		Module_Subscription subscription =new Module_Subscription();
//		subscription.To_validate_user_should_be_shown_subscription_plan_on_the_select_subscription_page();
//	}
	@Test(enabled = true, priority=-2)//pass 
	public void TC07_To_validate_the_Proceed_to_PayButton() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.to_validate_the_Proceed_to_PayButton();
	}

	@Test(enabled = false)
	public void TC_08_To_validate_Order_Summary_Checkout_page() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.to_validate_Order_Summary_Checkout_page();
	}
	@Test(enabled = false)//TBD
	public void TC_09_To_validate_Order_Summary_Checkout_page_section_with_Details() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.to_validate_Order_Summary_Checkout_page_section_with_Details();
	}
	@Test(enabled = false)
	public void TC12_To_validate_Payment_information_section_with_details_of_Checkout_page() throws MalformedURLException {
		Module_Subscription subscription =new Module_Subscription();
		subscription.To_validate_Payment_information_section_with_details_of_Checkout_page();
	}

	@AfterMethod
	public void restApp() throws MalformedURLException {
		applyExplicitWait(5);
		getDriver().launchApp();
	}

}
