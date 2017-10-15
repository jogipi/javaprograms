/* Name: Jorge Sanchez
 * Date: 7/14/2015
 * Lab Assignment 9 : TextProcessing
 * This program takes the input of a string. It then splits the string by the white space to create an array with elements that hold each word. Lastly we output the strings in each element by capitalizing the first letter and concantenating
 * it with the rest of the string in that same element.
 * 
 */
import java.util.Scanner;


public class TextProcessing {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		
		
		
		System.out.println("Please type in a string");
		String line = input.nextLine();
		String[] array = line.split(" ");
		
		for(int index = 0; index < array.length; index++)
		{
		String cap = array[index].substring(0, 1).toUpperCase() + array[index].substring(1);
		System.out.print(cap + " ");
		}
	
	
		
		
	

	}
	
	
}