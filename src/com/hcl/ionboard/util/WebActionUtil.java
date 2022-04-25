package com.hcl.ionboard.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.commonutil.ExcelUtil;
import com.hcl.ionboard.reports.ExtentHCLManager;
import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * Description: All the action utilities added in this class e.g
 * clickonelement,WaitforElement etc
 * 
 * @author : Shreya U ,Vivek Dogra,Aatish Slatia
 */

public class WebActionUtil {
	public WebDriver driver;
	WebDriverWait wait;
	public long ETO;
	public JavascriptExecutor jsExecutor;
	public Actions action;
	public static TakesScreenshot screenshot;
	public String mainWindowID;

	public WebActionUtil(WebDriver driver, long ETO) {
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		screenshot = (TakesScreenshot) driver;
	}

	/**
	 * 
	 * Description Method for the info updation in extent Report Report
	 * 
	 * @author Shreya Ugavekar
	 */

	public void pass(String message) {
		ExtentHCLManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * Description Method to provide info in the log,extent reports,testNg reports
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */
	public static void info(String message) {
		BaseTest.logger.info(message);

	}

	/**
	 * Description Method to provide info in the extent report
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */
	public void extentinfo(String message) {
		ExtentHCLManager.getTestReport().info(message);

	}

	/**
	 * 
	 * Description Method for the Warning updation in extent Report,Log file,TestNG
	 * Report
	 * 
	 * @author Shreya Ugavekar
	 */

	public void warn(String message) {

		BaseTest.logger.warn(message);
		Reporter.log(message);
	}

	/**
	 * 
	 * Description Method for the error/errorure updation in extent Report
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public static void fail(String message) {
		Reporter.log(message);
		ExtentHCLManager.getTestReport().error(MarkupHelper.createLabel(message, ExtentColor.RED));

	}

	/**
	 * 
	 * Description Method for the error/errorure updation in extent Report
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public static void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))

			ExtentHCLManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			ExtentHCLManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			ExtentHCLManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void error(String message) {

		BaseTest.logger.error(message);
		Reporter.log(message);

	}

	/**
	 * 
	 * Description Method for fetching of get Current Date Time
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * 
	 * Description Method for copy pasting
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public synchronized void copyPaste(WebElement element, String elementName, String claimTypeExcelFilepath,
			String dataSheetName, String strQuery, String downloadedDocumentName) throws FilloException {

		String userDir = System.getProperty("user.home");
		String newFilewithPath = userDir + "/Downloads/" + downloadedDocumentName;
		String downloadedSheetName = ExcelUtil.getSheetName(newFilewithPath);
		String[] headerValues = ExcelUtil.getGIMRowData(newFilewithPath, downloadedSheetName, 0);

		String dataFilewithPath = claimTypeExcelFilepath;
		int noOfDataRows = ExcelUtil.getRowCount(dataFilewithPath, dataSheetName);
		String[][] dataRows = new String[2][];
		dataRows[0] = headerValues;

		/*
		 * for(int i=0;i<noOfDataRows;i++) {
		 * dataRows[i+1]=ExcelUtil.getGIMRowData(dataFilewithPath, dataSheetName, i+1);
		 * 
		 * }
		 */

		// String strQuery = "SELECT * from " + dataSheetName + " WHERE EmployeeCode='"
		// + employeecode + "'";

		String employeedata[][] = ExcelUtil.getRowDataFromExcelUsingFillo(claimTypeExcelFilepath, strQuery);

		dataRows[1] = employeedata[0];

		String data = ExcelUtil.convertArrayToFormattedString(dataRows);
		ExcelUtil.writeToTextFile("./data/resources/temp.txt", data);

		ProcessBuilder pb = new ProcessBuilder("notepad.exe", "./data/resources/temp.txt");

		try {
			pb.start();
			Runtime.getRuntime().exec("./data/resources/copyContent.exe");
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("taskkill /F /IM Notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		actionMouseOver(element, elementName);
		element.sendKeys(Keys.CONTROL + "v");
		extentinfo(Arrays.toString(dataRows[1]) + " data is pasted");
	}

	/**
	 * Description Validate the Text partially
	 * 
	 * @author Sajal jain
	 * @param expected
	 * @param element
	 * @param elementname
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validatePartialText(String expected, WebElement element, String elementname,
			String validationPassMessage, String validationFailMessage, String color) {
		String actual = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actual = element.getText();
			Assert.assertTrue(actual.contains(expected));
			info("Expected text : " + expected + " is present in : " + actual + " text in the application");
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (Exception e) {
			error("Expected text : " + expected + " is not present in : " + actual + " text in the application ");
			error(validationFailMessage);
			fail(validationFailMessage);
		}
	}

	/**
	 * 
	 * Description Method for fetching downloaded file name
	 * 
	 * @author Shreya Ugavekar
	 * @param downloadDir
	 * @param fileExtension
	 * @return downloadedFileName
	 */

	public static synchronized String getDownloadedDocumentName(String downloadDir, String fileExtension) {
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;

		// default timeout in seconds
		long timeOut = 30;
		try {
			Path downloadFolderPath = Paths.get(downloadDir);
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do {
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut, TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis() - startTime) / 1000;
				if (currentTime > timeOut) {
					info("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}

				for (WatchEvent event : watchKey.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						String fileName = event.context().toString();
						info("New File Created:" + fileName);
						if (fileName.endsWith(fileExtension)) {
							downloadedFileName = fileName;
							info("Downloaded file found with extension " + fileExtension + ". File name is " +

									fileName);
							Thread.sleep(500);
							found = true;
							break;
						}
					}
				}
				if (found) {
					return downloadedFileName;
				} else {
					currentTime = (System.currentTimeMillis() - startTime) / 1000;
					if (currentTime > timeOut) {
						info("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		}

		catch (InterruptedException e) {
			error("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			error("Download operation timed out.. Expected file was not downloaded");
		} catch (Exception e) {
			error("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}

	/**
	 * 
	 * Description Method clicks on web element
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public synchronized void clickOnElement(WebElement element, String elementName, String message) {

		if (isElementClickable(element, elementName)) {
			element.click();
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} else {
			error(message);
			fail(message);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}

	}

	/**
	 * 
	 * Description Check whether the Element is displayed with expected conditions
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementClickable(WebElement element, String elementName) {

		info("Validate " + elementName + " is clickable");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			error(elementName + " is not clickable");
			return false;
		}
	}

	/**
	 * 
	 * Description Wait for the Element is displayed with expected conditions
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void waitForElement(WebElement element, String elementName) {
		try {
			info("Wait for " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);

		} catch (Exception e) {
			error(elementName + " is not visible");

		}
	}

	/**
	 * 
	 * Description Method to delete the directory
	 * 
	 * @author Shreya Ugavekar
	 * @param pathToDeleteFolder
	 */
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * 
	 * Description Method to delete folder directory
	 * 
	 * @author Shreya Ugavekar
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}

		}
		folderToDelete.delete();
	}

	/**
	 * Description Capture the screenshot of the complete screen
	 * 
	 * @author Shreya Ugavekar
	 * @param path
	 * @return destinationPath
	 */
	public static String getScreenShot(String path) {

		File src = (screenshot.getScreenshotAs(OutputType.FILE));
		String currentDateTime=getCurrentDateTime();
		String destinationPath = path + BaseTest.className+"-"+currentDateTime + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "./Screenshots/"+BaseTest.className+"-"+currentDateTime+".png";
//		return destinationPath;
	}
	/**
	 * Description To Enter the Text to the Text filed
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public synchronized void typeText(WebElement element, String value, String elementName) {
		try {
			info("Enter the value into " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(value);
			info(value + " typed into " + elementName);
		} catch (AssertionError error) {
			error(" Unable to type " + value + " into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		} catch (Exception e) {
			error(" Unable to type " + value + "into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		}
	}

	/**
	 * Description To Select the value by the Visible Text
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param value
	 */
	public synchronized void selectByText(WebElement element, String value) {
		try {
			info("Select the value " + value);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select selecvalue = new Select(element);
			selecvalue.selectByVisibleText(value);
			info(value +" is selected");
			extentinfo(value +" is selected");
		} catch (Exception e) {
			error("Unable to select the value : " + value);
			fail("Unable to select the value : " + value);
			Assert.fail("Unable to select the value : " + value);
		}

	}

	/**
	 * Description Click on the check box
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBox(WebElement element, String elementname) {

		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isSelected()) {
			info(elementname + " selected by default");
			extentinfo(elementname + " selected by default");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			info(elementname + " is selected");
			extentinfo(elementname + " is selected");
		}
	}

	/**
	 * Description Scroll to the Element
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void scrollToElement(WebElement element, String elementName) {
		info("Scroll till the " + elementName);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			info("Scroll till the " + elementName + " completed");
		} catch (Exception e) {
			error("Scroll till the " + elementName + " failed");
		}
	}

	/**
	 * Description Scroll up
	 * 
	 * @author Shreya Ugavekar
	 */
	public synchronized void scrollUp() {

		try {
			jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight , 0)");
			info("Scroll up");
		} catch (Exception e) {
			error("Scroll up failed");
		}

	}

	/**
	 * Description Scroll to the bottom
	 * 
	 * @author Sajal jain
	 */
	public synchronized void scrollDown() {

		try {
			jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}

	}
	/**
	 * Description Click on the Element using JavaSCript
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void clickOnElementUsingJS(WebElement element, String elementName) {
		try {
			if (isElementClickable(element, elementName)) {
				jsExecutor.executeScript("arguments[0].click();", element);
				info("Clicked on : " + elementName);
				extentinfo("Clicked on : " + elementName);
			}
		} catch (NoSuchElementException e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

//	/**
//	 * Description Double Click On Element
//	 * 
//	 * @author Shreya Ugavekar
//	 * @param element
//	 * @param elementName
//	 */
//	public void doubleClickOnElement(WebElement element, String elementName) {
//		try {
//			wait.until(ExpectedConditions.visibilityOf(element));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			action.doubleClick(element).perform();
//			info("Double clicked on : " + elementName);
//			extentinfo("Double clicked on : " + elementName);
//		} catch (Exception e) {
//			error("Unable to double click on " + elementName);
//			fail("Unable to double click on " + elementName);
//			Assert.fail("Unable to double click on " + elementName);
//		}
//	}

	/**
	 * Description Clear the Text
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void clearText(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			info("Clear the text present in" + elementName);
		} catch (Exception e) {
			error("Unable to clear the text in " + elementName);
		}
	}

	/**
	 * Description To create the duration of the Test Run
	 * 
	 * @author Aatish Slathia
	 * @param millis
	 */
	public static String formatDuration(final long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);

		StringBuilder b = new StringBuilder();
		b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) : String.valueOf(hours));
		b.append(":");
		b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : String.valueOf(minutes));
		b.append(":");
		b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) : String.valueOf(seconds));
		return b.toString();
	}

	/**
	 * Description Wait for the angular page to load
	 * 
	 * @author Aatish Slathia
	 */
	public synchronized void waitForAngularPageToLoad() {
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return Boolean.valueOf(((JavascriptExecutor) driver)
							.executeScript("return (window.angular !== undefined) "
									+ "&& (angular.element(document).injector() !== undefined) "
									+ "&& (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
							.toString());
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
			
		}
	}

	/**
	 * Description Validate the Text
	 * 
	 * @author Aatish Slathia
	 * @param expected
	 * @param element
	 * @param elementname
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validatetext(String expected, WebElement element, String elementname,
			String validationPassMessage, String validationFailMessage, String color) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String actual = element.getText();
		try {
			Assert.assertEquals(actual, expected);
			info("Expected text : " + expected + " is matching with the : " + actual + " text in the application ");
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (Exception e) {
			error("Expected text : " + expected + " is not  matching with the : " + actual
					+ " text in the application ");
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * Description :Checks whether an element is visible
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */
	public synchronized boolean isElementVisible(WebElement element, String elemantName) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elemantName + " is visible");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Description :File upload by using the image path
	 * 
	 * @author Shreya Ugavekar
	 * @param imagePath
	 * 
	 */
	public synchronized void upload(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description Click on element using action class
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */
	public synchronized void actionClick(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.click(element).build().perform();
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} catch (Exception e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
		}

	}

