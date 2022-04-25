package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for Employment Details page
 * 
 * @author Vivek Dogra
 */
public class EmploymentDetails_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public EmploymentDetails_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Employment head text */
	@FindBy(xpath = "//h4[@class='panel-title' and text()='Employment Details ']")
	private WebElement txtEmployment;

	/* Fresher Radio Button */
	@FindBy(xpath = "//input[@name='EmpRad' and @value='Fresher']/following-sibling::label/preceding-sibling::input")
	private WebElement rbFresher;

	/* Experienced Radio Button */
	@FindBy(xpath = "//input[@name='EmpRad' and @value='Experienced']/following-sibling::label/preceding-sibling::input")
	private WebElement rbExperienced;

	/* My Current Company Check Box */
	@FindBy(xpath = "//label[text()='This is my current Company']")
	private WebElement cbMyCurrentCompany;

	/* Employee Text Box */
	@FindBy(xpath = "//label[@class='control-label' and text()='Employer']/following-sibling::input[@type='text']")
	private WebElement tbEmployee;

	/* Employee Text */
	@FindBy(xpath = "//label[@class='control-label' and text()='Employer']")
	private WebElement txtEmployee;

	/* Industry Drop down */
	@FindBy(xpath = "//label[@class='control-label staticLable' and text()='Industry']/following-sibling::div[@class='btn-group bootstrap-select form-control']/button/span[text()='Select']")
	private WebElement ddIndustry;

	/*Industry text*/
	@FindBy(xpath="//label[text()='Industry']/parent::div/div/button[@type='button']/span[1]")
	private WebElement txtIndustry;
	
	/* Industry text box */
	@FindBy(xpath = "(//div[@class='bs-searchbox']/input[@type='text'])[1]")
	private WebElement tbIndustry;
	
	/*Industry Options*/
	@FindBys(@FindBy(xpath="//label[text()='Industry']/parent::div//div[@role='combobox']//ul/li"))
	private List<WebElement> otnIndustry;

	/* Country Drop down */
	@FindBy(xpath = "//label[@class='control-label staticLable' and text()='Country']/following-sibling::div[@class='btn-group bootstrap-select form-control']/button/span[text()='Select']")
	private WebElement ddCountry;

	/* Country text box */
	@FindBy(xpath = "(//div[@class='bs-searchbox']/input[@type='text'])[2]")
	private WebElement tbCountry;
	
	/*Country Options*/
	@FindBys(@FindBy(xpath="//label[text()='Country']/parent::div//div[@role='combobox']//ul/li/a/span[@class='text']"))
	private List<WebElement> otnCountry;

	

	/* City Text Box */
	@FindBy(xpath = "//label[@class='control-label' and text()='City']/following-sibling::input[@type='text']")
	private WebElement tbCity;

	/* City Text */
	@FindBy(xpath = "//label[@class='control-label' and text()='City']")
	private WebElement txtCity;

	/* Designation on Joining Text Box */
	@FindBy(xpath = "//label[@class='control-label' and text()='Designation on Joining']/following-sibling::input[@type='text']")
	private WebElement tbDesignationOnJoining;

	/* Designation at Present/Exit Joining Text Box */
	@FindBy(xpath = "//label[@class='control-label' and text()='Designation at Present/Exit']/following-sibling::input[@type='text']")
	private WebElement tbDesignationatPresentExit;

	/* From date */
	String txtfromdate = "//label[@class='control-label' and text()='From']";
	String inputfromdate = "//label[@class='control-label' and text()='From']/following-sibling::input[@type='text']";

	/* To date */
	String txttodate = "//label[@class='control-label' and text()='To']";
	String inputtodate = "//label[@class='control-label' and text()='To']/following-sibling::input[@type='text']";

	/* Add Details Button */
	@FindBy(xpath = "//span[contains(text(),'Add Detail')]")
	private WebElement btnAddDetails;

	/* Continue Button */
	@FindBy(id = "ContinueButton")
	private WebElement btnContinue;

	/* Save As Draft Button */
	@FindBy(xpath = "//input[@type='submit' and @value='Save As Draft']")
	private WebElement btnSaveAsDraft;

	/* Details Text */
	@FindBy(xpath = "//th[text()='Employer']/parent::tr/following-sibling::tr[1]/td")
	private List<WebElement> txtEmpoyemtDetails1;

	/* Details Text */
	@FindBy(xpath = "//th[text()='Employer']/parent::tr/following-sibling::tr[1]/td")
	private List<WebElement> txtEmpoyemtDetails2;

	/**
	 * Description: Method to validate Employment Detail page displayed
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void valdidateEmploymentDetailsHeadText() {
		
		WebActionUtil.waitForAngularPageToLoad();
		try {
			WebActionUtil.waitForElement(txtEmployment, "Employment Details text");
			WebActionUtil.isElementVisible(txtEmployment, "Employment Details text");
			WebActionUtil.info("Employment Details page is displayed");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Employment Details page is not displayed");
			Assert.fail("Employment Details page is not displayed");
		}
	}

	/**
	 * Description: Method click on Fresher Radio Button
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void clickFresherRadioButton() {
		try {
			WebActionUtil.waitForElement(rbFresher, "Fresher radio button");
		//	WebActionUtil.clickOnElement(rbFresher, "Fresher radio button", "Unable to click on Fresher radio button");
WebActionUtil.clickCheckBoxUsingJS(rbFresher, "Fresher radio button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Fresher radio button");
			Assert.fail("Unable to click on Fresher radio button");
		}
	}

	/**
	 * Description: Method click on Experienced Radio Button
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void clickExperiencedRadioButton() {
		try {
			WebActionUtil.waitForElement(rbExperienced, "Experienced radio button");
//			WebActionUtil.clickOnElement(rbExperienced, "Experienced radio button",
//					"Unable to click on Experienced radio button");
			WebActionUtil.clickCheckBoxUsingJS(rbExperienced, "Experienced radio button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Experienced radio button");
			Assert.fail("Unable to click on Experienced radio button");
		}
	}

	/**
	 * Description: Method click on My Current Company Check Box
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void clickcMyCurrentCompanyCheckBox() {
		try {
			WebActionUtil.waitForElement(cbMyCurrentCompany, "My Current Company check box");
			WebActionUtil.clickOnElement(cbMyCurrentCompany, "My Current Company check box",
					"Unable to click on My Current Company check box");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on My Current Company check box");
			Assert.fail("Unable to click on My Current Company check box");
		}
	}

	/**
	 * Description: Method to set the Employee Name in Employee text box
	 * 
	 * @author Vivek Dogra
	 * @param empname
	 */
	public synchronized void settypeOfEmployee(String empname) {
		try {
			WebActionUtil.waitForElement(tbEmployee, "Employee type text box");
			WebActionUtil.clickOnElement(tbEmployee, "Employee type text box", "Unable to click on Employee type text Box");
			WebActionUtil.typeText(tbEmployee, empname, "Employee type text box");
			String expectedempname = empname.toLowerCase();
			String employeeActualtext = WebActionUtil.getTextUsingJS("L077").toLowerCase();
			WebActionUtil.comparetText(employeeActualtext, expectedempname, "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the Employee Name");
			Assert.fail("Unable to set the Employee Name");
		}
	}
	
	
	/**
	 * Description: Method to set the Industry Name in Employee text box
	 * 
	 * @author Vivek Dogra
	 * @param industry
	 */
	public synchronized void settypeOfindustry(String industry) {
		try {
			WebActionUtil.waitForElement(ddIndustry, "Industry type text box");
			WebActionUtil.clickOnElement(ddIndustry, "Industry type text box", "Unable to click on Industry type text box");
			WebActionUtil.typeText(tbIndustry, industry, "Industry type text box");
			
			for(WebElement industryOptions:otnIndustry)
			{
				String industrysOption = industryOptions.getText();

				if(industry.contentEquals(industrysOption))
				{
					WebActionUtil.clickOnElement(industryOptions, "State Option", "Clicked on "+industry+"");
					WebActionUtil.pass("Selected "+industry+" from State Dropdown");
					
				}
			}    


		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the industry Name");
			Assert.fail("Unable to set the industry Name");
		}
	}
	
	
	/**
	 * Description: Method to set the Country Name in Employee text box
	 * 
	 * @author Vivek Dogra
	 * @param country
	 */
	public synchronized void settypeOfcountry(String country) {
		try {
			WebActionUtil.waitForElement(ddCountry, "country type text box");
			WebActionUtil.clickOnElement(ddCountry, "country type text box", "Unable to click on country type text box");
			WebActionUtil.typeText(tbCountry, country, "country type text box");

			for(WebElement countryOptions:otnCountry)
			{
				String countrysOption = countryOptions.getText();

				if(country.contentEquals(countrysOption))
				{
					WebActionUtil.clickOnElement(countryOptions, "State Option", "Clicked on "+country+"");
					WebActionUtil.pass("Selected "+country+" from State Dropdown");
					
				}
			}    
			String countryActualtext = WebActionUtil.getTextUsingJS("L079");
			WebActionUtil.comparetText(countryActualtext, country, "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the country Name");
			Assert.fail("Unable to set the country Name");
		}
	}
	

	/**
	 * Description: Method to set the City Name in City text box
	 * 
	 * @author Vivek Dogra
	 * @param cityname
	 */
	public synchronized void settypeOfCity(String cityname) {
		try {
			WebActionUtil.waitForElement(tbCity, "City type text box");
			WebActionUtil.clickOnElement(tbCity, "City type text box", "Unable to click on City text box");
			WebActionUtil.typeText(tbCity, cityname, "City type text box");
			String expectedcityname = cityname.toLowerCase();
			String actualcityname = WebActionUtil.getTextUsingJS("L080").toLowerCase();
			WebActionUtil.comparetText(actualcityname, expectedcityname, "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the City Name");
			Assert.fail("Unable to set the City Name");
		}
	}

	/**
	 * Description: Method to set the Designation On Joining
	 * 
	 * @author Vivek Dogra
	 * @param designationJ
	 */
	public synchronized void settypeOfDesignationOnJoining(String designationJ) {
		try {
			WebActionUtil.waitForElement(tbDesignationOnJoining, "Designation On Joining type text box");
			WebActionUtil.clickOnElement(tbDesignationOnJoining, "Designation On Joining type text box",
					"Unable to click on Designation On Joining text box");
			WebActionUtil.typeText(tbDesignationOnJoining, designationJ, "Designation On Joining type text box");
			String expecteddesignationname = designationJ.toLowerCase();
			String actualdesignationJname = WebActionUtil.getTextUsingJS("L081").toLowerCase();
			WebActionUtil.comparetText(actualdesignationJname, expecteddesignationname, "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the Designation On Joining ");
			Assert.fail("Unable to set the Designation On Joining ");
		}
	}

	/**
	 * Description: Method to set the Designation at Present Exit
	 * 
	 * @author Vivek Dogra
	 * @param designationP
	 */
	public synchronized void settypeOfDesignationatPresentExit(String designationP) {
		try {
			WebActionUtil.waitForElement(tbDesignationatPresentExit, "Designation at Present Exit type text box");
			WebActionUtil.clickOnElement(tbDesignationatPresentExit, "Designation at Present Exit type text box",
					"Unable to click on Designation at Present Exit Text Box");
			WebActionUtil.typeText(tbDesignationatPresentExit, designationP,
					"Designation at Present Exit type text box");
			String expecteddesignationname = designationP.toLowerCase();
			String actualdesignationJname = WebActionUtil.getTextUsingJS("L082").toLowerCase();
			WebActionUtil.comparetText(actualdesignationJname, expecteddesignationname, "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the Designation at Present Exit ");
			Assert.fail("Unable to set the Designation at Present Exit");
		}

	}

	/**
	 * Description: Method to set From Date
	 * 
	 * @author Vivek Dogra
	 * @param fromdate
	 */
	public synchronized void setFromdate(String fromdate) {
		try {
			String fromDateId = "L083";
			WebActionUtil.selectCalendarDate(fromDateId, fromdate, "From Date");

			if(WebActionUtil.getTextUsingJS("L083").equals(fromdate))
			{
				WebActionUtil.validationinfo("From Date selected is "+fromdate+" ", "blue");
			}
			else 
			{
				throw new Exception();
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the From date ");
			Assert.fail("Unable to set the From date");
		}

	}

	/**
	 * Description: Method to set To Date
	 * 
	 * @author Vivek Dogra
	 * @param todate
	 */
	public synchronized void setTodate(String todate) {
		try {

			String toDateId = "L084";
			WebActionUtil.selectCalendarDate(toDateId, todate, "To Date");

			if(WebActionUtil.getTextUsingJS("L084").equals(todate))
			{
				WebActionUtil.validationinfo("To Date selected is "+todate+" ", "blue");
			}
			else 
			{
				throw new Exception();
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set the TO date ");
			Assert.fail("Unable to set the To date");
		}

	}

	/**
	 * Description: Method click on Add Details Button
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void clickAddDetailsBtn() {
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
	 * @author Vivek Dogra
	 */
	public synchronized void clickContinueBtn() {
		try {
			WebActionUtil.waitForElement(btnContinue, "Continue button");
			WebActionUtil.clickOnElement(btnContinue, "Continue button", "Unable to click on Continue button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Continue button");
			Assert.fail("Unable to click on Continue button");
		}
	}

	/**
	 * Description: Method click on SaveAsDraft Button
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void clickSaveAsDraftBtn() {
		try {
			WebActionUtil.waitForElement(btnSaveAsDraft, "SaveAsDraft button");
			WebActionUtil.clickOnElement(btnSaveAsDraft, "SaveAsDraft button", "Unable to click on SaveAsDraft button");
			WebActionUtil.waitForAngularPageToLoad();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on SaveAsDraft button");
			Assert.fail("Unable to click on SaveAsDraft button");
		}
	}

	/**
	 * Description: Method to Validate Employment From is cleared
	 * 
	 * @author Vivek Dogra
	 */
	public synchronized void employementdetialsformcleard() {
		try {
			String expectedEmploye = WebActionUtil.getTextUsingJS("L077");
			String expectedindustry = WebActionUtil.getTextUsingJS("L078");
			String expectedcountry = WebActionUtil.getTextUsingJS("L079");
			String expectedcity = WebActionUtil.getTextUsingJS("L080");
			String expectedDesignationj = WebActionUtil.getTextUsingJS("L081");
			String expectedDesignationp = WebActionUtil.getTextUsingJS("L082");
			String expectedfromdate = WebActionUtil.getTextUsingJS("L083");
			String expectedtodate = WebActionUtil.getTextUsingJS("L084");
			WebActionUtil.validateEnteredValue(expectedEmploye, "", "Employee text box",
					"Employee text feild is cleared", "Employee text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedindustry, "", "Industry text box",
					"Industry text feild is cleared", "Industry text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedcountry, "", "Country text box", "Country text feild is cleared",
					"Country text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedcity, "", "City text box", "City text feild is cleared",
					"City text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedDesignationj, "", "Designation on Joining text box",
					"Designation on Joining text feild is cleared", "Designation on Joining text feild is not cleared",
					"blue");
			WebActionUtil.validateEnteredValue(expectedDesignationp, "", "Designation at Present/Exit text box",
					"Designation at Present/Exit text feild is cleared",
					"Designation at Present/Exit text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedfromdate, "", "From date text box",
					"From date text feild is cleared", "From date text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedfromdate, "", "From date text box",
					"From date text feild is cleared", "From date text feild is not cleared", "blue");
			WebActionUtil.validateEnteredValue(expectedtodate, "", "To date text box", "To date text feild is cleared",
					"To date text feild is not cleared", "blue");
			WebActionUtil.info("Employement detials form is  Reset");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Employement detials form is not Reset");
			Assert.fail("Employement detials form is not Reset");
		}
	}

	/**
	 * Description Method to validate the Employee details table first row
	 * 
	 * @author Vivek Dogra
	 * @param arr
	 * 
	 */

	public synchronized void validateEmployeeDetailsstable1(ArrayList arr) {
		try {
			
			ArrayList<String> alldetails =new ArrayList<String>();
			
			for (int i=0;i<txtEmpoyemtDetails1.size();i++) {
				try {
					alldetails.add(txtEmpoyemtDetails1.get(i).getText());
				} catch (Exception e) {
					continue;
				}
			}
			if(txtEmpoyemtDetails1.size()<4) {
			Assert.assertEquals(arr, alldetails);
			}
			WebActionUtil.info("Employment details in the table is matched");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Employment  details in the table");
			Assert.fail("Unable to validate Employment Qualifications details in the table");
		}
	}



/**
 * Description Method to validate the Employee details table second row
 * 
 * @author Vivek Dogra
 * @param arr
 * 
 */

public synchronized void validateEmployeeDetailsstable2(ArrayList arr) {
	try {
		ArrayList<String> alldetails =new ArrayList<String>();
		
		for (int i=0;i<txtEmpoyemtDetails2.size();i++) {
			try {
				alldetails.add(txtEmpoyemtDetails2.get(i).getText());
			} catch (Exception e) {
				continue;
			}
		}
		if(txtEmpoyemtDetails2.size()<4) {
		Assert.assertEquals(arr, alldetails);
		}
		WebActionUtil.info("Employment details in the table is matched");

	} catch (Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.fail("Unable to validate Employment  details in the table");
		Assert.fail("Unable to validate Employment Qualifications details in the table");
	}
}

}
