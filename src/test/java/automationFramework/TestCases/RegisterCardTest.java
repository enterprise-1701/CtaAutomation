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

public class RegisterCardTest {

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
	public static void registerCard()throws Exception{
	
		BasePage bPage = new BasePage(driver);
		bPage.getLandingPage(Global.URL1);
		Utils.waitTime(3000);
        Robots.authenticationWindow();
    
        Utils.waitTime(3000);
		bPage.clickPopClose(driver);
		
		//Add additional wait time for card to be processed 
		Utils.waitTime(3000);
		bPage.clickAcctLogin(driver);
		
		bPage.enterUsername(driver, "rayk_09062016");
		//Log.info("User name to login to account " +  UserData.getUserName());
		bPage.enterPasswd(driver, Global.PASSWD);
		bPage.clickLogin(driver);
		Utils.waitTime(3000);
		
		AccountLandingPage landingPage = new AccountLandingPage(driver);
		landingPage.clickMyVentraCard(driver);
		AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
		vPage.clickRegister(driver);
		RegisterCardPage rPage = new RegisterCardPage(driver);
		rPage.enterCardSerialNumber(driver, "123344444");
		rPage.enterCvv(driver, "123");
		rPage.selectMonth(driver);
		rPage.selectYear(driver);
		rPage.enterNickName(driver, "test");
		rPage.clickNextStep(driver);
		Utils.waitTime(5000);
		rPage.clickSubmit(driver);
		Utils.waitTime(5000);
		Assert.assertEquals(rPage.getRegistrationConfimration(driver),  "Register Confirmation");
	}
	
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}
}