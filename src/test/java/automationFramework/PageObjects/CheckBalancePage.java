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

public class CheckBalancePage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String SERIAL_NUMBER = "//*[@id='divCardInfo']/div[2]/div/input";	
		private static final String MONTH = "//*[@id='CT_Main_0_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_0_drpPaymentExpireYear']";
		private static final String SUBMIT = "//*[@id='divCardInfo']/div[3]/div/a";
		private static final String TRANSIT_ID =  "//*[@id='main']/div[2]/section/div[2]/div[1]/div/div[2]/span[1]";
		private static final String STATUS = "//*[@id='main']/div[2]/section/div[2]/div[1]/div/div[2]/span[2]";
		private static final String BALANCE = "//*[@id='main']/div[2]/section/div[2]/div[2]/div/div[3]/span";
	
	public CheckBalancePage(WebDriver driver) {
		super(driver);
	}
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
	public void enterCardNumber(WebDriver driver, String sNumber) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SERIAL_NUMBER)).click();
		driver.findElement(By.xpath(SERIAL_NUMBER)).sendKeys(sNumber);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(12);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(3);
	}
	
	public String getTransitID(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(TRANSIT_ID)).getText();
	}
	
	public String getStatus(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(STATUS)).getText();
	}
	
	public String getBalance(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(BALANCE)).getText();
	}

}