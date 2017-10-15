import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DLLNode p = new DLLNode();
		DLL multiplicand = new DLL();
		int multiplier = 1;
		int dataWithin;
		int userInput;
		
	
		System.out.println("Please Enter a number to be factorialized: ");
		userInput = s.nextInt();
		p = multiplicand.getFirstNode();
		p.setInfo(1);
		
		while(multiplier != userInput )
		{
			
			while(multiplier != 0)
			{
				dataWithin = (int)p.getInfo() * multiplier;
				p.setInfo(dataWithin%1000);
				
			}
			
			multiplier += 1;
		}

	}

}
