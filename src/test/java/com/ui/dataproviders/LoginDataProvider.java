package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]>  loginDataProvider() throws FileNotFoundException {
		
		Gson gson = new Gson();
		
		File testDataFile = new File(System.getProperty("user.dir")+"\\testdata\\loginData.json");

		FileReader fileReader = new FileReader(testDataFile);	
		
		TestData data=gson.fromJson(fileReader, TestData.class);//deserialization where you are converting json object(get data from json object) to java object and here data is the refernce variable 
		
		//and the you are going to go into for each loop and one by one you are going to get individual data and attach it to datatoReturn(ArrayList)
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for(User user:data.getData()) {
			
			dataToReturn.add(new Object[] {user});		
		}
		
		return dataToReturn.iterator();
		
	}
	
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		
		return CSVReaderUtility.readCSVFile("logindata.csv");
		
	}

	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		
		return ExcelReaderUtility.readExcelFile("logindata.xlsx");
		
	}

}
