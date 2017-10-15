/*
 * This is the objectStack class that creates the stacks used to store data.
 * This is a LIFO structure.
 */
public class ObjectStack implements ObjectStackInterface {
	private Object[] item;
	private int top;
	
	/*
	 * Default Constructor setting the size of the array and the value of the top. 
	 */
	
	public ObjectStack() {
		item = new Object[1];
		top = -1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ObjectStackInterface#isEmpty()
	 */
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() 
	{
		return top == item.length-1;				
	}
	
	public void clear() 
	{
		item = new Object[1];
		top = -1;
	}
	
	public void push(Object o) 
	{
		if (isFull())
			resize(2 + item.length);
		item[++top] = o;
	}
	
	private void resize(int size)
	{
		Object[] temp = new Object[size];
		for (int i = 0; i <= top; i++) 
			temp[i] = item[i];
		item = temp;
	}
	
	public Object pop() 
	{
		if (isEmpty()) 
		{
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		Object temp = item[top];
		item[top--] = null;
		if (top == item.length/4)
			resize(item.length/2);
		return temp;
	}

	public Object top() 
	{
		if (isEmpty()) 
		{
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return item[top];
	}
}
