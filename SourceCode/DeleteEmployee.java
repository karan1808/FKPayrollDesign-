package javafiles;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DeleteEmployee{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{


		System.out.println("Enter the id of employee which you want to delete");

		Scanner in = new Scanner(System.in); 
		int id = in.nextInt();

		JSONParser parser = new JSONParser();

		JSONArray arr = (JSONArray)parser.parse(new FileReader("Data.json"));
		
		int index = 0;

		for (Object obj : arr){

			
		JSONObject employee = (JSONObject) obj;
		Long employeeID =  (Long)(employee.get("employeeID"));
		int temp = (int)(id);
		if(employeeID == id){
			break;
		}
		index++;
		}
		arr.remove(index);

		FileWriter fileWriter = new FileWriter("Data.json");  
		
		fileWriter.write(arr.toJSONString());  
        
        fileWriter.flush();  
        
        fileWriter.close();  
	}	
}