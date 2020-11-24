package studi.co.pageModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Review_Plan_Tab;

public class Module_Review_Plan_Tab extends BaseClass {

	public static String getLandingPageTitle, getMyLessonPageTitle;

	public void Verify_Review_Plan_Tab() throws InterruptedException, AWTException {

		Object_Review_Plan_Tab RMQP = new Object_Review_Plan_Tab();

		getLandingPageTitle = RMQP.verify_landing_page.getText();
		System.out.println(getLandingPageTitle);
		if (getLandingPageTitle.contains("What would\n" + "you like to do next?"))
			System.out.println("Landing page displayed");
		else
			System.out.println("Landing page not displayed");

		RMQP.select_study_plan.click();
		Thread.sleep(1000);

		getMyLessonPageTitle = RMQP.verify_mylessons_page.getText();
		System.out.println(getMyLessonPageTitle);
		if (getMyLessonPageTitle.contains("Test Unit"))
			System.out.println("My Lessons Landing page displayed");
		else
			System.out.println("My Lessons Landing page not displayed");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);

		RMQP.click_Review_Plan.click();
		Thread.sleep(1000);
		System.out.println("Clicked Review Plan button");

	}
}
