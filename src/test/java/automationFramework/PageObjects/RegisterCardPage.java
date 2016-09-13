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

public class RegisterCardPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String CARD_SERIAL_NUMBER = "//*[@id='divCardRegisteredSubmit']/div/div[2]/div[4]/div/input";
		private static final String CVV = "//*[@id='divCardRegisteredSubmit']/div/div[2]/div[5]/div/input";
		private static final String MONTH = "//*[@id='CT_Main_1_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_1_drpPaymentExpireYear']";
		private static final String NICKNAME= "//*[@id='divCardRegisteredSubmit']/div/div[2]/div[7]/div/input";
		private static final String NEXTSTEP = "//*[@id='divCardRegisteredSubmit']/div/div[2]/p/a[2]";
		private static final String SUBMIT = "//*[@id='divSubmitStep']/div[2]/p/a[2]";
		private static final String REGISTER_CONFIRMAION = "//*[@id='main']/div[2]/section/div[2]/div[5]/div/h1";
		
		
	public RegisterCardPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCardSerialNumber(WebDriver driver, String number) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CARD_SERIAL_NUMBER)).sendKeys(number);
	}
	
	public void enterCvv(WebDriver driver, String cvv) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CVV)).sendKeys(cvv);
	}

	public void enterNickName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NICKNAME)).sendKeys(name);
	}
	
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(12);
	}
	
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(2);
	}
	
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
	public String getRegistrationConfimration(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(REGISTER_CONFIRMAION)).getText();
	}
	
	
}