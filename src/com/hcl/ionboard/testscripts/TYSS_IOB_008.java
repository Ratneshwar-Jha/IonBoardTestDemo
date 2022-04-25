package com.hcl.ionboard.testscripts;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
/**
 * TestCaseId: TYSS_IOB_008
 * TestScript Name: TYSS_IOB_008
 * Description: Verify Transfer case candidate data has been pushed to SAP upload(With Passport, Visa & Bank details)
 * 
 * Author: Sajal
 */
public class TYSS_IOB_008 extends BaseTest {

	@Test(description = "Description: Verify Transfer case candidate data has been pushed to SAP upload(With Passport, Visa & Bank details)")
	public void TC_TYSS_IOB_008() {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"PersonalDetails");
		Map<String, String> permanentAddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"PermanentAddress");
		Map<String, String> passportDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"PassportDetails");
		Map<String, String> visaDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"VisaDetails");
		Map<String, String> addressOnPassport = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"AddressOnPassport");
		Map<String, String> additionalInformation = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"AdditionalInformation");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"EmergencyContactDetails");
		Map<String, String> i94 = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008", "I94");
		Map<String, String> bankAccountDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_008",
				"BankAccountDetails");

		/************ Transfer Case Candidate login ******************/

		/* Log in as Candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* Click on fill joining form */
		pages.homePage.clkFillJoiningForm();

		/* Validate Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* fetch name */
		String candidateName = pages.joiningFormPage.fetchName();
		// String candidateName="Sanjana Kumari";

		/* Upload the Profile Picture */
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

		/* Click on My Current Address Is My Permanent Address check box */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Set the field Under permanent Address */
		pages.joiningFormPage.permanentAddress(permanentAddress.get("C/O"), permanentAddress.get("AddressLine1"),
				permanentAddress.get("AddressLine2"), permanentAddress.get("Country"), permanentAddress.get("State"),
				permanentAddress.get("City"), permanentAddress.get("PostalCode"));

		/* Click on Continue button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/*** AdditionalInfoPage ***/

		/* Click Yes Radio button */
		pages.additionalInfoPage.clkYesPassportRb();

		/* Enter Passport details */
		pages.additionalInfoPage.setPassportFields(passportDetails.get("PassportNumber"),
				passportDetails.get("PlaceOfIssue"), passportDetails.get("IssuingAuthority"),
				passportDetails.get("DateOfIssue"), passportDetails.get("DateOfExpiry"));

		/* Click on Yes Radio button for Visa */
		pages.additionalInfoPage.clkYesVisaRb();

		/* Enter Visa details */
		pages.additionalInfoPage.setVisaFields(visaDetails.get("VisaCountry"), visaDetails.get("TypeOfVisa"),
				visaDetails.get("VisaFrom"), visaDetails.get("VisaTo"));

		/* Enter Passport Address */
		pages.additionalInfoPage.setPassportAddress(addressOnPassport.get("C/O"), addressOnPassport.get("AddressLine1"),
				addressOnPassport.get("AddressLine2"), addressOnPassport.get("Country"), addressOnPassport.get("State"),
				addressOnPassport.get("City"), addressOnPassport.get("PostalCode"));

		/* Select Language */
		pages.additionalInfoPage.selectLanguage(additionalInformation.get("Language"));

		/* Click Protected Veteran */
		pages.additionalInfoPage.clkProtectedVeteran();

		pages.additionalInfoPage.setSSNnumber(additionalInformation.get("SSNNumber"));

		/* Click No Disability */
		pages.additionalInfoPage.clkNoDisablity();

		/* Enter Advance Taken Off shore */
		pages.additionalInfoPage.setAdvanceTakenOffshoreTb(additionalInformation.get("AdvanceTakenOffshore"));

		/* Enter Advance Taken On site */
		pages.additionalInfoPage.setAdvanceTakenOnsiteTb(additionalInformation.get("AdvanceTakenOnsite"));

		/* Enter Emergency ContanctDetails */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelephoneNumber"), emergencyContactDetails.get("AddressLine1"),
				emergencyContactDetails.get("AddressLine2"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Enter I94 Details */
		pages.additionalInfoPage.setI94(i94.get("I94Number"), i94.get("RetypeI94Number"),
				WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")),
				i94.get("I94AdmitUntilDate"));

		/* Click on Yes Radio button for Do you have a bank account */
		pages.additionalInfoPage.clkDoyouhaveaBankAccount();

		/* Enter Bank Account Details & click on Acknowledge Bank Details check box */
		pages.additionalInfoPage.setBankAccountDetails(bankAccountDetails.get("AccountNumber"),
				bankAccountDetails.get("RetypeAccountNumber"), bankAccountDetails.get("AccountType"),
				bankAccountDetails.get("RoutingNumber"), bankAccountDetails.get("RetypeRoutingNumber"));

		/* Click on Continue button */
		pages.additionalInfoPage.clkContinueThirdParty();

		/***** Preview page ******/

		/* Validate Preview Page is displayed */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

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

		/* Click view joining form */
		pages.homePage.clkViewJoiningForm();

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

		/* Click on Submit Button */
		pages.recruiterPage.clkSubmitButton(prop_app_constants.getProperty("expectedRecruiterUrl"));

		/************ ES Role Page ******************/

		/* Validate the Roles */
		pages.esPage.validateRoles();

		/* Switches the Role to ES */
		pages.esPage.changeRole(prop_app_constants.getProperty("roleES"));

		/* Validate the fields in ES Page */
		pages.esPage.validateFields();

		/* Set candidate id and click on search bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Click on Action Icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validate ES Page is displayed */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Select Actual Date of Joining from Calendar Icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Select an option from the Reason for Hiring drop down */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("reasonForHiring"));

		/* Enter the Remarks in Remarks text field */
		pages.esPage.setRemark(prop_app_constants.getProperty("approveRemark"));

		/* Click on Submit Button */
		pages.esPage.clkSubmit();

		/* Validate ES Status */
		pages.esPage.validateESStatus(loginDetails.get("CandidateId"));

		/* Logout from the application */
		pages.qaLogoutPage.logoutToApplication();
	}
}