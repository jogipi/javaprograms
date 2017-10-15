
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * This class converts from binary to decimal and from binary to hexadecimal.
 * 
 */
public class Binary {
	
	private PrintWriter pw;
	private String binary;
	private String hex;
	private Scanner s = new Scanner(System.in);
	private StringBuilder hexadecimalConversion = new StringBuilder("00000000");
	private int decimalConversion;
	
	public Binary(PrintWriter p) {
		pw = p;
	}

	/*
	 * Method uses other methods to convert binary to decimal.
	 */
	public void binToDec() {
		inputBin();
		toDec(binary);
		outDec();
	}
	
	/*
	 * Method prompts the user for a binary number then saves 
	 * the string into a private variable.
	 */
	private void inputBin() {
		System.out.println("Please enter a binary number:");
		pw.println("Please enter a binary number:");
		binary = s.nextLine();	
		pw.println (binary);
		binary = binary.replace(",", "");
		binary = binary.replace(" ", "");	
	}
	
	/*
	 * Method converts the string to a decimal.
	 * 
	 * @param b the string input of a binary number.
	 */
	private void toDec(String b) {
				
		int counter = 0;
		int finalSum = 0;
		
		
		for(int i = b.length() - 1; i>=0 ; i--) 
			{
				double sum = 0;
				int a = Character.getNumericValue(b.charAt(i));			
				sum = a* Math.pow(2, counter);
				finalSum += sum;
				counter++;
			}
		
		decimalConversion = finalSum;
		
	}
	
	/*
	 * Method outputs the decimal conversion onto csis.txt as well 
	 * as the command prompt.
	 */
	private void outDec() {
		System.out.println("Decimal Conversion: " + decimalConversion);
		pw.println("Decimal Conversion: " + decimalConversion);
		
	}
	
	/*
	 * Method uses other methods to convert from binary to hexadecimal.
	 */
	public void binToHex() {
		inputBin();
		toHex(binary);
		outHex();
	}
	
	/*
	 * Method converts a binary number represented as a string, into a 
	 * hexadecimal number.
	 * 
	 * @param s a string representation of a binary number
	 */
	private void toHex(String s) {
		int j = 0;
		for(int i=0; i<= s.length()-1; i=i+4){
				if (s.substring(i, i+4).equals("0000"))
					hexadecimalConversion.setCharAt(j, '0');
				else if (s.substring(i, i+4). equals("0001"))
					hexadecimalConversion.setCharAt(j, '1');
				else if (s.substring(i, i+4). equals("0010"))
					hexadecimalConversion.setCharAt(j, '2');
				else if (s.substring(i, i+4). equals("0011"))
					hexadecimalConversion.setCharAt(j, '3');
				else if (s.substring(i, i+4). equals("0100"))
					hexadecimalConversion.setCharAt(j, '4');
				else if (s.substring(i, i+4). equals("0101"))
					hexadecimalConversion.setCharAt(j, '5');
				else if (s.substring(i, i+4). equals("0110"))
					hexadecimalConversion.setCharAt(j, '6');
				else if (s.substring(i, i+4). equals("0111"))
					hexadecimalConversion.setCharAt(j, '7');
				else if (s.substring(i, i+4). equals("1000"))
					hexadecimalConversion.setCharAt(j, '8');
				else if (s.substring(i, i+4). equals("1001"))
					hexadecimalConversion.setCharAt(j, '9');
				else if (s.substring(i, i+4). equals("1010"))
					hexadecimalConversion.setCharAt(j, 'A');
				else if (s.substring(i, i+4). equals("1011"))
					hexadecimalConversion.setCharAt(j, 'B');
				else if (s.substring(i, i+4). equals("1100"))
					hexadecimalConversion.setCharAt(j, 'C');
				else if (s.substring(i, i+4). equals("1101"))
					hexadecimalConversion.setCharAt(j, 'D');
				else if (s.substring(i, i+4). equals("1110"))
					hexadecimalConversion.setCharAt(j, 'E');
				else if (s.substring(i, i+4). equals("1111"))
					hexadecimalConversion.setCharAt(j, 'F');
				j++;
		}
		
		hex = hexadecimalConversion.toString();
		hex = hex.substring(0, j);
		hexadecimalConversion = new StringBuilder("00000000");
	}
		
	
	/*
	 * Method outputs the hexadecimal conversion onto both csis.txt and 
	 * the console.
	 */
	private void outHex() {

		System.out.println("Hexadecimal Conversion: " + hex);
		pw.println("Hexadecimal Conversion: " + hex);
	}
	

}