	/**
	 * Description Mouse over on an element
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */
	public synchronized void actionMouseOver(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).build().perform();
			info("Able to mouse over on " + elementName);
			extentinfo("Able to mouse over on " + elementName);
		} catch (Exception e) {
			error("Unable to mouse over on " + elementName);
			fail("Unable to mouse over on " + elementName);
			Assert.fail("Unable to mouse over on " + elementName);
		}

	}

	/**
	 * Description Selects date from the Calendar(GIM Application) Can be used for
	 * other applications only after testing as Calendar Controls can differ
	 * 
	 * @author Aatish Slathia
	 * @param elementId
	 * @param date
	 * @param elementName
	 * 
	 */
	public synchronized void selectGIM_CalendarDate(String elementId, String date, String elementName) {
		try {
			WebActionUtil.poll(1000);
			waitForElement(driver.findElement(By.id(elementId)), elementName);
			String script = "document.getElementById('" + elementId + "').value='" + date + "'";
			jsExecutor.executeScript(script);
			info(date + " is selected");
		} catch (Exception e) {
			error("Unable to select " + date);
			Assert.fail("Unable to select " + date);

		}

	}

	/**
	 * Description Selects date from the Calendar(GIM Application) Can be used for
	 * other applications only after testing as Calendar Controls can differ
	 * 
	 * @author Aatish Slathia
	 * @param elementId
	 * @param date
	 * 
	 */
	public synchronized void selectGIM_CalendarRangeDates(String elementId, String date) {
		try {
			String script = "document.getElementById('" + elementId + "').value='" + date + "'";
			jsExecutor.executeScript(script);
			info(date + " is selected");
		} catch (Exception e) {
			error("Unable to select " + date);
			Assert.fail("Unable to select " + date);
		}

	}

	/**
	 * Description Selects range date from the given from & to date
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */

	public synchronized void selectCalendarRangeDate(WebElement calendarOpen, String fromYear, String fromMonth,
			String fromDate, String toYear, String toMonth, String toDate) {

		List<WebElement> lstMonthSelect = calendarOpen.findElements(By.xpath("//select[@class='monthselect']"));

		List<WebElement> lstYearSelect = calendarOpen.findElements(By.xpath("//select[@class='yearselect']"));

		Select fromMonthSelect = new Select(lstMonthSelect.get(0));
		Select toMonthSelect = new Select(lstMonthSelect.get(1));

		Select fromYearSelect = new Select(lstYearSelect.get(0));
		Select toYearSelect = new Select(lstYearSelect.get(1));

		fromYearSelect.selectByVisibleText(fromYear);
		fromMonthSelect.selectByVisibleText(fromMonth);

		String fromDatePath = "//div[@class='drp-calendar left']/descendant::td[text()='" + fromDate + "']";
		calendarOpen.findElement(By.xpath(fromDatePath)).click();

		toYearSelect.selectByVisibleText(toYear);
		toMonthSelect.selectByVisibleText(toMonth);
		String toDatePath = "//div[@class='drp-calendar right']/descendant::td[text()='" + toDate + "']";
		calendarOpen.findElement(By.xpath(toDatePath)).click();

	}

	/**
	 * Description Get login credentials using fillo
	 * 
	 * @author Manish Kumar C D
	 * @param empcode
	 * @return loginDataWithRole
	 */
	public synchronized Map<String, String> getLoginDetailsForAllRoles(String empCode) {

		String xlpath = System.getProperty("user.dir") + "/data/GIMTestData_OtherFlows.xlsx";
		String[] loginData = new String[1];

		String strQuery = "SELECT * from LoginCredentials WHERE EmpCode='" + empCode + "'";

		String employeedata[][] = null;
		try {
			employeedata = ExcelUtil.getRowDataFromExcelUsingFillo(xlpath, strQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String headers[] = ExcelUtil.getGIMRowData(xlpath, "LoginCredentials", 0);

		loginData = employeedata[0];

		Map<String, String> loginDataWithRole = new LinkedHashMap<String, String>();
		if (loginData.length == headers.length) {
			for (int i = 0; i < loginData.length; i++) {
				loginDataWithRole.put(headers[i], loginData[i]);
			}
		}
		return loginDataWithRole;

	}

	/**
	 * Description Get login credentials for Child Education Allwoance using fillo
	 * 
	 * @author Manish Kumar C D
	 * @param empcode
	 * @return loginDataWithRole
	 */
	public synchronized Map<String, String> getLoginDetailsForCEA(String empCode) {

		String xlpath = System.getProperty("user.dir") + "/data/GIMTestData_OtherFlows.xlsx";
		String[] loginData = new String[1];

		String strQuery = "SELECT * from LoginCredentials_CEA WHERE EmpCode='" + empCode + "'";

		String employeedata[][] = null;
		try {
			employeedata = ExcelUtil.getRowDataFromExcelUsingFillo(xlpath, strQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String headers[] = ExcelUtil.getGIMRowData(xlpath, "LoginCredentials_CEA", 0);

		loginData = employeedata[0];

		Map<String, String> loginDataWithRole = new LinkedHashMap<String, String>();
		if (loginData.length == headers.length) {
			for (int i = 0; i < loginData.length; i++) {
				loginDataWithRole.put(headers[i], loginData[i]);
			}
		}
		return loginDataWithRole;

	}

	/**
	 * 
	 * Description : Wait for given time
	 * 
	 * @author Abhilash B
	 * @param millis
	 */
	public synchronized static void poll(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Description Check whether the Element is displayed with expected conditions
	 * 
	 * @author Abhilash B
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementDisplayed(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
		}
	}

	/**
	 * 
	 * Description : Verify the attribute value of an element
	 * 
	 * @author Abhilash B
	 * @param element
	 * @param attribute
	 * @param valuetobecompared
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateAttribute(WebElement element, String attribute, String valuetobecompared,
			String elementName, String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			wait.until(ExpectedConditions.attributeContains(element, attribute, valuetobecompared));
			Assert.assertEquals(element.getAttribute(attribute), valuetobecompared);
			info("Expected attribute value : " + valuetobecompared + " is matching with the actual attribute value : "
					+ actualvalue + " of " + elementName);
			info(validationPassMessage);
			// validationinfo(validationPassMessage, color);
			extentinfo(validationPassMessage);
		} catch (Exception e) {
			error("Expected attribute value : " + valuetobecompared
					+ " is not matching with the actual attribute value : " + actualvalue + " of " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * 
	 * Description : Wait for the angular page load
	 * 
	 * @author Abhilash B
	 */
	public synchronized void waitForAngularPageload() {
		// JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		NgWebDriver ngDriver = new NgWebDriver(jsExecutor);
		ngDriver.waitForAngularRequestsToFinish();
	}

	/**
	 * 
	 * Description : Get file path
	 * 
	 * @author Abhilash B
	 * @param fileFormat
	 * @return filePath + fileName
	 */

	public synchronized String getSampleFilePath(String fileFormat) {
		String filePath = System.getProperty("user.dir") + "\\data\\SampleFiles\\";

		String fileName = "Sample(" + fileFormat.toUpperCase() + ")." + fileFormat;

		return filePath + fileName;

	}

	/**
	 * 
	 * Description : Validate the value entered in an element
	 * 
	 * @author Abhilash B
	 * @param expectedValue
	 * @param actualvalue
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateEnteredValue(String expectedValue, String actualvalue, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {

		try {
			Assert.assertEquals(expectedValue, actualvalue);
			info("Valid value is entered in " + elementName);
			info(validationPassMessage);
			// validationinfo(validationPassMessage, color);
			extentinfo(validationPassMessage);
		} catch (Exception e) {
			error("Valid value is not entered in " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * 
	 * Description : Retrives the value entered in an element
	 * 
	 * @author Abhilash B
	 * @param elementId
	 * @return entereddValue
	 */
	public synchronized String getTextUsingJS(String elementId) {
		String entereddValue = null;
		try {
			poll(1000);
			String script = "return document.getElementById('" + elementId + "').value";
			entereddValue = (String) (jsExecutor.executeScript(script));
			// info("The value entered in element is " + entereddValue);
		} catch (Exception e) {
			error("Unable to get entered value from element with id " + elementId);
		}
		return entereddValue;
	}

	/**
	 * 
	 * Description : Validate the download format
	 * 
	 * @author Abhilash B
	 * @param downloadedDocumentName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateDownload(String downloadedDocumentName, String validationPassMessage,
			String validationFailMessage, String color) {
		String userDir = System.getProperty("user.home");

		File file = new File(userDir + "/Downloads/" + downloadedDocumentName);

		if (file.exists()) {
			info("Downloaded document name is " + downloadedDocumentName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} else {

			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail("Unable to validate downloaded document");
		}

	}

	/**
	 * 
	 * Description : Validate the document download
	 * 
	 * @author Abhilash B
	 * @param downloadedDocumentName
	 */
	public synchronized void validateDownloadedDocument(String downloadedDocumentName) {
//		WebActionUtil.validateDownload(downloadedDocumentName,claimType+" allowance form Template is successfully downloaded",
//				claimType+" allowance form Template is not downloaded", "green");
		validateDownload(downloadedDocumentName,
				"Template with Filename " + downloadedDocumentName + " downloaded successfully",
				"Template could not be downloaded", "blue");

	}

	/**
	 * Description :Retrieves text of the webelement
	 * 
	 * @author Shreya u
	 * @param element
	 * @param elementName
	 * 
	 */
	public synchronized String getText(WebElement element, String elementName) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elementName + " is visible");
			String text = element.getText();
			info("Retrieved the text of the element " + elementName);
			return text;
		} catch (Exception e) {
			error("Failed to retrieve the text of the element " + elementName);
			return null;
		}
	}

	/**
	 * Description :Compares text of the webelement
	 * 
	 * @author Shreya u
	 * @param actual
	 * @param expected
	 * @param color
	 * 
	 */
	public synchronized void comparetText(String actual, String expected, String color) {

		try {
			Assert.assertEquals(actual, expected);
			info(actual + " data is entered");
			validationinfo(actual + " data is entered",color);

		} catch (Exception e) {
			error(expected + " data is not entered");
			fail(expected + " data is not entered");
		}
	}

	/**
	 * Description :Retrieves text of the Web element
	 * 
	 * @author Shreya u
	 * @param element
	 * @param color
	 * 
	 */
	public synchronized String getTextusingJSWithXpath(WebElement element, String color) {

		String entereddValue = null;
		try {
			poll(2000);
			entereddValue = (String) (jsExecutor.executeScript("return arguments[0].value", element));
			info("The value entered in element is" + entereddValue);
		} catch (Exception e) {
			error("Unable to entered value using JS with xpath");
		}
		return entereddValue;
	}

	/**
	 * Description :Retrieves text of the web element
	 * 
	 * @author Shreya u
	 * @param element
	 * @param attribute
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 * 
	 */
	public synchronized void validateAttributeIsEmpty(WebElement element, String attribute, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			if (actualvalue.isEmpty()) {
				// validationinfo(validationPassMessage, color);
				info(validationPassMessage);
				extentinfo(validationPassMessage);
			} else {
				error(validationFailMessage);
				fail(validationFailMessage);
			}
		} catch (Exception e) {
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * 
	 * Description Method to write and upload excel
	 * 
	 * @author Abhilash
	 * @param element
	 * @param elementName
	 * @param data
	 * @param downloadedDocumentName
	 */

	public synchronized void writeAndUploadExcel(WebElement element, String elementName, Map<String, String> data,
			String downloadedDocumentName) {

		String userDir = System.getProperty("user.home");
		// String downloadedDocumentName = getDownloadedDocumentName(userDir +
		// "/Downloads", ".xlsx");
		String[] downloadedDocumentNameSplit = downloadedDocumentName.split("[.]");
		String documentNameForUpLoad = downloadedDocumentNameSplit[0] + "_1" + ".xlsx";

		String downLoadedFilePath = userDir + "\\Downloads\\" + downloadedDocumentName;
		String downloadedSheetName = ExcelUtil.getSheetName(downLoadedFilePath);

		String newFilewithPath = userDir + "\\Downloads\\" + documentNameForUpLoad;

		try {
			ExcelUtil.writeSingleRowDataToExcel(downLoadedFilePath, downloadedSheetName, data);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ExcelUtil.updateExcelFileDateCellFormatUsingVbs(userDir + "\\Downloads", downloadedDocumentName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		waitForElement(element, elementName);
		clickOnElement(element, elementName, "failed to click on " + elementName);
		upload(newFilewithPath);
		extentinfo(new ArrayList<String>(data.keySet()) + " data is present in uploaded excel file");
		validationinfo("Excel file is uploaded and " + documentNameForUpLoad + " is displayed on the page", "blue");

	}

	/**
	 * Description fetched all the login details from GimTestData_OtherFlows.xlsx
	 * for Flows other than Child Education. It takes claim type as argument and
	 * return data as a Map
	 * 
	 * @author Manish Kumar C D
	 * @param claimType
	 */
	public synchronized Map<String, String[]> getLoginDetailsForAllRolesByClaimType(String claimType) {

		String xlpath = System.getProperty("user.dir") + "/data/GimTestData_OtherFlows.xlsx";
		String[] loginData = new String[1];

		String strQuery = "SELECT * from LoginCredentials WHERE ClaimType='" + claimType + "'";

		String employeedata[][] = null;
		try {
			employeedata = ExcelUtil.getRowDataFromExcelUsingFillo(xlpath, strQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		Map<String, String[]> mapLoginDetails = new HashMap<>();

		for (String[] singleEmpData : employeedata) {
			mapLoginDetails.put(singleEmpData[1], new String[] { singleEmpData[2], singleEmpData[3] });
		}

		return mapLoginDetails;
	}

	/**
	 * 
	 * Description : get file Name
	 * 
	 * @author Vivek Dogra
	 * @param fileFormat
	 * @return fileName
	 */

	public synchronized String getSampleFileName(String fileFormat) {
		String fileName = "Sample" + fileFormat.toUpperCase() + "." + fileFormat;
		return fileName;

	}

	/**
	 * 
	 * Description Method for copy pasting
	 * 
	 * @author Shreya Ugavekar
	 * 
	 */

	public synchronized void copyPastemultiplerows(WebElement element, String elementName,
			String claimTypeExcelFilepath, String dataSheetName, String[] employeecodes, String downloadedDocumentName)
			throws FilloException {

		String userDir = System.getProperty("user.home");

		String newFilewithPath = userDir + "/Downloads/" + downloadedDocumentName;
		String downloadedSheetName = ExcelUtil.getSheetName(newFilewithPath);
		String[] headerValues = ExcelUtil.getGIMRowData(newFilewithPath, downloadedSheetName, 0);

		String dataFilewithPath = claimTypeExcelFilepath;
		int noOfDataRows = ExcelUtil.getRowCount(dataFilewithPath, dataSheetName);
		String[][] dataRows = new String[employeecodes.length + 1][];
		dataRows[0] = headerValues;

		String strSelectFieldNames = generateQueryByHeaders(claimTypeExcelFilepath, dataSheetName);

		for (int i = 0; i < employeecodes.length; i++) {

			String strQuery = strSelectFieldNames + dataSheetName + " WHERE EmployeeCode='" + employeecodes[i] + "'";
			String employeedata[][] = ExcelUtil.getRowDataFromExcelUsingFillo(claimTypeExcelFilepath, strQuery);
			dataRows[i + 1] = employeedata[0];
		}

		String data = ExcelUtil.convertArrayToFormattedString(dataRows);
		ExcelUtil.writeToTextFile("./data/resources/temp.txt", data);
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", "./data/resources/temp.txt");

		try {
			pb.start();
			Runtime.getRuntime().exec("./data/resources/copyContent.exe");
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("taskkill /F /IM Notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		actionMouseOver(element, elementName);
		element.sendKeys(Keys.CONTROL + "v");
		for (int i = 0; i < employeecodes.length; i++) {
			extentinfo(Arrays.toString(dataRows[i + 1]) + " data is pasted");
		}
	}

	/**
	 * 
	 * Description Method to generate querry
	 * 
	 * @author Abhilash
	 * @param excelPath
	 * @param sheetName
	 */
	public synchronized String generateQueryByHeaders(String excelPath, String sheetName) {
		String[] headerValues = ExcelUtil.getGIMRowData(excelPath, sheetName, 0);
		String query = "Select ";
		for (int i = 1; i < headerValues.length - 1; i++) {
			query = query + headerValues[i] + ",";

		}
		query = query + headerValues[headerValues.length - 1];
		query = query + " from ";
		return query;

	}

	/**
	 * Description Verifies the Page Title
	 * 
	 * @author Manish Kumar C D
	 * @param expected
	 * @param elementname
	 * 
	 */
	public synchronized void validatePageTitle(String expectedTitle, String elementname) {
		try {
			info("Getting text from " + elementname);
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
		} catch (Exception e) {
			fail("Failed to verify the text partially of " + elementname);
		}
	}

	/**
	 * Description Wait for the load by checking readystate using JavascriptExecutor
	 * 
	 * @author Aatish Slathia
	 */
	public synchronized void waiForPageLoadJS(WebDriver driver, int timeInSecs) {
		new WebDriverWait(driver, timeInSecs).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 * 
	 * Description : Verify the attribute value of an element
	 * 
	 * @author Abhilash B
	 * @param element
	 * @param attribute
	 * @param valuetobecompared
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateAttribute1(WebElement element, String attribute, String valuetobecompared,
			String elementName, String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			wait.until(ExpectedConditions.attributeContains(element, attribute, valuetobecompared));
			Assert.assertEquals(element.getAttribute(attribute), valuetobecompared);
			info("Expected attribute value : " + valuetobecompared + " is matching with the actual attribute value : "
					+ actualvalue + " of " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} catch (Exception e) {
			error("Expected attribute value : " + valuetobecompared
					+ " is not matching with the actual attribute value : " + actualvalue + " of " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * 
	 * Description : Validate the value entered in an element
	 * 
	 * @author Abhilash B
	 * @param expectedValue
	 * @param actualvalue
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateEnteredValue1(String expectedValue, String actualvalue, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {

		try {
			Assert.assertEquals(expectedValue, actualvalue);
			info("Valid value is entered in " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} catch (Exception e) {
			error("Valid value is not entered in " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
		}

	}

	/**
	 * 
	 * Description Check whether the Element is Enabled
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementEnabled(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isEnabled());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
		}
	}

	/**
	 * 
	 * Description Method to return data for excel upload
	 * 
	 * @author Sajal
	 * @param data
	 * @param format
	 */
	public synchronized Map<String, String> getData_FormatMap(String[] data, String[] format) {
		Map<String, String> mapDataAndFormat = new LinkedHashMap<String, String>();
		for (int i = 0; i < data.length; i++) {
			mapDataAndFormat.put(data[i], format[i]);
		}
		return mapDataAndFormat;
	}
	
	
	/**
	 * 
	 * Description Check whether the Element is selected with expected conditions
	 * 
	 * @author Abhilash B
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementSelected(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {

		try {
		//	wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isSelected());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
		}
	}
	
	
	/**
	 * Description select date
	 * 
	 * @author Shreya Ugavekar
	 * @param labelXpath
	 * @param inputxpath
	 * @param date
	 * @param elementName
	 */
	public synchronized void selectDate(String labelXpath, String inputXpath, String date, String elementName) {
		try {
			jsExecutor.executeScript("function getElementsByXPath(xpath,parent)\r\n" + "{\r\n" + "\r\n"
					+ "let results=[];\r\n"
					+ "let query=document.evaluate(xpath,parent||document,null,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,null);\r\n"
					+ "for(let i=0,length=query.snapshotLength;i<length;i++)\r\n"
					+ "{results.push(query.snapshotItem(i));\r\n" + "}\r\n" + "return results;\r\n" + "}	\r\n"
					+ "let items=getElementsByXPath(" + labelXpath + ");\r\n" + "items[0].innerText='';\r\n"
					+ "let items=getElementsByXPath(" + inputXpath + ");\r\n" + "items[0].value=" + "\"" + date + "\"");
			info(elementName + " is selected");
			extentinfo(elementName + " is selected");
		} catch (Exception e) {
			error("Unable to select" + elementName);
			fail("Unable to select" + elementName);
			Assert.fail("Unable to select" + elementName);
		}
	}

/**
	 * 
	 * Description Method to switch driver focus to new tab/window
	 * 
	 * @author Sajal jain
	 */
	public synchronized void switchToNewTab() {
		try {
			mainWindowID = driver.getWindowHandle();
			Set<String> allWindowID = driver.getWindowHandles();
			for (String id : allWindowID) {
				if (!id.equals(mainWindowID)) {
					driver.switchTo().window(id);
				}
			}
			info("Switch to new tab");
			extentinfo("Switch to new tab");
		} catch (Exception e) {
			error("Unable to switch to new tab");
			fail("Unable to switch to new tab");
Assert.fail("Unable to switch to new tab");

		}
	}

	/**
	 * 
	 * Description Method to switch driver focus to main tab/window
	 * 
	 * @author Sajal jain
	 */
	public synchronized void switchToMainTab() {
		try {
			driver.switchTo().window(mainWindowID);
			info("Switch to main tab");
			extentinfo("Switch to main tab");
		} catch (Exception e) {
			error("Unable to switch to main tab");
			fail("Unable to switch to main tab");
Assert.fail("Unable to switch to main tab");
		}
	}

	/**
	 * 
	 * Description Wait for invisibility of element
	 * 
	 * @author Sajal jain
	 * @param element
	 * @param elementName
	 * @param timeInSecs
	 */
	public synchronized void waitForInvisibilityOfElement(WebElement element, String elementName, Long timeoutInSecs) {
		info("Wait for invisiblity of " + elementName);
		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSecs);
		try {
		wait1.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			error(elementName + " is still visible");
		}
	}
	
	/**
	 * Description Click on the check box using JavaScript
	 * 
	 * @author Sajal jain
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBoxUsingJS(WebElement element, String elementName) {
		try {
			if (element.isSelected()) {
				info(elementName + " selected by default");
				extentinfo(elementName + " selected by default");
			} else {
				jsExecutor.executeScript("arguments[0].click();", element);
				info(elementName + " is selected");
				extentinfo(elementName + " is selected");
			}
			}catch(NoSuchElementException e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
		}
	}
	
	/**
	 * Description Double Click On Element
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElement(WebElement element, String elementName) {
		try {
			action.doubleClick(element).perform();
			info("Double clicked on : " + elementName);
			extentinfo("Double clicked on : " + elementName);
		} catch (Exception e) {
			error("Unable to double click on " + elementName);
			fail("Unable to double click on " + elementName);
			Assert.fail("Unable to double click on " + elementName);
		}
	}
	
	/**
	 * 
	 * Description Method to press Enter key
	 * 
	 * @author Shreya
	 */
	public synchronized void actionEnter()
	{
		try {
			action.sendKeys(Keys.ENTER).build().perform();
			info("Enter Key pressed");
			extentinfo("Enter Key  is pressed");
		} catch (Exception e) {
			error("Unable to press Enter Key");
			fail("Unable to press Enter Key");
			Assert.fail("Unable to press Enter Key");
		}
		
	}
	/**
	 * 
	 * Description Method to select ionboard calendar date
	 * @paramelementId
	 * @param date
	 * @param element name
	 * @author vikas
	 */
	
	public synchronized void selectIonBoard_CalendarDate(String elementId, String date, String elementName) {
		try {
			WebActionUtil.poll(1000);
			waitForElement(driver.findElement(By.id(elementId)), elementName);
			String script = "document.getElementById('" + elementId + "').value=" +"\"" +date + "\" ";
			jsExecutor.executeScript(script);
			info(date + " is selected");
		} catch (Exception e) {
			error("Unable to select " + date);
			Assert.fail("Unable to select " + date);

		}
	}
	
	/**
	 * 
	 * Description Method to retrieve single row data from Excel
	 * @param Xlpath
	 * @param sheetName
	 * @param entity
	 * @author shreya
	 */
	
	public synchronized Map<String,String> getSingleRowDataWithHeader(String xlPath, String sheetName, String entity)
	{
		Map<String,String> mapHeaderAndData =new LinkedHashMap<String, String>();
		int entityRowno = ExcelUtil.getEntityRowNo(xlPath,sheetName,entity);
		String[] headers =ExcelUtil.getGIMRowData(xlPath, sheetName, entityRowno+1);
		String[] datas =ExcelUtil.getGIMRowData(xlPath, sheetName, entityRowno+2);
		
		if(headers.length==datas.length)
		{
			for(int i=0;i<headers.length;i++)
			{
			  mapHeaderAndData.put(headers[i], datas[i]);
			}
		}
		
		return mapHeaderAndData;
	}
	
	/**
	 * 
	 * Description Method to retrieve multiple row data from Excel
	 * @param Xlpath
	 * @param sheetName
	 * @param entity
	 * @author shreya
	 */
	public synchronized Map<String,String[]> getMultipleRowsDataWithHeader(String xlPath, String sheetName, String entity)
	{
		int entityRowno = ExcelUtil.getEntityRowNo(xlPath,sheetName,entity);
		int rowcount = ExcelUtil.getEntityandDataRowCount(xlPath, sheetName,entityRowno+1);
		
		String[] headers =ExcelUtil.getGIMRowData(xlPath, sheetName, entityRowno+1);
		String[][] data = new String[rowcount-1][];
		
		//System.out.println(Arrays.toString(headers));
		int index = 0;
		for(int i =entityRowno+2;i<=entityRowno+rowcount;i++)
		{
			data[index] =ExcelUtil.getGIMRowData(xlPath, sheetName, i);
			//System.out.println(Arrays.toString(data[index]));
			index++;
		}
		
		Map<String,String[]> mapHeadersAndDatas =new LinkedHashMap<String, String[]>();
		
		if(headers.length == data[0].length)
		{
			int rows = data.length;
			int cols = data[0].length;
			
			for(int i=0;i<cols;i++)
			{ String[] colData = new String[rows];
				for(int j=0;j<rows;j++)
				{
					colData[j] =data[j][i];
					
				}
			
				
				mapHeadersAndDatas.put(headers[i], colData);
			}
			
		}
		return mapHeadersAndDatas;
	}
	
	/**
	 * Description Selects date from the Calendar(iOn Board Application) Can be used for
	 * other applications only after testing as Calendar Controls can differ
	 * 
	 * @author Aatish Slathia
	 * @param elementId
	 * @param date
	 * @param elementName
	 * 
	 */
	public synchronized void selectCalendarDate(String elementId, String date, String elementName) {
		try {
			WebActionUtil.poll(1000);
			waitForElement(driver.findElement(By.id(elementId)), elementName);
			String script = "document.getElementById('" + elementId + "').value=\""+date+"\"";
			jsExecutor.executeScript(script);
			info(date + " is selected");
		} catch (Exception e) {
			error("Unable to select " + date);
			Assert.fail("Unable to select " + date);

		}

	}
	
	/**
	 * Description Double Click On Element
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElementCheckbox(WebElement element, String elementName) {
		try {
			if (element.isSelected()) {
				action.doubleClick(element).perform();
				info("Double clicked on : " + elementName);
				extentinfo("Double clicked on : " + elementName);
			} else {
				jsExecutor.executeScript("arguments[0].click();", element);
				info(elementName + " is selected");
				extentinfo(elementName + " is selected");
			}
		} catch (Exception e) {
			error("Unable to double click on " + elementName);
			fail("Unable to double click on " + elementName);
			Assert.fail("Unable to double click on " + elementName);
		}
	}
	
	/**
	 * Description Double Click On Element Using JS
	 * 
	 * @author Shreya Ugavekar
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElementCheckboxUsingJS(WebElement element, String elementName) {
		try {
			if (element.isSelected()) {
				jsExecutor.executeScript("arguments[0].dblclick;", element);
				info("Double clicked on : " + elementName);
				extentinfo("Double clicked on : " + elementName);
			} else {
				jsExecutor.executeScript("arguments[0].click();", element);
				info(elementName + " is selected");
				extentinfo(elementName + " is selected");
			}
		} catch (Exception e) {
			error("Unable to double click on " + elementName);
			fail("Unable to double click on " + elementName);
			Assert.fail("Unable to double click on " + elementName);
		}
	}
	
	/**
	 * Description Convert string into Camel case
	 * 
	 * @author Sajal
	 * @param name
	 */
	public synchronized String convertStringToCamelCase(String name) {
		name = name.toLowerCase();
		String[] split = name.split(" ");
		String candidateName="";
		for(int i=0;i<split.length;i++) {
		candidateName = candidateName + split[i].substring(0, 1).toUpperCase() + split[i].substring(1) + " ";
		}
		return candidateName.trim();
	}
}
