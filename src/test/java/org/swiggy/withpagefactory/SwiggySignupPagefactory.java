package org.swiggy.withpagefactory;

import java.util.List;

import org.adacitin.baseclass.CommonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggySignupPagefactory extends CommonUtils {
	
	public SwiggySignupPagefactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sign up']")
	public WebElement signupbutton;
	
	@FindBy(id="mobile")
	public WebElement phonenumber;
	
	@FindBy(xpath = "//a[@class='a-ayg']")
	public WebElement continubutton;
	
	@FindBy(xpath="//label[@for='mobile']")
	public WebElement labeldatafrophone;
	
	
	public void singupclick() {
		elementClick(signupbutton);
	}
	
	public void continueClick() {
		elementClick(continubutton);
	}
	
	public void ponenumnerCheck(String phone) {
		type(phonenumber, phone);
	}
	
	public String phoneLabelDataRead() {
		WebElement phoneLabelData = labeldatafrophone;
		String text = phoneLabelData.getText();
		return text;
	}
	
}
