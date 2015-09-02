package com.messaging.android.test.uiautomator.tests;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MessagingDemoTestLong extends UiAutomatorTestCase {

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		// Pressing "Home" button
		super.getUiDevice().pressHome();

	}

	public void testMessaging() throws UiObjectNotFoundException, InterruptedException {

		// Finding and clicking on Messaging icon on home screen
		// NEED UNIQUE RESOURCE ID FOR MESSAGING ICON!!!

		UiDevice.getInstance().click(756, 1643);

		// Finding and clicking on "Compose new message" icon
		new UiObject(new UiSelector().resourceId("com.sonyericsson.conversations:id/floating_button_new_conversation"))
				.click();

		// Typing telephone number into "To" field
		new UiObject(new UiSelector().resourceId("com.sonyericsson.conversations:id/recipients_editor"))
				.setText("6507738660");

		// Typing text into text field
		new UiObject(new UiSelector().resourceId("com.sonyericsson.conversations:id/conversation_edit_text"))
				.setText("Hello from UI Automator");

		// Clicking "Send message" icon
		new UiObject(new UiSelector().resourceId("com.sonyericsson.conversations:id/conversation_send_button")).click();

		Thread.sleep(2000);

		// Checking if sent text present
		new UiObject(new UiSelector().text("Hello from UI Automator"));

		// Clicking on "More options" icon
		new UiObject(new UiSelector().descriptionContains("More options")).click();

		// Clicking on "Delete messages" in "More options" drop down
		new UiObject(new UiSelector().text("Delete messages")).click();

		// Selecting all messages using "Mark all" drop down
		new UiObject(new UiSelector().text("0 selected")).click();

		new UiObject(new UiSelector().text("Mark all")).click();

		// Clicking trash icon
		new UiObject(new UiSelector().resourceId("com.sonyericsson.conversations:id/menu_delete")).click();

		// Accepting confirmation by clicking "Delete"
		new UiObject(new UiSelector().resourceId("android:id/button1")).click();
	}

	@Override
	protected void tearDown() throws Exception {

		// Returning to initial state (back to home screen, until line 14 is
		// fixed)
		super.tearDown();
		super.getUiDevice().pressHome();

	}

}