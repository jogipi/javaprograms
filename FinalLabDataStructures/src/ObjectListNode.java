/**
 * Class that holds the nodes which points to objects within the list.
 * @author Richard Stegman
 */

public class ObjectListNode {
    private Object info;
    private ObjectListNode next;
    
    /**
     * Default constructor sets private variables to null.
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * Assigns object to object list. 
     * @param o object to set info field to.
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    /**
     *  Assigns object to the object 'list'. Also assigns a pointer to the 'next' variable.
     *  @param o object to be set in info field
     *  @param p node pointing to object to be set in next field.
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     *  Sets info field
     *  @param o object to be set in info.
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns object in the info field
     * @return object within info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     *  Sets next field
     *  @param p node that points to next value in list.
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     *  Returns object in info field
     *  @return node that points to the next object in the list.
     */
    public ObjectListNode getNext() {
        return next;
    }
}
