package com.hcl.ionboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * Description: This class implements the methods for candidate Login page
 * 
 * @author vikas.kc 
 * 
 */
public class Login_Page {

	public WebDriver driver;
	public com.hcl.ionboard.util.WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Login_Page(WebDriver driver, long ETO, com.hcl.ionboard.util.WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Email Text Box */
	@FindBy(id = "EmailId")
	private WebElement txtEmailID;
	
	/* Password Text Box */
	@FindBy(id = "password-field")
	private WebElement txtPassword;
	
	/* Login Button */
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement btnLogin;
	
	/* Spinner */
	@FindBy(xpath = "//div[contains(@class,'spinner')]")
	private WebElement spinner;
	
	/* Login Text */
	@FindBy(xpath = "//div[@id='loginDetail']/descendant::div[@class='loginText']")
	private WebElement txtLoginPage;
	
	/* Sign In Button */
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement btnSignIn;
	
	/**
	 * Description: This method implements login to the application
	 * @author vikas.kc
	 * @param emailID
	 * @param password
	 */
	public synchronized void loginToApplication(String expectedLoginPageText, String expectedTitle, String expectedUrl, String emailID, String password)
	{
		try {
			WebActionUtil.waiForPageLoadJS(driver, 20);
			WebActionUtil.validationinfo("The URL is : "+ driver.getCurrentUrl(),"blue");
			validateLoginPage(expectedLoginPageText, expectedTitle, expectedUrl);
			WebActionUtil.validatetext("It all starts here", txtLoginPage, "It all starts here","Log In page is displayed", "Log In page is not displayed","blue");
		
			WebActionUtil.typeText(txtEmailID, emailID, "Email Id text box");
			WebActionUtil.typeText(txtPassword, password , "Password text box");
			WebActionUtil.clickOnElement(btnLogin, "Login button", "Unable to click on Login button");
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
			WebActionUtil.fail("Unable to LogIn to application");
			Assert.fail("Unable to LogIn to application");
		}
	}
	
	/**
	 * Description: Method to validate login page
	 * 
	 * @author vikas.kc
	 * 
	 * @param expectedLoginPageText
	 * @param expectedTitle
	 * @param expectedUrl
	 */
	public synchronized void validateLoginPage(String expectedLoginPageText,String expectedTitle,String expectedUrl){
		
		
		try {
			
			String actualLoginPageText = txtLoginPage.getText();
		    String actualUrl =driver.getCurrentUrl();
		    String actualTitle =driver.getTitle();
		    
		    if(actualLoginPageText.equals(expectedLoginPageText) && actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle))
		    {
		    	WebActionUtil.info("Home page is displayed, url ="+driver.getCurrentUrl()+ ", title=" +actualTitle);
		    	WebActionUtil.validationinfo("Home page is displayed, url ="+driver.getCurrentUrl()+ ", title=" +actualTitle,"blue");
		    }
		    else
		    {
		    	
		    	if(!expectedTitle.equals(actualTitle))
		    	{
		    	    WebActionUtil.validationinfo("Title is not matching,Expected=" +expectedTitle+",Actual="+actualTitle,"red");
		    	    WebActionUtil.error("Title is not matching,Expected=" +expectedTitle+",Actual="+actualTitle);
		    	}
		    	if(!expectedUrl.equals(actualUrl))
		    	{
		    	    WebActionUtil.validationinfo("Url is not matching,Expected=" +expectedUrl+",Actual="+actualUrl,"red");
		    	WebActionUtil.error("Url is not matching,Expected=" +expectedUrl+",Actual="+actualUrl);
		    	}
		    	if(!expectedLoginPageText.equals(actualLoginPageText)) {
		    	    WebActionUtil.validationinfo("Title is not matching,Expected=" +expectedLoginPageText+",Actual="+actualLoginPageText,"red");
		    	WebActionUtil.error("Title is not matching,Expected=" +expectedLoginPageText+",Actual="+actualLoginPageText);
		    	}
		    }
		  
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to verify Login Page");
			Assert.fail("Unable to verify Login Page");
		}
	
}
	/**
	 * Description: Method to click on Sign In button
	 * @author vikas.kc
	 */
	public synchronized void clkSignIn() 
	{
		try {
			WebActionUtil.clickOnElement(btnSignIn, "Sign In button", "Unable to click on Sign In button");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Sign In button");
			Assert.fail("Unable to click on Sign In button");
		}
	}
	
	
}
