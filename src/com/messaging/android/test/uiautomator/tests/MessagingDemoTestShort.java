package com.messaging.android.test.uiautomator.tests;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MessagingDemoTestShort extends UiAutomatorTestCase {

	// TEST STARTS HERE
	public void testMessagingShort() throws UiObjectNotFoundException, InterruptedException {

		Messaging messaging = new Messaging();
		messaging.getReadyForMessaging();												// Setting up for test
		messaging.messageTextField.setText("Hello from UI Automator"); 					// Typing text into text field 
		messaging.sendMessageIcon.click(); 												// Clicking "Send message" icon
		messaging.validatingText("Hello from UI Automator"); 							// Checking if sent text present
	}
	// TEST ENDS HERE
	
	// TEST STARTS HERE
	public void testMmsShort() throws UiObjectNotFoundException, InterruptedException {

		Messaging messaging = new Messaging();
		messaging.attachmentIcon.click();												// Clicking on attachment icon
		messaging.addStickerOption.click();												// Clicking "Add sticker" option
		messaging.newStickersIcon.click();												// Selecting all available stickers grid
		messaging.addRandomAvailableSticker.click();									// Picking random sticker from all available
		UiDevice.getInstance().pressBack();												// Hiding sticker grid
		messaging.checkIfStikerIsInBodyOfMessage();										// Checking if sticker is displayed in body of message
		messaging.checkIfMmsIconIsDisplayed();											// Checking if MMS icon is displayed
		messaging.sendMessageIcon.click();												// Clicking "Send message" icon
		Thread.sleep(3000);
		messaging.sentMmsImage.longClick();												// Long press on sent sticker to trigger pop up menu
			while (!messaging.dialog.exists()) {										// Checking if pop up menu showed up
				UiDevice.getInstance().pressBack();										// If not, pressing back
				UiDevice.getInstance().waitForWindowUpdate("com.sonyericsson.conversations", 3000);
				messaging.sentMmsImage.longClick();										// Long press on sent sticker to trigger pop up menu
			}
		messaging.viewMessageDetails.click();											// Clicking on "View message details" option
		String verify = messaging.messageDetails.getText();								// Reading text from pop up window
		String last = verify.substring(verify.length() - 4);							// Getting last 4 letters from entire text
		System.out.println(last);														// Printing last 4 letters into console
			while (!last.contains("Sent")) {											// Method that runs check in a loop until last 4 letters will match with "Sent"
				messaging.okButton.click();
				messaging.sentMmsImage.longClick();
				messaging.viewMessageDetails.click();				 
				verify = messaging.messageDetails.getText();
				last = verify.substring(verify.length() - 4);
				System.out.println(last);
		}
		assertEquals("Sent", last);														// Performing assertion
		messaging.okButton.click();														// Closing pop up
	}
	// TEST ENDS HERE
}