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

public class AddPassReviewOrderPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[5]/div[4]/p/a[2]";
		private static final String CTA_PASS = "//*[@id='main']/div[2]/section/div[1]/div[5]/div[2]/div[2]/div/div/div[1]/div[1]";
		
	
	public AddPassReviewOrderPage(WebDriver driver) {
		super(driver);
	}
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}

	public String getCTADayPass(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CTA_PASS)).getText();
	}
	
}