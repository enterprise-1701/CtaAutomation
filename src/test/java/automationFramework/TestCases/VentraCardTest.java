package automationFramework.TestCases;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.Credentials;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;
import com.beust.jcommander.Strings;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Event;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.beust.jcommander.Strings;

public class VentraCardTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
	static String browser;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		Log.info("Setup Started");
		Log.info("Current OS: " + WindowsUtils.readStringRegistryValue(Global.OS));
		Log.info("Current Browser: " + browser);
		driver = Utils.openBrowser(browser);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("Setup Completed");
	}
	

	@Test(priority=1 , enabled=true)
	public void getVentraCard()throws Exception{
	
		String email = "";
		String userName = "";
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
        Robots.authenticationWindow();
    
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		Utils.waitTime(3000);
		bPage.clickVentraCard(driver);
	
		PurchasePage pPage = new PurchasePage(driver);
		Utils.waitTime(3000);
		pPage.selectCTA1DayPass(driver);
		Utils.waitTime(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-275)", "");
		pPage.clickNextStep(driver);
	
		RegisterTransitAcctPage rPage = new RegisterTransitAcctPage(driver);
		userName = Utils.randomUsernameString();
		rPage.enterNickname(driver, userName);
		rPage.enterFirstname(driver, Global.FNAME);
		rPage.enterLastname(driver, Global.LNAME);
		rPage.enterAddress(driver, Global.ADDRESS);
		rPage.enterAddress2(driver, Global.ADDRESS2);
		rPage.enterCity(driver, Global.CITY);
		rPage.enterZip(driver, Global.ZIP);
		email = Utils.randomEmailString();
		rPage.enterEmail(driver, email);
		rPage.enterConfirmEmail(driver, email);
		rPage.enterPhone(driver, Global.PHONE);
	
		rPage.enterUsername(driver, userName);
		rPage.enterPasswd(driver, Global.PASSWD);
		rPage.enterConfirmPasswd(driver, Global.PASSWD);
		rPage.enterAccessCode(driver, Global.CODE);
		rPage.selectSecurityQuestion(driver);
		rPage.enterAnswer(driver, Global.ANSWER);
		rPage.selectDay(driver);
		rPage.selectMonth(driver);
		rPage.selectYear(driver);
		rPage.clickTerms(driver);
		rPage.clickNextStep(driver);
		Utils.waitTime(5000);
		
		ReviewOrderPage reviewPage = new ReviewOrderPage(driver);
		Assert.assertEquals(reviewPage.getHeading(driver),  "Review Order");
		Log.info("Actual results " +  reviewPage.getHeading(driver) + " matches " +  "Review Order");
		reviewPage.clickNextStep(driver);
		Utils.waitTime(5000);
		
		PaymentInfoPageVC paymentPage = new PaymentInfoPageVC(driver);
		Assert.assertEquals(paymentPage.getHeading(driver),  "Payment Information");
		Log.info("Actual results " +  paymentPage.getHeading(driver) + " matches " +  "Payment Information");
		paymentPage.enterCC(driver, Global.CC);
		paymentPage.enterCCName(driver, Global.CONTACT_NAME);
		paymentPage.enterSecurityCode(driver, Global.CC_CODE);
		paymentPage.selectMonth(driver);
		paymentPage.selectYear(driver);
		paymentPage.clickSubmit(driver);
		Utils.waitTime(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(30000);
		
		/*
		
		//Assertions
		ConfirmationPageTB confPage = new ConfirmationPageTB(driver);
  
		Assert.assertEquals(confPage.getFname(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getFname(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(confPage.getLname(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getLname(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(Utils.getPhoneNumber(confPage.getPhone(driver)),  Global.PHONE);
		Log.info("Actual results " +  confPage.getPhone(driver) + " matches " +  Global.PHONE);
	
		Assert.assertEquals(confPage.getFein(driver),  Global.FEIN);
		Log.info("Actual results " +  confPage.getFein(driver) + " matches " +  Global.FEIN);
	
		Assert.assertEquals(confPage.getEmail(driver),  Global.EMAIL);
		Log.info("Actual results " +  confPage.getEmail(driver) + " matches " +  Global.EMAIL);
	
		Assert.assertEquals(confPage.getAddress(driver),  Global.ADDRESS);
		Log.info("Actual results " +  confPage.getAddress(driver) + " matches " +  Global.ADDRESS);
	
		Assert.assertEquals(confPage.getAddress2(driver),  Global.ADDRESS2);
		Log.info("Actual results " +  confPage.getAddress2(driver) + " matches " +  Global.ADDRESS2);
	
		Assert.assertEquals(confPage.getCity(driver),  Global.CITY);
		Log.info("Actual results " +  confPage.getCity(driver) + " matches " +  Global.CITY);
	
		Assert.assertEquals(confPage.getZip(driver),  Global.ZIP);
		Log.info("Actual results " +  confPage.getZip(driver) + " matches " +  Global.ZIP);
	
		Assert.assertEquals(confPage.getEmployerName(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getEmployerName(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(confPage.getBankName(driver),  Global.BANKNAME);
		Log.info("Actual results " +  confPage.getBankName(driver) + " matches " +  Global.BANKNAME);
	
		Assert.assertEquals(confPage.getAcctNumber(driver),  Global.ACCT_NUMBER_MASKED);
		Log.info("Actual results " +  confPage.getAcctNumber(driver) + " matches " +  Global.ACCT_NUMBER_MASKED);
	
		Assert.assertEquals(confPage.getRoutingNumber(driver),  Global.ROUTE_NUMBER_MASKED);
		Log.info("Actual results " +  confPage.getRoutingNumber(driver) + " matches " +  Global.ROUTE_NUMBER_MASKED);
		
		Assert.assertEquals(confPage.getConfirmation(driver),  Global.CONFIRMATION);
		Log.info("Actual results " +  confPage.getConfirmation(driver) + " matches " +  Global.CONFIRMATION);
		*/
		
		driver.close();	
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}