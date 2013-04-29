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
	public void setElement(int n, int m, double a){
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
	 * Swaps the rows a and b in the Matrix.
	 */
	public void swapRows(int a, int b){
		if(a < 0 || a > numRows || b < 0 || b > numRows)
			throw new IllegalArgumentException("The rows you're trying to swap do not exist in Matrix.");
		
		double temp;
		for(int i = 0; i < numCols; i++){
			temp = elements[a][i];
			elements[a][i] = elements[b][i];
			elements[b][i] = temp;
		}
		
	}
	
	/**
	 * Multiplies each element in row by scalar.
	 */
	public void scalarMultiplicationRow(double scalar, int row){
		if(row < 0 || row > numRows)
			throw new IllegalArgumentException("Row is not in matrix.");
		
		for(int i = 0; i < numCols; i++){
			elements[row][i] *= scalar;
		}
	}
	
	
	/**
	 * Multiplies row by scalar, and adds the product to targetRow.
	 */
	public void addRowMultipliedByScalar(double scalar, int targetRow, int addendRow){
		if(targetRow < 0 || targetRow > numRows || addendRow < 0 || addendRow > numRows)
			throw new IllegalArgumentException("Row is not in matrix.");
		
		for(int i = 0; i < numCols; i++){
			elements[targetRow][i] += scalar * elements[addendRow][i];
		}
		
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
				if(elements[i][j] % 1.0 != 0){
					sb.append(elements[i][j]);
				}else{
					sb.append((int)elements[i][j]);
				}
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
		}
		
		sb.append("]");
		
		s=sb.toString();
		return s;
	}

}
