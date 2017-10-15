/*
 * This class evaluated the postfix expression sent.
 */

public class EvalPostfix 
{
	private InfixToPostfix infixConvert = new InfixToPostfix();
	private ObjectStack stack = new ObjectStack();
	private ObjectStack tempStack = new ObjectStack();
	private ObjectStack tempStack2 = new ObjectStack();
	private ObjectStack operand = new ObjectStack();
	private ObjectStack operator = new ObjectStack();
	private int count = 0;
	private char ch;
	private int result;
	
	/*
	 * Default constructor sets the count to zero;
	 */
	
	public EvalPostfix() 
	{
		count = 0;
	}
	
	/*
	 * This method takes in the input of a string. In our project we use it to take the input
	 * of a the postfix expression. The method also calls the Infix class' input String and converts 
	 * the postfix stucture into a string. 
	 * @param a The string that is to be converted into the postfix expression.
	 */
	
	public void stringInput(String a)
	{
		infixConvert.stringInput(a);
		placeIntoStacks(infixConvert.getPostString());
	}
	
	/*
	 * This method is used to find and set the result of the postfix expresion in string form;
	 */
	
	private void placeIntoStacks(String s) 
	{
		for(int i = 0; i < s.length(); i++)
			stack.push(s.charAt(i));
		
		for(int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if (ch>= '0' && ch <= '9')
				operand.push(new Integer(ch - 48));
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			{
				operator.push(new Character(ch));
				int val2 = (Integer)operand.pop();
				int val1 = (Integer)operand.pop();
				char op = (char)operator.pop();
				
				if(op == '+')
				{
					operand.push(new Integer(val1 + val2));
				}
				if(op == '-')
				{
					operand.push(new Integer(val1 - val2));
				}
				if(op == '*')
				{
					operand.push(new Integer(val1 * val2));
				}
				if(op == '/')
				{
					operand.push(new Integer(val1 / val2));
				}
				if(op == '^')
				{
					operand.push((val1)^(val2));
				}
			}
		}
	
		result = (int)operand.pop();
	}
	
	/*
	 * This method gets the count from the data structure.
	 * @return methCount is set from the private variable counter.
	 */
	
	public int getCount() 
	{	
		int methCount;
		countStack();
		methCount = count;
		
		return methCount;
	}
	
	/*
	 * This method gets the result of the postfix expression.
	 * @return result Integer value of the evaluated postfix equation.
	 */
	
	public int getResult()
	{
		int result = this.result;
		
		return result;
	}
	
	/*
	 * This is a method that outputs the stacks amongst the stacks used in this class
	 * It is used by the programmer for debugging purposes.
	 */
	
	public void outputStacks()
	{
	    tempStack = stack;
				
	    System.out.print("Original Stack: ");
			
    		while(!tempStack.isEmpty())
				tempStack2.push(tempStack.pop());
			while(!tempStack2.isEmpty())
				System.out.print(tempStack2.pop() + " ");
		
	    tempStack = operator;
			
	    System.out.print("\nOperator Stack: ");
	    
			while(!tempStack.isEmpty())
				tempStack2.push(tempStack.pop());
			while(!tempStack2.isEmpty())
				System.out.print(tempStack2.pop() + " ");
			
		 tempStack = operand;
			
		System.out.print("\nOperand Stack: ");
		
			while(!tempStack.isEmpty())
				tempStack2.push(tempStack.pop());
			while(!tempStack2.isEmpty())
				System.out.print(tempStack2.pop() + " ");
						
		System.out.print("\nResult: " + result);
	}
	
	/*
	 * This method counts the stack and sets count to the number of items in the data structure.
	 */
	
	private void countStack()
	{	
		int counter = 0;
		
		while(!stack.isEmpty())
		{
			tempStack.push(stack.pop()); //might need to cast to char  here
			counter++;	
		}
				
		while(!tempStack.isEmpty())
			stack.push(tempStack.pop());
		
		count = counter;
	}
	
}
