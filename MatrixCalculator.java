
public class MatrixCalculator {

	
	/**
	 * Adds two Matrices together and returns the sum as a new Matrix.
	 * @param B Matrix to be added to (this)
	 */
	public Matrix add(Matrix A, Matrix B){
		if( B.getNumRows() != A.getNumRows() || A.getNumCols() != B.getNumCols() ){
			throw new IllegalArgumentException("Matriserna har olika storlek.");
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
}
