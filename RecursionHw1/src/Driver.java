import java.io.IOException;


public class Driver {

	public static void main(String[] args) throws java.io.IOException {
		
		System.out.println("Enter String: ");
		foo();
	}

	public static void foo() throws IOException {
		char c = (char) System.in.read();
	
		if(c != '.'){
			foo();
			System.out.print(c);
		}
		
	}

}
