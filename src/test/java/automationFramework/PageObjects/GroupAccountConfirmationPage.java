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

public class GroupAccountConfirmationPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String NAME = "//*[@id='divBillingInfos']/div[1]/div/div[1]/span[1]";	
		private static final String CC = "//*[@id='divBillingInfos']/div[1]/div/div[1]/span[3]";
		private static final String HEADING = "//*[@id='main']/div[2]/section/div/div[2]/h1";
		private static final String MASKED_ACCOUNT_NO = "//*[@id='divBillingInfos']/div[1]/div/div[2]/span[4]";
		private static final String BANK_NAME = "//*[@id='divBillingInfos']/div[1]/div/div[2]/span[1]";
		private static final String ROUTING_NO = "//*[@id='divBillingInfos']/div[1]/div/div[2]/span[3]";
		private static final String MASKED_ACCOUNT_NO2 = "//*[@id='divBillingInfos']/div[1]/div/div[2]/span[4]";
		private static final String PHONE = "//*[@id='divBillingInfos']/div[1]/div/div[3]/span[4]";
		private static final String ADDRESS = "//*[@id='divBillingInfos']/div[1]/div/div[3]/span[2]";
		private static final String CITY_STATE = "//*[@id='divBillingInfos']/div[1]/div/div[3]/span[3]";
											
		
	public GroupAccountConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public String getName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(NAME)).getText();
	}
	
	public String getCC(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CC)).getText();
	}
	
	public String getHeading(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(HEADING)).getText();
	}
	
	public String getMaskedAccountNo(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(MASKED_ACCOUNT_NO)).getText();
	}
	
	public String getBankName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(BANK_NAME)).getText();
	}
	
	public String getRoutingNo(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(ROUTING_NO)).getText();
	}
	
	public String getMaskedAccountNo2(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(MASKED_ACCOUNT_NO2)).getText();
	}
	
	public String getPhone(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(PHONE)).getText();
	}
	
	public String getAddress(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(ADDRESS)).getText();
	}
	
	public String getCityState(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CITY_STATE)).getText();
	}
}