package com.hcl.ionboard.pages;

import java.util.ArrayList;
import java.util.Arrays;
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
 * Description: This class implements the methods for Home page
 * @author suganthini,Manish Kumar C D
 */

public class Home_Page {
	
public WebDriver driver;
public WebActionUtil WebActionUtil;
public long ETO = 10;

public Home_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) 
{
this.driver = driver;
PageFactory.initElements(driver, this);
this.WebActionUtil = WebActionUtil;
this.ETO = ETO;
}

/* Profile Drop Down*/
@FindBy(id = "Span")
private WebElement ddProfile;

/* Logout */
@FindBy(xpath = "//span[text()='Logout']")
private WebElement btnLogout;

/* Fill Joining Form */
@FindBy(xpath = "//p[text()='Fill Joining Form']")
private WebElement lnkFillJoiningForm;

/* View Joining Form */
@FindBy(xpath = "//p[text()='View Joining Form']")
private WebElement lnkViewJoiningForm;

/* Logout Success Message */
@FindBy(xpath = "//div[contains(text(),'You have been logged out')]/span")
private WebElement txtLogout;

/* Spinner */
@FindBy(xpath="//div[@class='go_spiner nolms']/div[@class='loader2 material-spinner']")
private WebElement spinner;

/* Titles Text */
@FindBys(@FindBy(xpath="//h4[@class='panel-title']"))
private List<WebElement> txtTitles;

/* Personal Detail Titles Text */
@FindBys(@FindBy(xpath="(//div[@class='panel-body'])[1]//label"))
private List<WebElement> txtPersonalDetailsTitles;

/* Address Detail Titles Text */
@FindBys(@FindBy(xpath="(//div[@class='panel-body'])[2]//label"))
private List<WebElement> txtAddressDetailsTitles;



/**
 * Description : Method to validate Welcome Page
 * @author Suganthini
 * @param expectedUrl
 */
public synchronized void validateHomePage(String expectedUrl){
	try {
		
		String actualUrl =driver.getCurrentUrl();
	    
	    if(actualUrl.equals(expectedUrl))
	    {
	    	WebActionUtil.info("Home page is displayed, url =" + actualUrl);
	    	WebActionUtil.validationinfo("Home page is displayed, url =" + actualUrl,"blue");
	    }
	    else
	    {
	    	
	    	if(!expectedUrl.equals(actualUrl))
	    	{
	    	    WebActionUtil.validationinfo("Url is not matching,Expected=" +expectedUrl+",Actual="+actualUrl,"red");
	    	WebActionUtil.error("Url is not matching,Expected=" +expectedUrl+",Actual="+actualUrl);
	    	}
	      }
	  
	} catch (Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to validate Home Page");
		Assert.fail("Unable to validate Home Page");
	}
}

/**
 * Description:This Method implements to click on Fill joining form
 * @author Suganthini
 */
public synchronized void clkFillJoiningForm()
{
	try {
		
		WebActionUtil.clickOnElement(lnkFillJoiningForm,
				"Fill Joining Form link",
				"Unable to click on Fill Joining Form link");
		WebActionUtil.waitForAngularPageload();

	} catch (Exception e) {
		WebActionUtil.fail("Unable to click on Fill Joining Form link");
		Assert.fail("Unable to click on Fill Joining Form link");
	}

}

/**
 * Description:This Method implements to click on view joining form
 * @author Suganthini
 */
public synchronized void clkViewJoiningForm()
{
	try {
		
		WebActionUtil.clickOnElement(lnkViewJoiningForm,
				"View Joining Form link",
				"Unable to click on View Joining Form link");
		WebActionUtil.waitForAngularPageload();

	} catch (Exception e) {
		WebActionUtil.fail("Unable to click on View Joining Form link");
		Assert.fail("Unable to click on View Joining Form link");
	}

}

/**
 * Description:This Method implements to log out of the application
 * @author Suganthini
 */
public synchronized void logout()
{
	try {
		WebActionUtil.actionMouseOver(ddProfile,"Profile drop down");
		WebActionUtil.waitForElement(btnLogout, "Logout");
		WebActionUtil.clickOnElement(btnLogout,"Logout","Unable to click on Logout button");
	    WebActionUtil.validatetext("Please sign in again", txtLogout, "Log out success message","User is able to Logout successfully", "User is not able to Logout","green");
	} catch (Exception e) {
		WebActionUtil.fail("Unable to Log out from the application");
		Assert.fail("Unable to Log out from the application");
	}
	
}
/**
 * Description : Method  to Validate Joining Form Page
 * @author Manish Kumar C D
 */
private synchronized void validateJoiningFormPage(){
	try {
		driver.findElement(By.xpath("(//i[@class='icon-tick'])[1]")).click();
		WebActionUtil.waitForElement(spinner, "Spinner");
		String actualJoiningFormUrl = driver.getCurrentUrl();
		String expectedJoiningFormUrl = "https://staging3.myhcl.com/iOnboard/Candidate/DataForm/JoiningForm";

		if(actualJoiningFormUrl.equals(expectedJoiningFormUrl)) 
		{
			WebActionUtil.extentinfo("Joining Form Page is displayed.");
		}

		else {
			throw new Exception();
		}

		String[] expectedTitle = new String [] {"Personal Details ","Address Details "};
		ArrayList<String> lstExpectedTitle = new ArrayList<>(Arrays.asList(expectedTitle));
		ArrayList<String> lstActualTitle = new ArrayList<>();

		for(WebElement txtTitle:txtTitles) {
			String actualTitle = txtTitle.getText();
			lstActualTitle.add(actualTitle);

			if(lstActualTitle.containsAll(lstExpectedTitle))
			{
				WebActionUtil.pass(actualTitle);
			}
		}

		for(WebElement txtPersonalDetailsTitle:txtPersonalDetailsTitles) {
			String actualPersonalDetailsTitle = txtPersonalDetailsTitle.getText();
			WebActionUtil.pass(actualPersonalDetailsTitle);
		}


		for(WebElement txtAddressDetailsTitle:txtAddressDetailsTitles) {
			String actualAddressDetailsTitle = txtAddressDetailsTitle.getText();
			WebActionUtil.pass(actualAddressDetailsTitle);
		}

	} catch (Exception e) {
		WebActionUtil.error("Unable to validate Joining Form Page");
		WebActionUtil.fail("Unable to validate Joining Form Page");
		Assert.fail("Unable to validate Joining Form Page");
	}
}


}
