package org.adacitin.scenario;

import org.adacitin.baseclass.CommonUtils;
import org.adacitin.baseclass.ReadData;
import org.adacitin.baseclass.RetryAnalyser;
import org.swiggy.withpagefactory.SwiggySignupPagefactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class KnownFailedTest extends CommonUtils {
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void phonenumnerValiddata() throws Exception {
		logger = extend.createTest("phonenumnerValiddata");
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		log.info("clicking on sign up button");
		logger.log(Status.INFO, "clicking on sign up button");
		e.ponenumnerCheck(ReadData.getdatafromexcel("overalldata", 1, 1));
		e.continueClick();
		logger.log(Status.INFO, "clicking on continue button");
		String phoneLabelDataRead = e.phoneLabelDataRead();
		try {
		Assert.assertTrue(phoneLabelDataRead.equalsIgnoreCase("Phone numbr"));
		log.info("the phone number entered is in 10 digit");
		logger.log(Status.PASS, "the phone number entered is in 10 digit");
		}catch (Exception a) {
			// TODO: handle exception
			log.error("the phone number entered is in 10 digit");
			logger.log(Status.FAIL, "the phone number entered is in 10 digit");
		}
	}
	

}
