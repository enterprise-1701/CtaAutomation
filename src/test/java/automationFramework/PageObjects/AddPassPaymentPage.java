package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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

public class AddPassPaymentPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String NEWCARD = "//*[@id='ui-id-2']";
		private static final String CC = "//*[@id='newCard']/div[1]/div[3]/div[1]/input";
		private static final String CVW = "//*[@id='newCard']/div[1]/div[3]/div[2]/input";
		private static final String CLICK_CC = "//*[@id='savedCard']/ul/li[2]/label";
		//*[@id="savedCard"]/ul/li[3]/label/span[2]
		
		//This CVW is on autoload payment info page
		private static final String CVW2 = "//*[@id='savedCard']/div/div/input";
		

		private static final String CCNAME = "//*[@id='newCard']/div[1]/div[4]/div[1]/input";
		private static final String PHONE = "//*[@id='newCard']/div[1]/div[4]/div[2]/input";
		private static final String MONTH = "//*[@id='CT_Main_0_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_0_drpPaymentExpireYear']";
		private static final String FNAME = "//*[@id='newCard']/div[2]/div[1]/div[1]/input";
		private static final String LNAME = "//*[@id='newCard']/div[2]/div[1]/div[2]/input";
		private static final String ADDRESS1 = "//*[@id='newCard']/div[2]/div[2]/div[1]/input";
		private static final String ADDRESS2 = "//*[@id='newCard']/div[2]/div[2]/div[2]/input";
		private static final String CITY =  "//*[@id='newCard']/div[2]/div[3]/div[1]/input";
		private static final String ZIP =  "//*[@id='newCard']/div[2]/div[3]/div[3]/input";
		private static final String SUBMIT =  "//*[@id='divPayment']/div[9]/a[2]";
		
	
	public AddPassPaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEWCARD)).click();
	}
	
	public void enterCC(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC)).sendKeys(cc);
	}
	
	public void enterCVW(WebDriver driver, String cvw) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CVW)).sendKeys(cvw);
	}
	
	public void enterCVW2(WebDriver driver, String cvw) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CVW2)).sendKeys(cvw);
	}
	
	public void enterCCName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CCNAME)).sendKeys(name);
	}
	
	public void enterPhoneNumber(WebDriver driver, String number) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).sendKeys(number);
	}
	
	public void enterFirstName(WebDriver driver, String fname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FNAME)).sendKeys(fname);
	}
	
	public void enterLastName(WebDriver driver, String lname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LNAME)).sendKeys(lname);
	}
	
	public void enterAddress(WebDriver driver, String address) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS1)).sendKeys(address);
	}
	
	public void enterAddress2(WebDriver driver, String address2) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS2)).sendKeys(address2);
	}
	
	public void enterCity(WebDriver driver, String city) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CITY)).sendKeys(city);
	}
	
	public void enterZip(WebDriver driver, String zip) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ZIP)).sendKeys(zip);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(12);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(2);
	}
	
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
	public void clickCC(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CLICK_CC)).click();
	}
	
}