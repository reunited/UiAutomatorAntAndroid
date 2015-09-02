UiAutomatorExample
==================

An example using UI Automator for testing Android applications. I used the native messaging app as subject to be tested.

##Running project with attached jar
> adb push /Path/to/git/folder/UiAutomatorExample.jar /data/local/tmp

> adb shell uiautomator runtest UiAutomatorExample.jar -c com.uiautomator.android.test.uiautomator.tests


##Build the project from source
###Dependencies
First add the following dependencies to the project:
> JUnit 3

> uiautomator.jar

> android.jar

###Build project
Generate an Ant build file, and compile it with ant
> ./android create uitest-project -n UiAutomatorExample -t 1 -p /Users/path/to/workspace/project

>  ant build

###Running project
Copy the jar to the SD-card and run the test
> adb push bin/UiAutomatorExample.jar /data/local/tmp

> adb shell uiautomator runtest UiAutomatorExample.jar -c com.uiautomator.android.test.uiautomator.tests
