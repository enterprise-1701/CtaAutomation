package automationFramework.TestCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
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

import automationFramework.PageObjects.AccountLandingPage;
import automationFramework.PageObjects.AccountVentraCardPage;
import automationFramework.PageObjects.AddPassConfirmationPage;
import automationFramework.PageObjects.AddValuePaymentPage;
import automationFramework.PageObjects.AddValueReviewOrderPage;
import automationFramework.PageObjects.AddValueSelectProductPage;
import automationFramework.PageObjects.BasePage;
import automationFramework.PageObjects.ConfirmationPageVC;
import automationFramework.PageObjects.PaymentInfoPageVC;
import automationFramework.PageObjects.PurchasePage;
import automationFramework.PageObjects.RegisterTransitAcctPage;
import automationFramework.PageObjects.ReviewOrderPage;
import automationFramework.Utilities.CreditCardNumberGenerator;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Logging;
import automationFramework.Utilities.Robots;
import automationFramework.Utilities.UserData;
import automationFramework.Utilities.Utils;

public class EmailTest{
	
	 private String host = "bb-corp-cas01.corp.cubic.cub";
     private String username = "cts.systemtest";
     private String password = "gd6N6MCkCdDa9Rc##";
     private String folder = "Inbox/Cta";
     private static Logger Log = Logger.getLogger(Logger.class.getName());
     static WebDriver driver;
	
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
	public void checkEmailAddValueTest() throws Exception{

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
		
		Assert.assertEquals(vPage.getUserName(driver),  "card1");
		Log.info("Actual results " +  vPage.getUserName(driver) + " matches " +  "card1");
		
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
		
		Log.info("Waiting for email to get generated" );
	    Utils.waitTime(180000);
		
		Properties props = System.getProperties();               
	      props.put("mail.imaps.auth.plain.disable","true"); 
	           try {
	                Session session = Session.getDefaultInstance(props, null);
	                Store store = session.getStore("imaps");
	                store.connect(host, 993, username, password);
	                Folder inbox = store.getFolder(folder);
	                inbox.open(Folder.READ_ONLY);        
	                Log.info("Number of new emails: " + inbox.getUnreadMessageCount());
	                Assert.assertTrue((inbox.getUnreadMessageCount()>0), ("Email Not Received!"));
	                Message messages[] = inbox.getMessages();
	                Log.info("Total number of emails: " + inbox.getMessages().length);	
	                String newSubject = messages[inbox.getMessages().length-1].getSubject();
	                Log.info("Email subject For last received email: " + newSubject);
	                
	                String newContent = (String) messages[inbox.getMessages().length-1].getContent();
	                Log.info("EMAIL CONTENT: " + newContent);
	                Assert.assertTrue(Utils.findAuthorizationNumber(newContent), "Authroization Number is Missing on the Email!"); 
	                Assert.assertEquals(newSubject, "Ventra Order Receipt");  
	                Log.info("Email Test Compelted");
	                
	           }  catch (Exception e) {
	           e.printStackTrace();
	           //System.exit(2);
	      }
			
	}
	
	
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
	
}