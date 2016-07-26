package automationFramework.TestCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automationFramework.DAO.PostgresAutomation;
import automationFramework.PageObjects.CreateCustomerPage;
import automationFramework.PageObjects.DashboardPage;
import automationFramework.PageObjects.NewCustomerPage;
import automationFramework.Utilities.*;

public class CreateCustomerDBTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private static String email;
	private static boolean contactRecordFound;
	private static boolean accountRecordFound;
	static WebDriver driver;
	static String browser;
	CoreTest coreTest = new CoreTest();
	
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
	public void createNewCustomerDBCheckContactTable() throws Exception{
	
		coreTest.signIn(driver);
	    coreTest.createCustomer(driver);  
	    email = coreTest.getEmail();
	    Log.info("Email being passed to DAO: " + email);
	    PostgresAutomation psAuto = new PostgresAutomation();
	    psAuto.dbConnect();
	    contactRecordFound = psAuto.dbFindCustomer(email);
	    psAuto.dbDisconnect();
	    Assert.assertTrue(contactRecordFound, "customer record was not found");
		driver.close();
		Log.info("createNewCustomerDBCheckContactTable Completed");
	    
	}
	
	@Test(priority=2 , enabled=true)
	public void createNewCustomerDBCheckAccountTable() throws Exception{
	
		coreTest.signIn(driver);
	    coreTest.createCustomer(driver);  
	    email = coreTest.getEmail();   
	    PostgresAutomation psAuto = new PostgresAutomation();
	    psAuto.dbConnect();
	    accountRecordFound = psAuto.dbFindAccount(email);
	    psAuto.dbDisconnect();
	    Assert.assertTrue(accountRecordFound, "account record was not found");
		driver.close();
		Log.info("createNewCustomerDBCheckAccountTable Completed");
		    
	}
	
	@Test(priority=3 , enabled=true)
	public void createNewCustomerDBCheckDuplicates() throws Exception{
		
		coreTest.signIn(driver);
	    coreTest.createCustomer(driver);  
	    email = coreTest.getEmail();   
	    PostgresAutomation psAuto = new PostgresAutomation();
	    psAuto.dbConnect();
	    accountRecordFound = psAuto.dbFindAccount(email);
	    psAuto.dbDisconnect();
	    Assert.assertTrue(accountRecordFound, "account record was not found");
		driver.close();
		Log.info("createNewCustomerDBCheckAccountTable Completed");
		    
	}
	
	
	@Test(priority=4 , enabled=true)
	public void createNewCustomerCancelDB() throws Exception{
	
		coreTest.signIn(driver);
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.getLandingPage(Global.URL1);
		dashPage.clickCustomerTab(driver);
		dashPage.switchToFrame(driver);
		CreateCustomerPage nPage = new CreateCustomerPage(driver);
		nPage.clickSwitch(driver);
		nPage.clickCreateCustomer(driver);
		nPage.clickCustomerMenu(driver);
		nPage.clickCreateCustomer(driver);
		nPage.clickCustomerType(driver, Global.CUSTOMERTYPE);
		nPage.enterFirstname(driver, Global.FNAME);
		nPage.enterLastname(driver, Global.LNAME);
		email = Utils.randomEmailString();
		nPage.enterEmail(driver, email);
		nPage.enterPhone(driver, Global.PHONE);
		nPage.clickContinue(driver);
		NewCustomerPage nPaget = new NewCustomerPage(driver);
		nPaget.clickCancel(driver);
		PostgresAutomation psAuto = new PostgresAutomation();
	    psAuto.dbConnect();
	    contactRecordFound  = psAuto.dbFindCustomer(email);
	    Assert.assertFalse(contactRecordFound , "customer record should not be created!");
	    psAuto.dbDisconnect();
		driver.close();
		Log.info("createNewCustomerCancelDB Completed");
		    
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Completed");
		Reporter.log("TearDown Completed");
		driver.quit();

	}
}