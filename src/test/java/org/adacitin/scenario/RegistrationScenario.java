package org.adacitin.scenario;

import java.io.IOException;

import org.adacitin.baseclass.CommonUtils;
import org.adacitin.baseclass.ReadData;
import org.swiggy.withpagefactory.SwiggySignupPagefactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class RegistrationScenario extends CommonUtils {
	
	
	@Test(priority = 0,groups = {"smoke","sanity"}, dataProvider = "user",dataProviderClass = DataProviderTest.class)
	public void phonenumnerValiddata(String data,String data1) throws Exception {
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
		Assert.assertTrue(phoneLabelDataRead.equalsIgnoreCase("Phone number"));
		log.info("the phone number entered is in 10 digit");
		logger.log(Status.PASS, "the phone number entered is in 10 digit");
		}catch (Exception a) {
			// TODO: handle exception
			log.error("the phone number entered is in 10 digit");
			logger.log(Status.FAIL, "the phone number entered is in 10 digit");
		}
		log.info(data);
		log.info(data1);
		
		//System.out.println("the phone number entered is in 10 digit");
//		if (phoneLabelDataRead.equalsIgnoreCase("Phone number")) {
//			System.out.println("the phone number entered is in 10 digit");
//		}
//		else {
//			System.out.println("The phone number entered is less then 10 digit: ");
//		}
	}
	
	
	@Test
	public void phonenumnerValiddatb() throws Exception {
		logger = extend.createTest("phonenumnerValiddatb");
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		logger.log(Status.INFO, "clicking on sign up button");
		e.ponenumnerCheck(ReadData.getdatafromexcel("overalldata", 2, 1));
		e.continueClick();
		logger.log(Status.INFO, "clicking on continue button");
		String phoneLabelDataRead1 = e.phoneLabelDataRead();
		try {
		Assert.assertEquals(phoneLabelDataRead1, "Phone numbr","after entring the phone number the label name is found to be different");
		logger.log(Status.PASS, "both the actual a expected are not same");
		}catch (Exception a) {
			// TODO: handle exception
			log.error("the phone number entered is not in 10 digit");
			logger.log(Status.FAIL, "both the actual a expected are not same");
		}
		
//		if (phoneLabelDataRead1.equalsIgnoreCase("Phone number")) {
//			System.out.println("the phone number entered is in 10 digit");
//		}
//		else {
//			System.out.println("The phone number entered is less then 10 digit: ");
//		}
		
	}


@Test(priority = -2,groups = {"sanity"})
	public void phonenumnerValiddatc() throws Exception {
		logger = extend.createTest("phonenumnerValiddatb");
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		logger.log(Status.INFO, "clicking on sign up button");
		e.ponenumnerCheck(ReadData.getdatafromexcel("overalldata", 2, 1));
		e.continueClick();
		logger.log(Status.INFO, "clicking on continue button");
		String phoneLabelDataRead1 = e.phoneLabelDataRead();
		try {
		Assert.assertEquals(phoneLabelDataRead1, "Phone numbr","after entring the phone number the label name is found to be different");
		logger.log(Status.PASS, "both the actual a expected are not same");
		}catch (Exception a) {
			// TODO: handle exception
			log.error("the phone number entered is not in 10 digit");
			logger.log(Status.FAIL, "both the actual a expected are not same");
		}
		
//		if (phoneLabelDataRead1.equalsIgnoreCase("Phone number")) {
//			System.out.println("the phone number entered is in 10 digit");
//		}
//		else {
//			System.out.println("The phone number entered is less then 10 digit: ");
//		}
		
	}

	
	

}
