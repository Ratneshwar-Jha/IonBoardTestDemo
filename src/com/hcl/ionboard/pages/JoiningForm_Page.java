package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for Joining Form page
 * 
 * @author Manish Kumar C D
 */
public class JoiningForm_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public JoiningForm_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Spinner */
	@FindBy(xpath = "//div[@class='go_spiner nolms']/div[@class='loader2 material-spinner']")
	private WebElement spinner;

	/* Title Dropdown */
	@FindBy(xpath = "//label[text()='Title']/parent::div/div/button[@type='button']")
	private WebElement ddTitle;

	/* Title TextBox */
	@FindBy(xpath = "//label[text()='Title']/parent::div/div/div/div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbTitle;

	/* Title Options */
	@FindBys(@FindBy(xpath = "//label[text()='Title']/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnTitle;

	/* First Name Textfield */
	@FindBy(xpath = "//span[text()='First Name']/../../input[@type='text']")
	private WebElement txtFirstName;

	/* Middle Name Textbox */
	@FindBy(xpath = "//label[text()='Middle Name']/parent::div//input[@type='text']")
	private WebElement tbMiddleName;

	/* Last Name Textfield */
	@FindBy(xpath = "//span[text()='Last Name']/parent::label/parent::div/input[@type='text']")
	private WebElement txtLastName;

	/* DOJ at Present Location Date Text */
	@FindBy(xpath = "//label[text()='DOJ at Present Location']/../input[@class='form-control text-box single-line valid']")
	private WebElement txtDOJAtPresentLocation;

	/* Client Name Text */
	@FindBy(xpath = "//label[text()='Client Name']/../input[@type='text']")
	private WebElement txtClientName;

	/* Client Address Text */
	@FindBy(xpath = "//label[text()='Client Address']/../textarea[@class='form-control valid']")
	private WebElement txtClientAddress;

	/* Different Maiden Name CheckBox */
	@FindBy(xpath = "//input[@id='maidenName']/../label[text()=' Different Maiden Name']")
	private WebElement cbDifferentMaidenName;

	/* Different Maiden Name TextBox */
	@FindBy(xpath = "//label[text()=' Different Maiden Name']/ancestor::div[2]/following-sibling::div/child::input")
	private WebElement tbDifferentMaidenName;

	/* Preferred Name Textbox */
	@FindBy(xpath = "//label[text()='Preferred Name']/parent::div/input[@type='text']")
	private WebElement tbPreferredName;

	/* Gender Dropdown */
	@FindBy(xpath = "//label[text()='Gender']/parent::div//button[@type='button']")
	private WebElement ddGender;

	/* Gender TextBox */
	@FindBy(xpath = "//label[text()='Gender']/parent::div//div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbGender;

	/* Gender Options */
	@FindBys(@FindBy(xpath = "//label[text()='Gender']/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnGender;

	/* Place Of Birth TextBox */
	@FindBy(xpath = "//label[text()='Place Of Birth']/parent::div/input[@type='text']")
	private WebElement tbPlaceofBirth;

	/* Email Textfield */
	@FindBy(xpath = "//label[text()='E-mail']/parent::div/input[@type='text']")
	private WebElement txtEmail;

	/* Marital Status Dropdown */
	@FindBy(xpath = "//label[text()='Marital Status']/parent::div/div/button[@type='button']")
	private WebElement ddMaritalStatus;

	/* Marital Status TextBox */
	@FindBy(xpath = "//label[text()='Marital Status']/parent::div//input[@type='text']")
	private WebElement tbMaritalStatus;

	/* Marital Status Options */
	@FindBys(@FindBy(xpath = "//label[text()='Marital Status']/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnMaritalStatus;

	/* Nationality dropdown */
	@FindBy(xpath = "//label[text()='Nationality']/parent::div//button[@type='button']")
	private WebElement ddNationality;

	/* Nationality TextBox */
	@FindBy(xpath = "//label[text()='Nationality']/parent::div//input[@type='text']")
	private WebElement tbNationality;

	/* Nationality Options */
	@FindBys(@FindBy(xpath = "//label[text()='Nationality']/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnNationality;

	/* Citizenship dropdown */
	@FindBy(xpath = "//label[text()='Citizenship']/parent::div/div/button[@type='button']")
	private WebElement ddCitizenship;

	/* Citizenship TextBox */
	@FindBy(xpath = "//label[text()='Citizenship']/parent::div//div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbCitizenship;

	/* Citizenship Options */
	@FindBys(@FindBy(xpath = "//label[text()='Citizenship']/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnCitizenship;

	/* Dual Citizenship Checkbox */
	@FindBy(xpath = "//div[@class='checkbox rsTransition']/label[text()=' Dual Citizenship']/preceding-sibling::input")
	private WebElement cbDualCitizenship;

	/* Dual Citizenship dropdown */
	@FindBy(xpath = "//label[text()=' Dual Citizenship']/parent::div/parent::div/following-sibling::div//button[@type='button']")
	private WebElement ddDualCitizenship;

	/* Dual Citizenship TextBox */
	@FindBy(xpath = "//label[text()=' Dual Citizenship']/../../following-sibling::div/parent::div//div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbDualCitizenship;

	/* Dual Citizenship Options */
	@FindBys(@FindBy(xpath = "//label[text()=' Dual Citizenship']/../../following-sibling::div/parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnDualCitizenship;

	/* Contact Number TextField */
	@FindBy(xpath = "//span[text()='Contact Number']/parent::label/parent::div/input[@type='text']")
	private WebElement txtContactNumber;

	/* Ethnic Origin Link */
	@FindBy(xpath = "//span[text()='Ethnic Origin']/parent::label/i[@class='glyphicon glyphicon-new-window']")
	private WebElement lnkEthnicOrigin;

	/* Ethnic Origin Dropdown */
	@FindBy(xpath = "//span[text()='Ethnic Origin']/parent::label/parent::div/div/button[@type='button']")
	private WebElement ddEthnicOrigin;

	/* Ethnic Origin TextBox */
	@FindBy(xpath = "//span[text()='Ethnic Origin']/parent::label/parent::div/parent::div//div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbEthnicOrigin;

	/* Ethnic Origin Options */
	@FindBys(@FindBy(xpath = "//span[text()='Ethnic Origin']/../../parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnEthnicOrigin;

	/* Race Link */
	@FindBy(xpath = "//span[text()='Race']/parent::label/i[@class='glyphicon glyphicon-new-window']")
	private WebElement lnkRace;

	/* Race Dropdown */
	@FindBy(xpath = "//span[text()='Race']/parent::label/parent::div/div/button[@type='button']")
	private WebElement ddRace;

	/* Race TextBox */
	@FindBy(xpath = "//span[text()='Race']/../../parent::div//div[@class='bs-searchbox']/input[@type='text']")
	private WebElement tbRace;

	/* Race Options */
	@FindBys(@FindBy(xpath = "//span[text()='Race']/../../parent::div//ul[@role='listbox']/li/a/span[@class='text']"))
	private List<WebElement> otnRace;

	/* Upload Your Color Photograph Image */
	@FindBy(xpath = "//span[contains(text(),'Click to upload your color photograph')]/parent::div/i[@class='glyphicon glyphicon-picture']")
	private WebElement imgUploadYourColorPhotograph;

	/* Browse Button */
	@FindBy(xpath = "//span[@class='btn btn-primary']")
	private WebElement btnBrowse;

	/* Upload Button */
	@FindBy(xpath = "//button[@id='upload' and @type='button']")
	private WebElement btnUpload;

	/* Cancel Button */
	@FindBy(xpath = "//button[text()='Cancel' and @type='button']")
	private WebElement btnCancel;

	/* Sample FileName Text */
	@FindBy(xpath = "//input[@id='filetext']")
	private WebElement txtSampleFileName;

	/* Photo Uploaded Successfully Text */
	@FindBy(xpath = "//p[@id='lblAlertMsg']")
	private WebElement txtPhotoUploadedSuccessfully;

	/* Personal Details PopUp */
	@FindBy(xpath = "//h4[@id='lblTitleAlert']")
	private WebElement popUpPersonalDetails;

	/* Ok Button */
	@FindBy(xpath = "//button[@id='btnOk']")
	private WebElement btnOk;

	/* Close Button */
	@FindBy(xpath = "//h4[@id='lblTitleAlert']/../button/span[text()='×']")
	private WebElement btnClose;

	/* Change Photo Link */
	@FindBy(xpath = "//u[text()='Change Photo']")
	private WebElement lnkChangePhoto;

	/* My Current Address Is My Permanent Address CheckBox */
	@FindBy(xpath = "//input[@type='checkbox']/../label[contains(text(),' My current Address is my Permanent Address')]")
	private WebElement cbMyCurrentAddressIsMyPermanentAddress;

	/* Co TextBox */
	@FindBy(xpath = "(//label[text()='C/O']/parent::div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressCo;

	/* Address Line1 TextBox */
	@FindBy(xpath = "(//label[text()='Address Line 1']/parent::div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressAddressLine1;

	/* Address Line2 TextBox */
	@FindBy(xpath = "(//label[text()='Address Line 2']/parent::div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressAddressLine2;

	/* Country Dropdown */
	@FindBy(xpath = "(//label[text()='Country']/parent::div//following-sibling::div/button[@role='button'])[1]")
	private WebElement ddPermanentAddressCountry;

	/* Country TextBox */
	@FindBy(xpath = "(//label[text()='Country']/..//following-sibling::div/div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressCountry;

	/* Country Options */
	@FindBys(@FindBy(xpath = "(//label[text()='Country']/..//following-sibling::div)[2]/ul/li/a/span[@class='text']"))
	private List<WebElement> otnPermanentAddressCountry;

	/* State Dropdown */
	@FindBy(xpath = "(//label[text()='State']/parent::div//following-sibling::div/button[@type='button'])[1]")
	private WebElement ddPermanentAddressState;

	/* State TextBox */
	@FindBy(xpath = "(//label[text()='State']/..//following-sibling::div/div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressState;

	/* State Options */
	@FindBys(@FindBy(xpath = "(//label[text()='State']/..//following-sibling::div)[2]/ul/li/a/span[@class='text']"))
	private List<WebElement> otnPermanentAddressState;

	/* City Textbox */
	@FindBy(xpath = "(//label[text()='City']/parent::div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressCity;

	/* Postal Code Textbox */
	@FindBy(xpath = "(//label[text()='Postal Code']/parent::div/input[@type='text'])[1]")
	private WebElement tbPermanentAddressPostalCode;

	/* Co TextBox */
	@FindBy(xpath = "(//label[text()='C/O']/parent::div/input[@type='text'])[2]")
	private WebElement tbCurrentAddressCo;

	/* Address Line1 TextBox */
	@FindBy(xpath = "(//label[text()='Address Line 1']/parent::div/input[@type='text'])[2]")
	private WebElement tbCurrentAddressAddressLine1;

	/* Address Line2 TextBox */
	@FindBy(xpath = "(//label[text()='Address Line 2']/parent::div/input[@type='text'])[2]")
	private WebElement tbCurrentAddressAddressLine2;

	/* Country Dropdown */
	@FindBy(xpath = "(//label[text()='Country']/..//following-sibling::div)[3]/button[@type='button']")
	private WebElement ddCurrentAddressCountry;

	/* Country TextBox */
	@FindBy(xpath = "(//label[text()='Country']/..//following-sibling::div)[4]/div/input[@type='text']")
	private WebElement tbCurrentAddressCountry;

	/* Country Options */
	@FindBys(@FindBy(xpath = "(//label[text()='Country']/..//following-sibling::div[@class='dropdown-menu open'])[2]/ul/li/a/span[@class='text']"))
	private List<WebElement> otnCurrentAddressCountry;

	/* State Dropdown */
	@FindBy(xpath = "(//label[text()='State']/..//following-sibling::div/button[@type='button'])[2]")
	private WebElement ddCurrentAddressState;

	/* State TextBox */
	@FindBy(xpath = "(//label[text()='State']/..//following-sibling::div[@class='dropdown-menu open']/div[@class='bs-searchbox']/input[@type='text'])[2]")
	private WebElement tbCurrentAddressState;

	/* State Options */
	@FindBys(@FindBy(xpath = "(//label[text()='State']/..//following-sibling::div)[4]/ul/li/a/span[@class='text']"))
	private List<WebElement> otnCurrentAddressState;

	/* City Textbox */
	@FindBy(xpath = "(//label[text()='City']/parent::div/input[@type='text'])[2]")
	private WebElement tbCurrentAddressCity;

	/* Postal Code Textbox */
	@FindBy(xpath = "(//label[text()='Postal Code']/parent::div/input[@type='text'])[2]")
	private WebElement tbCurrentAddressPostalCode;

	/* Continue Button */
	@FindBy(xpath = "//input[@id='ContinueButton']")
	private WebElement btnContinue;

	/* Save As Draft Button */
	@FindBy(xpath = "//input[@id='SaveButton']")
	private WebElement btnSaveAsDraft;

	/* Titles Texts */
	@FindBys(@FindBy(xpath = "//h4[@class='panel-title']"))
	private List<WebElement> txtTitles;

	/* Personal Detail Titles Texts */
	@FindBys(@FindBy(xpath = "(//div[@class='panel-body'])[1]//label"))
	private List<WebElement> txtPersonalDetailsTitles;

	/* Address Detail Titles Texts */
	@FindBys(@FindBy(xpath = "(//div[@class='panel-body'])[2]//label"))
	private List<WebElement> txtAddressDetailsTitles;

	/* Date Of Birth */
	@FindBy(xpath = "//label[text()='Date Of Birth']/../input[@id='L007']")
	private WebElement dteDateOfBirth;

	/* Marriage Date */
	@FindBy(xpath = "//label[text()='Marriage Date']/../input[@id='L103']")
	private WebElement dteMarriageDate;

	/* Ethnic Origin PopUp */
	@FindBy(xpath = "//div[@class='ethnic_pop']")
	private WebElement popUpEthnicOrigin;

	/* Race PopUp */
	@FindBy(xpath = "//div[@class='race_pop']")
	private WebElement popUpRace;

	/* Titles for Additional Info */
	@FindBys(@FindBy(xpath = "//div[@class='panel-heading ripple-effect']/h4"))
	private List<WebElement> txtAdditionalInfoTitles;

	/* Personal Tab Before Completion */
	@FindBy(xpath = "i[@class='icon-i-personal']")
	private WebElement tabPersonalBefore;

	/* Personal Tab After Completion */
	@FindBy(xpath = "i[@class='icon-tick']")
	private WebElement tabPersonalAfter;

	/* First Name Text */
	@FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::div/following-sibling::input")
	private WebElement txtFirstName1;

	/* Last Name Text */
	@FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::div/following-sibling::input")
	private WebElement txtLastName1;

	/* Gender Text */
	@FindBy(xpath = "//label[text()='Gender']/following-sibling::div/descendant::button")
	private WebElement txtGender;

	/**
	 * Description Method Selects the title from the title Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param title
	 */

	public synchronized void selectTitleDd(String title) {
		try {
			WebActionUtil.waitForElement(ddTitle, "Title drop down");
			WebActionUtil.clickOnElement(ddTitle, "Title drop down", "Unable to click on Title drop down");
			WebActionUtil.waitForElement(tbTitle, "Title TextBox");
			WebActionUtil.typeText(tbTitle, title, "Title TextBox");
			for (WebElement titleOptions : otnTitle) {
				String titleOption = titleOptions.getText();
				if (titleOption.equals(title)) {
					WebActionUtil.actionClick(titleOptions, "Clicked on " + title + "");
					WebActionUtil.validationinfo("Selected " + title + " from Title drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Title drop down");
			WebActionUtil.fail("Unable to click on Title drop down");
			Assert.fail("Unable to click on Title drop down");
		}
	}

	/**
	 * Description Method Writes the value into Middle Name TextBox
	 * 
	 * @author Manish Kumar C D
	 * @param middleName
	 */

	public synchronized void setMiddleNameTb(String middleName) {
		try {
			WebActionUtil.waitForElement(tbMiddleName, "Middle Name text box");
			WebActionUtil.clearText(tbMiddleName, "Middle Name text box");
			WebActionUtil.typeText(tbMiddleName, middleName, "Middle Name text box");
			WebActionUtil.validateisElementDisplayed(tbMiddleName, "Middle Name text box",
					"Entered " + middleName + " in Middle Name text box", "Unable to Enter in Middle Name text box",
					"blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Middle Name text box");
			WebActionUtil.fail("Unable to type the value in Middle Name text box");
			Assert.fail("Unable to type the value in Middle Name text box");
		}
	}

	/**
	 * Description Method Clicks on Different Maiden Name CheckBox
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkDifferentMaidenCb() {
		try {
			WebActionUtil.waitForElement(cbDifferentMaidenName, "Different Maiden Name CheckBox");
			WebActionUtil.clickCheckBox(cbDifferentMaidenName, "Different Maiden Name CheckBox");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Different Maiden Name CheckBox ");
			WebActionUtil.fail("Unable to click on Different Maiden Name CheckBox ");
			Assert.fail("Unable to click on Different Maiden Name CheckBox ");
		}
	}

	/**
	 * Description Method Writes the value into Different Maiden Name TextBox
	 * 
	 * @author Manish Kumar C D
	 * @param maidenName
	 */

	public synchronized void setDifferentMaidenNameTb(String maidenName) {
		try {
			WebActionUtil.waitForElement(tbDifferentMaidenName, "Different Maiden Name text box");
			WebActionUtil.clearText(tbDifferentMaidenName, "Different Maiden Name text box");
			WebActionUtil.typeText(tbDifferentMaidenName, maidenName, "Different Maiden Name text box");
			String actualName = WebActionUtil.getTextusingJSWithXpath(tbDifferentMaidenName, "blue");
			Assert.assertEquals(actualName, maidenName);
			WebActionUtil.info("Entered " + maidenName + " in Different Maiden Name text box");
			WebActionUtil.validationinfo("Entered " + maidenName + " in Different Maiden Name text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Different Maiden Name text box");
			WebActionUtil.fail("Unable to type the value in Different Maiden Name text box");
			Assert.fail("Unable to type the value in Different Maiden Name text box");
		}
	}

	/**
	 * Description Method Writes the value into Preferred Name TextBox
	 * 
	 * @author Manish Kumar C D
	 * @param preferredName
	 */

	public synchronized void setPreferredNameTb(String preferredName) {
		try {
			WebActionUtil.waitForElement(tbPreferredName, "Preferred Name text box");
			WebActionUtil.clearText(tbPreferredName, "Preferred Name text box");
			WebActionUtil.typeText(tbPreferredName, preferredName, "Preferred Name text box");
			WebActionUtil.validateisElementDisplayed(tbPreferredName, "Preferred Name text box",
					"Entered " + preferredName + " in  Preferred Name text box",
					"Unable to Enter in Preferred Name text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Preferred Name text box");
			WebActionUtil.fail("Unable to type the value in Preferred Name text box");
			Assert.fail("Unable to type the value in Preferred Name text box");
		}
	}

	/**
	 * Description Method Selects the gender from the Gender Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param gender
	 */

	public synchronized void selectGenderDd(String gender) {
		try {
			WebActionUtil.waitForElement(ddGender, "Gender drop down");
			WebActionUtil.clickOnElement(ddGender, "Gender drop down", "Unable to click on Gender drop down");
			WebActionUtil.waitForElement(tbGender, "Gender text box");
			WebActionUtil.typeText(tbGender, gender, "Gender text box");
			for (WebElement genderOptions : otnGender) {
				String genderOption = genderOptions.getText();
				if (gender.contentEquals(genderOption)) {
					WebActionUtil.actionClick(genderOptions, "Clicked on " + gender + "");
					WebActionUtil.validationinfo("Selected " + gender + " from Gender drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Gender drop down");
			WebActionUtil.fail("Unable to click on Gender drop down");
			Assert.fail("Unable to click on Gender drop down");
		}
	}

	/**
	 * Description Method Writes the value into Place Of Birth text box
	 * 
	 * @author Manish Kumar C D
	 * @param placeofbirth
	 */

	public synchronized void setPlaceOfBirthTb(String placeofbirth) {
		try {
			WebActionUtil.waitForElement(tbPlaceofBirth, "Place Of Birth text box");
			WebActionUtil.clearText(tbPlaceofBirth, "Place Of Birth text box");
			WebActionUtil.typeText(tbPlaceofBirth, placeofbirth, "Place Of Birth text box");
			WebActionUtil.validateisElementDisplayed(tbPlaceofBirth, "Place Of Birth text box",
					"Entered " + placeofbirth + " in  Place Of Birth text box",
					"Unable to Enter in Place Of Birth text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Place Of Birth text box");
			WebActionUtil.fail("Unable to type the value in Place Of Birth text box");
			Assert.fail("Unable to type the value in Place Of Birth text box");
		}
	}

	/**
	 * Description Method Selects the marital status from the Marital Status
	 * Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param maritalstatus
	 */

	public synchronized void selectMaritalStatusDd(String maritalstatus) {
		try {
			WebActionUtil.waitForElement(ddMaritalStatus, "Marital Status drop down");
			WebActionUtil.clickOnElement(ddMaritalStatus, "Marital Status drop down",
					"Unable to click on Marital Status drop down");
			WebActionUtil.waitForElement(tbMaritalStatus, "Marital Status text box");
			WebActionUtil.typeText(tbMaritalStatus, maritalstatus, "Marital Status text box");

			for (WebElement maritalstatusOptions : otnMaritalStatus) {
				String maritalstatusOption = maritalstatusOptions.getText();

				if (maritalstatus.contentEquals(maritalstatusOption)) {
					WebActionUtil.actionClick(maritalstatusOptions, "" + maritalstatus + "");
					WebActionUtil.validationinfo("Selected " + maritalstatus + " from Marital Status drop down", "blue");

				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Marital Status drop down");
			WebActionUtil.fail("Unable to click on Marital Status drop down");
			Assert.fail("Unable to click on Marital Status drop down");
		}
	}

	/**
	 * Description Method Selects the nationality option from the Nationality
	 * Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param nationality
	 */

	public synchronized void selectNationalityDd(String nationality) {
		try {
			WebActionUtil.scrollToElement(ddNationality, "Nationality drop down");
			WebActionUtil.waitForElement(ddNationality, "Nationality drop down");
			WebActionUtil.clickOnElement(ddNationality, "Nationality drop down",
					"Unable to click on Nationality drop down");
			WebActionUtil.waitForElement(tbNationality, "Nationality text box");
			WebActionUtil.typeText(tbNationality, nationality, "Nationality text box");

			for (WebElement nationalityOptions : otnNationality) {
				String nationalityOption = nationalityOptions.getText();

				if (nationality.equalsIgnoreCase(nationalityOption)) {
					WebActionUtil.actionClick(nationalityOptions, "" + nationality + "");
					WebActionUtil.validationinfo("Selected " + nationality + " from Nationality drop down", "blue");

				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Nationality drop down");
			WebActionUtil.fail("Unable to click on Nationality drop down");
			Assert.fail("Unable to click on Nationality drop down");
		}
	}

	/**
	 * Description Method Selects the citizenship option from the Citizenship
	 * Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param citizenship
	 */

	public synchronized void selectCitizenshipDd(String citizenship) {
		try {
			WebActionUtil.waitForElement(ddCitizenship, "Citizenship drop down");
			WebActionUtil.clickOnElement(ddCitizenship, "Citizenship drop down",
					"Unable to click on Citizenship drop down");
			WebActionUtil.waitForElement(tbCitizenship, "Citizenship text box");
			WebActionUtil.typeText(tbCitizenship, citizenship, "Citizenship text box");

			for (WebElement citizenshipOptions : otnCitizenship) {
				String citizenshipOption = citizenshipOptions.getText();

				if (citizenship.equalsIgnoreCase(citizenshipOption)) {
					WebActionUtil.actionClick(citizenshipOptions, "" + citizenship + "");
					WebActionUtil.validationinfo("Selected " + citizenship + " from Citizenship drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Citizenship drop down");
			WebActionUtil.fail("Unable to click on Citizenship drop down");
			Assert.fail("Unable to click on Citizenship drop down");
		}
	}

	/**
	 * Description Method Clicks on Different Dual Citizenship CheckBox
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkDualCitizenshipCb() {
		try {
			WebActionUtil.doubleClickOnElementCheckboxUsingJS(cbDualCitizenship, "Dual Citizenship CheckBox");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Dual Citizenship CheckBox ");
			WebActionUtil.fail("Unable to click on Dual Citizenship CheckBox ");
			Assert.fail("Unable to click on Dual Citizenship CheckBox ");
		}
	}

	/**
	 * Description Method Selects the dualcitizenship option from the Dual
	 * Citizenship Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param dualcitizenship
	 */

	public synchronized void selectDualCitizenshipDd(String dualcitizenship) {
		try {
			WebActionUtil.waitForElement(ddDualCitizenship, "Dual Citizenship drop down");
			WebActionUtil.clickOnElement(ddDualCitizenship, "Dual Citizenship drop down",
					"Unable to click on Dual Citizenship drop down");
			WebActionUtil.waitForElement(tbDualCitizenship, "Dual Citizenship text box");
			WebActionUtil.typeText(tbDualCitizenship, dualcitizenship, "Dual Citizenship text box");
			boolean flag = true;
			for (WebElement dualcitizenshipOptions : otnDualCitizenship) {
				String dualcitizenshipOption = dualcitizenshipOptions.getText();
				if (dualcitizenship.equals(dualcitizenshipOption)) {
					WebActionUtil.waitForElement(dualcitizenshipOptions, "Dual Citizenship Option");
					WebActionUtil.clickOnElement(dualcitizenshipOptions, "Dual Citizenship Option",
							"Clicked on " + dualcitizenship + "");
					flag = false;
					break;
				}
			}
			if (flag) {
				WebActionUtil.error(dualcitizenship + " option not present in Dual Citizenship drop down");
				WebActionUtil.fail(dualcitizenship + " option not present in Dual Citizenship drop down");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Dual Citizenship drop down");
			WebActionUtil.fail("Unable to click on Dual Citizenship drop down");
			Assert.fail("Unable to click on Dual Citizenship drop down");
		}
	}

	/**
	 * Description Method Writes the value into Contact Number text box
	 * 
	 * @author Manish Kumar C D
	 * @param contactnumber
	 */
	public synchronized void setContactNumberTb(String contactnumber) {
		try {
			WebActionUtil.waitForElement(txtContactNumber, "Contact Number text box");
			WebActionUtil.typeText(txtContactNumber, contactnumber, "Contact Number text box");
		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Contact Number text box");
			WebActionUtil.fail("Unable to type the value in Contact Number text box");
			Assert.fail("Unable to type the value in Contact Number text box");
		}
	}

	/**
	 * Description Method Selects the ethnicOrigin option from the Ethnic Origin
	 * Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param ethnicorigin
	 */

	public synchronized void selectEthnicOriginDd(String ethnicorigin) {
		try {
			WebActionUtil.waitForElement(ddEthnicOrigin, "Ethnic Origin drop down");
			WebActionUtil.clickOnElement(ddEthnicOrigin, "Ethnic Origin drop down",
					"Unable to click on Ethnic Origin drop down");
			WebActionUtil.waitForElement(tbEthnicOrigin, "Ethnic Origin text box");
			WebActionUtil.typeText(tbEthnicOrigin, ethnicorigin, "Ethnic Origin text box");

			for (WebElement ethnicoriginOptions : otnEthnicOrigin) {
				String ethnicoriginOption = ethnicoriginOptions.getText();

				if (ethnicorigin.equalsIgnoreCase(ethnicoriginOption)) {
					WebActionUtil.actionClick(ethnicoriginOptions, "" + ethnicorigin + "");
					WebActionUtil.validationinfo("Selected " + ethnicorigin + " from Ethnic Origin drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Ethnic Origin drop down");
			WebActionUtil.fail("Unable to click on Ethnic Origin drop down");
			Assert.fail("Unable to click on Ethnic Origin drop down");
		}
	}

	/**
	 * Description Method MouseHovers on Ethnic Origin Link
	 * 
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void mouseHoverEthnicOriginlnk() {
		try {
			WebActionUtil.waitForElement(lnkEthnicOrigin, "Ethnic Origin Link");
			WebActionUtil.actionMouseOver(lnkEthnicOrigin, "Ethnic Origin Link");
			WebActionUtil.waitForElement(popUpEthnicOrigin, "Ethnic Origin PopUp");
			WebActionUtil.validateisElementDisplayed(popUpEthnicOrigin, "Ethnic Origin PopUp",
					"Information PopUp is displayed", "Information PopUp is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error("Unable to mouseHover on Ethnic Origin Link");
			WebActionUtil.fail("Unable to mouseHover on Ethnic Origin Link");
			Assert.fail("Unable to mouseHover on Ethnic Origin Link");
		}
	}

	/**
	 * Description Method Selects the race Option from the Race Dropdown
	 * 
	 * @author Manish Kumar C D
	 * @param race
	 */

	public synchronized void selectRaceDd(String race) {
		try {
			WebActionUtil.waitForElement(ddRace, "Race drop down");
			WebActionUtil.clickOnElement(ddRace, "Race drop down", "Unable to click on Race drop down");
			WebActionUtil.waitForElement(tbRace, "Race text box");
			WebActionUtil.typeText(tbRace, race, "Race text box");

			for (WebElement raceOptions : otnRace) {
				String raceOption = raceOptions.getText();

				if (race.contentEquals(raceOption)) {
					WebActionUtil.actionClick(raceOptions, "" + race + "");
					WebActionUtil.validationinfo("Selected " + race + " from Race drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Race drop down");
			WebActionUtil.fail("Unable to click on Race drop down");
			Assert.fail("Unable to click on Race drop down");
		}
	}

	/**
	 * Description Method MouseHovers on Ethnic Origin Link
	 * 
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void mouseHoverRacelnk() {
		try {
			WebActionUtil.waitForElement(lnkRace, "Race Link");
			WebActionUtil.actionMouseOver(lnkRace, "Race Link");
			WebActionUtil.waitForElement(popUpRace, "Race PopUp");
			WebActionUtil.validateisElementDisplayed(popUpRace, "Race PopUp", "Information PopUp is displayed",
					"Information PopUp is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error("Unable to mouseHover on Race Link");
			WebActionUtil.fail("Unable to mouseHover on Race Link");
			Assert.fail("Unable to mouseHover on Race Link");
		}
	}

	/**
	 * Description Method Clicks on My Current Address Is My Permanent Address
	 * CheckBox
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkMyCurrentAddressIsMyPermanentAddressCb() {
		try {
			WebActionUtil.scrollToElement(cbMyCurrentAddressIsMyPermanentAddress,
					"My Current Address Is My Permanent Address CheckBox");
			WebActionUtil.waitForElement(cbMyCurrentAddressIsMyPermanentAddress,
					"My Current Address Is My Permanent Address CheckBox");
			WebActionUtil.clickCheckBox(cbMyCurrentAddressIsMyPermanentAddress,
					"My Current Address Is My Permanent Address CheckBox");
			WebActionUtil.validateisElementDisplayed(cbMyCurrentAddressIsMyPermanentAddress,
					"My Current Address Is My Permanent Address CheckBox",
					"My Current Address Is My Permanent Address CheckBox is selected",
					"My Current Address Is My Permanent Address CheckBox is not selected", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on My Current Address Is My Permanent Address CheckBox ");
			WebActionUtil.fail("Unable to click on My Current Address Is My Permanent Address CheckBox ");
			Assert.fail("Unable to click on My Current Address Is My Permanent Address CheckBox ");
		}
	}

	/**
	 * Description Method Writes the value into C/O TextBox of Permanent Address
	 * 
	 * @author Manish Kumar C D
	 * @param copermanent
	 */

	public synchronized void setCOPermanentTb(String copermanent) {
		try {
			WebActionUtil.waitForElement(tbPermanentAddressCo, "C/O text box");
			WebActionUtil.clearText(tbPermanentAddressCo, "C/O text box");
			WebActionUtil.typeText(tbPermanentAddressCo, copermanent, "C/O text box");
			WebActionUtil.validateisElementDisplayed(tbPermanentAddressCo, "C/O text box",
					"Entered " + copermanent + " in C/O text box", "Unable to Enter in C/O text box", "blue");
		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Co text box");
			WebActionUtil.fail("Unable to type the value in Co text box");
			Assert.fail("Unable to type the value in Co text box");
		}
	}

	/**
	 * Description Method Writes the value into Address Line1 TextBox of Permanent
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param addressline1permanent
	 */

	public synchronized void setAddressLine1Permanenttb(String addressline1permanent) {
		try {
			WebActionUtil.waitForElement(tbPermanentAddressAddressLine1, "AddressLine 1 text box");
			WebActionUtil.clearText(tbPermanentAddressAddressLine1, "Address Line1 text box");
			WebActionUtil.typeText(tbPermanentAddressAddressLine1, addressline1permanent, "AddressLine 1 text box");
			WebActionUtil.validateisElementDisplayed(tbPermanentAddressAddressLine1, "AddressLine 1 text box",
					"Entered " + addressline1permanent + " in AddressLine 1 text box",
					"Unable to Enter in AddressLine 1 text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in AddressLine 1 text box");
			WebActionUtil.fail("Unable to type the value in AddressLine 1 text box");
			Assert.fail("Unable to type the value in AddressLine 1 text box");
		}
	}

	/**
	 * Description Method Writes the value into Address Line2 TextBox of Permanent
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param addressline2permanent
	 */

	public synchronized void setAddressLine2Permanenttb(String addressline2permanent) {
		try {
			WebActionUtil.waitForElement(tbPermanentAddressAddressLine2, "AddressLine 2 text box");
			WebActionUtil.clearText(tbPermanentAddressAddressLine2, "Address Line2 text box");
			WebActionUtil.typeText(tbPermanentAddressAddressLine2, addressline2permanent, "AddressLine 2 text box");
			WebActionUtil.validateisElementDisplayed(tbPermanentAddressAddressLine2, "AddressLine 2 text box",
					"Entered " + addressline2permanent + " in AddressLine 2 text box",
					"Unable to Enter in AddressLine 2 text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in AddressLine 2 text box");
			WebActionUtil.fail("Unable to type the value in AddressLine 2 text box");
			Assert.fail("Unable to type the value in AddressLine 2 text box");
		}
	}

	/**
	 * Description Method Selects the country Option from the Country Dropdown of
	 * Permanent Address.
	 * 
	 * @author Manish Kumar C D
	 * @param countrypermanent
	 */

	public synchronized void selectCountryPermanentDd(String countrypermanent) {
		try {
			WebActionUtil.waitForElement(ddPermanentAddressCountry, "Country drop down");
			WebActionUtil.clickOnElement(ddPermanentAddressCountry, "Country drop down",
					"Unable to click on Country drop down");
			WebActionUtil.waitForElement(tbPermanentAddressCountry, "Country text box");
			WebActionUtil.typeText(tbPermanentAddressCountry, countrypermanent, "Country text box");

			for (WebElement countrypermanentOptions : otnPermanentAddressCountry) {
				String countrypermanentOption = countrypermanentOptions.getText();
				if (countrypermanent.contentEquals(countrypermanentOption)) {
					WebActionUtil.actionClick(countrypermanentOptions, "" + countrypermanent + "");
					WebActionUtil.validationinfo("Selected " + countrypermanent + " from Country drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Country drop down");
			WebActionUtil.fail("Unable to click on Country drop down");
			Assert.fail("Unable to click on Country drop down");
		}
	}

	/**
	 * Description Method Selects the state Option from the State Dropdown of
	 * Permanent Address.
	 * 
	 * @author Manish Kumar C D
	 * @param statepermanent
	 */

	public synchronized void selectStatePermanentDd(String statepermanent) {
		try {
			WebActionUtil.waitForElement(ddPermanentAddressState, "State drop down");
			WebActionUtil.clickOnElement(ddPermanentAddressState, "State drop down",
					"Unable to click on State drop down");
			WebActionUtil.waitForElement(tbPermanentAddressState, "State text box");
			WebActionUtil.typeText(tbPermanentAddressState, statepermanent, "State text box");

			for (WebElement statepermanentOptions : otnPermanentAddressState) {
				String statepermanentOption = statepermanentOptions.getText();

				if (statepermanent.contentEquals(statepermanentOption)) {
					WebActionUtil.actionClick(statepermanentOptions, "" + statepermanent + "");
					WebActionUtil.validationinfo("Selected " + statepermanent + " from State drop down", "blue");
				}

			}
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on State drop down");
			WebActionUtil.fail("Unable to click on State drop down");
			Assert.fail("Unable to click on State drop down");
		}
	}

	/**
	 * Description Method Writes the value into City TextBox of Permanent Address
	 * 
	 * @author Manish Kumar C D
	 * @param citypermanent
	 */

	public synchronized void setCityPermanentTb(String citypermanent) {
		try {
			WebActionUtil.waitForElement(tbPermanentAddressCity, "City text box");
			WebActionUtil.clearText(tbPermanentAddressCity, "City text box");
			WebActionUtil.typeText(tbPermanentAddressCity, citypermanent, "City text box");
			WebActionUtil.validateisElementDisplayed(tbPermanentAddressCity, "City text box",
					"Entered " + citypermanent + " in City text box", "Unable to Enter in City text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in City text box");
			WebActionUtil.fail("Unable to type the value in City text box");
			Assert.fail("Unable to type the value in City text box");
		}
	}

	/**
	 * Description Method Writes the value into Postal Code TextBox of Permanent
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param postalcodepermanent
	 */

	public synchronized void setPostalCodePermanentTb(String postalcodepermanent) {
		try {
			WebActionUtil.waitForElement(tbPermanentAddressPostalCode, "Postal Code text box");
			WebActionUtil.clearText(tbPermanentAddressPostalCode, "Postal Code text box");
			WebActionUtil.typeText(tbPermanentAddressPostalCode, postalcodepermanent, "Postal Code text box");
			WebActionUtil.validateisElementDisplayed(tbPermanentAddressPostalCode, "Postal Code text box",
					"Entered " + postalcodepermanent + " in Postal Code text box",
					"Unable to Enter in Postal Code text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Postal Code text box");
			WebActionUtil.fail("Unable to type the value in Postal Code text box");
			Assert.fail("Unable to type the value in Postal Code text box");
		}
	}

	/**
	 * Description Method Writes the value into C/O TextBox of Current Address
	 * 
	 * @author Manish Kumar C D
	 * @param cocurrent
	 */

	public synchronized void setCOCurrentTb(String cocurrent) {
		try {
			WebActionUtil.scrollToElement(tbCurrentAddressCo, "C/O text box");
			WebActionUtil.waitForElement(tbCurrentAddressCo, "C/O text box");
			WebActionUtil.typeText(tbCurrentAddressCo, cocurrent, "C/O text box");
			WebActionUtil.validateisElementDisplayed(tbCurrentAddressCo, "C/O text box",
					"Entered " + cocurrent + " in C/O text box", "Unable to Enter in C/O text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Co text box");
			WebActionUtil.fail("Unable to type the value in Co text box");
			Assert.fail("Unable to type the value in Co text box");
		}
	}

	/**
	 * Description Method Writes the value into Address Line1 TextBox of Current
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param addressline1current
	 */

	public synchronized void setAddressLine1Currenttb(String addressline1current) {
		try {
			WebActionUtil.waitForElement(tbCurrentAddressAddressLine1, "AddressLine 1 text box");
			WebActionUtil.typeText(tbCurrentAddressAddressLine1, addressline1current, "AddressLine 1 text box");
			WebActionUtil.validateisElementDisplayed(tbCurrentAddressAddressLine1, "AddressLine 1 text box",
					"Entered " + addressline1current + " in AddressLine 1 text box",
					"Unable to Enter in AddressLine 1 text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in AddressLine 1 text box");
			WebActionUtil.fail("Unable to type the value in AddressLine 1 text box");
			Assert.fail("Unable to type the value in AddressLine 1 text box");
		}
	}

	/**
	 * Description Method Writes the value into Address Line2 TextBox of Current
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param addressline2current
	 */

	public synchronized void setAddressLine2Currenttb(String addressline2current) {
		try {
			WebActionUtil.waitForElement(tbCurrentAddressAddressLine2, "AddressLine 2 text box");
			WebActionUtil.typeText(tbCurrentAddressAddressLine2, addressline2current, "AddressLine 2 text box");
			WebActionUtil.validateisElementDisplayed(tbCurrentAddressAddressLine2, "AddressLine 2 text box",
					"Entered " + addressline2current + " in AddressLine 2 text box",
					"Unable to Enter in AddressLine 2 text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in AddressLine 2 text box");
			WebActionUtil.fail("Unable to type the value in AddressLine 2 text box");
			Assert.fail("Unable to type the value in AddressLine 2 text box");
		}
	}

	/**
	 * Description Method Selects the country Option from the Country Dropdown of
	 * Current Address.
	 * 
	 * @author Manish Kumar C D
	 * @param countrycurrent
	 */

	public synchronized void selectCountryCurrentDd(String countrycurrent) {
		try {
			WebActionUtil.waitForElement(ddCurrentAddressCountry, "Country drop down");
			WebActionUtil.clickOnElement(ddCurrentAddressCountry, "Country drop down",
					"Unable to click on Country drop down");
			WebActionUtil.waitForElement(tbCurrentAddressCountry, "Country text box");
			WebActionUtil.typeText(tbCurrentAddressCountry, countrycurrent, "Country text box");

			for (WebElement countrycurrentOptions : otnCurrentAddressCountry) {
				String countrycurrentOption = countrycurrentOptions.getText();
				if (countrycurrent.contentEquals(countrycurrentOption)) {
					WebActionUtil.actionClick(countrycurrentOptions, "" + countrycurrent + "");
					WebActionUtil.validationinfo("Selected " + countrycurrent + " from Country drop down", "blue");
				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Country drop down");
			WebActionUtil.fail("Unable to click on Country drop down");
			Assert.fail("Unable to click on Country drop down");
		}
	}

	/**
	 * Description Method Selects the state Option from the State Dropdown of
	 * Current Address.
	 * 
	 * @author Manish Kumar C D
	 * @param statecurrent
	 */

	public synchronized void selectStateCurrentDd(String statecurrent) {
		try {
			WebActionUtil.waitForElement(ddCurrentAddressState, "State drop down");
			WebActionUtil.clickOnElement(ddCurrentAddressState, "State drop down", "Unable to click on State drop down");
			WebActionUtil.waitForElement(tbCurrentAddressState, "State text box");
			WebActionUtil.typeText(tbCurrentAddressState, statecurrent, "State text box");

			for (WebElement statecurrentOptions : otnCurrentAddressState) {
				String statecurrentOption = statecurrentOptions.getText();

				if (statecurrent.contentEquals(statecurrentOption)) {
					WebActionUtil.clickOnElement(statecurrentOptions, "State Option",
							"Clicked on " + statecurrent + "");
					WebActionUtil.validationinfo("Selected " + statecurrent + " from State drop down", "blue");

				}
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on State drop down");
			WebActionUtil.fail("Unable to click on State drop down");
			Assert.fail("Unable to click on State drop down");
		}
	}

	/**
	 * Description Method Writes the value into City TextBox of Current Address
	 * 
	 * @author Manish Kumar C D
	 * @param citycurrent
	 */

	public synchronized void setCityCurrentTb(String citycurrent) {
		try {
			WebActionUtil.waitForElement(tbCurrentAddressCity, "City text box");
			WebActionUtil.typeText(tbCurrentAddressCity, citycurrent, "City text box");
			WebActionUtil.validateisElementDisplayed(tbCurrentAddressCity, "City text box",
					"Entered " + citycurrent + " in City text box", "Unable to Enter in City text box", "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in City text box");
			WebActionUtil.fail("Unable to type the value in City text box");
			Assert.fail("Unable to type the value in City text box");
		}
	}

	/**
	 * Description Method Writes the value into Postal Code TextBox of Current
	 * Address
	 * 
	 * @author Manish Kumar C D
	 * @param postalcodecurent
	 */

	public synchronized void setPostalCodeCurrentTb(String postalcodecurent) {
		try {
			WebActionUtil.waitForElement(tbCurrentAddressPostalCode, "Postal Code text box");
			WebActionUtil.typeText(tbCurrentAddressPostalCode, postalcodecurent, "Postal Code text box");
			WebActionUtil.validateisElementDisplayed(tbCurrentAddressPostalCode, "Postal Code text box",
					"Entered " + postalcodecurent + " in Postal Code text box", "Unable to Enter in Postal Code text box",
					"blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to type the value in Postal Code text box");
			WebActionUtil.fail("Unable to type the value in Postal Code text box");
			Assert.fail("Unable to type the value in Postal Code text box");
		}
	}

	/**
	 * Description Method clicks on Continue Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkContinuebtn(String expectedAdditionalInfoUrl) {
		try {
			WebActionUtil.scrollToElement(btnContinue, "Continue button");
			WebActionUtil.waitForElement(btnContinue, "Continue button");
			WebActionUtil.clickOnElement(btnContinue, "Continue button", "Unable to click on Continue button");
			WebActionUtil.waitForAngularPageload();
			validateAdditionalInfoPage(expectedAdditionalInfoUrl);
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Continue button");
			WebActionUtil.fail("Unable to click on Continue button");
			Assert.fail("Unable to click on Continue button");
		}
	}

	/**
	 * Description Method clicks on Save As Draft Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkSaveAsDraftbtn() {
		try {
			WebActionUtil.waitForElement(btnSaveAsDraft, "Save As Draft button");
			WebActionUtil.clickOnElement(btnSaveAsDraft, "Save As Draft button",
					"Unable to click on Save As Draft button");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Save As Draft button");
			WebActionUtil.fail("Unable to click on Save As Draft button");
			Assert.fail("Unable to click on Save As Draft button");
		}
	}

	/**
	 * Description Method clicks on Browse Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkBrowsebtn() {
		try {
			WebActionUtil.waitForElement(btnBrowse, "Browse button");
			WebActionUtil.clickOnElement(btnBrowse, "Browse button", "Unable to click on Browse button");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Browse button");
			WebActionUtil.fail("Unable to click on Browse button");
			Assert.fail("Unable to click on Browse button");
		}
	}

	/**
	 * Description Method clicks on Cancel Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkCancelbtn() {
		try {
			WebActionUtil.waitForElement(btnCancel, "Cancel button");
			WebActionUtil.clickOnElement(btnCancel, "Cancel button", "Unable to click on Cancel button");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Cancel button");
			WebActionUtil.fail("Unable to click on Cancel button");
			Assert.fail("Unable to click on Cancel button");
		}
	}

	/**
	 * Description Method clicks on Ok Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkOkbtn() {
		try {
			WebActionUtil.waitForElement(btnOk, "Ok button");
			WebActionUtil.clickOnElement(btnOk, "Ok button", "Unable to click on Ok button");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Ok button");
			WebActionUtil.fail("Unable to click on Ok button");
			Assert.fail("Unable to click on Ok button");
		}
	}

	/**
	 * Description Method clicks on Upload Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkUploadbtn() {
		try {
			WebActionUtil.waitForElement(btnUpload, "Upload button");
			WebActionUtil.clickOnElement(btnUpload, "Upload button", "Unable to click on Upload button");
		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Upload button");
			WebActionUtil.fail("Unable to click on Upload button");
			Assert.fail("Unable to click on Upload button");
		}
	}

	/**
	 * Description Method clicks on Close Button
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkClosebtn() {
		try {
			WebActionUtil.waitForElement(btnClose, "Close button");
			WebActionUtil.clickOnElement(btnClose, "Close button", "Unable to click on Close button");

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Close button");
			WebActionUtil.fail("Unable to click on Close button");
			Assert.fail("Unable to click on Close button");
		}
	}

	/**
	 * Description Method clicks on Change Link
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkChangeLnk() {
		try {
			WebActionUtil.scrollToElement(lnkChangePhoto, "Change Photo link");
			WebActionUtil.waitForElement(lnkChangePhoto, "Change Photo link");
			WebActionUtil.actionClick(lnkChangePhoto, "Change Photo link");

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Change Photo link");
			WebActionUtil.fail("Unable to click on Change Photo link");
			Assert.fail("Unable to click on Change Photo link");
		}
	}

	/**
	 * Description Method clicks on Upload Your Color Photograph Image
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void clkUploadYourColorPhotographImg() {
		try {
			WebActionUtil.scrollToElement(imgUploadYourColorPhotograph, "Upload your color photograph");
			WebActionUtil.waitForElement(imgUploadYourColorPhotograph, "Click to upload your color photograph");
			WebActionUtil.clickOnElement(imgUploadYourColorPhotograph, "Click to upload your color photograph",
					"Unable to click on Click to upload your color photograph");

		} catch (Exception e) {
			WebActionUtil.error("Unable to click on Click to upload your color photograph");
			WebActionUtil.fail("Unable to click on Click to upload your color photograph");
			Assert.fail("Unable to click on Click to upload your color photograph");
		}
	}

	/**
	 * Description Method Uploads the Profile Picture
	 * 
	 * @author Manish Kumar C D
	 * @param imagePath
	 */

	public synchronized void uploadProfilePicture(String imagePath) {
		try {
			clkBrowsebtn();
			WebActionUtil.upload(imagePath);
			String filename = txtSampleFileName.getText();
			clkUploadbtn();
			WebActionUtil.waitForElement(txtPhotoUploadedSuccessfully, "Photo Uploaded Successfully Text");
			WebActionUtil.validateisElementDisplayed(txtPhotoUploadedSuccessfully, "Photo Uploaded Successfully Text",
					"Photo Uploaded Successfully is displayed", "Photo Uploaded Successfully is not displayed", "blue");
			clkOkbtn();

		} catch (Exception e) {
			WebActionUtil.error("Unable to Upload the Photo");
			WebActionUtil.fail("Unable to Upload the Photo");
			Assert.fail("Unable to Upload the Photo");
		}
	}

	/**
	 * Description Method implementation validates that name is present in First
	 * Name textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateFirstNametxt() {
		try {
			String firstNameText = txtFirstName.getText();
			if (!firstNameText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtFirstName, "First Name Textfield",
						"First Name is AutoFilled", "First Name textfield is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate First Name textfield");
			WebActionUtil.fail("Unable to validate First Name textfield");
			Assert.fail("Unable to validate First Name textfield");
		}
	}

	/**
	 * Description Method implementation validates that name is present in Last Name
	 * textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateLastNametxt() {
		try {
			String lastNameText = txtLastName.getText();
			if (!lastNameText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtLastName, "Last Name Textfield", "Last Name is AutoFilled",
						"Last Name textfield is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Last Name textfield");
			WebActionUtil.fail("Unable to validate Last Name textfield");
			Assert.fail("Unable to validate Last Name textfield");
		}
	}

	/**
	 * Description Method implementation validates that date is present in DOJ At
	 * Present Location date
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateDOJAtPresentLocationtxt() {
		try {
			String dojAtPresentLocationText = txtDOJAtPresentLocation.getText();
			if (!dojAtPresentLocationText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtDOJAtPresentLocation, "DOJ At Present Location Date text",
						"DOJ At Present Location is AutoFilled", "DOJ At Present Location is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate DOJ At Present Location date text");
			WebActionUtil.fail("Unable to validate DOJ At Present Location date text");
			Assert.fail("Unable to validate DOJ At Present Location date text");
		}
	}

	/**
	 * Description Method implementation validates that name is present in Client
	 * Name Textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateClientNametxt() {
		try {
			String clientNameText = txtClientName.getText();
			if (!clientNameText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtClientName, "Client Name Text", "Client Name is AutoFilled",
						"Client Name is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Client Name Text");
			WebActionUtil.fail("Unable to validate Client Name Text");
			Assert.fail("Unable to validate Client Name Text");
		}
	}

	/**
	 * Description Method implementation validates that address is present in Client
	 * Address Textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateClientAddresstxt() {
		try {
			String clientAddressText = txtClientAddress.getText();
			if (!clientAddressText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtClientAddress, "Client Address text",
						"Client Address is AutoFilled", "Client Address is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Client Address text");
			WebActionUtil.fail("Unable to validate Client Address text");
			Assert.fail("Unable to validate Client Address text");
		}
	}

	/**
	 * Description Method implementation validates that email is present in Email
	 * textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateEmailtxt() {
		try {
			String emailText = txtEmail.getText();
			if (!emailText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtEmail, "Email Textfield", "Email is AutoFilled",
						"Email textfield is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Email text field");
			WebActionUtil.fail("Unable to validate Email text field");
			Assert.fail("Unable to validate Email text field");
		}
	}

	/**
	 * Description Method implementation validates that contact is present in
	 * Contact Number textfield
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateContactNumbertxt() {
		try {
			String contactNumberText = txtContactNumber.getText();
			if (!contactNumberText.equals(null)) {
				WebActionUtil.validateisElementDisplayed(txtContactNumber, "Contact Number text field",
						"Contact Number text field is AutoFilled", "Contact Number Textfield is not AutoFilled", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Contact Number text field");
			WebActionUtil.fail("Unable to validate Contact Number text field");
			Assert.fail("Unable to validate Contact Number textfield");
		}
	}

	/**
	 * Description Method Validates Joining Form Page
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateJoiningFormPage(String expectedJoiningFormUrl) {
		try {
			WebActionUtil.waitForInvisibilityOfElement(spinner, "Spinner", 120l);
			WebActionUtil.poll(1000);
			String actualJoiningFormUrl = driver.getCurrentUrl();

			if (actualJoiningFormUrl.contentEquals(expectedJoiningFormUrl)) {
				WebActionUtil.info("Joining Form Page is Displayed., url= " + actualJoiningFormUrl);
				WebActionUtil.validationinfo("Joining Form Page is Displayed., url= " + actualJoiningFormUrl, "green");
			} else {
				WebActionUtil.fail("Joining Form Page is not Displayed., Url not matching, Expected= "
						+ expectedJoiningFormUrl + ", Actual= " + actualJoiningFormUrl);
				WebActionUtil.error("Joining Form Page is not Displayed., Url not matching, Expected= "
						+ expectedJoiningFormUrl + ", Actual= " + actualJoiningFormUrl);
			}

			String[] expectedTitle = new String[] { "Personal Details ", "Address Details " };

			ArrayList<String> lstExpectedTitle = new ArrayList<>();
			ArrayList<String> lstActualTitle = new ArrayList<>();

			for (WebElement txtTitle : txtTitles) {
				String actualTitle = txtTitle.getText();
				lstActualTitle.add(actualTitle);
			}
			if (lstExpectedTitle.contains(lstActualTitle)) {
				WebActionUtil.validationinfo("Personal Details and Address Details headers are present.", "blue");
				WebActionUtil.validationinfo("All the fields are displayed under Personal Details.", "blue");
				WebActionUtil.validationinfo("All the fields are displayed under Address Details.", "blue");
			}

		} catch (Exception e) {
			WebActionUtil.error("Unable to validate Joining Form Page");
			WebActionUtil.fail("Unable to validate Joining Form Page");
			Assert.fail("Unable to validate Joining Form Page");
		}
	}

	/**
	 * Description Method validates Additional Info Page
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void validateAdditionalInfoPage(String expectedAdditionalInfoUrl) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(expectedAdditionalInfoUrl));
			WebActionUtil.waitForInvisibilityOfElement(spinner, "Spinner", 120l);

			if (tabPersonalBefore != tabPersonalAfter) {
				WebActionUtil.extentinfo("Completed Filling of Joining Form Successfully");
			} else {
				throw new Exception();
			}

			String actualAdditionalInfoUrl = driver.getCurrentUrl();

			if (actualAdditionalInfoUrl.contentEquals(expectedAdditionalInfoUrl)) {
				WebActionUtil.info("Additional Info Page is Displayed., url= " + actualAdditionalInfoUrl);
				WebActionUtil.validationinfo("Additional Info Page is Displayed., url= " + actualAdditionalInfoUrl,
						"green");
			} else {
				WebActionUtil.fail("Additional Info Page is not Displayed., Url not matching, Expected= "
						+ expectedAdditionalInfoUrl + ", Actual= " + actualAdditionalInfoUrl);
				WebActionUtil.error("Additional Info Page is not Displayed., Url not matching, Expected= "
						+ expectedAdditionalInfoUrl + ", Actual= " + actualAdditionalInfoUrl);
			}

			String[] expectedAdditionalInfoTitle = new String[] { "Passport Details ", "Additional Information ",
					"Emergency Contact Details " };
			ArrayList<String> lstExpectedAdditionalInfoTitle = new ArrayList<>();
			ArrayList<String> lstActualAdditionalInfoTitle = new ArrayList<>();

			for (WebElement txtAdditionalInfoTitle : txtAdditionalInfoTitles) {
				String actualAdditionalInfoTitle = txtAdditionalInfoTitle.getText();
				lstActualAdditionalInfoTitle.add(actualAdditionalInfoTitle);

				if (lstActualAdditionalInfoTitle.containsAll(lstExpectedAdditionalInfoTitle)) {
					WebActionUtil.validationinfo(
							"Passport Details, Additional Information and Emergency Contact Details headers are visible.",
							"blue");
				}
			}
		}

		catch (Exception e) {
			WebActionUtil.error("Unable to validate Additional Info Page");
			WebActionUtil.fail("Unable to validate Additional Info Page");
			Assert.fail("Unable to validate Additional Info Page");
		}
	}

	/**
	 * Description Method to select the particular date from Date of Birth.
	 * 
	 * @author Manish Kumar C D
	 * @param date
	 */

	public synchronized void selectDateofBirth(String dateofbirth) {
		try {
			String dateofBirthId = "L007";
			WebActionUtil.selectCalendarDate(dateofBirthId, dateofbirth, "Date Of Birth");

			if (WebActionUtil.getTextUsingJS("L007").equals(dateofbirth)) {
				WebActionUtil.validationinfo("Date of Birth selected is " + dateofbirth + " ", "blue");
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
	 * Description Method to select the particular date from Marriage Date.
	 * 
	 * @author Manish Kumar C D
	 * @param date
	 */

	public synchronized void selectMarriageDate(String marriagedate) {
		try {

			String marriageDateId = "L103";
			WebActionUtil.selectCalendarDate(marriageDateId, marriagedate, "Date Of Birth");

			String actualmarriagedate = WebActionUtil.getTextUsingJS("L103");
			WebActionUtil.comparetText(actualmarriagedate, marriagedate, "blue");

		} catch (Exception e) {
			WebActionUtil.error("Unable to select date in Marriage Date");
			WebActionUtil.fail("Unable to select date in Marriage Date");
			Assert.fail("Unable to select date in Marriage Date");
		}
	}

	/**
	 * Description Method to Fill Personal Details fields
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void personalDetails(String title, String middleName, String preferredName, String gender,
			String placeofbirth, String date, String maritalstatus, String nationality, String citizenship,
			String ethnicorigin, String race) {
		selectTitleDd(title);
		validateFirstNametxt();
		setMiddleNameTb(middleName);
		validateLastNametxt();
		// clkDifferentMaidenCb();
		setPreferredNameTb(preferredName);
		selectGenderDd(gender);
		setPlaceOfBirthTb(placeofbirth);
		selectDateofBirth(date);
		validateEmailtxt();
		selectMaritalStatusDd(maritalstatus);
		selectNationalityDd(nationality);
		selectCitizenshipDd(citizenship);
		// clkDualCitizenshipCb();
		validateContactNumbertxt();
		selectEthnicOriginDd(ethnicorigin);
		selectRaceDd(race);
	}

	/**
	 * Description Method Fills the Permanent Address
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void permanentAddress(String copermanent, String addressline1permanent,
			String addressline2permanent, String countrypermanent, String statepermanent, String citypermanent,
			String postalcodepermanent) {
		setCOPermanentTb(copermanent);
		setAddressLine1Permanenttb(addressline1permanent);
		setAddressLine2Permanenttb(addressline2permanent);
		selectCountryPermanentDd(countrypermanent);
		selectStatePermanentDd(statepermanent);
		setCityPermanentTb(citypermanent);
		setPostalCodePermanentTb(postalcodepermanent);
	}

	/**
	 * Description Method Fills the Current Address
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void currentAddress(String cocurrent, String addressline1current, String addressline2current,
			String countrycurrent, String statecurrent, String citycurrent, String postalcodecurrent) {
		setCOCurrentTb(cocurrent);
		setAddressLine1Currenttb(addressline1current);
		setAddressLine2Currenttb(addressline2current);
		selectCountryCurrentDd(countrycurrent);
		selectStateCurrentDd(statecurrent);
		setCityCurrentTb(citycurrent);
		setPostalCodeCurrentTb(postalcodecurrent);
	}

	/**
	 * Description Method fetch Candidate name
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized String fetchName() {
		WebElement fname = driver.findElement(By.xpath("//div[@class='fname_pop']/following-sibling::input"));
		WebElement lname = driver.findElement(By.xpath("//div[@class='lname_pop']/following-sibling::input"));
		String firstName = fname.getAttribute("value");
		String lstName = lname.getAttribute("value");
		String lastName = lstName.substring(0, 1).toUpperCase() + lstName.substring(1);
		String name = firstName + " " + lastName;

		return name;
	}

	/**
	 * Description Method fetch Search name
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized String fetchCompleteName(String middleName) {
		WebElement fname = driver.findElement(By.xpath("//div[@class='fname_pop']/following-sibling::input"));
		WebElement lname = driver.findElement(By.xpath("//div[@class='lname_pop']/following-sibling::input"));
		String firstName = fname.getAttribute("value");
		String lstName = lname.getAttribute("value");
		String name = firstName + " " + middleName + " " + lstName;

		return name;
	}

	/**
	 * Description Method to Fill Personal Details fields
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void personalDetailsforThirdParty(String title, String middleName, String preferredName,
			String gender, String dateOfBirth, String nationality) {
		selectTitleDd(title);
		validateFirstNametxt();
		setMiddleNameTb(middleName);
		validateLastNametxt();
		selectGenderDd(gender);
		setPreferredNameTb(preferredName);
		selectDateofBirth(dateOfBirth);
		selectNationalityDd(nationality);
		validateDOJAtPresentLocationtxt();
		validateClientNametxt();
		validateClientAddresstxt();
		validateEmailtxt();
		validateContactNumbertxt();

	}

	/**
	 * Description Method Fills the Permanent Address
	 * 
	 * @author Manish Kumar C D
	 * 
	 */

	public synchronized void permanentAddressforThirdParty(String copermanent, String addressline1permanent,
			String addressline2permanent, String countrypermanent, String statepermanent, String citypermanent,
			String postalcodepermanent) {
		setCOPermanentTb(copermanent);
		setAddressLine1Permanenttb(addressline1permanent);
		setAddressLine2Permanenttb(addressline2permanent);
		selectCountryPermanentDd(countrypermanent);
		selectStatePermanentDd(statepermanent);
		setCityPermanentTb(citypermanent);
		setPostalCodePermanentTb(postalcodepermanent);

	}

	/**
	 * Description Method to fetch the first name, last name, gender data for
	 * validation
	 * 
	 * @author Manish Kumar C D
	 * @return expectedList
	 */

	public synchronized ArrayList<String> getData() {
		ArrayList<String> expectedList = new ArrayList<>();
		try {
			String expectedFirstName = txtFirstName1.getAttribute("value");
			expectedList.add(expectedFirstName);
			String expectedLastName = txtLastName1.getAttribute("value");
			expectedList.add(expectedLastName);
			String expectedGender = txtGender.getAttribute("title");
			expectedList.add(expectedGender);
		} catch (Exception e) {
			WebActionUtil.error("Unable to fetch data from joining form page");
			WebActionUtil.fail("Unable to fetch data from joining form page");
			Assert.fail("Unable to fetch data from joining form page");
		}
		return expectedList;
	}

	/**
	 * Description Method to Fill Personal Details fields for transfer case
	 * 
	 * @author Manish Kumar C D
	 * @param title
	 * @param middleName
	 * @param maidenName
	 * @param preferredName
	 * @param gender
	 * @param placeofbirth
	 * @param date
	 * @param maritalstatus
	 * @param marriagedate
	 * @param nationality
	 * @param citizenship
	 * @param dualcitizenship
	 * @param ethnicorigin
	 * @param race
	 */
	public synchronized void personalDetailsForTransferCase(String title, String middleName, String maidenName,
			String preferredName, String gender, String placeofbirth, String date, String maritalstatus,
			String marriagedate, String nationality, String citizenship, String dualcitizenship, String ethnicorigin,
			String race) {
		selectTitleDd(title);
		validateFirstNametxt();
		setMiddleNameTb(middleName);
		validateLastNametxt();
		clkDifferentMaidenCb();
		setDifferentMaidenNameTb(maidenName);
		setPreferredNameTb(preferredName);
		selectGenderDd(gender);
		setPlaceOfBirthTb(placeofbirth);
		selectDateofBirth(date);
		validateEmailtxt();
		selectMaritalStatusDd(maritalstatus);
		selectMarriageDate(marriagedate);
		selectNationalityDd(nationality);
		selectCitizenshipDd(citizenship);
		clkDualCitizenshipCb();
		selectDualCitizenshipDd(dualcitizenship);
		validateContactNumbertxt();
		selectEthnicOriginDd(ethnicorigin);
		selectRaceDd(race);
	}

	/**
	 * Description Method to Upload/Change profile photo
	 * 
	 * @author Manish Kumar C D
	 * @param imagePath
	 */
	public synchronized void uploadProfileImage(String imagePath) {
		if (imgUploadYourColorPhotograph.isDisplayed()) {
			/* Click upload color photograph */
			clkUploadYourColorPhotographImg();

			/* Upload the profile picture */
			uploadProfilePicture(imagePath);
		} else {
			clkChangeLnk();
			
			uploadProfilePicture(imagePath);
			
		}
	}

}
