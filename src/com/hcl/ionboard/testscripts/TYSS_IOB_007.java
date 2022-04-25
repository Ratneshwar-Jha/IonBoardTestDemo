package com.hcl.ionboard.testscripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
/**
 * TestCaseId: TYSS_IOB_007
 * TestScript Name: TYSS_IOB_007
 * Description: Verify third party candidate data has been pushed to SAP upload
 * 
 * Author: Sajal
 */
public class TYSS_IOB_007 extends BaseTest {
	@Test(description = "Description: Verify third party candidate data has been pushed to SAP upload")
	public void TC_TYSS_IOB_007() {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_007",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_007",
				"PersonalDetails");
		Map<String, String> addressDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_007",
				"AddressDetails");
		Map<String, String> passportDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_007",
				"PassportDetails");

		/************ 3rd Party Candidate login ******************/

		/* Log in as Candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* Click on fill joining form */
		pages.homePage.clkFillJoiningForm();

		/* Validate the Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Fetch Name */
		String candidateName = pages.joiningFormPage.fetchName();
		// String candidateName = "John Kevin";

		/* Upload the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fill The Personal Details Fields */
		pages.joiningFormPage.personalDetailsforThirdParty(personalDetails.get("Title"),
				personalDetails.get("MiddleName"), personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("DateOfBirth"), personalDetails.get("Nationality"));

		/* Fill The Address Details Fields */
		pages.joiningFormPage.permanentAddressforThirdParty(addressDetails.get("CO"),
				addressDetails.get("AddressLine1"), addressDetails.get("AddressLine2"), addressDetails.get("Country"),
				addressDetails.get("State"), addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Click on Continue button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/*** Additional Info Page ***/

		/* Click on Yes Radio button for passport */
		WebActionUtil.waitForAngularPageToLoad();
		pages.additionalInfoPage.clkYesPassportRbThirdparty();

		/* Click on Yes Radio button for Visa */
		pages.additionalInfoPage.clkYesVisaRb();

		/* Enter Visa details */
		pages.additionalInfoPage.setVisaFields(passportDetails.get("VisaCountry"), passportDetails.get("TypeOfVisa"),
				passportDetails.get("VisaFrom"), passportDetails.get("VisaTo"));

		/* Click on Continue button */
		pages.additionalInfoPage.clkContinueThirdParty();

		/* validate Preview Page is displayed */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Final Submit button */
		WebActionUtil.waitForAngularPageToLoad();
		pages.previewPage.clkFinalSubmitBtn();

		/* Click on View Joining form */
		pages.homePage.clkViewJoiningForm();

		/* Validate tick icon is disabled */
		pages.previewPage.validateTickIcn();

		/* Validate Form is Editable */
		pages.previewPage.validateFormEditable();

		/* Click on Logout link */
		pages.previewPage.clkLogoutLnk();

		/* Deleting the cookies */
		driver.manage().deleteAllCookies();

		/* Enter QA login URL */
		driver.navigate().to(prop.getProperty("App_QAURL"));

		/************ QA Login ******************/
		new WebDriverWait(driver, 80).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

		/* Enter User name and Password in QA Login Page */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Validates DashBoard And Joining Console Page */
		pages.esPage.validateDashBoardAndJoingConsolePage(prop_app_constants.getProperty("expectedDashboardText"),
				prop_app_constants.getProperty("expectedJoiningConsoleText"),
				prop_app_constants.getProperty("expectedDashboardAndJoiningConsolePageUrl"),
				prop_app_constants.getProperty("roleES"));

		/* Validate RM,Recruiter and Tag manager role **/
		pages.recruiterPage.validateRoles();

		/************ Recruiter(RMG) Page ******************/

		/* Change Role to Recruiter(RMG) */
		pages.recruiterPage.changeRole(prop_app_constants.getProperty("roleRMG"));

		/* Validate the fields in Recruiter Page */
		pages.recruiterPage.validateFields(prop_app_constants.getProperty("roleRMG"));

		/* Set candidate name and click on search bar */
		pages.recruiterPage.clkSearchBar(candidateName);

		/* Validate Joining Form status */
		pages.recruiterPage.validateJoiningFormStatus(candidateName);

		/* Click on Mail Icon */
		pages.recruiterPage.clkMailIcon(candidateName);

		/* Click on Action Icon */
		pages.recruiterPage.clkActionIcon(candidateName);

		/* Clicks on Did Candidate Join drop down */
		pages.recruiterPage.clkDidCandidateJoin();

		/* Select yes from the Did Candidate Join drop down */
		pages.recruiterPage.selectYesDd();

		/* Clicks on Submit Button */
		pages.recruiterPage.clkSubmitButton(prop_app_constants.getProperty("expectedRecruiterUrl"));

		/************ ES Role Page ******************/

		/* Validates the Roles */
		pages.esPage.validateRoles();

		/* Switches the Role to ES */
		pages.esPage.changeRole(prop_app_constants.getProperty("roleES"));

		/* Validates the fields in ES Page */
		pages.esPage.validateFields();

		/* Set candidate id and click on search bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Clicks on Action Icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validates ES Page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Select Actual Date of Joining from Calendar Icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Selects an option from the Reason for Hiring drop down */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("reasonForHiringContractualHiring"));

		/* Enters the Remarks in Remarks text field */
		pages.esPage.setRemark(prop_app_constants.getProperty("approveRemark"));

		/* Click on Submit Button */
		pages.esPage.clkSubmit();

		/* Validates ES Status */
		pages.esPage.validateESStatus(loginDetails.get("CandidateId"));

		/* Logout from the application */
		pages.qaLogoutPage.logoutToApplication();
	}
}
