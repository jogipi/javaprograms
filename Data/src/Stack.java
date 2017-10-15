/*
 * This Program creates two stacks within the same array. The first stacks begins at the beginning of the array
 * and grows towards the middle of the array while the second stack starts at the end of the array and
 *  grows towards the center. The methods within this class are the primitive stack operations push, pop, clear, isEmpty
 * and isFull, for the two different stacks the are separate methods.
 */
public class Stack {
	private int[] item;
	private int top1;
	private int top2;
	private int size;
	
	public Stack (int max) {
		size = max;
		item = new int[size];
		top1 = -1;
		top2 = size;
	}
	
	public void push1(int x){
		if(isFull1()) {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
		item[++top1] = x;
	}
	
	public void push2(int x) {
		if(isFull2()) {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
		item[--top2] = x;
	}

	public int pop1() {
		if(isEmpty1()) {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return item[top1--];
		
	}
	
	public int pop2() {
		if(isEmpty2()) {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return item[top2++];
		
	}
	
	public void clear1() {
		top1 = -1;		
	}
	
	public void clear2() {
		top2 = size;
	}
	
	public boolean isEmpty1() {
		return top1 == -1;
	}
	
	public boolean isEmpty2() {
		return top2 == size;
	}
	
	private boolean isFull1() {
		return top1 == ( (item.length - 1) / 2);
	}	
	
	private boolean isFull2() {
		
		return top2 == ( ((item.length - 1) / 2) + 1);
	}
}
