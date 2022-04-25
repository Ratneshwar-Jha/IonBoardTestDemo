package com.hcl.ionboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Description: This class implements the methods for QA Login Page
 * @author Aatish
 *
 */
public class QALogin_Page {

	public WebDriver driver;
	public com.hcl.ionboard.util.WebActionUtil WebActionUtil;
	public long ETO = 10;

	public QALogin_Page(WebDriver driver, long ETO, com.hcl.ionboard.util.WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Email Text Box */
	@FindBy(id = "txtUserName")
	private WebElement txtUserName;
	
	/* Password Text Box */
	@FindBy(id = "txtPassword")
	private WebElement txtPassword;
	
	/* Button Submit */
	@FindBy(id = "btnSubmit")
	private WebElement btnSubmit;
	
	/* Spinner */
	@FindBy(xpath = "//div[contains(@class,'spinner')]")
	private WebElement spinner;
	
	
	/**
	 * Description: This method implements login to the application
	 * @author Aathish
	 * @param sapCode
	 * @param password
	 */
	public synchronized void loginToApplication(String sapCode, String password)
	{
		try {
			
			WebActionUtil.waiForPageLoadJS(driver, 20);
			WebActionUtil.validationinfo("The URL is : "+ driver.getCurrentUrl(),"blue");
			
			WebActionUtil.typeText(txtUserName, sapCode, "Sapcode text box");
			WebActionUtil.typeText(txtPassword, password , "Password text box");
			WebActionUtil.clickOnElement(btnSubmit, "Login button", "Unable to click on Login button");
			WebActionUtil.waitForAngularPageload();
			try {
				while(true) {
					if (spinner.isDisplayed()) {
						new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(spinner));
						break;
					}
				}}catch(Exception e) {
					
				}
				
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to Login to application");
			Assert.fail("Unable to Login to application");
		}
	}
}
