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

public class GroupAccountLandingPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String DASHBOARD = "//*[@id='CT_Main_0_pnlContent']/div/div[1]/h1";	
		private static final String PAYMENT_INFO = "//*[@id='main']/div[2]/aside/ul/li[1]/ul/li/ul/li[2]/a";
		
		
	public GroupAccountLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDashboard(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(DASHBOARD)).getText();
	}
	
	public void clickPaymentInfo(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PAYMENT_INFO)).click();
	}
	
	
}