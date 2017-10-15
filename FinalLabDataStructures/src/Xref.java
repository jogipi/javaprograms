/**
 * This class holds the main functions of the program. setting the binary tree, controlling the 
 * search function, as well as comparing the words to the hash table.
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Xref {
	// build index which displays the number of times each word appears along with linenums and position
	private ObjectBinaryTree obt = new ObjectBinaryTree();
	private ObjectBinaryTree obtRestricted = new ObjectBinaryTree();
	private PrintWriter pw;
	private boolean restricted = false;


	/**
	 * Default constructor to set the printer output.
	 * @param p object holding printer output.
	 */
	public Xref(PrintWriter p) {
		pw = p;
	}
	
	/**
	 * Sets the binary tree.
	 * @param f holds the words to be input
	 */
	public void setTree(Scanner f){
		int lineNumber = 0;
		int linePlacement = 0;
		restricted = false;
		while(f.hasNextLine())
		{
			String buf = f.nextLine();
			String delims = "[ ,.;-]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length; i++)
			{
				String word = tokens[i].toLowerCase();
				linePlacement = i;
				obt.insertBSTDup(new Word(word, lineNumber+1, linePlacement+1, pw));
			}
			lineNumber++;
		}	
		
	}
	
	/**
	 * Displays the table in the binary tree.
	 */
	public void display(){
		ObjectTreeNode p = new ObjectTreeNode();
		System.out.println("Cross-Referenced Listing Table");
		pw.println("Cross-Referenced Listing Table");
		System.out.println("------------------------------");
		pw.println("------------------------------");
		if (!restricted)
		{
			p = obt.getRoot();
			obt.inTrav(p);
		}
		else
		{
			p = obtRestricted.getRoot();
			obt.inTrav(p);
		}
	}
	
	public void userSearch(PrintWriter p){
		Query q = new Query(p);
		if (!restricted)
			q.searchTree(obt);
		else
			q.searchTree(obtRestricted);
	}
	
	/**
	 * Sets the binary tree to hold the words without the omitted words
	 * @param f object holding the output file
	 * @param s array which holds words within each line in text
	 */
	public void setRestrictedTree(Scanner f, String[] s){
		int lineNumber = 0;
		int linePlacement = 0;
		restricted = true;
		while(f.hasNextLine())
		{
			String buf = f.nextLine();
			String delims = "[ ,.;-]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length; i++)
			{
				String word = tokens[i].toLowerCase();
				linePlacement = i;
				if (!(restrictedWord(word, s)))
					obtRestricted.insertBSTDup(new Word(word, lineNumber+1, linePlacement+1,pw));
			}
			lineNumber++;
		}
	}
	
	/**
	 * function to determine if word is restricted or not.
	 * @param s specific word to be compared
	 * @param hashTable array holding omitted words
	 * @return boolean to determine if word is a restricted word
	 */
	private boolean restrictedWord(String s, String[] hashTable) {
		for(int i = 0; i < hashTable.length; i++)
		{
			if(s.compareTo(hashTable[i]) == 0)
				return true;
		}
		return false;
		
	}
	
	
}