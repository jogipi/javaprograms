import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Division d = new Division();
		int integerOne, integerTwo;
		System.out.println("Enter two integers: ");
		integerOne = s.nextInt(); 
		integerTwo = s.nextInt();
		//System.out.println(integerOne);
		//System.out.println(integerTwo);
		System.out.println(d.Division(integerOne, integerTwo));
	}

}
