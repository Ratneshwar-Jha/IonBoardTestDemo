package com.hcl.ionboard.testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.baseutil.InitializePages;

/**
 * TestCaseId: TYSS_IOB_004 
 * TestScript Name: TYSS_IOB_004 
 * Description: Verify the candidate details has been pushed to SAP upload after being saved as
 * drafts
 * 
 * Author: Abhilash B
 */
public class TYSS_IOB_004 extends BaseTest {
	@Test(description = "Description: Verify the candidate details has been pushed to SAP upload after being saved as drafts")
	public void TC_TYSS_IOB_004() {
		Map<String, String> loginDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"LoginDetails");
		Map<String, String> personalDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"PersonalDetails");
		Map<String, String> addressDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"AddressDetails");
		Map<String, String> passPortDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"PassportDetails");
		Map<String, String> visaDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"VisaDetails");
		Map<String, String> additionalInfo = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"AdditionalInfo");
		Map<String, String> emergencyContactDetails = WebActionUtil.getSingleRowDataWithHeader(EXCELPATH, "IOB_TC_004",
				"EmergencyContactDetails");
		Map<String, String[]> educationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_004",
				"EducationDetails");
		Map<String, String[]> certificationDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH,
				"IOB_TC_004", "CertificationDetails");
		Map<String, String[]> employmentDetails = WebActionUtil.getMultipleRowsDataWithHeader(EXCELPATH, "IOB_TC_004",
				"EmploymentDetails");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		// String candidateName="Paruri Praveena";
		// ArrayList<String> expectedPersonalData=new ArrayList<String> ();
		// expectedPersonalData.add("Paruri");
		// expectedPersonalData.add("Praveena");
		// expectedPersonalData.add("Male");

		/************ candidate login ******************/

		/* log in as candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* click on fill joining form */
		pages.homePage.clkFillJoiningForm();

		/************ Personal Details ******************/

		/* validates the Joining Form Page */
		pages.joiningFormPage.validateJoiningFormPage(prop_app_constants.getProperty("expectedJoiningFormPageUrl"));

		/* Fetch Name from Joining Form Page */
		String candidateName = pages.joiningFormPage.fetchName();

		/* Uploads the Profile Picture */
		pages.joiningFormPage
				.uploadProfileImage(WebActionUtil.getSampleFilePath(prop_app_constants.getProperty("fileFormat_jpg")));

		/* enter personal details */
		pages.joiningFormPage.personalDetails(personalDetails.get("Title"), personalDetails.get("MiddleName"),
				personalDetails.get("PreferredName"), personalDetails.get("Gender"),
				personalDetails.get("PlaceOfBirth"), personalDetails.get("DateOfBirth"),
				personalDetails.get("MaritalStatus"), personalDetails.get("Nationality"),
				personalDetails.get("citizenship"), personalDetails.get("EthnicOrigin"), personalDetails.get("Race"));

		ArrayList<String> expectedPersonalData = pages.joiningFormPage.getData();
		/* Fills The Fields under Permanent Address */
		pages.joiningFormPage.permanentAddress(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* Click on My Current Address Is My Permanent Address Checkbox */
		pages.joiningFormPage.clkMyCurrentAddressIsMyPermanentAddressCb();

		/* Click on Continue Button */
		pages.joiningFormPage.clkContinuebtn(prop_app_constants.getProperty("expectedAdditionalInfoPageUrl"));

		/************ Additional info ******************/

		/* click on yes radio button of do you have passport */
		pages.additionalInfoPage.clkYesPassportRb();

		/* Enter the details of passport */
		pages.additionalInfoPage.setPassportFields(passPortDetails.get("PassportNumber"),
				passPortDetails.get("PlaceOfIssue"), passPortDetails.get("IssuingAuthority"),
				passPortDetails.get("DateOfIssue"), passPortDetails.get("DateOfExpiry"));

		/* click on yes radiobutton of do you have visa */
		pages.additionalInfoPage.clkYesVisaRb();

		/* Enter the details of visa */
		pages.additionalInfoPage.setVisaFields(visaDetails.get("VisaCountry"), visaDetails.get("TypeOfVisa"),
				visaDetails.get("VisaFrom"), visaDetails.get("VisaTo"));

		/* click on same as current radiobutton for passport address */
		pages.additionalInfoPage.clkSameAsCurrentRb(addressDetails.get("CO"), addressDetails.get("AddressLine1"),
				addressDetails.get("AddressLine2"), addressDetails.get("Country"), addressDetails.get("State"),
				addressDetails.get("City"), addressDetails.get("PostalCode"));

		/* select language from language dropdown */
		pages.additionalInfoPage.selectLanguage(additionalInfo.get("Language"));

		/* click i am a protected veteran radiobutton */
		pages.additionalInfoPage.clkProtectedVeteran();

		/* mouse over veteran */
		pages.additionalInfoPage.mouseOverVeterans();

		/* Enter SSN number */
		pages.additionalInfoPage.setSSNnumber(additionalInfo.get("SSNNumber"));

		/* click i dont wish to answer radiobutton under disability */
		pages.additionalInfoPage.clkDontWishToAnswer();

		/* Enter emergency contact details */
		pages.additionalInfoPage.setEmergencyContactDetails(emergencyContactDetails.get("Title"),
				emergencyContactDetails.get("Name"), emergencyContactDetails.get("MobileNumber"),
				emergencyContactDetails.get("TelNumber"), emergencyContactDetails.get("AddressLine1"),
				emergencyContactDetails.get("AddressLine2"), emergencyContactDetails.get("Apartment"),
				emergencyContactDetails.get("Country"), emergencyContactDetails.get("State"),
				emergencyContactDetails.get("PostalCode"));

		/* click on continue button */
		pages.additionalInfoPage.clkContinue(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/************ Educational info ******************/

		pages.educationalInfoPage
				.validateEducationInfoPage(prop_app_constants.getProperty("expectedEducationalInfoPageUrl"));

		/* Enter education details */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		/* click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		/* validate education details cleared from the table */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0],
				educationDetails.get("From")[0], educationDetails.get("To")[0]);

		String[] educationDetailsArraylist1 = new String[] { educationDetails.get("Type")[0],
				educationDetails.get("SubType")[0], educationDetails.get("Discipline")[0],
				educationDetails.get("University")[0], educationDetails.get("Country")[0] };
		ArrayList<String> lstExpectededucationDetailsArraylist1 = new ArrayList<String>(
				Arrays.asList(educationDetailsArraylist1));

		/* validate education details table */
		pages.educationalInfoPage.validateEducationalQualificationstable1(lstExpectededucationDetailsArraylist1);

		/* Enter education details */
		pages.educationalInfoPage.setEducationalDetails(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		/* click this is my highest education checkbox */
		pages.educationalInfoPage.clkThisismyHighestEducationCheckbox();

		/* click on add details button */
		pages.educationalInfoPage.clickEducationalDetailsAddDetailsBtn();

		/* validate education details cleared from the table */
		pages.educationalInfoPage.validateEducationalQualificationssCleared(educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1],
				educationDetails.get("From")[1], educationDetails.get("To")[1]);

		String[] educationDetailsArraylist2 = new String[] { educationDetails.get("Type")[1],
				educationDetails.get("SubType")[1], educationDetails.get("Discipline")[1],
				educationDetails.get("University")[1], educationDetails.get("Country")[1] };
		ArrayList<String> lstExpectededucationDetailsArraylist2 = new ArrayList<String>(
				Arrays.asList(educationDetailsArraylist2));
		/* validate education details table */
		pages.educationalInfoPage.validateEducationalQualificationstable2(lstExpectededucationDetailsArraylist2);

		/* Enter certification details */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0]);

		/* click add details details */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		/* validate certification details cleared */
		pages.educationalInfoPage.validateCertificationDetailsCleared(certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0]);

		String[] certificationDetailsArraylist1 = new String[] { certificationDetails.get("CetificateNumber")[0],
				certificationDetails.get("CertificateName")[0], certificationDetails.get("CerticateType")[0],
				certificationDetails.get("Grade")[0], certificationDetails.get("CertificateBody")[0],
				certificationDetails.get("From")[0], certificationDetails.get("To")[0] };
		ArrayList<String> lstExpectedcertificationDetailsArraylist1 = new ArrayList<String>(
				Arrays.asList(certificationDetailsArraylist1));
		/* validate certification table */
		pages.educationalInfoPage.validateCertificationQualificationstable1(lstExpectedcertificationDetailsArraylist1);

		/* Enter certification details */
		pages.educationalInfoPage.setCertificationDetails(certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1]);

		/* click add details details */
		pages.educationalInfoPage.clickCertificationDetailsAddDetailsBtn();

		/* validate certification details cleared */
		pages.educationalInfoPage.validateCertificationDetailsCleared(certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1]);

		String[] certificationDetailsArraylist2 = new String[] { certificationDetails.get("CetificateNumber")[1],
				certificationDetails.get("CertificateName")[1], certificationDetails.get("CerticateType")[1],
				certificationDetails.get("Grade")[1], certificationDetails.get("CertificateBody")[1],
				certificationDetails.get("From")[1], certificationDetails.get("To")[1] };
		ArrayList<String> lstExpectedcertificationDetailsArraylist2 = new ArrayList<String>(
				Arrays.asList(certificationDetailsArraylist2));

		/* validate certification table */
		pages.educationalInfoPage.validateCertificationQualificationstable2(lstExpectedcertificationDetailsArraylist2);

		/* click continue button */
		pages.educationalInfoPage.clickContinueBtn();

		/************ Employment details ******************/

		/* validate employment details page */
		pages.employementdetailspage.valdidateEmploymentDetailsHeadText();

		pages.employementdetailspage.clickExperiencedRadioButton();

		/* Enter employee name */
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
		ArrayList<String> lstExpectedEmploymentDetailsArraylist1 = new ArrayList<>(
				Arrays.asList(employmentDetailsArraylist1));

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable1(lstExpectedEmploymentDetailsArraylist1);

		/* validate Employee Details form cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* Enter the Employee Name in Employer Text box */
		pages.employementdetailspage.settypeOfEmployee(employmentDetails.get("Employer")[1]);

		/* Select the Industry from Industry Drop down */
		pages.employementdetailspage.settypeOfindustry(employmentDetails.get("Industry")[1]);

		/* Select the Country from Country Drop down */
		pages.employementdetailspage.settypeOfcountry(employmentDetails.get("Country")[1]);

		/* Enter the City name in City Text Box */
		pages.employementdetailspage.settypeOfCity(employmentDetails.get("City")[1]);

		/* Enter the Designation name in Designation TextBox */
		pages.employementdetailspage.settypeOfDesignationOnJoining(employmentDetails.get("DesignationOnJoining")[1]);

		/*
		 * Enter the Designation Present/Exit name in Designation Present/Exit TextBox
		 */
		pages.employementdetailspage.settypeOfDesignationatPresentExit(employmentDetails.get("DesignatiOnPresent")[1]);

		/* Enter the From date in From date calendar */
		pages.employementdetailspage.setFromdate(employmentDetails.get("From")[1]);

		/* Enter the To date in To date calendar */
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
		ArrayList<String> lstExpectedEmploymentDetailsArraylist2 = new ArrayList<>(
				Arrays.asList(employmentDetailsArraylist2));

		/* validate Employee Details table */
		pages.employementdetailspage.validateEmployeeDetailsstable2(lstExpectedEmploymentDetailsArraylist2);

		/* validate Employee Details form cleared */
		pages.employementdetailspage.employementdetialsformcleard();

		/* click on save as draft button */
		pages.employementdetailspage.clickSaveAsDraftBtn();

		/* logout from candidate */
		pages.homePage.logout();

		/* Clicks on Sign In Button */
		pages.loginPage.clkSignIn();

		WebActionUtil.waitForAngularPageToLoad();

		/* log in as candidate */
		pages.loginPage.loginToApplication(prop_app_constants.getProperty("expectedLoginPageText"),
				prop_app_constants.getProperty("expectedLoginPageTitle"),
				prop_app_constants.getProperty("expectedLoginPageUrl"), loginDetails.get("CandidateId"),
				loginDetails.get("CandidatePwd"));

		/* validate Home page */
		pages.homePage.validateHomePage(prop_app_constants.getProperty("expectedCandidatePreJoiningPageUrl"));

		/* click on joining form */
		pages.homePage.clkFillJoiningForm();

		WebActionUtil.waitForAngularPageToLoad();
		/* Click on Continue Button */
		pages.employementdetailspage.clickContinueBtn();

		/* validate preview Page */
		pages.previewPage.validatePreviewPage(prop_app_constants.getProperty("expectedPreviewPageUrl"));

		WebActionUtil.waitForAngularPageToLoad();
		/* click on expand all link */
		pages.previewPage.clkExpandAllDd();

		/* click on voluntary self identification look up */
		pages.previewPage.clkDocumentReadIcn(prop_app_constants.getProperty("voluntarySelfIdentification"));

		/* validate personal details */
		pages.previewPage.validateDataInForm(expectedPersonalData);

		/* click on submit button */
		pages.previewPage.clkSubmit1Btn(prop_app_constants.getProperty("genderAndRaceSelfIdentification"));

		/* click on submit button */
		pages.previewPage.clkSubmit2Btn(prop_app_constants.getProperty("coveredProtectedVeterans"));

		/* click on submit button */
		pages.previewPage.clkSubmitBtn();

		/* Closes the current Tab */
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

		/************ TagManager Page ******************/
		/* Validates the Roles */
		pages.tagManagerPage.validateRoles();

		/* Switches the Role to Recruiter(RMG) */
		pages.tagManagerPage.changeRole(prop_app_constants.getProperty("roleTagManager"));

		/* Validates the fields in Recruiter Page */
		pages.tagManagerPage.validateFields(prop_app_constants.getProperty("roleTagManager"));

		pages.tagManagerPage.clkSearchBar(candidateName);

		/* validates Joining Form Status */
		pages.tagManagerPage.validateJoiningFormStatus(candidateName);

		/* Clicks on Mail Icon */
		pages.tagManagerPage.clkMailIcon(candidateName);

		/* Clicks on Action Icon */
		pages.tagManagerPage.clkActionIcon(candidateName);

		/* Clicks on Did Candidate Join dropdoown */
		pages.tagManagerPage.clkDidCandidateJoin();

		/* Select yes from the Did Candidate Join dropdown */
		pages.tagManagerPage.selectYesDd();

		/* Clicks on Submit Button */
		pages.tagManagerPage.clkSubmitButton(prop_app_constants.getProperty("expectedTagManagerUrl"));

		/************ ES Role Page ******************/

		/* Validates the Roles */
		pages.esPage.validateTagRoles();

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
		pages.esPage.selectReasonForHiring(prop_app_constants.getProperty("fresherHiringOffCampus"));

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