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

public class PaymentInfoPageVC extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String CC_NUMBER = "//*[@id='divSubmitStep']/div[1]/div[3]/div[1]/input";
		private static final String SECURITY_CODE = "//*[@id='divSubmitStep']/div[1]/div[3]/div[2]/input";
		private static final String CC_NAME = "//*[@id='divSubmitStep']/div[1]/div[4]/div[1]/input";
		
		private static final String MONTH = "//*[@id='CT_Main_0_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_0_drpPaymentExpireYear']";
		private static final String SUBMIT = "//*[@id='divSubmitStep']/div[2]/p/a[2]/img";
		private static final String HEADING = "//*[@id='divPaymentInformation']/div[1]/h1";
		
	public PaymentInfoPageVC(WebDriver driver) {
		super(driver);
	}
	
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
	public void enterCC(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC_NUMBER)).click();
		driver.findElement(By.xpath(CC_NUMBER)).sendKeys(cc);
	}
	
	public void enterSecurityCode(WebDriver driver, String code) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SECURITY_CODE)).click();
		driver.findElement(By.xpath(SECURITY_CODE)).sendKeys(code);
	}
	
	public void enterCCName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC_NAME)).click();
		driver.findElement(By.xpath(CC_NAME)).sendKeys(name);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(2);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(2);
	}
	
	public String getHeading(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(HEADING)).getText();
	}
		
}