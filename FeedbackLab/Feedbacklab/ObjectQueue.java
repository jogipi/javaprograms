/*
 * This class is used to create a Queue of objects.
 */

public class ObjectQueue implements ObjectQueueInterface {
	private Object[] item;
	private int front;
	private int rear;
	private int count;

	/*
	 * This is the default constructor, an empty queue
	 */
	
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /*
	 * This method checks to see if the queue is empty.
	 */
    
    public boolean isEmpty() {
        return count == 0;
    }
	/*
	 * This method checks to see if the queue is full.
	 */
    
    public boolean isFull() {
        return count == item.length;
    }
    
	/*
	 * This method removes the first element from this FIFO structure.
	 */
    
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
     /*
      * This method inserts an object into the rear of the queue.
      */
    
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }
	/*
	 * This method removes the first element from this FIFO structure.
	 */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }
    /*
	 * This method returns the first element from the FIFO structure but does not remove it.
	 */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }
	/*
	 * This method is used by the class to resize the queue whenever the limit is reached.
	 */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}