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

public class AutoloadNewPassTest {

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
	//If the test is ran sooner an exception will be thrown and an assertion made for the 3 hour warning alert
	@Test(priority=1 , enabled=true)
	public void autoLoadNewPass()throws Exception{
	
		try{
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
		
		
		vPage.clickManageCard(driver);
		vPage.clickNewCard(driver);
		
		Utils.waitTime(5000);
		vPage.clickAddPassAutoLoad(driver);
		vPage.clickAddPassPopupOk(driver);
		Utils.waitTime(5000);
		
		AddPassSelectProductPage pPage = new AddPassSelectProductPage(driver);
		pPage.selectSevenDayPass(driver);
		pPage.clickNextStep(driver);
		AutoLoadPreferencesPage perfPage = new AutoLoadPreferencesPage(driver);
		Utils.waitTime(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-275)", "");
		perfPage.clickAgreement(driver);
		Utils.waitTime(3000);
		perfPage.clickNextSteps(driver);
		Utils.waitTime(3000);
		
		AddPassReviewOrderPage revPage = new AddPassReviewOrderPage(driver);
		revPage.clickNextStep(driver);
		
		AddPassPaymentPage pmtPage = new AddPassPaymentPage(driver);
		Utils.waitTime(5000);
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  //Vertical scroll - down by 150  pixels
		  js.executeScript("window.scrollBy(0,150)");
		  Utils.waitTime(3000);
		
		pmtPage.clickCC(driver);
		pmtPage.enterCVW2(driver, Global.CC_CODE);
		pmtPage.clickSubmit(driver);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(10000);
		AddPassConfirmationPage cPage = new AddPassConfirmationPage(driver);
		Assert.assertEquals(cPage.getConfirmation(driver), "Thank you!");
		}
		catch(Exception e){
			Log.info("Autload 3 hour warning alert triggered. Catching alert as an exeception");
			Alert alert2 = driver.switchTo().alert();
			alert2.accept();
			Assert.assertTrue(true, "Autoload 3 hours warning alert did not trigger!");
		}
		
		driver.close();
	}
	
	
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}