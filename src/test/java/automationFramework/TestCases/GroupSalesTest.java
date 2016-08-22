package automationFramework.TestCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;

public class GroupSalesTest {

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
	

	@Test(enabled=true)
	public void groupSales()throws Exception{
	
	BasePage bPage = new BasePage(driver);
	bPage.getLandingPage(Global.URL1);
	Utils.waitTime(3000);
	bPage.clickPopClose(driver);
	Utils.waitTime(3000);
	bPage.clickGroupSales(driver);
	Utils.waitTime(3000);
	ProgramDetailsPage dPage = new ProgramDetailsPage(driver);
	dPage.clickNextStep(driver);
	Utils.waitTime(3000);
	AccountFeaturesPage aPage = new AccountFeaturesPage(driver);
	aPage.clickLoadValueCheckBox(driver);
	aPage.clickNextStep(driver);
	Utils.waitTime(3000);
	
	}
	

		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}