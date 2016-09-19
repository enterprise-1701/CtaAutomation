package automationFramework.TestCases;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automationFramework.PageObjects.*;
import automationFramework.Utilities.*;


public class AddPassTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
	static String browser;
	private static String newCard;
	CreditCardNumberGenerator ccGen = new CreditCardNumberGenerator();
	
	
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
	public void addPass()throws Exception{
	
		try{
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
		
		}
		
		//If the element on the page is not indicates card has reached maxium number of passes
		//be spcific on exception
		catch(Exception e){
			
			Log.info("Exception caught");
			registerNewCard();
			
			//Add one time pass with the new card
			AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
			vPage.clickAddPass(driver);
			Utils.waitTime(3000);
			
			AddPassSelectProductPage addPage = new AddPassSelectProductPage(driver);
			addPage.selectOneDayPass(driver);
			
			addPage.clickNextStep(driver);
			Utils.waitTime(3000);
			
			AddPassReviewOrderPage revPage = new AddPassReviewOrderPage(driver);
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
			Utils.waitTime(5000);
			AddPassConfirmationPage cPage = new AddPassConfirmationPage(driver);
			Assert.assertEquals(cPage.getConfirmation(driver), "Thank you!");
		}
		
		driver.close();
		
	}
	
	//These two private methods are only called if existing card has reached the maxium number of passes
	private void registerNewCard() throws Exception{
		
		//Get the next card from the list
		newCard = Utils.getNewCard();
		
		//If the list does not return null then register the card and change the card
		if(newCard != null){
		Log.info("New Card retreived: " + newCard);
		
		//Register the new card
		AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
		vPage.clickRegister(driver);
		Log.info("Registering a new card:  " + newCard);
		RegisterCardPage rPage = new RegisterCardPage(driver);
		rPage.enterCardSerialNumber(driver, newCard);
		rPage.enterCvv(driver, "123");
		rPage.selectMonth(driver);
		rPage.selectYear(driver);
		UserData.setNickName("mycard" + IOFile.getIndex());
		Log.info("New user name:  " + UserData.getNickName());
		rPage.enterNickName(driver, UserData.getNickName());
		rPage.clickNextStep(driver);
		Utils.waitTime(3000);
		rPage.clickSubmit(driver);
		Utils.waitTime(3000);
		changeCards();
		
		}
		//This is the condition when system runs out of valid cards and test fails
		else{
			Log.error("System ran out of card numbers.  Update input file with new cards");
			Assert.assertFalse(true, "System ran out of card numbers" );
		}
		
	}
	
	//Change the default card to the new registered card
	private void changeCards()throws Exception{
	
		Log.info("Entering changeCards method");
		AccountVentraCardPage vPage = new AccountVentraCardPage(driver);
		Utils.waitTime(3000);
		vPage.clickMyAccount(driver);
		vPage.clickMyVentraCards(driver);
	
		Log.info("Username displayed: " + vPage.getUserName(driver));
		
		//If the username is not the latest card registered based on nickname
		if(!vPage.getUserName(driver).equals(UserData.getNickName())){
			vPage.clickManageCard(driver);
			Utils.waitTime(3000);
			vPage.clickTabManageCard(driver, 1);
			Utils.waitTime(3000);
		}
		else{
			Log.info("Nickname on the page is the same nickname as the latest card registered");
		}
	}
		
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
			driver.quit();

	}
}