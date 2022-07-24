package org.adacitin.baseclass;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonUtils extends Setup {
	protected static ExtentHtmlReporter report;
	protected static ExtentReports extend= new ExtentReports();
	protected static ExtentTest logger;
	
	
	public static Logger log = Slf4J.loadLogger(CommonUtils.class);

	
//	@BeforeSuite
//	public static void browserOpen() throws Exception {
//		report = new ExtentHtmlReporter("./target/novbatch.html");
//		extend.attachReporter(report);
//		log.info("Launching the chrome browser");
//		browserlaunch("chrome");
//	}
	
//	@Parameters({"Browser"})
//	@BeforeTest
//	public static void browserOpen(String browser) throws Exception {
//		report = new ExtentHtmlReporter("./target/novbatch.html");
//		extend.attachReporter(report);
//		log.info("Launching the chrome browser");
//		browserlaunch(browser);
//	}
//	
//	@Parameters({"Browser1"})
//	@BeforeClass
//	public void loadURL(String url) throws IOException {
//		loadUrl(ReadData.getConfigPropData(url));
//	}
	
	@BeforeMethod
	public void loadURL() throws Exception {
		report = new ExtentHtmlReporter("./target/novbatch.html");
		extend.attachReporter(report);
		log.info("Launching the chrome browser");
		browserlaunch(System.getProperty("browser"));
		loadUrl(ReadData.getConfigPropData(System.getProperty("environment")));
	}
	
	public static void browserlaunch(String key) throws Exception {
		switch (key) {
		case "chrome":
			System.setProperty(ReadData.getConfigPropData("chromevariable"), "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Jar/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.gecko.driver", "./Jar/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("the give key is not presentin the case");
			break;
		}

//		System.setProperty("webdriver.gecko.driver", "./Jar/geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();

//		System.setProperty("webdriver.chrome.driver", "./Jar/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		
		// driver.manage().window().setSize(new Dimension(600,530));

	}

	public static void browserMaximize() {
		driver.manage().window().maximize();
	}

	public void fullScreenView() {
		driver.manage().window().fullscreen();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public void loadDifferentUrl(String tourl) {
		driver.navigate().to(tourl);
	}

	public static WebElement elementFinder(By locator) {
		return driver.findElement(locator);
//		WebElement findElement = driver.findElement(locator);
//		return findElement;

	}
	
	public static By locatorFinderById(String data) {
		return By.id(data);
	}
	
	
	public static By locatorfinderByXpath(String data) {
//		By xpath = By.xpath(data);
//		return xpath;
		
		return By.xpath(data);
		
	}
	
	

	public WebElement elementfinderById(String locator) {
		return driver.findElement(By.id(locator));
	}

	public WebElement ElementFinderByxPath(String locator) {
		
		return driver.findElement(By.xpath(locator));
	}
	
	public static By locaterfindByname(String data) {
		return By.name(data);
	}
	
	public static void type(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}
	
	
	public static void elementClick(WebElement element) {
		element.click();
	}
//	
//	@AfterSuite
//	public static void tearDown() {
//		
//		extend.flush();
//		driver.quit();
//	}
//	
//	@AfterTest
//	public static void tearDown() {
//		
//		extend.flush();
//		driver.quit();
//	}
//	public static void main(String[] args) {
//		browserlaunch("chrome");
//		browserMaximize();
//		loadUrl("https://www.facebook.com/");
//		
//		//advicable methods use
//		type(elementFinder(locatorFinderById("email")),"shahul");
//		type(elementFinder(locatorFinderById("pass")),"hameed");
//		elementClick(elementFinder(locaterfindByname("login")));
//		
//		// non preferable
//		WebElement username = elementFinder(By.id("email"));
//		type(username, "shahul");
//		WebElement password = elementFinder(By.id("pass"));
//		type(password, "hameed");
//		WebElement login = elementFinder(By.name("login"));
//		elementClick(login);
//		
//		
//		
//		elementFinder(locatorFinderById("email"));
//		elementFinder(By.name("pass"));
//		elementFinder(locatorfinderByXpath("//button[@name='login']"));
//		elementFinder(By.xpath("//button[@name='login']"));
//		
//		type(elementFinder(locatorFinderById("email")),"hameed");
//	
//	}
	
	
	
	public void newcodes() {
		System.out.println("to check conflicts");
	}
	public void newcode() {
		System.out.println("to check conflicts");
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		int status = result.getStatus();
		System.out.println(status);
		if (status ==1) {
			log.info(result.getMethod().getMethodName(), Status.PASS);
			logger.log(Status.PASS, "The executed method "+ result.getMethod().getMethodName());
		}
		else if (status == 2) {
			// add screen shot code in logger
			//add screen shot in project folder
			log.info(result.getMethod().getMethodName(), Status.FAIL);
			logger.log(Status.FAIL, "The executed method "+ result.getMethod().getMethodName());
			
		}
		else {
			log.info(result.getMethod().getMethodName(), Status.SKIP);
			logger.log(Status.SKIP, "The executed method "+ result.getMethod().getMethodName());
			
		}
			driver.quit();
	}

}
