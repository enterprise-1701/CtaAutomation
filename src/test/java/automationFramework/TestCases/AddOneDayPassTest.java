package automationFramework.TestCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import automationFramework.DAO.DBAutomation;
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;

public class AddOneDayPassTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
	static String browser;
	CreditCardNumberGenerator ccGen = new CreditCardNumberGenerator();
	DBAutomation dbAuto = new DBAutomation();
	
	
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
	public void addOneDayPass()throws ElementNotVisibleException, ElementNotFoundException, NoSuchElementException, Exception{
	
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
		vPage.clickAddPass(driver);
		Utils.waitTime(3000);
		
		AddPassSelectProductPage addPage = new AddPassSelectProductPage(driver);
		addPage.selectOneDayPass(driver);
		addPage.clickNextStep(driver);
		Utils.waitTime(3000);
		
		AddPassReviewOrderPage revPage = new AddPassReviewOrderPage(driver);
		Assert.assertEquals(revPage.getCTADayPass(driver), "CTA 1-Day Pass");
		revPage.clickNextStep(driver);
		Utils.waitTime(3000);
		
		AddPassPaymentPage pmtPage = new AddPassPaymentPage(driver);
		pmtPage.clickNewCard(driver);
		pmtPage.enterCC(driver, ccGen.generate("4", 16));
		pmtPage.enterCVW(driver, Global.CC_CODE);
		pmtPage.enterCCName(driver, Global.CONTACT_NAME);
		pmtPage.enterPhoneNumber(driver, Global.PHONE);
		pmtPage.selectMonth(driver);
		pmtPage.selectYear(driver);
		pmtPage.enterFirstName(driver, Global.FNAME);
		pmtPage.enterLastName(driver, Global.LNAME);
		pmtPage.enterAddress(driver, Global.ADDRESS);
	    pmtPage.enterAddress2(driver, Global.ADDRESS2);
	    pmtPage.enterCity(driver, Global.CITY);
		pmtPage.enterZip(driver, Global.ZIP);
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
		Log.info("TearDown Initialized");
		//Deactivate pass
		dbAuto.dbConnect();
		boolean update = dbAuto.dbUpdateCard();
		Log.info("Card got updated? " + update);
		dbAuto.dbDisconnect();
		Log.info("DB connection closed. TearDown Completed");
	    driver.quit();
	}
}