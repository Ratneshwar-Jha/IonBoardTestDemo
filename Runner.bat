%~d1
cd "%~p1"
java -cp "./lib/*;bin" com.hcl.ionboard.testngrunner.TestNGRunner
java -cp "./lib/*;bin" org.testng.TestNG TestSuite.xml
pause
