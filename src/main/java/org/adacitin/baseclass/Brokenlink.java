package org.adacitin.baseclass;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Brokenlink  extends CommonUtils{
	
	@FindBy(tagName = "a")
	public static List<WebElement> allhyperlink;
	
	
	
	static void brokernlink() throws Exception{
		browserlaunch("chrome");
		loadUrl(ReadData.getConfigPropData("url"));
		try {
			List<WebElement> link = driver.findElements(By.tagName("a"));			Iterator<WebElement> iterator = link.iterator();
			while (iterator.hasNext()) {
				WebElement wb = (WebElement) iterator.next();
				String url = wb.getAttribute("href");
				System.out.println(url);
				if (url == null || url.isEmpty()) {
					System.out.println("url is empty");

				}
				if (!url.startsWith("https://www.flipkart.com/")) {
					System.out.println("this is related to another domain");
				}
				URL hyperlin= new URL(url);
				URLConnection openConnection =hyperlin.openConnection();
				HttpURLConnection ul=(HttpURLConnection)openConnection;
				ul.connect();
				int responseCode = ul.getResponseCode();
				String responseMessage = ul.getResponseMessage();
				System.out.println(responseCode);
				System.out.println(responseMessage);
				if (responseCode < 400) {
					System.out.println("the give url is non broken");
				} else {
					System.out.println("the given url is broken : " + url);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		brokernlink();
	}

}
