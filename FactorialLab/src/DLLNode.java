
public class DLLNode {
	private Object info;
	private DLLNode next;
	private DLLNode back;
	
	//Constructs empty node
	public DLLNode() {
		info = null;
		next = null;
		back = null;
	}
	
	public DLLNode(Object o){
		info = o;
		next = null;
		back = null;
	}
	
	public DLLNode(Object o, DLLNode p, DLLNode q){
		info = o;
		next = p;
		back = q;
	}
	
	public void setInfo(Object o){
		info = o;
	}
	
	public Object getInfo() {
		return info;
	}
	
	public void setNext(DLLNode p) {
		next = p;
	}
	
	public DLLNode getNext() {
		return next;
	}
	
	public void setBack(DLLNode p) {
		back = p;
	}
	
	public DLLNode getBack(){
		return back;
	}
}
