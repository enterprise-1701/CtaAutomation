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

public class PaymentInfoPageTB extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String EMPLOYEE_NAME = "//*[@id='divBankAccount']/div[1]/div[1]/input";
		private static final String BANK_NAME = "//*[@id='divBankAccount']/div[1]/div[2]/input";
		private static final String ACCOUNT_NUMBER = "//*[@id='divBankAccount']/div[2]/div[1]/input";
		private static final String ROUTING_NUMBER = "//*[@id='divBankAccount']/div[2]/div[2]/input";
		private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[5]/div[6]/p/a[2]";
		
	public PaymentInfoPageTB(WebDriver driver) {
		super(driver);
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void enterEmpName(WebDriver driver, String ename) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(EMPLOYEE_NAME)).click();
		driver.findElement(By.xpath(EMPLOYEE_NAME)).sendKeys(ename);
	}
	
	public void enterBankName(WebDriver driver, String bname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(BANK_NAME)).click();
		driver.findElement(By.xpath(BANK_NAME)).sendKeys(bname);
	}
	
	public void enterAcctNumber(WebDriver driver, String number) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACCOUNT_NUMBER)).click();
		driver.findElement(By.xpath(ACCOUNT_NUMBER)).sendKeys(number);
	}
	
	public void enterRoutingNumber(WebDriver driver, String rnumber) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ROUTING_NUMBER)).click();
		driver.findElement(By.xpath(ROUTING_NUMBER)).sendKeys(rnumber);
	}
		
}