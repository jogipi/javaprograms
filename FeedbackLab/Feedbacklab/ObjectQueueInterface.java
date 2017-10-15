/*
 * This is the interface for the ObjectQueue class.
 */
interface ObjectQueueInterface {
	/*
	 * These methods check to see whether the stack is Empty, or full. It also has the function
	 * to insert something onto the structure, clear the structure, remove something from the top, or
	 * just look at the firstvalue of the structure without removing it. This is a FIFO structure.
	 */
	
	/*
	 * This method checks to see if the queue is empty.
	 */
	public boolean isEmpty();
	/*
	 * This method checks to see if the queue is full.
	 */
	public boolean isFull();
	/*
	 * This method clears the Queue.
	 */
	public void clear();
	/*
	 * This method removes the first element from this FIFO structure.
	 */
	public Object remove();
	/*
	 * This method returns the first element from the FIFO structure but does not remove it.
	 */
	public Object query();
	/*
	 * This method inserts an object to the queue. This is a FIFO structure so it is at the "end of the line"
	 */
}
