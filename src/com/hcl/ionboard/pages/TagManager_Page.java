
package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Description: This class implements the methods for Tag Manager page
 * @author Suganthini
 *
 */
public class TagManager_Page {
	public WebDriver driver;
	public com.hcl.ionboard.util.WebActionUtil WebActionUtil;
	public long ETO = 10;

	public TagManager_Page(WebDriver driver, long ETO, com.hcl.ionboard.util.WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	/* Type Search Name Text Box */
	@FindBy(xpath = "//input[@placeholder='Search by Name / SAP Code']")
	private WebElement tbSearchName;

	/* Profile Drop Down */
	@FindBy(xpath = "//div[@class='glb-pnl-informationDropIcon']")
	private WebElement ddProfile;
	
	/* Roles */
	@FindBy(xpath = "//ul[@class='glb-pnl-role-list']/li/a")
	private List<WebElement> txtRoles;
	
	/*Did Candidate Join Drop Down */
	@FindBy(xpath = "//label[text()='Did Candidate Join']/parent::div/descendant::span[@class='filter-option pull-left']")
	private WebElement ddDidCandidateJoin;
	
	/* Select Yes */
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement otnYes;
	
	/* Yes and No Menu */
	@FindBy(xpath ="//label[text()='Did Candidate Join']/parent::div/descendant::ul/descendant::span[@class='text']")
	private List<WebElement> txtMenu;
	
	/* Table Header */
	@FindBy(xpath = "//table[@id='first_table']/descendant::th[contains(@class,'sorting')]")
	private List<WebElement> tlHeader;
		
	/* Confirm Message */
	@FindBy(xpath = "//div[contains(text(),'I Confirm that I have spoken to candidate and updating as candidate joined for ID creation with DOJ Shown')]")
	private WebElement txtConfirmMesg;
	
	/* Submit Button */
	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnSubmit;
	
	/* Search Text Box */
	@FindBy(xpath="//input[@type='search']")
	private WebElement tbSearch;
	
	/* Export to Excel Icon */
	@FindBy(xpath="//span[@class='icon-excel excel_icon']")
	private WebElement icnExportToExcel;
	
	/* Search Data */
	@FindBy(xpath="//tr[@class='odd']")
	private WebElement searchData;
	
	/* Search Button */
	@FindBy(xpath="//span[contains(@class,'icon-search')]")
	private WebElement btnSearch;
	
	/* Submit Success Message */
	@FindBy(xpath="//span[text()='Your request has been submitted successfully.']")
	private WebElement txtSuccessMessage;
	
	/* Cancel Button */
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btnCancel;
	
	/* Select Role */
	private WebElement selectRole(String var) {
		String xpath = "//a[text()='" + var + "']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/*Mail Icon*/
		private WebElement icnMail(String var) {
		String xpath="//td/a[normalize-space(text())='"+var+"']/parent::td/following-sibling::td/descendant::i[@class='icon-mail']";
		return driver.findElement(By.xpath(xpath));
	}
		
	/*Mail Text*/
	private WebElement textMail(String var) {
		String xpath="//td/a[normalize-space(text())='"+var+"']/parent::td/following-sibling::td/descendant::i[@class='icon-mail']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}
	
	/* Select Role */
	private WebElement icnAction(String var) {
		String xpath="//td/a[normalize-space(text())='"+var+"']/parent::td/following-sibling::td/descendant::i[contains(@class,'icon-edit')]";
		return driver.findElement(By.xpath(xpath));
	}
		

	/**
	 * Description: Method to validate Fields
	 * @author Suganthini
	 * @param expectedRole
	 */	
	public synchronized void validateFields(String expectedRole)
	{
		try {
					
			WebActionUtil.poll(5000);
			validateSelectedRole(expectedRole);
			List<String> actualFields = new ArrayList<String>();
			WebActionUtil.poll(50);
			for(WebElement value : tlHeader)
			{
				actualFields.add(value.getText());
			}
			
			List<String> expectedFields = new ArrayList<String>();
			expectedFields.add("Candidate ID/\n"+"SAP ID");
			expectedFields.add("Candidate Name");
			expectedFields.add("Record Triggered");
			expectedFields.add("DOJ");
			expectedFields.add("Employee Type");
			expectedFields.add("GEO Location");
			expectedFields.add("JF");
			expectedFields.add("BGV");
			expectedFields.add("I-9\n" + 
					"Status");
			expectedFields.add("SAP ID\n" + 
					"Creation");
			expectedFields.add("Mail");
			expectedFields.add("Action");
			
			
			Assert.assertEquals(expectedFields, actualFields);
			WebActionUtil.pass("All the fields are displayed");
			

		} catch (Exception e) {
			WebActionUtil.fail("The fields are not displayed");
			Assert.fail("The fields are not displayed");
		}
	}
	
	/**
	 * Description: Method to validate Joining Form status
	 * @author Suganthini
	 * @param candidateName
	 */
	public synchronized void validateJoiningFormStatus(String candidateName)
	{
		try {
			
			WebElement JF = driver.findElement(By.xpath("//table[@id='first_table']/descendant::td/a[normalize-space(text())='"+candidateName+"']/parent::td/following-sibling::td/i"));
//			new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOf(JF));
//			WebActionUtil.scrollToElement(JF, "Joing Form Button");
			EventFiringWebDriver event=new EventFiringWebDriver(driver);
			event.executeScript("window.scrollBy(0,500)");
			Assert.assertEquals(JF.getAttribute("class"), "indicate ind-green");
			WebActionUtil.pass("Colour of Joining Form Status: Green colour is displayed");
			
			WebActionUtil.actionMouseOver(JF, "Joining Form Status");
			
			Assert.assertEquals(JF.getAttribute("data-original-title"), "Completed");
			WebActionUtil.pass("Joining Form Status: "+ JF.getAttribute("data-original-title") +" is displayed");
			
			
		} catch (Exception e) {
			WebActionUtil.fail("Joining Form Status: Green colour is not displayed");
			Assert.fail("Joining Form Status: Green colour is not displayed");
		}
	}
	
	/**
	 * Description: Method to Click on mail icon
	 * @author Suganthini
	 * @param candidateName
	 */
	public synchronized void clkMailIcon(String candidateName) {
		try {
//			EventFiringWebDriver event=new EventFiringWebDriver(driver);
//			event.executeScript("window.scrollBy(0,500)");
		
			WebActionUtil.waitForElement(icnMail(candidateName), "Mail Icon Status");
			WebActionUtil.actionMouseOver(icnMail(candidateName), "Mail Icon Status");
			WebActionUtil.poll(1000);
			
			Assert.assertEquals(textMail(candidateName).getAttribute("data-original-title"), "Re-trigger Candidate Welcome mail");
			WebActionUtil.pass("MailIconStatus Status: "+ textMail(candidateName).getAttribute("data-original-title") +" is displayed");
			
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Mail Icon");
			Assert.fail("Unable to click on Mail Icon");
		}
	}
	
	
	
	/**
	 * Description: Method to click on search box
	 * @author Suganthini
	 * @param CandidateName
	 */
	public synchronized void clkSearchBar(String candidateName) {
		try {
			
			WebActionUtil.waitForElement(tbSearch, "Search Name text box");
			WebActionUtil.typeText(tbSearch, candidateName, "Search Name text box");
			WebActionUtil.validateAttribute(tbSearch, "value", candidateName, "Payment Type text box",
					candidateName + " Entered in Search text box",
					candidateName + " not entered in Search text box", "blue");
			WebActionUtil.waitForElement(btnSearch, "Searchbar button");
			WebActionUtil.clickOnElement(btnSearch, "Searchbar button", "Unable to click on Search button");
			WebActionUtil.validateisElementDisplayed(searchData, "Search data", "Candidate information is displayed", "Candidate information is not displayed", "blue");
			
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Search button");
			Assert.fail("Unable to click on Search button");
		}
	}
	/**
	 * Description: Method to download Expert to excel
	 * @author Suganthini 
	 */
	public synchronized void clkExpertToExcel() 
	{
		try
		{
		String fileExtension=".xls";
		
		WebActionUtil.clickOnElement(icnExportToExcel, "Expert to Excel Icon",
				"Unable to click on Expert to Excel Icon");
		String userDir = System.getProperty("user.home");
		String downloadedDocumentName = WebActionUtil.getDownloadedDocumentName(userDir + "/Downloads",
				fileExtension);
		Assert.assertTrue(downloadedDocumentName.contains(fileExtension));
		WebActionUtil.info(downloadedDocumentName + " File Succesfully Downloaded");
		WebActionUtil.validationinfo(downloadedDocumentName + " File Succesfully Downloaded", "blue");
		}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Expert to Excel Icon ");
			Assert.fail("Unable to click on Expert to Excel Icon");
		}
	}
	
	/**
	 * Description: Method to Click on action Icon
	 * @author Suganthini
	 * @param candidateName
	 */
	public synchronized void clkActionIcon(String candidateName) {
		try {
			WebActionUtil.scrollToElement(icnAction(candidateName), "Action ICon");
			WebActionUtil.waitForElement(icnAction(candidateName), "Action Icon");
			WebActionUtil.clickOnElement(icnAction(candidateName),"Action Icon","Unable to click on Action Icon");
			validateCandidatePhysicalConfirmationPage();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Action Icon");
			Assert.fail("Unable to click on Action Icon");
		}
	}
	
	/**
	 * Description  Method validate candidate physical Confirmation page
	 * @author Suganthini
	 */
	private synchronized void validateCandidatePhysicalConfirmationPage(){
					try {
				
				String expectedPhysicalConfirmationUrl="https://staging3.myhcl.com/iOnboardRoles/Employer/Recruiter/CallDetail";
				
				String actualCandidatePhysicalConfirmationText = driver.findElement(By.xpath("//li[text()='Candidate Physical Confirmation']")).getText();
				String actualUrl =driver.getCurrentUrl();
			   
			    if(actualUrl.equals(expectedPhysicalConfirmationUrl))
			    {
			    	WebActionUtil.info("Candidate Physical Confirmation page is displayed, url ="+driver.getCurrentUrl());
			    	WebActionUtil.validationinfo("Candidate Physical Confirmation page is displayed, url ="+driver.getCurrentUrl(),"blue");
			    }
			    else
			    {
			    	if(!expectedPhysicalConfirmationUrl.equals(actualUrl))
			    	{
			    	    WebActionUtil.validationinfo("Url is not matching,Expected=" +expectedPhysicalConfirmationUrl+",Actual="+actualUrl,"red");
			    	WebActionUtil.error("Url is not matching,Expected=" +expectedPhysicalConfirmationUrl+",Actual="+actualUrl);
			    	}
			    }
			}
			   
			 catch (Exception e) {
				WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to validate Candidate Physical Confirmation Page");
				Assert.fail("Unable to validate Candidate Physical Confirmation Page");
			}
			
		
	}
	
	/**
	 * Description: Method to Click on Did candidate join drop down
	 * @author Suganthini
	 */
	public synchronized void clkDidCandidateJoin() {
		try {
		
			WebActionUtil.waitForElement(ddDidCandidateJoin, "Did candidate Join drop down");
			WebActionUtil.clickOnElement(ddDidCandidateJoin,"Did candidate Join drop down","Unable to click on Did candidate Join drop down");
			validateDidCandidateJoinDropDown();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Did candidate Join drop down");
			Assert.fail("Unable to click on Did candidate Join drop down");
		}
	}
	
	/**
	 * Description: Method to select Yes
	 * @author Suganthini
	 */
	public synchronized void selectYesDd() {
		try {
			WebActionUtil.clickOnElement(otnYes,"Yes option","Unable to click on Yes option");
			WebActionUtil.validatetext("Yes",ddDidCandidateJoin , "Yes option", "Yes option is selected", "Yes option is not selected", "blue");
			WebActionUtil.validatetext("I Confirm that I have spoken to candidate and updating as candidate joined for ID creation with DOJ Shown", txtConfirmMesg, "Confirm message", "I Confirm that I have spoken to candidate and updating as candidate joined for ID creation with DOJ Shown message is Display", "confirm message is not display", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Yes option");
			Assert.fail("Unable to click on Yes option");
		}
	}
	/**
	 * Description: Method to validate the yes or No Drop down
	 * @author Suganthini
	 */
	private synchronized void validateDidCandidateJoinDropDown() {
		try {
			List<String> actualMenu = new ArrayList<String>();
			for(WebElement Menu : txtMenu)
			{
				actualMenu.add(Menu.getText());
			}
			
			List<String> expectedMenu = new ArrayList<String>();
			expectedMenu.add("Yes");
			expectedMenu.add("No");
			
			Assert.assertEquals(expectedMenu, actualMenu);
			WebActionUtil.info("Drop down is displayed with YES or NO option");
			WebActionUtil.pass("Drop down is displayed with YES or NO option");
		} catch (Exception e) {
			WebActionUtil.fail("Drop down is not displayed");
			Assert.fail("Drop down is not displayed");
		}
	}
	
	/**
	 * Description: Method to validate the yes option selected
	 * @author Suganthini
	 */	
	public synchronized void validateYesOptionSelected()
	{
	String selectedOption=ddDidCandidateJoin.getText();
	if(selectedOption.equals("Yes"))
	{
		WebActionUtil.info("Yes option is selected");
		WebActionUtil.validationinfo("Yes option is selected", "blue");
	}
	else
	{
		WebActionUtil.info("Yes option is not selected");
		WebActionUtil.validationinfo("Yes option is not selected", "red");
	}
	}
	/**
	 * Description: Click on Submit button 
	 * @author Suganthini
	 * @param expectedTagManagerHomePageUrl
	 */
	public synchronized void clkSubmitButton(String expectedTagManagerHomePageUrl) 
	{
		try {
			WebActionUtil.waitForElement(btnSubmit, "Submit button");
			WebActionUtil.clickOnElement(btnSubmit, "Submit button", "Unable to click on Submit button");
			WebActionUtil.waitForElement(txtSuccessMessage, "Success message");
			WebActionUtil.validatetext("Your request has been submitted successfully.", txtSuccessMessage, "Submit Success message",
										"Your request has been submitted successfully message is displayed ",
											"Your request has been submitted successfully message is not displayed", "blue");
			validateRecruiterHomePage(expectedTagManagerHomePageUrl);
	}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Submit button");
			Assert.fail("Unable to click on Submit button");
		}
	}
	
	/**
	 * Description  Method validate Recruiter Home page
	 * @author Suganthini
	 * @param expectedTagManagerHomePageUrl
	 */
	public synchronized void validateRecruiterHomePage(String expectedTagManagerHomePageUrl){
	try {
		WebActionUtil.poll(3000);
	    String actualUrl =driver.getCurrentUrl(); 
	    if(actualUrl.equals(expectedTagManagerHomePageUrl))
	    {
	    	WebActionUtil.info("Tag Manager Home page is displayed, url ="+driver.getCurrentUrl());
	    	WebActionUtil.validationinfo("Tag Manager Home page is displayed, url ="+driver.getCurrentUrl(),"blue");
	    }
	    else
	    {
	    	if(!expectedTagManagerHomePageUrl.equals(actualUrl))
	    	{
	    	    WebActionUtil.validationinfo("Url is not matching,Expected=" +expectedTagManagerHomePageUrl+",Actual="+actualUrl,"red");
	    	WebActionUtil.error("Url is not matching,Expected=" +expectedTagManagerHomePageUrl+",Actual="+actualUrl);
	    	}
	    }
	}
	   
	 catch (Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to validate Tag Manager Home Page");
		Assert.fail("Unable to validate Tag Manager Home Page");
	}
	

}
	
	/**
	 * Description:This Method implements to change the role
	 * @author Suganthini
	 * @param role
	 */
	public synchronized void changeRole(String role) {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "Profile drop down");
			WebActionUtil.clickOnElement(selectRole(role), "Role Link", "Able to click on" + role + "Link");
			WebActionUtil.waitForAngularPageload();
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select the Role");
			Assert.fail("Unable to select the Role");
		}
	}

