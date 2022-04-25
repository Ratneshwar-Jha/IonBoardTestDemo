package com.hcl.ionboard.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for AdditionalInfo Page
 * 
 * @author Abhilash
 */
public class AdditionalInfo_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public AdditionalInfo_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* passport yes radio button */
	@FindBy(xpath = "//input[@name='Passport']/parent::div/label[text()='Yes']")
	private WebElement rbPassportYes;

	/* passport No radio button */
	@FindBy(xpath = "//input[@name='Passport']/parent::div/label[text()='No']")
	private WebElement rbPassportNo;

	/* passport No Selected radio button */
	@FindBy(xpath = "//input[@name='Passport']/parent::div/label[text()='No']/preceding-sibling::input")
	private WebElement rbPassportNoSelected;

	/* passport number text box */
	@FindBy(xpath = "(//label[text()='Passport Number']/following-sibling::input)[2]")
	private WebElement tbPassportNumber;

	/* place of issue text box */
	@FindBy(xpath = "//label[text()='Place of Issue']/following-sibling::input")
	private WebElement tbPlaceOfIssue;

	/* issuing authority text box */
	@FindBy(xpath = "//label[text()='Issuing Authority']/following-sibling::input")
	private WebElement tbIssuingAuthority;

	/* date of issue */
	@FindBy(id = "L032")
	private WebElement dteDateOfIssue;

	/* date of expiry */
	@FindBy(id = "L033")
	private WebElement dteDateOfExpiry;

	/* visa country button */
	@FindBy(xpath = "//label[text()='Visa Country']/parent::div/descendant::button")
	private WebElement btnVisaCountry;

	/* visa country text box */
	@FindBy(xpath = "//label[text()='Visa Country']/parent::div/descendant::input")
	private WebElement tbVisaCountry;

	/* select visa country */
	private WebElement selectVisaCountry(String country) {
		String xpath = "//label[text()='Visa Country']/parent::div/descendant::span[text()='" + country
				+ "']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}

	/* visa type button */
	@FindBy(xpath = "//label[text()='Type of Visa']/parent::div/descendant::button")
	private WebElement btnVisaType;

	/* visa type text box */
	@FindBy(xpath = "//label[text()='Type of Visa']/parent::div/descendant::input")
	private WebElement tbVisaType;

	/* select visa type */
	private WebElement selectVisaType(String type) {
		String xpath = "//label[text()='Type of Visa']/parent::div/descendant::span[text()='" + type + "']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}

	/* Visa from date */
	@FindBy(xpath = "L036")
	private WebElement dteVisaFrom;

	/* Visa to date */
	@FindBy(xpath = "L037")
	private WebElement dteVisaTo;

	/* Add visa details button */
	@FindBy(xpath = "//span[text()='Add VISA Details']/preceding-sibling::span")
	private WebElement btnAddVisaDetails;

	/* Edit visa */
	private WebElement selectEditVisa(String country) {
		String xpath = "//td[text()='" + country + "']/parent::tr/descendant::i[@title='Edit']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Delete visa */
	private WebElement selectDeleteVisa(String country) {
		String xpath = "//td[text()='" + country + "']/parent::tr/descendant::i[@title='Delete']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Update visa button */
	@FindBy(xpath = "//span[text()='Update VISA Details']/preceding-sibling::span")
	private WebElement btnUpdateVisa;

	/* Visa delete pop up */
	@FindBy(xpath = "//h4[text()='Delete Visa Details']")
	private WebElement txtDeleteVisaDetails;

	/* Pop up yes button */
	@FindBy(id = "btnYesConfirmYesNo")
	private WebElement btnYes;

	/* Pop up No button */
	@FindBy(id = "btnNoConfirmYesNo")
	private WebElement btnNo;

	/* Add new radio button of passport */
	@FindBy(xpath = "//strong[text()='Address On Passport']/parent::div/div/input[@id='PassportAdd']")
	private WebElement rbAddNew;

	/* Same as permanent radio button of passport */
	@FindBy(xpath = "//strong[text()='Address On Passport']/parent::div//label[text()='Same As Permanent']")
	private WebElement rbSameAsPermanent;

	/* Same as current radio button of passport */
	@FindBy(xpath = "//strong[text()='Address On Passport']/parent::div//label[text()='Same As Current']")
	private WebElement rbSameAsCurrent;

	/* Care of text box */
	@FindBy(xpath = "//label[text()='C/O']/following-sibling::input")
	private WebElement tbPassportCo;

	/* Address line1 of passport text box */
	@FindBy(xpath = "(//label[text()='Address Line 1']/following-sibling::input)[1]")
	private WebElement tbPassportAddressLine1;

	/* address line2 of passport text box */
	@FindBy(xpath = "(//label[text()='Address Line 2']/following-sibling::input)[1]")
	private WebElement tbPassportAddressLine2;

	/* passport country button */
	@FindBy(xpath = "//button[@data-id='L041']/span[@class='filter-option pull-left']")
	private WebElement btnPassportCountry;

	/* passport country text box */
	@FindBy(xpath = "(//label[text()='Country']/parent::div/descendant::input)[1]")
	private WebElement tbPassportCountry;

	/* passport country text */
	private WebElement selectPassportCountry(String country) {
		String xpath = "(//label[text()='Country']/parent::div/descendant::span[text()='" + country
				+ "']/parent::a)[1]";
		return driver.findElement(By.xpath(xpath));
	}

	/* passport state button */
	@FindBy(xpath = "//button[@data-id='L042']/span[@class='filter-option pull-left']")
	private WebElement btnPassportState;

	/* passport state text box */
	@FindBy(xpath = "(//label[text()='State']/parent::div/descendant::input)[1]")
	private WebElement tbPassportState;

	/* select passport state */
	private WebElement selectPassportState(String state) {
		String xpath = "//label[text()='State']/parent::div/descendant::span[text()='" + state + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* postal code of passport text box */
	@FindBy(xpath = "(//label[text()='Postal Code']/following-sibling::input[@type='text'])[1]")
	private WebElement tbPassportPostalCode;

	/* city of passport text box */
	@FindBy(xpath = "//label[text()='City']/following-sibling::input")
	private WebElement tbPassportcity;

	/* language button */
	@FindBy(xpath = "//label[text()='Language']/parent::div/descendant::button")
	private WebElement btnLanguage;

	/* language text box */
	@FindBy(xpath = "//label[text()='Language']/parent::div/descendant::input")
	private WebElement tbLanguage;

	/* language text */
	private WebElement selectLang(String language) {
		String xpath = "//label[text()='Language']/parent::div/descendant::span[text()='" + language + "']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}

	/* veterans text */
	@FindBy(xpath = "//span[text()='Veterans']")
	private WebElement txtVeterans;

	/* protected veterans radio button */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I identify as one or more of the classifications of protected veterans listed above.']")
	private WebElement rbProtectedVeterans;

	/* protected veterans selected radio button */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I identify as one or more of the classifications of protected veterans listed above.']/preceding-sibling::input")
	private WebElement rbProtectedVeteransSeleted;

	/* Not protected veterans radio button */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I am not a protected veteran.']")
	private WebElement rbNotProtectedVeterans;

	/* Not protected veterans radio button selected */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I am not a protected veteran.']/preceding-sibling::input")
	private WebElement rbNotProtectedVeteransSelected;

	/* Not to self identify radio button */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I choose not to self identify.']")
	private WebElement rbnNotToSelfIdentify;

	/* Not to self identify radio button */
	@FindBy(xpath = "//span[text()='Veterans']/parent::label/following::div/label[text()='I choose not to self identify.']/preceding-sibling::input")
	private WebElement rbnNotToSelfIdentifySelected;

	/* no disability radio button */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='NO, I DON’T HAVE A DISABILITY']")
	private WebElement rbNoDisability;

	/* no disability Selected radio button */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='NO, I DON’T HAVE A DISABILITY']/preceding-sibling::input")
	private WebElement rbNoDisabilitySelected;

	/* yes disability radio button */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='YES, I HAVE A DISABILITY (or previously had a disability)']")
	private WebElement rbYesDisabality;

	/* yes disability radio button selected */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='YES, I HAVE A DISABILITY (or previously had a disability)']/preceding-sibling::input")
	private WebElement rbYesDisabalitySelected;

	/* disability Type text box */
	@FindBy(xpath = "//label[text()='Disability Type']/following-sibling::input")
	private WebElement tbDisabilityType;

	/* don’t wish to answer radio button */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='I DON’T WISH TO ANSWER']")
	private WebElement rbDontWishToAnswer;

	/* don’t wish to answer Selected radio button */
	@FindBy(xpath = "//span[text()='Differently Abled']/parent::label/parent::div//label[text()='I DON’T WISH TO ANSWER']/preceding-sibling::input")
	private WebElement rbDontWishToAnswerSelected;

	/* SSN number text box */
	@FindBy(xpath = "//label[text()='SSN Number']/parent::div/child::input[@type='text']")
	private WebElement tbSsnNumber;

	/* veterans pop up */
	@FindBy(xpath = "//div[@class='veterans_pop']")
	private WebElement taVeterans;

	/* emergency contact title button */
	@FindBy(xpath = "//label[text()='Title']/parent::div/descendant::button")
	private WebElement btnEmergencyTitle;

	/* emergency contact title text box */
	@FindBy(xpath = "//label[text()='Title']/parent::div/descendant::input")
	private WebElement tbEmergencyTitle;

	/* emergency contact title text */
	/* language text */
	private WebElement selectEmergencyTitle(String title) {
		String xpath = "//label[text()='Title']/parent::div/descendant::span[text()='" + title + "']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}

	/* emergency contact name text box */
	@FindBy(xpath = "//label[text()='Name']/following-sibling::input")
	private WebElement tbEmergencyName;

	/* emergency contact telephone no text box **/
	@FindBy(xpath = "//label[text()='Mobile Number']/following-sibling::input[@type='text']")
	private WebElement tbEmergencyMobileNumber;

	/* emergency contact telephone no text box **/
	@FindBy(xpath = "//label[text()='Telephone Number']/following-sibling::input[@type='text']")
	private WebElement tbEmergencyTelephoneNumber;

	/* emergency contact address line1 text box */
	@FindBy(xpath = "(//label[text()='Address Line 1']/following-sibling::input)[2]")
	private WebElement tbEmergencyAddressLine1;

	/* emergency contact address line2 text box */
	@FindBy(xpath = "(//label[text()='Address Line 2']/following-sibling::input)[2]")
	private WebElement tbEmergencyAddressLine2;

	/* emergency contact apartment text box */
	@FindBy(xpath = "//label[text()='Apartment']/following-sibling::input")
	private WebElement tbEmergencyApartment;

	/* emergency contact country button */
	@FindBy(xpath = "(//label[text()='Country']/parent::div/descendant::button)[2]")
	private WebElement btnEmergencyCountry;

	/* emergency contact country text box */
	@FindBy(xpath = "(//label[text()='Country']/parent::div/descendant::input)[2]")
	private WebElement tbEmergencyCountry;

	/* emergency contact country text */
	private WebElement selectEmergencyContactCountry(String country) {
		String xpath = "(//label[text()='Country']/parent::div/descendant::span[text()='" + country
				+ "']/parent::a)[2]";
		return driver.findElement(By.xpath(xpath));
	}

	/* emergency contact state button */
	@FindBy(xpath = "(//label[text()='State']/parent::div/descendant::button)[2]")
	private WebElement btnEmergencyState;

	/* emergency contact state text box */
	@FindBy(xpath = "(//label[text()='State']/parent::div/descendant::input)[2]")
	private WebElement tbEmergencyState;

	/* emergency contact state text */
	private WebElement selectEmergencyContactState(String state) {
		String xpath = "//h4[text()='Emergency Contact Details ']/ancestor::div[2]/descendant::span[text()='" + state
				+ "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* emergency contact postal code */
	@FindBy(xpath = "(//label[text()='Postal Code']/following-sibling::input[@type='text'])[2]")
	private WebElement tbEmergencyPostalCode;

	/* continue button */
	@FindBy(id = "ContinueButton")
	private WebElement btnContinue;

	/* save as draft button */
	@FindBy(id = "savebutton")
	private WebElement btnSaveAsDraft;

	/* spinner */
	@FindBy(xpath = "//div[@class='loader2 material-spinner']")
	private WebElement spinner;

	/**
	 * Description:This Method implements to click on 'No' radio button of do you
	 * have passport
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkNoPassportRb() {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.waitForElement(rbPassportNo, "No radio button");
			WebActionUtil.clickOnElement(rbPassportNo, "No radio button ",
					"Unable to click on No radio button of do you have Passport");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on No radio button of do you have Passport");
			WebActionUtil.error("Unable to click on No radio button of do you have Passport");
			Assert.fail("Unable to click on No radio button of do you have Passport");
		}
	}

	/**
	 * Description:This Method implements to click on 'Yes' radio button of do you
	 * have Passport
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkYesPassportRb() {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.waitForElement(rbPassportYes, "Yes radio button");
			WebActionUtil.clickOnElement(rbPassportYes, "Yes radio button ",
					"Unable to click on Yes radio button of do you have Passport");
			validateDoYouHavePassportFields();
			WebActionUtil.poll(1000);
			validateDoYouHaveVisa();
			WebActionUtil.poll(1000);
			validateAddressOnPassport();
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Yes radio button of do you have Passport");
			WebActionUtil.error("Unable to click on Yes radio button of do you have Passport");
			Assert.fail("Unable to click on Yes radio button of do you have Passport");
		}
	}

	/**
	 * Description:This Method implements to enter data into passport fields of do
	 * you have passport
	 * 
	 * @author Abhilash
	 * @param passportNumber
	 * @param placeOfIssue
	 * @param issuingAuthority
	 * @param dateOfIssue
	 * @param dateOfExpiry
	 */
	public synchronized void setPassportFields(String passportNumber, String placeOfIssue, String issuingAuthority,
			String dateOfIssue, String dateOfExpiry) {
		try {
			WebActionUtil.poll(2000);

			WebActionUtil.waitForElement(tbPassportNumber, "Passport Number");
			WebActionUtil.typeText(tbPassportNumber, passportNumber, "Passport Number");

			WebActionUtil.waitForElement(tbPlaceOfIssue, "Place Of Issue");
			WebActionUtil.typeText(tbPlaceOfIssue, placeOfIssue, "Place Of Issue");

			WebActionUtil.waitForElement(tbIssuingAuthority, "Issuing Authority");
			WebActionUtil.typeText(tbIssuingAuthority, issuingAuthority, "Issuing Authority");

			WebActionUtil.waitForElement(dteDateOfIssue, "Date Of Issue");
			selectDate(dateOfIssue, "L032");

			WebActionUtil.waitForElement(dteDateOfExpiry, "Date Of Expiry");
			selectDate(dateOfExpiry, "L033");

			validatePassportEnteredValues(passportNumber, placeOfIssue, issuingAuthority, dateOfIssue, dateOfExpiry);
		} catch (Exception e) {
			WebActionUtil.fail("Unable to enter data into Passport fields");
			WebActionUtil.error("Unable to enter data into Passport fields");
			Assert.fail("Unable to enter data into Passport fields");
		}

	}

	/**
	 * Description:This Method implements to click on No radio button of do you have
	 * visa
	 * 
	 * @author Abhilash
	 * 
	 */
	public synchronized void clkNoVisaRb() {
		try {
			WebActionUtil.clickOnElement(rbVisaNo, "No radio button",
					"Unable to click on No radio button of do you have visa");
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.validateisElementSelected(rbVisaNo, "No radio button",
					"No radio button of do you have visa is selected",
					"No radio button of do you have visa is not selected", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on No radio button of do you have visa");
			WebActionUtil.error("Unable to click on No radio button of do you have visa");
			Assert.fail("Unable to click on No radio button of do you have visa");
		}

	}

	/**
	 * Description:This Method implements to enter data into visa fields of do you
	 * have visa
	 * 
	 * @author Abhilash
	 * @param visaCountry
	 * @param visaType
	 * @param visaFromDate
	 * @param visaToDate
	 */
	public synchronized void setVisaFields(String visaCountry, String visaType, String visaFromDate,
			String visaToDate) {
		try {
			WebActionUtil.waitForElement(btnVisaCountry, "Visa country drop down");
			WebActionUtil.clickOnElement(btnVisaCountry, "Visa country drop down",
					"Unable to click on Visa country drop down");
			WebActionUtil.waitForElement(tbVisaCountry, "Visa country text box");
			WebActionUtil.typeText(tbVisaCountry, visaCountry, "Visa country text box");
			WebActionUtil.waitForElement(selectVisaCountry(visaCountry), "Visa country");
			WebActionUtil.clickOnElement(selectVisaCountry(visaCountry), visaCountry, "Unable to select Visa country");

			WebActionUtil.waitForElement(btnVisaType, "Visa type drop down");
			WebActionUtil.clickOnElement(btnVisaType, "Visa type drop down", "Unable to click on Visa type dropdown");
			WebActionUtil.waitForElement(tbVisaType, "Visa type text box");
			WebActionUtil.typeText(tbVisaType, visaType, "Visa type text box");
			WebActionUtil.waitForElement(selectVisaType(visaType), "Visa type");
			WebActionUtil.clickOnElement(selectVisaType(visaType), visaType, "Unable to select Visa type");

			selectDate(visaFromDate, "L036");

			selectDate(visaToDate, "L037");

			WebActionUtil.clickOnElement(btnAddVisaDetails, "Add visa ", "Unable to click on Add visa");
			WebActionUtil.waitForAngularPageload();
			validateVisaEnteredValues(visaCountry, visaType);
		} catch (Exception e) {
			WebActionUtil.fail("Unable to enter Visa details");
			WebActionUtil.error("Unable to enter Visa details");
			Assert.fail("Unable to enter Visa details");
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
	 * Description:This Method implements to click on same as permanent radio button
	 * of address on passport
	 * 
	 * @author Abhilash
	 * @param co
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param city
	 * @param postalCode
	 */
	public synchronized void clkSameAsPermanentRb(String co, String addressLine1, String addressLine2, String country,
			String state, String city, String postalCode) {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.clickOnElement(rbSameAsPermanent, "Same as permanent radio button ",
					"Unable to click on Same as permanent radio button of address on passport");
			WebActionUtil.waitForAngularPageload();
			validateAddAddressFieldsOnPassport(co, addressLine1, addressLine2, country, state, city, postalCode);
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Same as permanent radio button of address on passport");
			WebActionUtil.error("Unable to click on Same as permanent radio button of address on passport");
			Assert.fail("Unable to click on Same as permanent radio button of address on passport");
		}

	}

	/**
	 * Description:This Method implements to click on same as current radio button
	 * of address on passport
	 * 
	 * @author Abhilash
	 * @param co
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param postalCode
	 * @param city
	 */

	public synchronized void clkSameAsCurrentRb(String co, String addressLine1, String addressLine2, String country,
			String state, String city, String postalCode) {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.clickOnElement(rbSameAsCurrent, "Same as current radio button",
					"Unable to click on Same as current radio button of address on passport");
			WebActionUtil.waitForAngularPageload();
			validateAddAddressFieldsOnPassport(co, addressLine1, addressLine2, country, state, city, postalCode);
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Same as current radio button of address on passport");
			WebActionUtil.error("Unable to click on Same as current radio button of address on passport");
			Assert.fail("Unable to click on Same as current radio button of address on passport");
		}

	}

	/**
	 * Description:This Method implements to set address on passport
	 * 
	 * @author Abhilash
	 * @param co
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param city
	 * @param postalCode
	 */

	public synchronized void setPassportAddress(String co, String addressLine1, String addressLine2, String country,
			String state, String city, String postalCode) {
		try {
			WebActionUtil.waitForAngularPageload();

			WebActionUtil.waitForElement(tbPassportCo, "c/o text box");
			WebActionUtil.typeText(tbPassportCo, co, "c/o text box");
			WebActionUtil.waitForElement(tbPassportAddressLine1, "Address Line1 text box");
			WebActionUtil.typeText(tbPassportAddressLine1, addressLine1, "Address Line1 text box");
			WebActionUtil.waitForElement(tbPassportAddressLine2, "Address Line2 text box");
			WebActionUtil.typeText(tbPassportAddressLine2, addressLine2, "Address Line2 text box");

			WebActionUtil.waitForElement(btnPassportCountry, "Passport Country button");
			WebActionUtil.clickOnElement(btnPassportCountry, "Passport Country button",
					"Unable to click on Passport Country button");
			WebActionUtil.waitForElement(tbPassportCountry, "Passport Country text box");
			WebActionUtil.typeText(tbPassportCountry, country, "Passport Country text box");
			WebActionUtil.clickOnElement(selectPassportCountry(country), "Passport Country",
					"Unable to click on Passport Country");

			WebActionUtil.waitForElement(btnPassportState, "Passport State dropdown");
			WebActionUtil.clickOnElement(btnPassportState, "Passport State dropdown",
					"Unable to click on Passport State dropdown");
			WebActionUtil.typeText(tbPassportState, state, "Passport State text box");
			WebActionUtil.clickOnElement(selectPassportState(state), "Passport State",
					"Unable to click on Passport State");

			WebActionUtil.waitForElement(tbPassportcity, "Passport City text box");
			WebActionUtil.typeText(tbPassportcity, city, "Passport City text box");

			WebActionUtil.waitForElement(tbPassportPostalCode, "Postal Code text box");
			WebActionUtil.typeText(tbPassportPostalCode, postalCode, "Postal Code text box");

		} catch (Exception e) {
			WebActionUtil.fail("Unable to add address of passport");
			WebActionUtil.error("Unable to add address of passport");
			Assert.fail("Unable to add address of passport");
		}

	}

	/**
	 * Description:This Method implements to select language in additional
	 * information
	 * 
	 * @author Abhilash
	 * @param language
	 */
	public synchronized void selectLanguage(String language) {
		try {
			WebActionUtil.waitForElement(btnLanguage, "Language radio button");
			WebActionUtil.clickOnElement(btnLanguage, "Language radio button",
					"Unable to click on Language radio button");
			WebActionUtil.waitForElement(tbLanguage, "Language text box");
			WebActionUtil.typeText(tbLanguage, language, "Language text box");
			WebActionUtil.waitForElement(selectLang(language), "Language text");
			WebActionUtil.clickOnElement(selectLang(language), "Language text", "Unable to click on Language option");
			WebActionUtil.validateAttribute(btnLanguage, "title", language, "Language",
					"Valid language is selected from Language drop down",
					"Unable to select valid language from Language drop down", "blue");

		} catch (Exception e) {
			WebActionUtil.fail("Unable to select valid language from Language drop down");
			WebActionUtil.error("Unable to select valid language from Language drop down");
			Assert.fail("Unable to select valid language from Language drop down");
		}

	}

	/**
	 * Description:This Method implements to mouse over veterans
	 * 
	 * @author Abhilash
	 */
	public synchronized void mouseOverVeterans() {
		try {
			WebActionUtil.waitForElement(txtVeterans, "Veterans");
			WebActionUtil.actionMouseOver(txtVeterans, "Veterans");
			WebActionUtil.waitForElement(taVeterans, "EX Serviceman pop up");
			WebActionUtil.validateisElementDisplayed(taVeterans, "EX Serviceman pop up",
					"EX Serviceman pop up is displayed", "EX Serviceman pop up is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to mouse over Veterans");
			WebActionUtil.error("Unable to mouse over Veterans");
			Assert.fail("Unable to mouse over Veterans");
		}

	}

	/**
	 * Description:This Method implements to click protected veteran in additional
	 * information
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkProtectedVeteran() {
		try {
			WebActionUtil.waitForElement(rbProtectedVeterans, "Protected Veterans");
			WebActionUtil.clickOnElement(rbProtectedVeterans, "Protected Veterans",
					"Unable to click on protected veteran radio button");
			WebActionUtil.validateisElementSelected(rbProtectedVeteransSeleted, "Protected Veterans radio button",
					"Protected Veteran radio button is selected", "Unable to select protected veteran radio button",
					"blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select Protected Veteran radio button");
			WebActionUtil.error("Unable to select Protected Veteran radio button");
			Assert.fail("Unable to select Protected Veteran radio button");
		}

	}

	/**
	 * Description:This Method implements to click Not a protected veteran in
	 * additional information
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkNotProtectedVeteran() {
		try {

			WebActionUtil.waitForElement(rbNotProtectedVeterans, "Not a Protected Veteran");
			WebActionUtil.clickOnElement(rbNotProtectedVeterans, "Not a Protected Veteran",
					"Unable to click on Not a Protected Veteran radio button");
			WebActionUtil.validateisElementSelected(rbNotProtectedVeteransSelected,
					"Not a Protected Veterans radio button", "Not a Protected Veteran radio button is selected",
					"Unable to select Not a Protected Veteran radio button", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select Not a Protected Veteran radio button");
			WebActionUtil.error("Unable to select Not a Protected Veteran radio button");
			Assert.fail("Unable to select Not a Protected Veteran radio button");
		}
	}

	/**
	 * Description:This Method implements to click Not to self Identify in
	 * additional information
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkNotToSelfIdentify() {
		try {
			WebActionUtil.waitForElement(rbnNotToSelfIdentify, "Not to Self Identify radio button");
			WebActionUtil.clickOnElement(rbnNotToSelfIdentify, "Not to Self Identify radio button",
					"Unable to click on Not to Self Identify radio button");
			WebActionUtil.validateisElementSelected(rbnNotToSelfIdentifySelected, "Not to Self Identify radio button",
					"Not to Self Identify radio button is selected",
					"Unable to select Not to Self Identify radio button", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select Not to Self Identify radio button");
			WebActionUtil.error("Unable to select Not to Self Identify radio button");
			Assert.fail("Unable to select Not to Self Identify radio button");
		}

	}

	/**
	 * Description:This Method implements to enter ssn number
	 * 
	 * @author Abhilash
	 * @param ssnNumber
	 */
	public synchronized void setSSNnumber(String ssnNumber) {
		try {
			WebActionUtil.waitForElement(tbSsnNumber, "SSN number text box");
			WebActionUtil.clearText(tbSsnNumber, "SSN number text box");
			WebActionUtil.typeText(tbSsnNumber, ssnNumber, "SSN number text box");
			WebActionUtil.validateEnteredValue1(WebActionUtil.getTextUsingJS("L028"), ssnNumber, "SSN number text box",
					ssnNumber + " value entered in SSN number text box", "Unable to enter value in SSN number text box",
					"blue");

		} catch (Exception e) {
			WebActionUtil.fail("Unable to enter value in SSN number text box");
			WebActionUtil.error("Unable to enter value in SSN number text box");
			Assert.fail("Unable to enter value in SSN number text box");
		}

	}

	/**
	 * Description:This Method implements to click No disability in additional
	 * information
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkNoDisablity() {
		try {
			WebActionUtil.scrollToElement(rbNoDisability, "No disability radio button");
			WebActionUtil.waitForElement(rbNoDisability, "No disability radio button");
			WebActionUtil.clickOnElement(rbNoDisability, "No disability radio button",
					"Unable to click on no disability radio button");
			WebActionUtil.validateisElementSelected(rbNoDisabilitySelected, "No disability radio button",
					"No disability radio button is selected", "Unable to select No disability radio button", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select No disability radio button");
			WebActionUtil.error("Unable to select No disability radio button");
			Assert.fail("Unable to select No disability radio button");
		}

	}

	/**
	 * Description:This Method implements to click yes i have disability in
	 * additional information
	 * 
	 * @author Abhilash
	 * @param disbalityType
	 */
	public synchronized void clkYesDisablity(String disbalityType) {
		try {
			WebActionUtil.scrollToElement(rbYesDisabality, "Yes i have disability radio button");
			WebActionUtil.waitForElement(rbYesDisabality, "Yes i have disability radio button");
			WebActionUtil.clickOnElement(rbYesDisabality, "Yes i have disability radio button",
					"Unable to click on Yes i have disability radio button");
			WebActionUtil.validateisElementSelected(rbYesDisabalitySelected, "Yes i have disability radio button",
					"Yes i have disability radio button is selected",
					"Unable to select Yes i have disability radio button", "blue");
			WebActionUtil.waitForElement(tbDisabilityType, "Disability type");
			WebActionUtil.typeText(tbDisabilityType, disbalityType, "Disability type");
			WebActionUtil.validateEnteredValue1(WebActionUtil.getTextUsingJS("L027"), disbalityType, "Disability type",
					disbalityType + " value entered in Disability type", "Unable to enter value in Disability type",
					"blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select Yes i have disability radio button");
			WebActionUtil.error("Unable to select Yes i have disability radio button");
			Assert.fail("Unable to select Yes i have disability radio button");
		}

	}

	/**
	 * Description:This Method implements to click I don't wish to answer in
	 * additional information
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkDontWishToAnswer() {
		try {
			WebActionUtil.scrollToElement(rbDontWishToAnswer, "I dont wish to answer radio button");
			WebActionUtil.waitForElement(rbDontWishToAnswer, "I dont wish to answer radio button");
			WebActionUtil.clickOnElement(rbDontWishToAnswer, "I dont wish to answer radio button",
					"Unable to click on i dont wish to answer radio button");
			WebActionUtil.validateisElementSelected(rbDontWishToAnswerSelected, "I dont wish to answer radio button",
					"I dont wish to answer radio button is selected",
					"Unable to select I dont wish to answer radio button", "blue");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select I dont wish to answer radio button");
			WebActionUtil.error("Unable to select I dont wish to answer radio button");
			Assert.fail("Unable to select I dont wish to answer radio button");
		}

	}

	/**
	 * Description:This Method implements to set emergency contact details
	 * 
	 * @author Abhilash
	 * @param title
	 * @param name
	 * @param mobileNumber
	 * @param telephoneNumber
	 * @param apartment
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param postalcode
	 */
	public synchronized void setEmergencyContactDetails(String title, String name, String mobileNumber,
			String telephoneNumber, String apartment, String addressLine1, String addressLine2, String country,
			String state, String postalCode) {
		try {
			WebActionUtil.waitForElement(btnEmergencyTitle, "Title");
			WebActionUtil.clickOnElement(btnEmergencyTitle, "Title", "Unable to click on Title drop down");
			WebActionUtil.waitForElement(tbEmergencyTitle, "Title text box");
			WebActionUtil.typeText(tbEmergencyTitle, title, "Title text box");
			WebActionUtil.waitForElement(selectEmergencyTitle(title), "Title text box");
			WebActionUtil.clickOnElement(selectEmergencyTitle(title), "Title text box",
					"Unable to click on Title text box");

			WebActionUtil.waitForElement(tbEmergencyName, "Name text box");
			WebActionUtil.typeText(tbEmergencyName, name, "Name text box");

			WebActionUtil.waitForElement(tbEmergencyMobileNumber, "Mobile number text box");
			WebActionUtil.typeText(tbEmergencyMobileNumber, mobileNumber, "Mobile number text box");

			WebActionUtil.waitForElement(tbEmergencyTelephoneNumber, "Telephone number text box");
			WebActionUtil.typeText(tbEmergencyTelephoneNumber, telephoneNumber, "Telephone number text box");

			WebActionUtil.waitForElement(tbEmergencyAddressLine1, "Address line1 text box");
			WebActionUtil.typeText(tbEmergencyAddressLine1, addressLine1, "Address line1 text box");

			WebActionUtil.waitForElement(tbEmergencyAddressLine2, "Address line2 text box");
			WebActionUtil.typeText(tbEmergencyAddressLine2, addressLine2, "Address line2 text box");

			WebActionUtil.waitForElement(tbEmergencyApartment, "Apartment text box");
			WebActionUtil.typeText(tbEmergencyApartment, apartment, "Apartment text box");

			WebActionUtil.waitForElement(btnEmergencyCountry, "Country");
			WebActionUtil.clickOnElement(btnEmergencyCountry, "Country", "Unable to click on Country drop down");
			WebActionUtil.typeText(tbEmergencyCountry, country, "Country text box");
			WebActionUtil.actionClick(selectEmergencyContactCountry(country), "Country text box");

			WebActionUtil.waitForElement(btnEmergencyState, "State");
			WebActionUtil.clickOnElement(btnEmergencyState, "State", "Unable to click on State drop down");
			WebActionUtil.typeText(tbEmergencyState, state, "State text box");
			WebActionUtil.actionClick(selectEmergencyContactState(state), "State Dropdown");

			WebActionUtil.waitForElement(tbEmergencyPostalCode, "Postal code text box");
			WebActionUtil.typeText(tbEmergencyPostalCode, postalCode, "Postal code text box");
			validateEmergencyContactFields(title, name, mobileNumber, telephoneNumber, apartment, addressLine1,
					addressLine2, country, state, postalCode);

		} catch (Exception e) {
			WebActionUtil.fail("Unable to add address of Emergency contact");
			WebActionUtil.error("Unable to add address of Emergency contact");
			Assert.fail("Unable to add address of Emergency contact");
		}

	}

	/**
	 * Description:This Method implements to click on continue Button
	 * 
	 * @author Abhilash
	 * @param EducationalInfoPageUrl
	 */
	public synchronized void clkContinue(String EducationalInfoPageUrl) {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			WebActionUtil.waitForElement(btnContinue, "Continue button");
			WebActionUtil.clickOnElement(btnContinue, "Continue button", "Unable to click on Continue button");
			validateEducationDetailsPage(EducationalInfoPageUrl);
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Continue button");
			WebActionUtil.error("Unable to click on Continue button");
			Assert.fail("Unable to click on Continue button");
		}

	}

	/**
	 * Description:This Method implements to click on SaveAsDraft Button
	 * 
	 * @author Abhilash
	 * 
	 */
	public synchronized void clkSaveAsDraft() {
		try {
			WebActionUtil.waitForElement(btnSaveAsDraft, "Save As Draft button");
			WebActionUtil.clickOnElement(btnSaveAsDraft, "Save As Draft button",
					"Unable to click on Save As Draft button");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Save As Draft button");
			WebActionUtil.error("Unable to click on Save As Draft button");
			Assert.fail("Unable to click on Save As Draft button");
		}

	}

	/**
	 * Description:This Method implements to validate passport fields
	 * 
	 * @author Abhilash
	 * 
	 */

	private synchronized void validateDoYouHavePassportFields() {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.waitForElement(tbPassportNumber, "Passport number");
			WebActionUtil.waitForElement(tbPlaceOfIssue, "Place of issue");
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(tbPassportNumber.isDisplayed());
			arraylist.add(tbPlaceOfIssue.isDisplayed());
			arraylist.add(tbIssuingAuthority.isDisplayed());
			arraylist.add(dteDateOfIssue.isDisplayed());
			arraylist.add(dteDateOfExpiry.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"Passport number,Place of Issue and Issuing Authority fields are displayed", "blue");
				WebActionUtil.validationinfo("Passport Date of Issue, Date of expiry fields are displayed", "blue");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Passport number,Place of Issue and Issuing Authority fields are not displayed");
			WebActionUtil.fail("Passport Date of Issue, Date of expiry fields are not displayed");
			WebActionUtil.error(
					"Passport number, Place of Issue, Issuing Authority, Date of Issue, Date of expiry fields are not displayed");
			Assert.fail(
					"Passport number, Place of Issue, Issuing Authority, Date of Issue, Date of expiry fields are not displayed");
		}

	}

	/**
	 * Description:This Method implements to validate address on passport
	 * 
	 * @author Abhilash
	 */
	private synchronized void validateAddressOnPassport() {
		try {
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(rbAddNew.isSelected());
			arraylist.add(rbSameAsPermanent.isDisplayed());
			arraylist.add(rbSameAsCurrent.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"Address on passport with Add new, Same as Permanent and Same as current radio buttons are displayed",
						"blue");
				WebActionUtil.info(
						"Address on passport with Add new ,Same as Permanent and Same as current radio buttons are displayed");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail(
					"Address on passport with Add new ,Same as Permanent and Same as current radio buttons are not displayed");
			WebActionUtil.error(
					"Address on passport with Add new ,Same as Permanent and Same as current radio buttons are not displayed");
			Assert.fail(
					"Address on passport with Add new ,Same as Permanent and Same as current radio buttons are not displayed");

		}
		try {
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(tbPassportCo.isDisplayed());
			arraylist.add(tbPassportAddressLine1.isDisplayed());
			arraylist.add(tbPassportAddressLine2.isDisplayed());
			arraylist.add(tbPassportPostalCode.isDisplayed());
//			arraylist.add(tbPassportCountry.isDisplayed());
//			arraylist.add(tbPassportState.isDisplayed());

			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"c/o, Address line1, Address line2, Postal code, City, Country and State are displayed",
						"blue");
				WebActionUtil
						.info("c/o, Address line1, Address line2, Postal code, City, Country and State are displayed");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil
					.fail("c/o, Address line1, Address line2, Postal code, City, Country and State are not displayed");
			WebActionUtil
					.error("c/o, Address line1, Address line2, Postal code, City, Country and State are not displayed");
			Assert.fail("c/o, Address line1, Address line2, Postal code, City, Country and State are not displayed");
		}
	}

	/**
	 * Description:This Method implements to validate entered values in passport
	 * 
	 * @author Abhilash
	 * @param passportNumber
	 * @param placeOfIssue
	 * @param issuingAuthority
	 * @param dateOfIssue
	 * @param dateOfexpiry
	 */

	private synchronized void validatePassportEnteredValues(String passportNumber, String placeOfIssue,
			String issuingAuthority, String dateOfIssue, String dateOfExpiry) {
		try {
			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(WebActionUtil.getTextUsingJS("L029").equals(passportNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L030").equals(placeOfIssue));
			arraylist.add(WebActionUtil.getTextUsingJS("L031").equals(issuingAuthority));
			arraylist.add(WebActionUtil.getTextUsingJS("L032").equals(dateOfIssue));
			arraylist.add(WebActionUtil.getTextUsingJS("L033").equals(dateOfExpiry));
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Valid data is reflected in the Passport fields", "green");
				WebActionUtil.info("Valid data is reflected in the Passport fields");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Valid data is not reflected in the Passport fields");
			WebActionUtil.error("Valid data is not reflected in the Passport fields");
			Assert.fail("Valid data is not reflected in the Passport fields");
		}
	}

	/**
	 * Description:This Method implements to validate entered values in visa
	 * 
	 * @author Abhilash
	 * @param visaCountry
	 * @param visaType
	 * 
	 */
	private synchronized void validateVisaEnteredValues(String visaCountry, String visaType) {
		try {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myTable02"))));
			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(driver.findElement(By.xpath(
					"//th[text()='Visa Country']/parent::tr/following-sibling::tr/td[text()='" + visaCountry + "']"))
					.isDisplayed());
			arraylist.add(driver
					.findElement(By.xpath(
							"//th[text()='Visa Type']/parent::tr/following-sibling::tr/td[text()='" + visaType + "']"))
					.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Data is selected and displayed in Add visa details table", "green");
				WebActionUtil.info("Data is selected and displayed in Add visa details table");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Selected data is not displayed in Add visa details table");
			WebActionUtil.error("Selected data is not displayed in Add visa details table");
			Assert.fail("Selected data is not displayed in Add visa details table");
		}
		try {
			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(btnVisaCountry.getAttribute("title").equals("Select"));
			arraylist.add(btnVisaType.getAttribute("title").equals("Select"));
			arraylist.add(WebActionUtil.getTextUsingJS("L036").equals(""));
			arraylist.add(WebActionUtil.getTextUsingJS("L037").equals(""));
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Visa country, Type of visa, From date and To date fields are cleared",
						"green");
				WebActionUtil.info("Visa country, Type of visa, From date and To date fields are cleared");
			} else
				throw new Exception();
		} catch (Exception e) {

			WebActionUtil.fail("Visa country, Type of visa, From date and To date fields are cleared are not cleared");
			WebActionUtil.error("Visa country, Type of visa, From date and To date fields are cleared are not cleared");
			Assert.fail("Visa country, Type of visa, From date and To date fields are cleared are not cleared");
		}
	}

	/**
	 * Description:This Method implements to validate address fields on passport
	 * 
	 * @author Abhilash
	 * @param co
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param postalCode
	 * @param city
	 */
	private synchronized void validateAddAddressFieldsOnPassport(String co, String addressLine1, String addressLine2,
			String country, String state, String city, String postalCode) {
		try {
			if (rbAddNew.isSelected()) {
				WebActionUtil.validationinfo("Add new radio button is selected by default", "blue");
			} else if (rbSameAsPermanent.isDisplayed()) {
				WebActionUtil.validationinfo("Same as permanent radio button is selected", "blue");
			} else if (rbSameAsCurrent.isDisplayed()) {
				WebActionUtil.validationinfo("Same as current radio button is selected", "blue");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select radio button to add Address on Passport");
			WebActionUtil.error("Unable to select radio button to add Address on Passport");
			Assert.fail("Unable to select radio button to add Address on Passport");
		}
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(tbPassportCo));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(tbPassportAddressLine1));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(tbPassportAddressLine2));

			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(WebActionUtil.getTextUsingJS("L038").contains(co));
			arraylist.add(WebActionUtil.getTextUsingJS("L039").equals(addressLine1));
			arraylist.add(WebActionUtil.getTextUsingJS("L040").equals(addressLine2));
			arraylist.add(btnPassportCountry.getText().equals(country));
			arraylist.add(btnPassportState.getText().equals(state));
			arraylist.add(WebActionUtil.getTextUsingJS("L043").equals(city));
			arraylist.add(WebActionUtil.getTextUsingJS("L044").equals(postalCode));

			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"Valid data is displayed in c/o, address line1, address line2, country, state, city and postal code",
						"green");
				WebActionUtil.info(
						"Valid data is displayed in c/o, address line1, address line2, country, state, city and postal code");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail(
					"Valid data is not displayed in c/o, address line1, address line2, country, state, city and postal code");
			WebActionUtil.error(
					"Valid data is not displayed in c/o, address line1, address line2, country, state, city and postal code");
			Assert.fail(
					"Valid data is not displayed in c/o, address line1, address line2, country, state, city and postal code");
		}
	}

	/**
	 * Description:This Method implements to validate emergency contact details
	 * 
	 * @author Abhilash
	 * @param title
	 * @param name
	 * @param mobileNumber
	 * @param telephoneNumber
	 * @param apartment
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param postalcode
	 */
	private synchronized void validateEmergencyContactFields(String title, String name, String mobileNumber,
			String telephoneNumber, String apartment, String addressLine1, String addressLine2, String country,
			String state, String postalCode) {

		try {
			ArrayList<Boolean> arraylist = new ArrayList<>();

			arraylist.add(btnEmergencyTitle.getAttribute("title").equals(title));
			arraylist.add(WebActionUtil.getTextUsingJS("L047").equals(name));
			arraylist.add(WebActionUtil.getTextUsingJS("L048").equals(mobileNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L049").equals(telephoneNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L050").equals(addressLine1));
			arraylist.add(WebActionUtil.getTextUsingJS("L051").equals(addressLine2));
			arraylist.add(WebActionUtil.getTextUsingJS("L052").equals(apartment));
			arraylist.add(WebActionUtil.getTextUsingJS("L055").equals(postalCode));
			WebActionUtil.waitForAngularPageToLoad();
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"Valid data is displayed in Title, Name, Mobile number, Telephone number, Address line1, Address line2 of Emergency Contact",
						"green");
				WebActionUtil.validationinfo(
						"Valid data is displayed in Country, State and Postal code of Emergency Contact", "green");
				WebActionUtil.info(
						"Valid data is displayed in Title, Name, Mobile number, Telephone number, Address line1, Address line2 of Emergency Contact");
				WebActionUtil.info("Valid data is displayed in Country, State and Postal code of Emergency Contact");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail(
					"Valid data is not displayed in title, name, mobile number, telephone number, address line1, address line2 of emergency contact");
			WebActionUtil.fail("Valid data is not displayed in country, state and postal code of emergency contact");
			WebActionUtil.error(
					"Valid data is not displayed in title, name, mobile number, telephone number, address line1, address line2 of emergency contact");
			WebActionUtil.error("Valid data is not displayed in country, state and postal code of emergency contact");
			Assert.fail(
					"Valid data is not displayed in title, name, mobile number, telephone number, address line1, address line2, country, state and postal code of emergency contact");
		}
	}

	/**
	 * Description:This Method to validate Education details page is displayed
	 * 
	 * @author Abhilash
	 * @param EducationalInfoPageUrl
	 * 
	 */
	private synchronized void validateEducationDetailsPage(String EducationalInfoPageUrl) {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			if (spinner.isDisplayed())
				new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(spinner));
			WebActionUtil.waitForAngularPageToLoad();
			if (spinner.isDisplayed())
				new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(spinner));
			new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(EducationalInfoPageUrl));
			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(driver.getCurrentUrl().equals(EducationalInfoPageUrl));
			arraylist.add(driver.findElement(By.xpath("//h4[text()='Educational Details ']")).isDisplayed());
			if (!arraylist.contains(false))
				WebActionUtil.validationinfo("Education details page is displayed", "green");
			else
				throw new Exception();
		} catch (TimeoutException e) {
			WebActionUtil.fail("Spinner is still visible");
			WebActionUtil.error("Spinner is still visible");
			Assert.fail("Spinner is still visible");
		} catch (Exception e) {
			WebActionUtil.fail("Education details page is not displayed");
			WebActionUtil.error("Education details page is not displayed");
			Assert.fail("Education details page is not displayed");
		}
	}

	/**
	 * Description:This Method implements to click on Continue button for third
	 * party
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkContinueThirdParty() {
		try {
			WebActionUtil.waitForElement(btnContinue, "Continue button");
			WebActionUtil.clickOnElement(btnContinue, "Continue button", "Unable to click on Continue button");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Continue button");
			WebActionUtil.error("Unable to click on Continue button");
			Assert.fail("Unable to click on Continue button");
		}
	}

	/* passport yes text */
	@FindBy(xpath = "//input[@name='Passport' and @value='Yes']/following-sibling::label")
	private WebElement txtPassportYes;

	/* passport No text */
	@FindBy(xpath = "//input[@name='Passport' and @value='No']/following-sibling::label")
	private WebElement txtPassportNo;

	/* visa yes text */
	@FindBy(xpath = "//input[@name='Visa' and @value='Yes']/following-sibling::label")
	private WebElement txtVisaYes;

	/* visa No text */
	@FindBy(xpath = "//input[@name='Visa' and @value='No']/following-sibling::label")
	private WebElement txtVisaNo;

	/* visa yes radio button */
	@FindBy(xpath = "//input[@name='Visa' and @value='Yes']")
	private WebElement rbVisaYes;

	/* visa no radio button */
	@FindBy(xpath = "//input[@name='Visa' and @value='No']")
	private WebElement rbVisaNo;

	/* visa from date */
	@FindBy(xpath = "//label[text()='Visa From']")
	private WebElement txtVisaFrom;

	/* visa to date */
	@FindBy(xpath = "//label[text()='Visa To']")
	private WebElement txtVisaTo;

	/**
	 * Description:This Method implements to click on 'Yes' radio button of do you
	 * have passport for third party
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkYesPassportRbThirdparty() {
		try {
			if (txtPassportNo.isDisplayed() && txtPassportYes.isDisplayed()) {
				WebActionUtil.validationinfo("Do you have passport with 'Yes' and 'No' radio button is displayed",
						"blue");
				WebActionUtil.info("Do you have passport with 'Yes' and 'No' radio button is displayed");
			} else {
				WebActionUtil.fail("Do you have passport with 'Yes' and 'No' radio button is not displayed");
				WebActionUtil.error("Do you have passport with 'Yes' and 'No' radio button is not displayed");
			}
			if (rbPassportNoSelected.isSelected()) {
				WebActionUtil.validationinfo("'No' radio button of do you have passport is selected by default",
						"blue");
				WebActionUtil.info("'No' radio button of do you have passport is selected by default");
			} else {
				WebActionUtil.fail("'No' radio button of do you have passport is not selected by default");
				WebActionUtil.error("'No' radio button of do you have passport is not selected by default");
			}
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.clickCheckBoxUsingJS(rbPassportYes, "Yes radio button");
			validateDoYouHaveVisa();
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on 'Yes' radio button of do you have passport");
			WebActionUtil.error("Unable to click on 'Yes' radio button of do you have passport");
			Assert.fail("Unable to click on Yes radio button of do you have passport");
		}
	}

	/**
	 * Description:This Method implements to validate visa fields
	 * 
	 * @author Abhilash
	 * 
	 */
	private synchronized void validateDoYouHaveVisa() {
		try {
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(txtVisaYes.isDisplayed());
			arraylist.add(txtVisaNo.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Do you have Visa with Yes and No button is displayed", "blue");
				WebActionUtil.info("Do you have Visa with Yes and No button is displayed");
			} else
				throw new Exception();

		} catch (Exception e) {
			WebActionUtil.fail("Do you have Visa with Yes and No button is not displayed");
			WebActionUtil.error("Do you have Visa with Yes and No button is not displayed");
			Assert.fail("Do you have Visa with Yes and No button is not displayed");
		}
		try {
			if (rbVisaNo.isSelected()) {
				WebActionUtil.validationinfo("Do you have Visa 'No' radio button is selected by default", "blue");
				WebActionUtil.info("Do you have Visa 'No' radio button is selected by default");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Do you have Visa No button is not selected by default");
			WebActionUtil.error("Do you have Visa No button is not selected by default");
			Assert.fail("Do you have Visa No button is not selected by default");

		}
	}

	/**
	 * Description:This Method implements to click on Yes radio button of do you
	 * have visa
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkYesVisaRb() {
		try {
			WebActionUtil.clickCheckBoxUsingJS(rbVisaYes, "Yes radio button ");
			WebActionUtil.waitForAngularPageload();
			validateDoYouHaveVisaFields();
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Yes radio button of do you have Visa");
			WebActionUtil.error("Unable to click on Yes radio button of do you have Visa");
			Assert.fail("Unable to click on Yes radio button of do you have Visa");
		}
	}

	/**
	 * Description:This Method implements to validate fields in visa
	 * 
	 * @author Abhilash
	 */

	private synchronized void validateDoYouHaveVisaFields() {
		try {
			WebActionUtil.waitForAngularPageload();
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(btnVisaCountry.isDisplayed());
			arraylist.add(btnVisaType.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Visa country and Type of visa is displayed", "blue");
				WebActionUtil.info("Visa country and Type of visa is displayed");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Visa country and Type of visa is not displayed");
			WebActionUtil.error("Visa country and Type of visa is not displayed");
			Assert.fail("Visa country and Type of visa is not displayed");
		}
		try {
			WebActionUtil.waitForAngularPageload();
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(txtVisaFrom.isDisplayed());
			arraylist.add(txtVisaTo.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Visa From and Visa To calendar is displayed", "blue");
				WebActionUtil.info("Visa From and Visa To calendar is displayed");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Visa From and Visa To calendar is not displayed");
			WebActionUtil.error("Visa From and Visa To calendar is not displayed");
			Assert.fail("Visa From and Visa To calendar is not displayed");
		}
		try {
			WebActionUtil.waitForAngularPageload();
			ArrayList<Boolean> arraylist = new ArrayList<Boolean>();
			arraylist.add(btnAddVisaDetails.isDisplayed());
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Add visa details button is displayed", "blue");
				WebActionUtil.info("Add visa details button is displayed");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Add visa details button is not displayed");
			WebActionUtil.error("Add visa details button is not displayed");
			Assert.fail("Add visa details button is not displayed");
		}
	}

	/* Advance taken Off shore text box */
	@FindBy(xpath = "//label[text()='Advance taken Offshore']/following-sibling::input[@type='text']")
	private WebElement tbAdvanceTakenOffshore;

	/* Advance taken On site text box */
	@FindBy(xpath = "//label[text()='Advance taken Onsite']/following-sibling::input[@type='text']")
	private WebElement tbAdvanceTakenOnsite;

	/* I-94 Number text box */
	@FindBy(xpath = "//label[text()='I-94 Number']/following-sibling::input")
	private WebElement tbI94Number;

	/* Retype I-94 Number text box */
	@FindBy(xpath = "//label[text()='Re-type I-94 Number']/following-sibling::input[@type='text']")
	private WebElement tbRetypeI94Number;

	/* I-94 Admit Until Date */
	@FindBy(id = "L107")
	private WebElement dteI94AdmitUntilDate;

	/* Upload I-94 document link */
	@FindBy(xpath = "//a[text()='Upload I-94 document.']")
	private WebElement lnkI94UploadDocument;

	/* Choose file link */
	@FindBy(xpath = "//a[text()='Choose file']")
	private WebElement lnkChooseFile;

	/* Upload button */
	@FindBy(id = "upload")
	private WebElement btnUpload;

	/* Upload Document text */
	@FindBy(xpath = "//a[text()='Upload I-94 document.']/ancestor::div[1]/following-sibling::a")
	private WebElement txtUploadDocument;

	/* Additional Details text */
	@FindBy(id = "lblTitleAlert")
	private WebElement txtAdditionalDetails;

	/* OK button */
	@FindBy(id = "btnOk")
	private WebElement btnOk;

	/* File Uploaded Successfully text */
//	@FindBy(id = "lblAlertMsg")
	@FindBy(xpath = "//p[text()='File Uploaded Successfully!']")
	private WebElement txtFileUploadedSuccessfully;

	/* Do you have a Bank Account Radio Button */
	@FindBy(xpath = "//input[@name='BankAccount' and @id='L110']")
	private WebElement rbDoyouhaveaBankAccount;

	/* Account Number text box */
	@FindBy(xpath = "(//label[text()='Account Number']/following-sibling::input)[2]")
	private WebElement tbAccountNo;

	/* Re-type AccountNo text box */
	@FindBy(xpath = "(//label[text()='Re-type Account Number']/following-sibling::input)[3]")
	private WebElement tbRetypeAccountNo;

	/* Account type drop down */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default' and @data-id='L113']")
	private WebElement ddAccounttype;

	/* Routing Number text box */
	@FindBy(xpath = "(//label[text()='Routing Number']/following-sibling::input)[2]")
	private WebElement tbRoutingNumber;

	/* Re-type Routing Number text box */
	@FindBy(xpath = "(//label[text()='Re-type Routing Number']/following-sibling::input)[3]")
	private WebElement tbRetypeRoutingNumber;

	/* Acknowledge Bank Details check box */
	@FindBy(xpath = "//input[@id='L117' and @type='checkbox']")
	private WebElement cbAcknowledgeBankDetails;

	/* Select Account type */
	private WebElement selectAccounttype(String accounttype) {
		String xpath = "//span[text()='" + accounttype + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * Description:This Method implements to set Advance Taken Off shore text box
	 * 
	 * @author Abhilash
	 * @param advanceTakenOffshore
	 */
	public synchronized void setAdvanceTakenOffshoreTb(String advanceTakenOffshore) {
		try {
			WebActionUtil.waitForElement(tbAdvanceTakenOffshore, "Advance Taken Offshore text box");
			WebActionUtil.clearText(tbAdvanceTakenOffshore, "Advance Taken Offshore text box");
			WebActionUtil.typeText(tbAdvanceTakenOffshore, advanceTakenOffshore, "Advance Taken Offshore text box");
			String actual = tbAdvanceTakenOffshore.getAttribute("value");
			try {
				Assert.assertEquals(advanceTakenOffshore, actual);
				WebActionUtil.validationinfo(advanceTakenOffshore + " value entered in Advance Taken Offshore text box",
						"blue");
				WebActionUtil.info(advanceTakenOffshore + " value entered in Advance Taken Offshore text box");
			} catch (Exception e) {
				WebActionUtil.fail(advanceTakenOffshore + " value not entered in Advance Taken Offshore text box");
				WebActionUtil.error(advanceTakenOffshore + " value not entered in Advance Taken Offshore text box");
			}
		} catch (Exception e) {
			WebActionUtil.fail("Unable to type " + advanceTakenOffshore + " in Advance Taken Offshore text box");
			WebActionUtil.error("Unable to type " + advanceTakenOffshore + " in Advance Taken Offshore text box");
			Assert.fail("Unable to type " + advanceTakenOffshore + " in Advance Taken Offshore text box");
		}
	}

	/**
	 * Description:This Method implements to set Advance Taken On site text box
	 * 
	 * @author Abhilash
	 * @param advanceTakenOnsite
	 */
	public synchronized void setAdvanceTakenOnsiteTb(String advanceTakenOnsite) {
		try {
			WebActionUtil.waitForElement(tbAdvanceTakenOnsite, "Advance Taken Onsite text box");
			WebActionUtil.clearText(tbAdvanceTakenOnsite, "Advance Taken Onsite text box");
			WebActionUtil.typeText(tbAdvanceTakenOnsite, advanceTakenOnsite, "Advance Taken Onsite text box");
			String actual = tbAdvanceTakenOnsite.getAttribute("value");
			try {
				Assert.assertEquals(advanceTakenOnsite, actual);
				WebActionUtil.validationinfo(advanceTakenOnsite + " value entered in Advance Taken Onsite text box",
						"blue");
				WebActionUtil.info(advanceTakenOnsite + " value entered in Advance Taken Onsite text box");
			} catch (Exception e) {
				WebActionUtil.fail(advanceTakenOnsite + " value not entered in Advance Taken Onsite text box");
				WebActionUtil.error(advanceTakenOnsite + " value not entered in Advance Taken Onsite text box");
			}
		} catch (Exception e) {
			WebActionUtil.fail("Unable to type " + advanceTakenOnsite + " in Advance Taken Onsite text box");
			WebActionUtil.error("Unable to type " + advanceTakenOnsite + " in Advance Taken Onsite text box");
			Assert.fail("Unable to type " + advanceTakenOnsite + " in Advance Taken Onsite text box");
		}
	}

	/**
	 * Description:This Method implements to set I94 fields
	 * 
	 * @author Abhilash
	 * @param i94Number
	 * @param retypeI94Number
	 * @param imagePath
	 * @param i94AdmitUntilDate
	 */
	public synchronized void setI94(String i94Number, String retypeI94Number, String imagePath,
			String i94AdmitUntilDate) {
		try {

			WebActionUtil.waitForElement(tbI94Number, "I-94 Number text box");
			WebActionUtil.clearText(tbI94Number, "I-94 Number text box");
			WebActionUtil.typeText(tbI94Number, i94Number, "I-94 Number text box");

			WebActionUtil.waitForElement(tbRetypeI94Number, "Retype I-94 Number text box");
			WebActionUtil.clearText(tbRetypeI94Number, "Retype I-94 Number text box");
			WebActionUtil.typeText(tbRetypeI94Number, retypeI94Number, "Retype I-94 Number text box");

			WebActionUtil.scrollToElement(lnkI94UploadDocument, "Upload I-94 document link");
			WebActionUtil.waitForElement(lnkI94UploadDocument, "Upload I-94 document link");
			WebActionUtil.clickOnElement(lnkI94UploadDocument, "Upload I-94 document link",
					"Unable to click on Upload I-94 document link");

			WebActionUtil.waitForElement(lnkChooseFile, "Choose file link");
			WebActionUtil.clickOnElement(lnkChooseFile, "Choose file link", "Unable to click on Choose file link");

			WebActionUtil.upload(imagePath);

			WebActionUtil.waitForElement(btnUpload, "Upload Button");
			WebActionUtil.clickOnElement(btnUpload, "Upload Button", "Unable to click on Upload Button");

			WebActionUtil.waitForAngularPageToLoad();
			if (txtUploadDocument.isDisplayed()) {
				WebActionUtil.waitForElement(txtUploadDocument, "Upload Document text");
				WebActionUtil.validateisElementDisplayed(txtUploadDocument, "Upload Document text",
						"Uploaded Document is displayed", "Uploaded Document is not displayed", "blue");
			} else {
				WebActionUtil.fail("Unable to validate Uploaded Document");
				WebActionUtil.error("Unable to validate Uploaded Document");
				Assert.fail("Unable to validate Uploaded Document");
			}
			WebActionUtil.waitForElement(dteI94AdmitUntilDate, "I-94 Admit Until Date");
			WebActionUtil.selectCalendarDate("L107", i94AdmitUntilDate, "I-94 Admit Until Date");
			validateI94Fields(i94Number, retypeI94Number, i94AdmitUntilDate);

		} catch (Exception e) {
			WebActionUtil.fail("Unable to add I94 fields");
			WebActionUtil.error("Unable to add I94 fields");
			Assert.fail("Unable to add I94 fields");
		}
	}

	/**
	 * Description:This Method implements to validate I94 fields
	 * 
	 * @author Abhilash
	 * @param i94Number
	 * @param retypeI94Number
	 * @param i94AdmitUntilDate
	 */
	private synchronized void validateI94Fields(String i94Number, String retypeI94Number, String i94AdmitUntilDate) {

		try {
			ArrayList<Boolean> arraylist = new ArrayList<>();
			i94Number = i94Number.toLowerCase();
			retypeI94Number = retypeI94Number.toLowerCase();
			arraylist.add(WebActionUtil.getTextUsingJS("L104").equals(i94Number));
			arraylist.add(WebActionUtil.getTextUsingJS("L105").equals(retypeI94Number));
			arraylist.add(WebActionUtil.getTextUsingJS("L107").equals(i94AdmitUntilDate));
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo("Valid data is displayed in I94Number, RetypeI94Number, I94AdmitUntilDate",
						"green");
				WebActionUtil.info("Valid data is displayed in I94Number, RetypeI94Number, I94AdmitUntilDate");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail("Valid data is not displayed in I94Number, RetypeI94Number, I94AdmitUntilDate");
			WebActionUtil.error("Valid data is not displayed in I94Number, RetypeI94Number, I94AdmitUntilDate");
			Assert.fail("Valid data is not displayed in I94Number, RetypeI94Number, I94AdmitUntilDate");
		}
	}

	/**
	 * Description:This Method implements to click on Do you have a Bank Account
	 * Radio Button
	 * 
	 * @author Abhilash
	 */
	public synchronized void clkDoyouhaveaBankAccount() {
		try {
			WebActionUtil.clickCheckBoxUsingJS(rbDoyouhaveaBankAccount, "Bank Account Radio Button");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Do you have a Bank Account Radio Button");
			WebActionUtil.error("Unable to click on Do you have a Bank Account Radio Button");
			Assert.fail("Unable to click on Do you have a Bank Account Radio Button");
		}

	}

	/**
	 * Description:This Method implements to set Bank account details
	 * 
	 * @author Abhilash
	 * @param accountNumber
	 * @param retypeAccountNumber
	 * @param accountType
	 * @param routingNumber
	 * @param retypeRoutingNumber
	 */
	public synchronized void setBankAccountDetails(String accountNumber, String retypeAccountNumber, String accountType,
			String routingNumber, String retypeRoutingNumber) {
		try {
			WebActionUtil.waitForElement(tbAccountNo, "Account Number Text field");
			WebActionUtil.clickOnElement(tbAccountNo, "Account Number Text field",
					"Unable to click Account Number Text field");
			WebActionUtil.typeText(tbAccountNo, accountNumber, "Account Number Text field");
			WebActionUtil.waitForElement(tbRetypeAccountNo, "Re-type Account Number Text field");
			WebActionUtil.clickOnElement(tbRetypeAccountNo, "Re-type Account Number Text field",
					"Unable to click Re-type Account Number Text field");
			WebActionUtil.typeText(tbRetypeAccountNo, accountNumber, "Re-type Account Number Text field");
			WebActionUtil.waitForElement(ddAccounttype, "Account type drop down");
			WebActionUtil.clickOnElement(ddAccounttype, "Account type drop down",
					"Unable to click on Account type drop down");
			WebActionUtil.clickOnElement(selectAccounttype(accountType), "Account type option",
					"Unable to click on Account type option");
			WebActionUtil.waitForElement(tbRoutingNumber, "Routing number");
			WebActionUtil.clickOnElement(tbRoutingNumber, "Routing number",
					"Unable to click on Routing number text field");
			WebActionUtil.typeText(tbRoutingNumber, routingNumber, "Routing number text field");
			WebActionUtil.waitForElement(tbRetypeRoutingNumber, "Re-type Routing number");
			WebActionUtil.clickOnElement(tbRetypeRoutingNumber, "Re-type Routing number",
					"Unable to click on Re-type Routing number text field");
			WebActionUtil.typeText(tbRetypeRoutingNumber, routingNumber, "Re-type Routing number");

			validateBankAccountdetails(accountNumber, retypeAccountNumber, accountType, routingNumber,
					retypeRoutingNumber);
//			WebActionUtil.waitForElement(cbAcknowledgeBankDetails, "Acknowledge Bank Details check box");
			WebActionUtil.clickCheckBoxUsingJS(cbAcknowledgeBankDetails, "Acknowledge Bank Details check box");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to set Bank Account details");
			WebActionUtil.error("Unable to set Bank Account details");
			Assert.fail("Unable to set Bank Account details");
		}

	}

	/**
	 * Description:This Method implements to Validate Bank Account details
	 * 
	 * @author Abhilash
	 * @param accountNumber
	 * @param retypeAccountNumber
	 * @param accountType
	 * @param routingNumber
	 * @param retypeRoutingNumber
	 */
	private synchronized void validateBankAccountdetails(String accountNumber, String retypeAccountNumber,
			String accountType, String routingNumber, String retypeRoutingNumber) {
		try {

			ArrayList<Boolean> arraylist = new ArrayList<>();
			arraylist.add(WebActionUtil.getTextUsingJS("L111").equals(accountNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L112").equals(retypeAccountNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L113").equals(accountType));
			arraylist.add(WebActionUtil.getTextUsingJS("L114").equals(routingNumber));
			arraylist.add(WebActionUtil.getTextUsingJS("L115").equals(retypeRoutingNumber));
			if (!arraylist.contains(false)) {
				WebActionUtil.validationinfo(
						"Valid data is displayed in Account number, Re-type Account number, Account type, Routing number, Re-type Routing number",
						"green");
				WebActionUtil.info(
						"Valid data is displayed in Account number, Re-type Account number, Account type, Routing number, Re-type Routing number");
			} else
				throw new Exception();
		} catch (Exception e) {
			WebActionUtil.fail(
					"Valid data is not displayed in Account number, Re-type Account number, Account type, Routing number, Re-type Routing number");
			WebActionUtil.error(
					"Valid data is not displayed in Account number, Re-type Account number, Account type, Routing number, Re-type Routing number");
			Assert.fail(
					"Valid data is not displayed in Account number, Re-type Account number, Account type, Routing number, Re-type Routing number");
		}
	}

}
