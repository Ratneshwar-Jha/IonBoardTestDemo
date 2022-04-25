package com.hcl.ionboard.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;

/**
 * TestCaseId: TYSS_IOB_003
 * TestScript Name: TYSS_IOB_003
 * Description: Verify that Experience Candidate Detail (with Passport without Visa) have been
 * pushed for SAP upload.
 * 
 * Author: Manish Kumar C D
 */

public class TYSS_IOB_003 extends BaseTest {
	@Test(description = "Description: Verify Experience Candidate Detail (with Passport without Visa) have been pushed for SAP upload")
	public void TC_TYSS_IOB_003() {

		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"PersonalDetails");
		Map<String, String> addressDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"AddressDetails");
		Map<String, String> passPortDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"PassportDetails");
		Map<String, String> visaDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"VisaDetails");
		Map<String, String> additionalInfo = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"AdditionalInfo");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_003",
				"EmergencyContactDetails");
		Map<String, String[]> educationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_003",
				"EducationDetails");
		Map<String, String[]> certificationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH,
				"IOB_TC_003", "CertificationDetails");
		Map<String, String[]> employmentDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_003",
				"EmploymentDetails");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		/* Login with Candidate Credentials */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Validate home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* Click on Fill Joining Form */
		pages.homePage.clkFillJoiningForm();

		/************ Joining Form Page ******************/

		/* validates the Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Fetch Name from Joining Form Page */
		String candidateName = pages.joiningFormPage.fetchName();

		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fills The Personal Details Fields */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));

		/* Fills The Fields under Permanent Address */
		pages.joiningFormPage.permanentAddress(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Click on My Current Address Is My Permanent Address Check box */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/************ Additional Info Page ******************/

		/* Clicks on Yes Radio button under Passport Details */
		pages.additionalInfoPage.clkYesPassportRb();

		/* Enters the Passport Fields Details */
		pages.additionalInfoPage.setPassportFields(passPortDetails.get("PassportNumber"),
				passPortDetails.get("PlaceOfIssue"), passPortDetails.get("IssuingAuthority"),
				passPortDetails.get("DateOfIssue"), passPortDetails.get("DateOfExpiry"));

		/* Clicks on No Radio button in Do You have Visa */
		// pages.additionalInfoPage.clkNoVisaRb();

		/* Click on Same As Permanent RadioButton */
		pages.additionalInfoPage.clkSameAsPermanentRb(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Select a Language from Language Drop down */
		pages.additionalInfoPage.selectLanguage(additionalInfo.get("Language"));

		/* Click on I am not a protected Veteran Radio Button */
		pages.additionalInfoPage.clkNotProtectedVeteran();

		/* Mouse hovers on Veteran Information Icon */
		pages.additionalInfoPage.mouseOverVeterans();

		/* Enter the SSN number in SSN Number Text field */
		pages.additionalInfoPage.setSSNnumber(additionalInfo.get("SSNNumber"));

		/* Click on Yes, I have Disability */
		pages.additionalInfoPage.clkYesDisablity("disbalityType");

		/************ Emergency Contact Details ******************/

		/* Enter the Emergency Contact Details in their repective fields */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("AddressLine1"), emergencyContactDetails.get("AddressLine2"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Click on Continue Button */
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

		/* click on This is my Highest Education Check box */
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

		/* Click on Add Details button */
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

		/* Click on Add Details button */
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

		/************ Employment Details Page ******************/

		/* valdidates Employment Details HeadText */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		/* Click on Experienced Radio Button */
		pages.employementdetailspage.clickExperiencedRadioButton();

		/* Enter the Employee Name in Employer Textbox */
		pages.employementdetailspage.settypeOfEmployee(employmentDetails.get("Employer")[0]);

		/* Select the Industry from Industry Dropdown */
		pages.employementdetailspage.settypeOfindustry(employmentDetails.get("Industry")[0]);

		/* Select the Country from Country Dropdown */
		pages.employementdetailspage.settypeOfcountry(employmentDetails.get("Country")[0]);

		/* Enter the City name in City TextBox */
		pages.employementdetailspage.settypeOfCity(employmentDetails.get("City")[0]);

		/* Enter the Designation name in Designation TextBox */
		pages.employementdetailspage.settypeOfDesignationOnJoining(employmentDetails.get("DesignationOnJoining")[0]);

		/*
		 * Enter the Designation Present/Exit name in Designation Present/Exit TextBox
		 */
		pages.employementdetailspage.settypeOfDesignationatPresentExit(employmentDetails.get("DesignatiOnPresent")[0]);

		/* Enter the From date in From date calender */
		pages.employementdetailspage.setFromdate(employmentDetails.get("From")[0]);

		/* Enter the To date in To date calender */
		pages.employementdetailspage.setTodate(employmentDetails.get("To")[0]);

		/* Click on Add details Button */
		pages.employementdetailspage.clickAddDetailsBtn();

		String[] employmentDetailsArraylist1 = new String[] { employmentDetails.get("Employer")[0],
				employmentDetails.get("Industry")[0], employmentDetails.get("Country")[0],
				employmentDetails.get("City")[0], employmentDetails.get("DesignationOnJoining")[0],
				employmentDetails.get("DesignatiOnPresent")[0], employmentDetails.get("From")[0],
				employmentDetails.get("To")[0] };
		ArrayList<String> lstExpectedEmploymentDetailsArraylist1 = new ArrayList<>();
		for (int i = 0; i < employmentDetailsArraylist1.length; i++) {
			lstExpectedEmploymentDetailsArraylist1.add(employmentDetailsArraylist1[i]);
		}

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable1(lstExpectedEmploymentDetailsArraylist1);

		/* validate Employee Details form cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* Enter the Employee Name in Employer Textbox */
		pages.employementdetailspage.settypeOfEmployee(employmentDetails.get("Employer")[1]);

		/* Select the Industry from Industry Dropdown */
		pages.employementdetailspage.settypeOfindustry(employmentDetails.get("Industry")[1]);

		/* Select the Country from Country Dropdown */
		pages.employementdetailspage.settypeOfcountry(employmentDetails.get("Country")[1]);

		/* Enter the City name in City TextBox */
		pages.employementdetailspage.settypeOfCity(employmentDetails.get("City")[1]);

		/* Enter the Designation name in Designation TextBox */
		pages.employementdetailspage.settypeOfDesignationOnJoining(employmentDetails.get("DesignationOnJoining")[1]);

		/*
		 * Enter the Designation Present/Exit name in Designation Present/Exit TextBox
		 */
		pages.employementdetailspage.settypeOfDesignationatPresentExit(employmentDetails.get("DesignatiOnPresent")[1]);

		/* Enter the From date in From date calender */
		pages.employementdetailspage.setFromdate(employmentDetails.get("From")[1]);

		/* Enter the To date in To date calender */
		pages.employementdetailspage.setTodate(employmentDetails.get("To")[1]);

		/* Click on My Current Company CheckBox */
		pages.employementdetailspage.clickcMyCurrentCompanyCheckBox();

		/* Click on Add details Button */
		pages.employementdetailspage.clickAddDetailsBtn();

		String[] employmentDetailsArraylist2 = new String[] { employmentDetails.get("Employer")[1],
				employmentDetails.get("Industry")[1], employmentDetails.get("Country")[1],
				employmentDetails.get("City")[1], employmentDetails.get("DesignationOnJoining")[1],
				employmentDetails.get("DesignatiOnPresent")[1], employmentDetails.get("From")[1],
				employmentDetails.get("To")[1] };
		ArrayList<String> lstExpectedEmploymentDetailsArraylist2 = new ArrayList<>();
		for (int i = 0; i < employmentDetailsArraylist2.length; i++) {
			lstExpectedEmploymentDetailsArraylist2.add(employmentDetailsArraylist2[i]);
		}

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable2(lstExpectedEmploymentDetailsArraylist2);

		/* validate Employee Details form cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* Click on Continue button */
		pages.employementdetailspage.clickContinueBtn();

		/************ Preview Page ******************/

		/* Click on All the Expand Dropdown of all the fields */
		pages.previewPage.clkExpandAllDd();

		/* Click on Voluantary Self Identification Lookup */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* Click on I have Read and Understood Checkbox and Clicks on Submit Button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* Click on Submit Button */
		pages.previewPage.clkSubmitBtn();

		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

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

		/* Clicks on View Joining Form Link */
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

		driver.navigate().to(prop.getProperty("App_QAURL"));
		new WebDriverWait(driver, 90).until(ExpectedConditions.urlToBe(prop.getProperty("App_QAURL")));

		/* Enter Username and Password in QA Login Page */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Validates DashBoard And Joining Console Page */
		pages.esPage.validateDashBoardAndJoingConsolePage(prop_app_constants.getProperty("expectedDashboardText"),
				prop_app_constants.getProperty("expectedJoiningConsoleText"),
				prop_app_constants.getProperty("expectedDashboardAndJoiningConsolePageUrl"),
				prop_app_constants.getProperty("roleES"));

		/* Validates the Roles */
		pages.recruiterPage.validateRoles();

		/************ Recruiter(RMG) Page ******************/

        //String candidateName="John Mac";

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
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("fresherHiringCampus"));

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
