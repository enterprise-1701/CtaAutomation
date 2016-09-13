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

public class ManagementConsoleTest {

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
	public void activateCard()throws Exception{
	
		ManagementConsolePage mcPage = new ManagementConsolePage(driver);
		mcPage.getLandingPage(Global.URL2);
		Utils.waitTime(3000);
        
	    mcPage.enterUserId(driver, "sysadmin");
	    mcPage.enterPasswd(driver, "password");
	    mcPage.clickLogin(driver);
	    mcPage.clickAccountsTab(driver);
	    
	    //Get dynamically generated account number from previous tests
	    mcPage.enterAccount(driver, UserData.getAccountNumber());
	    mcPage.clickSearch(driver);
	    mcPage.clickToken(driver);
	    mcPage.clickActivate(driver);
    
	    Utils.waitTime(5000);
	    mcPage.clickLogout(driver);
      
		driver.close();
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}