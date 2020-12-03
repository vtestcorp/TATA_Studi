package studi.co.testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageObjects.Object_Browse_Books;

public class Verify_Scroll extends BaseClass {
	
	public Verify_Scroll() {
		super();
	}
	
	@Test
	public void verifyScroll() throws InterruptedException, AWTException {
		Module_Login ml=new Module_Login(); 
		ml.Login_to_app();
		Object_Browse_Books obb = new Object_Browse_Books(); 
		obb.browseBooks.click();
		
		Thread.sleep(7000);
		
		getDriver().navigate().back();
		
		
		//JavascriptExecutor js=(JavascriptExecutor)getDriver();
		//js.executeScript("arguments[0].scrollIntoView(true);", obb.grade6Text);
		//Thread.sleep(1000);
		//AndroidDriver<AndroidElement> driver=(AndroidDriver<AndroidElement>) getDriver();
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		//TouchActions action = new TouchActions(driver);
		//action.scroll(obb.grade6Text, 10, 100);
		//action.perform();
		
		
		Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        
        r.keyPress(KeyEvent.VK_PAGE_DOWN);
        r.keyRelease(KeyEvent.VK_PAGE_DOWN);
    
		
		
		Thread.sleep(2000);
		System.out.println("Scrolled Successfully");


		
		
		
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(text(\"Your Syllabus\"));"));
		driver.quit();
	}

}
