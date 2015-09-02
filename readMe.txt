1. ant (copy to C:/ and specify path in System Variables)
2. adroid sdk (copy to C:/ and specify path in System Variables)
3. In new java project add external jars: android.jar and uiautomator.jar (path: C:\Android\android-sdk\platforms\android-23)
4. Create empty local.properties in project directory
5. Generate build.xml: C:\Android\android-sdk\tools\android create uitest-project -n PROJECT_NAME -t 1 -p C:\workspace\PROJECT_NAME
6. Generate project jar file in project directory: ant build
7. Upload .jar to SD card: adb push bin/PROJECT_NAME.jar /data/local/tmp
8. Run test: adb shell uiautomator runtest PROJECT_NAME.jar -c com.MY_PROJECT.android.test.uiautomator.MY_DEMO_TEST (path to your class with tests in project)