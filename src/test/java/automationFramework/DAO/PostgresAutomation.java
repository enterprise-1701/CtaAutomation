package automationFramework.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationFramework.Utilities.Global;
import automationFramework.Utilities.Logging;

public class PostgresAutomation {
	
	static WebDriver driver;
	static String browser;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	Connection connection;
	int accountID;
	int customerID;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		
	}
	
	@Test
	public void dbConnect(){
		try{
			Class.forName("org.postgresql.Driver");
			Enumeration<Driver> drivers = DriverManager.getDrivers();
			connection = DriverManager.getConnection(Global.POSTGRESDB, Global.POSTGRESUSER, Global.POSTGRESPASS);
			Log.info("PostgresDB connection success!");
			
			}catch(Exception e){
			Log.error("Not able to connect to postgresDB");
			}	
		}
	
	
	@Test
	public boolean dbFindCustomer(String userEmail){
		
		boolean recordFound = false;
		
		try{
			
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM cms_main.contact where email ='" + userEmail + "'");
			while(results.next()){
			  String ID = results.getString("contact_id");
			  Log.info("contact id in the database: " + ID);
			  recordFound = true;
			}
			
			}catch(Exception e){
			Log.error("Not able to retrieve record from postgresDB");
			}
		
			return recordFound;	
		}
	
	//check oam_main.account
	@Test
	public boolean dbFindAccount(String email){
			
		try{
			
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT customer_id FROM cms_main.contact where email ='" + email + "'");
		    
			while(results.next()){
				  customerID = results.getInt("customer_id");
				  Log.info("contact id in the database: " + customerID);
				
				}
			
			Statement statement2 = connection.createStatement();
			ResultSet results2 = statement2.executeQuery("SELECT account_id FROM oam_main.account where customer_id = '" + customerID + "'");
			
			
			while(results2.next()){
			  accountID = results2.getInt("account_id");
			  Log.info("account id in the database: " + accountID);
			 
			}
			
			}catch(Exception e){
			System.err.println(e.getMessage());
			Log.error("Not able to retrieve record from postgresDB oam_main.account");
			}
		
		if (customerID == accountID){
			return true;
		}
		else{
			return false;
		}
			
		}
	
	

	@Test
	public void dbDisconnect(){
		try {
			connection.close();
			Log.info("PostgresDB disconnected");
		} catch (SQLException e) {
			Log.error("Not able to disconnect from postgresDB");
		}
		
	}
	
}
