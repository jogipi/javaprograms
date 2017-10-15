
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * This class is used as the menu
 */
public class Menu {
	
	private PrintWriter pw;
	Scanner s = new Scanner(System.in);
	
	
	/* 
	 * Enables output to CSIS.txt
	 * 
	 * @param a Printwriter shared class
	 */
	public Menu(PrintWriter p) {
		pw = p;
	}


	public void display() {
		System.out.println("List of conversions\n1. Decimal to Binary\n"
				+ "2. Decimal to Hexadecimal\n"
				+ "3. Binary to Decimal\n"
				+ "4. Binary to Hexadecimal\n"
				+ "5. Hexadecimal to Decimal\n"
				+ "6. Hexadecimal to Binary");
		
		pw.println("List of conversions\r\n1. Decimal to Binary\r\n"
				+ "2. Decimal to Hexadecimal\r\n"
				+ "3. Binary to Decimal\r\n"
				+ "4. Binary to Hexadecimal\r\n"
				+ "5. Hexadecimal to Decimal\r\n"
				+ "6. Hexadecimal to Binary");
		
		
	}
		
	/*
	 * Prompts the user for the choice. Outputs the prompt to the console
	 * as well as csis.txt.
	 * @return choice as an int value.
	 */
	public int getSelection() {
		
		int choice = 0;
		
		System.out.println("Please choose which conversion: ");
		choice = s.nextInt();
		
		pw.println("Please choose which conversion: ");
		pw.println(choice);
		
		return choice;
		
		
	}

}
