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

public class ConfirmationPageVC extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	    // Element Locators
		private static final String CC_NUMBER = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[7]/p/span[3]";
		private static final String CC_NAME = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[7]/p/span[2]";
		private static final String PAYMENT_AUTHORIZATION = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[1]/p[1]/span[2]";
		private static final String ORDER_NUMBER =  "//*[@id='main']/div[2]/section/div[1]/div[6]/div[1]/p[1]/span[1]";
		private static final String CONFIRMATION = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[1]/h1";
		private static final String PAYMENT_METHOD = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[7]/p";
		private static final String NAME =  "//*[@id='main']/div[2]/section/div[1]/div[6]/div[4]/p[2]/span[1]";
		private static final String BILLING_ADDRESS = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[4]/p[2]/span[2]";
		private static final String BILLING_CITY = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[4]/p[2]/span[3]";
		private static final String ORDER_TOTAL = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[5]/div[2]/div/div/div[4]/ul/li[4]/span";
		private static final String ORDER_SUBTOTAL = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[5]/div[2]/div/div/div[4]/ul/li[1]/span";
													
		public ConfirmationPageVC(WebDriver driver) {
			super(driver);
		}
		
		public String getCCNumber(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CC_NUMBER)).getText();	
		}
		
		public String getCCName(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CC_NAME)).getText();	
		}
		
		public String getName(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(NAME)).getText();	
		}
		
		public String getConfirmation(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CONFIRMATION)).getText();	
		}
		
		public String getPaymentMethod(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(PAYMENT_METHOD)).getText();	
		}
		
		public String getBillingAddress(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(BILLING_ADDRESS)).getText();	
		}
		
		public String getBillingCity(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(BILLING_CITY)).getText();	
		}
		
		public String getOrderTotal(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ORDER_TOTAL)).getText();	
		}
		
		public String getOrderSubTotal(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ORDER_SUBTOTAL)).getText();	
		}
		
		public boolean isOrderNumberDisplayed(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(ORDER_NUMBER)).isDisplayed();
			}
		
		public boolean isPaymentAuthorizationDisplayed(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(PAYMENT_AUTHORIZATION)).isDisplayed();
			}
}