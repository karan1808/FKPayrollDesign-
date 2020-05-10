package javafiles;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class PostTimeCard{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{

JSONParser parser = new JSONParser();
JSONArray arr = (JSONArray)parser.parse(new FileReader("employeesData.json"));
JSONArray arr2 = new JSONArray();

		for (Object obj : arr){
			JSONObject employee = (JSONObject) obj;
			int flag=0;         
			if(employee.get("salaryType").equals("HOURLY")){
				flag=1;
				System.out.println("Employee number: " + employee.get("employeeID")+ ", Enter the total number of hours of Work");

				Scanner in = new Scanner(System.in); 
				
				int totalHours = in.nextInt();  
				
				Long extraHours = (Long)employee.get("extraHours") + Math.max(totalHours - 8L , 0L);
				
				JSONObject newEmployee = new JSONObject();

				
				newEmployee.put("employeeID" , employee.get("employeeID"));
				
				newEmployee.put("employeeName" , employee.get("employeeName"));
				
				newEmployee.put("basicPay" , employee.get("basicPay"));
				
				newEmployee.put("salaryType" , employee.get("salaryType"));
				
				newEmployee.put("methodOfPayment" , employee.get("methodOfPayment"));
				
				newEmployee.put("partOfUnion" , employee.get("partOfUnion"));
				
				newEmployee.put("extraHours" , extraHours);
				
				newEmployee.put("hourlyRate" , employee.get("hourlyRate"));
				
				newEmployee.put("commissionRate" , employee.get("commissionRate"));
				
				newEmployee.put("amountOfSales" , employee.get("amountOfSales"));
				
				newEmployee.put("unionDues" , employee.get("unionDues"));
				
				newEmployee.put("duesRate" , employee.get("duesRate"));

				arr2.add(newEmployee);

			}

			if(flag==0){
				arr2.add(employee);
			}

			FileWriter fileWriter = new FileWriter("Data.json");  

			fileWriter.write(arr2.toJSONString());  
	        
	        fileWriter.flush();  
	        
	        fileWriter.close();  
		}
	}
}