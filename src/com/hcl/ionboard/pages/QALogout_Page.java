package com.hcl.ionboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.ionboard.util.WebActionUtil;

/**
 * Description: This class implements the methods for QA Logout Page
 * @author Aatish
 *
 */
public class QALogout_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public QALogout_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Logout Button*/
	@FindBy(xpath ="//span[text()='LOGOUT']")
	private WebElement btnlogout;
	
	/* Profile Drop Down */
	@FindBy(xpath = "//div[@class='glb-pnl-informationDropIcon']")
	private WebElement ddProfile;
	
	/* Spinner */
	@FindBy(xpath = "//div[contains(@class,'spinner')]")
	private WebElement spinner;
	
	/* Yes Button */
	@FindBy(xpath = "//button[text()='YES']")
	private WebElement btnYes;
	
	/* Back To My HCL */
	@FindBy(xpath = "//span[text()='BACK TO MY HCL']")
	private WebElement btnBackTomyHcl;

	/**
	 * Description: This method implements logout to the application
	 * @author Aathish
	 */	
	public synchronized void logoutToApplication()
	{
		try {
	  WebActionUtil.poll(3000);
      WebActionUtil.waitForElement(ddProfile, "Profile dropdown");
	  WebActionUtil.actionMouseOver(ddProfile, "Profile Dropdown");	
	  WebActionUtil.waitForElement(btnlogout, "Logout Button");
	  WebActionUtil.clickOnElement(btnlogout, "Logout Button", "Unable to click on Logout Button");
	  WebActionUtil.poll(2000);
	  WebActionUtil.waitForElement(btnYes, "Yes Button");
	  WebActionUtil.clickOnElement(btnYes, "Yes Button", "Unable to click on Yes button");
	  WebActionUtil.validationinfo("The URL is : "+ driver.getCurrentUrl(),"Blue");
	  WebActionUtil.clickOnElement(btnBackTomyHcl, "BackToMyHcl", "Unable to click on Back to my Hcl button");
			
		
	} catch (Exception e) {
		WebActionUtil.fail("Unable to Logout of application");
		Assert.fail("Unable to Logout of application");
	}
	}
}