package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
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

public class AddPassSelectProductPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String ONE_DAY_PASS = "//*[@id='purchase']/table[1]/tbody[2]/tr[1]/td[1]/input";
		private static final String THREE_DAY_PASS = "//*[@id='purchase']/table[1]/tbody[2]/tr[2]/td[1]/input";
		private static final String SEVEN_DAY_PASS = "//*[@id='purchase']/table[1]/tbody[2]/tr[3]/td[1]/input";
		private static final String NO_PRODUCT = "//*[@id='main']/div[2]/section/div[1]/div[3]/div[1]/p";
		private static final String NEXTSTEP = "//*[@id='main']/div[2]/section/div[1]/div[3]/div[4]/p/span/a";
		
	
	public AddPassSelectProductPage(WebDriver driver) {
		super(driver);
	}
	public void clickNextStep(WebDriver driver) throws InterruptedException, AWTException, ElementNotVisibleException{
		try{
		driver.findElement(By.xpath(NEXTSTEP)).click();
		}catch(Exception e){
			System.out.println("next step button not visible");
		}
		}
	
	
	//If element is not on the page throw an exception
	public void selectOneDayPass(WebDriver driver) throws InterruptedException, AWTException, NoSuchElementException{
		try{
		driver.findElement(By.xpath(ONE_DAY_PASS)).click();
		}
		catch(Exception NoSuchElementException ){
			System.out.println("OneDayPass element not on the page");
		}
		
	}	
	
	//If element is not on the page throw an exception
		public void selectThreeDayPass(WebDriver driver) throws InterruptedException, AWTException, NoSuchElementException{
			try{
			driver.findElement(By.xpath(THREE_DAY_PASS)).click();
			}
			catch(Exception NoSuchElementException ){
				System.out.println("ThreeDayPass element not on the page");
			}
			
		}	
	
	public void selectSevenDayPass(WebDriver driver) throws InterruptedException, AWTException, NoSuchElementException{
		
		try{
		driver.findElement(By.xpath(SEVEN_DAY_PASS)).click();
		}catch (Exception NoSuchElementException){
			System.out.println("SevenDayPass element not on the page");
		}
	}	
	
	public String getNoProduct(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(NO_PRODUCT)).getText();
	}
}