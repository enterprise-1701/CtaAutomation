package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Utils;

public class ConfirmationPageTB extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String FNAME = "//*[@id='BillingInfo']/div[1]/div[2]/div";	
		//*[@id="BillingInfo"]/div[1]/div[2]/div
		
		private static final String LNAME = "//*[@id='BillingInfo']/div[2]/div[2]/div";
		
		//*[@id="BillingInfo"]/div[2]/div[2]/div
		private static final String PHONE = "//*[@id='BillingInfo']/div[3]/div[2]/div";
		private static final String FEIN =  "//*[@id='BillingInfo']/div[4]/div[2]/div";
		private static final String EMAIL = "//*[@id='BillingInfo']/div[5]/div[2]/div";
		private static final String ADDRESS = "//*[@id='BillingInfo']/div[7]/div[1]/div[2]/div";
		private static final String ADDRESS2 = "//*[@id='BillingInfo']/div[7]/div[2]/div[2]/div";
		private static final String CITY = "//*[@id='BillingInfo']/div[7]/div[3]/div[2]/div";
		private static final String STATE = "//*[@id='BillingInfo']/div[7]/div[4]/div[2]/div";
		private static final String ZIP = "//*[@id='BillingInfo']/div[7]/div[5]/div[2]/div";
		private static final String EMPLOYER_NAME = "//*[@id='PaymentInfo']/div[2]/div[1]/div[2]/div";
		private static final String BANK_NAME = "//*[@id='PaymentInfo']/div[2]/div[2]/div[2]/div";
		private static final String ACCOUNT_NUMBER = "//*[@id='PaymentInfo']/div[2]/div[3]/div[2]/div";
		private static final String ROUTING_NUMBER = "//*[@id='PaymentInfo']/div[2]/div[4]/div[2]/div";
		private static final String CONFIRMATION = "//*[@id='main']/div[2]/section/div[1]/div[7]/div[1]/h1";
													
		public ConfirmationPageTB(WebDriver driver) {
			super(driver);
		}
		
		public String getFname(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(FNAME)).getText();	
		}
		
		public String getLname(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(LNAME)).getText();	
		}
		
		public String getPhone(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(PHONE)).getText();	
		}
		
		public String getFein(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(FEIN)).getText();	
		}
		
		public String getEmail(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(EMAIL)).getText();	
		}
		
		public String getAddress(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ADDRESS)).getText();	
		}
		
		public String getAddress2(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ADDRESS2)).getText();	
		}
		
		public String getCity(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CITY)).getText();	
		}
		
		public String getState(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(STATE)).getText();	
		}
		
		public String getZip(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ZIP)).getText();	
		}
		
		public String getEmployerName(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(EMPLOYER_NAME)).getText();	
		}
		
		public String getBankName(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(BANK_NAME)).getText();	
		}
		
		public String getAcctNumber(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ACCOUNT_NUMBER)).getText();	
		}
		
		public String getRoutingNumber(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ROUTING_NUMBER)).getText();	
		}
		
		public String getConfirmation(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CONFIRMATION)).getText();	
		}
	
}