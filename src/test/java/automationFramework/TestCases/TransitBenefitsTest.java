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

public class TransitBenefitsTest {

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
	public void enterEmployerDetails()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL0);
		Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		Utils.waitTime(3000);
		bPage.clickTransitBenefits(driver);
		Utils.waitTime(3000);
	

		ProgramDetailsPage dPage = new ProgramDetailsPage(driver);
		dPage.clickNextStep(driver);
		Utils.waitTime(3000);
		
		EmployerDetailsPage ePage = new EmployerDetailsPage(driver);
		ePage.enterCompanyName(driver, Utils.randomCompanyname());
		ePage.enterCompanySite(driver, Global.COMPANY_SITE);
		ePage.enterContactname(driver, Global.CONTACT_NAME);
		ePage.enterFein(driver, Global.FEIN);
		ePage.enterEmail(driver, Global.EMAIL);
		ePage.enterConfirmEmail(driver, Global.EMAIL);
		ePage.enterPhone(driver, Global.PHONE);
		ePage.enterAddress(driver, Global.ADDRESS);
		ePage.enterAddress2(driver, Global.ADDRESS2);
		ePage.enterCity(driver, Global.CITY);
		ePage.enterZip(driver, Global.ZIP);
		ePage.enterBillingFname(driver, Global.CONTACT_NAME);
		ePage.enterBillingLname(driver, Global.CONTACT_NAME);
		ePage.enterBillingPhone(driver, Global.PHONE);
		ePage.clickNextStep(driver);
		Utils.waitTime(5000);
	
		AdminDetailsPageTB admPage = new AdminDetailsPageTB(driver);
		admPage.enterUserName(driver, Utils.randomUsernameString());
		admPage.enterPasswd(driver, Global.PASSWD);
		admPage.enterConfirmPasswd(driver, Global.PASSWD);
		admPage.selectSecurityQ(driver);
		admPage.enterAnswer(driver, Global.ANSWER);
		admPage.clickNextStep(driver);
		Utils.waitTime(5000);
		
		PaymentInfoPageTB payPage = new PaymentInfoPageTB(driver);
		payPage.enterEmpName(driver, Global.CONTACT_NAME);
		payPage.enterBankName(driver, Global.BANKNAME);
		payPage.enterAcctNumber(driver, Global.ACCT_NUMBER);
		payPage.enterRoutingNumber(driver, Global.ROUTE_NUMBER);
		payPage.clickNextStep(driver);
		Utils.waitTime(5000);
	
		AgreementPageTB agreePage = new AgreementPageTB(driver);
		agreePage.clickAgreement(driver);
		agreePage.clickSubmit(driver);
		Utils.waitTime(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.waitTime(5000);
		
		//Assertions
		ConfirmationPageTB confPage = new ConfirmationPageTB(driver);
  
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
	
		Assert.assertEquals(confPage.getEmployerName(driver),  Global.CONTACT_NAME);
		Log.info("Actual results " +  confPage.getEmployerName(driver) + " matches " +  Global.CONTACT_NAME);
	
		Assert.assertEquals(confPage.getBankName(driver),  Global.BANKNAME);
		Log.info("Actual results " +  confPage.getBankName(driver) + " matches " +  Global.BANKNAME);
	
		Assert.assertEquals(confPage.getAcctNumber(driver),  Global.ACCT_NUMBER_MASKED);
		Log.info("Actual results " +  confPage.getAcctNumber(driver) + " matches " +  Global.ACCT_NUMBER_MASKED);
	
		Assert.assertEquals(confPage.getRoutingNumber(driver),  Global.ROUTE_NUMBER_MASKED);
		Log.info("Actual results " +  confPage.getRoutingNumber(driver) + " matches " +  Global.ROUTE_NUMBER_MASKED);
		
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