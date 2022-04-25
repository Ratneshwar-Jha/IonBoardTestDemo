package com.hcl.ionboard.testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;
import com.hcl.ionboard.commonutil.ExcelUtil;
/**
 * TestCaseId: TYSS_IOB_002
 * TestScript Name: TYSS_IOB_002
 * Description: Verify the experience candidate details(with passport with visa)have been pushed for SAP upload
 * 
 * Author: Suganthini
 */
public class TYSS_IOB_002 extends BaseTest {

	@Test(description = "Description: Verify the experience candidate details(with passport with visa)have been pushed for SAP upload")
	public void TC_TYSS_IOB_002() {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"PersonalDetails");
		Map<String, String> passportDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"PassportDetails");
		Map<String, String> visaDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"VisaDetails");
		Map<String, String> addressOfPassport = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"AddressOfPassport");
		Map<String, String> additionalInfo = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"AdditionalInfo");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"EmergencyContactDetails");
		Map<String, String> addressDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_002",
				"AddressDetails");

		Map<String, String[]> educationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_002",
				"EducationDetails");
		Map<String, String[]> certificationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH,
				"IOB_TC_002", "CertificationDetails");
		Map<String, String[]> employmentDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_002",
				"EmploymentDetails");

		/* Enter user name and Password for Candidate Login */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* Validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* Validate Fill Joining Form */
		pages.homePage.clkFillJoiningForm();

		/****** JoiningFormPage **********/

		// String candidateName="Chatrapathi K";
		// ArrayList<String> expectedPersonalData=new ArrayList<String> ();
		// expectedPersonalData.add("Chatrapathi");
		// expectedPersonalData.add("K");
		// expectedPersonalData.add("Male");

		/* validates the Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* fetch name */
		String candidateName = pages.joiningFormPage.fetchName();

		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* Fills The Personal Details Fields */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("Citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));
		ArrayList<String> expectedPersonalData = pages.joiningFormPage.getData();

		/* Fills The Fields under Permanent Address */
		pages.joiningFormPage.permanentAddress(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Click on my current address is my permanent address check box */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/*** AdditionalInfoPage ***/

		/* Click Yes Radio Button */
		pages.additionalInfoPage.clkYesPassportRb();

		/* Enter Passport details */
		pages.additionalInfoPage.setPassportFields(passportDetails.get("PassportNumber"),
				passportDetails.get("PlaceOfIssue"), passportDetails.get("IssuingAuthority"),
				passportDetails.get("DateOfIssue"), passportDetails.get("DateOfExpiry"));

		/* Select yes radio button in visa */
		pages.additionalInfoPage.clkYesVisaRb();

		/* Enter visa details */
		pages.additionalInfoPage.setVisaFields(visaDetails.get("VisaCountry"), visaDetails.get("TypeOfVisa"),
				visaDetails.get("VisaFrom"), visaDetails.get("VisaTo"));

		/* Enter Passport Address */
		pages.additionalInfoPage.setPassportAddress(addressOfPassport.get("CO"), addressOfPassport.get("AddressLine1"),
				addressOfPassport.get("AddressLine2"), addressOfPassport.get("Country"), addressOfPassport.get("State"),
				addressOfPassport.get("City"), addressOfPassport.get("PostalCode"));

		/* Select Language */
		pages.additionalInfoPage.selectLanguage(additionalInfo.get("Language"));

		pages.additionalInfoPage.setSSNnumber(additionalInfo.get("SSNNumber"));

		/* Enter Emergency ContanctDetails */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("AddressLine1"),
				emergencyContactDetails.get("AddressLine2"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* Click on Continue button */
		pages.additionalInfoPage.clkContinue(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/**** Education Page ****/

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

		/**** Employment Page ****/
		// WebActionUtil.waitForAngularPageToLoad();

		/* validate employment details page */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		pages.employementdetailspage.clickExperiencedRadioButton();

		/* Enter Employer name */
		pages.employementdetailspage.settypeOfEmployee(employmentDetails.get("Employer")[0]);

		/* Select industry */
		pages.employementdetailspage.settypeOfindustry(employmentDetails.get("Industry")[0]);

		/* Select Country */
		pages.employementdetailspage.settypeOfcountry(employmentDetails.get("Country")[0]);

		/* Enter city name */
		pages.employementdetailspage.settypeOfCity(employmentDetails.get("City")[0]);

		/* Enter designation on joining */
		pages.employementdetailspage.settypeOfDesignationOnJoining(employmentDetails.get("DesignationOnJoining")[0]);

		/* Enter designation at present */
		pages.employementdetailspage.settypeOfDesignationatPresentExit(employmentDetails.get("DesignatiOnPresent")[0]);

		/* Enter From date */
		pages.employementdetailspage.setFromdate(employmentDetails.get("From")[0]);

		/* Enter to date */
		pages.employementdetailspage.setTodate(employmentDetails.get("To")[0]);

		/* Click on add details button */
		pages.employementdetailspage.clickAddDetailsBtn();

		String[] employmentDetailsArraylist1 = new String[] { employmentDetails.get("Employer")[0],
				employmentDetails.get("Industry")[0], employmentDetails.get("Country")[0],
				employmentDetails.get("City")[0], employmentDetails.get("DesignationOnJoining")[0],
				employmentDetails.get("DesignatiOnPresent")[0], employmentDetails.get("From")[0],
				employmentDetails.get("To")[0] };
		ArrayList<String> expectedEmploymentDetails1 = new ArrayList<String>(
				Arrays.asList(employmentDetailsArraylist1));

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable1(expectedEmploymentDetails1);

		/* validate Employment details form is cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* Enter Employer name */
		pages.employementdetailspage.settypeOfEmployee(employmentDetails.get("Employer")[1]);

		/* Select industry */
		pages.employementdetailspage.settypeOfindustry(employmentDetails.get("Industry")[1]);

		/* Select Country */
		pages.employementdetailspage.settypeOfcountry(employmentDetails.get("Country")[1]);

		/* Enter city name */
		pages.employementdetailspage.settypeOfCity(employmentDetails.get("City")[1]);

		/* Enter designation on joining */
		pages.employementdetailspage.settypeOfDesignationOnJoining(employmentDetails.get("DesignationOnJoining")[1]);

		/* Enter designation at present */
		pages.employementdetailspage.settypeOfDesignationatPresentExit(employmentDetails.get("DesignatiOnPresent")[1]);

		/* Enter From date */
		pages.employementdetailspage.setFromdate(employmentDetails.get("From")[1]);

		/* Enter to date */
		pages.employementdetailspage.setTodate(employmentDetails.get("To")[1]);

		/* Select My current company checkbox */
		pages.employementdetailspage.clickcMyCurrentCompanyCheckBox();

		/* Click on add details button */
		pages.employementdetailspage.clickAddDetailsBtn();

		String[] employmentDetailsArraylist2 = new String[] { employmentDetails.get("Employer")[1],
				employmentDetails.get("Industry")[1], employmentDetails.get("Country")[1],
				employmentDetails.get("City")[1], employmentDetails.get("DesignationOnJoining")[1],
				employmentDetails.get("DesignatiOnPresent")[1], employmentDetails.get("From")[1],
				employmentDetails.get("To")[1] };
		ArrayList<String> expectedEmploymentDetails2 = new ArrayList<String>(
				Arrays.asList(employmentDetailsArraylist2));

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable2(expectedEmploymentDetails2);

		/* validate Employment details form is cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* Click on continue Button */
		pages.employementdetailspage.clickContinueBtn();

		/***** Preview page ******/
		/* Validate preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on All the Expand Dropdown of all the fields */
		WebActionUtil.waitForAngularPageToLoad();
		pages.previewPage.clkExpandAllDd();

		/* Click on Voluantary Self Identification Lookup */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* validate personal details */
		pages.previewPage.validateDataInForm(expectedPersonalData);

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

		/* Closes the current tab and validate the preview page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		/* Click on cFIUS Security Policies Checkbox */
		pages.previewPage.clkDocumentCb(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Validates cFIUS Security Policies Pdf File */
		pages.previewPage.validatePdf(prop_app_constants.getProperty("cFIUSSecurityPolicies"));

		/* Closes the current Tab */
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

		/* Enter Username and password for QA login */
		pages.qALoginPage.loginToApplication(loginDetails.get("QaId"), loginDetails.get("QaPwd"));

		/* Validate Dashboard and JoingConsolePage */
		pages.esPage.validateDashBoardAndJoingConsolePage(prop_app_constants.getProperty("expectedDashboardText"),
				prop_app_constants.getProperty("expectedJoiningConsoleText"),
				prop_app_constants.getProperty("expectedDashboardAndJoiningConsolePageUrl"),
				prop_app_constants.getProperty("roleES"));

		/******* recruiterPage *********/

		/* Validate RM,Recruiter and Tag manager role **/
		pages.recruiterPage.validateRoles();

		/* Change role to Recruiter */
		pages.recruiterPage.changeRole(prop_app_constants.getProperty("roleRMG"));

		/* Validate Recruiter page fields */
		pages.recruiterPage.validateFields(prop_app_constants.getProperty("roleRMG"));

		/* validate Joining Form status */
		pages.recruiterPage.validateJoiningFormStatus(candidateName);

		/* Click on mail Icon */
		pages.recruiterPage.clkMailIcon(candidateName);

		/* Click on Action Icon */
		pages.recruiterPage.clkActionIcon(candidateName);

		/* Click Did candidate join drop down */
		pages.recruiterPage.clkDidCandidateJoin();

		/* Select yes option */
		pages.recruiterPage.selectYesDd();

		/* Click Submit button */
		pages.recruiterPage.clkSubmitButton(prop_app_constants.getProperty("expectedRecruiterUrl"));

		/***** Es page ********/

		/* Validate ES,RM and Tag manager role **/
		pages.esPage.validateRoles();

		/* Change role to ES */
		pages.esPage.changeRole(prop_app_constants.getProperty("roleES"));

		/* Validate ES page fields */
		pages.esPage.validateFields();

		/* Enter CandidateId in search box */
		pages.esPage.clkSearchBar(loginDetails.get("CandidateId"));

		/* Click on Action Icon */
		pages.esPage.clkAction(loginDetails.get("CandidateId"));

		/* Validate ES page */
		pages.esPage.validateESPage(prop_app_constants.getProperty("roleES"),
				prop_app_constants.getProperty("expectedESInformationUrl"));

		/* click actual DOJ and select date */
		pages.esPage.selectActualDOJ(prop_app_constants.getProperty("actualDOJ"));

		/* Select reason for Hiring */
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("reasonForHiring"));

		/* Enter remarks */
		pages.esPage.setRemark(prop_app_constants.getProperty("approveRemark"));

		/* Click on SapUpload button */
		pages.esPage.clkSubmit();

		/* Validates ES Status */
		pages.esPage.validateESStatus(loginDetails.get("CandidateId"));

		/* Logout from the application */
		pages.qaLogoutPage.logoutToApplication();

	}

}
