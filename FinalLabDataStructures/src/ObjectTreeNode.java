/**
 * @author Richard Stegman
 * This class creates a node for the Object Binary List.
 */

public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * Default constructor for class setting all fields to null.
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    /**
     * This constructor sets the info field for the specific node being point to.
     * Sets both the left and right fields to null.
     * @param o object to be stored into the info field
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    /**
     * Function to set the info of a node.
     * @param o object to be store into the info field
     */
    public void setInfo(Object o) {
        info = o;
    }
    /**
     * retrieves the information within the node.
     * @return info field carrying the object 
     */
    public Object getInfo() {
        return info;
    }
    /**
     * sets the left field of the node in the binary tree to the specific object node in the parameter.
     * @param p node pointer to the specific object that is to be set in the field left.
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    /**
     * retrieval of the object in the left field of the node class.
     * @return object set in left field
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    /**
     * sets the right field of the node in the binary tree to the specific object node in the parameter.
     * @param p node pointer to the specific object that is to be set in the field right.
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    /**
     * retrieval of the object in the right field of the node class.
     * @return object set in the right field
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}
