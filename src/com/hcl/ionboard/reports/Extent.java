package com.hcl.ionboard.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hcl.ionboard.baseutil.BaseTest;
import com.hcl.ionboard.commonutil.FileVariables;

/**
 * Description: Implements the creation of the Extent Html report with specified
 * name after loading the Extent config file from specified location.
 * 
 * @author Shreya U,Vivek Dogra
 */
public class Extent {

	private ExtentReports extent;
	FileVariables fileVariables = new FileVariables();

	/**
	 * Description: Creates of HTML report in specified path
	 * 
	 * @author shreya U, Vivek Dogra
	 * @param filepath
	 */
	public ExtentReports getExtent(String filepath) {

		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter(filepath + "/AutomationReport.html"));
				return extent;
			} catch (Exception e) {
				BaseTest.logger.info("Exception while creating report html file.");
			}
		}
		return extent;
	}

	/**
	 * Description :Loads the Extent-config file specified from the location
	 * 
	 * @author Shreya U, Vivek Dogra
	 * @param filePath
	 */
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "./config\\extent-config.xml");
		return htmlReporter;
	}

}
