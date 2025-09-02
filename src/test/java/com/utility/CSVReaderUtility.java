package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String filename) {
		
		File csvFile = new File(System.getProperty("user.dir")+"//testdata//"+ filename);
		FileReader filereader = null;
		CSVReader csvReader ;
		String[] line;
		List<User> userList = null;
		User userData;
		
		try {
			filereader = new FileReader(csvFile);
			csvReader = new CSVReader(filereader);
			csvReader.readNext();
		
			userList = new ArrayList<User>();
			
			while((line = csvReader.readNext())!=null){
				
				if (line.length > 0 && !line[0].trim().isEmpty()) {	
		
				userData = new User(line[0],line[1]);
				
				userList.add(userData);
			}
			
		}	
			
		}
		
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}		

		 catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}  
		
		return userList.iterator();
	}
	
}
