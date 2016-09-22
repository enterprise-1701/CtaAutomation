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

@Test
public class DBAutomation {
	
	static WebDriver driver;
	static String browser;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	Connection connection;
	

	@BeforeMethod
	public void setUp() throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		
	}
	
	public void dbConnect(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			}catch(Exception e){
			Log.error("JDBC driver not found" + e);
			}
		
		try {
			
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@CTA-EIL-ORA.wd.cubic.com:1521:abp", "ABP_MAIN",
					"abp_main");
			Log.info("DB connection success");
			
		}catch(Exception e){
			Log.error("Connection failed" + e);
		}
		
		}
	
	//update table
	//we need to deactivate the passes on the account so the same card can be reused 
		public boolean dbUpdateCard(){
			
			boolean recordFound = false;
			
			try{
				
				Statement statement = connection.createStatement();
				connection.setAutoCommit(false);
				int results = statement.executeUpdate("UPDATE TRANSIT_ACCOUNT_X_FARE_PRODUCT SET DEACTIVATION_REASON = 2, DEACTIVATED_DTM=SYS_EXTRACT_UTC(SYSTIMESTAMP) WHERE TRANSIT_ACCOUNT_ID = 110009059400 AND DEACTIVATION_REASON IS NULL");
				connection.commit();
				
				if(results==1){
				  Log.info("results: " + results);
				  Log.info("TRANSIT_ACCOUNT_X_FARE_PRODUCT Record update success");
				  recordFound = true;
				}
				else{
					Log.error("TRANSIT_ACCOUNT_X_FARE_PRODUCT Record did NOT get updated");
				}
				}catch(Exception e){
					Log.error(e);
				}
			
				return recordFound;	
			}
	
	public void dbDisconnect(){
		try {
			connection.close();
			Log.info("DB disconnected");
		} catch (SQLException e) {
			Log.error("Not able to disconnect from DB");
		}
		
	}
	
}
