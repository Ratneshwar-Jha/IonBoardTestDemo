package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for ES Page
 * @author vikas.kc
 *
 */
public class ES_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public ES_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Spinner */
	@FindBy(xpath = "//div[contains(@class,'spinner')]")
	private WebElement spinner;

	/* Menu list */
	@FindBy(xpath = "//span[@class='icon-menu3 glb-pnl-localNav-ico']")
	private WebElement menu;

	@FindBy(xpath = "//div[@class='glb-pnl-localNav-box1']")
	private List<WebElement> options;

	/* profile Drop down */
	@FindBy(xpath = "//div[@class='glb-pnl-informationDropIcon']")
	private WebElement ddProfile;

	/* Select actual date of join */
	@FindBy(id = "ActualDOJ")
	private WebElement txtActualDOJ;

	/* Reason for hiring drop down */
	@FindBy(xpath = "//label[text()='Reason For Hiring']/parent::div/select[@id='hiringReasonId']")
	private WebElement ddReasonForHiring;

	/* Remarks text field */
	@FindBy(id = "Remarks")
	private WebElement txtRemarks;

	/* validate profile drop down */
	@FindBy(xpath = "//ul[@class='glb-pnl-role-list']")
	private List<WebElement> differentRole;

	/* Submit button */
	@FindBy(id = "btn_submit")
	private WebElement btnSubmit;

	/* Sap upload success message */
	@FindBy(xpath = "//div[@id='success_model']/span")
	private WebElement txtSapUpLoadSuccessMessage;

	
	/*Search textbox*/
	@FindBy(xpath="//input[@type='search']")
	private WebElement tbSearch;
	
	/* Save button */
	@FindBy(id = "btn_save")
	private WebElement btnSave;

	/* Back button */
	@FindBy(xpath = "//span[text()='Back']")
	private WebElement btnBack;

	/* Pagination */
	@FindBy(name = "first_table_length")
	private WebElement paginate;

	/* Table header */
	@FindBy(xpath = "//table[@id='first_table']/descendant::th[contains(@class,'sorting')]")
	private List<WebElement> tableHeader;

	/* Roles */
	@FindBy(xpath = "//ul[@class='glb-pnl-role-list']/li/a")
	private List<WebElement> txtRoles;

	/* Table header */
	@FindBy(xpath = "//li[@class='active']")
	private WebElement txtESInformation;

	/* Calendar */
	@FindBy(xpath = "//div[contains(@class,'datepicker ')]/div")
	private List<WebElement> txtDatePicker;

	/* Select Role */
	public WebElement selectRole(String var) {
		String xpath = "//a[text()='" + var + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* User manual link */
	@FindBy(xpath = "//a[text()='User Manual']")
	private WebElement lnkUserManuel;

	/* Training ppt link */
	@FindBy(xpath = "//a[text()='Training PPT']")
	private WebElement lnkTrainingPPT;

	/* FQA's pdf link */
	@FindBy(xpath = "//a[contains(text(),'FAQ')]")
	private WebElement lnkFQA;
	
	/* Filter link */
	@FindBy(xpath = "//span[@class='icon-filter glb-fltr-rt-Ico filter_list']")
	private WebElement lnkFilter;
	
	/* Filter text */
	@FindBy(xpath = "//label[contains(@class,'control-label')]")
	private List<WebElement> txtFilter;
	
	/* Search button */
	@FindBy(xpath = "//span[contains(text(),'Search')]/parent::button")
	private WebElement btnSearch;
	
	/* Search button */
	@FindBy(xpath = "//span[contains(text(),'reset')]")
	private WebElement btnReset;
	
	/* Filter fields reset */
	@FindBy(xpath = "(//button/span[@class='filter-option pull-left'])[position()>1]")
	private List<WebElement> txtReset;

	/* Country  */
	@FindBy(xpath = "//button[@data-id='CountryId']")
	private WebElement txtCountry;
	
	/* Band  */
	@FindBy(xpath = "//button[@data-id='empBandId']")
	private WebElement txtBand;
	
	/* LocationId  */
	@FindBy(xpath = "//button[@data-id='LocationId']")
	private WebElement txtLocationId;
	
	/* BgvStatusCode  */
	@FindBy(xpath = "//button[@data-id='BgvStatusCode']")
	private WebElement txtBgvStatusCode;
	
	/* Joining Form Status Code */
	@FindBy(xpath = "//button[@data-id='joiningFormStatusCode']")
	private WebElement txtjoiningFormStatusCode;
	
	/* Employee Type  */
	@FindBy(xpath = "//button[@data-id='employeeTypeCode']")
	private WebElement txtemployeeTypeCode;
	
	/* Joining Date From  */
	@FindBy(id = "datepicker1")
	private WebElement txtJoiningDateFrom;
	
	/* Joining Date To  */
	@FindBy(id = "datepicker2")
	private WebElement txtJoiningDateTo;
	
	/* Candidate Name text field  */
	@FindBy(id = "canName")
	private WebElement txtCandidateName;
	
	/* SAP ID text field  */
	@FindBy(id = "sapID")
	private WebElement txtSapID;
	
	/* Dashboard triangle */
	@FindBy(xpath = "//div[@class='btn btn-cus pull-right rotate']/i")
	private WebElement txtDashboardTriangle;
	
	/* Candidate name text */
	@FindBy(xpath = "//table[@id='first_table']//td[2]/a")
	private WebElement txtJoiningConsoleCandidateName;
	
	/* Home link */
	@FindBy(id = "homelink")
	private WebElement lnkHome;

	/* iOnboard-Joining Report link */
	@FindBy(xpath = "//a[text()='iOnboard-Joining Report']")
	public WebElement lnkiOnboardJoiningReport;

	/* Lateral-Complete Report link */
	@FindBy(xpath = "//a[text()='Lateral-Complete Report']")
	private WebElement lnkLateralCompleteReport;

	/* Lateral-InComplete Report link */
	@FindBy(xpath = "//a[text()='Lateral-InComplete Report']")
	private WebElement lnkLateralInCompleteReport;

	/* Transfer-Complete Report link */
	@FindBy(xpath = "//a[text()='Transfer-Complete Report']")
	private WebElement lnkTransferCompleteReport;

	/* iOnboard-Joining Report page */
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement txtiOnboardJoining;

	/* Home menu options link */
	private synchronized WebElement menuOptions(String optionName)
	{
		return driver.findElement(By.xpath("//a[text()='"+optionName+"']"));

	}
	
	/**
	 * Description: Method to click on action link
	 * @author vikas.kc
	 * 
	 * @param candidateEmailID
	 */
	public synchronized void clkAction(String candidateEmailID)
	{
		try {
			
			WebElement action = driver.findElement(By.xpath("//table[@id='first_table']/descendant::td[contains(text(),'"+candidateEmailID+"')]/following-sibling::td/a/i[contains(@class,'icon-edit')]"));
			WebActionUtil.waitForElement(action, "Action link");
			WebActionUtil.clickOnElement(action, "Action link", "Unable to click Action link");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Action link");
			Assert.fail("Unable to click Action link");
		}
	}
	
	
	/**
	 * Description: Method to click on Search bar
	 * @author vikas.kc
	 * 
	 * @param candidateId
	 */
	public synchronized void clkSearchBar(String candidateId) {
		try {
			
			WebActionUtil.waitForElement(tbSearch, "Search Name textbox");
			WebActionUtil.scrollToElement(tbSearch, "Search Name textbox");
			WebActionUtil.typeText(tbSearch, candidateId, "Search Name textbox");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to Click on Search button");
			Assert.fail("Unable to Click on Search button");
		}
	} 
	
	/**
	 * Description: Method to validate ES/HR status
	 * @author vikas.kc
	 * 
	 * @param candidateEmailID
	 */
	public synchronized void validateESStatus(String candidateEmailID)
	{
		try {
			
			WebActionUtil.waitForAngularPageToLoad();
			clkSearchBar(candidateEmailID);
			WebElement esStatus = driver.findElement(By.xpath("//table[@id='first_table']/descendant::td[contains(text(),'"+candidateEmailID+"')]/following-sibling::td[9]/i"));
			WebActionUtil.waitForElement(esStatus,"Es Status Colour");
			Assert.assertEquals(esStatus.getAttribute("class"), "indicate ind-amber");
			WebActionUtil.pass("Colour of ES/HR Status: Amber colour is displayed");
			WebActionUtil.actionMouseOver(esStatus, "ES Status");	
			//WebElement sapidGeneration = driver.findElement(By.xpath("(//table[@id='first_table']/descendant::td[contains(text(),'"+candidateEmailID+"')]/following-sibling::td/i)[4]/ancestor::div[6]/parent::main/following::div[@role='tooltip']/div[@class='tooltip-inner']"));
			WebElement sapidGeneration=driver.findElement(By.xpath("//table[@id='first_table']/descendant::td[contains(text(),'"+candidateEmailID+"')]/ancestor::main/following-sibling::div[@class='tooltip fade top in']/div[@class='tooltip-inner']"));
			WebActionUtil.waitForElement(sapidGeneration, "SapIdGeneration Tooltip");
			Assert.assertEquals(sapidGeneration.getText(), "SAP ID Generation Pending");
			WebActionUtil.info("ES/HR Status: "+ esStatus.getAttribute("data-original-title") +" is displayed");
			WebActionUtil.pass("ES/HR Status: "+ esStatus.getAttribute("data-original-title") +" is displayed");


		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES/HR Status: Amber colour is not displayed");
			Assert.fail("ES/HR Status: Amber colour is not displayed");
		}
	}

	/**
	 * Description: Method to validate Recruiter Action Status
	 * @author vikas.kc
	 * 
	 * @param candidateEmailID
	 */
	public synchronized void validateRecruiterActionStatus(String candidateEmailID)
	{
		try {
			WebElement recruiterActionStatus = driver.findElement(By.xpath("(//table[@id='first_table']/descendant::td[contains(text(),'"+candidateEmailID+"')]/following-sibling::td/i)[2]"));

			Assert.assertEquals(recruiterActionStatus.getAttribute("class"), "indicate ind-green");
			WebActionUtil.info("Recruiter Action Status: Green colour is displayed");
			WebActionUtil.pass("Recruiter Action Status: Green colour is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Recruiter Action Status: Green colour is not displayed");
			Assert.fail("Recruiter Action Status Green: colour is not displayed");
		}

	}

	/**
	 * Description: Method to validate Fields
	 * @author vikas.kc
	 */
	public synchronized void validateFields()
	{
		try {
			List<String> actualFields = new ArrayList<String>();

			WebActionUtil.poll(2000);
			for(WebElement value : tableHeader)
			{
				actualFields.add(value.getText());
			}

			List<String> expectedFields = new ArrayList<String>();
			expectedFields.add("Candidate Email ID");
			expectedFields.add("Candidate Name");
			expectedFields.add("DOJ");
			expectedFields.add("Employee Type");
			expectedFields.add("PSA Location");
			expectedFields.add("I-9 Status");
			expectedFields.add("Joining\n" + 
					"Form Status");
			expectedFields.add("BGV");
			expectedFields.add("Recruiter\n" + 
					"Action Status");
			expectedFields.add("ES/HR");
			expectedFields.add("Action");
			expectedFields.add("Candidate ID");

			Assert.assertEquals(expectedFields, actualFields);
			WebActionUtil.info("All fields are displayed");
			WebActionUtil.pass("All fields are displayed");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("All fields are not displayed");
			Assert.fail("All fields are not displayed");
		}
	}
	
	/**
	 * Description: Method to validate all the menu options
	 * @author vikas.kc
	 */
	public synchronized void validateHomeMenuOptions()
	{
		try {
			WebActionUtil.actionMouseOver(menu, "Home Menu");
			WebActionUtil.poll(1000);
			List<String> actualMenu = new ArrayList<String>();

			for(WebElement op : options)
			{
				actualMenu.add(op.getText());
			}

			List<String> expectedMenu = new ArrayList<String>();
			expectedMenu.add("Quick links\n" + 
					"Home");
			expectedMenu.add("Reports\n" + 
					"iOnboard-Joining Report\n" + 
					"Lateral-Complete Report\n" + 
					"Lateral-InComplete Report\n" + 
					"Transfer-Complete Report");
			expectedMenu.add("Help\n" + 
					"User Manual\n" + 
					"Training PPT\n" + 
					"FAQ's");
			Assert.assertEquals(expectedMenu, actualMenu);
			WebActionUtil.info("All menu optons are displayed");
			WebActionUtil.pass("All menu optons are displayed");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("All menu optons are not displayed");
			Assert.fail("All menu optons are not displayed");
		}
	}
	
	/**
	 * Description: Method to validate Home link
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateHomeLink(String expectedRole, String expectedESUrl)
	{
		try {
		    validateHomeMenuOptions();
			WebActionUtil.poll(1000);
			WebActionUtil.clickOnElement(lnkHome, "Home link", "Unable to click home link");
			WebActionUtil.waitForAngularPageload();
			validateESPage(expectedRole, expectedESUrl);

			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {

				}
			WebActionUtil.pass("ES page is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES page is not displayed");
			Assert.fail("ES page is not displayed");
		}
	}

	/**
	 * Description: Method to validate Lateral-Complete Report
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateLateralCompleteReportReport(String optionName, String expectedRole, String expectedESUrl, String menuName, String expectedReportDataUrl)
	{
		try {
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(menuOptions(optionName), menuName, "Unable to click on "+menuName+" link");
			WebActionUtil.waitForAngularPageload();

			WebActionUtil.poll(1000);
			WebActionUtil.switchToNewTab();

			validateReportDataPage(menuName, expectedReportDataUrl);

			validateLateralCompleteReportData(menuName);

			WebActionUtil.switchToMainTab();
			WebActionUtil.poll(1000);
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(menuName+" page is not displayed");
			Assert.fail(menuName+" page is not displayed");
		}
	}

	/**
	 * Description: Method to validate Lateral-InComplete Report
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateLateralInCompleteReportReport(String optionName, String expectedRole, String expectedESUrl, String menuName, String expectedReportDataUrl)
	{
		try {
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(menuOptions(optionName), menuName, "Unable to click on "+menuName+" link");
			WebActionUtil.waitForAngularPageload();

			WebActionUtil.poll(1000);
			WebActionUtil.switchToNewTab();

			validateReportDataPage(menuName, expectedReportDataUrl);

			validateLateralInCompleteReportData(menuName);

			WebActionUtil.switchToMainTab();
			WebActionUtil.poll(1000);
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(menuName+" page is not displayed");
			Assert.fail(menuName+" page is not displayed");
		}
	}

	/**
	 * Description: Method to validate iOnboard-Joining Report
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateiOnboardJoiningReport(String optionName, String expectedRole, String expectedESUrl, String menuName, String expectedReportDataUrl)
	{
		try {
			validateHomeMenuOptions();

			WebActionUtil.clickOnElement(menuOptions(optionName), menuName, "Unable to click on "+menuName+" link");
			WebActionUtil.waitForAngularPageload();

			WebActionUtil.poll(1000);
			WebActionUtil.switchToNewTab();

			validateReportDataPage(menuName, expectedReportDataUrl);

			validateiOnboardJoiningReportData(menuName);

			WebActionUtil.switchToMainTab();
			WebActionUtil.poll(1000);
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(menuName+" page is not displayed");
			Assert.fail(menuName+" page is not displayed");
		}
	}

	/**
	 * Description: Method to validate Transfer-Complete Report
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateTransferCompleteReport(String optionName, String expectedRole, String expectedESUrl, String menuName, String expectedReportDataUrl)
	{
		try {
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(menuOptions(optionName), menuName, "Unable to click on "+menuName+" link");
			WebActionUtil.waitForAngularPageload();

			WebActionUtil.poll(1000);
			WebActionUtil.switchToNewTab();

			validateReportDataPage(menuName, expectedReportDataUrl);

			validateTransferCompleteReportData(menuName);

			WebActionUtil.switchToMainTab();
			WebActionUtil.poll(1000);
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(menuName+" page is not displayed");
			Assert.fail(menuName+" page is not displayed");
		}
	}


	/**
	 * Description: Method to validate iOnboard-Joining Report link
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateLateralCompleteReportLink(String expectedRole, String expectedESUrl)
	{
		try {
			WebActionUtil.actionMouseOver(menu, "Home link");
			WebActionUtil.poll(1000);
			WebActionUtil.clickOnElement(lnkiOnboardJoiningReport, "iOnboard-Joining Report", "Unable to click iOnboard-Joining Report link");
			WebActionUtil.waitForAngularPageload();
			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {

				}
			WebActionUtil.switchToNewTab();

			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES page is not displayed");
			Assert.fail("ES page is not displayed");
		}
	}

	/**
	 * Description: Method to validate Lateral-InComplete Report link
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateLateralInCompleteReportLink(String expectedRole, String expectedESUrl)
	{
		try {
			WebActionUtil.actionMouseOver(menu, "Home link");
			WebActionUtil.poll(1000);
			WebActionUtil.clickOnElement(lnkiOnboardJoiningReport, "iOnboard-Joining Report", "Unable to click iOnboard-Joining Report link");
			WebActionUtil.waitForAngularPageload();
			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {

				}

			WebActionUtil.switchToNewTab();
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES page is not displayed");
			Assert.fail("ES page is not displayed");
		}
	}

	/**
	 * Description: Method to validate iOnboard-Joining Report link
	 * @author vikas.kc
	 * 
	 * @param expectedRole
	 * @param expectedESUrl
	 */
	public synchronized void validateTransferCompleteReportLink(String expectedRole, String expectedESUrl)
	{
		try {
			WebActionUtil.actionMouseOver(menu, "Home link");
			WebActionUtil.poll(1000);
			WebActionUtil.clickOnElement(lnkiOnboardJoiningReport, "iOnboard-Joining Report", "Unable to click iOnboard-Joining Report link");
			WebActionUtil.waitForAngularPageload();
			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {

				}
			WebActionUtil.switchToNewTab();
			validateESPage(expectedRole, expectedESUrl);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES page is not displayed");
			Assert.fail("ES page is not displayed");
		}
	}


	/**
	 * Description:This Method implements to change the role
	 * 
	 * @author vikas.kc 
	 * @param role
	 */
	public synchronized void changeRole(String role) {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "Profile drop down");
			WebActionUtil.clickOnElement(selectRole(role), "Role Link", "Unable to click on" + role + "link");
			WebActionUtil.waitForAngularPageload();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select the "+role+" role");
			Assert.fail("Unable to select the "+role+" role"); 
		}
	}

	/**
	 * Description:This Method implements to change the role
	 * 
	 * @author vikas.kc 
	 * @param role
	 */
	public synchronized void changeRole1(String role) {
		try {
			WebActionUtil.clickOnElement(selectRole(role), role+" role Link", "Unable to click on" + role + "link");
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.poll(3000);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select the "+role+" role");
			Assert.fail("Unable to select the "+role+" role");
		}
	}

	/**
	 * Description: Method to validate the roles
	 * @author vikas.kc
	 */
	public synchronized void validateRoles() {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "profile");
			WebActionUtil.poll(3000);
			List<String> actualRoles = new ArrayList<String>();
			for(WebElement role : txtRoles)
			{
				actualRoles.add(role.getText());
			}
			List<String> expectedRoles = new ArrayList<String>();
			expectedRoles.add("ES");
			expectedRoles.add("RM");
			expectedRoles.add("TAG Manager");
			Assert.assertEquals(expectedRoles, actualRoles);
			
			WebActionUtil.info("ES, RM, TAG Manager Roles are displayed");
			WebActionUtil.pass("ES, RM, TAG Manager Roles are displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES, RM, TAG Manager Roles are not displayed");
			Assert.fail("ES, RM, TAG Manager Roles are not displayed");
		}
	}
	
	
	
	/**
	 * Description: Method to validate the roles
	 * @author vikas.kc
	 */
	public synchronized void validateTagRoles() {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "profile");
			WebActionUtil.poll(3000);
			List<String> actualRoles = new ArrayList<String>();
			for(WebElement role : txtRoles)
			{
				actualRoles.add(role.getText());
			}
			
			List<String> expectedRoles = new ArrayList<String>();
			expectedRoles.add("ES");
			expectedRoles.add("RM");
			expectedRoles.add("Recruiter (RMG)");
			Assert.assertEquals(expectedRoles, actualRoles);
			
			WebActionUtil.info("ES, RM, Recruiter Roles are displayed");
			WebActionUtil.pass("ES, RM, Recruiter Roles are displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("ES, RM, Recruiter Roles are not displayed");
			Assert.fail("ES, RM, Recruiter Roles are not displayed");
		}
	}

	/**
	 * Description: This Method implements to click on submit button
	 * 
	 * @author vikas.kc 
	 * @param role
	 */
	public synchronized void clkSubmit() {
		try {
			WebActionUtil.scrollDown();
			WebActionUtil.waitForElement(btnSubmit, "Submit button");
			WebActionUtil.clickOnElement(btnSubmit, "Submit button", "Unable to click on Submit button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on submit button");
			Assert.fail("Unable to click on submit button");
		}
	}

	/**
	 * Description: This method to validate Submit Success Message
	 * @author vikas.kc
	 */
	public synchronized void validateSubmiedtSuccessMessage() {
		try {
			WebActionUtil.waitForElement(txtSapUpLoadSuccessMessage, "Sap id Submit Success Message");
			Assert.assertTrue(txtSapUpLoadSuccessMessage.getText().contains("Your request has been submitted successfully."));
			WebActionUtil.pass("Sap Submit Success Message is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Sap Submit Success Message is not displayed");
			Assert.fail("Sap Submit Success Message is not displayed");
		}
	}

	/**
	 * Description: This method to select actual date of join
	 * @author vikas.kc
	 * @param actualDOJ
	 */
	public synchronized void selectActualDOJ(String actualDOJ)
	{
		try {
			WebActionUtil.waitForElement(txtActualDOJ, "ActualDOJ text field");
			WebActionUtil.clickOnElement(txtActualDOJ, "ActualDOJ text field", "Unable to click on ActualDOJ text field");
			validateCalendar();
			WebActionUtil.selectIonBoard_CalendarDate("ActualDOJ", actualDOJ, "ActualDOJ");
			WebActionUtil.action.moveByOffset(20, 5).click().perform();
			WebActionUtil.pass("Actual date of join is selected");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on ActualDOJ text field");
			Assert.fail("Unable to click on ActualDOJ text field");
		}
	}

	/**
	 * Description: Method to validate the calendar
	 * @author vikas.kc
	 */
	public synchronized void validateCalendar()
	{
		try {
			List<String> actualCalendar = new ArrayList<String>();
			for(WebElement cal : txtDatePicker)
			{
				actualCalendar.add(cal.getAttribute("class"));
			}
			List<String> expectedCalendar = new ArrayList<String>();
			expectedCalendar.add("datepicker-days");
			expectedCalendar.add("datepicker-months");
			expectedCalendar.add("datepicker-years");

			Assert.assertEquals(actualCalendar, expectedCalendar);
			WebActionUtil.pass("Calendar is displayed with days, months and years");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Calendar is not displayed");
			Assert.fail("Calendar is not displayed");
		}
	}

	/**
	 * Description: Method implements to Select the options from Reason For Hiring drop down
	 * 
	 * @author vikas.kc 
	 * @param role
	 */
	public synchronized void selectReasonForHiring(String reasonForHiring) {
		try {
			WebActionUtil.selectByText(ddReasonForHiring, reasonForHiring);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select "+reasonForHiring+" option from the drop down");
			Assert.fail("Unable to select "+reasonForHiring+" option from the drop down");
		}
	}

	/**
	 * Description: Method to validate the options in Reason For Hiring
	 * 
	 * @author vikas.kc 
	 * @param role
	 */
	public synchronized void validateReasonForHiringOptions() {
		try {
			Select selectValue = new Select(ddReasonForHiring);
			WebActionUtil.poll(1000);
			List<WebElement> ddOptions = selectValue.getOptions();
			List<String> actualOptions = new ArrayList<String>();
			for(WebElement options : ddOptions)
			{
				actualOptions.add(options.getText());
			}

			List<String> expectedOptions = new ArrayList<String>();
			expectedOptions.add("Lateral Hiring");
			expectedOptions.add("Fresher Hiring Off Campus");
			expectedOptions.add("Lateral Hiring Campus");
			expectedOptions.add("Acquisition");
			expectedOptions.add("Non SAP HCL Entity");

			Assert.assertEquals(expectedOptions, actualOptions);
			WebActionUtil.pass("Options diplayed in Reason For Hiring drop down are same");


		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Options diplayed in Reason For Hiring drop down are not same");
			Assert.fail("Options diplayed in Reason For Hiring drop down are not same");
		}
	}

	/**
	 * Description: This method implements Enter approve Remark
	 * 
	 * @author vikas.kc
	 * @param remark
	 */

	public synchronized void setRemark(String remark) {
		try {
			WebActionUtil.waitForElement(txtRemarks, "Remark text field");
			WebActionUtil.clearText(txtRemarks, "Remark text field");
			WebActionUtil.typeText(txtRemarks, remark, "Remark text field");
			validateRemark(remark);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to enter Remark");
			Assert.fail("Unable to enter Remark");
		}
	}

	/**
	 * Description: This method to validate entered remarks
	 * @author vikas.kc
	 * @param expectedRemark
	 */
	public synchronized void validateRemark(String expectedRemark)
	{
		try {
			String actualremark = WebActionUtil.getTextUsingJS("Remarks");
			Assert.assertEquals(actualremark, expectedRemark);
			WebActionUtil.pass("Entered remark is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate entered data in Remark text box");
			Assert.fail("Unable to validate entered data in Remark text box");
		}
	}

	/**
	 * Description  Method validate validate DashBoardAndJoingConsolePage
	 * @author vikas.kc
	 * 
	 * @param expectedDashboardText
	 * @param expectedJoiningConsoleText
	 * @param expectedDashboardAndJoiningConsolePageUrl
	 * @param expectedRole
	 */
	public synchronized void validateDashBoardAndJoingConsolePage(String expectedDashboardText,String expectedJoiningConsoleText,String expectedDashboardAndJoiningConsolePageUrl,String expectedRole){


		try {
			WebActionUtil.poll(1000);
			String actualDashboardText = driver.findElement(By.xpath("//div[text()='Dashboard']")).getText();
			String actualUrl =driver.getCurrentUrl();
			String actualJoiningConsoleText = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).getText();
			
			String actualRole =driver.findElement(By.xpath("//span[@class='glb-pnl-showRole role']")).getText();

			if(actualDashboardText.equals(expectedDashboardText) && actualUrl.equals(expectedDashboardAndJoiningConsolePageUrl) && actualJoiningConsoleText.equals(expectedJoiningConsoleText))
			{
				WebActionUtil.info("Dashboard and Joining Console page is displayed, url ="+driver.getCurrentUrl()+ ", title=" +actualJoiningConsoleText);
				WebActionUtil.validationinfo("Dashboard and Joining Console page is displayed, url ="+driver.getCurrentUrl()+ ", title=" +actualJoiningConsoleText,"blue");
			}
			else
			{

				if(!expectedJoiningConsoleText.equals(actualJoiningConsoleText))
				{
					WebActionUtil.validationinfo("Joining Console Text not matching,Expected=" +expectedJoiningConsoleText+",Actual="+actualJoiningConsoleText,"red");
					WebActionUtil.error("Joining Console Text not matching,Expected=" +expectedJoiningConsoleText+",Actual="+actualJoiningConsoleText);
				}
				if(!expectedDashboardAndJoiningConsolePageUrl.equals(actualUrl))
				{
					WebActionUtil.validationinfo("Url not matching,Expected=" +expectedDashboardAndJoiningConsolePageUrl+",Actual="+actualUrl,"red");
					WebActionUtil.error("Url not matching,Expected=" +expectedDashboardAndJoiningConsolePageUrl+",Actual="+actualUrl);
				}
				if(!expectedDashboardText.equals(actualDashboardText)) {
					WebActionUtil.validationinfo("Dashboard Text not matching,Expected=" +expectedDashboardText+",Actual="+actualDashboardText,"red");
					WebActionUtil.error("Dashboard Text not matching,Expected=" +expectedDashboardText+",Actual="+actualDashboardText);
				}
			}
			if(expectedRole.equals(actualRole))
			{
				WebActionUtil.info("Role: "+actualRole);
				WebActionUtil.validationinfo("Role: "+actualRole,"blue");
			}
			else
			{
				WebActionUtil.error("Role not matching, Exptected= "+expectedRole + " Actual ="+actualRole);	
				WebActionUtil.validationinfo("Role not matching, Exptected= "+expectedRole + " Actual ="+actualRole,"red");	
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to verify Home Page");
			Assert.fail("Unable to verify Home Page");
		}

	}

	/**
	 * Description  Method validate validate ES Information page
	 * @author vikas.kc
	 * 
	 * @param expectedESInformationText
	 * @param expectedESInformationUrl
	 */
	public synchronized void validateESInformationPage(String expectedESInformationText,String expectedESInformationUrl){


		try {

			String actualESInformationText = txtESInformation.getText();
			String actualUrl =driver.getCurrentUrl();

			if(actualESInformationText.equals(expectedESInformationText) && actualUrl.equals(expectedESInformationUrl))
			{
				WebActionUtil.info("ES Informatione page is displayed, url ="+driver.getCurrentUrl());
				WebActionUtil.validationinfo("ES Informatione page is displayed, url ="+driver.getCurrentUrl(),"blue");
			}
			else
			{

				if(!expectedESInformationText.equals(actualESInformationText))
				{
					WebActionUtil.validationinfo("ES Information Text not matching,Expected=" +expectedESInformationText+",Actual="+actualESInformationText,"red");
					WebActionUtil.error("ES Informatione Text not matching,Expected=" +expectedESInformationText+",Actual="+actualESInformationText);
				}
				if(!expectedESInformationUrl.equals(actualUrl))
				{
					WebActionUtil.validationinfo("Url not matching,Expected=" +expectedESInformationUrl+",Actual="+actualUrl,"red");
					WebActionUtil.error("Url not matching,Expected=" +expectedESInformationUrl+",Actual="+actualUrl);
				}
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to verify ES Information Page");
			Assert.fail("Unable to verify ES Information Page");
		}

	}

	/**
	 * Description  Method validate validate ES page
	 * @author vikas.kc
	 * 
	 * @param expectedESInformationText
	 * @param expectedESInformationUrl
	 */
	public synchronized void validateESPage(String expectedRole ,String expectedESUrl){

		try {
			String actualUrl =driver.getCurrentUrl();
			String actualRole =driver.findElement(By.xpath("//span[@class='glb-pnl-showRole role']")).getText();
			if(actualRole.equals(expectedRole) && actualUrl.equals(expectedESUrl))
			{
				WebActionUtil.info("ES page is displayed, url ="+driver.getCurrentUrl());
				WebActionUtil.validationinfo("ES page is displayed, url ="+driver.getCurrentUrl(),"blue");
			}
			else
			{
				if(!expectedRole.equals(actualRole))
				{
					WebActionUtil.error("Role not matching, Exptected= "+expectedRole + " Actual ="+actualRole);	
					WebActionUtil.validationinfo("Role not matching, Exptected= "+expectedRole + " Actual ="+actualRole,"red");	
				}
				if(!expectedESUrl.equals(actualUrl))
				{
					WebActionUtil.validationinfo("Url not matching,Expected=" +expectedESUrl+",Actual="+actualUrl,"red");
					WebActionUtil.error("Url not matching,Expected=" +expectedESUrl+",Actual="+actualUrl);
				}
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to verify ES Page");
			Assert.fail("Unable to verify ES Page");
		}
	}

	/**
	 * Description  Method validate validate ES page
	 * @author vikas.kc
	 * 
	 * @param expectedESInformationText
	 * @param expectedESInformationUrl
	 */
	public synchronized void validateReportDataPage(String menuName, String expectedReportDataUrl){

		try {
			String actualUrl =driver.getCurrentUrl();

			if(actualUrl.equals(expectedReportDataUrl))
			{
				WebActionUtil.info(menuName+" page is displayed, url ="+driver.getCurrentUrl());
				WebActionUtil.validationinfo(menuName+" page is displayed, url ="+driver.getCurrentUrl(),"blue");
			}
			else
			{
				if(!expectedReportDataUrl.equals(actualUrl))
				{
					WebActionUtil.validationinfo("Url not matching, Expected=" +expectedReportDataUrl+", Actual="+actualUrl,"red");
					WebActionUtil.error("Url not matching, Expected=" +expectedReportDataUrl+", Actual="+actualUrl);
				}
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Report Page");
			Assert.fail("Unable to Report Page");
		}
	}


	/* iOnboard-Joining Report data table */
	private List<WebElement> lstiOnboardJoiningReportData;

	public  List<WebElement> tableData()
	{
		return driver.findElements(By.xpath("//table//th[contains(@class,'sorting')]"));
	}

	/**
	 * Description: Validate if Headers/Data is present in Lateral-Complete Report table
	 * 
	 * @author Harsha K B
	 */

	public synchronized void validateLateralCompleteReportData(String menuName) {

		WebActionUtil.poll(2000);

		List<WebElement> lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()<=15]"));

		boolean isHeadersPresent = true;

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}
		WebActionUtil.poll(200);
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:last-child').scrollIntoView();");
		WebActionUtil.poll(1000);

		lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()>15]"));

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}

		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:first-child').scrollIntoView();");
		WebActionUtil.poll(1000);

		List<WebElement> welstiOnboardJoiningReportDataRows = driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr"));
		boolean isDataPresent = true;

		if (welstiOnboardJoiningReportDataRows.size() > 0)
		{
			for (int k = 1; k < welstiOnboardJoiningReportDataRows.size(); k++) {

				List<WebElement> weTabledataRow = driver
						.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr[" + k + "]/td"));

				for (int j = 1; j < weTabledataRow.size(); j++) {


					if (weTabledataRow.get(1).getText().isEmpty() || weTabledataRow.get(3).getText().isEmpty()) {

						isDataPresent = false;
						break;
					}
				}
				if (!isDataPresent) {

					break;
				}
			}
		}
		if (isDataPresent)
			WebActionUtil.validationinfo(menuName+" data is displayed", "blue");
		else
			WebActionUtil.validationinfo(menuName+" data is not displayed", "red");


	}

	/**
	 * Description: Validate if Headers/Data is present in the Lateral-Complete Report table
	 * 
	 * @author Harsha K B
	 */

	public synchronized void validateLateralInCompleteReportData(String menuName) {

		WebActionUtil.poll(2000);

		List<WebElement> lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()<=14]"));

		boolean isHeadersPresent = true;

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}
		WebActionUtil.poll(200);
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:last-child').scrollIntoView();");
		WebActionUtil.poll(1000);

		lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()>14]"));

		for (int i = 0; i < lstTH.size(); i++) {
			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}

		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:first-child').scrollIntoView();");
		WebActionUtil.poll(1000);

		List<WebElement> welstiOnboardJoiningReportDataRows = driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr"));
		boolean isDataPresent = true;


		if (welstiOnboardJoiningReportDataRows.size() > 0)
		{
			for (int k = 1; k < welstiOnboardJoiningReportDataRows.size(); k++) {

				List<WebElement> weTabledataRow = driver
						.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr[" + k + "]/td"));
				for (int j = 1; j < weTabledataRow.size(); j++) {

					if (weTabledataRow.get(1).getText().isEmpty() || weTabledataRow.get(3).getText().isEmpty()) {

						isDataPresent = false;
						break;
					}
				}
				if (!isDataPresent) {

					break;
				}
			}
		}
		if (isDataPresent)
			WebActionUtil.validationinfo(menuName+" data is displayed", "blue");
		else
			WebActionUtil.validationinfo(menuName+" data is not displayed", "red");


	}

	/**
	 * Description: Validate if Headers/Data is present in iOnboard-Joining Report table
	 * 
	 * @author Harsha K B
	 */

	public synchronized void validateiOnboardJoiningReportData(String menuName) {

		WebActionUtil.poll(1500);
		List<WebElement> lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()<=18]"));

		boolean isHeadersPresent = true;

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(3000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}
		WebActionUtil.poll(200);
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:last-child').scrollIntoView();");
		WebActionUtil.poll(1000);

		lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()>18]"));

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}

		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:first-child').scrollIntoView();");
		WebActionUtil.poll(1000);
		List<WebElement> welstiOnboardJoiningReportDataRows = driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr"));
		boolean isDataPresent = true;

		if (welstiOnboardJoiningReportDataRows.size() > 0)
		{
			for (int k = 1; k < welstiOnboardJoiningReportDataRows.size(); k++) {

				List<WebElement> weTabledataRow = driver
						.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr[" + k + "]/td"));
				for (int j = 1; j < weTabledataRow.size(); j++) {

					if (weTabledataRow.get(1).getText().isEmpty() || weTabledataRow.get(3).getText().isEmpty()) {

						isDataPresent = false;
						break;
					}
				}
				if (!isDataPresent) {

					break;
				}
			}
		}
		if (isDataPresent)
			WebActionUtil.validationinfo(menuName+" data is displayed", "blue");
		else
			WebActionUtil.validationinfo(menuName+" data is not displayed", "red");
	}

	/**
	 * Description: Validate if Headers/Data is present in the table
	 * 
	 * @author Harsha K B
	 */

	public synchronized void validateTransferCompleteReportData(String menuName) {
		WebActionUtil.poll(2000);

		List<WebElement> lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()<=16]"));

		boolean isHeadersPresent = true;

		for (int i = 0; i < lstTH.size(); i++) {
			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}

		WebActionUtil.poll(200);
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:nth-child(28)').scrollIntoView();");
		WebActionUtil.poll(1000);

		lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()>16 and position()<=28]"));

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}

		WebActionUtil.poll(200);
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:last-child').scrollIntoView();");
		WebActionUtil.poll(1000);
		lstTH = driver.findElements(By.xpath("(//div[@class='dataTables_scrollHead']/div[@class='dataTables_scrollHeadInner']/table/thead/tr/th)[position()>28]"));

		for (int i = 0; i < lstTH.size(); i++) {

			WebActionUtil.poll(1000);
			if (lstTH.get(i).getText().isEmpty()) {

				isHeadersPresent = false;
				break;
			}
		}
		((JavascriptExecutor)driver).executeScript("document.querySelector('div.dataTables_scroll>div:nth-child(1)>div>table tr>th:first-child').scrollIntoView();");
		WebActionUtil.poll(1000);
		List<WebElement> welstiOnboardJoiningReportDataRows = driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr"));
		boolean isDataPresent = true;

		if (welstiOnboardJoiningReportDataRows.size() > 0)
		{
			for (int k = 1; k < welstiOnboardJoiningReportDataRows.size(); k++) {

				List<WebElement> weTabledataRow = driver
						.findElements(By.xpath("//table[contains(@id,'DataTables_Table_')]//tr[" + k + "]/td"));

				for (int j = 1; j < weTabledataRow.size(); j++) {
					if (weTabledataRow.get(1).getText().isEmpty() || weTabledataRow.get(3).getText().isEmpty()) {
						isDataPresent = false;
						break;
					}
				}
				if (!isDataPresent) {

					break;
				}

			}
		}
		if (isDataPresent)
			WebActionUtil.validationinfo(menuName+" data is displayed", "blue");
		else
			WebActionUtil.validationinfo(menuName+" data is not displayed", "red");


	}

	/**
	 * Description:Method to download UserManuel link
	 * @author 
	 */

	public synchronized void clkUserManuel() 
	{
		try
		{
			String fileExtension="pptx";
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(lnkUserManuel, "User manual link",
					"Unable to click on usermanual link");
			String userDir = System.getProperty("user.home");
			String downloadedDocumentName = WebActionUtil.getDownloadedDocumentName(userDir + "/Downloads",
					fileExtension);
			Assert.assertTrue(downloadedDocumentName.contains(fileExtension));
			WebActionUtil.info(downloadedDocumentName + " file succesfully downloaded");
			WebActionUtil.validationinfo(downloadedDocumentName + " file succesfully downloaded", "blue");
		}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on User manual link ");
			Assert.fail("Unable to perform action on User manual link");
		}
	}

	/**
	 * Description: Method to download Training PPT
	 * @author 
	 */
	public synchronized void clkTrainingPPT() 
	{
		try
		{
			String fileExtension="pptx";
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(lnkTrainingPPT, "Training ppt link",
					"Unable to click on Training ppt link");
			String userDir = System.getProperty("user.home");
			String downloadedDocumentName = WebActionUtil.getDownloadedDocumentName(userDir + "/Downloads",
					fileExtension);
			Assert.assertTrue(downloadedDocumentName.contains(fileExtension));
			WebActionUtil.info(downloadedDocumentName + " file succesfully downloaded");
			WebActionUtil.validationinfo(downloadedDocumentName + " file succesfully downloaded", "blue");
		}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Training ppt link");
			Assert.fail("Unable to perform action on Training ppt link");
		}
	}

	/**
	 * Description: Method to select FQA pdf link
	 * @author 
	 */
	public synchronized void clkFQA(String expectedFQAUrl) 
	{
		try
		{
			validateHomeMenuOptions();
			WebActionUtil.clickOnElement(lnkFQA, "FAQ pdf link",
					"Unable to click on FAQ pdf link");
			WebActionUtil.switchToNewTab();
			String actualUrl =driver.getCurrentUrl(); 
			if(actualUrl.equals(expectedFQAUrl))
			{
				WebActionUtil.info("FAQ's IOnBoard pdf is displayed");
				WebActionUtil.validationinfo("FAQ's IOnBoard pdf is displayed","blue");
			}
			else
			{
				if(!expectedFQAUrl.equals(actualUrl))
				{
					WebActionUtil.validationinfo("FAQ's IOnBoard pdf is not displayed","red");
					WebActionUtil.error("FAQ's IOnBoard pdf is not displayed");
				}
			}
			WebActionUtil.switchToMainTab();
		}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on FAQ's pdf link ");
			Assert.fail("Unable to perform action on FAQ's link");
		}

	}
	
	/**
	 * Description: Method to click on filter
	 * @author vikas.kc
	 */
	public synchronized void clkFilter() 
	{
		try {
			WebActionUtil.clickOnElement(lnkFilter, "Filter link", "Unable to click on Filter link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Filter link");
			Assert.fail("Unable to click on Filter link");
		}
	}
	
	/**
	 * Description: Method to Filter Fields text
	 * @author vikas.kc
	 */
	public synchronized void validateFilterText() 
	{
		try {
			WebActionUtil.poll(1000);
			List<String> actualFilterText = new ArrayList<String>();
			for(WebElement op : txtFilter)
			{
				actualFilterText.add(op.getText());
			}

			actualFilterText.add(btnSearch.getText());
			actualFilterText.add(btnReset.getText());
			
			List<String> expectedFilterText = new ArrayList<String>();
			
			expectedFilterText.add("Country");
			expectedFilterText.add("Band");
			expectedFilterText.add("Location");
			expectedFilterText.add("BGV Status");
			expectedFilterText.add("Candidate Name");
			expectedFilterText.add("SAP ID");
			expectedFilterText.add("Joining Form Status");
			expectedFilterText.add("Employee Type");
			expectedFilterText.add("Joining Date From");
			expectedFilterText.add("Joining Date To");
			expectedFilterText.add("SEARCH");
			expectedFilterText.add("RESET");
			Assert.assertEquals(expectedFilterText, actualFilterText);
			WebActionUtil.info("All filter optons are displayed");
			WebActionUtil.pass("All filter optons are displayed");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("All Filter optons are not displayed");
			Assert.fail("All Filter optons are not displayed");
		}
	}
	
	/**
	 * Description: Method to click on reset button
	 * @author vikas.kc
	 */
	public synchronized void clkReset() 
	{
		try {
			WebActionUtil.clickOnElement(btnReset, "Reset", "Unable to click on Reset button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Reset button");
			Assert.fail("Unable to click on Reset button");
		}
	}
	
	/**
	 * Description: Method to click on Search button
	 * @author vikas.kc
	 */
	public synchronized void clkSearch() 
	{
		try {
			WebActionUtil.clickOnElement(btnSearch, "Search", "Unable to click on Search button");
			
			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {
					
				}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Search button");
			Assert.fail("Unable to click on Search button");
		}
	}
	
	/**
	 * Description: Method to Select country 
	 * @author vikas.kc
	 */
	public synchronized void selectCountry() 
	{
		try {
			WebActionUtil.poll(500);
			WebActionUtil.typeText(txtCountry, "USA", "Country");
			txtCountry.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select  country");
			Assert.fail("Unable to select  country");
		}
	}
	
	/**
	 * Description: Method to Select band 
	 * @author vikas.kc
	 */
	public synchronized void selectBand() 
	{
		try {
			WebActionUtil.poll(1000);
			WebActionUtil.typeText(txtBand, "AT", "Band");
			txtBand.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select band");
			Assert.fail("Unable to select band");
		}
	}
	
	/**
	 * Description: Method to Select location 
	 * @author vikas.kc
	 */
	public synchronized void selectLocation() 
	{
		try {
			WebActionUtil.typeText(txtLocationId, "Alabama", "location");
			txtLocationId.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select location");
			Assert.fail("Unable to select location");
		}
	}
	
	/**
	 * Description: Method to Select BgvStatusCode 
	 * @author vikas.kc
	 */
	public synchronized void selectBgvStatusCode() 
	{
		try {
			WebActionUtil.typeText(txtBgvStatusCode, "Red", "BgvStatusCode");
			WebActionUtil.poll(500);
			txtBgvStatusCode.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select BgvStatusCode");
			Assert.fail("Unable to select BgvStatusCode");
		}
	}
	
	/**
	 * Description: Method to Select Joining Form Status 
	 * @author vikas.kc
	 */
	public synchronized void selectjoiningFormStatusCode() 
	{
		try {
			WebActionUtil.typeText(txtjoiningFormStatusCode, "Pending", "Joining Form Status");
			WebActionUtil.poll(500);
			txtjoiningFormStatusCode.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select Joining Form Status");
			Assert.fail("Unable to select Joining Form Status");
		}
	}
	
	/**
	 * Description: Method to Select Employee Type
	 * @author vikas.kc
	 */
	public synchronized void selectEmployeeType() 
	{
		try {
			WebActionUtil.typeText(txtemployeeTypeCode, "All", "Employee Type");
			WebActionUtil.poll(500);
			txtemployeeTypeCode.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select Employee Type");
			Assert.fail("Unable to select Employee Type");
		}
	}
	
	/**
	 * Description: Method to Select Joining Date From
	 * @author vikas.kc
	 */
	public synchronized void selectJoiningDateFrom() 
	{
		try {
			WebActionUtil.clickOnElement(txtJoiningDateFrom, "Joining Date From", "Unable to click on joining date from");
			WebActionUtil.selectIonBoard_CalendarDate("datepicker1", "Thu, 18 Feb'21", "Joining Date From");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select Joining Date From");
			Assert.fail("Unable to select Joining Date From");
		}
	}
	
	/**
	 * Description: Method to Select Joining Date To
	 * @author vikas.kc
	 */
	public synchronized void selectJoiningDateTo() 
	{
		try {
			WebActionUtil.clickOnElement(txtJoiningDateTo, "Joining Date To", "Unable to click on joining date to");
			WebActionUtil.selectIonBoard_CalendarDate("datepicker2", "Thu, 20 Feb'21", "Joining Date From");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select Joining Date To");
			Assert.fail("Unable to select Joining Date To");
		}
	}
	
	/**
	 * Description: Method to enter SAP ID
	 * @author vikas.kc
	 */
	public synchronized void setSAPID() 
	{
		try {
			WebActionUtil.typeText(txtSapID, "7241", "SAP ID");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on SAP ID");
			Assert.fail("Unable to click on SAP ID");
		}
	}
	
	/**
	 * Description: Method to enter Candidate Name
	 * @author vikas.kc
	 */
	public synchronized void setCandidateName(String candidateName) 
	{
		try {
			WebActionUtil.typeText(txtCandidateName, candidateName, "Candidate Name");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Candidate Name");
			Assert.fail("Unable to click on Candidate Name");
		}
	}
	
	/**
	 * Description: Method to validate Candidate Name
	 * @author vikas.kc
	 */
	public synchronized void validateCandidateName(String candidateName) 
	{
		try {
			String actualCandidateName = WebActionUtil.getTextUsingJS("canName");
			Assert.assertTrue(actualCandidateName.contains(candidateName));
			WebActionUtil.info("Entered candidate name is reflected");
			WebActionUtil.pass("Entered candidate name is reflected");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Entered candidate name is not reflected");
			Assert.fail("Entered candidate name is not reflected");
		}
	}
	
	/**
	 * Description: Method to validate Candidate Name after reset
	 * @author vikas.kc
	 */
	public synchronized void validateCandidateNameAfterReset() 
	{
		try {
			String actualCandidateName = WebActionUtil.getTextUsingJS("canName");
			Assert.assertTrue(actualCandidateName.contains(""));
			WebActionUtil.info("Entered Data got reseted in candidate name text field");
			WebActionUtil.pass("Entered Data got reseted in candidate name text field");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Entered Data doesnot got reseted in candidate name text field");
			Assert.fail("Entered Data doesnot got reseted in candidate name text field");
		}
	}
	
	/**
	 * Description: Method to validate Candidate Name after reset
	 * @author vikas.kc
	 */
	public synchronized void validateJoiningConsoleCandidateName(String candidateName) 
	{
		try {
			String actualCandidateName = txtJoiningConsoleCandidateName.getText();
			Assert.assertTrue(actualCandidateName.contains(candidateName));
			WebActionUtil.info("Valid candidate name reflected under joining console");
			WebActionUtil.pass("Valid candidate name reflected under joining console");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Valid candidate name not reflected under joining console");
			Assert.fail("Valid candidate name not reflected under joining console");
		}
	}
	
	/**
	 * Description: Method to Filter Fields text reset
	 * @author vikas.kc
	 */
	public synchronized void validateFilterFieldsTextReset() 
	{
		try {
			WebActionUtil.poll(1000);
			List<String> actualFilterFieldsText = new ArrayList<String>();

			for(WebElement reset : txtReset)
			{
				actualFilterFieldsText.add(reset.getText());
			}
			List<String> expectedFilterFieldsText = new ArrayList<String>();
			
			expectedFilterFieldsText.add("Select");
			expectedFilterFieldsText.add("Select");
			expectedFilterFieldsText.add("Select");
			expectedFilterFieldsText.add("Select");
			expectedFilterFieldsText.add("Select");
			expectedFilterFieldsText.add("Select");
			
			Assert.assertEquals(expectedFilterFieldsText, actualFilterFieldsText);
			WebActionUtil.info("All Filter fields are reseted");
			WebActionUtil.pass("All Filter fields are reseted");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("All Filter fields are not reseted");
			Assert.fail("All Filter fields are not reseted");
		}
	}

	/**
	 * Description: Method to click on dash board button
	 * @author vikas.kc
	 */
	public synchronized void clkDashBoardTriangle() 
	{
		try {
			WebActionUtil.clickOnElement(txtDashboardTriangle, "DashboardTriangle button", "Unable to click on DashboardTriangle button");
			Assert.assertEquals(txtDashboardTriangle.getAttribute("class"), "glyphicon glyphicon-triangle-bottom down");
			WebActionUtil.info("Dashboard is collapsed");
			WebActionUtil.pass("Dashboard is collapsed");
			
			WebActionUtil.clickOnElement(txtDashboardTriangle, "DashboardTriangle button", "Unable to click on DashboardTriangle button");
			Assert.assertEquals(txtDashboardTriangle.getAttribute("class"), "glyphicon glyphicon-triangle-bottom");
			WebActionUtil.info("Dashboard is expanded");
			WebActionUtil.pass("Dashboard is expanded");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on dash board button");
			Assert.fail("Unable to click on dash board button");
		}
	}

}
