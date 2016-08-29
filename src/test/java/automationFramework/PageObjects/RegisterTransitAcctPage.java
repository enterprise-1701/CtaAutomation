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

public class RegisterTransitAcctPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String NICKNAME = "//*[@id='divStep2UsernameAjax']/div[7]/div[2]/div/input";
		private static final String NEXT_STEP = "//*[@id='divStep2UsernameAjax']/div[13]/p/a[2]";
		private static final String FIRSTNAME = "//*[@id='divStep2UsernameAjax']/div[9]/div[2]/div[1]/input";
		private static final String LASTNAME = "//*[@id='divStep2UsernameAjax']/div[9]/div[2]/div[2]/input";
		private static final String ADDRESS = "//*[@id='divStep2UsernameAjax']/div[9]/div[3]/div[1]/input";
		private static final String ADDRESS2 = "//*[@id='divStep2UsernameAjax']/div[9]/div[3]/div[2]/input";
		private static final String CITY = "//*[@id='divStep2UsernameAjax']/div[9]/div[4]/div[1]/input";
		private static final String ZIP = "//*[@id='divStep2UsernameAjax']/div[9]/div[4]/div[3]/input";
		private static final String EMAIL = "//*[@id='divStep2UsernameAjax']/div[9]/div[5]/div[1]/input";
		private static final String CONFIRM_EMAIL = "//*[@id='divStep2UsernameAjax']/div[9]/div[5]/div[2]/input";
		private static final String PHONE =  "//*[@id='divStep2UsernameAjax']/div[9]/div[6]/div/input";
		
		private static final String USERNAME =  "//*[@id='divUserName']/input";
		private static final String PASSWD = "//*[@id='divStep2UsernameAjax']/div[11]/div[3]/div[1]/input";
		private static final String CONFIRM_PASSWD = "//*[@id='divStep2UsernameAjax']/div[11]/div[3]/div[2]/input";
		private static final String ACCESS_CODE = "//*[@id='divStep2UsernameAjax']/div[11]/div[4]/div/input";
		private static final String SECURITYQ = "//*[@id='drpSecurityQuestion']";
		private static final String ANSWER = "//*[@id='divStep2UsernameAjax']/div[11]/div[6]/div/input";
		private static final String MONTH = "//*[@id='CT_Main_0_drpAccountDOBMonth']";
		private static final String DAY = "//*[@id='divStep2UsernameAjax']/div[11]/div[8]/select[2]";
		private static final String YEAR = "//*[@id='CT_Main_0_drpAccountDOBYear']";
		private static final String TERMS = "//*[@id='understand']";
		
	public RegisterTransitAcctPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterNickname(WebDriver driver, String nickname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NICKNAME)).sendKeys(nickname);
	}
	
	public void enterFirstname(WebDriver driver, String fname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FIRSTNAME)).sendKeys(fname);
	}
	
	public void enterLastname(WebDriver driver, String lname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LASTNAME)).sendKeys(lname);
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
	
	public void enterEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public void enterConfirmEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONFIRM_EMAIL)).sendKeys(email);
	}
	
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void enterUsername(WebDriver driver, String username) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(USERNAME)).sendKeys(username);
	}
	
	public void enterPasswd(WebDriver driver, String passwd) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PASSWD)).sendKeys(passwd);
	}
	
	public void enterConfirmPasswd(WebDriver driver, String passwd) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONFIRM_PASSWD)).sendKeys(passwd);
	}
	
	public void enterAccessCode(WebDriver driver, String accessCode) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACCESS_CODE)).sendKeys(accessCode);
	}
	
	public void selectSecurityQuestion(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(SECURITYQ)));
		mySelect.selectByIndex(1);
	}
	
	public void enterAnswer(WebDriver driver, String answer) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ANSWER)).sendKeys(answer);
	}
	
	public void selectMonth(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(MONTH)));
		mySelect.selectByIndex(1);
	}
	
	public void selectDay(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(DAY)));
		mySelect.selectByIndex(1);
	}
	
	public void selectYear(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(YEAR)));
		mySelect.selectByIndex(10);
	}
	
	public void clickTerms(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(TERMS)).click();
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXT_STEP)).click();
	}
	
	
}