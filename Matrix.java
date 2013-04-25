/**
 * This class specifies a nxm matrix, 
 * and some operations that can be performed on matrices. 
 */

public class Matrix{
	
	double[][] matrix;
	int numRows, numCols; 
	
	/**
	 * Creates a new empty matrix.
	 * @param n rows in matrix
	 * @param m columns in matrix
	 */
	Matrix(int n, int m){
		numRows = n;
		numCols = m;
		
		matrix = new double [n][];
		for(int i=0; i < n; i++){
			matrix[i] = new double [m];
		}
	}
	
	/**
	 * Creates a new matrix containing elements in the array elements.
	 * @param n rows in matrix
	 * @param m columns in matrix
	 * @param elements array containing the elements of the matrix
	 */
	Matrix(double[][] elements){
		matrix = elements;
		numRows = elements.length;
		numCols = elements[0].length;
		
	}
	
	/**
	 * Returns an element at position [x,y].
	 * Throws IndexOutOfBoundsException if n or m is too large/small.
	 */
	public double getElement(int x, int y){
		if(x >= 0 && x < numRows && y >= 0 && y < numCols)
			return matrix[x][y];
		
		throw new IndexOutOfBoundsException("x eller y är fel!");
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
	
	

}
