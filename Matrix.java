/**
 * This class specifies a nxm matrix, 
 * and some operations that can be performed on matrices. 
 */

public class Matrix{
	
	double[][] elements;
	int numRows, numCols; 
	
	/**
	 * Creates a new empty matrix.
	 * @param n rows in matrix
	 * @param m columns in matrix
	 */
	Matrix(int n, int m){
		numRows = n;
		numCols = m;
		
		elements = new double [n][m];
		
	}
	
	/**
	 * Creates a new matrix containing elements in the array elements.
	 * @param n rows in matrix
	 * @param m columns in matrix
	 * @param elements array containing the elements of the matrix
	 */
	Matrix(double[][] matrix){
		elements = matrix;
		numRows = matrix.length;
		numCols = matrix[0].length;
		
	}
	
	/**
	 * Returns an element at position [x,y].
	 * Throws IndexOutOfBoundsException if n or m is too large/small.
	 */
	public double getElement(int x, int y){
		if(x >= 0 && x < numRows && y >= 0 && y < numCols)
			return elements[x][y];
		
		throw new IndexOutOfBoundsException("x eller y är fel!");
	}
	
	/**
	 * Test method.
	 * Used internally to simplify testing.
	 * Adds element to index [n,m].
	 */
	public void addElement(int n, int m, double a){
		elements[n][m] = a;
	}


	/**
	 * Returns the number of rows in Matrix.
	 * @return number of rows in Matrix.
	 */
	public int getNumRows(){
		return numRows;
	}
	
	/**
	 * Returns the number of columns in Matrix.
	 * @return number of columns in Matrix.
	 */
	public int getNumCols(){
		return numCols;
	}
	
	
	/**
	 * Returns a string representation of the Matrix. 
	 */
	public String toString(){
		String s ="";
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for(int i=0; i < numRows; i++){
			sb.append("[");
			for(int j=0; j < numCols; j++){
				sb.append(elements[i][j]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
		}
		
		sb.append("]");
		
		s=sb.toString();
		System.out.println(s);
		return s;
	}

}
