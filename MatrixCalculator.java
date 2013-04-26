
public class MatrixCalculator {

	
	/**
	 * Adds two Matrices together and returns the sum as a new Matrix.
	 * @param A Matrix
	 * @param B Matrix
	 */
	public Matrix add(Matrix A, Matrix B){
		if( A.getNumRows() != B.getNumRows() || A.getNumCols() != B.getNumCols() ){
			throw new IllegalArgumentException("Matrices differ in size.");
		}
		int n = A.getNumRows();
		int m = A.getNumCols();
		
		double[][] sum  = new double [n][];
		for(int i=0; i < n; i++){
			sum[i] = new double [m];
		}
		
		for(int i=0; i < n; i++){
			for(int j=0; j < m; j++){
				sum[i][j] = A.getElement(i, j) + B.getElement(i, j);
			}
		}
		
		return new Matrix(sum);

	}
	
	/**
	 * Multiplies two Matrices together and returns the sum as a new Matrix.
	 * @param A Matrix
	 * @param B Matrix
	 */
	public Matrix multiply(Matrix A, Matrix B){
		if( A.getNumCols() != B.getNumRows()  ){
			throw new IllegalArgumentException("Number of rows in A is not equal to the number of columns in B.");
		}
		
		
		int n = A.getNumCols();
		int m = A.getNumRows();
		int p = B.getNumCols();
		
		/*double[][] product  = new double [m][];
		for(int i=0; i < m; i++){
			product[i] = new double [p];
		}*/
		double[][] product = new double[m][p];
		
		for(int i=0; i < m; i++){
			for(int j=0; j < p; j++){
				for(int k=0; k < n; k++){
					product[i][j] += A.getElement(i, k) * B.getElement(k, j);			
				}
			}
		}
		
		return new Matrix(product);

	}
	
	
}
