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

public class AutoloadTest {

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
	

	//When you turn on Autoload for a pass you have to wait 3 hours before you can turn it on again
	@Test(priority=1 , enabled=true)
	public void autoLoadSavedCC()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
		
        Robots.authenticationWindow();
		
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		
		bPage.clickAcctLogin(driver);
		
		bPage.enterUsername(driver, Global.EXISTING_USER);
		bPage.enterPasswd(driver, Global.PASSWD);
		bPage.clickLogin(driver);
		Utils.waitTime(3000);
		AccountLandingPage landingPage = new AccountLandingPage(driver);
		landingPage.clickMyVentraCard(driver);
		AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
		Utils.waitTime(3000);
		
		Assert.assertEquals(vPage.getUserName(driver),  "fifthcard");
		Log.info("Actual results " +  vPage.getUserName(driver) + " matches " +  "fifthcard");
		
		vPage.clickAutoLoadStatus(driver);
		Utils.waitTime(3000);
		vPage.clickPopupOk(driver);
		
		AutoLoadPage aPage = new AutoLoadPage(driver);
		aPage.clickAgreement(driver);
		aPage.clickNextSteps(driver);
		aPage.clickSavedCard(driver);
		aPage.clickSubmit(driver);
		
		Utils.waitTime(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(3000);
		
		//Assert autoload is on
		Utils.waitTime(3000);
		Assert.assertEquals(vPage.getAutoLoadStatus(driver), "ON");
		
		vPage.clickAutoLoadStatus(driver);
		Utils.waitTime(3000);
		driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(3000);
		
		//Assert autoload is off 
		Assert.assertEquals(vPage.getAutoLoadStatusOff(driver), "OFF");
		
		driver.close();
	}
	
	
	@Test(priority=1 , enabled=true)
	public void autoLoadNewCC()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
		
        Robots.authenticationWindow();
		
		
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		
		bPage.clickAcctLogin(driver);
		
		bPage.enterUsername(driver, Global.EXISTING_USER);
		bPage.enterPasswd(driver, Global.PASSWD);
		bPage.clickLogin(driver);
		Utils.waitTime(3000);
		AccountLandingPage landingPage = new AccountLandingPage(driver);
		landingPage.clickMyVentraCard(driver);
		AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
		Utils.waitTime(3000);
		
		Assert.assertEquals(vPage.getUserName(driver),  "fifthcard");
		Log.info("Actual results " +  vPage.getUserName(driver) + " matches " +  "fifthcard");
		
		vPage.clickAutoLoadStatus(driver);
		Utils.waitTime(3000);
		vPage.clickPopupOk(driver);
		
		AutoLoadPage aPage = new AutoLoadPage(driver);
		aPage.clickAgreement(driver);
		aPage.clickNextSteps(driver);
		Utils.waitTime(5000);
		aPage.clickNewCard(driver);
		aPage.enterCC(driver, ccGen.generate("4", 16));
		aPage.enterCVV(driver, Global.CC_CODE);
		aPage.enterName(driver, Global.CONTACT_NAME);
		aPage.enterPhone(driver, Global.PHONE);
		aPage.selectMonth(driver);
		aPage.selectYear(driver);
		aPage.enterFname(driver, Global.FNAME);
		aPage.enterLname(driver, Global.LNAME);
		aPage.enterAddress(driver, Global.ADDRESS);
		aPage.enterAddress2(driver, Global.ADDRESS2);
		aPage.enterCity(driver, Global.CITY);
		aPage.enterZip(driver, Global.ZIP);
		aPage.clickSubmit(driver);
		
		Utils.waitTime(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(3000);
		
		//Assert autoload is on
		Utils.waitTime(3000);
		Assert.assertEquals(vPage.getAutoLoadStatus(driver), "ON");
		
		vPage.clickAutoLoadStatus(driver);
		Utils.waitTime(3000);
		driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(3000);
		
		//Assert autoload is off 
		Assert.assertEquals(vPage.getAutoLoadStatusOff(driver), "OFF");
		driver.close();
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}