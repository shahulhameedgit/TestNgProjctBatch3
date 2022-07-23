package org.adacitin.scenario;

import org.adacitin.baseclass.CommonUtils;
import org.swiggy.withpagefactory.SwiggySignupPagefactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends CommonUtils{
	
	@Test(dataProvider = "user")
	public void met(String data,String data1) throws Exception {
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		e.ponenumnerCheck(data);
		e.continueClick();
		String phoneLabelDataRead = e.phoneLabelDataRead();
		System.out.println(data1);
	}
	
	@Test(dataProvider = "user")
	public void meth(String data,String data1) throws Exception {
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		e.ponenumnerCheck(data);
		e.continueClick();
		String phoneLabelDataRead = e.phoneLabelDataRead();
		System.out.println(data1);
	}
	
	@Test(dataProvider = "user")
	public void metho(String data,String data1) throws Exception {
		SwiggySignupPagefactory e= new SwiggySignupPagefactory();
		e.singupclick();
		e.ponenumnerCheck(data);
		e.continueClick();
		String phoneLabelDataRead = e.phoneLabelDataRead();
		System.out.println(data1);
	}
	
	@DataProvider(name="user",parallel = true)
	public Object[][] dataPr(){
		return new Object[][] { {"98908909", "hameed"},{"123432", "mohameed"},{"123432", "mohameed"} };
	}

}
