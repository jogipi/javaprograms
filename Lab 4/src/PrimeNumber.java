/*
 * Name: Jorge Sanchez
 * ID: 5213188
 * Date: 6/20/2015
 * Lab 4: Loops and Files
 * This program asks the user for an integer input and it outputs whether the number input is prime.
 */
import java.util.Scanner;
public class PrimeNumber {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int number = 0;
	int divisible = 0;
	
	System.out.println("Enter a number from 1 to 100: ");
	number = input.nextInt();
	
	for(int i = 1; i<=number; i++)
	{
		if(number%i == 0)
			divisible++;
	}
	
	if (divisible > 2) 
	System.out.println("The number is not a prime number.");
	else
	System.out.println("The number is a prime number.");
	

	}
}
