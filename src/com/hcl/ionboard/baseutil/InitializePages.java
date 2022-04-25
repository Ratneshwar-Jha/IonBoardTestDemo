package com.hcl.ionboard.baseutil;

import org.openqa.selenium.WebDriver;

import com.hcl.ionboard.pages.AdditionalInfo_Page;
import com.hcl.ionboard.pages.ES_Page;
import com.hcl.ionboard.pages.EducationalInfo_Page;
import com.hcl.ionboard.pages.EmploymentDetails_Page;
import com.hcl.ionboard.pages.Home_Page;
import com.hcl.ionboard.pages.JoiningForm_Page;
import com.hcl.ionboard.pages.Login_Page;
import com.hcl.ionboard.pages.Preview_Page;
import com.hcl.ionboard.pages.QALogin_Page;
import com.hcl.ionboard.pages.QALogout_Page;
import com.hcl.ionboard.pages.RM_Page;
import com.hcl.ionboard.pages.Recruiter_Page;
import com.hcl.ionboard.pages.TagManager_Page;
import com.hcl.ionboard.util.WebActionUtil;

/**
 *Description: Initializes all pages with driver instance ,Explicit Time out, WebAactionUtility
 *             using variables driver,ETO,WebactionUtil
 *@author  :   Shreya U,Vivek Dogra,Aatish Slathia 
 */
public class InitializePages {
	
	

	public EducationalInfo_Page educationalInfoPage;
	public QALogin_Page qALoginPage;
	public  ES_Page esPage;
	public RM_Page rmPage;
	public EmploymentDetails_Page employementdetailspage;
	public Login_Page loginPage;
	public AdditionalInfo_Page additionalInfoPage;
	public Home_Page homePage;
	public JoiningForm_Page joiningFormPage;
	public Preview_Page previewPage;
	public Recruiter_Page recruiterPage;
	public TagManager_Page tagManagerPage;
	public QALogout_Page qaLogoutPage;
	
 
	public InitializePages(WebDriver driver,long ETO,WebActionUtil WebActionUtil) {
	
		educationalInfoPage=new EducationalInfo_Page(driver, ETO, WebActionUtil);
		
		qALoginPage  = new QALogin_Page(driver, ETO, WebActionUtil);
		
		esPage = new ES_Page(driver, ETO, WebActionUtil);
		
		rmPage = new RM_Page(driver, ETO, WebActionUtil);
	
		employementdetailspage = new EmploymentDetails_Page(driver, ETO, WebActionUtil);

		loginPage = new Login_Page(driver, ETO, WebActionUtil);

		additionalInfoPage = new AdditionalInfo_Page(driver, ETO, WebActionUtil);

		homePage = new Home_Page(driver, ETO, WebActionUtil);

		joiningFormPage = new JoiningForm_Page(driver, ETO, WebActionUtil);

		previewPage = new Preview_Page(driver, ETO, WebActionUtil);

		recruiterPage = new Recruiter_Page(driver, ETO, WebActionUtil);
		
		tagManagerPage=new TagManager_Page(driver, ETO, WebActionUtil);
				
		qaLogoutPage= new QALogout_Page(driver, ETO, WebActionUtil);
	}	

}
