package studi.co.pageModules;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Study_Plan_Review_Active_Plan;

public class Module_Study_Plan_Review_Active_Plan extends BaseClass {
	
	Object_Study_Plan_Review_Active_Plan objStudyPlan = new Object_Study_Plan_Review_Active_Plan();
	Module_Create_Study_Plan CSP = new Module_Create_Study_Plan();
	public static String homepage_title, no_active_study_plan, myLessonsPage_title ;
	
	public void Validate_Home_Page_Header()
	{
		homepage_title = objStudyPlan.homePageHeader.getText(); 
		if(homepage_title.equals("What would\n" + "you like to do next?"))
			System.out.println("User is navigated to the landing page");
		else 
			System.out.println("User is NOT navigated to the landing page");
	}
	
	public void Navigate_To_Active_Study_Plan_Page() throws InterruptedException
	{
		boolean flag_active_study_plan = true;
		try {
		no_active_study_plan = objStudyPlan.noActiveStudyPlan.getText();
		if(no_active_study_plan.equals("There is no active plan"))
		{
			System.out.println("'No Active Plan'");
			flag_active_study_plan = false;
		}	
		}
		catch (Exception e) {}
		if(flag_active_study_plan==false)
		{
			CSP.Validate_create_study_plan();				
		}
		objStudyPlan.activeStudyPlan.click();
		System.out.println("Clicked");
		//Check_Visibility_Of_Element(objStudyPlan.myLessonsPageHeader, 5);
		
	}
	public void Validate_Mylessons_Page_Header() throws InterruptedException, MalformedURLException
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
	//	Check_Visibility_Of_Element(objStudyPlan.lblToday, 2);
		System.out.println("Going in scroll now: "+getDriver());
		System.out.println("Going in scroll now: "+Get_Android_driver());
		
//		scroll(objStudyPlan.lblToday,getDriver(), 1);//Working Fine
//		scroll(objStudyPlan.reviewButton,getDriver(), 1);
		
		
		
//		new TouchAction((PerformsTouchActions)getDriver())
//		.tap(point(50,50))
//        .waitAction(waitOptions(Duration.ofMillis(250))).perform();
		
//		action.press(50, 50).moveTo(50, 150).release().perform();
		
		objStudyPlan.reviewButton.click();
//		myLessonsPage_title = objStudyPlan.lblToday.getText(); 
//		if(myLessonsPage_title.equals("What would\n" + "you like to do next?"))
//			System.out.println("User is navigated to the landing page");
//		else 
//			System.out.println("User is NOT navigated to the landing page");
	}

	public void Navigate_To_Review_Plan_Page() throws InterruptedException {
		Thread.sleep(5);
		System.out.println("After sleep 5");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("After Wait");
		scroll(objStudyPlan.lblToday,driver, 1);
		scroll(objStudyPlan.reviewButton,getDriver(), 1);
	}

		public void scroll(WebElement ele, RemoteWebDriver driver, int retryCount) {
		    boolean flag=true;
		    int count=1;
		    while(flag){
		        try {
		        	WebElement ele1 = ele;
		        	System.out.println("In Scroll Try");
		            flag=false;
		            break;
		        }
		        catch(Exception e) {
		        	System.out.println("In EXCEP: "+e.getMessage());
		            count=count+1;
		            Map<String, Object> params = new HashMap<>();
		            params.put("start","40%,90%");
		            params.put("end","40%,20%");
		            params.put("duration","2");
		            System.out.println("Before");
		            Object res= driver.executeScript("mobile:touch:swipe",params);
		        if(count==retryCount)
		        {
		            break;
		        }
		        }
		    }
		}

		public void Check_Visibility_Of_Element(WebElement ele, int maxTryCount) throws InterruptedException
		{
			System.out.println("IN Check_Visibility_Of_Element");
			int counter =0;
			while(counter < maxTryCount)
			{
				try
				{
					ele.isDisplayed();
				}
				catch (Exception e) {
					getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					counter++;
				}
			}
		}

		public RemoteWebDriver Get_Android_driver() throws MalformedURLException
		{
			String device = "Android"; 
			String devicename = "E1MGA3E822429306";
			String platformversion = "7";
			String platformname = "Android";
			

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("device", device);
			cap.setCapability("deviceName", devicename);
			cap.setCapability("platformName", platformname);
			cap.setCapability("platformVersion", platformversion);
			//cap.setCapability("browserName", "");
			cap.setCapability("appPackage", "com.tce.afs");
			cap.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
			//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
			cap.setCapability("newCommandTimeout", "120");
		
			RemoteWebDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			return driver1;
		}
		
}

