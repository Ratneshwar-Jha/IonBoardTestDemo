package com.hcl.ionboard.testscripts;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;

/**
 * TestCaseId: TYSS_IOB_009
 * TestScript Name: TYSS_IOB_009
 * Description: Verify Transfer case candidate data has been pushed to SAP upload(Without Passport, Visa & without Bank details)
 * 
 * Author: Vivek
 */
public class TYSS_IOB_009 extends BaseTest {
	@Test(description = "Description: Verify Transfer case candidate data has been pushed to SAP upload(Without Passport, Visa & without Bank details)")
	public void TC_TYSS_IOB_009() {
		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009",
				"LoginDetails");
		Map<String, String> permanentaddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009",
				"PermanentAddress");
		Map<String, String> additionalInfo = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009",
				"AdditionalInformation");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009",
				"EmergencyContactDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009",
				"PersonalDetails");
		Map<String, String> i94 = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_009", "I94");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		/* log in as candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* click on fill joining form */
		pages.homePage.clkFillJoiningForm();

		/* joining Personal details */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Fetch candidate name */
//		String candidateName = "Rajesh Mohan Negi";
		String candidateName1 = pages.joiningFormPage.fetchName();
		String candidateName = WebActionUtil.convertStringToCamelCase(candidateName1);

		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fills The Personal Details Fields */
		pages.joiningFormPage.personalDetailsForTransferCase(personalDetails.get("Title"),
				personalDetails.get("MiddleName"), personalDetails.get("DifferentMaidenName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("MarriageDate"),
				personalDetails.get("Nationality"), personalDetails.get("Citizenship"),
				personalDetails.get("DualCitizenship"), personalDetails.get("EthnicOrigin"),
				personalDetails.get("Race"));

		/* click My Current Address Is My Permanent Address check box */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Set the fields Under permanent Address */
		pages.joiningFormPage.permanentAddress(permanentaddress.get("C/O"), permanentaddress.get("AddressLine1"),
				permanentaddress.get("AddressLine2"), permanentaddress.get("Country"), permanentaddress.get("State"),
				permanentaddress.get("City"), permanentaddress.get("PostalCode"));

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/************** Additional Info************** */
		/* Click on No Passport Radio Button */
		pages.additionalInfoPage.clkNoPassportRb();

		/* select Language */
		pages.additionalInfoPage.selectLanguage(additionalInfo.get("Language"));

		/* Click protected Veteran */
		pages.additionalInfoPage.clkProtectedVeteran();

		/* set SSNumber */
		pages.additionalInfoPage.setSSNnumber(additionalInfo.get("SSNNumber"));

		/* click No Disability */
		pages.additionalInfoPage.clkNoDisablity();

		/* Set the fields Advance Taken Off shore */
		pages.additionalInfoPage.setAdvanceTakenOffshoreTb(additionalInfo.get("AdvanceTakenOffshore"));

		/* Set the fields AdvanceTakenOnsiteTb */
		pages.additionalInfoPage.setAdvanceTakenOnsiteTb(additionalInfo.get("AdvanceTakenOnsite"));

		/* set Emergency Contact Details */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelephoneNumber"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("AddressLine1"), emergencyContactDetails.get("AddressLine2"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Set I94 Details */
		pages.additionalInfoPage.setI94(i94.get("I94Number"), i94.get("RetypeI94Number"),
				WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")),
				i94.get("I94AdmitUntilDate"));

		/* click Continue Button */
		pages.additionalInfoPage.clkContinueThirdParty();

		/***** Preview page ******/

		/* Validate Preview Page is displayed */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		WebActionUtil.waitForAngularPageToLoad();

		/* Click on Voluntary Self Identification Lookup */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* Click on I have Read and Understood Check box & Click on Submit button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* Click on I have Read and Understood Check box & Click on Submit button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* Click on Submit Button */
		pages.previewPage.clkSubmitBtn();

		/* Validate Preview Page is displayed */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));
		WebActionUtil.waitForAngularPageToLoad();

		/*
		 * Click on Employee Handbook HCLA Check box & Validate Employee Handbook HCLA
		 * PDF file
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/*
		 * Click on Export Compliance Policy Check box & Validate Export Compliance
		 * Policy PDF File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("exportCompliancePolicy"));

		/*
		 * Click on Policy and Procedures Check box & Validate Policy and Procedures PDF
		 * File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("policyAndProcedures"));

		/*
		 * Click on Sexual Harassment Policy Check box & Validate Sexual Harassment
		 * Policy PDF File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/*
		 * Click on Employment Agreement Check box & Validate Employment Agreement PDF
		 * File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employmentAgreement"));

		/*
		 * Click on Joining Form Declaration for bank details Check box & Validate
		 * Joining Form Declaration for bank details PDF File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("joiningFormDeclarationForBankDetails"));

		/*
		 * Click on cFIUS Security Policies Check box & Validate cFIUS Security Policies
		 * PDF File
		 */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Click on Final Submit Button */
		pages.previewPage.clkFinalSubmitBtn();

		/* Click on Logout Link */
		pages.previewPage.clkLogoutLnk();

		/* Deleting the cookies */
		driver.manage().deleteAllCookies();

		/************ QA Login ******************/

		/* Enter QA login URL */
		driver.navigate().to(prop.getProperty("App_QAURL"));
		new WebDriverWait(driver, 90).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

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

		/* enter candidate name in search bar */
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

		/* enter candidate name in search bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Clicks on Action Icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validates ES Page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Select Actual Date of Joining from Calendar Icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Selects an option from the Reason for Hiring drop down */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("reasonForHiring"));

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
