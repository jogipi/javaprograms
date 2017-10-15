/*
 * This is the interface for the ObjectStack class.
 */
interface ObjectStackInterface 
{
	/*
	 * These methods check to see whether the stack is Empty, or full. It also has the function
	 * to push something onto the structure, clear the structure, pop something from the top, or
	 * just look at the top value of the structure without removing it.
	 */
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	public void push(Object symbol);
	public Object pop();
	public Object top();
}
