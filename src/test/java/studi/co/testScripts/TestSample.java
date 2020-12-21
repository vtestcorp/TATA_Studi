package studi.co.testScripts;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DesiredCapabilities caps=new DesiredCapabilities(); 
		
			
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY223HQBHZ");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			caps.setCapability("appPackage", "com.tce.studi");
			caps.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
			caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			System.out.println("ok1");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			AndroidDriver ad = new AndroidDriver(url, caps);
			System.out.println("ok2");
			//AndroidDriver driver=new AndroidDriver(url, caps);
			System.out.println("ok3");
	}

}
