package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for Educational info page
 * 
 * @author Shreya U
 */
public class EducationalInfo_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public EducationalInfo_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;

	}

	/* Type Qualification Drop down */
	@FindBy(xpath = "//label[text()='Type/Qualification']/following-sibling::div/button")
	private WebElement ddTypeQualification;

	/* Type Qualification Text box */
	@FindBy(xpath = "//label[text()='Type/Qualification']/parent::div//div[@class='bs-searchbox']/input")
	private WebElement tbTypeQualification;

	/* Sub Type Drop Down */
	@FindBy(xpath = "//label[text()='Sub Type']/following-sibling::div/button")
	private WebElement ddSubType;

	/* Discipline Drop Down */
	@FindBy(xpath = "//label[text()='Discipline']/following-sibling::div/button")
	private WebElement ddDiscipline;

	/* Country Drop Down */
	@FindBy(xpath = "//label[text()='Country']/following-sibling::div/button")
	private WebElement ddCountry;

	/* University Text box */
	@FindBy(xpath = "//label[text()='University']/following-sibling::input")
	private WebElement tbUniversity;

	/* University Label */
	@FindBy(xpath = "//label[text()='University']")
	private WebElement txtUniversity;

	/* Qualification From Date Text box */
	@FindBy(id = "L068")
	private WebElement dteQualificationFrom;

	/* Qualification To Date Text box */
	@FindBy(id = "L069")
	private WebElement dteQualificationTo;

	/* Certification Number Text box */
	@FindBy(xpath = "//label[text()='Certification Number']/following-sibling::input")
	private WebElement tbCertificationNumber;

	/* Certification Name Text box */
	@FindBy(xpath = "//label[text()='Certification Name']/following-sibling::input")
	private WebElement tbCertificationName;

	/* Certification Type Text box */
	@FindBy(xpath = "//label[text()='Certification Type']/following-sibling::input")
	private WebElement tbCertificationType;

	/* Certification Grade Text box */
	@FindBy(xpath = "//label[text()='Score/Percentage/Grade']/following-sibling::input")
	private WebElement tbCertificationGrade;

	/* Score Percentage grade Text box */
	@FindBy(xpath = "//label[text()='Score/Percentage/Grade']/following-sibling::input")
	private WebElement tbScorePercentageGrade;

	/* Certification Body Text box */
	@FindBy(xpath = "//label[text()='Certification Body']/following-sibling::input")
	private WebElement tbCertificationBody;

	/* Certification From Date Text box */
	@FindBy(id = "L075")
	private WebElement dteCertificateFrom;

	/* Certification From Date Text box */
	@FindBy(id = "L076")
	private WebElement dteCertificateTo;

	/* Qualification Add Details Icon */
	@FindBy(xpath = "(//span[text()='Add Detail']/preceding-sibling::span)[1]")
	private WebElement icnQualificationAddDetails;

	/* Certification Add Details Icon */
	@FindBy(xpath = "(//span[text()='Add Detail']/preceding-sibling::span)[2]")
	private WebElement icnCertificationAddDetails;

	/* Details Text */
	@FindBy(xpath = "//th[text()='Type']/parent::tr/following-sibling::tr[1]/td")
	private List<WebElement> txtDetails1;

	/* Details Text */
	@FindBy(xpath = "//th[text()='Type']/parent::tr/following-sibling::tr[2]/td")
	private List<WebElement> txtDetails2;

	/* Certificate Details Text */
	@FindBy(xpath = "//th[text()='Certif No']/parent::tr/following-sibling::tr[1]/td")
	private List<WebElement> txtCertificateDetails1;

	/* Certificate Details Text */
	@FindBy(xpath = "//th[text()='Certif No']/parent::tr/following-sibling::tr[2]/td")
	private List<WebElement> txtCertificateDetails2;

	/* Certificate Edit Icon */
	@FindBy(xpath = "//th[text()='Certif. No']/parent::tr/following-sibling::tr//i[@title='Edit']")
	private WebElement icnCertificateEdit;

	/* Certificate Delete Icon */
	@FindBy(xpath = "//th[text()='Certif. No']/parent::tr/following-sibling::tr//i[@title='Delete']")
	private WebElement icnCertificateDelete;

	/* Qualification Delete Icon */
	@FindBy(xpath = "//th[text()='Type']/parent::tr/following-sibling::tr//i[@title='Delete']")
	private WebElement icnQualificationsDelete;

	/* Qualification Edit Icon */
	@FindBy(xpath = "//th[text()='Type']/parent::tr/following-sibling::tr//i[@title='Edit']")
	private WebElement icnQualificationsEdit;

	/* Continue Button */
	@FindBy(id = "ContinueButton")
	private WebElement btnContinue;

	/* Save As Draft Button */
	@FindBy(name = "education:save")
	private WebElement btnSaveAsDraft;

	/* This is my Highest Education Check box */
	@FindBy(id = "L0100")
	private WebElement cbThisismyHighestEducation;

	/* Sub Type Text Box */
	@FindBy(xpath = "//label[text()='Sub Type']/parent::div//div[@class='bs-searchbox']/input")
	private WebElement tbSubType;

	/* Discipline Text Box */
	@FindBy(xpath = "//label[text()='Discipline']/parent::div//div[@class='bs-searchbox']/input")
	private WebElement tbDiscipline;

	/* Country Text Box */
	@FindBy(xpath = "//label[text()='Country']/parent::div//div[@class='bs-searchbox']/input")
	private WebElement tbCountry;

	/* Add Details Button */
	@FindBy(xpath = "//h4[text()='Educational Details ']/ancestor::div[3]//div[@id='collapselist1-dec']/child::div/div[@class='row'][5]//span[contains(text(),'Add Detail')]")
	private WebElement btnAddDetails;

	/* Certification Details Add Details Button */
	@FindBy(xpath = "//h4[text()='Certification Details ']/parent::div/parent::div/div[@id='collapselist2-dec']//div[@class='row'][4]/child::div/div[@id='btncerti']/span[contains(text(),'Add Detail')]")
	private WebElement btnCertificationDetailsAddDetails;

	String txtQualificationFromDate = "(//label[text()='From'])[1]";
	String dteInputQualificationFrom = "(//label[text()='From'])[1]/following-sibing::input";

	String txtQualificationToDate = "(//label[text()='To'])[1]";
	String dteInputQualificationTo = "(//label[text()='To'])[1]/following-sibing::input";

	String txtCerificationFromDate = "(//label[text()='From'])[2]";
	String dteInputCeritificationFrom = "(//label[text()='From'])[2]/following-sibing::input";

	String txtCertificationToDate = "(//label[text()='To'])[2]";
	String dteInputCertificationTo = "(//label[text()='To'])[2]/following-sibing::input";

	/* Education Details Edit Button */
	@FindBy(xpath = "//h4[text()='Educational Details ']/ancestor::div[@class='panel panel-default accordion']/descendant::td/i[@class='icon-edit pointer']")
	private WebElement btnEducationDetailsEdit;

	/* Certification Details Edit Button */
	@FindBy(xpath = "//h4[text()='Certification Details ']/ancestor::div[@class='panel panel-default accordion']/descendant::td/i[@class='icon-edit pointer']")
	private WebElement btnCertificationDetailsEdit;

	/* Education Details Update Button */
	@FindBy(xpath = "//h4[text()='Educational Details ']/ancestor::div[@class='panel panel-default accordion']/descendant::span[text()='Update Details']")
	private WebElement btnEducationalDetailsUpdate;

	/* Certification Details Update Button */
	@FindBy(xpath = "//h4[text()='Certification Details ']/ancestor::div[@class='panel panel-default accordion']/descendant::span[text()='Update Details']")
	private WebElement btnCertificationDetailsUpdate;

	/* Get the Searched Option */
	private synchronized WebElement getSearchedOption(String option) {
		String xpath = "//a/span[text()='" + option + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * Description Method to click on This is my Highest Education Check Box
	 * 
	 * @author Shreya U
	 * 
	 */
	public synchronized void clkThisismyHighestEducationCheckbox() {
		try {
			WebActionUtil.waitForElement(cbThisismyHighestEducation, " This is my Highest Education Check box");
			WebActionUtil.poll(1000);
			WebActionUtil.jsExecutor.executeScript("document.getElementById('L0100').click()");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click This is my highest education check box");
			Assert.fail("Unable to click This is my highest education check box");
		}

	}

	/**
	 * Description Method to set the educational details
	 * 
	 * @author Shreya U
	 * @param type
	 * @param subType
	 * @param discipline
	 * @param university
	 * @param country
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void setEducationalDetails(String type, String subType, String discipline, String university,
			String country, String fromDate, String toDate) {
		try {
			WebActionUtil.waitForElement(ddTypeQualification, "Type Qualification drop down");
			WebActionUtil.clickOnElement(ddTypeQualification, "Type Qualification drop down",
					"Unable to click on Type Qualification drop down");
			WebActionUtil.typeText(tbTypeQualification, type, "Type Qualification text box");
			WebActionUtil.actionEnter();

			WebActionUtil.validateAttribute(ddTypeQualification, "title", type, "Type Qualification drop down",
					type + " entered in Type Qualification text box",
					type + "is not entered in Type Qualification text box", "blue");

			WebActionUtil.waitForElement(ddSubType, "Sub Type drop down");
			WebActionUtil.clickOnElement(ddSubType, "Sub Type drop down", "Unable to click on Sub Type drop down");
			WebActionUtil.typeText(tbSubType, subType, "Sub Type  text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddSubType, "title", subType, "Sub Type drop down",
					subType + " entered in  Sub Type text box", subType + "is not entered in Sub Type text box",
					"blue");

			WebActionUtil.waitForElement(ddDiscipline, "Discipline drop down");
			WebActionUtil.clickOnElement(ddDiscipline, "Discipline drop down",
					"Unable to click on Discipline drop down");
			WebActionUtil.typeText(tbDiscipline, discipline, "Sub Type  text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddDiscipline, "title", discipline, "Discipline drop down",
					discipline + " entered in  Discipline drop down",
					discipline + "is not entered in Discipline drop down", "blue");

			WebActionUtil.waitForElement(tbUniversity, "University text box");
			WebActionUtil.clickOnElement(tbUniversity, "University text box",
					"Unable to click on University  text box");
			WebActionUtil.typeText(tbUniversity, university, "University text box");
			String expectedUniversity = university.toLowerCase();
			String actualuniversity = WebActionUtil.getTextUsingJS("L066").toLowerCase();
			WebActionUtil.comparetText(actualuniversity, expectedUniversity, "blue");

			WebActionUtil.waitForElement(ddCountry, "Country drop down");
			WebActionUtil.clickOnElement(ddCountry, "Country drop down", "Unable to click on Country drop down");
			WebActionUtil.typeText(tbCountry, country, "Country text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddCountry, "title", country, "Country text box",
					country + " entered in Country drop down", country + "is not entered in Country drop down", "blue");

			selectDate(fromDate, "L068");
			String actualfromdate = WebActionUtil.getTextUsingJS("L068");
			WebActionUtil.comparetText(actualfromdate, fromDate, "blue");

			selectDate(toDate, "L069");
			String actualtodate = WebActionUtil.getTextUsingJS("L069");
			WebActionUtil.comparetText(actualtodate, toDate, "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set Educational details");
			Assert.fail("Unable to set Educational details");
		}

	}

	/**
	 * Description Method to select the particular date from Date of Birth.
	 * 
	 * @author Manish Kumar C D
	 * @param date
	 */

	public synchronized void selectDate(String date, String dateID) {
		try {
			WebActionUtil.selectCalendarDate(dateID, date, "Date Of Birth");

			if (WebActionUtil.getTextUsingJS(dateID).equals(date)) {
				WebActionUtil.validationinfo("Selected date is " + date + " ", "blue");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to select date in Date of Birth");
			WebActionUtil.fail("Unable to select date in Date of Birth");
			Assert.fail("Unable to select date in Date of Birth");
		}
	}

	/**
	 * Description Method to set the certificate details
	 * 
	 * @author Shreya U
	 * @param certificationNumber
	 * @param certificationName
	 * @param certificationType
	 * @param scorePercentage
	 * @param certificationBody
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void setCertificationDetails(String certificationNumber, String certificationName,
			String certificationType, String scorePercentage, String certificationBody, String fromDate,
			String toDate) {
		try {
			WebActionUtil.waitForElement(tbCertificationNumber, "Certification Number text box");
			WebActionUtil.clickOnElement(tbCertificationNumber, "Certification Number text box",
					"Unable to click on Certification Number text box");
			WebActionUtil.typeText(tbCertificationNumber, certificationNumber, "Certification Number text box");

			String expectedCerticationNumber = certificationNumber.toLowerCase();
			String actualCerticationNumber = WebActionUtil.getTextUsingJS("L070").toLowerCase();
			WebActionUtil.comparetText(actualCerticationNumber, expectedCerticationNumber, "blue");

			WebActionUtil.waitForElement(tbCertificationName, "Certification Name text box");
			WebActionUtil.clickOnElement(tbCertificationName, "Certification Name text box",
					"Unable to click on Certification Name text box");
			WebActionUtil.typeText(tbCertificationName, certificationName, "Certification Name text box");

			String expectedcertificationName = certificationName.toLowerCase();
			String actualcertificationName = WebActionUtil.getTextUsingJS("L071").toLowerCase();
			WebActionUtil.comparetText(actualcertificationName, expectedcertificationName, "blue");

			WebActionUtil.waitForElement(tbCertificationType, "Certification type text box");
			WebActionUtil.clickOnElement(tbCertificationType, "Certification type text box",
					"Unable to click on Certification type text box");
			WebActionUtil.typeText(tbCertificationType, certificationType, "Certification type text box");
			String expectedCertificationType = certificationType.toLowerCase();
			String actualCertificationType = WebActionUtil.getTextUsingJS("L072").toLowerCase();
			WebActionUtil.comparetText(actualCertificationType, expectedCertificationType, "blue");

			WebActionUtil.waitForElement(tbCertificationGrade, "Certification Grade text box");
			WebActionUtil.clickOnElement(tbCertificationGrade, "Certification Grade text box",
					"Unable to click on Certification Grade text box");
			WebActionUtil.typeText(tbCertificationGrade, scorePercentage, "Certification Grade text box");
			String expectedCertificationGrade = scorePercentage.toLowerCase();
			String actualCertificationGrade = WebActionUtil.getTextUsingJS("L073").toLowerCase();
			WebActionUtil.comparetText(expectedCertificationGrade, actualCertificationGrade, "blue");

			WebActionUtil.waitForElement(tbCertificationBody, "Certification body text box");
			WebActionUtil.clickOnElement(tbCertificationBody, "Certification body text box",
					"Unable to click on Certification type text box");
			WebActionUtil.typeText(tbCertificationBody, certificationBody, "Certification body text box");

			String expectedcertificationBody = certificationBody.toLowerCase();
			String actualcertificationBody = WebActionUtil.getTextUsingJS("L074").toLowerCase();
			WebActionUtil.comparetText(actualcertificationBody, expectedcertificationBody, "blue");

			selectFromDate(fromDate);

			selectToDate(toDate);

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set certificate details");
			Assert.fail("Unable to set certificate details");
		}

	}

	/**
	 * Description Method to validate reset of data of the certificate details
	 * 
	 * @author Shreya U
	 * @param certificationNumber
	 * @param certificationName
	 * @param certificationType
	 * @param scorePercentage
	 * @param certificationBody
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void validateCertificationDetailsCleared(String certificationNumber, String certificationName,
			String certificationType, String scorePercentage, String certificationBody, String fromDate,
			String toDate) {
		try {

			String actualcertificationNumber = WebActionUtil.getTextUsingJS("L070");
			WebActionUtil.validateEnteredValue(actualcertificationNumber, "", "Certification Number text box",
					certificationNumber + "is cleared from Certification Number text box",
					certificationNumber + "is not cleared from Certification Number text box", "blue");

			String actualcertificationName = WebActionUtil.getTextUsingJS("L071");
			WebActionUtil.validateEnteredValue(actualcertificationName, "", "Certification Name text box",
					certificationName + "is cleared from Certification Name text box",
					certificationName + "is not cleared from Certification Name text box", "blue");

			String actualcertificationType = WebActionUtil.getTextUsingJS("L072");
			WebActionUtil.validateEnteredValue(actualcertificationType, "", "Certification Type text box",
					certificationType + "is cleared from Certification Type text box",
					certificationType + "is not cleared from Certification Type text box", "blue");

			String actualcertificationBody = WebActionUtil.getTextUsingJS("L073");
			WebActionUtil.validateEnteredValue(actualcertificationBody, "", "Certification Body text box",
					certificationType + "is cleared from Certification Body text box",
					certificationType + "is not cleared from Certification Body text box", "blue");

			String actualFromDate = WebActionUtil.getTextUsingJS("L074");
			WebActionUtil.validateEnteredValue(actualFromDate, "", "From Date text box",
					fromDate + "is cleared from From Date text box", fromDate + "is not From Date text box", "blue");

			String actualToDate = WebActionUtil.getTextUsingJS("L075");
			WebActionUtil.validateEnteredValue(actualToDate, "", "To Date text box",
					toDate + "is cleared from To Date text box", toDate + "is not cleared from To Date text box",
					"blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate reset of data of the certificate details");
			Assert.fail("Unable to validate reset of data of the certificate details");
		}

	}

	/**
	 * Description Method to validate reset of data of the Educational
	 * Qualifications
	 * 
	 * @author Shreya U
	 * @param type
	 * @param subType
	 * @param discipline
	 * @param scorePercentage
	 * @param university
	 * @param country
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void validateEducationalQualificationssCleared(String type, String subType, String discipline,
			String university, String country, String fromDate, String toDate) {
		try {

			WebActionUtil.validateAttribute(ddTypeQualification, "title", "Select", "Type Qualification drop down",
					type + "is cleared from Type Qualification drop down",
					type + "is not cleared from Type Qualification drop down", "blue");
			WebActionUtil.validateAttribute(ddSubType, "title", "Select", "Subtype drop down",
					subType + "is cleared from Subtype drop down", subType + "is not entered in Subtype drop down",
					"blue");
			WebActionUtil.validateAttribute(ddDiscipline, "title", "Select", "Discipline drop down",
					discipline + "is cleared from Discipline drop down",
					discipline + "is not cleared from Discipline drop down", "blue");
			String actualUniversityText = WebActionUtil.getTextUsingJS("L066");
			WebActionUtil.validateEnteredValue(actualUniversityText, "", "University  text box",
					"The text entered in University text box is cleared",
					"The text entered in University text box is not cleared", "blue");

			WebActionUtil.validateAttribute(ddCountry, "title", "Select", "Country body text box",
					country + "is cleared from Country  text box", country + "is not cleared in Country  text box",
					"blue");

			String actualFromDate = WebActionUtil.getTextUsingJS("L068");
			WebActionUtil.validateEnteredValue(actualFromDate, "", "From Date text box",
					fromDate + "is cleared from From Date text box", fromDate + "is not From Date text box", "blue");

			String actualToDate = WebActionUtil.getTextUsingJS("L069");
			WebActionUtil.validateEnteredValue(actualToDate, "", "To Date text box",
					toDate + "is cleared from To Date text box", toDate + "is not cleared from To Date text box",
					"blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate reset of data of the Educational Qualifications details");
			Assert.fail("Unable to validate reset of data of the Educational Qualifications details");
		}

	}

	/**
	 * Description Method to validate the Education details table second row
	 * 
	 * @author Shreya U
	 * @param arr
	 */

	public synchronized void validateEducationalQualificationstable2(ArrayList arr) {
		try {
			ArrayList<String> alldetails = new ArrayList<String>();
			for (int i = 0; i < arr.size(); i++) {
				try {

					alldetails.add(txtDetails2.get(i).getText());
				} catch (Exception e) {
					continue;
				}
			}
			Assert.assertEquals(arr, alldetails);
			WebActionUtil.info("Educational  details in the table is matched");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Educational Qualifications details in the table");
			Assert.fail("Unable to validate Educational Qualifications details in the table");
		}
	}

	/**
	 * Description Method to validate the Education details table first row
	 * 
	 * @author Shreya U
	 * @param arr
	 */

	public synchronized void validateEducationalQualificationstable1(ArrayList arr) {
		try {
			ArrayList<String> alldetails = new ArrayList<String>();
			for (int i = 0; i < arr.size(); i++) {
				try {

					alldetails.add(txtDetails1.get(i).getText());
				} catch (Exception e) {
					continue;
				}
			}

			Assert.assertEquals(arr, alldetails);
			WebActionUtil.info("Educational  details in the table is matched");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Educational Qualifications details in the table");
			Assert.fail("Unable to validate Educational Qualifications details in the table");
		}
	}

	/**
	 * Description Method to validate the Certification details table first row
	 * 
	 * @author Shreya U
	 * @param arr
	 * 
	 */

	public synchronized void validateCertificationQualificationstable1(ArrayList arr) {
		try {
			ArrayList<String> alldetails = new ArrayList<String>();

			for (int i = 0; i < txtCertificateDetails1.size(); i++) {
				try {
					alldetails.add(txtCertificateDetails1.get(i).getText());

				} catch (Exception e) {
					continue;
				}

			}
			if (txtCertificateDetails1.size() < 5) {
				Assert.assertEquals(arr, alldetails);
			}
			WebActionUtil.info("Certification  details in the table is matched");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Certification  details in the table");
			Assert.fail("Unable to validate Certification Qualifications details in the table");
		}
	}

	/**
	 * Description Method to validate the Certification details table second row
	 * 
	 * @author Shreya U
	 * @param arr
	 * 
	 */

	public synchronized void validateCertificationQualificationstable2(ArrayList arr) {
		try {
			ArrayList<String> alldetails = new ArrayList<String>();

			for (int i = 0; i < txtCertificateDetails2.size(); i++) {
				try {
					alldetails.add(txtCertificateDetails2.get(i).getText());
				} catch (Exception e) {
					continue;
				}

			}
			if (txtCertificateDetails2.size() < 5) {

				Assert.assertEquals(arr, alldetails);
			}
			WebActionUtil.info("Certification  details in the table is matched");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Certification  details in the table");
			Assert.fail("Unable to validate Certification Qualifications details in the table");
		}
	}

	/**
	 * Description Method to validate the Education info page
	 * 
	 * @author Shreya U
	 * @param url
	 * 
	 */

	public synchronized void validateEducationInfoPage(String pageUrl) {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, pageUrl);
			WebActionUtil.info("Educational page is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Education details page");
			Assert.fail("Unable to validate Education details page");
		}

	}

	/**
	 * Description: Method click on Add Details Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clickCertificationDetailsAddDetailsBtn() {
		try {
			WebActionUtil.waitForElement(btnCertificationDetailsAddDetails, "Add Details Button");
			WebActionUtil.clickOnElement(btnCertificationDetailsAddDetails, "Add Details Button",
					"Unable to click on Add Details Button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Add Details Button");
			Assert.fail("Unable to click on Add Details Button");
		}
	}

	/**
	 * Description: Method click on Add Details Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clickEducationalDetailsAddDetailsBtn() {
		try {
			WebActionUtil.waitForElement(btnAddDetails, "Add Details button");
			WebActionUtil.clickOnElement(btnAddDetails, "Add Details button", "Unable to click on Add Details button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Add Details button");
			Assert.fail("Unable to click on Add Details button");
		}
	}

	/**
	 * Description: Method click on Continue Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clickContinueBtn() {
		try {
			WebActionUtil.waitForElement(btnContinue, "Continue button");
			WebActionUtil.clickOnElement(btnContinue, "Continue button", "Unable to click on Continue button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Continue Button");
			Assert.fail("Unable to click on Continue Button");
		}
	}

	/**
	 * Description Method to select the particular date from From Date.
	 * 
	 * @author Manish Kumar C D
	 * @param date
	 */

	public synchronized void selectFromDate(String fromDate) {
		try {
			String fromDateId = "L075";
			WebActionUtil.selectCalendarDate(fromDateId, fromDate, "Date Of Birth");

			if (WebActionUtil.getTextUsingJS("L075").equals(fromDate)) {
				WebActionUtil.validationinfo("From Date selected is " + fromDate + " ", "blue");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to select date in From Date");
			WebActionUtil.fail("Unable to select date in From Date");
			Assert.fail("Unable to select date in From Date");
		}
	}

	/**
	 * Description Method to select the particular date from To Date.
	 * 
	 * @author Manish Kumar C D
	 * @param date
	 */

	public synchronized void selectToDate(String toDate) {
		try {
			String toDateId = "L076";
			WebActionUtil.selectCalendarDate(toDateId, toDate, "Date Of Birth");

			if (WebActionUtil.getTextUsingJS("L076").equals(toDate)) {
				WebActionUtil.validationinfo("To Date selected is " + toDate + " ", "blue");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to select date in To Date");
			WebActionUtil.fail("Unable to select date in To Date");
			Assert.fail("Unable to select date in To Date");
		}
	}

	/**
	 * Description: Method click on Education Details Edit Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clkEducationDetailsEditbtn() {
		try {
			WebActionUtil.waitForElement(btnEducationDetailsEdit, "Education Details Edit Button");
			WebActionUtil.clickOnElement(btnEducationDetailsEdit, "Education Details Edit Button",
					"Unable to click on Education Details Edit Button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Education Details Edit Button");
			Assert.fail("Unable to click on Education Details Edit Button");
		}
	}

	/**
	 * Description: Method click on Certification Details Edit Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clkCertificationDetailsEditbtn() {
		try {
			WebActionUtil.waitForElement(btnCertificationDetailsEdit, "Certification Details Edit Button");
			WebActionUtil.clickOnElement(btnCertificationDetailsEdit, "Certification Details Edit Button",
					"Unable to click on Certification Details Edit Button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Certification Details Edit Button");
			Assert.fail("Unable to click on Certification Details Edit Button");
		}
	}

	/**
	 * Description: Method click on Certification Details Update Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clkCertificationDetailsUpdatebtn() {
		try {
			WebActionUtil.waitForElement(btnCertificationDetailsUpdate, "Certification Details Update Button");
			WebActionUtil.clickOnElement(btnCertificationDetailsUpdate, "Certification Details Update Button",
					"Unable to click on Certification Details Update Button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Certification Details Update Button");
			Assert.fail("Unable to click on Certification Details Update Button");
		}
	}

	/**
	 * Description: Method click on Educational Details Update Button
	 * 
	 * @author Shreya u
	 */
	public synchronized void clkEducationalDetailsUpdatebtn() {
		try {
			WebActionUtil.waitForElement(btnEducationalDetailsUpdate, "Educational Details Update button");
			WebActionUtil.clickOnElement(btnEducationalDetailsUpdate, "Educational Details Update button",
					"Unable to click on Educational  Details Update button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Educational Details Update Button");
			Assert.fail("Unable to click on Educational Details Update Button");
		}
	}

	/**
	 * Description Method to edit the educational details
	 * 
	 * @author Shreya U
	 * @param type
	 * @param subType
	 * @param discipline
	 * @param university
	 * @param country
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void editEducationalDetails(String type, String subType, String discipline, String university,
			String country, String fromDate, String toDate) {
		try {
			WebActionUtil.waitForElement(ddTypeQualification, "Type Qualification drop down");
			WebActionUtil.clickOnElement(ddTypeQualification, "Type Qualification drop down",
					"Unable to click on Type Qualification drop down");
			WebActionUtil.typeText(tbTypeQualification, type, "Type Qualification text box");
			WebActionUtil.actionEnter();

			WebActionUtil.validateAttribute(ddTypeQualification, "title", type, "Type Qualification drop down",
					type + " entered in Type Qualification text box",
					type + "is not entered in Type Qualification text box", "blue");

			WebActionUtil.waitForElement(ddSubType, "Sub Type drop down");
			WebActionUtil.clickOnElement(ddSubType, "Sub Type drop down", "Unable to click on Sub Type drop down");
			WebActionUtil.typeText(tbSubType, subType, "Sub Type  text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddSubType, "title", subType, "Sub Type drop down",
					subType + " entered in  Sub Type text box", subType + "is not entered in Sub Type text box",
					"blue");

			WebActionUtil.waitForElement(ddDiscipline, "Discipline drop down");
			WebActionUtil.clickOnElement(ddDiscipline, "Discipline drop down",
					"Unable to click on Discipline drop down");
			WebActionUtil.typeText(tbDiscipline, discipline, "Sub Type  text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddDiscipline, "title", discipline, "Discipline drop down",
					discipline + " entered in  Discipline drop down",
					discipline + "is not entered in Discipline drop down", "blue");

			WebActionUtil.waitForElement(tbUniversity, "University  text box");
			WebActionUtil.clickOnElement(tbUniversity, "University  text box",
					"Unable to click on University  text box");
			WebActionUtil.clearText(tbUniversity, "University  text box");
			WebActionUtil.typeText(tbUniversity, university, "University  text box");
			String expectedUniversity = university.toLowerCase();
			String actualuniversity = WebActionUtil.getTextUsingJS("L066").toLowerCase();
			WebActionUtil.comparetText(actualuniversity, expectedUniversity, "blue");

			WebActionUtil.waitForElement(ddCountry, "Country drop down");
			WebActionUtil.clickOnElement(ddCountry, "Country drop down", "Unable to click on Country drop down");
			WebActionUtil.typeText(tbCountry, country, "Country text box");
			WebActionUtil.actionEnter();
			WebActionUtil.validateAttribute(ddCountry, "title", country, "Country text box",
					country + " entered in Country drop down", country + "is not entered in Country drop down", "blue");

//			WebActionUtil.selectDate(txtQualificationFromDate, dteInputQualificationFrom, fromDate, "From Date");
			selectDate(fromDate, "L068");
			String actualfromdate = WebActionUtil.getTextUsingJS("L068");
			WebActionUtil.comparetText(actualfromdate, fromDate, "blue");

//			WebActionUtil.selectDate(txtQualificationToDate, dteInputQualificationTo, toDate, "To Date");
			selectDate(toDate, "L069");
			String actualtodate = WebActionUtil.getTextUsingJS("L069");
			WebActionUtil.comparetText(actualtodate, toDate, "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set educational details");
			Assert.fail("Unable to set educational details");
		}

	}

	/**
	 * Description Method to Edit the certificate details
	 * 
	 * @author Shreya U
	 * @param certificationNumber
	 * @param certificationName
	 * @param certificationType
	 * @param scorePercentage
	 * @param certificationBody
	 * @param fromDate
	 * @param toDate
	 * 
	 */
	public synchronized void editCertificationDetails(String certificationNumber, String certificationName,
			String certificationType, String scorePercentage, String certificationBody, String fromDate,
			String toDate) {
		try {
			WebActionUtil.waitForElement(tbCertificationNumber, "Certification Number text box");
			WebActionUtil.clickOnElement(tbCertificationNumber, "Certification Number text box",
					"Unable to click on Certification Number text box");
			WebActionUtil.clearText(tbCertificationNumber, "Certification Number text box");

			WebActionUtil.typeText(tbCertificationNumber, certificationNumber, "Certification Number text box");

			String expectedCerticationNumber = certificationNumber.toLowerCase();
			String actualCerticationNumber = WebActionUtil.getTextUsingJS("L070").toLowerCase();
			WebActionUtil.comparetText(actualCerticationNumber, expectedCerticationNumber, "blue");

			WebActionUtil.waitForElement(tbCertificationName, "Certification Name text box");
			WebActionUtil.clickOnElement(tbCertificationName, "Certification Name text box",
					"Unable to click on Certification Name text box");
			WebActionUtil.clearText(tbCertificationName, "Certification Name text box");

			WebActionUtil.typeText(tbCertificationName, certificationName, "Certification Name text box");

			String expectedcertificationName = certificationName.toLowerCase();
			String actualcertificationName = WebActionUtil.getTextUsingJS("L071").toLowerCase();
			WebActionUtil.comparetText(actualcertificationName, expectedcertificationName, "blue");

			WebActionUtil.waitForElement(tbCertificationType, "Certification type text box");
			WebActionUtil.clickOnElement(tbCertificationType, "Certification type text box",
					"Unable to click on Certification type text box");
			WebActionUtil.clearText(tbCertificationType, "Certification type text box");
			WebActionUtil.typeText(tbCertificationType, certificationType, "Certification type text box");
			String expectedCertificationType = certificationType.toLowerCase();
			String actualCertificationType = WebActionUtil.getTextUsingJS("L072").toLowerCase();
			WebActionUtil.comparetText(actualCertificationType, expectedCertificationType, "blue");

			WebActionUtil.waitForElement(tbCertificationGrade, "Certification Grade text box");
			WebActionUtil.clickOnElement(tbCertificationGrade, "Certification Grade text box",
					"Unable to click on Certification Grade text box");
			WebActionUtil.clearText(tbCertificationGrade, "Certification Grade text box");
			WebActionUtil.typeText(tbCertificationGrade, scorePercentage, "Certification Grade text box");
			String expectedCertificationGrade = scorePercentage.toLowerCase();
			String actualCertificationGrade = WebActionUtil.getTextUsingJS("L073").toLowerCase();
			WebActionUtil.comparetText(expectedCertificationGrade, actualCertificationGrade, "blue");

			WebActionUtil.waitForElement(tbCertificationBody, "Certification body text box");
			WebActionUtil.clickOnElement(tbCertificationBody, "Certification body text box",
					"Unable to click on Certification type text box");
			WebActionUtil.clearText(tbCertificationBody, "Certification body text box");
			WebActionUtil.typeText(tbCertificationBody, certificationBody, "Certification body text box");

			String expectedcertificationBody = certificationBody.toLowerCase();
			String actualcertificationBody = WebActionUtil.getTextUsingJS("L074").toLowerCase();
			WebActionUtil.comparetText(actualcertificationBody, expectedcertificationBody, "blue");

			selectFromDate(fromDate);

			selectToDate(toDate);

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set certificate details");
			Assert.fail("Unable to set certificate details");
		}

	}

}