	/**
	 * Description:This Method implements to Validate Selected Role
	 * @author Suganthini
	 * @param expectedRole
	 */
	
	public synchronized void validateSelectedRole(String expectedRole)
	{
		try
		{
		String actualRole =driver.findElement(By.xpath("//span[@class='glb-pnl-showRole role']")).getText();
		 if(expectedRole.equals(actualRole))
		    {
		    	WebActionUtil.info("Role is changed as "+actualRole);
		    	WebActionUtil.validationinfo("Role is changed as "+actualRole,"blue");
		    }
		    else
		    {
		    	WebActionUtil.error("Role is not matching, Expected= "+expectedRole + " Actual ="+actualRole);	
		    	WebActionUtil.validationinfo("Role is not matching, Expected= "+expectedRole + " Actual ="+actualRole,"red");	
		    }
		}
		catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to validate Selected Role");
			Assert.fail("Unable to validate Selected Role");
		}
	}
		
	/**
	 * Description: Method to validate the roles
	 * @author Suganthini
	 */
	public synchronized void validateRoles() {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "Profile drop down");
			WebActionUtil.poll(1000);
			List<String> actualRoles = new ArrayList<String>();
			for(WebElement role : txtRoles)
			{
				actualRoles.add(role.getText());
			}
			List<String> expectedRoles = new ArrayList<String>();
			expectedRoles.add("RM");
			expectedRoles.add("Recruiter (RMG)");
			expectedRoles.add("TAG Manager");
			Assert.assertEquals(expectedRoles, actualRoles);
			WebActionUtil.info(" RM,Recruiter (RMG),TAG Manager role is displayed");
			WebActionUtil.pass("RM,Recruiter (RMG),TAG Manager role is displayed");
		} catch (Exception e) {
			WebActionUtil.fail("RM,Recruiter (RMG),TAG Manager role is not displayed");
			Assert.fail("RM,Recruiter (RMG),TAG Manager role is not displayed");
			
		}
	}
	
	
}
