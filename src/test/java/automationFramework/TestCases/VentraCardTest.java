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
		Utils.waitTime(15000);
	
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
		Utils.waitTime(5000);
		ConfirmationPageVC confPage = new ConfirmationPageVC(driver);
		
		//Assertions
		Assert.assertTrue(confPage.isOrderNumberDisplayed(driver), "Order number is not displayed on confirmation page!");
		
		Assert.assertTrue(confPage.isPaymentAuthorizationDisplayed(driver), "Payment Authorization is not displayed on confirmation page!");
		
		Assert.assertEquals(confPage.getCCName(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getCCName(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(confPage.getCCNumber(driver),  Global.CC_MASKED);
		Log.info("Actual results " +  confPage.getCCNumber(driver) + " matches " +  Global.CC_MASKED);
		
		Assert.assertEquals(confPage.getConfirmation(driver),  Global.ORDER_CONFIRMATION);
		Log.info("Actual results " +  confPage.getConfirmation(driver) + " matches " +  Global.ORDER_CONFIRMATION);
		
		Assert.assertEquals(confPage.getName(driver),  Global.CONTACT_NAME2);
		Log.info("Actual results " +  confPage.getName(driver) + " matches " +  Global.CONTACT_NAME2);
		
		Assert.assertEquals(confPage.getOrderTotal(driver),  Global.TOTAL);
		Log.info("Actual results " +  confPage.getOrderTotal(driver) + " matches " +  Global.TOTAL);
		
		Assert.assertEquals(confPage.getOrderSubTotal(driver),  Global.SUBTOTAL);
		Log.info("Actual results " +  confPage.getOrderSubTotal(driver) + " matches " +  Global.SUBTOTAL);
		
		Assert.assertEquals(confPage.getBillingCity(driver),  Global.BILLING_CITY);
		Log.info("Actual results " +  confPage.getBillingCity(driver) + " matches " +  Global.BILLING_CITY);
		
		Assert.assertEquals(confPage.getBillingAddress(driver),  Global.BILLING_ADDRESS);
		Log.info("Actual results " +  confPage.getBillingAddress(driver) + " matches " +  Global.BILLING_ADDRESS);
		
		//Add more assertions
		driver.close();	
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}