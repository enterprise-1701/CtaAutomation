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

public class GroupAccountPaymentInfoPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String ADD_FUNDING_SOURCE = "//*[@id='divBillingInfos']/div[3]/button";	
		private static final String SAVE_CC = "//*[@id='divBillingInfoDetails']/div[2]/div[1]/div[2]/div/input";
		private static final String CC = "//*[@id='divBillingInfoDetails']/div[2]/div[1]/div[3]/div[2]/div[1]/input";
		private static final String NAME = "//*[@id='divBillingInfoDetails']/div[2]/div[1]/div[3]/div[2]/div[2]/input";
		private static final String MONTH = "//*[@id='CT_Main_0_drpPaymentExpireMonth']";
		private static final String YEAR =  "//*[@id='CT_Main_0_drpPaymentExpireYear']";
		private static final String EDIT =  "//*[@id='divBillingInfos']/div[1]/div/div[5]/button";
		private static final String FNAME =   "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[1]/div[1]/input";
		private static final String LNAME =   "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[1]/div[2]/input";
	    private static final String PHONE =   "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[2]/div/input";
		private static final String ADDRESS =   "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[3]/div[1]/input";
		private static final String ADDRESS2 =  "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[3]/div[2]/input";
		private static final String CITY =  "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[4]/div[1]/input";
		private static final String ZIP =  "//*[@id='divBillingInfoDetails']/div[2]/div[3]/div[4]/div[3]/input";
		private static final String SAVE = "//*[@id='divBillingInfoDetails']/div[2]/div[4]/div/div/button";
		private static final String SAVE_ACH = "//*[@id='divBillingInfoDetails']/div[2]/div[2]/div[1]/div/input";
		private static final String ACCOUNT_NO = "//*[@id='divBillingInfoDetails']/div[2]/div[2]/div[2]/div/div[1]/input";
		private static final String ROUTING_NO = "//*[@id='divBillingInfoDetails']/div[2]/div[2]/div[2]/div/div[2]/input";
		private static final String NAME_ACCOUNT = "//*[@id='divBillingInfoDetails']/div[2]/div[2]/div[2]/div/div[3]/input";
		private static final String NAME_BANK = "//*[@id='divBillingInfoDetails']/div[2]/div[2]/div[2]/div/div[4]/input";
		
		
	public GroupAccountPaymentInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddFundingSource(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADD_FUNDING_SOURCE)).click();
	}
	
	public void clickSaveCCInfo(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SAVE_CC)).click();
	}
	
	public void clickSaveACHInfo(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SAVE_ACH)).click();
	}
	
	public void clickSave(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SAVE)).click();
	}
	
	public void clickEdit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(EDIT)).click();
	}
	
	public void enterCCNumber(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC)).clear();
		driver.findElement(By.xpath(CC)).sendKeys(cc);
	}
	
	public void enterName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAME)).clear();
		driver.findElement(By.xpath(NAME)).sendKeys(name);
	}
	
	public void enterFname(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FNAME)).clear();
		driver.findElement(By.xpath(FNAME)).sendKeys(name);
	}
	
	public void enterLname(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LNAME)).clear();
		driver.findElement(By.xpath(LNAME)).sendKeys(name);
	}
	
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).click();
		driver.findElement(By.xpath(PHONE)).clear();
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void enterAddress(WebDriver driver, String address) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS)).clear();
		driver.findElement(By.xpath(ADDRESS)).sendKeys(address);
	}
	
	public void enterAddress2(WebDriver driver, String address2) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS2)).clear();
		driver.findElement(By.xpath(ADDRESS2)).sendKeys(address2);
	}
	
	public void enterCity(WebDriver driver, String city) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CITY)).clear();
		driver.findElement(By.xpath(CITY)).sendKeys(city);
	}
	
	public void enterZip(WebDriver driver, String zip) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ZIP)).sendKeys(zip);
	}
	
	public void enterAccountNo(WebDriver driver, String accountNo) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACCOUNT_NO)).clear();
		driver.findElement(By.xpath(ACCOUNT_NO)).sendKeys(accountNo);
	}
	
	public void enterRoutingNo(WebDriver driver, String routingNo) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ROUTING_NO)).clear();
		driver.findElement(By.xpath(ROUTING_NO)).sendKeys(routingNo);
	}
	
	public void enterNameOnAccount(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAME_ACCOUNT)).clear();
		driver.findElement(By.xpath(NAME_ACCOUNT)).sendKeys(name);
	}
	
	public void enterBankName(WebDriver driver, String bankName) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAME_BANK)).clear();
		driver.findElement(By.xpath(NAME_BANK)).sendKeys(bankName);
	}
	
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(3);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(3);
	}
	
}