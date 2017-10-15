/** define a 2D array of chars as a way to make ascii art.
 * can place and clear an arbitrary 2D array of chars in the grid
 * if asked-for array fits.
 * @author Jorge Sanchez
 * @version CSE11 Spring 2015
 */
public class AsciiGrid
{	
	private char[][] grid;
	private static final char NEWLINE = '\n';
	private static final char EMPTY = ' ';
	
	/** Constructor 
	 */
	public AsciiGrid()
	{	
		grid = new char[25][40];
		
	
		for(int i = 1; i < 25; i++)
		{
			grid[0][0] = '=';
			for(int j = 1; j < 40; j++) 
			{
				grid[0][j] = '=';
				grid[i][0] = '|'; 
				grid[i][j] = EMPTY;
				grid[i][39] = '|';
				grid[24][j] = '=';
			}
			grid[24][0] = '=';
	
		}
	}
		
		
	
	/** Constructor 
	 * @param row number of rows in the ascii grid 
	 * @param col number of columns in the ascii grid 
	 */
	public  AsciiGrid(int row, int col)
	{	
		
		grid = new char[row][col];
		
	
		for(int i = 1; i < row; i++)
		{
			for(int j = 1; j < col; j++) 
			grid[0][0] = '=';
			for(int j = 1; j < col; j++) 
			{
				grid[0][j] = '=';
				grid[i][0] = '|'; 
				grid[i][j] = EMPTY;
				grid[i][col-1] = '|';
				grid[row-1][j] = '=';
			}
			grid[row-1][0] = '=';
	
		}
		
		
			
	
	}
	/** return a row x col array of the current char array  
	 * This should be a full/deep copy, not a reference to internal
	 * storage
	 * @return array of chars 
	 */
	public char [][] getChars()
	{
		char [][] rarray = new char[grid.length][];
		for (int i = 0; i < grid.length; i++)
		{
			rarray[i] = new char[grid[i].length];
			for(int j = 0; j < grid[i].length; j++)
				rarray[i][j] = grid[i][j];
		}
		return rarray;
	}


	/** 
	 * place the 2D shape in the grid at location (r,c) 
	 * only if every row of the shape fits in the grid and
	 * doesn't intersect any non-empty spaces. Otherwise don't
	 * place the shape
	 * @param shape 2D array of chars to put on the Grid
	 * @param r row in the grid where to place the first row of the shape
	 * @param c column in the grid where to place the first column of the shape
	 * @return true, if successful false otherwise
	 */
	public boolean placeShape(char [][] shape,int r, int c)
	{
		int[] size = getSize();
		int i = 0;
		int j = 0;
		
			for(i = r; i > shape.length; i++)
			{
				if( size[0] > shape.length && size[1] > shape[i].length) {
				for(j = c; j > shape[i].length; j++)
					grid[i][j] = shape[i][j];
				return true;
				}
			}
	
		return false;
	}

	/** 
	 * clear the elements in the grid  defined by the 2D shape 
	 * starting at grid at location (r,c). The contents of the 
	 * shape are irrelevant only the dimensions of each row are used.
	 * Clear only if every row of the shape fits in the grid. 
	 * Cleared elements in the grid are set to the EMPTY char.
	 *
	 * @param shape 2D array of chars. Defines the shape to  
	 * @param r row in the grid where to start the clearing 
	 * @param c column in the grid where to start the clearing 
	 * @return true, if successful false otherwise
	 */
	public boolean clearShape(char [][] shape,int r, int c)
	{
		int[] size = getSize();
		int i = 0;
		int j = 0;
		
			for (i = r; i < shape.length + r; i ++)
			{
				if( (shape.length < size[0]) && shape[i - r].length < size[1] ) 
				{
					for (j = c; j < size[1] + c; j++ )
					{
					grid[i][j] = EMPTY;		
					return true;
					}
				}
			
			}
		return false;
	}
	
	/** Return the width and height of the grid 
	 *  @return array where index=0 is nrows, index=1 nrows 
	 */
	public int [] getSize()
	{
		
		int count = 0;
		int rows = grid.length;
		for (int i = 0; i < grid[i].length; i ++)
		    {			
		    count++;
		    }
		int[] sizeArray = {rows, count};
		
		return (sizeArray); 
	}

	/** create a nice, printable representation of the grid and
	 * filled coordinates
	 *
	 * the grid should be framed. A row of "=' (length = width of grid + 2)
	 * should be used to frame the top and bottom of the grid. The '|' should
	 * be used to frame the left and right side of each row of the grid. e.g 
	 * 1x1  empty grid      2 x 2 empty grid
	 * ===                  ====
	 * | |                  |  |
	 * ===                  |  |
	 *                      ====
	 */
	@Override
	public String toString()
	{
		
		String output = "";
		int i;
		for (i = 0; i < grid.length; i++)
			output += new String(grid[i]) + NEWLINE;
		return output;
	}
	

}
// vim: ts=4:sw=4:tw=78