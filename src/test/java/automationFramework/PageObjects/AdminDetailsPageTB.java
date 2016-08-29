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

public class AdminDetailsPageTB extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String USERNAME = "//*[@id='divUserName']/input";	
		private static final String PASSWD = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[3]/div[3]/div[1]/input";
		private static final String CONFIRM_PASSWD = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[3]/div[3]/div[2]/input";
		private static final String ANSWER = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[3]/div[4]/div[2]/input";
	    private static final String SECURITYQ = "//*[@id='drpSecurityQuestion']";
	    private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[3]/p/a[2]";
		
	public AdminDetailsPageTB(WebDriver driver) {
		super(driver);
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void enterUserName(WebDriver driver, String userName) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(USERNAME)).click();
		driver.findElement(By.xpath(USERNAME)).sendKeys(userName);
	}
	
	public void enterPasswd(WebDriver driver, String passwd) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PASSWD)).click();
		driver.findElement(By.xpath(PASSWD)).sendKeys(passwd);
	}
	
	public void enterConfirmPasswd(WebDriver driver, String passwd) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONFIRM_PASSWD)).click();
		driver.findElement(By.xpath(CONFIRM_PASSWD)).sendKeys(passwd);
	}
	
	public void enterAnswer(WebDriver driver, String answer) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ANSWER)).click();
		driver.findElement(By.xpath(ANSWER)).sendKeys(answer);
	}

	public void selectSecurityQ(WebDriver driver) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(SECURITYQ)));
		mySelect.selectByIndex(1);
	}
}