/**
 * @author Jorge Sanchez
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Hash {

	private static final int MAX_OMITTED_WORDS = 36;
	private String hashTable[] = new String[MAX_OMITTED_WORDS];
	private PrintWriter pw;
	private int collision = 0;
	/**
	 * Constructor to set the printer output.
	 * @param p printwriter object which holds the output file.
	 */
	public Hash(PrintWriter p){
		pw = p;
	}
	
	/**
	 * Function to output table thats been hashed
	 * @param f object Scanner file which holds the txt document.
	 */
	public void createTable(Scanner f) {
		while (f.hasNextLine())
		{
			String buf = f.nextLine();
			String delims = "[ ,.;-]+";
			String[] tokens = buf.split(delims);
			for (int i = 0; i < tokens.length; i++)
			{
				String word = tokens[i].toLowerCase();
				int hashIndex = hash(word);
				while (hashTable[hashIndex] != null)
				{	
					hashIndex++;
					collision++;
					if (hashIndex == MAX_OMITTED_WORDS){
						hashIndex = 0;
					}
				}
				if (hashTable[hashIndex] == null)
					hashTable[hashIndex] = word;
			}
		}
                for (int i = 0; i < hashTable.length; i++)
                    if (hashTable[i] == null)
                        hashTable[i] = "";
                
	}
	
	/**
	 * Outputs the the display of the hash table.
	 */
	public void displayTable(){
		System.out.println("Current Ommitted Words Hash-Table in memory\n");
		pw.println("Current Ommitted Words Hash-Table in memory\r\n");
		
		for (int i = 0; i < hashTable.length; i++)
		{
			System.out.println("\t--------------");
			pw.println("\r\t--------------");
			System.out.print(i + "\t");
			pw.print(i + "\r\t");
			System.out.format("| %-10s |\n", hashTable[i]);
			pw.format("| %-10s |\r\n", hashTable[i]);


		}
		System.out.println("\t--------------\n");
	}
	
	/**
	 * Outputs descriptions of the hash table.
	 */
	public void hashTableInfo(){
		System.out.println("\nHash Table Description\n----------------------\n"
				+ "The hash table is set to have minimal collisions. The hash function\n"
				+ "is created by summing the integer ASCII values of each character\n"
				+ "in the specific word to be ommitted. We then use that sum, add and\n"
				+ "multiply certain numbers then mod the value and the size of the amount\n"
				+ "of words ommitted. This leads to the number that we have as the specific\n"
				+ "index key for the hash table in memory. If a word has then same\n"
				+ "index as another, we simply move to the next spot in memory\n"
				+ "until it is empty. If we reach the end of the table we use the\n"
				+ "wrap-around method. This specific hash table has 7 collisions.\n ");
		
		pw.println("\r\nHash Table Description\r\n----------------------\r\n"
				+ "The hash table is set to have minimal collisions. The hash function\r\n"
				+ "is created by summing the integer ASCII values of each character\r\n"
				+ "in the specific word to be ommitted. We then use that sum, add and\r\n"
				+ "multiply certain numbers then mod the value and the size of the amount\r\n"
				+ "of words ommitted. This leads to the number that we have as the specific\r\n"
				+ "index key for the hash table in memory. If a word has then same\r\n"
				+ "index as another, we simply move to the next spot in memory\r\n"
				+ "until it is empty. If we reach the end of the table we use the\r\n"
				+ "wrap-around method. This specific hash table has 7 collisions.\r\n ");
	}
	
	/**
	 * Returns a copy of the array created in the hash program.
	 * @return hashTableCopy the array of the hashed items.
	 */
	public String[] getArray(){
		String hashTableCopy[] = new String[MAX_OMITTED_WORDS];
		for (int i = 0; i < hashTable.length; i++)
			hashTableCopy[i] = hashTable[i];
		return hashTableCopy;
	}
	
	/**
	 * Boolean to check if the ommitted word was found.
	 * @param s String word to be checked if within the hash table. 
	 * @return boolean that suggests whether or not the word was found in the table.
	 */
	public boolean foundOmmittedWord(String s){
		for (int i = 0; i < s.length(); i++)
		{
			if(s.compareTo(hashTable[i]) == 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Function for programmer to find the collisions within the hash table.
	 * @return amount of collisions
	 */
	public int getCollision() {
		int colide;
		colide = collision;
		return colide;
	}
	/**
	 * Function to determine random hash key.
	 * @param s
	 * @return integer that is to represent the hash key
	 */
	private int hash(String s) {
		final int TABLESIZE = 36;
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++)
			sum += (int)s.charAt(i) + 64 + i*i;
		sum %= 41;
		sum %= 64;
		
		return sum % TABLESIZE;
	}
	
	
}
