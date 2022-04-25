package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for Preview Page
 * 
 * @author Sajal jain
 */
public class Preview_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Preview_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Preview Icon */
	@FindBy(xpath = "//div[@id='PREVIEW']/div[@class='icon preview']")
	private WebElement icnPreview;

	/* Expand All Drop down */
	@FindBy(id = "ecAll")
	private WebElement ddExpandAll;

	/* Preview Panel */
	@FindBy(xpath = "//div[contains(@id,'preSec')]")
	private List<WebElement> panelPreview;

	/* Gender And Race Self Identification Text */
	@FindBy(xpath = "//div[@id='nav-home']/descendant::p[@class='main-head']/descendant::b")
	private WebElement txtGenderAndRaceSelfIdentification;

	/* I have Read and Understood Check box */
	@FindBy(xpath = "//label[text()=' I have read and understood.']/preceding-sibling::input")
	private WebElement cbIHaveReadAndUnderstoood;

	/* Submit Button */
	@FindBy(id = "fistTb")
	private WebElement btnSubmit1;

	/* Covered Protected Veterans */
	@FindBy(xpath = "//div[@id='nav-profile']/descendant::p[@class='main-head']/descendant::b")
	private WebElement txtCoveredProtectedVeterans;

	/* I have Read and Understood Check box */
	@FindBy(xpath = "//b[text()='I have read and understood.']/parent::label/preceding-sibling::input")
	private WebElement cbIHaveReadUnderstood;

	/* Submit Button */
	@FindBy(id = "secondTb")
	private WebElement btnSubmit2;

	/* Voluntary Self Identification Of Disability Text */
	@FindBy(xpath = "//b[text()='Voluntary Self-Identification of Disability']")
	private WebElement txtVoluntarySelfIdentificationOfDisability;

	/* Submit Button */
	@FindBy(id = "submitTb")
	private WebElement btnSubmit;

	/* Final Submit Button */
	@FindBy(id = "btnFinal")
	private WebElement btnFinalSubmit;

	/* Back Button */
	@FindBy(id = "btnSubmit")
	private WebElement btnBack;

	/* Spinner */
	@FindBy(xpath = "//div[contains(@class,'spinner')]")
	private WebElement spinner;

	/* Joining Form has been submitted successfully Text */
	@FindBy(xpath = "//div[@id='success']/div[text()='Joining Form has been submitted successfully']")
	private WebElement txtJoiningFormHasBeenSubmittedSuccessfully;

	/* Profile Image */
	@FindBy(xpath = "//*[@class='img-circle' or @class='candImg']")
	private WebElement imgProfile;

	/* Logout Link */
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement lnkLogout;

	/* Panel Title Edit Icon */
	@FindBy(xpath = "//h4[@class='panel-title']/i[@class='icon-edit preEdit']")
	private List<WebElement> icnPanelTitle;

	/* Tick Icon */
	@FindBy(xpath = "//div[@class='icon complete']/parent::div")
	private List<WebElement> icnTick;

	/* Edit Icon */
	@FindBy(xpath = "//i[@class='icon-edit preEdit']")
	private List<WebElement> icnEdit;

	/* First Name Text */
	@FindBy(id = "FirstName")
	private WebElement txtFirstName;

	/* Last Name Text */
	@FindBy(id = "LastName")
	private WebElement txtLastName;

	/* Gender Text */
	@FindBy(xpath = "//input[@name='rad1' and @checked='checked']/following-sibling::label")
	private WebElement txtGender;

	/*
	 * Get Personal Details/Address Details/Passport Details/Additional Information/
	 * Emergency Contact Details/Educational Details/Certification
	 * Details/Employment Details Drop down xpath
	 */
	private WebElement getDetailsDd(String detailsType) {
		String xpath = "//h4[contains(text(),'" + detailsType + "')]/i[contains(@class,'indicator')]";
		return driver.findElement(By.xpath(xpath));
	}

	/*
	 * Get Personal Details/Address Details/Passport Details/Additional Information/
	 * Emergency Contact Details/Educational Details/Certification
	 * Details/Employment Details Edit Icon xpath
	 */
	private WebElement getDetailsEditIcn(String detailsType) {
		String xpath = "//h4[contains(text(),'" + detailsType + "')]/i[@class='icon-edit preEdit']";
		return driver.findElement(By.xpath(xpath));
	}

	/*
	 * Get Voluntary Self Identification/Employee Handbook-HCLA/Export Compliance
	 * Policy/Policy And Procedures/Sexual Harassment Policy/Employment
	 * Agreement/CFIUS Security Policies Read Icon xpath
	 */
	private WebElement getDocumentReadIcn(String documentType) {
		String xpath = "//label[contains(text(),'" + documentType
				+ "')]/descendant::a/i[@class='glyphicon glyphicon-new-window']";
		return driver.findElement(By.xpath(xpath));
	}

	/*
	 * Get Voluntary Self Identification/Employee Handbook-HCLA/Export Compliance
	 * Policy/Policy And Procedures/Sexual Harassment Policy/Employment
	 * Agreement/CFIUS Security Policies Check box xpath
	 */
	private WebElement getDocumentCb(String documentType) {
		String xpath = "//label[contains(text(),'" + documentType + "')]/preceding-sibling::input";
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * Description Method to click on Personal Details/Address Details/Passport
	 * Details/Additional Information/ Emergency Contact Details/Educational
	 * Details/Certification Details/Employment Details drop down
	 * 
	 * @author Sajal jain
	 * @param detailsType
	 */
	public synchronized void clkDetailsDd(String detailsType) {
		try {
			WebActionUtil.waitForElement(getDetailsDd(detailsType), detailsType + " drop down");
			WebActionUtil.clickOnElementUsingJS(getDetailsDd(detailsType), detailsType + " drop down");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click " + detailsType + " drop down");
			Assert.fail("Unable to click " + detailsType + " drop down");
		}
	}

	/**
	 * Description Method to click on Personal Details/Address Details/Passport
	 * Details/Additional Information/ Emergency Contact Details/Educational
	 * Details/Certification Details/Employment Details Edit icon
	 * 
	 * @author Sajal jain
	 * @param detailsType
	 */
	public synchronized void clkDetailsEditIcn(String detailsType) {
		try {
			WebActionUtil.waitForElement(getDetailsEditIcn(detailsType), detailsType + " Edit icon");
			WebActionUtil.clickOnElementUsingJS(getDetailsEditIcn(detailsType), detailsType + " Edit icon");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click " + detailsType + " Edit icon");
			Assert.fail("Unable to click " + detailsType + " Edit icon");
		}
	}

	/**
	 * Description Method to click on Expand All drop down & validate all fields are
	 * expanded
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkExpandAllDd() {
		try {
			WebActionUtil.waitForElement(ddExpandAll, "Expand All drop down");
			WebActionUtil.waitForAngularPageToLoad();
			WebActionUtil.clickOnElementUsingJS(ddExpandAll, "Expand All drop down");
			WebActionUtil.waitForAngularPageToLoad();
			ArrayList<String> actualList = new ArrayList<String>();
			String[] expected = new String[] { "true", "true", "true", "true", "true", "true", "true", "true" };
			ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(expected));
			for (WebElement preview : panelPreview) {
				String attribute = preview.getAttribute("aria-expanded");
				actualList.add(attribute);
			}
			if (expectedList.equals(actualList)) {
				WebActionUtil.pass("All the fields are expanded");
				WebActionUtil.info("All the fields are expanded");
			} else {
				WebActionUtil.fail("All the fields are not expanded");
				WebActionUtil.error("All the fields are not expanded");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Expand All drop down");
			Assert.fail("Unable to perform action on Expand All drop down");
		}
	}

	/**
	 * Description Method to click on Voluntary Self Identification/Employee
	 * Handbook-HCLA/Export Compliance Policy/Policy And Procedures/Sexual
	 * Harassment Policy/Employment Agreement/CFIUS Security Policies Read icon
	 * 
	 * @author Sajal jain
	 * @param documentType
	 */
	public synchronized void clkDocumentReadIcn(String documentType) {
		try {
			WebActionUtil.waitForElement(getDocumentReadIcn(documentType), documentType + " read icon");
			WebActionUtil.clickOnElementUsingJS(getDocumentReadIcn(documentType), documentType + " read icon");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click " + documentType + " read icon");
			Assert.fail("Unable to click " + documentType + " read icon");
		}
	}

	/**
	 * Description Method to click on Voluntary Self Identification/Employee
	 * Handbook-HCLA/Export Compliance Policy/Policy And Procedures/Sexual
	 * Harassment Policy/Employment Agreement/CFIUS Security Policies check box
	 * 
	 * @author Sajal jain
	 * @param documentType
	 */
	public synchronized void clkDocumentCb(String documentType) {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			WebActionUtil.clickCheckBoxUsingJS(getDocumentCb(documentType), documentType + " check box");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click " + documentType + " check box");
			Assert.fail("Unable to click " + documentType + " check box");
		}
	}

	/**
	 * Description Method to click on Back button
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkBackBtn() {
		try {
			WebActionUtil.waitForElement(btnBack, "Back button");
			WebActionUtil.clickOnElement(btnBack, "Back button", "Unable to click Back button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Back button");
			Assert.fail("Unable to click Back button");
		}
	}

	/**
	 * Description Method to mouse over to Profile drop down & click on Logout link
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkLogoutLnk() {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			WebActionUtil.actionMouseOver(imgProfile, "Profile image");
			WebActionUtil.waitForElement(lnkLogout, "Logout link");
			WebActionUtil.clickOnElement(lnkLogout, "Logout link", "Unable to click Logout link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform Logout action");
			Assert.fail("Unable to perform Logout action");
		}
	}

	/**
	 * Description Method to validate Voluntary Self-Identification (Gender And Race
	 * Self Identification) form is displayed & click on I have read and understood
	 * check box & click on Submit button
	 * 
	 * @author Sajal jain
	 * @param expectedFormHeader
	 */
	public synchronized void clkSubmit1Btn(String expectedFormHeader) {
		try {
			WebActionUtil.validatePartialText(expectedFormHeader, txtGenderAndRaceSelfIdentification,
					"Voluntary Self-Identification Form(Gender And Race Self Identification) text",
					"Voluntary Self-Identification (Gender And Race Self Identification) form is displayed",
					"Voluntary Self-Identification (Gender And Race Self Identification) form is not displayed",
					"blue");
			WebActionUtil.doubleClickOnElementCheckbox(cbIHaveReadAndUnderstoood,
					"I have read and understood check box");
			WebActionUtil.waitForElement(btnSubmit1, "Submit button");
			if (btnSubmit1.isEnabled()) {
				WebActionUtil.clickOnElement(btnSubmit1, "Submit button", "Unable to click Submit button");
			}
			WebActionUtil.waitForAngularPageToLoad();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(
					"Unable to perform action on Voluntary Self-Identification (Gender And Race Self Identification) form");
			Assert.fail(
					"Unable to perform action on Voluntary Self-Identification (Gender And Race Self Identification) form");
		}
	}

	/**
	 * Description Method to validate Voluntary Self-Identification (Covered
	 * Protected Veterans) form is displayed & click on I have read and understood
	 * check box & click on Submit button
	 * 
	 * @author Sajal jain
	 * @param expectedFormHeader
	 */
	public synchronized void clkSubmit2Btn(String expectedFormHeader) {
		try {
			WebActionUtil.validatePartialText(expectedFormHeader, txtCoveredProtectedVeterans,
					"Voluntary Self-Identification Form(Covered Protected Veterans) text",
					"Voluntary Self-Identification (Covered Protected Veterans) form is displayed",
					"Voluntary Self-Identification (Covered Protected Veterans) form is not displayed", "blue");
			WebActionUtil.doubleClickOnElementCheckbox(cbIHaveReadUnderstood, "I have read and understood check box");
			WebActionUtil.waitForElement(btnSubmit2, "Submit button");
			if (btnSubmit2.isEnabled()) {
				WebActionUtil.clickOnElement(btnSubmit2, "Submit button", "Unable to click Submit button");
			}
			WebActionUtil.waitForAngularPageToLoad();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(
					"Unable to perform action on Voluntary Self-Identification (Covered Protected Veterans) form");
			Assert.fail("Unable to perform action on Voluntary Self-Identification (Covered Protected Veterans) form");
		}
	}

	/**
	 * Description Method to validate Voluntary Self Identification Of Disability
	 * form is displayed & click on Submit button
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkSubmitBtn() {
		try {
			WebActionUtil.validateisElementDisplayed(txtVoluntarySelfIdentificationOfDisability,
					"Voluntary Self Identification Of Disability text",
					"Voluntary Self Identification Of Disability form is displayed",
					"Voluntary Self Identification Of Disability form is not displayed", "blue");
			WebActionUtil.waitForElement(btnSubmit, "Submit button");
			if (btnSubmit.isEnabled()) {
				WebActionUtil.clickOnElement(btnSubmit, "Submit button", "Unable to click Submit button");
			}
			WebActionUtil.waitForAngularPageToLoad();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Voluntary Self Identification Of Disability form");
			Assert.fail("Unable to perform action on Voluntary Self Identification Of Disability form");
		}
	}

	/**
	 * Description Method to click on Preview icon
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkPreviewIcn() {
		try {
			WebActionUtil.waitForElement(icnPreview, "Preview icon");
			WebActionUtil.clickOnElement(icnPreview, "Preview icon", "Unable to click Preview icon");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Preview icon");
			Assert.fail("Unable to click Preview icon");
		}
	}

	/**
	 * Description Method to click on Voluntary Self Identification/Employee
	 * Handbook-HCLA/Export Compliance Policy/Policy And Procedures/Sexual
	 * Harassment Policy/Employment Agreement/CFIUS Security Policies Read icon &
	 * validate PDF is displayed
	 * 
	 * @author Sajal jain
	 * @param documentType
	 */
	public synchronized void validatePdf(String documentType) {
		try {
			clkDocumentReadIcn(documentType);
			WebActionUtil.switchToNewTab();
			String currentUrl = WebActionUtil.driver.getCurrentUrl();
			String currentUrlLowerCase = currentUrl.toLowerCase();
			if (currentUrlLowerCase.endsWith(".pdf")) {
				WebActionUtil.info(documentType + " PDF is displayed");
				WebActionUtil.validationinfo(documentType + " PDF is displayed", "blue");
			} else {
				WebActionUtil.error(documentType + " PDF is not displayed");
				WebActionUtil.fail(documentType + " PDF is not displayed");
			}
			WebActionUtil.driver.close();
			WebActionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on " + documentType + " read icon");
			Assert.fail("Unable to perform action on " + documentType + " read icon");
		}
	}

	/**
	 * Description Method to click on Final Submit button
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkFinalSubmitBtn() {
		try {
			WebActionUtil.scrollToElement(btnFinalSubmit, "Final Submit button");
			WebActionUtil.waitForElement(btnFinalSubmit, "Final Submit button");
			WebActionUtil.clickOnElement(btnFinalSubmit, "Final Submit button", "Unable to click Final Submit button");
			WebActionUtil.waitForInvisibilityOfElement(spinner, "Spinner", 180l);
			WebActionUtil.validateisElementDisplayed(txtJoiningFormHasBeenSubmittedSuccessfully,
					"Joining Form has been submitted successfully confirmation message text",
					"Joining Form has been submitted successfully confirmation message is displayed",
					"Joining Form has been submitted successfully confirmation message is not displayed", "green");
			if (spinner.isDisplayed()) {
				WebActionUtil.waitForInvisibilityOfElement(spinner, "Spinner", 60l);
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Final Submit button");
			Assert.fail("Unable to click Final Submit button");
		}
	}

	/**
	 * Description Method to validate Personal, Additional, Educational, Employment
	 * Tick Icon is disabled
	 * 
	 * @author Sajal jain
	 */
	public synchronized void validateTickIcn() {
		try {
			boolean flag = false;
			for (WebElement wb : icnTick) {
				String classAttributeValue = wb.getAttribute("class");
				if (!classAttributeValue.contains("disabledbutton")) {
					flag = true;
					break;
				}
			}
			if (flag) {
				WebActionUtil.fail("Personal, Additional, Educational, Employment tick icon enabled");
				Assert.fail("Personal, Additional, Educational, Employment tick icon enabled");
			} else {
				WebActionUtil.info("Personal, Additional, Educational, Employment tick icon disabled");
				WebActionUtil.validationinfo("Personal, Additional, Educational, Employment tick icon disabled",
						"blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate tick icon");
			Assert.fail("Unable to validate tick icon");
		}
	}

	/**
	 * Description Method to validate Form is not editable
	 * 
	 * @author Sajal jain
	 */
	public synchronized void validateFormEditable() {
		try {
			boolean flag = false;
			for (WebElement wb : icnEdit) {
				String styleAttributeValue = wb.getAttribute("style");
				if (!styleAttributeValue.contains("display: none")) {
					flag = true;
					break;
				}
			}
			if (flag) {
				WebActionUtil.error("Form is editable");
				Assert.fail("Form is editable");
			} else {
				WebActionUtil.info("Form is not editable");
				WebActionUtil.validationinfo("Form is not editable", "blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate form edit icon");
			Assert.fail("Unable to validate form edit icon");
		}
	}

	/**
	 * Description: Method to validate Preview page is displayed
	 * 
	 * @author Sajal jain
	 * @param expectedUrl
	 */
	public synchronized void validatePreviewPage(String expectedUrl) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = driver.getCurrentUrl();
			if (actualUrl.equals(expectedUrl)) {
				WebActionUtil.info("Preview page is displayed, url= " + actualUrl);
				WebActionUtil.validationinfo("Preview page is displayed, url= " + actualUrl, "blue");
			} else {
				WebActionUtil.fail("Preview page is not displayed, Url not matching, Expected= " + expectedUrl
						+ ", Actual= " + actualUrl);
				WebActionUtil.error("Preview page is not displayed, Url not matching, Expected= " + expectedUrl
						+ ", Actual= " + actualUrl);
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Preview Page is displayed");
			Assert.fail("Unable to validate Preview Page is displayed");
		}
	}

	/**
	 * Description: Method to validate first name,last name, gender present in
	 * Voluntary Self-Identification (Gender And Race Self Identification) form is
	 * same as data present in joining form page
	 * 
	 * @author Sajal jain
	 * @param expectedList
	 */
	public synchronized void validateDataInForm(ArrayList<String> expectedList) {
		try {
			WebActionUtil.waitForAngularPageToLoad();
			ArrayList<String> actualList = new ArrayList<>();
			String actualFirstName = txtFirstName.getAttribute("value");
			actualList.add(actualFirstName);
			String actualLastName = txtLastName.getAttribute("value");
			actualList.add(actualLastName);
			String actualGender = txtGender.getText();
			actualList.add(actualGender);
			if (actualList.equals(expectedList)) {
				WebActionUtil.info("First Name : " + actualFirstName + ", Last Name : " + actualLastName + ", Gender : "
						+ actualGender
						+ " in Voluntary Self-Identification (Gender And Race Self Identification) form are same as Joining Form page data");
				WebActionUtil.validationinfo("First Name : " + actualFirstName + ", Last Name : " + actualLastName
						+ ", Gender : " + actualGender
						+ " in Voluntary Self-Identification (Gender And Race Self Identification) form are same as Joining Form page data",
						"blue");
			} else {
				WebActionUtil.fail(
						"Data in Voluntary Self-Identification (Gender And Race Self Identification) form and Joining Form page is not same");
				WebActionUtil.error(
						"Data in Voluntary Self-Identification (Gender And Race Self Identification) form and Joining Form page is not same");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(
					"Unable to validate data in Voluntary Self-Identification (Gender And Race Self Identification) form");
			Assert.fail(
					"Unable to validate data in Voluntary Self-Identification (Gender And Race Self Identification) form");
		}
	}

}