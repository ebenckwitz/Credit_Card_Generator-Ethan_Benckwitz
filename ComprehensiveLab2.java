/*
*In this lab I will be doing two activites and a bonus activity.
*In activity one we will check if the credit card number inputed is valid or not
*and in activity two we are asking for peoples names and credit card numbers to see if they are valid or not. 
*In the bonus activity we will ask the user if they want a new credit card number that is valid and if not the program will end.
*
*@Author 	Ethan Benckwitz
*@Version 	1.0
*@Since 	2018-11-7
*/

import java.util.*;

public class ComprehensiveLab2{
	public static void main(String []args){		
		Scanner sc = new Scanner(System.in);
		//Asking for credit card number for activity 1
		for(int i = 1; i <= 2; i++){
			System.out.println("See if your credit card number is valid or not! Enter your 16 digit credit card info: ");
			String creditCard = sc.nextLine();
			boolean valid = Luhn(creditCard);
			if(valid){
				System.out.println("Credit card number " +creditCard+ " is valid!\n");
			}else{
				System.out.println("Credit card number " +creditCard+ " is invalid!\n");
			}	
		}
		
		
		//Activity 2
		String[] creditCard2 = new String[2];
		checkCustomers(creditCard2);
		
		//Bonus Activity
		System.out.println("Do you want a new credit card?(y/n)");
		String answer = sc.nextLine();
		if(answer.equals ("y")){
			System.out.println("We are going to give you a new valid credit card number!");
			generateCCard();
		}else{
			System.exit(0);
		}
	}
	
	public static boolean Luhn(String creditCard){
		//Activity 1 where the system checks if the user input credit card number is valid or not
		boolean valid = false;
		int [] nums = new int[creditCard.length()];
		for(int i = 0; i < creditCard.length(); i++){
			nums[i] = Integer.parseInt(creditCard.substring(i, i + 1));
		}
		for(int i = nums.length - 2; i >= 0; i = i - 2){
			int j = nums[i];
			j = (j * 2);
			if(j > 9){
				j = j % 10 + 1;
			}
			nums[i] = j;
		}
		int total = 0;
		for(int i = 0; i < nums.length; i++){
			total += nums[i];
		}
		if(total % 10  == 0){
			valid = true;
		}
		return valid;
	
	}
	public static void checkCustomers(String[] creditCard2){
		//activity 2 will put names and credit card number into 2D array and will see if the credit card number is valid or not
		Scanner sc = new Scanner(System.in);
		System.out.println("Thanks for using our service! How many people will be charged?");
		int n = sc.nextInt();
		boolean[] num = new boolean[n];
		String[][] info = new String[n][2];
		sc.nextLine();
		for(int i = 0; i < n; i++){
			System.out.println("Enter name #" +(i+1));
			info[i][0] = sc.nextLine();
			System.out.println("Credit card number for " +(i+1));
			info[i][1] = sc.nextLine();
		}
		for(int i = 0; i < n; i++){
			num[i] = Luhn(info[i][1]);
		}
		for(int i = 0; i < n; i++){
			System.out.print(info[i][0]+ "'s credit card number " +info[i][1]);
			if(num[i]){
				System.out.println(" is valid\n");
			}else{
				System.out.println(" is not valid\n");
			}
		}
	}
	public static void generateCCard(){
		//Bonus activity! We will give the user a new valid credit card number that is valid
		Random RAN = new Random();
		boolean valid = false;
		String s;
		while(!valid){
			s = "" +(RAN.nextInt(9999-1000)+ "" +(RAN.nextInt(8999) +1000)+ "" +(RAN.nextInt(8999) +1000)+ "" +(RAN.nextInt(8999) +1000));
			if(Luhn(s)){
				valid = true;
				System.out.println("Your random credit card number is " +s);
			}
		}
	}	
}
