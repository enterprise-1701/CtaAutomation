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

public class ForgotUsernameTest {

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
	public void forgotUsername()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
        Robots.authenticationWindow();
    
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		Utils.waitTime(3000);
		bPage.clickAcctLogin(driver);
		bPage.clickForgotUsername(driver);
		ForgotUsernamePage fPage = new ForgotUsernamePage(driver);
		fPage.enterEmail(driver, UserData.getEmail());
		fPage.clickSubmit(driver);
		Utils.waitTime(3000);
		Assert.assertEquals(fPage.getConfirmation(driver), Global.CONFIRMATION);
		Log.info("Actual results " +  fPage.getConfirmation(driver) + " matches " +  Global.CONFIRMATION);
		
		driver.close();
	}
	

		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}