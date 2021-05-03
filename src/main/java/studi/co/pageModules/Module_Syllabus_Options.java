package studi.co.pageModules;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.google.inject.internal.util.ImmutableMap;

import io.appium.java_client.LocksDevice;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.SupportsSpecialEmulatorCommands;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_Questions_Revision;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Syllabus_Options extends BaseClass {
	Object_Syllabus_Option oso = new Object_Syllabus_Option();
	Object_Receive_Questions_Revision rqr = new Object_Receive_Questions_Revision();

	private void pauseVideo() throws MalformedURLException, InterruptedException {

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		if (device.equalsIgnoreCase("Android")) {
			clickOnElement(driver.findElement(By.xpath(
					"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]")));


		}

		// applyExplicitWait(2);
		oso.pauseBtn.click();

	}

	public void Verify_Revision_Overview(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		while (flag == 1) {
			try {
				applyExplicitWait(5);

				status = findElementByText("Begin Revis").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Begin Revision button Displayed");
					test.log(Status.INFO, "Begin Revision button Displayed");

					applyExplicitWait(2);
					if (device.equalsIgnoreCase("Android"))
						status = findElementByText("Return to Subject").isDisplayed();
					else
						status = driver.findElementByXPath(
								"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
						.isDisplayed();
					System.out.println("Clicking on Return to Subject");
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Return to Subject button Displayed");
						test.log(Status.INFO, "Return to Subject button Displayed");
					}

					applyExplicitWait(2);
					if (device.equalsIgnoreCase("Android"))
						clickOnElement(findElementByText("Return to Subject"));
					else
						driver.findElementByXPath(
								"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
						.click();
					System.out.println("Clicking on Return to Subject");
					test.log(Status.INFO, "Clicking on Return to Subject");

					applyExplicitWait(5);

					status = findElementByText(subject).isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Navigated to " + subject + "'s Bookshelf");
						test.log(Status.INFO, "Navigated to " + subject + "'s Bookshelf");
					}

					flag = 0;

				}
			} catch (Exception e) {

				applyExplicitWait(5);

				status = findElementByText("Continue Studying").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Continue Studying button Displayed");
					test.log(Status.INFO, "Continue Studying button Displayed");

					//					applyExplicitWait(2);
					//					status = findElementByText("Revise").isDisplayed();
					//					sAss.assertTrue(status);
					//					if (status) {
					//						System.out.println("Revise again button Displayed");
					//						test.log(Status.INFO, "Revise again button Displayed");
					//					}

					applyExplicitWait(2);
					clickOnElement(findElementByText("Continue Studying"));
					System.out.println("Clicking on Continue Studying");
					test.log(Status.INFO, "Clicking on Continue Studying");

					applyExplicitWait(5);
					if (device.equalsIgnoreCase("Android"))
						status = findElementByText("your Confidence").isDisplayed();
					else
						status = findElementByText("youR COMPLETION").isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Navigated to next lesson of " + subject);
						test.log(Status.INFO, "Navigated to next lesson of " + subject);
					}

					flag = 0;
				}

			}
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Begin_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		int fl = 0;
		while (fl == 0) {
			String resource = verify_TQ_Resource();
			if (resource.equals("Video")) {
				System.out.println("Video started");
				test.log(Status.INFO, "Video started");
				//forwardVideoTimerToEnd();
				clickOnElement(rqr.forward);
				applyExplicitWait(5);
			} else if (resource.equals("Quiz")) {
				System.out.println("Quiz started");
				test.log(Status.INFO, "Quiz started");
				int count =getTotalQuestionsInPractice();
				for (int i = 0; i < count; i++) {
					applyExplicitWait(5);
					clickOnElement(rqr.nextButton);
				}
			}
			fl = 1;

		}

		System.out.println("All resources completed");
		test.log(Status.INFO, "All resources completed");

		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_View_Video(String subject, String topic)
			throws MalformedURLException, AWTException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		Thread.sleep(1000);
		status = oso.videoPlayer.isDisplayed();
		sAss.assertTrue(status, "1");

		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started");
			Thread.sleep(2000);

			pauseVideo();
			applyExplicitWait(5);
			System.out.println("Clicked on Pause Button");
			test.log(Status.INFO, "Clicked on Pause Button");

			status = oso.playBtn.isDisplayed();
			sAss.assertTrue(status, "2");
			if (status) {
				System.out.println("Play Button visible");
				test.log(Status.INFO, "Play Button visible");
			}

			status = oso.fwdBtn.isDisplayed();
			sAss.assertTrue(status, "3");
			if (status) {
				System.out.println("Navigate Forward Button visible");
				test.log(Status.INFO, "Navigate Forward Button visible");
			}

			status = oso.bkwdBtn.isDisplayed();
			sAss.assertTrue(status, "4");
			if (status) {
				System.out.println("Navigate Backward Button visible");
				test.log(Status.INFO, "Navigate Backward Button visible");
			}

			ArrayList<MobileElement> quePointsArrayList;
			if (device.equalsIgnoreCase("Android")) {
				quePointsArrayList = (ArrayList<MobileElement>) driver.findElements(
						MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.tce.studi:id/tv_overview\")"));
				status = (quePointsArrayList.size() > 1) ? true : false;
			} else {
				quePointsArrayList = (ArrayList<MobileElement>) driver
						.findElements(By.xpath("//*[@type=\"XCUIElementTypeTextView\"]"));
				status = (quePointsArrayList.size() >= 1) ? true : false;
			}
			sAss.assertTrue(status, "5");
			if (status) {
				System.out.println("QuePoints visible");
				test.log(Status.INFO, "QuePoints visible");
			}

			////////////////////////////////////////////Note Creation///////////////////////////////
			createNoteInVideo(prop.getProperty("note"));

			System.out.println("Verifying added note");
			test.log(Status.INFO, "Verifying added note");

			applyExplicitWait(5);
			clickOnElement(oso.hamburgerBtn);
			System.out.println("Opening hamburger menu");
			test.log(Status.INFO, "Opening hamburger menu");

			applyExplicitWait(5);
			if (device.equalsIgnoreCase("Android"))
				clickOnElement(findElementByText("NOTES"));
			else
				clickOnElement(oso.hamburgerNotes);
			System.out.println("Opening notes");
			test.log(Status.INFO, "Opening notes");

			System.err.println(findElementByText(prop.getProperty("note")).getText());

			status = findElementByText(prop.getProperty("note")).isEnabled();
			sAss.assertTrue(status, "6");
			if (status) {
				System.out.println("Note added succesfully");
				test.log(Status.INFO, "Note added succesfully");
			}

		} else {
			System.out.println("Video not started");
			test.log(Status.INFO, "Video not started");

		}

		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Create_Note_During_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException, AWTException, ParseException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		applyExplicitWait(5);
		pauseVideo();

		applyExplicitWait(5);
		String actualBookmarkDesc;

		if (device.equalsIgnoreCase("Android"))
			actualBookmarkDesc = driver.findElementById("com.tce.studi:id/exo_progress").getAttribute("content-desc");
		else
			actualBookmarkDesc = oso.seekBar.getAttribute("value");

		System.out.println("actual " + actualBookmarkDesc);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create note Button visible");
			test.log(Status.INFO, "Create note Button visible");
		}

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create note Button is tappable");
			test.log(Status.INFO, "Create note Button is tappable");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Create note Button");
		test.log(Status.INFO, "Clicked on Create note Button");

		//swipeDown();
		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status, "Save Note option not visible");
		if (status) {
			System.out.println("Save Note option is visible");
			test.log(Status.INFO, "Save Note option is visible");
		}

		status = oso.discardNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Discard option is visible");
			test.log(Status.INFO, "Discard option is visible");
		}

		applyExplicitWait(5);

		//oso.noteTxtArea.click();
		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		applyExplicitWait(5);

		status = oso.noteTxtArea.getText().equalsIgnoreCase(prop.getProperty("note"));
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Note entered correctly");
			test.log(Status.INFO, "Note entered correctly");
		} else {
			System.out.println("Note not entered correctly");
			test.log(Status.INFO, "Note not entered correctly");
		}

		driver.hideKeyboard();
		if (!device.equalsIgnoreCase("Android"))
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Save Note option is visible after entering note");
			test.log(Status.INFO, "Save Note option is visible after entering note");
		}

		status = oso.discardNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Discard option is visible after entering note");
			test.log(Status.INFO, "Discard option is visible after entering note");
		}

		applyExplicitWait(5);
		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicking on Save Note");
		test.log(Status.INFO, "Clicking on Save Note");

		System.out.println("Note " + prop.getProperty("note") + " Saved");
		test.log(Status.INFO, "Note " + prop.getProperty("note") + " Saved");

		try {
			if (device.equalsIgnoreCase("Android"))
				status = driver.findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed();
			else
				status = driver.findElement(By.xpath(
						"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton"))
				.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Guidance model displayed after saving note");
				test.log(Status.INFO, "Guidance model displayed after saving note");

				System.out.println("Clicking on Do not show me again");
				test.log(Status.INFO, "Clicking on Do not show me again");
				if (device.equalsIgnoreCase("Android"))
					clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));
				else
					clickOnElement(driver.findElement(By.xpath(
							"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")));
			}
		} catch (Exception e) {
			System.out.println("Guidance model not displayed after saving note");
			test.log(Status.INFO, "Guidance model not displayed after saving note");
		}
		if (!device.equalsIgnoreCase("Android"))
			clickOnElement(findElementByText("CONTINUE"));

		System.out.println("Verifyind added Bookmark of note");
		test.log(Status.INFO, "Verifyind added Bookmark of note");

		clickOnElement(oso.hamburgerBtn);
		if (device.equalsIgnoreCase("Android"))
			clickOnElement(findElementByText("Notes"));
		else
			clickOnElement(oso.hamburgerNotes);

		System.out.println("Opening notes");
		test.log(Status.INFO, "Opening notes");

		clickOnElement(findElementByText(prop.getProperty("note").toLowerCase()));
		System.out.println("Opening note : " + prop.getProperty("note"));
		test.log(Status.INFO, "Opening notes : " + prop.getProperty("note"));

		clickOnElement(findElementByText("Go to Note Location"));
		System.out.println("Clicking on Go to Note Location");
		test.log(Status.INFO, "Clicking on Go to Note Location");

		if (!device.equalsIgnoreCase("Android"))
			clickOnElement(findElementByText("CONTINUE"));
		else
			clickOnElement(findElementByText("Continue"));
		pauseVideo();
		//clickOnElement(rqr.forward);
		applyExplicitWait(5);

		String expected;

		if (device.equalsIgnoreCase("Android"))
			expected = driver.findElementById("com.tce.studi:id/exo_progress").getAttribute("content-desc");
		else
			expected = oso.seekBar.getAttribute("value");

		System.out.println("expected " + expected);

		int diff;

		if (device.equalsIgnoreCase("Android"))
			diff = Integer.parseInt(actualBookmarkDesc.replaceAll("[:0]", ""))
			- Integer.parseInt(expected.replaceAll("[:0]", ""));
		else
			diff = Integer.parseInt(actualBookmarkDesc.replaceAll("%", ""))
			- Integer.parseInt(expected.replaceAll("%", ""));

		status = (diff < 10 && diff > -10) ? true : false;

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Note succefully bookmarked in Video");
			test.log(Status.INFO, "Note succefully bookmarked in Video");
		} else {
			System.out.println("Note can't bookmarked in Video");
			test.log(Status.INFO, "Note can't bookmarked in Video");

		}

		sAss.assertAll();
	}

	public void Verify_Functionality_After_Killing_The_App(String subject, String topic)
			throws InterruptedException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);
		//		status = getDriver()
		//				.findElement(
		//						MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Show player controls\")"))
		//				.isDisplayed();
		//		sAss.assertTrue(status);
		//		if (status) {
		//			System.out.println("TQ resource started for revision");
		//			test.log(Status.INFO, "TQ resource started for revision");
		//		}
		System.out.println("Reset the App");
		test.log(Status.INFO, "Reset the App");
		if (device.equalsIgnoreCase("Android"))
			driver.resetApp();
		else {
			driver.removeApp("com.tce.studi");
			driver.installApp(appPath);
		}

		System.out.println("App relaunching");
		test.log(Status.INFO, "App relaunching");
		driver.launchApp();

		Thread.sleep(3000);

		driver.executeScript("mobile:alert", ImmutableMap.of("action", "accept"));

		System.out.println("Try to login with valid credintials");
		test.log(Status.INFO, "Try to login with valid credintials");

		Module_Login login = new Module_Login();
		login.Login_to_app();

		applyExplicitWait(5);

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("After relauch, user lands on Homepage");
			test.log(Status.INFO, "After relauch, user lands on Homepage");
		}
		sAss.assertAll();
	}

	public void Verify_Functionality_After_Network_Loss_The_App(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		// oso.startRevision2();

		/*
		 * forwardVideoTimerToEnd(); System.out.println("Forwarding video to end");
		 * test.log(Status.INFO,"Forwarding video to end");
		 * 
		 * System.out.println("Quiz started"); test.log(Status.INFO,"Quiz started");
		 * 
		 * System.out.println("Skipping two question in Quiz");
		 * test.log(Status.INFO,"Skipping two question in Quiz");
		 * 
		 * applyExplicitWaitsUntilElementVisible(rqr.question); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 * applyExplicitWaitsUntilElementVisible(rqr.question); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 */

		if (device.equalsIgnoreCase("Android")) {
			((SupportsNetworkStateManagement) driver).toggleData();
			((SupportsNetworkStateManagement) driver).toggleWifi();
		} else {

		}

		String sdkPath = System.getenv("ANDROID_HOME") + "/platform-tools/";

		Runtime.getRuntime().exec(sdkPath + "adb shell settings put global airplane_mode_on 1");

		Thread.sleep(1000);

		Process process = Runtime.getRuntime()

				.exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");

		process.waitFor();

		Thread.sleep(4000);
		System.out.println("Turning OFF Data and Wifi connection");

		/*
		 * applyExplicitWait(5); System.out.println("Try to fetching next question");
		 * test.log(Status.INFO,"Try to fetching next question"); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 */

		Thread.sleep(2000);
		oso.startRevision2();

		status = driver.findElementById("android:id/alertTitle").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("No internet connection message displayed");
			test.log(Status.INFO, "No internet connection message displayed");
		}

		((SupportsNetworkStateManagement) driver).toggleData();
		((SupportsNetworkStateManagement) driver).toggleWifi();

		sdkPath = System.getenv("ANDROID_HOME") + "/platform-tools/";

		Runtime.getRuntime().exec(sdkPath + "adb shell settings put global airplane_mode_on 0");

		Thread.sleep(1000);

		process = Runtime.getRuntime()

				.exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");

		process.waitFor();

		Thread.sleep(4000);

		System.out.println("Turning ON Data and Wifi connection");

		System.out.println("App relaunching");
		test.log(Status.INFO, "App relaunching");
		driver.launchApp();

		System.out.println("Try to login with valid credintials");
		test.log(Status.INFO, "Try to login with valid credintials");

		Module_Login login = new Module_Login();
		login.Login_to_app();

		applyExplicitWait(5);

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		status = findElementByText("Begin Revision").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Begin Revision Button Displayed (i.e. Revision set to Not Started)");
			test.log(Status.INFO, "Begin Revision Button Displayed (i.e. Revision set to Not Started)");
		}

		sAss.assertAll();
	}

	public void Verify_Functionality_The_App_After_Call_Interrupt(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		System.out.println("Trying Call");
		test.log(Status.INFO, "Trying Call");
		((SupportsSpecialEmulatorCommands) driver).makeGsmCall("1010101010", GsmCallActions.CALL);
		Thread.sleep(5000);
		System.out.println("Call Recieved");
		test.log(Status.INFO, "Call Recieved");
		((SupportsSpecialEmulatorCommands) driver).makeGsmCall("1010101010", GsmCallActions.ACCEPT);
		Thread.sleep(5000);
		System.out.println("Call End");
		test.log(Status.INFO, "Call End");
		((SupportsSpecialEmulatorCommands) driver).makeGsmCall("1010101010", GsmCallActions.CANCEL);

		status = findElementByText("What").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on same page after call inturruption");
			test.log(Status.INFO, "Landed on same page after call inturruption");
		}

		sAss.assertAll();
	}

	public void Verify_Functionality_Of_App_In_App_Background_Scenario(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		System.out.println("Minimize app");
		test.log(Status.INFO, "Minimize app");

		// String act=driver.currentActivity();
		// driver.runAppInBackground(Duration.ofMillis(200));
		if (device.equalsIgnoreCase("Android")) {
			((PressesKey) driver).pressKeyCode(AndroidKeyCode.HOME);
			((PressesKey) driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

		} else
			driver.runAppInBackground(Duration.ofSeconds(10));

		System.out.println("Bring App in front");
		test.log(Status.INFO, "Bring App in front");

		if (device.equalsIgnoreCase("Android")) {
			List<MobileElement> apps = driver.findElementsByClassName("android.widget.FrameLayout");
			for (MobileElement mobileElement : apps) {
				if (mobileElement.getAttribute("content-desc").toLowerCase().contains("studi")) {
					clickOnElement(mobileElement);
					break;
				}
			}
		} else {
			HashMap<String, Object> args = new HashMap<>();
			args.put("bundleId", "com.tce.studi");
			driver.executeScript("mobile: activateApp", args);
		}
		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android"))
			status = findElementByText("you").isDisplayed();
		else
			status = findElementByText("you").isDisplayed();
		if (status) {
			System.out.println("List of TQ'a Displayed after maximizing");
			test.log(Status.INFO, "List of TQ'a Displayed after maximizing");
		}
		sAss.assertAll();
	}

	public void Verify_Behaviour_In_Landscape_And_Portrait_Mode_Transition(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);
		pauseVideo();
		status = oso.playBtn.isDisplayed();
		if (status) {
			System.out.println("Video control panel displayed");
			test.log(Status.INFO, "Video control panel displayed");
		}

		System.out.println("Current screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Current screen orientation Is : " + driver.getOrientation());
		System.out.println("Changing screen Orientation to LANDSCAPE.");
		test.log(Status.INFO, "Changing screen Orientation to LANDSCAPE.");

		if (device.equalsIgnoreCase("Android"))
			driver.rotate(ScreenOrientation.LANDSCAPE);
		else
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"fullScreenIcon\"]")).click();

		System.out.println("Now screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Now screen orientation Is : " + driver.getOrientation());

		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android")) {
			clickOnElement(driver.findElementById("com.tce.studi:id/exo_subtitles"));
			getDriver().findElementByAccessibilityId("Pause").click();
		}
		status = oso.playBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video control panel displayed in Landscape mode");
			test.log(Status.INFO, "Video control panel displayed in Landscape mode");
		}
		System.out.println("Changing screen Orientation to PORTRAIT.");
		test.log(Status.INFO, "Changing screen Orientation to PORTRAIT.");

		if (device.equalsIgnoreCase("Android"))
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		else
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"fullScreenIcon\"]")).click();

		System.out.println("Now screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Now screen orientation Is : " + driver.getOrientation());

		applyExplicitWait(5);

		if (device.equalsIgnoreCase("Android"))
			pauseVideo();
		//clickOnElement(rqr.forward);
		applyExplicitWait(5);

		status = oso.playBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video control panel displayed in portrait mode");
			test.log(Status.INFO, "Video control panel displayed in portrait mode");
		}

		sAss.assertAll();

	}

	public void Verify_Behaviour_In_Locking_and_Unlocking_Transition(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		applyExplicitWait(5);
		// String temp =
		// driver.findElementById("com.tce.studi:id/tv_overview").getText();

		applyExplicitWait(5);
		System.out.println("Lock the device");
		test.log(Status.INFO, "Lock the device");
		((LocksDevice) driver).lockDevice();

		applyExplicitWait(5);
		System.out.println("Unlock the device");
		test.log(Status.INFO, "Unlock the device");
		((LocksDevice) driver).unlockDevice();

		if (device.equalsIgnoreCase("Android"))
			status = findElementByText("you").isDisplayed();
		else
			status = findElementByText("you").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on same page after lock\\unlock");
			test.log(Status.INFO, "Landed on same page after lock\\unlock");
		}

		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Abondon_The_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		oso.startRevision2();

		System.out.println("Video started");
		test.log(Status.INFO, "Video started");

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);

		applyExplicitWait(5);

		if (device.equalsIgnoreCase("Android")) {
			if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled()) {
				test.log(Status.INFO, "Exit warning message displayed");
				System.out.println("Exit warning message displayed");
			}
		} else {
			if (getDriver().findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"))
					.isEnabled()) {
				test.log(Status.INFO, "Exit warning message displayed");
				System.out.println("Exit warning message displayed");
			}
		}

		test.log(Status.INFO, "Tapping on Continue revise");
		System.out.println("Tapping on Continue revise");

		if (device.equalsIgnoreCase("Android"))
			clickOnElement(oso.noBtn);
		else
			clickOnElement(findElementByExactText("Cancel"));
		System.out.println("Forwarding Video");
		//forwardVideoTimerToEnd();
		clickOnElement(rqr.forward);
		applyExplicitWait(5);

		String actualQue, expectedQue;

		expectedQue = oso.question.getText();

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);

		applyExplicitWait(5);

		if (device.equalsIgnoreCase("Android")) {
			if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled()) {
				test.log(Status.INFO, "Exit warning message displayed");
				System.out.println("Exit warning message displayed");
			}
		} else {
			if (getDriver().findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"))
					.isEnabled()) {
				test.log(Status.INFO, "Exit warning message displayed");
				System.out.println("Exit warning message displayed");
			}
		}
		test.log(Status.INFO, "Tapping on Continue revise");
		System.out.println("Tapping on Continue revise");
		if (device.equalsIgnoreCase("Android"))
			clickOnElement(oso.noBtn);
		else
			clickOnElement(findElementByExactText("Cancel"));
		applyExplicitWait(5);

		actualQue = oso.question.getText();
		if (actualQue.equalsIgnoreCase(expectedQue)) {
			sAss.assertTrue(actualQue.equalsIgnoreCase(expectedQue));
			test.log(Status.INFO, "same question appear again");
			System.out.println("same question appear again");
		}

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);
		applyExplicitWait(5);

		test.log(Status.INFO, "Tapping on End revise");
		System.out.println("Tapping on End revise");
		if (device.equalsIgnoreCase("Android"))
			clickOnElement(oso.noBtn);
		else
			clickOnElement(findElementByExactText("OK"));
		applyExplicitWait(5);

		// status = findElementByText("What you will revise:").isDisplayed();
		if (device.equalsIgnoreCase("Android"))
			status = findElementByText("you").isDisplayed();
		else
			status = findElementByText("you").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on Bookshelf");
			test.log(Status.INFO, "Landed on Bookshelf");
		}

		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Navigate_To_Revision_Via_MySyllabus(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = findElementByText("Test Unit").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed");
			test.log(Status.INFO, "Test Unit tab displayed");
		}

		status = findElementByText("Syllabus").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab displayed");
			test.log(Status.INFO, "Syllabus tab displayed");
		}
		status = findElementByText("Assignments").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}

		System.out.println("Selecting Syllabus option");
		test.log(Status.INFO, "Selecting Syllabus option");
		clickOnElement(findElementByText("Syllabus"));

		status = oso.allSubjectLbl.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Subjects displayed :");
			test.log(Status.INFO, "Subjects displayed :");
		}


		scrollTo1(subject);
		clickOnElement(findElementByText(subject));
		System.out.println("Opening book for :" + subject);
		test.log(Status.INFO, "Opening book for :" + subject);

		scrollTo1(topic);
		System.out.println("Opening Topic :" + topic);
		test.log(Status.INFO, "Opening Topic :" + topic);
		clickOnElement(findElementByText(topic));

		Boolean status1 = false;
		Boolean status2 = false;
		applyExplicitWait(5);
		try {
			status1 = findElementByText("Revis").isDisplayed();
		} catch (Exception e) {
			try {
				status2 = findElementByText("Revise Again").isDisplayed();
			} catch (Exception e1) {
			}

		}

		if (status1) {
			sAss.assertTrue(status1);
			test.log(Status.INFO, "Begin Revision tab displayed");
			System.out.println("Begin Revision tab displayed");
		} else {
			sAss.assertTrue(status2);
			test.log(Status.INFO, "Revise Again tab displayed");
			System.out.println("Revise Again tab displayed");

		}

		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Launch_Revision_Via_MySyllabus(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		//scrollTo1("Report an issue");
		status = findElementByText("Test Unit").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed");
			test.log(Status.INFO, "Test Unit tab displayed");
		}

		status = findElementByText("Syllabus").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab displayed");
			test.log(Status.INFO, "Syllabus tab displayed");
		}
		status = findElementByText("Assignments").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}

		System.out.println("Selecting Syllabus option");
		test.log(Status.INFO, "Selecting Syllabus option");
		clickOnElement(findElementByText("Syllabus"));

		scrollTo1(subject);
		clickOnElement(findElementByText(subject));
		System.out.println("Opening book for :" + subject);
		test.log(Status.INFO, "Opening book for :" + subject);

		scrollTo1(topic);
		System.out.println("Opening Topic :" + topic);
		test.log(Status.INFO, "Opening Topic :" + topic);
		clickOnElement(findElementByText(topic));

		scrollTo2("Practice");
		Boolean status1 = false;
		Boolean status2 = false;
		applyExplicitWait(5);
		try {
			status1 = findElementByText("Revis").isDisplayed();
		} catch (Exception e) {
			try {
				status2 = findElementByText("Revise Again").isDisplayed();
			} catch (Exception e1) {
			}

		}

		if (status1) {
			sAss.assertTrue(status1);
			test.log(Status.INFO, "Begin Revision tab displayed");
			System.out.println("Begin Revision tab displayed");
			findElementByText("Revis").click();

		} else {
			sAss.assertTrue(status2);
			test.log(Status.INFO, "Revise Again tab displayed");
			System.out.println("Revise Again tab displayed");
			findElementByText("Revis").click();
		}

		applyExplicitWait(5);
		/*
		 * try { status1 =
		 * Boolean.parseBoolean(findElementByText("Begin Revision").getAttribute(
		 * "clickable")); } catch (Exception e) { } try { status2 =
		 * Boolean.parseBoolean(findElementByText("Revise Again").getAttribute(
		 * "clickable")); } catch (Exception e) { } if (status1) {
		 * sAss.assertTrue(status1); test.log(Status.INFO,
		 * "Begin Revision tab clickable");
		 * System.out.println("Begin Revision tab clickable"); } else {
		 * sAss.assertTrue(status2); test.log(Status.INFO,
		 * "Revise Again tab clickable");
		 * System.out.println("Revise Again tab clickable"); }
		 */

		applyExplicitWait(5);
		//if (device.equalsIgnoreCase("Android"))
		status = findElementByText("you").isDisplayed();
		//else
		//status = findElementByText("you").isDisplayed();
		if (status) {
			System.out.println("List of TQ's Displayed");
			test.log(Status.INFO, "List of TQ's Displayed");
		}
		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Attempt_Revision_Multiple_Times(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		int TQ_count = driver.findElements(By.xpath("//*[@type=\"XCUIElementTypeCell\"]")).size();
		System.out.println(TQ_count);
		oso.startRevision2();

		for (int j = 0; j < TQ_count - 1; j++) {

			System.out.println("Video Started");
			test.log(Status.INFO, "Video Started");

			System.out.println("Forwarding Video");
			test.log(Status.INFO, "Forwarding Video");
			//forwardVideoTimerToEnd();
			clickOnElement(rqr.forward);
			applyExplicitWait(5);

			System.out.println("Quiz Started");
			test.log(Status.INFO, "Quiz Started");

			System.out.println("Skipping the Quiz");
			test.log(Status.INFO, "Skipping the Quiz");

			int count = getTotalQuestionsInPractice();
			for (int i = 0; i < count; i++) {
				applyExplicitWaitsUntilElementVisible(oso.question);
				System.out.println("Next question");
				test.log(Status.INFO, "Next question");
				clickOnElement(rqr.nextButton);
			}
			applyExplicitWait(5);
			status = oso.letsSummriseTxt.isDisplayed();
			if (status) {
				System.out.println("resouces completed");
				test.log(Status.INFO, "resouces completed");
			}
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_View_Summary_Pages(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		int  TQ_count;
		applyExplicitWait(5);


		if (device.equalsIgnoreCase("Android"))
			TQ_count=driver.findElements(By.id("com.tce.studi:id/ivOverview")).size();

		else
			TQ_count = driver.findElements(By.xpath("//*[@type=\"XCUIElementTypeCell\"]")).size();
		System.out.println(TQ_count);
		oso.startRevision2();
		for (int j = 0; j < TQ_count; j++) 

		{
			System.out.println("Video Started");
			test.log(Status.INFO, "Video Started");
			System.out.println("Forwarding Video");
			test.log(Status.INFO, "Forwarding Video");
			//forwardVideoTimerToEnd();
			clickOnElement(oso.forward);

			Thread.sleep(3000);

			System.out.println("Quiz Started");
			test.log(Status.INFO, "Quiz Started");

			System.out.println("Skipping the Quiz");
			test.log(Status.INFO, "Skipping the Quiz");
			applyExplicitWaitsUntilElementVisible(oso.question);
			Thread.sleep(3000);
			clickOnElement(oso.forward);
			Thread.sleep(3000);
			clickOnElement(oso.forward);

			//status = oso.letsSummriseTxt.isDisplayed();
			//if (status) {
			//System.out.println("Summary of TQ displayed");
			//test.log(Status.INFO, "Summary of TQ displayed");
			//}

			//			if (device.equalsIgnoreCase("Android"))
			//				clickOnElement(findElementByText("CONTINUE"));
			//			else
			//				clickOnElement(findElementByText("Continue"));

		}

		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android"))
			status = findElementByText("you").isDisplayed();
		else
			status = findElementByText("you").isDisplayed();
		if (status) {
			System.out.println("All TQ's completed");
			test.log(Status.INFO, "All TQ's completed");
		}

		status = findElementByText("Continue Studying").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Continue Studying button Displayed");
			test.log(Status.INFO, "Continue Studying button Displayed");
		}
		applyExplicitWait(2);
		status = findElementByText("Revise again").isEnabled();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Revise again button Displayed");
			test.log(Status.INFO, "Revise again button Displayed");
		}

		if (device.equalsIgnoreCase("Android")) {
			applyExplicitWaitsUntilElementVisible(oso.tertiaryBtnBottom);
			clickOnElement(oso.tertiaryBtnBottom);
			status = findElementByText("Return to Subject").isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Return to Subject button available");
				test.log(Status.INFO, "Return to Subject button available");
			}
			action = new TouchAction(driver);
			getTouchAction().tap(PointOption.point((driver.manage().window().getSize().width) / 2,
					(driver.manage().window().getSize().height) / 2)).perform();

		}

		if (device.equalsIgnoreCase("Android"))
			clickOnElement(findElementByText("Revise again"));
		else {
			MobileElement btn = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Revise again\"]"));
			driver.performTouchAction(
					new TouchAction(driver).tap(PointOption.point(((btn.getLocation().x) + (btn.getSize().width / 2)),
							((btn.getLocation().y) + (btn.getSize().height / 2)))));
		}
		test.log(Status.INFO, "Clicked on Revise again");
		System.out.println("Clicked on Revise again");
		applyExplicitWait(5);

		// applyExplicitWaitsUntilElementVisible(oso.continueOnVdoBtn);

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);
		applyExplicitWait(5);

		test.log(Status.INFO, "Tapping on End revise");
		System.out.println("Tapping on End revise");
		if (device.equalsIgnoreCase("Android"))
			clickOnElement(oso.yesBtn);
		else
			clickOnElement(findElementByExactText("OK"));

		status = findElementByText("Continue Studying").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on Bookshelf");
			test.log(Status.INFO, "Landed on Bookshelf");
		}

		sAss.assertAll();
	}
	public void Verify_Behaviour_In_Sleep_Mode(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		try {
			System.out.println("Left the app unattended for 1 Min");
			test.log(Status.INFO, "Left the app unattended for 1 Min");
			for (int i = Integer.parseInt(prop.getProperty("timerDuration")); i > 0; i--) {
				label2.setText("");
				label.setText("");

				startCounter(i);
				Thread.sleep(1000);
				frame.dispose();
			}
			if (device.equalsIgnoreCase("Android"))
				status = findElementByText("you").isDisplayed();
			else
				status = findElementByText("you").isDisplayed();
			sAss.assertFalse(status);
			if (status) {
				System.out.println("Same page is visible after visible after sleep");
				test.log(Status.INFO, "Same page is visible after visible after sleep");
			}
		} catch (Exception ne) {
			System.out.println("Session expired/User Logged out after sleep mode");
			test.log(Status.INFO, "Session expired/User Logged out after sleep mode");

		}
		sAss.assertAll();

	}

	public void Verify_Create_Note_Icon_Should_Be_Visible_In_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android"))
			status = getDriver().findElement(By.xpath(
					"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
			.isDisplayed();
		else
			status = getDriver().findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther"))
			.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("TQ started");
			test.log(Status.INFO, "TQ started");
			pauseVideo();
			applyExplicitWait(5);
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Write_Upto_3000_Charcters_In_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException, AWTException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		System.out.println("Try to enter more than 3000 characters in note");
		test.log(Status.INFO, "Try to enter more than 3000 characters in note");
		String temp = "";
		for (int i = 0; i < oso.notesLimit + 10; i++) {
			temp = temp + "T";
		}
		oso.noteTxtArea.sendKeys(temp);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entering " + temp.length() + " characters and " + temp2.length() + " characters accepted");
		test.log(Status.INFO,
				"Entering " + temp.length() + " characters and " + temp2.length() + " characters accepted");

		status = oso.notesLimit == temp2.length() ? true : false;
		sAss.assertTrue(status,
				"Entering " + temp.length() + " characters and " + temp2.length() + " characters accepted");

		sAss.assertAll();
	}

	public void Verify_User_Is_Unable_To_Add_Empty_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		//clickOnElement(rqr.forward);
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Try to add note without any Text");
		test.log(Status.INFO, "Try to add note without any Text");

		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicked on Save note Button");
		test.log(Status.INFO, "Clicked on Save note Button");

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Error message displayed. Not Allowed to add empty note");
			test.log(Status.INFO, "Error message displayed. Not Allowed to add empty note");
		}

		System.out.println("Try to add note with adding Blank-spaces");
		test.log(Status.INFO, "Try to add note with adding Blank-spaces");

		System.out.println("Adding spaces in Text area");
		test.log(Status.INFO, "Adding spaces in Text area");
		String temp = "";
		for (int i = 0; i < 10; i++) {
			temp = temp + " ";
		}

		oso.noteTxtArea.sendKeys(temp);
		driver.hideKeyboard();
		if (!device.equalsIgnoreCase("Android"))
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicked on Save note Button");
		test.log(Status.INFO, "Clicked on Save note Button");
		status = false;
		try {
			status = oso.noteTxtArea.isDisplayed();
		} catch (Exception e) {
			sAss.assertTrue(status, "Error message not displayed. App Allowed to add empty note");
			if (status) {
				System.out.println("Error message displayed. Not Allowed to add empty note");
				test.log(Status.INFO, "Error message displayed. Not Allowed to add empty note");
			} else {
				System.out.println("Error message not displayed. App Allowed to add empty note");
				test.log(Status.INFO, "Error message not displayed. App Allowed to add empty note");
			}
		}

		sAss.assertAll();
	}

	public void Verify_Create_Note_Icon_Should_Be_Clickable_In_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android"))
			status = getDriver().findElement(By.xpath(
					"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
			.isDisplayed();
		else
			status = getDriver().findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther"))
			.isDisplayed();

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started ");
			pauseVideo();
			applyExplicitWait(5);
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		if (device.equalsIgnoreCase("Android"))
			status = oso.addNotesBtn.getAttribute("clickable").trim().equalsIgnoreCase("true");
		else
			status = oso.addNotesBtn.isEnabled();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes button is Clickable");
			test.log(Status.INFO, "Add notes button is Clickable");
		}

		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");
		clickOnElement(oso.addNotesBtn);

		applyExplicitWait(5);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add Note module window displayed");
			test.log(Status.INFO, "Add Note module window displayed");
		}

		sAss.assertAll();
	}

	public void Verify_User_Is_Able_To_Enter_Special_Characters_In_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to enter Text with special characters");
		test.log(Status.INFO, "Try to enter Text with special characters");
		String temp = "T@t@ $tud!";
		oso.noteTxtArea.sendKeys(temp);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + temp + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + temp + ", Accepted text by note module: " + temp2);

		status = temp.equalsIgnoreCase(temp2) ? true : false;
		sAss.assertTrue(status, "User can't enter special characters in note");
		if (status) {
			System.out.println("User can enter special characters in note");
			test.log(Status.INFO, "User can enter special characters in note");
		}

		sAss.assertAll();

	}

	public void Verify_Note_Module_Will_Cosed_Without_Warning(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to close Note Module without adding any text in note");
		test.log(Status.INFO, "Try to close Note Module without adding any text in note");

		System.out.println("Clicked on Close(X) Button");
		test.log(Status.INFO, "Clicked on Close(X) Button");
		clickOnElement(oso.closeNotesBtn);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Notes Module closed without any warning message");
			test.log(Status.INFO, "Notes Module closed without any warning message");
		}
		sAss.assertAll();
	}

	public void Verify_Warning_Message_Shown_After_Clicking_Discard_In_Notes(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();
		pauseVideo();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status, "1");
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to close Note Module without adding any text in note");
		test.log(Status.INFO, "Try to close Note Module without adding any text in note");

		System.out.println("Clicked on Close(X) Button");
		test.log(Status.INFO, "Clicked on Close(X) Button");
		clickOnElement(oso.closeNotesBtn);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status, "2");
		if (status) {
			System.out.println("Notes Module closed without any warning message");
			test.log(Status.INFO, "Notes Module closed without any warning message");
		}

		System.out.println("Verifying Discard Button");
		test.log(Status.INFO, "Verifying Discard Button");

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status, "3");
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to enter text in note and Click Discard Button");
		test.log(Status.INFO, "Try to enter text in note and Click Discard Button");

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		if (device.equalsIgnoreCase("Android"))
			driver.hideKeyboard();
		else
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);


		System.out.println("Clicked on Discard Button");
		test.log(Status.INFO, "Clicked on Discard Button");
		clickOnElement(oso.discardNoteBtn);

		status = oso.discardWarnMsg.isDisplayed();
		sAss.assertTrue(status, "4");
		if (status) {
			System.out.println("Warning message displayed to Discard Note");
			test.log(Status.INFO, "Warning message displayed to Discard Note");
		}

		System.out.println("Cancel the discarding process");
		test.log(Status.INFO, "Cancel the discarding process");
		clickOnElement(oso.discardDenyBtn);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status, "5");
		if (status) {
			System.out.println("User can still able to modify entered text");
			test.log(Status.INFO, "User can still able to modify entered text");
		}

		System.out.println("Clicked on Discard Button");
		test.log(Status.INFO, "Clicked on Discard Button");
		clickOnElement(oso.discardNoteBtn);

		status = oso.discardWarnMsg.isDisplayed();
		sAss.assertTrue(status, "6");
		if (status) {
			System.out.println("Warning message displayed to Discard Note");
			test.log(Status.INFO, "Warning message displayed to Discard Note");
		}

		System.out.println("Accept the discarding process");
		test.log(Status.INFO, "Accept the discarding process");
		clickOnElement(oso.discardAcceptBtn);

		if (device.equalsIgnoreCase("Android"))
			status = oso.addNotesBtn.isDisplayed();
		else
			status = oso.noteTxtArea.getText().isEmpty();
		sAss.assertTrue(status, "7");
		if (status) {
			System.out.println("Note discarded using Discard Button");
			test.log(Status.INFO, "Note discarded using Discard Button");
		}
		sAss.assertAll();
	}

	public void Verify_Notes_Will_Be_Saved_Using_Save_Note_Option(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		if (device.equalsIgnoreCase("Android"))
			status = getDriver().findElement(By.xpath(
					"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
			.isDisplayed();
		else
			status = getDriver().findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther"))
			.isDisplayed();

		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started");
			pauseVideo();
			applyExplicitWait(5);
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");
		clickOnElement(oso.addNotesBtn);

		applyExplicitWait(5);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add Note module window displayed");
			test.log(Status.INFO, "Add Note module window displayed");
		}

		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Save Note option is visible");
			test.log(Status.INFO, "Save Note option is visible");
		}

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		applyExplicitWait(5);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);

		if (device.equalsIgnoreCase("Android"))
			driver.hideKeyboard();
		else
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Save Note option is visible after entering note");
			test.log(Status.INFO, "Save Note option is visible after entering note");
		}

		applyExplicitWait(5);
		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicking on Save Note");
		test.log(Status.INFO, "Clicking on Save Note");

		System.out.println("Note " + prop.getProperty("note") + " Saved");
		test.log(Status.INFO, "Note " + prop.getProperty("note") + " Saved");

		try {
			if (device.equalsIgnoreCase("Android"))
				status = driver.findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed();
			else
				status = driver.findElement(By.xpath(
						"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton"))
				.isDisplayed();
			if (status) {
				System.out.println("Guidance model displayed after saving note");
				test.log(Status.INFO, "Guidance model displayed after saving note");

				System.out.println("Clicking on Do not show me again");
				test.log(Status.INFO, "Clicking on Do not show me again");
				if (device.equalsIgnoreCase("Android"))
					clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));
				else
					clickOnElement(driver.findElement(By.xpath(
							"//XCUIElementTypeApplication[@name=\"Studi QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")));

			} else {
				System.out.println("Guidance model not displayed after saving note");
				test.log(Status.INFO, "Guidance model not displayed after saving note");
			}
		} catch (Exception e) {
			System.out.println("Guidance model not displayed after saving note");
			test.log(Status.INFO, "Guidance model not displayed after saving note");
		}

		System.out.println("Verifyind added Bookmark of note");
		test.log(Status.INFO, "Verifyind added Bookmark of note");

		clickOnElement(oso.hamburgerBtn);

		System.out.println("Verifying total notes count");
		test.log(Status.INFO, "Verifying total notes count");
		//System.out.println(oso.notesCountIndicator.findElement(By.xpath("//*[@type=\"XCUIElementTypeStaticText\"]")).getAttribute("value"));

		if(device.equalsIgnoreCase("Android"))
			status = Integer.parseInt(oso.notesCountIndicator.getText()) == (notesCount + 1) ? true : false;
		else
			status=Integer.parseInt(oso.notesCountIndicator.findElement(By.xpath("//*[@type=\"XCUIElementTypeStaticText\"]")).getAttribute("value"))== (notesCount + 1) ? true : false;
		if (status) {
			System.out.println("Notes count increased by 1 succefully");
			test.log(Status.INFO, "Notes count increased by 1 succefully");
		}

		if(device.equalsIgnoreCase("Android"))
			clickOnElement(driver.findElementById("com.tce.studi:id/tvNotes"));
		else 
			clickOnElement(oso.hamburgerNotes);

		System.out.println("Opening note list");
		test.log(Status.INFO, "Opening note list");

		status = findElementByText(prop.getProperty("note")).isDisplayed();
		if (status) {
			System.out.println(prop.getProperty("note") + " succefully saved in list");
			test.log(Status.INFO, prop.getProperty("note") + " succefully saved in list");
		}

		sAss.assertAll();

	}

	public void Verify_Save_Note_Button_Should_Be_Disable_Initially(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Checking Status of Save Note button");
		test.log(Status.INFO, "Checking Status of Save Note button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertFalse(status, "Save note Button clickable without entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disabled initially");
			test.log(Status.INFO, "Save Note button is disabled initially");

		}

		sAss.assertAll();
	}

	public void Verify_Save_Note_Button_Enable_After_User_Entering_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();
		pauseVideo();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Checking Status of Save Note button");
		test.log(Status.INFO, "Checking Status of Save Note button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertFalse(status, "Save note Button clickable without entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disabled initially");
			test.log(Status.INFO, "Save Note button is disabled initially");

		}

		System.out.println("Entering Note in Text area");
		test.log(Status.INFO, "Entering Note in Text area");

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		driver.hideKeyboard();

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertTrue(status, "Save note Button disabled after entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disable after entering Text");
			test.log(Status.INFO, "Save Note button is disable after entering Text");

		}

		sAss.assertAll();

	}

	public void Verify_Save_Note_And_Discard_Button_Should_Be_Disable_Initially(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		//clickOnElement(rqr.forward);
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Checking Status of Save Note button");
		test.log(Status.INFO, "Checking Status of Save Note button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertFalse(status, "Save note Button clickable without entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disabled initially");
			test.log(Status.INFO, "Save Note button is disabled initially");

		}

		System.out.println("Checking Status of Discard button");
		test.log(Status.INFO, "Checking Status of Discard button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.discardNoteBtn.getAttribute("clickable"));
		else
			status = oso.discardNoteBtn.isEnabled();
		sAss.assertFalse(status, "Discard Button clickable without entering Text");
		if (status) {
			System.out.println("Discard button is Clickable");
			test.log(Status.INFO, "Discard button is Clickable");
		} else {
			System.out.println("Discard button is disabled initially");
			test.log(Status.INFO, "Discard button is disabled initially");

		}

		sAss.assertAll();

	}

	public void Verify_Save_Note_And_Discard_Button_Enable_After_User_Entering_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();

		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Checking Status of Save Note button");
		test.log(Status.INFO, "Checking Status of Save Note button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertFalse(status, "Save note Button clickable without entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disabled initially");
			test.log(Status.INFO, "Save Note button is disabled initially");

		}

		System.out.println("Checking Status of Discard button");
		test.log(Status.INFO, "Checking Status of Discard button");

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.discardNoteBtn.getAttribute("clickable"));
		else
			status = oso.discardNoteBtn.isEnabled();
		sAss.assertFalse(status, "Discard Button clickable without entering Text");
		if (status) {
			System.out.println("Discard button is Clickable");
			test.log(Status.INFO, "Discard button is Clickable");
		} else {
			System.out.println("Discard button is disabled initially");
			test.log(Status.INFO, "Discard button is disabled initially");

		}

		System.out.println("Entering Note in Text area");
		test.log(Status.INFO, "Entering Note in Text area");

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		if (device.equalsIgnoreCase("Android"))
			driver.hideKeyboard();
		else
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.saveNoteBtn.getAttribute("clickable"));
		else
			status = oso.saveNoteBtn.isEnabled();
		sAss.assertTrue(status, "Save note Button disabled after entering Text");
		if (status) {
			System.out.println("Save Note button is Clickable");
			test.log(Status.INFO, "Save Note button is Clickable");
		} else {
			System.out.println("Save Note button is disable after entering Text");
			test.log(Status.INFO, "Save Note button is disable after entering Text");

		}

		status = Boolean.parseBoolean(oso.discardNoteBtn.getAttribute("clickable"));
		if (device.equalsIgnoreCase("Android"))
			status = Boolean.parseBoolean(oso.discardNoteBtn.getAttribute("clickable"));
		else
			status = oso.discardNoteBtn.isEnabled();
		if (status) {
			System.out.println("Discard button is Clickable");
			test.log(Status.INFO, "Discard button is Clickable");
		} else {
			System.out.println("Discard button is disable after entering Text");
			test.log(Status.INFO, "Discard button is disable after entering Text");

		}
		sAss.assertAll();

	}

	public void Verify_Note_Area_Have_Initial_Message_For_Entering_Text(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();
		pauseVideo();
		applyExplicitWait(5);
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Checking for Initial message available in text area");
		test.log(Status.INFO, "Checking for Initial message available in text area");

		status = oso.noteTxtArea.getText().equalsIgnoreCase("Insert text here");
		sAss.assertTrue(status, "Guidance message not available in Note Text area");
		if (status) {
			System.out.println("Guidance message available in Note Text area as : " + oso.noteTxtArea.getText());
			test.log(Status.INFO, "Guidance message available in Note Text area as : " + oso.noteTxtArea.getText());
		} else {
			System.out.println("Guidance message not available in Note Text area");
			test.log(Status.INFO, "Guidance message not available in Note Text area");

		}

		sAss.assertAll();

	}
}