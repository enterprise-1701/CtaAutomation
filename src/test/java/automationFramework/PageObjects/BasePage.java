package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	// Element Locators
	        private static final String POP_CLOSE = "//*[@id='modalClose']"; 
			private static final String GROUP_SALES_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl03_lnkLink2']";
			private static final String VENTRA_APP_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl04_lnkLink2']";
			private static final String SEARCH_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl05_lnkLink2']";
			private static final String TRANSIT_BENEFITS_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl02_lnkLink2']";
			private static final String HELP_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl01_lnkLink2]";
			private static final String WHAT_TAB = "//*[@id='CT_Header_ccTopNav_rptNav_ctl00_lnkLink2']";
			private static final String VENTRA = "//*[@id='main']/header/div/div[1]/h1/a";
			
	public static WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 15, 100);
	

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}
	
	public void getLandingPage(String url) throws Exception {
		try{
			driver.get(url);		
		} catch (Exception e) {
			Reporter.log("landing page not Found");
			throw (e);
		}
	}
	
	public void clickPopClose(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(POP_CLOSE)).click();
	}
	
	public void clickGroupSales(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(GROUP_SALES_TAB)).click();
	}
	
	public void clickVentraApp(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(VENTRA_APP_TAB)).click();
	}
	
	public void clickSearch(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SEARCH_TAB)).click();
	}
	
	public void clickTransitBenefits(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(TRANSIT_BENEFITS_TAB)).click();
	}
	
	public void clickHelp(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(HELP_TAB)).click();
	}
	
	public void clickWhat(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(WHAT_TAB)).click();
	}
	
	public void clickVentra(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(VENTRA)).click();
	}
	
	
	public String getCookie(String cookie) {
		driver.get(Global.URL1);
		Set<Cookie> cookies = driver.manage().getCookies();
		Cookie UID = driver.manage().getCookieNamed(cookie);
		return UID.getValue();
	}
	
	public static int getStatusCode(long appUserId) throws IOException {
		WebClient webClient = new WebClient();
		int code = webClient.getPage(Global.URL1).getWebResponse().getStatusCode();
		return code;
	}
	
	public static String getPageContent() throws IOException {
		WebClient webClient = new WebClient();
		String content = webClient.getPage(Global.URL1).getWebResponse().getContentAsString();
		return content;
	}
	
	public static void checkLinks(WebDriver driver) throws Exception {
		
		 List<WebElement> links=driver.findElements(By.tagName("a"));
	     System.out.println("total number of links: " +links.size());
	     
	     for (int i=0; i<links.size();i++){
	    	 if(!(links.get(i).getText().isEmpty())){
	    		
	    			 links.get(i).click();
	    			 driver.navigate().back();
	    			 links=driver.findElements(By.tagName("a"));    		 
	    	 }
	     }  	
	 }	     
}
