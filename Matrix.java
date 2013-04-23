/**
 * This class specifies a nxm matrix, 
 * and some operations that can be performed on matrices. 
 */

public class Matrix{
  
	double[][] matrix;
	int numRows, numCols; 
	
	/**
	 * Creates an empty matrix with 
	 * n rows
	 * and
	 * m columns
	 */
	Matrix(int n, int m){
		numRows = n;
		numCols = m;
		
		matrix = new double [n][];
		for(int i=0; i < n; i++){
			matrix[i] = new double [m];
		}
	}
	
	public double getElement(int n, int m){
		if(n >= 0 && n < numRows && m >= 0 && m < numCols)
			return matrix[n][m];
		
		throw new IndexOutOfBoundsException("n eller m är fel!");
	}
	
	
	public static void main(String[] args){
		Matrix m = new Matrix(4, 4);
		System.out.println(m.getElement(2,2));
	}
}
