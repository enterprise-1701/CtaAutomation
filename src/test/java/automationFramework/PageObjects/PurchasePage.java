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

public class PurchasePage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String CTA_1DAY_PASS = "//*[@id='purchase']/div[2]/table[1]/tbody/tr[1]/td[1]/input";
		private static final String NEXT_STEP = "//*[@id='main']/div[2]/section/div[1]/div[2]/div[3]/p/span/a";
		
	
	public PurchasePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectCTA1DayPass(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CTA_1DAY_PASS)).click();
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXT_STEP)).click();
	}
	
	
}