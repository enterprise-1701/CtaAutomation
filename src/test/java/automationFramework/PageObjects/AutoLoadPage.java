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

public class AutoLoadPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String AGREEMENT = "//*[@id='understand']";	
		private static final String SAVED_CARD = "//*[@id='savedCard']/ul/li[1]/label/span[2]";
		private static final String SUBMIT = "//*[@id='lnkSubmitAutoload']";
		private static final String NEXTSTEPS = "//*[@id='autoload']/div[2]/div[2]/p/a";
		private static final String NEW_CARD = "//*[@id='autoload']/div[3]/div[4]/div/ul/li[2]/a";
		private static final String CC = "//*[@id='newCard']/div/div[1]/div[2]/div[1]/input";
		private static final String CVV = "//*[@id='newCard']/div/div[1]/div[2]/div[2]/input";
		private static final String NAME = "//*[@id='newCard']/div/div[1]/div[3]/div/input";
		private static final String PHONE = "//*[@id='newCard']/div/div[1]/div[4]/div/input";
		private static final String MONTH = "//*[@id='CT_Main_2_drpPaymentExpireMonth']";
		private static final String YEAR = "//*[@id='CT_Main_2_drpPaymentExpireYear']";
		private static final String FNAME =  "//*[@id='newCard']/div/div[3]/div[1]/div[1]/input";
		private static final String LNAME = "//*[@id='newCard']/div/div[3]/div[1]/div[3]/input";
		private static final String ADDRESS = "//*[@id='newCard']/div/div[3]/div[2]/div[1]/input";
		private static final String ADDRESS2 = "//*[@id='newCard']/div/div[3]/div[2]/div[3]/input";
		private static final String CITY = "//*[@id='newCard']/div/div[3]/div[3]/div[1]/input";
		private static final String ZIP = "//*[@id='newCard']/div/div[3]/div[3]/div[3]/input";
		
		
	public AutoLoadPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCC(WebDriver driver, String cc) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CC)).sendKeys(cc);
	}
	
	public void enterCVV(WebDriver driver, String cvv) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CVV)).sendKeys(cvv);
	}
	
	public void enterName(WebDriver driver, String name) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NAME)).sendKeys(name);
	}
	
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void enterFname(WebDriver driver, String fname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FNAME)).sendKeys(fname);
	}
	
	public void enterLname(WebDriver driver, String lname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LNAME)).sendKeys(lname);
	}
	
	public void enterAddress(WebDriver driver, String address) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDRESS)).sendKeys(address);
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
	
	public void clickAgreement(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(AGREEMENT)).click();
	}
	

	public void clickSavedCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SAVED_CARD)).click();
	}
	
	public void clickNewCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEW_CARD)).click();
	}
	
	
	public void clickNextSteps(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEPS)).click();
	}
	
	
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
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