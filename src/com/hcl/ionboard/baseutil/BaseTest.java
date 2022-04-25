package com.hcl.ionboard.baseutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.hcl.ionboard.commonutil.FileOperation;
import com.hcl.ionboard.reports.ExtentHCLManager;
import com.hcl.ionboard.reports.ExtentHCLTest;
import com.hcl.ionboard.util.WebActionUtil;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * 
 * @author : Shreya U ,Vivek Dogra, Aatish Slathia
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : Launches the browser according to the browser name specified.
 * @AfterClass : Closes the browser after completion of execution
 * @AfterSuite: Kills the driver (example chromedriver.exe) according to browser
 *              specified.
 */

public class BaseTest {

	public WebDriver driver;
	public static Properties prop;
	public static Properties prop_app_constants;
	public static final int ITO = 10;
	public static final int ETO = 10;
	public static String sDirPath = System.getProperty("user.dir");
	public static final String EXCELPATH = sDirPath + "./data/IOnBoardTestData.xlsx";
	public static final String CLAIMTYPEEXCELPATH = sDirPath + "./data/ClaimTypeTemplateData.xlsx";
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static WebActionUtil WebActionUtil;
	public String testCaseName;
	public DesiredCapabilities cap;
	public static final String CONFIGPATH = sDirPath + "./config/config.properties";
	public static ChromeOptions chromeOpt;
	public static final String DATACONSTANTSPATH = sDirPath + "./data/data_constants.properties";
	public static String className;
	static {
		try {
			prop = new Properties();
			prop_app_constants = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);

			FileInputStream fis1 = new FileInputStream(DATACONSTANTSPATH);
			prop_app_constants.load(fis1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Description : Creates folder structure for Extent reports.
	 * 
	 * @author:Shreya U
	 */
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {
			logger.info("Folder creation for Extent");
			FileOperation fileOperation = new FileOperation();
			fileOperation.CreateFiles();
			Runtime.getRuntime().exec("wscript " + System.getProperty("user.dir") + "/PreventScreenLock.vbs");
		} catch (Exception e) {
			logger.error("Exception while report inititation");
		}

	}

	/**
	 * Description: Launches the browser as specified in the parameter
	 * 
	 * @author:Shreya U,Vivek Dogra
	 * @param :browserName
	 */
	@Parameters({ "browserName" })
	@BeforeClass
	public synchronized void launchApp(String browserName) {
		className = getClass().getSimpleName();
		logger = LoggerFactory.getLogger(getClass().getName());
		ExtentTest parentExtentTest = ExtentHCLTest.createTest(getClass().getSimpleName());
		ExtentHCLManager.setParentReport(parentExtentTest);

		driver = CreateDriver.getInstance().launchBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		WebActionUtil = new WebActionUtil(driver, ETO);
		driver.manage().window().maximize();

	}

	/**
	 * Description: Closes the browser
	 * 
	 * @author:Shreya U
	 */
	@AfterClass
	public synchronized void closeBrowser() {

		try {
			if (driver != null) {

				driver.quit();

			} else {
				logger.error("Unable to close the driver");
			}
		} catch (Exception e) {

		}

	}

	/**
	 * Description: Kills the driver in Task Manager as specified in the parameter.
	 * 
	 * @author:Shreya U
	 * @param :browserName
	 */
	@AfterSuite
	@Parameters({ "browserName" })
	public synchronized void killTask(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} else if (browserName.equalsIgnoreCase("firefox")) {

				Runtime.getRuntime().exec("taskkill /IM firefox.exe /F");
			} else if (browserName.equalsIgnoreCase("edge")) {

				Runtime.getRuntime().exec("taskkill /F /IM MicrosoftEdgeCP.exe");
			} else {
				logger.error("Browser name not specified properly to kill the task");
			}

		} catch (IOException e) {

		}
	}

	/**
	 * Description: Creates nodes for the test methods in Extent report. =
	 * 
	 * @author:Shreya U
	 * @param: methodName
	 */
	@BeforeMethod
	@Parameters({ "browserName" })
	public synchronized void setExtentReport(String browserName, Method methodName) {

		this.testCaseName = methodName.getName();
	
		String description = methodName.getAnnotation(Test.class).description();
		ExtentTest testReport = ExtentHCLManager.getParentReport().createNode(testCaseName, description);
		ExtentHCLManager.setTestReport(testReport);

		if (driver.getWindowHandles().size() > 0) {
			WebActionUtil.validationinfo(browserName + " Browser is launched", "blue");
			WebActionUtil.info(browserName + " Browser is launched");
		} else {
			WebActionUtil.fail("Failed to launch the Browser");
			WebActionUtil.error("Failed to launch the Browser");
		}
		String appurl = prop.getProperty("App_URL");
		driver.get(appurl);
	}
}
