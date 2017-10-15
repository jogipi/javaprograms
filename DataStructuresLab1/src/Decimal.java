


import java.io.PrintWriter;
import java.util.Scanner;
/*
 * This class converts from decimal to Binary and from decimal to hexadecimal.
 */

public class Decimal {
	
	private String decimal;
	private PrintWriter pw;
	private String hexadecimalConversion;
	private String binaryConversion;
	private Scanner s = new Scanner(System.in);
	private StringBuilder sb = new StringBuilder();
	private StringBuilder sb2 = new StringBuilder();
	

	public Decimal(PrintWriter p) {
		pw = p;
	}

	/*
	 * Method uses other methods to convert from decimal to binary numbers.
	 */
	public void decToBin() {
		inputDec();	
		toBin(decimal);
		outBin();
		
	}
	
	/*
	 * Method prompts the user for an input of a decimal number.
	 */
	private void inputDec() {
		System.out.println("Please enter a decimal number:");
		pw.println("Please enter a decimal number:");
		decimal = s.nextLine();
		pw.println (decimal);
		decimal = decimal.replace(",", "");
		decimal = decimal.replace(" ", "");

	}
	
    /*
     * Method converts the string into a binary number.
     */
	private void toBin(String a) {
		a = a.replace(",", "");
		a= a.replace(" ", "");
		int b = Integer.parseInt(a);
		int r = 0;
		
		while(b != 0){
			r = b%2;
			b = b/2;
			sb.append(r);
		}
		binaryConversion = sb.reverse().toString();
			
	}
	
	/*
	 * Method outputs the binary conversion to csis.txt as well as
	 *  the command prompt.
	 */
	private void outBin() {
		System.out.println("Binary Conversion: " + binaryConversion);
		pw.println("Binary Conversion: " + binaryConversion);
		sb.setLength(0);
	}
	
	/*
	 * Method uses other methods to convert from decimal to Hex
	 */
	public void decToHex() {
		inputDec();
		toHex(decimal);
		outHex();
		
	}
	
	/*
	 * Method converts the string to a hexadecimal
	 * @param h the string input of a decimal number.
	 */
	private void toHex(String h) {
		
		int a = Integer.parseInt(h);
		int remainder = 0;
		int quotient = a;
		int b = 0;		
			while( quotient != 0)
			{
				
				remainder = quotient%16;
				a = a/16; 
				quotient = a;
				
				b = remainder;
					
				if (b<10) {
					sb2.append(b);
				}
				
				switch (b) {
				
				case 10: sb2.append('A');
				break;
						
				case 11: sb2.append('B');
				break;
				
				case 12: sb2.append('C');
				break;
				
				case 13: sb2.append('D');
				break;
				
				case 14: sb2.append('E');
				break;
				
				case 15: sb2.append('F');
				break;		
				
				}
													
			}
			hexadecimalConversion = sb2.reverse().toString();
		
	}
	
	/*
	 * Method outputs the conversion to hexadecimal to the user and the console.
	 */
	private void outHex() {
		System.out.println("Hexadecimal Conversion: " + hexadecimalConversion);
		pw.println("Hexadecimal Conversion: " + hexadecimalConversion);
		sb2.setLength(0);
		
	}
}
