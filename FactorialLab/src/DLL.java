
public class DLL {
	private DLLNode list;
	
	public DLL() {
		list = null;
	}
	
    /**
     * Returns the first node in the list
     * @return private object that holds information in the first node.
     */
    public DLLNode getFirstNode() {
        return list;
    }
    
	public Object remove(DLLNode p) {
		if (p == null || list == null) {
			System.out.println("Runtime Error: remove()");
			System.exit(1);
		}
		DLLNode q = p.getBack();
		DLLNode r = p.getNext();
		if (q == null)
			list = r;
		else
			q.setNext(r);
		if(r != null)
			r.setBack(q);
		return p.getInfo();
	}
	
	public void insertLeft(DLLNode p, Object o) {
		DLLNode r;
		
		if (list == null || p == null) {
			System.out.println("Runtime Error: insertLeft()");
			System.exit(1);
		}
		DLLNode q = new DLLNode(o);
		r  = p.getBack();
		if (r != null)
			r.setNext(q);;
		q.setBack(r);
		q.setNext(p);
		p.setBack(q);
		if (list == p)
			list = q;
	}
	
	public void insertRight(DLLNode p, Object o) {
		DLLNode r;
		
		if (list == null || p == null) {
			System.out.println("Runtime Error: insertRight()");
			System.exit(1);
		}
		DLLNode q = new DLLNode(o);
		r = p.getNext();
		if (r != null)
			r.setBack(q);
		q.setNext(r);
		q.setBack(p);
		p.setNext(q);
	}
}
