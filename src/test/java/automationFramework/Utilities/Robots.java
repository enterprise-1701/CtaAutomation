package automationFramework.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.beust.jcommander.Strings;

public class Robots {
	
	
	public static void authenticationWindow() throws AWTException, IOException {

		 try {
             
	            Robot robot = new Robot();
	              
	        	robot.keyPress(KeyEvent.VK_A);
	        	robot.keyPress(KeyEvent.VK_M);
	        	robot.keyPress(KeyEvent.VK_E);
	        	robot.keyPress(KeyEvent.VK_A);
	        	robot.keyPress(KeyEvent.VK_G);
	        	robot.keyPress(KeyEvent.VK_L);
	        	robot.keyPress(KeyEvent.VK_E);
	           
	            //go to password field 
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.keyPress(KeyEvent.VK_D);
	        	robot.keyPress(KeyEvent.VK_E);
	        	robot.keyPress(KeyEvent.VK_S);
	        	robot.keyPress(KeyEvent.VK_I);
	        	robot.keyPress(KeyEvent.VK_G);
	        	robot.keyPress(KeyEvent.VK_N);
	        	
	        	
	        	//click on login
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.keyPress(KeyEvent.VK_ENTER);
	        	
	        	
	        	
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }
		

	
}
