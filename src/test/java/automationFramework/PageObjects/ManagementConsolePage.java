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

public class ManagementConsolePage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String USERID = "//*[@id='MainContentPlaceholder_UserId']";	
		private static final String PASSWD = "//*[@id='MainContentPlaceholder_Password']";
		private static final String LOGIN = "//*[@id='Ok']";
		private static final String ACCOUNTS_TAB = "//*[@id='UserMenu']/table/tbody/tr/td[1]/div/a/span";
		private static final String ACCOUNT = "//*[@id='AccountId']";
		private static final String SEARCH =  "//*[@id='Search']";
		private static final String TOKEN = "//*[@id='__tab_MainContentPlaceholder_AccountTabContainer_TokenTabPanel']";
		private static final String ACTIVATE = "//*[@id='MainContentPlaceholder_AccountTabContainer_TokenTabPanel_TokenGrid_ActiveButton_0']";
		private static final String LOGOUT = "//*[@id='GlobalMenu']/ul/li[5]/a";
		
		
	
	public ManagementConsolePage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserId(WebDriver driver, String userid) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(USERID)).sendKeys(userid);
	}
	
	public void enterPasswd(WebDriver driver, String passwd) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PASSWD)).sendKeys(passwd);
	}
	
	public void enterAccount(WebDriver driver, String account) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACCOUNT)).sendKeys(account);
	}
	
	public void clickLogin(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LOGIN)).click();
	}
	
	public void clickAccountsTab(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACCOUNTS_TAB)).click();
	}
	
	public void clickSearch(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SEARCH)).click();
	}
	
	public void clickToken(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(TOKEN)).click();
	}
	
	public void clickActivate(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ACTIVATE)).click();
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LOGOUT)).click();
	}
	
	

}