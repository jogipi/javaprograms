/*
 * This class is used to convert the infix expression into a postfix expression.
 */

public class InfixToPostfix {
	
	private ObjectStack stack = new ObjectStack();
	private ObjectStack tempStack = new ObjectStack();
	private ObjectStack tempStack2 = new ObjectStack();
	private ObjectStack operator = new ObjectStack();
	private ObjectStack operatorWithinParen = new ObjectStack();
	private ObjectStack operand = new ObjectStack();
	private ObjectStack postfix = new ObjectStack();
	private ObjectStack postfixParen = new ObjectStack();
	private int count = 0;
	private char ch;
	public ObjectStack postfixOut = new ObjectStack();
	
	/*
	 * This is the default constructor. The count is set. 
	 */
	
	public InfixToPostfix() 
	{
		count = 0;
	}
	
	/*
	 * This method take in the input of a string, removes the spaces, then calls the function placeIntoStacks.
	 * @param a The string input by the infix.txt file.
	 */
	
	public void stringInput(String a)
	{
		a = a.replace(" ", "");
			placeIntoStacks(a);
	}
	
	/*
	 * This method places the string input into different stacks in order to
	 *  calculate the algorithm for the postfix expression.
	 * @param s This string is the same line that was sent from the infix.txt file.
	 */
	
	private void placeIntoStacks (String s) 
	{
		
		int holdCharPriority = 0;
				
		for(int i = 0; i < s.length(); i++) 
		{
			ch = s.charAt(i);
			
			if(ch == '(') 
			{
				i++;
				while(!(ch == ')')) 
				{
					ch = s.charAt(i);
					if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') 
					{						
						if(!(operatorWithinParen.isEmpty()))
							holdCharPriority = priority((char)operatorWithinParen.top());
						
						if((!(operatorWithinParen.isEmpty())) && (holdCharPriority >= priority(ch)))
						{
							postfixParen.push((char)operatorWithinParen.pop());
							operatorWithinParen.push(new Character(ch));
						}
						else 
						{
							operatorWithinParen.push(new Character(ch));	
						}
					}
					else if (ch>= '0' && ch <= '9')
						postfix.push(ch);	//new Integer(ch - 48)
				
					i++;
					ch = s.charAt(i);
							
				}
			}
			while(!operatorWithinParen.isEmpty())
				postfix.push(operatorWithinParen.pop());
		
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			{
				
				if(!(operator.isEmpty()))
					holdCharPriority = priority((char)operator.top());
				
				if((!(operator.isEmpty())) && (holdCharPriority >= priority(ch)))
				{
					postfix.push((char)operator.pop());
					operator.push(new Character(ch));
				}
				else
					operator.push(new Character(ch));	
				
			}
			else if (ch>= '0' && ch <= '9')
				postfix.push(ch);	//new Integer(ch - 48)
						
		}
		
		while(!operator.isEmpty())
			postfix.push(operator.pop());
	}
	
	/* 
	 * This method is mainly for the programmers debugging since
	 * we do not use this in our program. We call countstack() here.
	 * @return The integer amount of how large the stack is.
	 */

	public int getCount() 
	{
		int methCount;
		countStack();
		methCount = count;

		return methCount;
	}
	
	/*
	 * This method is mainly for debugging. The programmer can call this function to see the different data structures
	 * within each stack output through the system console.
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
		
		 tempStack = postfix;
			
		System.out.print("\nPostfix Stack: ");
	 
		while(!tempStack.isEmpty())
			tempStack2.push(tempStack.pop());
		while(!tempStack2.isEmpty())
			System.out.print(tempStack2.pop() + " ");
			
		tempStack = operatorWithinParen;
			
		System.out.print("\nInside Parenthesis Stack: ");
		 
		while(!tempStack.isEmpty())
			tempStack2.push(tempStack.pop());
		while(!tempStack2.isEmpty())
			System.out.print(tempStack2.pop() + " ");
			
		tempStack = postfixParen;
		
		System.out.print("\nPostfix Paren Stack: ");
			 
		while(!tempStack.isEmpty())
			tempStack2.push(tempStack.pop());
		while(!tempStack2.isEmpty())
			System.out.print(tempStack2.pop() + " ");
	}
	
	/*
	 * This method takes the stored Object stack postfix and converts it into a String.
	 * @return sb The string of postfix.
	 */
	
	public String getPostString()
	{
		char a;
		StringBuilder sb = new StringBuilder();
		tempStack = postfix;
		 
		while(!tempStack.isEmpty())
			tempStack2.push(tempStack.pop());
		while(!tempStack2.isEmpty())
		{
			a = (char)tempStack2.pop();
			sb.append(a);
		}
		
		return sb.toString();
	}
	
	/*
	 * This method counts the stacks. It then sets the private variable count to the amount.
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
	
	/*
	 * This method checks the precedence of different math symbols.
	 * 
	 * @param op The symbol to be checked.
	 * @return The integer value of the level of precedence. The higher the value the
	 * higher the precedence.
	 */
	
	private int priority(char op) 
	{
		switch (op) 
		{
		case '^': return 3;
		case '*': 
		case '/': return 2;
		case '+':
		case '-': return 1;
		default : return 0;
		}
	}
}
