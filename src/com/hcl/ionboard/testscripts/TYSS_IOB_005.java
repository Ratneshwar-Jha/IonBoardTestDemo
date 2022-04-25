package com.hcl.ionboard.testscripts;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
/**
 * TestCaseId: TYSS_IOB_005
 * TestScript Name: TYSS_IOB_005
 * Description: Verify Fresher candidate details(With passport and without Visa)has been pushed for SAP upload
 * 
 * Author: Vivek
 */
public class TYSS_IOB_005 extends BaseTest {
	@Test(description = "Description: Verify Fresher candidate details(With passport and without Visa)has been pushed for SAP upload")
	public void TC_TYSS_IOB_005() {

		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"PersonalDetails");
		Map<String, String> passPortDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"PassportDetails");
		Map<String, String> passportAddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"PassportAddress");
		Map<String, String> additionalInfo = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"AdditionalInfo");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"EmergencyContactDetails");
		Map<String, String[]> educationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_005",
				"EducationDetails");
		Map<String, String[]> certificationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH,
				"IOB_TC_005", "CertificationDetails");
		Map<String, String> permanentaddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"PermanentAddress");
		Map<String, String> currentaddress = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_005",
				"CurrentAddress");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		/* log in as candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));
		/* Validate home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));
		/* click on fill joining form */
		pages.homePage.clkFillJoiningForm();
		/* joining Personal details */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Fetch Name from Joining Form Page */
		String candidateName = pages.joiningFormPage.fetchName();

		// String candidateName="Akash Johri";
		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fills The Personal Details Fields */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));

		/* Set the fields Under permanent Address */
		pages.joiningFormPage.permanentAddress(permanentaddress.get("C/O"), permanentaddress.get("Address Line1"),
				permanentaddress.get("Address Line2"), permanentaddress.get("Country"), permanentaddress.get("State"),
				permanentaddress.get("City"), permanentaddress.get("PostalCode"));

		/* Set the fields Under current Address */
		pages.joiningFormPage.currentAddress(currentaddress.get("C/O"), currentaddress.get("Address Line1"),
				currentaddress.get("Address Line2"), currentaddress.get("Country"), currentaddress.get("State"),
				currentaddress.get("City"), currentaddress.get("PostalCode"));

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/* Additional Info */

		/* Click on Passport Radio Button */
		pages.additionalInfoPage.clkYesPassportRb();
		/* Set Passport fields */
		pages.additionalInfoPage.setPassportFields(passPortDetails.get("PassportNumber"),
				passPortDetails.get("PlaceOfIssue"), passPortDetails.get("IssuingAuthority"),
				passPortDetails.get("DateOfIssue"), passPortDetails.get("DateOfExpiry"));

		/* Click on No Visa Radio Button */
		// pages.additionalInfoPage.clkNoVisaRb();

		/* Set Passport Address */
		pages.additionalInfoPage.setPassportAddress(passportAddress.get("C/O"), passportAddress.get("Address Line1"),
				passportAddress.get("Address Line2"), passportAddress.get("Country"), passportAddress.get("State"),
				passportAddress.get("City"), passportAddress.get("PostalCode"));
		/* select Language */
		pages.additionalInfoPage.selectLanguage(additionalInfo.get("Language"));
		/* Click protected Veteran */
		pages.additionalInfoPage.clkProtectedVeteran();
		/* set SSNumber */
		pages.additionalInfoPage.setSSNnumber(additionalInfo.get("SSNNumber"));
		/* click No Disability */
		pages.additionalInfoPage.clkNoDisablity();
		/* set Emergency Contact Details */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("AddressLine1"), emergencyContactDetails.get("AddressLine2"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* click Continue Button */
		pages.additionalInfoPage.clkContinue(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/************ Educational Info Page ******************/

		/* Educational Info */
		pages.educationalInfoPage
				.validateEducationInfoPage(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/* Enter all the fields under Educational Details(Graduation) */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		/* Click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		String[] educationDetailsArraylist1 = new String[] { educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0] };
		ArrayList<String> lstExpectededucationDetailsArraylist1 = new ArrayList<>();
		for (int i = 0; i < educationDetailsArraylist1.length; i++) {
			lstExpectededucationDetailsArraylist1.add(educationDetailsArraylist1[i]);
		}

		/* Validate all the entered data present in the table */
		pages.educationalInfoPage.validateEducationalQualificationstable1(lstExpectededucationDetailsArraylist1);

		/* Validate all the fields are cleared under educational details */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		/* Enter all the fields under Educational Details (Post Graduation) */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		/* click on This is my Highest Education Checkbox */
		pages.educationalInfoPage.clkThisismyHighestEducationCheckbox();

		/* Click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		String[] educationDetailsArraylist2 = new String[] { educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1] };
		ArrayList<String> lstExpectededucationDetailsArraylist2 = new ArrayList<>();
		for (int i = 0; i < educationDetailsArraylist2.length; i++) {
			lstExpectededucationDetailsArraylist2.add(educationDetailsArraylist2[i]);
		}

		/* Validate all the entered data present in the table */
		pages.educationalInfoPage.validateEducationalQualificationstable2(lstExpectededucationDetailsArraylist2);

		/* Validate all the fields are cleared under educational details */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		/************ Certification Details ******************/

		/* Enter all the fields under Certification Details(Certification1) */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0]);

		/* Click on Add Details Button */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		String[] certificationDetailsArraylist1 = new String[] { certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0] };
		ArrayList<String> lstExpectedcertificationDetailsArraylist1 = new ArrayList<>();
		for (int i = 0; i < certificationDetailsArraylist1.length; i++) {
			lstExpectedcertificationDetailsArraylist1.add(certificationDetailsArraylist1[i]);
		}

		/* validate Certification Qualifications table */
		pages.educationalInfoPage.validateCertificationQualificationstable1(lstExpectedcertificationDetailsArraylist1);

		/* validates Certification Details is Cleared */
		pages.educationalInfoPage.validateCertificationDetailsCleared(certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0]);

		/* Enter all the fields under Certification Details(Certification2) */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1]);

		/* Click on Add Details Button */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		String[] certificationDetailsArraylist2 = new String[] { certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1] };
		ArrayList<String> lstExpectedcertificationDetailsArraylist2 = new ArrayList<>();
		for (int i = 0; i < certificationDetailsArraylist2.length; i++) {
			lstExpectedcertificationDetailsArraylist2.add(certificationDetailsArraylist2[i]);
		}

		/* validates Certification Qualifications table */
		pages.educationalInfoPage.validateCertificationQualificationstable2(lstExpectedcertificationDetailsArraylist2);

		/* validates Certification Qualifications Details Cleared */
		pages.educationalInfoPage.validateCertificationDetailsCleared(certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1]);

		/* Click on Continue Button */
		pages.educationalInfoPage.clickContinueBtn();

		/************ Employment details ******************/

		/* Validate Employment page */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		/* Click Fresher Radio Button */
		pages.employementdetailspage.clickFresherRadioButton();

		/* Click Continue Btn */
		pages.employementdetailspage.clickContinueBtn();

		/************ Preview Page ******************/

		/* Click on Voluantary Self Identification Lookup */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* Click on Submit Button */
		pages.previewPage.clkSubmitBtn();

		WebActionUtil.waitForAngularPageToLoad();
		/* Click on Employee Handbook HCLA Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Validates Employee Handbook HCLA Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("employeeHandbookHCLA"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Export Compliance Policy Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Validates Export Compliance Policy Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("exportCompliancePolicy"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Export Compliance Policy Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("policyAndProcedures"));

		/* Validates Policy and Procedures Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("policyAndProcedures"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Sexual Harassment Policy Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Validates Sexual Harassment Policy Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("sexualHarassmentPolicy"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on Employment Agreement Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("employmentAgreement"));

		/* Validates Employment Agreement Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("employmentAgreement"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on cFIUS Security Policies Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Validates cFIUS Security Policies Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Closes the current Tab */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on final Submit Button */
		pages.previewPage.clkFinalSubmitBtn();

		/* Click view joining form */
		pages.homePage.clkViewJoiningForm();

		/* Validate if The Icon is Tick */
		pages.previewPage.validateTickIcn();

		/* validates the Form Editable */
		pages.previewPage.validateFormEditable();

		/* Click on Logout Link */
		pages.previewPage.clkLogoutLnk();

		/* Deleting the cookies */
		driver.manage().deleteAllCookies();

		/************ QA Login Page ******************/
		// String candidateName="Akash Johri";
		driver.navigate().to(prop.getProperty("App_QAURL"));
		new WebDriverWait(driver, 90).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

		/* Enter Username and Pasword in QA login page */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Validates DashBoard And Joining Console Page */
		pages.esPage.validateDashBoardAndJoingConsolePage(prop_app_constants.getProperty("expectedDashboardText"),
				prop_app_constants.getProperty("expectedJoiningConsoleText"),
				prop_app_constants.getProperty("expectedDashboardAndJoiningConsolePageUrl"),
				prop_app_constants.getProperty("roleES"));

		/* Validates the Roles */
		pages.recruiterPage.validateRoles();

		/************ Recruiter(RMG) Page ******************/

		/* Switches the Role to Recruiter(RMG) */
		pages.recruiterPage.changeRole(prop_app_constants.getProperty("roleRMG"));

		/* Validates the fields in Recruiter Page */
		pages.recruiterPage.validateFields(prop_app_constants.getProperty("roleRMG"));

		/* validates Joining Form Status */
		pages.recruiterPage.validateJoiningFormStatus(candidateName);

		/* Clicks on Mail Icon */
		pages.recruiterPage.clkMailIcon(candidateName);

		/* Clicks on Action Icon */
		pages.recruiterPage.clkActionIcon(candidateName);

		/* Clicks on Did Candidate Join dropdoown */
		pages.recruiterPage.clkDidCandidateJoin();

		/* Select yes from the Did Candidate Join dropdown */
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

		/* Clicks on Search Bar */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Clicks on Action Icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validates ES Page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* Selects Actual Date of Joining from Calender Icon */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Selects an option from the Reason for Hiring Dropdown */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("reasonForHiring"));

		/* Enters the Remarks in Remarks textfield */
		pages.esPage.setRemark(prop_app_constants.getProperty("approveRemark"));

		/* Click on Submit Button */
		pages.esPage.clkSubmit();

		/* Validates ES Status */
		pages.esPage.validateESStatus(loginDetails.get("CandidateId"));

		/* Logout from the application */
		pages.qaLogoutPage.logoutToApplication();

	}
}
