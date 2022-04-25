package com.hcl.ionboard.testscripts;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
import com.hcl.ionboard.util.WebActionUtil;
/**
 * TestCaseId: TYSS_IOB_001
 * TestScript Name: TYSS_IOB_001
 * Description: Verify fresher Candidate Detail (without Passport details) have been pushed for SAP upload
 * 
 * Author: Vikas
 */
public class TYSS_IOB_001 extends BaseTest {

	@Test(description = "Description: Verify fresher Candidate Detail (without Passport details) have been pushed for SAP upload")
	public void TC_TYSS_IOB_001() {
		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_001",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_001",
				"PersonalDetails");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_001",
				"EmergencyContactDetails");
		Map<String, String[]> educationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_001",
				"EducationDetails");
		Map<String, String[]> certificationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH,
				"IOB_TC_001", "CertificationDetails");
		Map<String, String> addressDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_001",
				"AddressDetails");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		/***************************************************************************/

		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Validate home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* Click on joining form */
		pages.homePage.clkFillJoiningForm();

		/************ Joining Form Page ******************/

		/* validate the joining form page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		// String candidateName = "Santosh Kumar";
		/* Fetch the candidate name */
		String candidateName = pages.joiningFormPage.fetchName();

		/* Upload the profile picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fills the personal details fields */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));

		/* Fills The Fields under Permanent Address */
		pages.joiningFormPage.permanentAddress(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Click on my current address is my permanent address check box */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn((prop_app_constants.getProperty("expectedAdditionalInfoPageUrl")));

		/****************** Additional Info Page ************************/
		WebActionUtil.waitForAngularPageToLoad();
		/* Clicks on No radio button under passport details */
		pages.additionalInfoPage.clkNoPassportRb();

		pages.additionalInfoPage.selectLanguage("Arabic");

		/* Enter the emergency contact details */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("AddressLine1"),
				emergencyContactDetails.get("AddressLine2"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Click on continue button */
		pages.additionalInfoPage.clkContinue(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/**************** Educational Info Page *********************/
		/* Educational Info */
		pages.educationalInfoPage
				.validateEducationInfoPage(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/* Enter all the fields under educational details(Graduation) */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		/* Click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		/* Validate all the fields are cleared under educational details */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		String[] educationDetailsArraylist1 = new String[] { educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0] };
		ArrayList<String> lstExpectededucationDetailsArraylist1 = new ArrayList<>();
		for (int i = 0; i < educationDetailsArraylist1.length; i++) {
			lstExpectededucationDetailsArraylist1.add(educationDetailsArraylist1[i]);
		}

		/* Validate all the entered data present in the table */
		pages.educationalInfoPage.validateEducationalQualificationstable1(lstExpectededucationDetailsArraylist1);

		/* Enter all the fields under educational details(Graduation) */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		/* Click on This is my Highest Education check box */
		pages.educationalInfoPage.clkThisismyHighestEducationCheckbox();

		/* Click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		/* Validate all the fields are cleared under educational details */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		String[] educationDetailsArraylist2 = new String[] { educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1] };
		ArrayList<String> lstExpectededucationDetailsArraylist2 = new ArrayList<>();
		for (int i = 0; i < educationDetailsArraylist2.length; i++) {
			lstExpectededucationDetailsArraylist2.add(educationDetailsArraylist2[i]);
		}

		/* Validate all the entered data present in the table */
		pages.educationalInfoPage.validateEducationalQualificationstable1(lstExpectededucationDetailsArraylist1);

		/* Enter all the fields under Certification details (Certification1) */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0]);

		/* Click on Add Details button */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		/* Click on Continue button */
		pages.educationalInfoPage.clickContinueBtn();

		/************ Employment Details Page ******************/

		/* Validate Employment details page */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		/* Click on fresher radio button */
		pages.employementdetailspage.clickFresherRadioButton();

		/* Click on continue button */
		pages.employementdetailspage.clickContinueBtn();

		/**************** Preview Page ******************/
		WebActionUtil.waitForAngularPageToLoad();
		/* Click on Expand All the drop down of all the fields */
		pages.previewPage.clkExpandAllDd();

		/* Click on Voluantary Self Identification Lookup */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* Click on Submit button */
		pages.previewPage.clkSubmitBtn();

		WebActionUtil.waitForAngularPageToLoad();
		/* Click on Employee Handbook HCLA check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Validates Employee Handbook HCLA Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Export Compliance Policy check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Validates Export Compliance Policy Pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Export Compliance Policy check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("policyAndProcedures"));

		/* Validates Policy and Procedures Pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("policyAndProcedures"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Sexual Harassment Policy check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Validates Sexual Harassment Policy Pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Employment Agreement check box */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employmentAgreement"));

		/* Click on Employment Agreement check box */
