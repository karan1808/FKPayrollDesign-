package javafiles;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String [] args){

	Scanner in = new Scanner(System.in);

	System.out.println("Welcome to Flipkart Payroll Portal");
	System.out.println("Select The Operation Which You Want To Perform");
	System.out.println("1.Add a new employee");
	System.out.println("2.Delete an employee");
	System.out.println("3.Post a time card");
	System.out.println("4.Post a sales receipt");
	System.out.println("5.Post a union membership,service charge");
	System.out.println("6.Change employee details");
	System.out.println("7.Run the payroll for today");
	
	int operationInput;
    operationInput = in.nextInt();

    		if(operationType == 1) {
                	AddEmployee();
            } else if(operationType == 2){
            		DeleteEmployee();
            } else if(operationType == 3) {
                	PostTimeCard();
            } else if(operationType == 4) {
                	PostSalesReceipt();
            } else if(operationType == 5) {
                	PostAUnionMembership();
            } else if(operationType == 6) {
                	ChangeEmployeeDetails();
            } else if(operationType == 7) {
                	RunPayRoll();
            }


	}
}
