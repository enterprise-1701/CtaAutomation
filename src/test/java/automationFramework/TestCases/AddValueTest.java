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

public class AddValueTest {

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
	public void addValue()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
		
		//if(!(bPage.isLogDisplayed(driver))){
	    //Log.info("Authentication Popup is Displayed!");
        Robots.authenticationWindow();
		//}else{
		//	Log.info("Authentication Popup is NOT Displayed!");
		//}
        
		
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
		
		Assert.assertEquals(vPage.getUserName(driver),  "raycard");
		Log.info("Actual results " +  vPage.getUserName(driver) + " matches " +  "raycard");
		
		vPage.clickAddValue(driver);
		Utils.waitTime(3000);
		
		AddValueSelectProductPage addPage = new AddValueSelectProductPage(driver);
		addPage.selectAmount(driver);
		addPage.clickNextStep(driver);
		Utils.waitTime(3000);
		
		AddValueReviewOrderPage revPage = new AddValueReviewOrderPage(driver);
		revPage.clickNextStep(driver);
		Utils.waitTime(3000);
		
		AddValuePaymentPage pmtPage = new AddValuePaymentPage(driver);
		pmtPage.enterCVW(driver, Global.CC_CODE);
		pmtPage.clickSubmit(driver);
		Utils.waitTime(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(10000);
		
		
		AddPassConfirmationPage cPage = new AddPassConfirmationPage(driver);
		Assert.assertEquals(cPage.getConfirmation(driver), "Thank you!");
	    
		
		driver.close();
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}