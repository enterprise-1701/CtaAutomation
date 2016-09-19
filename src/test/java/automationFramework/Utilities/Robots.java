package automationFramework.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.beust.jcommander.Strings;

public class Robots {
	
	
	public static void authenticationWindow() throws AWTException, IOException {

		 try {
             
	            Robot robot = new Robot();
	            System.out.println("Entering Robots class.....");
	        	robot.delay(3000);
	        	
	        	/*
	        	//Use this code block for older chrome driver version 
	        	int x = 1750;
	            int y = 200;

	           robot.setAutoDelay(500);
	           
	           robot.mouseMove(x, y);
	           robot.mousePress(InputEvent.BUTTON1_MASK);
	           robot.mouseRelease(InputEvent.BUTTON1_MASK);
	           robot.setAutoDelay(500);
	            
	           x = 1900;
	           y = 80;
	           
	           robot.mouseMove(x, y);
	           robot.mousePress(InputEvent.BUTTON1_MASK);
	           robot.mouseRelease(InputEvent.BUTTON1_MASK);
	           robot.setAutoDelay(500);
	           
	           // end of code block
	           */
	        	
	            //Enter username
	            robot.keyPress(KeyEvent.VK_A);
	            robot.keyRelease(KeyEvent.VK_A);
	            robot.keyPress(KeyEvent.VK_M);
	            robot.keyRelease(KeyEvent.VK_M);
	            robot.keyPress(KeyEvent.VK_E);
	            robot.keyRelease(KeyEvent.VK_E);
	            robot.keyPress(KeyEvent.VK_A);
	            robot.keyRelease(KeyEvent.VK_A);
	            robot.keyPress(KeyEvent.VK_G);
	            robot.keyRelease(KeyEvent.VK_G);
	            robot.keyPress(KeyEvent.VK_L);
	            robot.keyRelease(KeyEvent.VK_L);
	            robot.keyPress(KeyEvent.VK_E);
	            robot.keyRelease(KeyEvent.VK_E);
	            
	            //Enter password
	            robot.keyPress(KeyEvent.VK_TAB);
	            robot.keyPress(KeyEvent.VK_D);
	            robot.keyRelease(KeyEvent.VK_D);
	            robot.keyPress(KeyEvent.VK_E);
	            robot.keyRelease(KeyEvent.VK_E);
	            robot.keyPress(KeyEvent.VK_S);
	            robot.keyRelease(KeyEvent.VK_S);
	            robot.keyPress(KeyEvent.VK_I);
	            robot.keyRelease(KeyEvent.VK_I);
	            robot.keyPress(KeyEvent.VK_G);
	            robot.keyRelease(KeyEvent.VK_G);
	            robot.keyPress(KeyEvent.VK_N);
	            robot.keyRelease(KeyEvent.VK_N);
	            robot.keyPress(KeyEvent.VK_TAB);
	        	robot.keyPress(KeyEvent.VK_ENTER);
	           
	            
	        	robot.delay(3000);
	        	System.out.println("Exiting Robots class.....");
	        	
	        	
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }
		
	public static void authenticationWindowCancel() throws AWTException, IOException {

		 try {
            
	            Robot robot = new Robot();
	            System.out.println("Entering Robots class.....");
	        	robot.delay(3000);
	        	
	            robot.keyPress(KeyEvent.VK_TAB);
	            robot.keyPress(KeyEvent.VK_TAB);
	            robot.keyPress(KeyEvent.VK_TAB);
	        	robot.keyPress(KeyEvent.VK_ENTER);
	           
	            
	        	robot.delay(3000);
	        	System.out.println("Exiting Robots class.....");
	        	
	        	
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }
	
	public static void clickOkWindow() throws AWTException, IOException {

		 try {
           
	            Robot robot = new Robot();
	            System.out.println("Entering Robots class.....");
	        	robot.delay(3000);
	        
	        	robot.keyPress(KeyEvent.VK_ENTER);
	           
	            
	        	robot.delay(3000);
	        	System.out.println("Exiting Robots class.....");
	        	
	        	
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }

	
}
