package com.messaging.android.test.uiautomator.tests;

import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Messaging {
	
	int[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	
	public static int getRandom(int[] index) {
	    int rnd = new Random().nextInt(index.length);
	    return index[rnd];
	}
	
	UiObject emptyConversationsList = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/conversationlist_emptytext_view"));
	
	UiObject conversationsList = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/conversationlist_item"));
	
	UiObject dialog = new UiObject(new UiSelector()
			.resourceId("android:id/select_dialog_listview"));
		
	UiObject newStickersIcon = new UiObject(new UiSelector()
			.className("android.widget.HorizontalScrollView").childSelector(new UiSelector().index(0)));
	
	UiObject composeIcon = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/floating_button_new_conversation"));
	
	UiObject recipientNumberField = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/recipients_editor"));

	UiObject messageTextField = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/conversation_edit_text"));
	
	UiObject attachmentIcon = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/conversation_tool_button_image"));
	
	UiObject addStickerOption = new UiObject(new UiSelector()
			.text("Add sticker")); 
	
	UiObject addRandomAvailableSticker = new UiObject(new UiSelector()
			.className("android.widget.ImageView")
			.index(getRandom(index)));
	
	UiObject sendMessageIcon = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/conversation_send_button"));
	
	UiObject moreOptionsIcon = new UiObject(new UiSelector()
			.descriptionContains("More options"));
	
	UiObject deleteConversations = new UiObject(new UiSelector()
			.text("Delete conversations"));
	
	UiObject markAllCheckbox = new UiObject(new UiSelector()
			.text("0 selected"));
	
	UiObject markAllButton = new UiObject(new UiSelector()
			.text("Mark all"));
	
	UiObject trashIcon = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/menu_delete"));
	
	UiObject deleteConfirmation = new UiObject(new UiSelector()
			.resourceId("android:id/button1"));
	
	UiObject okButton = new UiObject(new UiSelector()
			.resourceId("android:id/button1"));
	
	UiObject sentMmsImage = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/sticker_view"));
	
	UiObject viewMessageDetails = new UiObject(new UiSelector()
			.text("View message details"));
	
	UiObject messageDetails = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/content_description"));
	
	UiObject messageBubble = new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/bubble_content"));
	
	public void validatingText(String text) {
		new UiObject(new UiSelector()
			.text(text));		
	}

	public void checkIfStikerIsInBodyOfMessage() throws UiObjectNotFoundException {
		new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/composer_sticker_image")).isFocusable();		
	}
	
	public void checkIfMmsIconIsDisplayed() throws UiObjectNotFoundException {
		new UiObject(new UiSelector()
			.resourceId("com.sonyericsson.conversations:id/primary_info")).isFocusable();
	}
	
	public void composeAndSetRecipient() throws UiObjectNotFoundException {
		composeIcon.click(); 														// Finding and clicking on "Compose new message" icon
		recipientNumberField.setText("6507738660"); 								// Typing telephone number into "To" field
	}

	public void deleteConversations() throws UiObjectNotFoundException {
		
		if (conversationsList.exists()) {
			moreOptionsIcon.click(); 												// Clicking on "More options" icon
			deleteConversations.click(); 											// Clicking on "Delete Messages" drop down menu
			markAllCheckbox.click(); 												// Selecting all messages using "Mark all" drop down
			markAllButton.click();
			trashIcon.click(); 														// Clicking trash icon
			deleteConfirmation.click(); 											// Accepting confirmation by clicking "Delete"
		}
	}
	
	public void getReadyForMessaging() throws UiObjectNotFoundException, InterruptedException { 
		UiDevice.getInstance().pressHome(); 										// Pressing "Home" button
		UiDevice.getInstance().click(756, 1643); 									// Finding and clicking on Messaging icon on home screen
		Thread.sleep(500);
			while (!composeIcon.exists()) {											// If compose icon is not displayed, click back
				UiDevice.getInstance().pressBack();									// Clicking back
				UiDevice.getInstance().pressHome(); 								// Pressing "Home" button
				UiDevice.getInstance().click(756, 1643);							// Finding and clicking on Messaging icon on home screen
			}
//		deleteConversations();
		composeAndSetRecipient();
	}
}