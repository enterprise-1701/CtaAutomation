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

public class AccountVentraCardPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String USER = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[1]/div/h1/span[1]";	
		private static final String LOGOUT = "//*[@id='CT_Header_ccHeaderLogin_pnlLogout']/div[2]/a";
		private static final String ADDPASS = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[6]/table/tbody/tr/td[1]/a";
		private static final String ADDVALUE = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[3]/div[2]/div[1]/a";
		private static final String AUTOLOAD_STATUS = "//*[@id='onOff_3']/a[2]";
		private static final String POPUP_OK = "//*[@id='divContinueWithAutoload']/div/a[1]";
		private static final String AUTOLOAD_STATUS_OFF = "//*[@id='onOff_2']/a[1]";
		private static final String CHANGE_CARD = "//*[@id='CT_Main_2_pnlChangeAccount']";
		private static final String OTHER_CARD = "//*[@id='CT_Main_2_rptSelectAccounts_ctl02_lnk']";
		private static final String ADDPASS_AUTOLOAD = "//*[@id='CT_Main_2_pnlContent']/div[2]/div[6]/table/tbody/tr/td[2]/a";
		private static final String ADDPASS_AUTOLOAD_POPUP_OK = "//*[@id='divAddPassWithAutoload']/div[4]/p/a[1]";
	
	public AccountVentraCardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(USER)).getText();
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
	
	public void clickChangeCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CHANGE_CARD)).click();
	}
	
	public void clickOtherCard(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(OTHER_CARD)).click();
	}
	
	public String getAutoLoadStatus(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(AUTOLOAD_STATUS)).getText();
	}
	
	public String getAutoLoadStatusOff(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(AUTOLOAD_STATUS_OFF)).getText();
	}
	
}