
public class Division {

	private int first;
	private int second;
	
	public void Division () {
		first = 0;
		second = 0;
	}
	
	public int Division (int a, int b) {
		
			if( b == 0 )
		    {
				System.out.println("Does not exist. You cannot divide by zero.");
		        return 0;
		    }
		    else if( a < b)
		    {
		        return 0;
		    }
		    else
		    { 
				
		        return( 1 + Division(a-b, b) );
		   }
	}
	
	public int exponentiate(int a, int b) {
		
		if(b == 0) {
			return 1;
		}
		else if (b>0) {
			return (a*exponentiate(a,(b-1)));
		}
		else
		return 0;
	}
	
	public int foo(int n) {
		if(n==1)
			return 0;
		else
			return 1 + foo(n/2);
	}
}
