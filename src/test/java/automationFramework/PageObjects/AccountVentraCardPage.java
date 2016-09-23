package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Utils;

public class AccountVentraCardPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String USER = " //*[@id='CT_Main_2_pnlContent']/div[2]/div[1]/div[1]/h1/span[1]";
		private static final String LOGOUT = "//*[@id='CT_Header_ccHeaderLogin_pnlLogout']/div[2]/a";
		private static final String ADDPASS = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[6]/table/tbody/tr/td[1]/a";
		private static final String ADDVALUE = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[3]/div[2]/div[1]/a";
		private static final String AUTOLOAD_STATUS = "//*[@id='onOff_0']/a[2]";
		private static final String POPUP_OK = "//*[@id='divContinueWithAutoload']/div/a[1]";
		private static final String AUTOLOAD_STATUS_OFF = "//*[@id='onOff_2']/a[1]";
		private static final String MANAGE_CARD = "//*[@id='CT_Main_2_pnlChangeAccount']";
		private static final String NEW_CARD = "//*[@id='CT_Main_2_rptSelectAccounts_ctl02_lnk']";
		private static final String ADDPASS_AUTOLOAD = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[6]/table/tbody/tr/td[2]/a";
		private static final String ADDPASS_AUTOLOAD_POPUP_OK = "//*[@id='divAddPassWithAutoload']/div[4]/p/a[1]";
		private static final String ACCOUNT_ID = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[1]/div/div[2]/span[1]";
		private static final String REGISTER = "//*[@id='CT_Left_0_pnlLoggedIn']/ul/li[1]/ul/li/ul/li[6]/a";
		int i;
	
	public AccountVentraCardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(USER)).getText();
	}
	
	public String getAccountId(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(ACCOUNT_ID)).getText();
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LOGOUT)).click();
	}
	
	public void clickAddPass(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDPASS)).click();
	}
	
	public void clickAddPassAutoLoad(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDPASS_AUTOLOAD)).click();
	}
	
	
	public void clickAddValue(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDVALUE)).click();
	}
	
	public void clickAutoLoadStatus(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(AUTOLOAD_STATUS)).click();
	}
	
	public void clickPopupOk(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(POPUP_OK)).click();
	}
	
	public void clickAddPassPopupOk(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(ADDPASS_AUTOLOAD_POPUP_OK)).click();
	}
	
	public void clickManageCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(MANAGE_CARD)).click();
	}
	
	
	public void clickNewCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEW_CARD)).click();
	}
	
	//Tab to the correct card and press enter
	public void clickTabManageCard(WebDriver driver, int numberOfTabs) throws InterruptedException, AWTException{
		    Actions action = new Actions(driver);
			for(i=0; i<numberOfTabs; i++){
				action.sendKeys(Keys.TAB).build().perform();
				System.out.println("On iteration " + i);
				Utils.waitTime(3000);
				}
		
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickRegister(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(REGISTER)).click();
	}
	
	public String getAutoLoadStatus(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(AUTOLOAD_STATUS)).getText();
	}
	
	public String getAutoLoadStatusOff(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(AUTOLOAD_STATUS_OFF)).getText();
	}
	
}