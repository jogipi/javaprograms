

import java.io.PrintWriter;
import java.util.Scanner;
/*
 * This class generally converts from Hexadecimal to decimal and Hexadecimal to Binary
 */
public class Hexadecimal {
	
	private PrintWriter pw;
	private String hexadecimal;
	private String hexadecimalConverted;
	private Scanner s = new Scanner(System.in);
	private int finalSum = 0;
	private StringBuilder sb = new StringBuilder();
	
	
	public Hexadecimal(PrintWriter p) {
		pw = p;
	}
	
	/*
	 * Method converts hexadecimal to decimal using the other methods.
	 */
	public void hexToDec() {
		inputHex();
		toDec();
		outDec();				
	}
	
	/*
	 * Method prompts the user for an input of a hexadecimal number
	 */
	private void inputHex() {
		System.out.println("Please enter a Hexadecimal number:");
		pw.println("Please enter a Hexadecimal number:");
		hexadecimal = s.nextLine();
		pw.println(hexadecimal);
		hexadecimal = hexadecimal.replace(",", "");
		hexadecimal = hexadecimal.replace(" ", "");
	}
	
	/*
	 * Method converts the hexadecimal into a decimal number using the private
	 * variable.
	 */
	private void toDec() {
		int counter = 0;
		finalSum = 0;
		int b = 0; 
		
		for(int i = hexadecimal.length()-1; i>=0 ; i--) 
			{
				double sum = 0;
				
				b = Character.getNumericValue(hexadecimal.charAt(i));
				
					if(hexadecimal.charAt(i) == 'A')
						b = 10;
					if(hexadecimal.charAt(i) == 'B')
						b = 11;
					if(hexadecimal.charAt(i) == 'C')
						b = 12;
					if(hexadecimal.charAt(i) == 'D')
						b = 13;
					if(hexadecimal.charAt(i) == 'E')
						b = 14;
					if(hexadecimal.charAt(i) == 'F')
						b = 15;
				
				sum = b * Math.pow(16, counter);
				finalSum += sum;
				counter++;
			}
		
		
	}
	
	/*
	 * Outputs the decimal conversion to the csis.txt as well as the command line.
	 */
	
	private void outDec() {
		System.out.println("Decimal Conversion: " + finalSum);
		pw.println("Decimal Conversion: " + finalSum);
	}
	
	/*
	 * Method uses the other methods to convert from hexadecimal to binary.
	 */
	
	public void hexToBin() {
		inputHex();
		toBin();
		outBin();
	}
	
	/*
	 * Method converts the hexadecimal private variable into a binary string.
	 */
	
	private void toBin() {
		for(int i = 0; i<= hexadecimal.length() - 1; i++){
			if(hexadecimal.charAt(i) == '0')
				sb.append("0000");
			if(hexadecimal.charAt(i) == '1')
				sb.append("0001");
			if(hexadecimal.charAt(i) == '2')
				sb.append("0010");
			if(hexadecimal.charAt(i) == '3')
				sb.append("0011");
			if(hexadecimal.charAt(i) == '4')
				sb.append("0100");
			if(hexadecimal.charAt(i) == '5')
				sb.append("0101");
			if(hexadecimal.charAt(i) == '6')
				sb.append("0110");
			if(hexadecimal.charAt(i) == '7')
				sb.append("0111");
			if(hexadecimal.charAt(i) == '8')
				sb.append("1000");
			if(hexadecimal.charAt(i) == '9')
				sb.append("1001");
			if(hexadecimal.charAt(i) == 'A')
				sb.append("1010");
			if(hexadecimal.charAt(i) == 'B')
				sb.append("1011");
			if(hexadecimal.charAt(i) == 'C')
				sb.append("1100");
			if(hexadecimal.charAt(i) == 'D')
				sb.append("1101");
			if(hexadecimal.charAt(i) == 'E')
				sb.append("1110");
			if(hexadecimal.charAt(i) == 'F')
				sb.append("1111");
				
		}
		hexadecimalConverted = sb.toString();
		
	}
	
	/*
	 * Method outputs the Binary string onto the csis.txt document as well as
	 * the console.
	 */
	private void outBin() {
		System.out.println("Hexadecimal Conversion: " + hexadecimalConverted);
		pw.println("Hexadecimal Conversion: " + hexadecimalConverted);
		
	}

}
