import java.io.*;
import java.util.*;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ChangeEmployeeDetails{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{

		System.out.println("Enter the id of employee to be updated");
		Scanner in = new Scanner(System.in); 
		int id = in.nextInt(); 


		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray)parser.parse(new FileReader("Data.json"));

		JSONObject newEmployee = new JSONObject();

		int flag=0;
		int index =0;
		for (Object obj : arr){
		JSONObject employee = (JSONObject) obj;
		Long employeeID =  (Long)(employee.get("employeeID"));
		int temp = (int)(id);
		if(employeeID == id){
			flag=1;
			System.out.println("Update the name of employee");

			Scanner in1 = new Scanner(System.in); 

			String employeeName = in1.nextLine();

			System.out.println("Updated salary type in capitals: HOURLY or FLAT or SALES");

			Scanner in3 = new Scanner(System.in); 

			String salaryType = in3.nextLine();


			System.out.println("Updated method of payment which employee wants in capitals: POST or PICKUP or BANK");


			Scanner in4 = new Scanner(System.in); 

			String methodOfPayment = in4.nextLine();



			System.out.println("Is Employee part of union now? Answer in capitals: YES or NO");

			Scanner in5 = new Scanner(System.in); 

			String partOfUnion = in5.nextLine();


			int basicPay = 0;
			if(!salaryType.equals("HOURLY")){

				System.out.println("Enter the updated basic pay salary of employee");

				Scanner in6 = new Scanner(System.in); 

				basicPay = in6.nextInt();

			}

			Long unionDues = (Long)employee.get("unionDues");
			int duesRate = 0;
			if(partOfUnion.equals("YES")){

				System.out.println("Enter the updated amount of dues employee pays weekly to the union");

				Scanner in7 = new Scanner(System.in); 

				duesRate = in7.nextInt();
			}

			int commissionRate = 0;

			Long amountOfSales = (Long)employee.get("amountOfSales");

			if(salaryType.equals("SALES")){

				System.out.println("Enter the updated percentage of commission employee receives on sales made by him/her");

				Scanner in8 = new Scanner(System.in); 

				commissionRate = in8.nextInt();

			}

			int hourlyRate = 0;

			Long extraHours = (Long)employee.get("extraHours");

			if(salaryType.equals("HOURLY")){

				System.out.println("Enter the updated rate which you receive per hour");

				Scanner in9 = new Scanner(System.in); 

				hourlyRate = in9.nextInt();

			}

			newEmployee.put("employeeID" , employeeID);

			newEmployee.put("employeeName" , employeeName);

			newEmployee.put("basicPay" , basicPay);

			newEmployee.put("salaryType" , salaryType);

			newEmployee.put("methodOfPayment" , methodOfPayment);

			newEmployee.put("partOfUnion" , partOfUnion);

			newEmployee.put("hourlyRate" , hourlyRate);

			newEmployee.put("extraHours" , extraHours);

			newEmployee.put("commissionRate" , commissionRate);

			newEmployee.put("amountOfSales" , amountOfSales);

			newEmployee.put("unionDues" , unionDues);
			
			newEmployee.put("duesRate" , duesRate);

				break;
			}

			index++;
		}

		if(flag==1){
			arr.remove(index);
			arr.add(newEmployee);
		}

		FileWriter fileWriter = new FileWriter("Data.json");  
		fileWriter.write(arr.toJSONString());  
        fileWriter.flush();  
        fileWriter.close();  
	}
}
