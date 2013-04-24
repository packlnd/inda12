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
	 * Returns an element at position [n,m].
	 * Throws IndexOutOfBoundsException if n or m is too large/small.
	 */
	public double getElement(int n, int m){
		if(n >= 0 && n < numRows && m >= 0 && m < numCols)
			return matrix[n][m];
		
		throw new IndexOutOfBoundsException("n eller m är fel!");
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
	 * Adds two Matrices together and returns the sum as a new Matrix.
	 * @param B Matrix to be added to (this)
	 */
	public Matrix addMatrix(Matrix B){
		if( B.getNumRows() != numRows || B.getNumCols() != numCols ){
			throw new IllegalArgumentException("Matriserna har olika storlek.");
		}
		int n = numRows;
		int m = numCols;
		
		double[][] sum  = new double [n][];
		for(int i=0; i < n; i++){
			sum[i] = new double [m];
		}
		
		for(int i=0; i < n; i++){
			for(int j=0; j < m; j++){
				sum[i][j] = B.getElement(i, j) + (this).getElement(i, j);
			}
		}
		
		return new Matrix(sum);

	}
	
	
	public static void main(String[] args){
		Matrix m = new Matrix(4, 4);
		System.out.println(m.getElement(2,2));
	}
}
