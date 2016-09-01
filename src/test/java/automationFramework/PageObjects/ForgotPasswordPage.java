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

public class ForgotPasswordPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String USERNAME = "//*[@id='CT_Main_0_txtUsername']";	
		private static final String SUBMIT = "//*[@id='CT_Main_0_btnGetSecurityQuestion']";
		private static final String ANSWER = "//*[@id='CT_Main_0_txtSecurityAnswer']";
		private static final String RETRIEVE = "//*[@id='CT_Main_0_btnRetrievePassword']";
		private static final String CONFIRMATION = "//*[@id='inline']/p[1]";
		
		
		public ForgotPasswordPage(WebDriver driver) {
			super(driver);
		}
		
		public void enterUsername(WebDriver driver, String username) throws InterruptedException, AWTException{
			driver.findElement(By.xpath(USERNAME)).sendKeys(username);	
		}
		
		public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
			driver.findElement(By.xpath(SUBMIT)).click();	
		}
		
		public void enterAnswer(WebDriver driver, String answer) throws InterruptedException, AWTException{
			driver.findElement(By.xpath(ANSWER)).sendKeys(answer);
		}
		
		public void clickRetrievePasswd(WebDriver driver) throws InterruptedException, AWTException{
			driver.findElement(By.xpath(RETRIEVE)).click();	
		}
		
		public String getConfirmation(WebDriver driver) throws InterruptedException, AWTException{
			return driver.findElement(By.xpath(CONFIRMATION)).getText();
		}
	
}