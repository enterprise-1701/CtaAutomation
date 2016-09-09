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

public class GroupAccountAddPaymentAch {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
	static String browser;
	CreditCardNumberGenerator ccGen = new CreditCardNumberGenerator();
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		driver = Utils.openBrowser(browser);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("Setup Completed");
	}
	

	@Test(priority=1 , enabled=true)
	public void addACHPayment()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
		
		//windows automation 
        Robots.authenticationWindow();
		
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		bPage.clickAcctLogin(driver);
		
		bPage.enterUsername(driver, UserData.getGroupUserName());
		bPage.enterPasswd(driver, Global.PASSWD);
		bPage.clickLogin(driver);
		Utils.waitTime(13000);
		Log.info("USERNAME used is: " + UserData.getGroupUserName());
		
		
		GroupAccountLandingPage landingPage = new GroupAccountLandingPage(driver);
		Assert.assertEquals(landingPage.getDashboard(driver), "Dashboard");
		
		landingPage.clickPaymentInfo(driver);
		Utils.waitTime(3000);
		
		GroupAccountPaymentInfoPage pPage = new GroupAccountPaymentInfoPage(driver);
		
		//Brand new account 
		pPage.clickAddFundingSource(driver);
		pPage.clickSaveACHInfo(driver);
		
		//edit account
		//pPage.clickEdit(driver);
		Utils.waitTime(3000);
				
		
		pPage.enterAccountNo(driver, Global.ACCT_NUMBER);
		pPage.enterRoutingNo(driver, Global.ROUTE_NUMBER);
		pPage.enterNameOnAccount(driver, Global.CONTACT_NAME );
		pPage.enterBankName(driver, Global.BANKNAME);
		pPage.enterFname(driver, Global.FNAME);
		pPage.enterLname(driver, Global.LNAME);
		pPage.enterPhone(driver, Global.PHONE);
		pPage.enterAddress(driver, Global.ADDRESS);
		pPage.enterAddress2(driver, Global.ADDRESS2);
		pPage.enterCity(driver, Global.CITY);
		pPage.enterZip(driver, Global.ZIP);
		pPage.clickSave(driver);
		
		Utils.waitTime(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(3000);
		
		GroupAccountConfirmationPage cPage = new GroupAccountConfirmationPage(driver);
		Assert.assertEquals(cPage.getHeading(driver), "Payment Information");
		Assert.assertEquals(cPage.getMaskedAccountNo2(driver), Global.ACCT_NUMBER_MASKED);
		Assert.assertEquals(cPage.getRoutingNo(driver), Global.ROUTE_NUMBER_MASKED);
		Assert.assertEquals(cPage.getAddress(driver), Global.FULL_ADDRESS);
		Assert.assertEquals(cPage.getCityState(driver), Global.CITY_STATE);
		Assert.assertEquals(cPage.getPhone(driver), Global.PHONE2);
		
		driver.close();
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}