package com.hcl.ionboard.testscripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
/**
 * TestCaseId: TYSS_IOB_006
 * TestScript Name: TYSS_IOB_006
 * Description: Verify the Fresher Candidate Details (with Passport and with Visa) have been pushed to Sap upload
 * 
 * Author: Aatish
 */
public class TYSS_IOB_006 extends BaseTest {
	@Test(description = "Description: Verify the Fresher Candidate Details (with Passport and with Visa) have been pushed to Sap upload")
	public void TC_TYSS_IOB_006() {

		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"LoginDetails");
		Map<String, String> certificationDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"CertificationDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"PersonalDetails");
		Map<String, String> permanentAddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"PermanentAddress");
		Map<String, String> currentAddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"CurrentAddress");
		Map<String, String> passPortDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"PassportDetails");
		Map<String, String> passPortAddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"PassportAddress");

		Map<String, String> visaDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"VisaDetails");
		Map<String, String> additionalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"AdditionalInfo");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"EmergencyContactDetails");
		Map<String, String> educationDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_006",
				"EducationDetails");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		/* log in as candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Click on Fill Joining Form */
		pages.homePage.clkFillJoiningForm();

		/************ Joining Form Page ******************/
		/* validates the Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fetch Name from Joining Form Page */
		String candidateName = pages.joiningFormPage.fetchName();
		String completeName = pages.joiningFormPage.fetchCompleteName(personalDetails.get("MiddleName"));
		// String candidateName="Kevin John";
		// String completeName="Kevin Rahet John";

		/* Fills The Personal Details Fields */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("Citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));

		/* Mouse over on Ethnic Origin book icon */
		pages.joiningFormPage.mouseHoverEthnicOriginlnk();

		/* Mouse Over on Race Book Icon */
		pages.joiningFormPage.mouseHoverRacelnk();

		/** Parmanent Adress **/

		/* Enter Permanent Address */
		pages.joiningFormPage.permanentAddress(permanentAddress.get("C/O"), permanentAddress.get("Address Line1"),
				permanentAddress.get("Address Line2"), permanentAddress.get("Country"), permanentAddress.get("State"),
				permanentAddress.get("City"), permanentAddress.get("PostalCode"));

		/* Current Address */
		pages.joiningFormPage.currentAddress(currentAddress.get("C/O"), currentAddress.get("Address Line1"),
				currentAddress.get("Address Line2"), currentAddress.get("Country"), currentAddress.get("State"),
				currentAddress.get("City"), currentAddress.get("PostalCode"));

		/* Clicking on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/* Clicking Yes Passport Button */
		pages.additionalInfoPage.clkYesPassportRb();

		/* Entering the Passport Fields */
		pages.additionalInfoPage.setPassportFields(passPortDetails.get("PassportNumber"),
				passPortDetails.get("PlaceOfIssue"), passPortDetails.get("IssuingAuthority"),
				passPortDetails.get("DateOfIssue"), passPortDetails.get("DateOfExpiry"));

		/* Selecting Yes for Visa Details */
		pages.additionalInfoPage.clkYesVisaRb();

		/* Entering Visa details */
		pages.additionalInfoPage.setVisaFields(visaDetails.get("VisaCountry"), visaDetails.get("TypeOfVisa"),
				visaDetails.get("VisaFrom"), visaDetails.get("VisaTo"));

		/* Entering Passport details */
		pages.additionalInfoPage.setPassportAddress(passPortAddress.get("C/O"), passPortAddress.get("Address Line1"),
				passPortAddress.get("Address Line2"), passPortAddress.get("Country"), passPortAddress.get("State"),
				passPortAddress.get("City"), passPortAddress.get("PostalCode"));

		/* Select Language */
		pages.additionalInfoPage.selectLanguage(additionalDetails.get("Language"));

		/* Click on Not to self identify Radio button */
		pages.additionalInfoPage.clkNotToSelfIdentify();

		/* Entering the SSNumber */
		pages.additionalInfoPage.setSSNnumber(additionalDetails.get("SSNNumber"));

		/* Click on No disability Radio button */
		pages.additionalInfoPage.clkNoDisablity();

		/* Filling Emergency details */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("AddressLine1"),
				emergencyContactDetails.get("AddressLine2"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Clicking on Continue button */
		pages.additionalInfoPage.clkContinue(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/* Validate education info page */
		pages.educationalInfoPage
				.validateEducationInfoPage("https://staging3.myhcl.com/iOnboard/Candidate/DataForm/EducationalInfo");

		/* Filling the Education details */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type"), educationDetails.get("SubType"),
				educationDetails.get("Discipline"), educationDetails.get("University"), educationDetails.get("Country"),
				educationDetails.get("From"), educationDetails.get("To"));

		/* Clicking on This is my Highest Education CheckBox */
		pages.educationalInfoPage.clkThisismyHighestEducationCheckbox();

		/* Click on Add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		/* Clicking on Education Edit under action button */
		pages.educationalInfoPage.clkEducationDetailsEditbtn();

		/* Filling the Education details */
		pages.educationalInfoPage.editEducationalDetails(educationDetails.get("Type"), educationDetails.get("SubType"),
				educationDetails.get("Discipline"), educationDetails.get("University"), educationDetails.get("Country"),
				educationDetails.get("From"), educationDetails.get("To"));

		/* Click on Educational Details Update button */
		pages.educationalInfoPage.clkEducationalDetailsUpdatebtn();

		/* Enter all the fields under Certification Details */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CertificateNumber"),
				certificationDetails.get("CertificateName"), certificationDetails.get("CertificateType"),
				certificationDetails.get("Grade"), certificationDetails.get("CertificateBody"),
				certificationDetails.get("From"), certificationDetails.get("To"));

		/* Click on Add details button */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		/* Clicking on Certification Edit under action button */
		pages.educationalInfoPage.clkCertificationDetailsEditbtn();

		/* Filling Certification details */
		pages.educationalInfoPage.editCertificationDetails(certificationDetails.get("CertificateNumber"),
				certificationDetails.get("CertificateName"), certificationDetails.get("CertificateType"),
				certificationDetails.get("Grade"), certificationDetails.get("CertificateBody"),
				certificationDetails.get("From"), certificationDetails.get("To"));

		/* Click on Certification Details Update button */
		pages.educationalInfoPage.clkCertificationDetailsUpdatebtn();

		/* Clicking on Continue Button */
		pages.educationalInfoPage.clickContinueBtn();

		/* Validate Employment details page */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		/* Clicking on Fresh Radio button */
		pages.employementdetailspage.clickFresherRadioButton();

		/* Clicking on Continue button */
		pages.employementdetailspage.clickContinueBtn();

		/* Preview Page */

		/* Clicks on all the Dropdown */
		pages.previewPage.clkExpandAllDd();

		/* Click on Personal Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("personalDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Address Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("addressDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Passport Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("passportDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Additional Information Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("additionalInformation"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Emergency Contact Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("emergencyContactDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Educational Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("educationalDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Certification Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("certificationDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Employment Details Edit icon */
		pages.previewPage.clkDetailsEditIcn(prop_app_constants.getProperty("employmentDetails"));

		/* Click on Preview icon */
		pages.previewPage.clkPreviewIcn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Read icon document */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* Click on Submit 1 Button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* Click on Submit 2 Button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* Click on Submit button */
		pages.previewPage.clkSubmitBtn();

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		WebActionUtil.waitForAngularPageToLoad();

		/* Click on Document Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Validate the Employee Handbook HCLA pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Document Check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Validate the Export Compliance Policy pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Document Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("policyAndProcedures"));

		/* Validate the Policy and Procedures pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("policyAndProcedures"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Document Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Validate the Sexual Harassment Policy pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Document Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employmentAgreement"));

		/* Validate the Employment Agreement pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("employmentAgreement"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Document Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Validate the CFIUS Security Policies pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Validating Preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Final Submit button */
		pages.previewPage.clkFinalSubmitBtn();

		/* Clicks on View Joining Form Link */
		pages.homePage.clkViewJoiningForm();

		/* Validate Tick icon */
		pages.previewPage.validateTickIcn();

		/* Validating Edit table and Click on Logout link */
		pages.previewPage.validateFormEditable();

		/* Click on Logout button */
		pages.previewPage.clkLogoutLnk();

		/* Deleting the cookies */
		driver.manage().deleteAllCookies();

		/* Enter QA login URL */
		driver.navigate().to(prop.getProperty("App_QAURL"));

		/************ QA Login ******************/
		new WebDriverWait(driver, 80).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

		/* Enter Username and Pasword in QA login page */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Clicks on Home link from the dropdown next to the smily */
		pages.esPage.validateHomeLink(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESUrl"));

		/* Clicks on iOnboard Joining Report link from the dropdown next to the smily */
		pages.esPage.validateiOnboardJoiningReport(prop_app_constants.getProperty("ionboardJoiningReport"),
				prop_app_constants.getProperty("roleES"), prop_app_constants.getProperty("expectedESUrl"),
				prop_app_constants.getProperty("ionboardJoiningReport"),
				prop_app_constants.getProperty("expectedJoiningReportDataUrl"));

		/*
		 * Clicks on Lateral Complete Report Report link from the dropdown next to the
		 * smily
		 */
		pages.esPage.validateLateralCompleteReportReport(prop_app_constants.getProperty("lateralCompleteReport"),
				prop_app_constants.getProperty("roleES"), prop_app_constants.getProperty("expectedESUrl"),
				prop_app_constants.getProperty("lateralCompleteReport"),
				prop_app_constants.getProperty("expectedLateralCompleteReportUrl"));

		/*
		 * Clicks on Lateral In Complete Report Report link from the dropdown next to
		 * the smily
		 */
		pages.esPage.validateLateralInCompleteReportReport(prop_app_constants.getProperty("lateralInCompleteReport"),
				prop_app_constants.getProperty("roleES"), prop_app_constants.getProperty("expectedESUrl"),
				prop_app_constants.getProperty("lateralInCompleteReport"),
				prop_app_constants.getProperty("expectedLateralInCompleteReportUrl"));

		/*
		 * Clicks on Transfer Complete Report Report link from the dropdown next to the
		 * smily
		 */
		pages.esPage.validateTransferCompleteReport(prop_app_constants.getProperty("transferCompleteReport"),
				prop_app_constants.getProperty("roleES"), prop_app_constants.getProperty("expectedESUrl"),
				prop_app_constants.getProperty("transferCompleteReport"),
				prop_app_constants.getProperty("expectedTransferCompleteReportUrl"));

		/* Click on User Manual */
		pages.esPage.clkUserManuel();

		/* click on Training PPT */
		pages.esPage.clkTrainingPPT();

		/* Click on FQA */
		pages.esPage.clkFQA(prop_app_constants.getProperty("expectedFQAUrl"));

		/* click on DashBoard Triangle */
		pages.esPage.clkDashBoardTriangle();

		/* Click on Filter */
		pages.esPage.clkFilter();

		/************ Recruiter(RMG) Page ******************/

		/* Change Role as Recruiter(RMG) */
		pages.recruiterPage.changeRole(prop_app_constants.getProperty("roleRMG"));

		/* Validate Role in dropdown */
		pages.recruiterPage.validateFields(prop_app_constants.getProperty("roleRMG"));

		/* Click on mail icon */
		pages.recruiterPage.clkMailIcon(candidateName);

		WebActionUtil.waitForAngularPageToLoad();
		/* Enter Name in Search bar */
		pages.recruiterPage.clkSearchBar(candidateName);

		/* Click Expert to Excel */
		pages.recruiterPage.clkExpertToExcel();

		/* Click Action icon */
		pages.recruiterPage.clkActionIcon(candidateName);

		/* click Did candidate Join dropdown */
		pages.recruiterPage.clkDidCandidateJoin();

		/* Select value as Yes */
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

		/* Click on Filter icon in ES page */
		pages.esPage.clkFilter();

		/* Enter CandidateName in Name text box */
		pages.esPage.setCandidateName(candidateName);

		/* Click Reset Button */
		pages.esPage.clkReset();

		/* Enter CandidateName in Name Text box */
		pages.esPage.setCandidateName(completeName);

		/* Click on search button */
		pages.esPage.clkSearch();

		/* Clicks on Search Bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Clicks on Action Icon */
		WebActionUtil.waitForAngularPageToLoad();
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validates ES Page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Selects Actual Date of Joining from Calnder Icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Selects an option from the Reason for Hiring Drop down */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("fresherHiringCampus"));

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
