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

public class EmployerDetailsPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String NEXTSTEP = "//*[@id='divPersonalInformation']/div[3]/p/a[2]";	
		private static final String COMPANY_NAME = "//*[@id='divPersonalInformation']/div[1]/div[3]/div[1]/input";
		private static final String COMPANY_SITE = "//*[@id='divPersonalInformation']/div[1]/div[3]/div[2]/input";
		private static final String CONTACT_NAME = "//*[@id='divPersonalInformation']/div[1]/div[4]/div[1]/input";
		private static final String FEIN = "//*[@id='divPersonalInformation']/div[1]/div[4]/div[2]/input";
		private static final String EMAIL = "//*[@id='divPersonalInformation']/div[1]/div[6]/div[1]/input";
		private static final String CONFIRM_EMAIL = "//*[@id='divPersonalInformation']/div[1]/div[6]/div[2]/input";
		private static final String PHONE = "//*[@id='divPersonalInformation']/div[1]/div[5]/div[1]/input";
		private static final String ADDRESS = "//*[@id='divPersonalInformation']/div[1]/div[7]/div[1]/input";
		private static final String ADDRESS2 = "//*[@id='divPersonalInformation']/div[1]/div[7]/div[2]/input";
		private static final String CITY = "//*[@id='divPersonalInformation']/div[1]/div[8]/div[1]/input";
		private static final String ZIP = "//*[@id='divPersonalInformation']/div[1]/div[8]/div[3]/input";
		private static final String BILLING_FNAME = "//*[@id='divPersonalInformation']/div[3]/div[2]/div[1]/input";
		private static final String BILLING_LNAME = "//*[@id='divPersonalInformation']/div[3]/div[2]/div[2]/input";
		private static final String BILLING_NUMBER = "//*[@id='divPersonalInformation']/div[3]/div[3]/div/input";
		private static final String CONFIRM_ADDRESS_LINK = "//*[@id='divCorrectedAddresses']/div[2]/a/span";
	
	public EmployerDetailsPage(WebDriver driver) {
		super(driver);
	}
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void enterCompanyName(WebDriver driver, String companyName) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(COMPANY_NAME)).click();
		driver.findElement(By.xpath(COMPANY_NAME)).sendKeys(companyName);
	}
	
	public void enterCompanySite(WebDriver driver, String companySite) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(COMPANY_SITE)).click();
		driver.findElement(By.xpath(COMPANY_SITE)).sendKeys(companySite);
	}
	
	public void enterContactname(WebDriver driver, String contactName) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONTACT_NAME)).click();
		driver.findElement(By.xpath(CONTACT_NAME)).sendKeys(contactName);
	}
	
	public void enterFein(WebDriver driver, String fein) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FEIN)).click();
		driver.findElement(By.xpath(FEIN)).sendKeys(fein);
	}

	public void enterEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(EMAIL)).click();
		driver.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public void enterConfirmEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONFIRM_EMAIL)).click();
		driver.findElement(By.xpath(CONFIRM_EMAIL)).sendKeys(email);
	}
	
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).click();
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void enterAddress(WebDriver driver, String address) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS)).click();
		driver.findElement(By.xpath(ADDRESS)).sendKeys(address);
	}
	
	public void enterAddress2(WebDriver driver, String address) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS2)).click();
		driver.findElement(By.xpath(ADDRESS2)).sendKeys(address);
	}
	
	public void enterCity(WebDriver driver, String city) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CITY)).click();
		driver.findElement(By.xpath(CITY)).sendKeys(city);
	}
	
	public void enterZip(WebDriver driver, String zip) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ZIP)).click();
		driver.findElement(By.xpath(ZIP)).sendKeys(zip);
	}
	
	public void enterBillingFname(WebDriver driver, String billingFname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(BILLING_FNAME)).click();
		driver.findElement(By.xpath(BILLING_FNAME )).sendKeys(billingFname);
	}
	

	public void enterBillingLname(WebDriver driver, String billingLname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(BILLING_LNAME)).click();
		driver.findElement(By.xpath(BILLING_LNAME )).sendKeys(billingLname);
	}
	
	public void enterBillingPhone(WebDriver driver, String billingNumber) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(BILLING_NUMBER)).click();
		driver.findElement(By.xpath(BILLING_NUMBER )).sendKeys(billingNumber);
	}
	
	public void clickConfirmAddress(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath( CONFIRM_ADDRESS_LINK)).click();
	}
}