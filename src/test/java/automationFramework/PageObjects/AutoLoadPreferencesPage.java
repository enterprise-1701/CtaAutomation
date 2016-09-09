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

public class AutoLoadPreferencesPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String AGREEMENT = "//*[@id='understand']";
		private static final String NEXTSTEPS = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[4]/p/a[2]";
		
		
	public AutoLoadPreferencesPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAgreement(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(AGREEMENT)).click();
	}
	
	
	public void clickNextSteps(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEPS)).click();
	}
	
}