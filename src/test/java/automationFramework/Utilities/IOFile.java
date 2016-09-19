package automationFramework.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.testng.Reporter;
import automationFramework.Utilities.Global;

public final class IOFile {

	//Get index from external file
	public static String getIndex(){
		
		String index = null;
		try{
			Scanner s = new Scanner(new File(Global.INDEX_FILE));
			while(s.hasNext()){
				index = s.next();
			}
			s.close();
	
		}catch (Exception e) {
			Reporter.log("Utils.getIndex failed");
			System.out.print("Utils.getIndex failed");
		}
		
		return index;	
	}
	
	//Increment index in external file
	public static String incrementIndex(){
		
        //Get current index
		String currentIndex = IOFile.getIndex();
		//Convert to int and increment 
		int currentIndex1 = Integer.parseInt(currentIndex);
		currentIndex1 = currentIndex1++;
		//Convert incremented index back to String
		String nextIndex = Integer.toUnsignedString(currentIndex1);
		
		return nextIndex;					
	}
	
	//Set index in external file
	public static void setIndex(String newIndex){
		
		try{
		
		File file = new File(Global.INDEX_FILE);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(newIndex);
		bw.close();
		
		}catch (IOException e){
			Reporter.log("Utils.setIndex failed");
			System.out.print("Utils.setIndex failed");
		}
			
	}
	
	
	// Read input file and return row specified by the index number
	public static String readFile(int index) throws FileNotFoundException, IndexOutOfBoundsException{
		
		ArrayList<String> list = new ArrayList<String>();
		String token = null;
		try{
			Scanner s = new Scanner(new File(Global.INPUT_FILE));
			while(s.hasNext()){
				list.add(s.next());
			}
		
			token = list.get(index);
			s.close();
	
		} catch (FileNotFoundException e) {
			Reporter.log("Utils.readFile failed");
			System.out.print("Utils.readFile failed");
		} catch (IndexOutOfBoundsException e){
			System.out.print("Index out of bound exception - Update input file with new card numbers");
		}
			
	return token;
	
	}
		
}