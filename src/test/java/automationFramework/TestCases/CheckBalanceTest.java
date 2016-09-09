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

public class CheckBalanceTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
	static String browser;
	
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
	public void checkBalance()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
        Robots.authenticationWindow();
    
        Utils.waitTime(3000);
		//bPage.clickPopClose(driver);
		driver.navigate().refresh();
		bPage.clickCheckBalance(driver);
		CheckBalancePage cbPage = new CheckBalancePage(driver);
		cbPage.enterCardNumber(driver, Global.CARD_SERIAL_NUMBER);
		cbPage.selectMonth(driver);
		cbPage.selectYear(driver);
		cbPage.clickSubmit(driver);
		
		Utils.waitTime(3000);
		Assert.assertEquals(cbPage.getTransitID(driver), Global.TRANSIT_ID);
		Log.info("Actual results " + cbPage.getTransitID(driver)  + " matches " +  Global.TRANSIT_ID);
		
		Assert.assertEquals(cbPage.getStatus(driver), Global.STATUS);
		Log.info("Actual results " + cbPage.getStatus(driver)  + " matches " +  Global.STATUS);
		
		Assert.assertEquals(cbPage.getBalance(driver), Global.BALANCE);
		Log.info("Actual results " + cbPage.getBalance(driver)  + " matches " +  Global.BALANCE);
		
		driver.close();
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}