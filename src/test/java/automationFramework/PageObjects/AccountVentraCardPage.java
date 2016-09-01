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
		
		
	public AccountVentraCardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(USER)).getText();
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LOGOUT)).click();
	}
	
}