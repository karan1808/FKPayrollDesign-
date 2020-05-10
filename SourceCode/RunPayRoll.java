import java.io.*;
import java.util.*;
import java.time.*; 
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class RunPayRoll{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{

		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray)parser.parse(new FileReader("Data.json"));

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

		String todayDate = String.format("%1$te" , cal);

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		cal.set(Calendar.DAY_OF_MONTH, lastDay);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:

				lastDay--;

			case Calendar.SATURDAY:

				lastDay--;
		}

		int flag = 0;
		int flag2 = 0;
		String lastDayOfMonth = String.valueOf(lastDay);
		if(lastDayOfMonth==todayDate)
			flag=1;
		if(dayOfWeek==6)
			flag2 = 1;
		for (Object obj : arr){
			JSONObject employee = (JSONObject) obj;
			
			if(employee.get("salaryType").equals("FLAT")){

				if(flag==1){

					Long salaryToPay = (Long)employee.get("basicPay") - (Long)employee.get("unionDues");	

					System.out.println("Basic Salary to be paid today to Employee number: " + employee.get("employeeID") + " = Rs " + salaryToPay);
				}
			}
			else if(employee.get("salaryType").equals("HOURLY")){
				int temp=0;
				if(flag==1){
					temp=1;
					Long salaryToPay = (Long)employee.get("basicPay") - (Long)employee.get("unionDues");

					System.out.println("Basic Salary to be paid today to Employee number: " + employee.get("employeeID") + " = Rs " + salaryToPay);

				}
				if(flag2==1){

					Long dues = (temp==0 ? (Long)employee.get("unionDues") : 0L);

					Long salaryToPay = (3*((Long)employee.get("extraHours"))*((Long)employee.get("hourlyRate")))/2 - dues;

					System.out.println("Additional Salary to be paid today for extra working hours to Employee number: " + employee.get("employeeID") + " = Rs " + salaryToPay);

				}
			}
			else{
				int temp=0;
				if(flag==1){
					temp=1;

					Long salaryToPay = (Long)employee.get("basicPay") - (Long)employee.get("unionDues");

					System.out.println("Basic Salary to be paid today to Employee number: " + employee.get("employeeID") + " = Rs " + salaryToPay);

				}
				if(flag2==1){

					Long dues = (temp==0 ? (Long)employee.get("unionDues") : 0L);

					Long salaryToPay = ((Long)employee.get("amountOfSales"))*((Long)employee.get("commissionRate")) - dues;

					System.out.println("Additional Salary to be paid today for sales commission to Employee number: " + employee.get("employeeID") + " = Rs " + salaryToPay);

				}
			}
		}
	}
}
