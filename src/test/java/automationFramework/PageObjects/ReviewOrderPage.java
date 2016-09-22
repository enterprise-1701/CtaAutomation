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

public class ReviewOrderPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String HEADING = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[1]/h1";
		private static final String NEXT_STEP = "//*[@id='main']/div[2]/section/div[1]/div[4]/div[7]/p[3]/a[2]";
		
												   
	public ReviewOrderPage(WebDriver driver) {
		super(driver);
	}
	
	public String getHeading(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(HEADING)).getText();
	}
	
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXT_STEP)).click();
	}
	
	
	
}