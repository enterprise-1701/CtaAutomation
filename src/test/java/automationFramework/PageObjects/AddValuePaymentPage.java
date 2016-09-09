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

public class AddValuePaymentPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		
		private static final String CVW = "//*[@id='savedCard']/div/div/input";
		private static final String SUBMIT =  "//*[@id='divCreditCard']/div[2]/div/div[3]/div/a[2]";
		
	
	public AddValuePaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCVW(WebDriver driver, String cvw) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CVW)).sendKeys(cvw);
	}
	
	public void clickSubmit(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SUBMIT)).click();
	}
	
}