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
 * Description: This class implements the methods for RM page
 * @author vikas.kc
 *
 */
public class RM_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public RM_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Profile Drop Down */
	@FindBy(xpath = "//div[@class='glb-pnl-informationDropIcon']")
	private WebElement ddProfile;
	
	/* Roles */
	@FindBy(xpath = "//ul[@class='glb-pnl-role-list']/li/a")
	private List<WebElement> txtRoles;
	
	/* Table Header */
	@FindBy(xpath = "//tr[@role='row']/th")
	private List<WebElement> tableHeader;
	
	/**
	 * Description: Method to validate the roles
	 * @author vikas.kc
	 */
	public synchronized void validateRoles() {
		try {
			WebActionUtil.actionMouseOver(ddProfile, "Profile drop down");
			WebActionUtil.poll(3000);
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
			WebActionUtil.pass("Different roles are displayed in drop down and Role are matching");
			
		} catch (Exception e) {
			WebActionUtil.fail("Roles are not same");
			Assert.fail("Roles are not same");
		}
	}
	
	/**
	 * Description : Method to validate Role
	 * @author vikas.kc
	 * @param expectedRole
	 */
	public synchronized void validateRole(String expectedRole){
			try {
				WebActionUtil.poll(1000);
		
			  String actualUrl =driver.getCurrentUrl();
			  String actualRole =driver.findElement(By.xpath("//span[@class='glb-pnl-showRole role']")).getText();
			    if(expectedRole.equals(actualRole))
			    {
			    	WebActionUtil.info("Role: "+actualRole);
			    	WebActionUtil.validationinfo("Role: "+actualRole,"blue");
			    }
			    else
			    {
			    	WebActionUtil.error("Role is not matching, Expected= "+expectedRole + " Actual ="+actualRole);	
			    	WebActionUtil.validationinfo("Role is not matching, Expected= "+expectedRole + " Actual ="+actualRole,"red");	
			    }
		
			} catch (Exception e) {
				WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to verify Role");
				Assert.fail("Unable to verify Role");
			}
	}
	
	/**
	 * Description: Method to validate Fields
	 * @author vikas.kc
	 */
	public synchronized void validateFields()
	{
		try {
			List<String> actualFields = new ArrayList<String>();
			for(WebElement value : tableHeader)
			{
				actualFields.add(value.getText());
			}
						
			List<String> expectedFields = new ArrayList<String>();
			expectedFields.add("Candidate ID/\n" + 
					"SAP Code");
			expectedFields.add("Candidate Name");
			expectedFields.add("Record Triggered");
			expectedFields.add("         DOJ        ");
			expectedFields.add("Employee Type");
			expectedFields.add("GEO Name");
			expectedFields.add("GEO Location");
			expectedFields.add("Joining\n" + 
					"Form Status");
			expectedFields.add("BGV");
			expectedFields.add("I-9\n" + 
					"Status");
			expectedFields.add("SAP ID\n" + 
					"Creation");
			expectedFields.add("Admin");
			expectedFields.add("Action");
			
			Assert.assertEquals(expectedFields, actualFields);
			WebActionUtil.pass("Fields are same");
			
		} catch (Exception e) {
			WebActionUtil.fail("Fields are not same");
			Assert.fail("Fields are not same");
		}
	}
}
