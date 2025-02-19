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

public class AddValueSelectProductPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String AMOUNT = "//*[@id='purchase']/table/tbody/tr[1]/td[1]";
		private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[3]/div[4]/p/span/a";
		
	
	public AddValueSelectProductPage(WebDriver driver) {
		super(driver);
	}
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXTSTEP)).click();
	}
	
	public void selectAmount(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(AMOUNT)).click();
	}
	
	
}