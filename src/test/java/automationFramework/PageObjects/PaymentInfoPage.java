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

public class PaymentInfoPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String CC = "//*[@id='divCreditCard']/div[2]/div[1]/input";
		private static final String NAME = "//*[@id='divCreditCard']/div[2]/div[2]/input";
		private static final String MONTH = "//*[@id='CT_Main_0_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_0_drpPaymentExpireYear']";
		private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[6]/div[6]/p/a[2]";
		
	public PaymentInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void enterCC(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC)).click();
		driver.findElement(By.xpath(CC)).sendKeys(cc);
	}
	
	public void enterName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAME)).click();
		driver.findElement(By.xpath(NAME)).sendKeys(name);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(2);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(2);
	}
		
}