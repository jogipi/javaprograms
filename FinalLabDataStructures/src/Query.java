/**
 * This is the Query class used for searching within the binary tree
 * for a specific word referenced by the word object.
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Query {
	//query the doc for specific words and display there number of times the word appears in the doc/linenums/position
	Scanner s = new Scanner(System.in);
	private ObjectTreeNode p = new ObjectTreeNode();
	private PrintWriter pw;
	
	/**
	 * Constructor to set the print output.
	 * @param p printwriter object to be the output.
	 */
	public Query(PrintWriter p){
		pw = p;
	}

	/**
	 * Searches the binary tree for a specific word
	 * @param obt object which holds tree.
	 */
	public void searchTree(ObjectBinaryTree obt){
		System.out.println("Enter the word to perform a search (type 'exit search' to leave the search): ");
		pw.println("Enter the word to perform a search (type 'exit search' to leave the search): ");
		String userWord = s.nextLine().toLowerCase();
		while(userWord.compareTo("exit search") != 0){
			p = obt.searchBST(new Word(userWord, 0, 0, pw));
			if(p != null){
				Object o = p.getInfo();
				((Word) o).visit();
			}
			else
			{
				System.out.println("That word does not exit in this file.");
				pw.println("That word does not exit in this file.");
			}
			
			System.out.println("Enter the word to perform a search (type 'exit search' to leave the search): ");
			pw.println("Enter the word to perform a search (type 'exit search' to leave the search): ");
			userWord = s.nextLine().toLowerCase();
		}
	}
}