//		pages.previewPage.validatePdf(prop_app_constants.getProperty("employmentAgreement"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on cFIUS Security Policies checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Validates cFIUS Security Policies Pdf file */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		WebActionUtil.waitForAngularPageToLoad();
		/* Click on final Submit button */
		pages.previewPage.clkFinalSubmitBtn();

		/* Click view joining form */
		pages.homePage.clkViewJoiningForm();

		/* Validate if The Icon is tick */
		pages.previewPage.validateTickIcn();

		/* validates the form editable */
		pages.previewPage.validateFormEditable();

		/* Click on Logout link */
		pages.previewPage.clkLogoutLnk();

		/* Deleting the cookies */
		driver.manage().deleteAllCookies();

		/***** QA Login ******/

		driver.navigate().to(prop.getProperty("App_QAURL"));
		new WebDriverWait(driver, 80).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

		/* Enter Username and Password in QA login page */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Validates DashBoard And Joining Console Page */
		pages.esPage.validateDashBoardAndJoingConsolePage(prop_app_constants.getProperty("expectedDashboardText"),
				prop_app_constants.getProperty("expectedJoiningConsoleText"),
				prop_app_constants.getProperty("expectedDashboardAndJoiningConsolePageUrl"),
				prop_app_constants.getProperty("roleES"));

		/* Validates the Roles */
		pages.recruiterPage.validateRoles();

		/************ Recruiter(RMG) Page ******************/

		/* Change role to RMG */
		pages.recruiterPage.changeRole(prop_app_constants.getProperty("roleRMG"));

		/* Validates the fields in Recruiter page */
		pages.recruiterPage.validateFields(prop_app_constants.getProperty("roleRMG"));

		/* Click on Search Bar */
		pages.recruiterPage.clkSearchBar(candidateName);

		/* validates Joining Form Status */
		pages.recruiterPage.validateJoiningFormStatus(candidateName);

		/* Click on Mail Icon */
		pages.recruiterPage.clkMailIcon(candidateName);

		/* Clicks on Action Icon */
		pages.recruiterPage.clkActionIcon(candidateName);

		/* Clicks on did candidate join drop down */
		pages.recruiterPage.clkDidCandidateJoin();

		/* Select yes from the Did Candidate Join drop down */
		pages.recruiterPage.selectYesDd();

		/* Click on Submit button */
		pages.recruiterPage.clkSubmitButton(prop_app_constants.getProperty("expectedRecruiterUrl"));

		/************ ES Role Page ******************/

		/* Validates the Roles */
		pages.esPage.validateRoles();

		/* Change role to ES */
		pages.esPage.changeRole(prop_app_constants.getProperty("roleES"));

		/* Validates the fields in ES page */
		pages.esPage.validateFields();

		/* Clicks on Search Bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Clicks on Action icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validates ES page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Selects Actual Date of Joining from calendar icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Selects an option from the Reason for Hiring drop down */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("fresherHiringOffCampus"));

		/* Enter the remarks in Remarks text field */
		pages.esPage.setRemark(prop_app_constants.getProperty("approveRemark"));

		/* Click on Submit button */
		pages.esPage.clkSubmit();

		/* Validates ES status */
		pages.esPage.validateESStatus(loginDetails.get("CandidateId"));

		/* Logout from the application */
		pages.qaLogoutPage.logoutToApplication();

	}

}
