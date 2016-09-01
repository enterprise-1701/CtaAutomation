package automationFramework.TestCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
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
	

	@Test(priority=1 , enabled=true)
	public void loadValueGroupSales()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL0);
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
	
		CompanyDetailsPage cPage = new CompanyDetailsPage(driver);
		cPage.enterCompanyName(driver, Utils.randomCompanyname());
		cPage.enterCompanySite(driver, Global.COMPANY_SITE);
		cPage.enterContactname(driver, Global.CONTACT_NAME);
		cPage.enterFein(driver, Global.FEIN);
		cPage.enterEmail(driver, Global.EMAIL);
		cPage.enterConfirmEmail(driver, Global.EMAIL);
		cPage.enterPhone(driver, Global.PHONE);
		cPage.enterAddress(driver, Global.ADDRESS);
		cPage.enterAddress2(driver, Global.ADDRESS2);
		cPage.enterCity(driver, Global.CITY);
		cPage.enterZip(driver, Global.ZIP);
		cPage.enterBillingFname(driver, Global.CONTACT_NAME);
		cPage.enterBillingLname(driver, Global.CONTACT_NAME);
		cPage.enterBillingPhone(driver, Global.PHONE);
		cPage.clickNextStep(driver);
		Utils.waitTime(5000);
	
		AdminDetailsPage admPage = new AdminDetailsPage(driver);
		admPage.enterUserName(driver, Utils.randomUsernameString());
		admPage.enterPasswd(driver, Global.PASSWD);
		admPage.enterConfirmPasswd(driver, Global.PASSWD);
		admPage.selectSecurityQ(driver);
		admPage.enterAnswer(driver, Global.ANSWER);
		admPage.clickNextStep(driver);
		Utils.waitTime(3000);
	
		PaymentInfoPage payPage = new PaymentInfoPage(driver);
		
		CreditCardNumberGenerator ccGen = new CreditCardNumberGenerator();
		String cc = ccGen.generate("4", 16);
		
		payPage.enterCC(driver, cc);
		payPage.enterName(driver, Global.CONTACT_NAME);
		payPage.selectMonth(driver);
		payPage.selectYear(driver);
		payPage.clickNextStep(driver);
		Utils.waitTime(5000);
	
		AgreementPage agreePage = new AgreementPage(driver);
		agreePage.clickAgreement(driver);
		agreePage.clickSubmit(driver);
		Utils.waitTime(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(10000);
	
		ConfirmationPage confPage = new ConfirmationPage(driver);
    
		//13 different assertions 
		Assert.assertEquals(confPage.getFname(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getFname(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(confPage.getLname(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getLname(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(Utils.getPhoneNumber(confPage.getPhone(driver)),  Global.PHONE);
		Log.info("Actual results " +  confPage.getPhone(driver) + " matches " +  Global.PHONE);
	
		Assert.assertEquals(confPage.getFein(driver),  Global.FEIN);
		Log.info("Actual results " +  confPage.getFein(driver) + " matches " +  Global.FEIN);
	
		Assert.assertEquals(confPage.getEmail(driver),  Global.EMAIL);
		Log.info("Actual results " +  confPage.getEmail(driver) + " matches " +  Global.EMAIL);
	
		Assert.assertEquals(confPage.getAddress(driver),  Global.ADDRESS);
		Log.info("Actual results " +  confPage.getAddress(driver) + " matches " +  Global.ADDRESS);
	
		Assert.assertEquals(confPage.getAddress2(driver),  Global.ADDRESS2);
		Log.info("Actual results " +  confPage.getAddress2(driver) + " matches " +  Global.ADDRESS2);
	
		Assert.assertEquals(confPage.getCity(driver),  Global.CITY);
		Log.info("Actual results " +  confPage.getCity(driver) + " matches " +  Global.CITY);
	
		Assert.assertEquals(confPage.getZip(driver),  Global.ZIP);
		Log.info("Actual results " +  confPage.getZip(driver) + " matches " +  Global.ZIP);
	
		Assert.assertEquals(confPage.getCCType(driver),  Global.CCTYPE);
		Log.info("Actual results " +  confPage.getCCType(driver) + " matches " +  Global.CCTYPE);
	
		Assert.assertEquals(confPage.getCCName(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getCCName(driver) + " matches " +  Global.CONTACT_NAME);
	
		//Assert.assertEquals(confPage.getCCNumber(driver),  Global.CC_MASKED);
		//Log.info("Actual results " +  confPage.getCCNumber(driver) + " matches " +  Global.CC_MASKED);
	
		Assert.assertEquals(confPage.getConfirmation(driver),  Global.CONFIRMATION);
		Log.info("Actual results " +  confPage.getConfirmation(driver) + " matches " +  Global.CONFIRMATION);
		driver.close();
	
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}