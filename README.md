# This is a Framework for Vois Automation Task 
- Selenium Framework project using Java , Maven , TestNG and POM
for automation task 

# Tech Stach:-

- Java 
- Maven 
- TestNG 
- DDT for Creating users data 
- Extent Report for reporting in HTML5 format
- Automation-remarks for recording all tests in video 

# Test Flow
* Sign Up Info exist in User_Data excel sheet located in TestData directory
* Sign In Info exist same excel sheet but in different sheet 
* There are 3 test cases : 
    - Sign up
    - Sign in
    - Create order , check out then make sure order was placed in history page
    
    
* All tests are recorded in as video located in Video directory with .avi format with test name+run time.
 
     - if you want to record only failed test cases just comment below line in BaseTest class
  	    	  System.setProperty("video.save.mode", RecordingMode.ALL.toString());
  


* Extent Report generated after running the test cases with name : Vois GUI Automation + runtime
      - every test case in the report has a screenshot for the last step in the testcase
 
